package co.edu.sena.horariosTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.horariosTecnica.domain.Sede;

public interface SedeRepository extends JpaRepository<Sede,Integer> {
	Sede findByNombreSede(String nombreSede);
	List<Sede> findByDireccion(String direccion);
	List<Sede> findByLikeDireccion(String direccion);
}
