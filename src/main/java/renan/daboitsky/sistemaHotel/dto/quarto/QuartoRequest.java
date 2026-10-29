package renan.daboitsky.sistemaHotel.dto.quarto;

import renan.daboitsky.sistemaHotel.enums.TipoQuarto;
import renan.daboitsky.sistemaHotel.model.Imagem;

import java.util.List;

public record QuartoRequest(
        Integer numero,
        TipoQuarto tipo,
        Integer capacidade,
        Double preco,
        List<Imagem> imagens
) {}
