package projetoAna.laboratorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoAna.laboratorio.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
