package renan.daboitsky.sistemaHotel.dto.reserva;

import jakarta.persistence.*;
import renan.daboitsky.sistemaHotel.model.Cliente;
import renan.daboitsky.sistemaHotel.model.Quarto;

import java.sql.Date;

public record ReservaResponse (

        Long id,
        Cliente cliente,
        Quarto quarto,
        Date checkIn,
        Date checkOut,
        Integer hospedes,
        Double valor
) {}
