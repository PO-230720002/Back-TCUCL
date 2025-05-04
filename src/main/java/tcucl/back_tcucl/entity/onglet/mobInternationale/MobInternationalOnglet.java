package tcucl.back_tcucl.entity.onglet.mobInternationale;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageDto;
import tcucl.back_tcucl.entity.onglet.Onglet;

import java.util.List;

@Entity
@Table(name = "mob_international_onglet")
public class MobInternationalOnglet extends Onglet {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "voyage_mob_internationale_id")
    @Valid
    private List<Voyage> voyage;


    public List<Voyage> getVoyage() {
        return voyage;
    }

    public void setVoyage(List<Voyage> voyage) {
        this.voyage = voyage;
    }

    

    public void ajouterVoyageViaDto(VoyageDto voyageDto) {

        Voyage voyage = new Voyage();
        voyage.setNomPays(voyageDto.getNomPays());
        voyage.setProsAvion(voyageDto.getProsAvion());
        voyage.setProsTrain(voyageDto.getProsTrain());
        voyage.setStagesEtudiantsAvion(voyageDto.getStagesEtudiantsAvion());
        voyage.setStagesEtudiantsTrain(voyageDto.getStagesEtudiantsTrain());
        voyage.setSemestresEtudiantsAvion(voyageDto.getSemestresEtudiantsAvion());
        voyage.setSemestresEtudiantsTrain(voyageDto.getSemestresEtudiantsTrain());

        this.voyage.add(voyage);
    }
}
