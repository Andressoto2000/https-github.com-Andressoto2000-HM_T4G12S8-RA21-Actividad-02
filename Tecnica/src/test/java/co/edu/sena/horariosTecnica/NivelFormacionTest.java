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

import co.edu.sena.horariosTecnica.domain.NivelFormacion;

import co.edu.sena.horariosTecnica.repository.NivelFormacionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NivelFormacionTest {

	@Autowired
	private NivelFormacionRepository nivelFormacionRepository;
	
	@Test
	public void test01Insert() {
		NivelFormacion nFormacionP = new NivelFormacion();
		nFormacionP.setNivel("Tecnico");
		nFormacionP.setEstado("Activo");
		
		nivelFormacionRepository.save(nFormacionP);
		Assert.assertEquals(nFormacionP,nivelFormacionRepository.findByNivel("Tecnico"));
		
	}
	
	@Test
	public void test02Update() {
		NivelFormacion nFormacionP =  nivelFormacionRepository.findByNivel("Tecnico");
		nFormacionP.setEstado("Inactivo");
		
		nivelFormacionRepository.save(nFormacionP);
		Assert.assertEquals(nivelFormacionRepository.findByNivel("Tecnico").getEstado(),"Inactivo");
	}
	
	@Test
	public void test03UpdateUnique() {
		NivelFormacion nFormacionP = nivelFormacionRepository.findByNivel("Tecnico");
		nFormacionP.setNivel("Tecnico Nocturno");
		
		nivelFormacionRepository.save(nFormacionP);
		Assert.assertEquals(nivelFormacionRepository.findById(nFormacionP.getId()).get().getNivel(),"Tecnico Nocturno");
	}
	
	@Test
	public void test04FindBy() {
		List<NivelFormacion> nFormacionP = nivelFormacionRepository.findByEstado("Inactivo");
		assertFalse(nFormacionP.isEmpty());
	}
	
	@Test
	public void test05FindByLike() {
		List<NivelFormacion> nFormacionP= nivelFormacionRepository.findByLikeEstado("%n%");
		assertFalse(nFormacionP.isEmpty());
	}
	
	@Test
	public void test06FindAll() {
		List <NivelFormacion> nFormacionP= nivelFormacionRepository.findAll();
		assertFalse(nFormacionP.isEmpty());
	}
	
	@Test
	public void test07Delete() {
		NivelFormacion nFormacionP = nivelFormacionRepository.findByNivel("Tecnico Nocturno");
		nivelFormacionRepository.delete(nFormacionP);
		Assert.assertNull(nivelFormacionRepository.findByNivel("tecnico Nocturno"));
	}
}
