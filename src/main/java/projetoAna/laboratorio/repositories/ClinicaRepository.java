package projetoAna.laboratorio.repositories;

import projetoAna.laboratorio.entities.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // a entidade é a clinica e o Id seria o Long
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
}
