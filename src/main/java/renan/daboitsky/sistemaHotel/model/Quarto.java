package renan.daboitsky.sistemaHotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import renan.daboitsky.sistemaHotel.enums.StatusQuarto;
import renan.daboitsky.sistemaHotel.enums.TipoQuarto;

import java.util.List;

@Builder
@Entity
@Table(name = "quarto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;

    @Enumerated(EnumType.STRING)
    private TipoQuarto tipo;

    private Integer capacidade;
    private Double preco;

    @Enumerated(EnumType.STRING)
    private StatusQuarto statusQuarto;

    @OneToMany(mappedBy = "quarto")
    private List<Reserva> reservas;
}
