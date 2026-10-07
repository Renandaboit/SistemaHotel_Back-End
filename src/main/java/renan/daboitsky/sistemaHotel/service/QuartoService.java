package renan.daboitsky.sistemaHotel.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoRequest;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoResponse;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoUpdateRequest;
import renan.daboitsky.sistemaHotel.mapper.QuartoMapper;
import renan.daboitsky.sistemaHotel.model.Quarto;
import renan.daboitsky.sistemaHotel.repository.QuartoRepository;

import java.util.List;

@Service
public class QuartoService {

    private final QuartoRepository repository;
    private final QuartoMapper mapper;

    public QuartoService(QuartoRepository repository, QuartoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<QuartoResponse> listar() {
        return mapper.toResponseList(repository.findAll());
    }

    public QuartoResponse buscar(Long id) {
        return repository.findById(id).map(mapper::toResponse).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum cliente com esse ID"));
    }

    public QuartoResponse cadastrar(QuartoRequest request) {
        Quarto quarto = mapper.toEntity(request);

        return mapper.toResponse(repository.save(quarto));
    }

    public QuartoResponse atualizar(Long id, QuartoUpdateRequest request) {
        Quarto quarto = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum cliente com esse ID"));

        mapper.updateEntity(request, quarto);

        Quarto quartoAtualizado = repository.save(quarto);
        return mapper.toResponse(quartoAtualizado);
    }

    public void excluir(Long id) {
        Quarto quarto = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum cliente com esse ID"));

        repository.deleteById(id);
    }


}
