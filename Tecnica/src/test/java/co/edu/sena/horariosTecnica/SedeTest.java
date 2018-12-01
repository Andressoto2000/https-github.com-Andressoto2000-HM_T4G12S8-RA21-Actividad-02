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

import co.edu.sena.horariosTecnica.domain.Sede;
import co.edu.sena.horariosTecnica.repository.SedeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SedeTest {
	
	@Autowired
	private SedeRepository sedeRepository;
	
	@Test
	public void test01Insert() {
		Sede sedeP = new Sede();
		sedeP.setNombreSede("Barrio Colombia");
		sedeP.setDireccion("Calle 69 - 22");
		sedeP.setEstado("Activa");
		
		sedeRepository.save(sedeP);
		Assert.assertEquals(sedeP,sedeRepository.findByNombreSede("Barrio Colombia"));
		
	}
	
	@Test
	public void test02Update() {
		Sede sedeP =  sedeRepository.findByNombreSede("Barrio Colombia");
		sedeP.setEstado("Disponible");
		sedeP.setDireccion("Calle 69 - 22 Sur");
		
		sedeRepository.save(sedeP);
		Assert.assertEquals(sedeRepository.findByNombreSede("Barrio Colombia").getDireccion(),"Calle 69 - 22 Sur");
	}
	
	@Test
	public void test03UpdateUnique() {
		Sede sedeP = sedeRepository.findByNombreSede("Barrio Colombia");
		sedeP.setNombreSede("Barrio Colombia CEET");
		
		sedeRepository.save(sedeP);
		Assert.assertEquals(sedeRepository.findById(sedeP.getId()).get().getNombreSede(),"Barrio Colombia CEET");
	}
	
	@Test
	public void test04FindBy() {
		List<Sede> sedeP = sedeRepository.findByDireccion("Calle 69 - 22 Sur");
		assertFalse(sedeP.isEmpty());
	}
	
	@Test
	public void test05FindByLike() {
		List<Sede> sedeP= sedeRepository.findByLikeDireccion("%alle%");
		assertFalse(sedeP.isEmpty());
	}
	
	@Test
	public void test06FindAll() {
		List <Sede> sedeP= sedeRepository.findAll();
		assertFalse(sedeP.isEmpty());
	}
	
	@Test
	public void test07Delete() {
		Sede sedeP = sedeRepository.findByNombreSede("Barrio Colombia CEET");
		sedeRepository.delete(sedeP);
		Assert.assertNull(sedeRepository.findByNombreSede("Barrio Colombia CEET"));
	}
	
}
