package ma.tpsJ2ee.hospitalTP.repositories;

import ma.tpsJ2ee.hospitalTP.entities.Consultation;
import ma.tpsJ2ee.hospitalTP.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
