package projetoAna.laboratorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoAna.laboratorio.entities.Clinica;
import projetoAna.laboratorio.entities.Dentista;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {
}
