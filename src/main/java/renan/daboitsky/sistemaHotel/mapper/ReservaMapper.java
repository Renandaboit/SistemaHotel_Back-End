package renan.daboitsky.sistemaHotel.mapper;

import org.springframework.stereotype.Component;
import renan.daboitsky.sistemaHotel.dto.reserva.ReservaRequest;
import renan.daboitsky.sistemaHotel.dto.reserva.ReservaResponse;
import renan.daboitsky.sistemaHotel.model.Reserva;

import java.util.List;

@Component
public class ReservaMapper {

    public Reserva toEntity (ReservaRequest request) {
        return Reserva.builder()
                .checkIn(request.checkIn())
                .checkOut(request.checkOut())
                .hospedes(request.hospedes())
                .build();
    }

    public ReservaResponse toResponse (Reserva reserva) {
        return new ReservaResponse(
                reserva.getId(),
                reserva.getCliente(),
                reserva.getQuarto(),
                reserva.getCheckIn(),
                reserva.getCheckOut(),
                reserva.getHospedes(),
                reserva.getValor()
        );
    }

    public List<ReservaResponse> toResponseList (List<Reserva> reservas) {
        return reservas.stream().map(this::toResponse).toList();
    }
}
