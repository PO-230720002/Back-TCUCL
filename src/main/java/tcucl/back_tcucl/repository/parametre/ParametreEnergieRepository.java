package tcucl.back_tcucl.repository.parametre;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tcucl.back_tcucl.entity.parametre.energie.ParametreEnergie;


@Repository
public interface ParametreEnergieRepository extends JpaRepository<ParametreEnergie, Long> {
    
    @Modifying
    @Transactional
    @Query("UPDATE ParametreEnergie p SET p.valeurEnumEnergieReseauVille = :reseauVille WHERE p.id = :id")
    int setReseauVille(@Param("id") Long id, @Param("reseauVille") Integer valeurEnumEnergieReseauVille);

    @Modifying
    @Transactional
    @Query("UPDATE ParametreEnergie p SET p.valeurEnumEnergieUniteBois = :uniteBois WHERE p.id = :id")
    int setUniteBois(@Param("id") Long id, @Param("uniteBois") Integer valeurEnumEnergieUniteBois);

    @Modifying
    @Transactional
    @Query("UPDATE ParametreEnergie p SET p.valeurEnumEnergieUniteFioul = :uniteFioul WHERE p.id = :id")
    int setUniteFioul(@Param("id") Long id, @Param("uniteFioul") Integer valeurEnumEnergieUniteFioul);

    @Modifying
    @Transactional
    @Query("UPDATE ParametreEnergie p SET p.valeurEnumEnergieUniteGaz = :uniteGaz WHERE p.id = :id")
    int setUniteGaz(@Param("id") Long id, @Param("uniteGaz") Integer valeurEnumEnergieUniteGaz);

}
