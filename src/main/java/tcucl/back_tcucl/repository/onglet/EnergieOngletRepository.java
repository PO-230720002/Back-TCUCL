package tcucl.back_tcucl.repository.onglet;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.onglet.EnergieOnglet;

@Repository
public interface EnergieOngletRepository extends JpaRepository<EnergieOnglet, Long> {



    @Modifying
    @Transactional
    @Query("UPDATE EnergieOnglet e SET e.estTermine = :estTermine WHERE e.id = :id")
    int updateEstTermine(@Param("id") Long id, @Param("estTermine") boolean estTermine);

    @Modifying
    @Transactional
    @Query("UPDATE EnergieOnglet e SET e.ConsoGaz = :consoGaz WHERE e.id = :id")
    int updateConsoGaz(@Param("id") Long id, @Param("consoGaz") Float consoGaz);

    @Modifying
    @Transactional
    @Query("UPDATE EnergieOnglet e SET e.ConsoFioul = :consoFioul WHERE e.id = :id")
    int updateConsoFioul(@Param("id") Long id, @Param("consoFioul") Float consoFioul);

    @Modifying
    @Transactional
    @Query("UPDATE EnergieOnglet e SET e.ConsoBois = :consoBois WHERE e.id = :id")
    int updateConsoBois(@Param("id") Long id, @Param("consoBois") Float consoBois);

    @Modifying
    @Transactional
    @Query("UPDATE EnergieOnglet e SET e.ConsoReseauVille = :consoReseauVille WHERE e.id = :id")
    int updateConsoReseauVille(@Param("id") Long id, @Param("consoReseauVille") Float consoReseauVille);

    @Modifying
    @Transactional
    @Query("UPDATE EnergieOnglet e SET e.ConsoElecChauffage = :consoElecChauffage WHERE e.id = :id")
    int updateConsoElecChauffage(@Param("id") Long id, @Param("consoElecChauffage") Float consoElecChauffage);

    @Modifying
    @Transactional
    @Query("UPDATE EnergieOnglet e SET e.ConsoElecSpecifique = :consoElecSpecifique WHERE e.id = :id")
    int updateConsoElecSpecifique(@Param("id") Long id, @Param("consoElecSpecifique") Float consoElecSpecifique);

    @Modifying
    @Transactional
    @Query("UPDATE EnergieOnglet e SET e.ConsoEau = :consoEau WHERE e.id = :id")
    int updateConsoEau(@Param("id") Long id, @Param("consoEau") Float consoEau);

    @Modifying
    @Transactional
    @Query("UPDATE EnergieOnglet e SET e.note = :note WHERE e.id = :id")
    int updateNote(@Param("id") Long id, @Param("note") String note);
}

