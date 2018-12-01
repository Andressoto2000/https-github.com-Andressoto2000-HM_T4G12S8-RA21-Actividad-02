package co.edu.sena.horariosTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.horariosTecnica.domain.Dia;

public interface DiaRepository extends JpaRepository<Dia,Integer>{
	Dia findByNombreDia(String nombreDia);
	List<Dia> findByEstado(String estado);
	List<Dia> findByLikeEstado(String estado);
}
