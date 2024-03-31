package ma.tpsJ2ee.hospitalTP.service;

import jakarta.transaction.Transactional;
import ma.tpsJ2ee.hospitalTP.entities.Consultation;
import ma.tpsJ2ee.hospitalTP.entities.Medecin;
import ma.tpsJ2ee.hospitalTP.entities.Patient;
import ma.tpsJ2ee.hospitalTP.entities.RendezVous;
import ma.tpsJ2ee.hospitalTP.repositories.ConsultationRepository;
import ma.tpsJ2ee.hospitalTP.repositories.MedecinRepository;
import ma.tpsJ2ee.hospitalTP.repositories.PatientRepository;
import ma.tpsJ2ee.hospitalTP.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
//Injection de dependances
    public HospitalServiceImpl(PatientRepository patientRepository,
                               MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository,
                               ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }
    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        //UUID genere des chaines de caracteres aleatoires uniques
       rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);}
    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
