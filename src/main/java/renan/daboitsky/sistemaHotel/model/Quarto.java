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
    private TipoQuarto tipo;
    private Integer capacidade;
    private Double preco;
    private StatusQuarto status;

    @OneToMany(mappedBy = "quarto")
    private List<Reserva> reservas;
}
