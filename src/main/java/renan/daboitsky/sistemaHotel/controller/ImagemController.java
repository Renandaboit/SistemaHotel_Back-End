package renan.daboitsky.sistemaHotel.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import renan.daboitsky.sistemaHotel.dto.imagem.ImagemRequest;
import renan.daboitsky.sistemaHotel.dto.imagem.ImagemResponse;
import renan.daboitsky.sistemaHotel.service.ImagemService;

import java.net.URI;
import java.util.List;

@RestController("sistemahotel/v1.0/imagem")
public class ImagemController {
    private ImagemService service;

    public ImagemController(ImagemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ImagemResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<ImagemResponse> cadastrar(@RequestBody ImagemRequest request) {
        ImagemResponse response = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response)
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
