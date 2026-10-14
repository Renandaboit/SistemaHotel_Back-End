package renan.daboitsky.sistemaHotel.dto.reserva;

import jakarta.persistence.*;
import renan.daboitsky.sistemaHotel.model.Cliente;
import renan.daboitsky.sistemaHotel.model.Quarto;

import java.sql.Date;

public record ReservaRequest (
        Long clienteId,
        Long quartoId,
        Date checkIn,
        Date checkOut,
        Integer hospedes
)
{ }
