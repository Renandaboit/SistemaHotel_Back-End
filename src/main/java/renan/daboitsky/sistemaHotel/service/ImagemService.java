package renan.daboitsky.sistemaHotel.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import renan.daboitsky.sistemaHotel.dto.imagem.ImagemRequest;
import renan.daboitsky.sistemaHotel.dto.imagem.ImagemResponse;
import renan.daboitsky.sistemaHotel.mapper.ImagemMapper;
import renan.daboitsky.sistemaHotel.model.Imagem;
import renan.daboitsky.sistemaHotel.model.Quarto;
import renan.daboitsky.sistemaHotel.repository.ImagemRepository;
import renan.daboitsky.sistemaHotel.repository.QuartoRepository;

import java.util.List;

public class ImagemService {
    private final ImagemRepository repository;
    private final ImagemMapper mapper;
    private final QuartoRepository quartoRepository;

    public ImagemService(ImagemRepository repository, ImagemMapper mapper, QuartoRepository quartoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.quartoRepository = quartoRepository;
    }

    public List<ImagemResponse> listar() {
        return mapper.toResponseList(repository.findAll());
    }

    public ImagemResponse cadastrar(ImagemRequest request) {
        Quarto quarto = quartoRepository.findById(request.quartoId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não achou o quarto com esse ID"));

        Imagem imagem = mapper.toEntity(request, quarto);
        return mapper.toResponse(imagem);
    }

    public void excluir(Long id) {
        Imagem imagem = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não achou imagem com esse ID"));

        repository.deleteById(id);
    }
}
