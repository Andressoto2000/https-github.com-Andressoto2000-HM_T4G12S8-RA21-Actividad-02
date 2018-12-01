package co.edu.sena.horariosTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import co.edu.sena.horariosTecnica.domain.Modalidad;

public interface ModalidadRepository extends JpaRepositoryImplementation<Modalidad,Integer> {
	Modalidad findByNombreModalidad(String nombreModalidad);
	List<Modalidad> findByColor(String color);
	List<Modalidad> findByLikeColor(String color);
}
