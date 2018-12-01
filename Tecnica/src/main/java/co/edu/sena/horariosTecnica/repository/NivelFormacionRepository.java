package co.edu.sena.horariosTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.horariosTecnica.domain.NivelFormacion;

public interface NivelFormacionRepository extends JpaRepository<NivelFormacion,Integer>{
	NivelFormacion findByNivel(String nivel);
	List<NivelFormacion> findByEstado(String estado);
	List<NivelFormacion> findByLikeEstado(String estado);
}
