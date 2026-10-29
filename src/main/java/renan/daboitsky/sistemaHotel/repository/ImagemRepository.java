package renan.daboitsky.sistemaHotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import renan.daboitsky.sistemaHotel.model.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
