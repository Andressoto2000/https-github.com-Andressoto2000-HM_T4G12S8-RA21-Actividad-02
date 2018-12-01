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

import co.edu.sena.horariosTecnica.domain.ServidorCorreoElectronico;
import co.edu.sena.horariosTecnica.repository.ServidorCorreoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class ServidorCorreoTest {
	@Autowired
	public ServidorCorreoRepository servidorCorreoRepository;
	
	@Test
	public void test01Insert() {
		ServidorCorreoElectronico sCorreoP = new ServidorCorreoElectronico();
		sCorreoP.setAsuntoMensaje("Restablecer Contrasenia");
		sCorreoP.setCorreo("Andres8834374@outlook.com");
		sCorreoP.setMensaje("Para restablecer su contraseña pulse en el siguiente Link");
		sCorreoP.setPassword("123456789");
		sCorreoP.setSmtopStartTlsEnable(2345);
		sCorreoP.setSmtpAuthentication(7896);
		sCorreoP.setSmtpHost("2589");
		sCorreoP.setSmtpPort(4036);
		
		servidorCorreoRepository.save(sCorreoP);
		Assert.assertEquals(sCorreoP,servidorCorreoRepository.findByCorreo("Andres8834374@outlook.com"));
	}
	
	@Test
	public void test02Update() {
		ServidorCorreoElectronico sCorreoP = servidorCorreoRepository.findByCorreo("Andres8834374@outlook.com");
		sCorreoP.setPassword("987654321");
		sCorreoP.setSmtpPort(4306);
		sCorreoP.setAsuntoMensaje("Prueba");
		
		servidorCorreoRepository.save(sCorreoP);
		Assert.assertEquals(servidorCorreoRepository.findByCorreo("Andres8834374@outlook.com").getPassword(), "987654321");
	}
	
	@Test
	public void test03UpdateUnique() {
		ServidorCorreoElectronico sCorreoP =servidorCorreoRepository.findByCorreo("Andres8834374@outlook.com");
		sCorreoP.setCorreo("Andres@outlook.com");
		
		servidorCorreoRepository.save(sCorreoP);
		Assert.assertEquals(servidorCorreoRepository.findById(sCorreoP.getId()).get().getCorreo(), "Andres@outlook.com");
	}
	
	@Test
	public void test04FindBy() {
		List<ServidorCorreoElectronico> sCorreoP = servidorCorreoRepository.findByAsuntoMensaje("Prueba");
		assertFalse(sCorreoP.isEmpty());
	}
	
	@Test
	public void test05FindByLike() {
		List<ServidorCorreoElectronico> sCorreoP = servidorCorreoRepository.findByLikeAsuntoMensaje("%eb%");
		assertFalse(sCorreoP.isEmpty());
	}
	
	@Test
	public void test06FindAll() {
		List<ServidorCorreoElectronico> sCorreoP =servidorCorreoRepository.findAll();
		assertFalse(sCorreoP.isEmpty());
	}
	
	
	@Test
	public void test07Delete() {
		ServidorCorreoElectronico sCorreoP = servidorCorreoRepository.findByCorreo("Andres@outlook.com");
		System.out.println(sCorreoP);
		servidorCorreoRepository.delete(sCorreoP);
		Assert.assertNull(servidorCorreoRepository.findByCorreo("Andres@outlook.com"));
	}
	
}
