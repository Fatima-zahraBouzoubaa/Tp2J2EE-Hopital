package ma.tpsJ2ee.hospitalTP.repositories;

import ma.tpsJ2ee.hospitalTP.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);
}
