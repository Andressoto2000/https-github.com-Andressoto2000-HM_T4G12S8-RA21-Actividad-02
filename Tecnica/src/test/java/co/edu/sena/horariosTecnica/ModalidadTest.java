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

import co.edu.sena.horariosTecnica.domain.Modalidad;
import co.edu.sena.horariosTecnica.repository.ModalidadRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModalidadTest {
	
	@Autowired
	private ModalidadRepository modalidadRepository;
	
	@Test
	public void test01Insert() {
		Modalidad modP= new Modalidad();
		modP.setNombreModalidad("Presencial ");
		modP.setColor("Verde");
		modP.setEstado("Activa");
	
		modalidadRepository.save(modP);
		Assert.assertEquals(modP,modalidadRepository.findByNombreModalidad("Presencial"));
		
	}
	
	@Test
	public void test02Update() {
		Modalidad modP = modalidadRepository.findByNombreModalidad("Presencial");
		modP.setColor("Rojo");
		modP.setEstado("Inactiva");
		
		modalidadRepository.save(modP);
		Assert.assertEquals(modalidadRepository.findByNombreModalidad("Presencial").getColor(),"Rojo");
	}
	
	@Test
	public void test03UpdateUnique() {
		Modalidad modP = modalidadRepository.findByNombreModalidad("Presencial");
		modP.setNombreModalidad("Virtual");
		
		modalidadRepository.save(modP);
		Assert.assertEquals(modalidadRepository.findById(modP.getId()).get().getNombreModalidad(), "Virtual");
	}
		
	@Test
	public void test04FindBy() {
		List<Modalidad> modP = modalidadRepository.findByColor("Rojo");
		assertFalse(modP.isEmpty());
		
	}
	
	@Test
	public void test05FindByLike() {
		List<Modalidad> modP = modalidadRepository.findByLikeColor("%oj%");
		assertFalse(modP.isEmpty());
	}
	
	@Test
	public void test06FindAll() {
		List<Modalidad> modP= modalidadRepository.findAll();
		assertFalse(modP.isEmpty());
	}
	
	@Test
	public void test07Delete() {
		Modalidad modP = modalidadRepository.findByNombreModalidad("Virtual");
		modalidadRepository.delete(modP);
		Assert.assertNull(modalidadRepository.findByNombreModalidad("Virtual"));
	}
}
