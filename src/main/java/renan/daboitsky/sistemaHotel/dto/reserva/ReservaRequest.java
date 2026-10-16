package renan.daboitsky.sistemaHotel.dto.reserva;

import java.sql.Date;

public record ReservaRequest (
        Long clienteId,
        Long quartoId,
        Date checkIn,
        Date checkOut,
        Integer hospedes
)
{ }
