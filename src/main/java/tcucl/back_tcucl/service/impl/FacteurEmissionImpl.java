package tcucl.back_tcucl.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tcucl.back_tcucl.entity.FacteurEmission;
import tcucl.back_tcucl.repository.FacteurEmissionRepository;
import tcucl.back_tcucl.service.FacteurEmissionService;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.poi.ss.util.CellReference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FacteurEmissionImpl implements FacteurEmissionService {

    private final FacteurEmissionRepository repository;

    public FacteurEmissionImpl(FacteurEmissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public String importFromExcel(MultipartFile file) {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            repository.deleteAll();

            for (int i = 3; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                try {
                    String categorie = getCellValue(row.getCell(0));
                    String type = getCellValue(row.getCell(1));
                    Double facteur = parseDoubleSafe(row.getCell(2), sheet);                    String unite = getCellValue(row.getCell(3));
                    // Si tu as une colonne pourcentage en cellule 4 :
                    // Double pourcentage = parsePourcentage(row.getCell(4));

                    if (categorie == null || type == null ) {
                        System.out.printf("Ligne %d ignorée : données manquantes.%n", i + 1);
                        continue;
                    }

                    FacteurEmission fe = new FacteurEmission();
                    fe.setCategorie(categorie);
                    fe.setType(type);
                    fe.setFacteurEmission(facteur);
                    fe.setUnite(unite);
                    // fe.setPourcentage(pourcentage); // si applicable

                    repository.save(fe);

                } catch (Exception e) {
                    System.err.printf("Erreur à la ligne %d : %s%n", i + 1, e.getMessage());
                }
            }

            return "Importation réussie.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur : " + e.getMessage();
        }
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return null;

        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            case BLANK -> null;
            default -> null;
        };
    }

    private Double parseDoubleSafe(Cell cell, Sheet sheet) {
        try {
            if (cell == null) return 0.0;

            if (cell.getCellType() == CellType.NUMERIC) {
                return cell.getNumericCellValue();
            }

            String formula = getCellValue(cell);
            if (formula == null || formula.isBlank()) return 0.0;

            formula = formula.replace(",", ".");

            // Recherche toutes les références de cellules (ex: C4, B12...)
            Pattern cellRefPattern = Pattern.compile("\\b([A-Z]+[0-9]+)\\b");
            Matcher matcher = cellRefPattern.matcher(formula);
            while (matcher.find()) {
                String ref = matcher.group(1);
                CellReference cellRef = new CellReference(ref);
                Row refRow = sheet.getRow(cellRef.getRow());
                if (refRow != null) {
                    Cell refCell = refRow.getCell(cellRef.getCol());
                    double value = parseDoubleSafe(refCell, sheet);
                    formula = formula.replace(ref, String.valueOf(value));
                } else {
                    formula = formula.replace(ref, "0");
                }
            }

            // Évalue l'expression mathématique
            Expression exp = new ExpressionBuilder(formula).build();
            return exp.evaluate();

        } catch (Exception e) {
            System.err.println("Erreur de conversion/évaluation : " + e.getMessage());
            return 0.0;
        }
    }
}
