package tcucl.back_tcucl.entity.annee;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import tcucl.back_tcucl.entity.Entite;
import tcucl.back_tcucl.repository.annee.AnneeRepository;

@Entity
@Table(name = "annee_logement_restauration")
public class Annee_LogementRestauration extends Annee {
}
