package renan.daboitsky.sistemaHotel.mapper;

import org.springframework.stereotype.Component;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoRequest;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoResponse;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoUpdateRequest;
import renan.daboitsky.sistemaHotel.model.Quarto;

import java.util.List;

@Component
public class QuartoMapper {
    public Quarto toEntity(QuartoRequest request) {
        return Quarto.builder()
                .numero(request.numero())
                .tipo(request.tipo())
                .capacidade(request.capacidade())
                .preco(request.preco())
                .build();
    }

    public QuartoResponse toResponse(Quarto quarto) {
        return new QuartoResponse(
                quarto.getId(),
                quarto.getNumero(),
                quarto.getTipo(),
                quarto.getCapacidade(),
                quarto.getPreco(),
                quarto.getStatusQuarto()
        );
    }

    public List<QuartoResponse> toResponseList(List<Quarto> quartos) {
        return quartos.stream().map(this::toResponse).toList();
    }

    public void updateEntity(QuartoUpdateRequest request, Quarto quarto) {
        quarto.setNumero(request.numero());
        quarto.setTipo(request.tipo());
        quarto.setCapacidade(request.capacidade());
        quarto.setPreco(request.preco());
        quarto.setStatusQuarto(request.status());
    }
}
