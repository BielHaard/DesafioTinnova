package br.com.desafio.tinnova.controller;

import br.com.desafio.tinnova.service.EleicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DesafiosController {

   public final EleicaoService eleicaoService;

    @Autowired
    public DesafiosController(EleicaoService eleicaoService) {
        this.eleicaoService = eleicaoService;
    }

    @GetMapping("/percentuais")
    public Map<String, Double> percentuais() {
        int totalEleitores = 1000;
        int votosValidos = 800;
        int votosBrancos = 150;
        int votosNulos = 50;

        Map<String, Double> percentuais = new HashMap<>();
        percentuais.put("validos", eleicaoService.percentualVotosValidos(totalEleitores, votosValidos));
        percentuais.put("brancos", eleicaoService.percentualVotosBrancos(totalEleitores, votosBrancos));
        percentuais.put("nulos", eleicaoService.percentualVotosNulos(totalEleitores, votosNulos));

        return percentuais;
    }

    @GetMapping("/bubbleSort")
    public int[] bubbleSort() {
        int[] vetor = {5, 3, 2, 4, 7, 1, 0, 6};
        int temp;

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }

        return vetor;
    }


    @GetMapping("/fatorial/{numero}")
    public ResponseEntity<Long> calcularFatorial(@PathVariable Long numero) {
        if (numero < 0) {
            return ResponseEntity.badRequest().build();
        }
        long resultado = 1;
        for (long i = numero; i >= 1; i--) {
            resultado *= i;
        }
        return ResponseEntity.ok(resultado);
    }
}

