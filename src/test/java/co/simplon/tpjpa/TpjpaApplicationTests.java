package co.simplon.tpjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.simplon.tpjpa.model.Apprenant;
import co.simplon.tpjpa.model.Competence;
import co.simplon.tpjpa.model.DossierAdministration;
import co.simplon.tpjpa.model.SessionFormation;
import co.simplon.tpjpa.repository.ApprenantRepository;
import co.simplon.tpjpa.repository.CompetenceRepository;
import co.simplon.tpjpa.repository.DossierAdministrationRepository;
import co.simplon.tpjpa.repository.SessionFormationReposytory;

@SpringBootTest
class TpjpaApplicationTests {

	@Autowired
	private ApprenantRepository apprenant;
	@Autowired
	private CompetenceRepository competence;
	@Autowired
	private DossierAdministrationRepository dossierAdmin;
	@Autowired
	private SessionFormationReposytory sessionFormation;
	
	@BeforeEach
	void clean() {
		dossierAdmin.deleteAll();
		apprenant.deleteAll();
		competence.deleteAll();
		sessionFormation.deleteAll();
	}

	@Test
	void allTestJpa(){
		SessionFormation s = new SessionFormation();
		s.setLabelle("cda");
		sessionFormation.save(s);
		
		
		Competence c = new Competence();
		c.setLabelle("dev");
		c.setNiveau(3);
		//c.getApprenants().add(a);
		competence.save(c);
		
		Apprenant a = new Apprenant();
		a.setPrenom("pat");
		a.setNom("catou");
		a.setSessionFormation(s);
		a.getCompetences().add(c);
		//apprenant.save(a);
		
		Competence c2 = new Competence();
		c2.setLabelle("mae");
		c2.setNiveau(34);
		c2.getApprenants().add(a);
		competence.save(c2);
		apprenant.save(a);
		
		DossierAdministration d = new DossierAdministration();
		d.setTuteurNom("moran");
		d.setTuteurEmail("bobmaran@gmail.com");
		d.setApprenant(a);
		dossierAdmin.save(d);
		
		assertEquals("moran", d.getTuteurNom());
		
	}

}
