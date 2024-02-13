package projetoAna.laboratorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoAna.laboratorio.entities.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
