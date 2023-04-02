package br.com.desafio.tinnova.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String veiculo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = false)
    private boolean vendido;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updated = LocalDateTime.now();

}
