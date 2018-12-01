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

import co.edu.sena.horariosTecnica.domain.EstadoFicha;
import co.edu.sena.horariosTecnica.repository.EstadoFichaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EstadoFichaTest {
	@Autowired
	private EstadoFichaRepository  eFichaRepository;
	
	@Test
	public void test01Insert() {
		EstadoFicha eFichaP = new EstadoFicha();
		eFichaP.setNombreEstado("Activo");
		eFichaP.setEstado(1);
		
		eFichaRepository.save(eFichaP);
		Assert.assertEquals(eFichaP,eFichaRepository.findByNombreEstado("Activo"));
	}
	
	@Test
	public void test02Update() {
		EstadoFicha eFichaP = eFichaRepository.findByNombreEstado("Activo");
		eFichaP.setEstado(2);
		
		eFichaRepository.save(eFichaP);
		Assert.assertEquals(eFichaRepository.findByNombreEstado("Activo").getEstado(),2);
	}
	
	@Test
	public void test03UpdateUnique() {
		EstadoFicha eFichaP = eFichaRepository.findByNombreEstado("Activo");
		eFichaP.setNombreEstado("Fusion");
		
		eFichaRepository.save(eFichaP);
		Assert.assertEquals(eFichaRepository.findById(eFichaP.getId()).get().getNombreEstado(),"Fusion");
	}
	
	@Test
	public void test04FindBy() {
		List<EstadoFicha> eFichaP = eFichaRepository.findByEstado(2);
		assertFalse(eFichaP.isEmpty());
	}
	
	@Test
	public void test05FindByLike() {
		List <EstadoFicha> eFichaP = eFichaRepository.findByLikeNombreEstado("%si%");
		assertFalse(eFichaP.isEmpty());
	}
	
	@Test
	public void test06FindAll() {
	List<EstadoFicha> eFichaP = eFichaRepository.findAll();
	assertFalse(eFichaP.isEmpty());
	}
	
	@Test
	public void test07Delete() {
		EstadoFicha eFichaP = eFichaRepository.findByNombreEstado("Fusion");
		eFichaRepository.delete(eFichaP);
		Assert.assertNull(eFichaRepository.findByNombreEstado("Fusion"));
	}
}

