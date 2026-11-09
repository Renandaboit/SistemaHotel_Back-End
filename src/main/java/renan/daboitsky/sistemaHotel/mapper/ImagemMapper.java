package renan.daboitsky.sistemaHotel.mapper;

import org.springframework.stereotype.Component;
import renan.daboitsky.sistemaHotel.dto.imagem.ImagemRequest;
import renan.daboitsky.sistemaHotel.dto.imagem.ImagemResponse;
import renan.daboitsky.sistemaHotel.model.Imagem;
import renan.daboitsky.sistemaHotel.model.Quarto;

import java.util.List;

@Component
public class ImagemMapper {
    public Imagem toEntity(ImagemRequest request, Quarto quarto) {
        return Imagem.builder()
                .id(request.quartoId())
                .url(request.url())
                .quarto(quarto)
                .build();
    }

    public ImagemResponse toResponse(Imagem imagem) {
        return new ImagemResponse(
                imagem.getId(),
                imagem.getUrl(),
                imagem.getQuarto().getId()
        );
    }
    public List<ImagemResponse> toResponseList(List<Imagem> imagens) {
        return imagens.stream().map(this::toResponse).toList();
    }
}
