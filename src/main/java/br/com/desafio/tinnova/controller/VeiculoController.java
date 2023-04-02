package br.com.desafio.tinnova.controller;

import br.com.desafio.tinnova.service.VeiculoService;
import br.com.desafio.tinnova.entity.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<?> veiculosPorMarcaAnoCorOuSem(@RequestParam(value = "marca",  required = false) String marca,
                                                  @RequestParam(value = "ano", required = false) Integer ano,
                                                  @RequestParam(value = "cor", required = false) String cor) {

        List<Veiculo> veiculos;
        if (marca != null || ano != null || cor != null) {
            veiculos = veiculoService.veiculosPorMarcaAnoCor(marca, ano, cor);
        } else {
            veiculos  = veiculoService.todosOsVeiculos();
        }

        return ResponseEntity.ok().body(veiculos);
    }

    @PostMapping
    public ResponseEntity<?> salvarVeiculo(@RequestBody Veiculo veiculo) {
        try {
            Veiculo veiculoSalvo = veiculoService.salvarVeiculo(veiculo);
            return ResponseEntity.created(null).body(veiculoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizaCarro(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Veiculo veiculoAtualizado = veiculoService.atualizaCarro(id, veiculo);
        return ResponseEntity.ok().body(veiculoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  veiculoPorId(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.carroById(id);
        return ResponseEntity.ok().body(veiculo);
    }

    @PatchMapping("/{id}")
    public Veiculo atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        return veiculoService.atualizarVeiculo(id, veiculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity.HeadersBuilder<?> excluiVeiculo(@PathVariable Long id) {
        veiculoService.excluiVeiculo(id);
        return ResponseEntity.noContent();
    }

}
