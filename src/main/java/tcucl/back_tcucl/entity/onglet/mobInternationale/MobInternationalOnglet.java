package tcucl.back_tcucl.entity.onglet.mobInternationale;

import jakarta.persistence.*;
import tcucl.back_tcucl.dto.onglet.mobInternational.VoyageDto;
import tcucl.back_tcucl.entity.onglet.Onglet;

import java.util.List;

@Entity
@Table(name = "mob_international_onglet")
public class MobInternationalOnglet extends Onglet {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "voyage_mob_internationale_id")
    private List<Voyage> voyage;


    public List<Voyage> getVoyage() {
        return voyage;
    }

    public void setVoyage(List<Voyage> voyage) {
        this.voyage = voyage;
    }

    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    @Override
    public Boolean getEstTermine() {
        return super.getEstTermine();
    }

    @Override
    public void setEstTermine(Boolean estTermine) {
        super.setEstTermine(estTermine);
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
