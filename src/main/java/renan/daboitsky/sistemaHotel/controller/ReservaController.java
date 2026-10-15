package renan.daboitsky.sistemaHotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import renan.daboitsky.sistemaHotel.dto.reserva.ReservaRequest;
import renan.daboitsky.sistemaHotel.dto.reserva.ReservaResponse;
import renan.daboitsky.sistemaHotel.service.ReservaService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("sistemahotel/v1.0/quarto")
public class ReservaController {
    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<ReservaResponse> cadastrar(@RequestBody ReservaRequest request) {
        ReservaResponse reserva = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reserva.id())
                .toUri();

        return ResponseEntity.created(uri).body(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
