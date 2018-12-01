package co.edu.sena.horariosTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.horariosTecnica.domain.EstadoFormacion;

public interface EstadoFormacionRepository extends JpaRepository <EstadoFormacion, Integer> {

	EstadoFormacion findById (int estado);
	List<EstadoFormacion> findByEstado(String estado);
	List<EstadoFormacion>findByLikeEstado();
}
