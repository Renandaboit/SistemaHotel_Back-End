package renan.daboitsky.sistemaHotel.dto.quarto;

import renan.daboitsky.sistemaHotel.enums.StatusQuarto;
import renan.daboitsky.sistemaHotel.enums.TipoQuarto;
import renan.daboitsky.sistemaHotel.model.Imagem;

import java.util.List;

public record QuartoResponse(
        Long id,
        Integer numero,
        TipoQuarto tipo,
        Integer capacidade,
        Double preco,
        StatusQuarto status,
        List<Imagem> imagens
) {}
