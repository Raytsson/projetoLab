package projetoAna.laboratorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoAna.laboratorio.entities.Protetica;

@Repository
public interface ProteticaRepository extends JpaRepository<Protetica, Long> {
}
