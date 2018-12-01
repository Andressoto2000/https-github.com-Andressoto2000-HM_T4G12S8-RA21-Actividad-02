package co.edu.sena.horariosTecnica.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.horariosTecnica.domain.Jornada;
import co.edu.sena.horariosTecnica.domain.Sede;

public interface JornadaRepository extends JpaRepository<Jornada,Integer>{
	Jornada findBySiglaJornada(String siglaJornada);
	List<Jornada> findByNombreJornada(String nombreJornada);
	List<Jornada> findByLikeNombreJornada(String nombreJornada);
}
