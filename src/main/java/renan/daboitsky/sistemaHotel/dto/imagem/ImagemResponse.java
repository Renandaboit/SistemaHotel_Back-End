package renan.daboitsky.sistemaHotel.dto.imagem;

import renan.daboitsky.sistemaHotel.model.Quarto;

public record ImagemResponse(
        Long imagemId,
        String url,
        Quarto quarto
) {}
