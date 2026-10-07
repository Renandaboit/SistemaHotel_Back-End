package renan.daboitsky.sistemaHotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoRequest;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoResponse;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoUpdateRequest;
import renan.daboitsky.sistemaHotel.service.QuartoService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("sistemahotel/v1.0/quarto")
public class QuartoController {

    private final QuartoService service;

    public QuartoController(QuartoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<QuartoResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<QuartoResponse> cadastrar(@RequestBody QuartoRequest request) {
        QuartoResponse quarto = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(quarto.id())
                .toUri();

        return ResponseEntity.created(uri).body(quarto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoResponse> atualizar(@PathVariable Long id, @RequestBody QuartoUpdateRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
