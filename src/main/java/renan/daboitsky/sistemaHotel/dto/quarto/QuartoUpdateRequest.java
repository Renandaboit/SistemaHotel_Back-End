package renan.daboitsky.sistemaHotel.dto.quarto;

import renan.daboitsky.sistemaHotel.enums.StatusQuarto;
import renan.daboitsky.sistemaHotel.enums.TipoQuarto;

public record QuartoUpdateRequest(
        Integer numero,
        TipoQuarto tipo,
        Integer capacidade,
        Double preco,
        StatusQuarto status
) {}
