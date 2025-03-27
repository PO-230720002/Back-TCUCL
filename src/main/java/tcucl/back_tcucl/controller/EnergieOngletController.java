package tcucl.back_tcucl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;
import tcucl.back_tcucl.service.EnergieOngletService;

@RestController
@RequestMapping("/energieOnglet")
public class EnergieOngletController {
    private final EnergieOngletService energieOngletService;

    public EnergieOngletController(EnergieOngletService energieOngletService) {
        this.energieOngletService = energieOngletService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEnergieOngletById(@PathVariable Long id) {
        return ResponseEntity.ok(energieOngletService.getEnergieOngletById(id));
    }

    @PostMapping("/createRandom")
    public ResponseEntity<?> createRandomEnergieOnglet() {
        return ResponseEntity.ok(energieOngletService.createRandomEnergieOnglet());
    }

    @PatchMapping()
    public ResponseEntity<?> updateEnergieOnglet( @RequestBody EnergieOnglet energieOnglet) {
        energieOngletService.updateEnergieOnglet(energieOnglet);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{id}/estTermine")
    public ResponseEntity<Void> updateEstTermine(@PathVariable Long id, @RequestBody boolean estTermine) {
        energieOngletService.setEstTermine(id, estTermine);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{id}/consoGaz")
    public ResponseEntity<Void> updateConsoGaz(@PathVariable Long id, @RequestBody Float consoGaz) {
        energieOngletService.setConsoGaz(id, consoGaz);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/consoFioul")
    public ResponseEntity<Void> updateConsoFioul(@PathVariable Long id, @RequestBody Float consoFioul) {
        energieOngletService.setConsoFioul(id, consoFioul);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/consoBois")
    public ResponseEntity<Void> updateConsoBois(@PathVariable Long id, @RequestBody Float consoBois) {
        energieOngletService.setConsoBois(id, consoBois);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/consoReseauVille")
    public ResponseEntity<Void> updateConsoReseauVille(@PathVariable Long id, @RequestBody Float consoReseauVille) {
        energieOngletService.setConsoReseauVille(id, consoReseauVille);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/consoElecChauffage")
    public ResponseEntity<Void> updateConsoElecChauffage(@PathVariable Long id, @RequestBody Float consoElecChauffage) {
        energieOngletService.setConsoElecChauffage(id, consoElecChauffage);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/consoElecSpecifique")
    public ResponseEntity<Void> updateConsoElecSpecifique(@PathVariable Long id, @RequestBody Float consoElecSpecifique) {
        energieOngletService.setConsoElecSpecifique(id, consoElecSpecifique);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/consoEau")
    public ResponseEntity<Void> updateConsoEau(@PathVariable Long id, @RequestBody Float consoEau) {
        energieOngletService.setConsoEau(id, consoEau);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/note")
    public ResponseEntity<Void> updateNote(@PathVariable Long id, @RequestBody String note) {
        energieOngletService.setNote(id, note);
        return ResponseEntity.ok().build();
    }
}
