package renan.daboitsky.sistemaHotel.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import renan.daboitsky.sistemaHotel.dto.reserva.ReservaRequest;
import renan.daboitsky.sistemaHotel.dto.reserva.ReservaResponse;
import renan.daboitsky.sistemaHotel.mapper.ReservaMapper;
import renan.daboitsky.sistemaHotel.model.Reserva;
import renan.daboitsky.sistemaHotel.repository.ClienteRepository;
import renan.daboitsky.sistemaHotel.repository.QuartoRepository;
import renan.daboitsky.sistemaHotel.repository.ReservaRepository;

import java.util.List;

public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;
    private final QuartoRepository quartoRepository;
    private final ReservaMapper mapper;

    public ReservaService(ReservaRepository reservaRepository, ClienteRepository clienteRepository, QuartoRepository quartoRepository, ReservaMapper mapper) {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
        this.quartoRepository = quartoRepository;
        this.mapper = mapper;
    }

    public ReservaResponse cadastrar(ReservaRequest request) {
        Reserva reserva = mapper.toEntity(request);

        reserva.setCliente(clienteRepository.findById(request.clienteId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum cliente com esse ID")));
        reserva.setQuarto(quartoRepository.findById(request.quartoId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum quarto com esse ID")));
        reserva.setValor(reserva.getCheckIn().compareTo(reserva.getCheckOut()) * reserva.getQuarto().getPreco());

        return mapper.toResponse(reservaRepository.save(reserva));
    }

    public List<ReservaResponse> listar() {
        return mapper.toResponseList(reservaRepository.findAll());
    }

    public ReservaResponse buscar(Long id) {
        return mapper.toResponse(reservaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum cliente com esse ID")));
    }
}
