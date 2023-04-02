package br.com.desafio.tinnova.service;


import br.com.desafio.tinnova.entity.Veiculo;
import br.com.desafio.tinnova.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo carroById(Long id) {
        Optional<Veiculo> veiculoPorId = veiculoRepository.findById(id);
        return veiculoPorId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encontrar o véiculo, Id" + id ));
    }

    public Veiculo atualizaCarro(Long id, Veiculo veiculo) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);
        if (veiculoExistente.isPresent()) {
            Veiculo atualizaVeiculo = veiculoExistente.get();
            atualizaVeiculo.setVeiculo(veiculo.getVeiculo());
            atualizaVeiculo.setMarca(veiculo.getMarca());
            atualizaVeiculo.setAno(veiculo.getAno());
            atualizaVeiculo.setDescricao(veiculo.getDescricao());
            atualizaVeiculo.setVendido(veiculo.isVendido());
            atualizaVeiculo.setUpdated(LocalDateTime.now());

            return veiculoRepository.save(atualizaVeiculo);

        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível atualizar o véiculo, Id" + id + "Não encontrado");
        }

    }

    @GetMapping
    public List<Veiculo> todosOsVeiculos() {
        List<Veiculo> todosOsVeiculos = veiculoRepository.findAll();
        if (todosOsVeiculos.isEmpty()) {
             throw new ResponseStatusException(HttpStatus.NO_CONTENT, "A lista de carros está vazia");
        }
        return todosOsVeiculos;
    }


    public List<Veiculo> veiculosPorMarcaAnoCor(String marca, Integer ano, String cor) {
        List<Veiculo>veiculos = veiculoRepository.findByMarcaAndAnoAndCor(marca, ano, cor);
        System.out.println(veiculos);
        if (veiculos.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "A Busca retornou vazia");
        }
        return veiculos;
    }

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizarVeiculo(Long id, Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível atualizar o véiculo, Id" + id + "Não encontrado");
        } else {

            Veiculo veiculo = veiculoOptional.get();
            if (veiculoAtualizado.getVeiculo() != null) {
                veiculo.setVeiculo(veiculoAtualizado.getVeiculo());
            }
            if (veiculoAtualizado.getMarca() != null) {
                veiculo.setMarca(veiculoAtualizado.getMarca());
            }
            if (veiculoAtualizado.getAno() != null) {
                veiculo.setAno(veiculoAtualizado.getAno());
            }
            if (veiculoAtualizado.getCor() != null) {
                veiculo.setCor(veiculoAtualizado.getCor());
            }
            if (veiculoAtualizado.getDescricao() != null) {
                veiculo.setDescricao(veiculoAtualizado.getDescricao());
            }
            if (veiculoAtualizado.isVendido()) {
                veiculo.setVendido(true);
            }
            veiculo.setUpdated(LocalDateTime.now());
            veiculoRepository.save(veiculo);

            return veiculo;

        }
    }

    public ResponseEntity.HeadersBuilder<?> excluiVeiculo (Long id) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível atualizar o véiculo, Id" + id + "Não encontrado");
        } else {
            veiculoRepository.deleteById(id);
            return ResponseEntity.noContent();
        }
    }
}