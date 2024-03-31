package ma.tpsJ2ee.hospitalTP.repositories;

import ma.tpsJ2ee.hospitalTP.entities.Medecin;
import ma.tpsJ2ee.hospitalTP.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
Medecin findByNom(String name);
}
