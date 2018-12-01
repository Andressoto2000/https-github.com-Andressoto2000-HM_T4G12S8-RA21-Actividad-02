package co.edu.sena.horariosTecnica;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.Assert;

import static org.junit.Assert.assertFalse;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.edu.sena.horariosTecnica.domain.Jornada;
import co.edu.sena.horariosTecnica.repository.JornadaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JornadaTest {
	
	@Autowired
	public JornadaRepository jornadaRepository;
	
	@Test
	public void test01Insert() {
		Jornada jornadaP = new Jornada();
		jornadaP.setSiglaJornada("FDS");
		jornadaP.setNombreJornada("Diurna");
		jornadaP.setEstado("Activa");
		jornadaP.setDescripcion("Jornada Sabado y domingo de 6 a 6");
		
		jornadaRepository.save(jornadaP);
		Assert.assertEquals(jornadaP,jornadaRepository.findBySiglaJornada("FDS"));
	}
	
	@Test
	public void test02Update() {
		Jornada jornadaP = jornadaRepository.findBySiglaJornada("FDS");
		jornadaP.setDescripcion("Jornada Sabado y domingo de 6am a 6pm");
		jornadaP.setEstado("Inactiva");
		
		jornadaRepository.save(jornadaP);
		Assert.assertEquals(jornadaRepository.findBySiglaJornada("FDS").getDescripcion(), "Jornada Sabado y domingo de 6am a 6pm");
	}
	
	@Test
	public void test03UpdateUnique() {
		Jornada jornadaP = jornadaRepository.findBySiglaJornada("FDS");
		jornadaP.setNombreJornada("Fines de Semanas1");
		
		jornadaRepository.save(jornadaP);
		Assert.assertEquals(jornadaRepository.findById(jornadaP.getId()).get().getNombreJornada(),"Fines de Semanas1");
	}
	
	@Test
	public void test04FindBy() {
		List<Jornada> jornadaP =jornadaRepository.findByNombreJornada("Fines de Semanas1");
		assertFalse(jornadaP.isEmpty());
	}
	
	@Test
	public void test05FindByLike() {
		List<Jornada> jornadaP = jornadaRepository.findByLikeNombreJornada("%ana%");
		assertFalse(jornadaP.isEmpty());
	}
	
	@Test
	public void test06FindAll() {
		List<Jornada> jornadaP = jornadaRepository.findAll();
		assertFalse(jornadaP.isEmpty());
	}
	
	@Test
	public void test07Delete() {
		Jornada jornadaP = jornadaRepository.findBySiglaJornada("FDS");
		jornadaRepository.delete(jornadaP);
		
		Assert.assertNull(jornadaRepository.findBySiglaJornada("FDS"));
		
		
	}
	
}
