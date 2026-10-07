package renan.daboitsky.sistemaHotel.dto.quarto;

import renan.daboitsky.sistemaHotel.enums.TipoQuarto;

public record QuartoRequest(
        Integer numero,
        TipoQuarto tipo,
        Integer capacidade,
        Double preco
) {}
