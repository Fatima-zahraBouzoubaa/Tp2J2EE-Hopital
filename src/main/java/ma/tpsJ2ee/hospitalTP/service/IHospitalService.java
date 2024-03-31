package ma.tpsJ2ee.hospitalTP.service;

import ma.tpsJ2ee.hospitalTP.entities.Consultation;
import ma.tpsJ2ee.hospitalTP.entities.Medecin;
import ma.tpsJ2ee.hospitalTP.entities.Patient;
import ma.tpsJ2ee.hospitalTP.entities.RendezVous;

public interface IHospitalService {
    public Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
