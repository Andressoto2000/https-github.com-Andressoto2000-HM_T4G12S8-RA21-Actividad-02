package co.edu.sena.horariosTecnica.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.horariosTecnica.domain.ServidorCorreoElectronico;
public interface ServidorCorreoRepository extends JpaRepository<ServidorCorreoElectronico,Integer>{
	ServidorCorreoElectronico findByCorreo(String correo);
	List<ServidorCorreoElectronico> findByAsuntoMensaje(String asuntoMensaje);
	List<ServidorCorreoElectronico> findByLikeAsuntoMensaje(String asuntoMensaje);
	
}
