package br.com.desafio.tinnova.repository;

import br.com.desafio.tinnova.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {


    List<Veiculo> findByMarcaAndAnoAndCor(String marca, Integer ano, String cor);

}
