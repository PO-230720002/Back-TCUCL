package tcucl.back_tcucl.service.impl.onglet;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tcucl.back_tcucl.dto.onglet.mobInternational.MobInternationalOngletDto;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageDto;
import tcucl.back_tcucl.entity.onglet.mobInternationale.MobInternationalOnglet;
import tcucl.back_tcucl.entity.onglet.mobInternationale.Voyage;
import tcucl.back_tcucl.entity.onglet.mobInternationale.enums.EnumMobInternationale_NomPays;
import tcucl.back_tcucl.exceptionPersonnalisee.ValidationCustomException;
import tcucl.back_tcucl.manager.MobInternationalOngletManager;
import tcucl.back_tcucl.service.MobInternationalOngletService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MobInternationalOngletServiceImpl implements MobInternationalOngletService {

    @Autowired
    private Validator validator;

    private final MobInternationalOngletManager mobInternationalOngletManager;

    public MobInternationalOngletServiceImpl(MobInternationalOngletManager mobInternationalOngletManager) {
        this.mobInternationalOngletManager = mobInternationalOngletManager;
    }

    @Override
    public MobInternationalOnglet getMobInternationalOngletById(Long ongletId) {
        return mobInternationalOngletManager.getMobInternationalOngletById(ongletId);
    }

    @Override
    public void updateMobInternationalOngletPartiel(Long ongletId, MobInternationalOngletDto mobInternationalOngletDto) {
        mobInternationalOngletManager.updateMobInternationalOngletPartiel(ongletId, mobInternationalOngletDto);
    }

    @Override
    public void ajouterVoyage(Long ongletId, VoyageDto voyageDto) {
        mobInternationalOngletManager.ajouterVoyage(ongletId, voyageDto);
    }

    @Override
    public void supprimerVoyage(Long ongletId, Long voyageId) {
        mobInternationalOngletManager.supprimerVoyage(ongletId, voyageId);
    }

    @Override
    public void updateVoyagePartiel(Long ongletId, Long voyageId, VoyageDto voyageDto) {
        mobInternationalOngletManager.updateVoyagePartiel(ongletId, voyageId, voyageDto);
    }

    @Override
    public void importVoyagesFromExcel(Long ongletId, MultipartFile file, boolean modeAjout) {

        // Import de l'onglet
        MobInternationalOnglet mobInternationalOngletById = mobInternationalOngletManager.getMobInternationalOngletById(ongletId);

        // Récupération de la liste des voyages
        List<Voyage> voyagesById = mobInternationalOngletById.getVoyage();

        // Si on n'est pas en mode modeAjout, on vide la liste des voyages
        if (!modeAjout) {
            voyagesById.clear();
        }

        // Création d'une map, Destination -> Voyage
        // avec les valeurs des voyages existants en base (byId)
        Map<EnumMobInternationale_NomPays, Voyage> voyagesParPays = new HashMap<>();
        if (modeAjout) {
            for (Voyage v : voyagesById) {
                voyagesParPays.put(v.getNomPays(), v);
            }
        }

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            // Récupération de la première feuille
            Sheet sheet = workbook.getSheetAt(0);

            // itération sur les lignes de la feuille
            for (int i = 3; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                // Vérification si la ligne est vide (si ne comporte aucun trajet, cela ne vérifie pas la colonne des noms de pays)
                if (row == null || isRowEmpty(row)) continue;

                //Récupération de la Destination (nomPays)
                String nomPaysStr = getCellValueAsString(row.getCell(0));
                EnumMobInternationale_NomPays nomPays = EnumMobInternationale_NomPays.fromLibelle(nomPaysStr);
                if (nomPays == null) {
                    System.err.println("Pays non reconnu : " + nomPaysStr);
                    continue;
                }

                //Récupération des valeurs des trajets pour la destination
                Integer prosAvion = getCellValueAsInteger(row.getCell(1));
                Integer stagesEtudiantsAvion = getCellValueAsInteger(row.getCell(3));
                Integer semestresEtudiantsAvion = getCellValueAsInteger(row.getCell(5));
                Integer stagesEtudiantsTrain = 0;
                Integer semestresEtudiantsTrain = 0;
                Integer prosTrain = 0;

                // Si le pays est accessible en train, on récupère les valeurs des trajets en train
                if (nomPays.getAccessibleEnTrain()) {
                    stagesEtudiantsTrain = getCellValueAsInteger(row.getCell(4));
                    semestresEtudiantsTrain = getCellValueAsInteger(row.getCell(6));
                    prosTrain = getCellValueAsInteger(row.getCell(2));
                }

                // Si nous sommes en mode ajout  et que le pays existe déjà,
                // on met à jour les valeurs en sommant l'excel et les valeurs en base
                if (modeAjout && voyagesParPays.containsKey(nomPays)) {
                    Voyage existing = voyagesParPays.get(nomPays);
                    existing.setProsAvion(existing.getProsAvion() + prosAvion);
                    existing.setProsTrain(existing.getProsTrain() + prosTrain);
                    existing.setStagesEtudiantsAvion(existing.getStagesEtudiantsAvion() + stagesEtudiantsAvion);
                    existing.setStagesEtudiantsTrain(existing.getStagesEtudiantsTrain() + stagesEtudiantsTrain);
                    existing.setSemestresEtudiantsAvion(existing.getSemestresEtudiantsAvion() + semestresEtudiantsAvion);
                    existing.setSemestresEtudiantsTrain(existing.getSemestresEtudiantsTrain() + semestresEtudiantsTrain);
                    continue;
                }

                // Si nous ne sommes pas en mode ajout, OU que le pays n'existe pas encore,
                // on crée un nouveau voyage
                Voyage voyage = new Voyage(nomPays, prosAvion, prosTrain, stagesEtudiantsAvion, stagesEtudiantsTrain, semestresEtudiantsAvion, semestresEtudiantsTrain);

                voyagesById.add(voyage);
            }

            // Check des contraintes de validation (s'il n'y a pas de valeurs train si la destination n'est pas accessible en train)
            Set<ConstraintViolation<MobInternationalOnglet>> violations = validator.validate(mobInternationalOngletById);
            if (!violations.isEmpty()) {
                throw new ValidationCustomException(violations);
            }

            mobInternationalOngletManager.save(mobInternationalOngletById);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String getCellValueAsString(Cell cell) {
        if (cell == null || cell.getCellType() == CellType.BLANK) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }

    private Integer getCellValueAsInteger(Cell cell) {
        if (cell == null || cell.getCellType() == CellType.BLANK) return 0;
        return switch (cell.getCellType()) {
            case NUMERIC -> (int) cell.getNumericCellValue();
            case STRING -> {
                try {
                    yield Integer.parseInt(cell.getStringCellValue().trim());
                } catch (NumberFormatException e) {
                    yield 0;
                }
            }
            default -> 0;
        };
    }

    // Méthode pour vérifier si une ligne est entièrement vide
    private boolean isRowEmpty(Row row) {
        for (int i = 1; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

}
