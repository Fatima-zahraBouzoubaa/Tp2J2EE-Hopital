package ma.tpsJ2ee.hospitalTP;

import ma.tpsJ2ee.hospitalTP.entities.*;
import ma.tpsJ2ee.hospitalTP.repositories.ConsultationRepository;
import ma.tpsJ2ee.hospitalTP.repositories.MedecinRepository;
import ma.tpsJ2ee.hospitalTP.repositories.PatientRepository;
import ma.tpsJ2ee.hospitalTP.repositories.RendezVousRepository;
import ma.tpsJ2ee.hospitalTP.service.HospitalServiceImpl;
import ma.tpsJ2ee.hospitalTP.service.IHospitalService;
import org.apache.el.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HospitalTpApplication {

	public static void main(String[] args) {SpringApplication.run(HospitalTpApplication.class, args);}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository,
							MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository,
							ConsultationRepository consultationRepository
							){
		return args -> {
		//	patientRepository.save(new Patient(null, "Hassan", new Date(),false, null));
			java.util.stream.Stream.of("Mohammed","Hassan","Najat")
					.forEach(name->{
						Patient patient=new Patient ();
						//patient.setNom("Hassan");
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);});



		java.util.stream.Stream.of("Aymane","Hanane","Yassmine")
				.forEach(name->{
					Medecin medecin=new Medecin();
					medecin.setNom(name);
					medecin.setEmail((name+"gmail.com"));
					medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
					hospitalService.saveMedecin(medecin);});
		Patient patient=patientRepository.findById(1L).orElse(null);
		Patient patient1=patientRepository.findByNom("Mohammed");
		Medecin medecin=medecinRepository.findByNom("Yassmine");

			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			RendezVous saveRDV= hospitalService.saveRDV(rendezVous);
			System.out.println(saveRDV.getId());

			//RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
			RendezVous rendezVous1=rendezVousRepository.findAll().get(0);

			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation 1");
			hospitalService.saveConsultation(consultation);




	};
	}


}
