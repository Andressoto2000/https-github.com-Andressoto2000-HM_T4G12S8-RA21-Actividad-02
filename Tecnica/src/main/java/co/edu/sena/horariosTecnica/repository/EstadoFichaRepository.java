package co.edu.sena.horariosTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.horariosTecnica.domain.EstadoFicha;

public interface EstadoFichaRepository extends JpaRepository<EstadoFicha,Integer>{
	EstadoFicha findByNombreEstado(String nombreEstado);
	List <EstadoFicha> findByEstado(int estado);
	List<EstadoFicha> findByLikeNombreEstado(String nombreEstado);
}
