package renan.daboitsky.sistemaHotel.dto.reserva;

import renan.daboitsky.sistemaHotel.dto.cliente.ClienteResponse;
import renan.daboitsky.sistemaHotel.dto.quarto.QuartoResponse;

import java.sql.Date;

public record ReservaResponse (

        Long id,
        ClienteResponse cliente,
        QuartoResponse quarto,
        Date checkIn,
        Date checkOut,
        Integer hospedes,
        Double valor
) {}
