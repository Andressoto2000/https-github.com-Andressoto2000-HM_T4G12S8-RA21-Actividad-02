package co.edu.sena.horariosTecnica;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.edu.sena.horariosTecnica.domain.EstadoFormacion;
import co.edu.sena.horariosTecnica.repository.EstadoFormacionRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class EstadoFormacionTest {
	@Autowired
	private EstadoFormacionRepository estadoFormacionRepository;

	@Test
	public void test01Insert() {
		EstadoFormacion estado = new EstadoFormacion();
		estado.setId(1);
		estado.setEstado("activo");
		estado.setNombreEstado("el estado esta activo");
		estadoFormacionRepository.save(estado);
		
		
	}
	
	@Test
	
	public void test02Update() {
		EstadoFormacion estado = estadoFormacionRepository.findById(1);
		estado.setEstado("activo");
		estado.setNombreEstado("esta activo");
		estadoFormacionRepository.save(estado);
		Assert.assertEquals(estadoFormacionRepository.findById(1).getEstado(),"activo");
	}
	/*
	@Test
	
	public void test03UpdateUnique() {
		EstadoFormacion estado = estadoFormacionRepository.findByEstado(1);
		estado.setId(2);
		estadoFormacionRepository.save(estado);
		
	}
	*/
	
	@Test
	
	public void test03FindBy() {
		List<EstadoFormacion> es = estadoFormacionRepository.findByEstado("activo");
		assertFalse(es.isEmpty());
	}
	
	

}
