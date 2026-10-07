package renan.daboitsky.sistemaHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import renan.daboitsky.sistemaHotel.model.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
}
