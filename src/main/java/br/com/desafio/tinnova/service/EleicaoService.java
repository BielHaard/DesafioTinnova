package br.com.desafio.tinnova.service;

import org.springframework.stereotype.Service;

@Service
public class EleicaoService {

    public double percentualVotosValidos(int totalEleitores, int votosValidos) {
        return (double) votosValidos / totalEleitores * 100;
    }

    public double percentualVotosBrancos(int totalEleitores, int votosBrancos) {
        return (double) votosBrancos / totalEleitores * 100;
    }

    public double percentualVotosNulos(int totalEleitores, int votosNulos) {
        return (double) votosNulos / totalEleitores * 100;
    }
}