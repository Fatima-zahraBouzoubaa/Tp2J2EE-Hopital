package ma.tpsJ2ee.hospitalTP.repositories;

import ma.tpsJ2ee.hospitalTP.entities.Patient;
import ma.tpsJ2ee.hospitalTP.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
