package servidor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luisn
 */
public class Data {
    private static final int N_FILMES = 20;

    private static final int[][] avaliacoes = {
            {2, 1, 0, 3, 2, 0, 1, 0, 3, 2, 0, 0, 1, 3, 2, 0, 3, 2, 0, 1},
            {3, 2, 0, 0, 1, 2, 0, 1, 0, 3, 2, 3, 0, 0, 1, 2, 0, 1, 3, 2},
            {1, 0, 3, 2, 0, 0, 1, 2, 3, 0, 1, 0, 3, 2, 0, 0, 1, 2, 3, 0},
            {0, 1, 2, 0, 0, 3, 2, 0, 1, 0, 0, 1, 2, 0, 0, 3, 2, 0, 1, 0},
            {0, 0, 1, 0, 3, 2, 0, 0, 1, 2, 3, 0, 1, 0, 0, 2, 0, 1, 0, 3},
            {2, 0, 0, 1, 0, 3, 2, 0, 0, 1, 2, 3, 0, 0, 1, 0, 3, 2, 0, 0},
            {0, 3, 2, 0, 0, 1, 0, 3, 2, 0, 0, 1, 0, 3, 2, 0, 0, 1, 0, 3},
            {1, 0, 0, 1, 2, 0, 0, 1, 0, 3, 2, 0, 0, 1, 2, 0, 0, 1, 0, 3},
            {0, 1, 2, 3, 0, 0, 1, 2, 0, 0, 1, 0, 3, 2, 0, 0, 1, 2, 3, 0},
            {3, 0, 1, 0, 0, 2, 3, 0, 1, 0, 0, 1, 0, 2, 3, 0, 1, 0, 0, 1}
    };

    private static final Map<String, Integer> indiceUsuarioMapa = new HashMap<>();
    private static final Map<String, Integer> indiceFilmeMapa = new HashMap<>();
    
     static {

        indiceUsuarioMapa.put("Alice", 0);
        indiceUsuarioMapa.put("Bernardo", 1);
        indiceUsuarioMapa.put("Carla", 2);
        indiceUsuarioMapa.put("Daniel", 3);
        indiceUsuarioMapa.put("Eduarda", 4);
        indiceUsuarioMapa.put("Felipe", 5);
        indiceUsuarioMapa.put("Gustavo", 6);
        indiceUsuarioMapa.put("Helena", 7);
        indiceUsuarioMapa.put("Isabela", 8);
        indiceUsuarioMapa.put("João", 9);

        indiceFilmeMapa.put("A Origem", 0);
        indiceFilmeMapa.put("Interestelar", 1);
        indiceFilmeMapa.put("Gravidade", 2);
        indiceFilmeMapa.put("O Poderoso Chefão", 3);
        indiceFilmeMapa.put("Pulp Fiction", 4);
        indiceFilmeMapa.put("Clube da Luta", 5);
        indiceFilmeMapa.put("Forrest Gump", 6);
        indiceFilmeMapa.put("Cidade de Deus", 7);
        indiceFilmeMapa.put("Vingadores: Ultimato", 8);
        indiceFilmeMapa.put("O Senhor dos Anéis", 9);
        indiceFilmeMapa.put("Coringa", 10);
        indiceFilmeMapa.put("O Iluminado", 11);
        indiceFilmeMapa.put("Cisne Negro", 12);
        indiceFilmeMapa.put("Titanic", 13);
        indiceFilmeMapa.put("O Rei Leão", 14);
        indiceFilmeMapa.put("Harry Potter", 15);
        indiceFilmeMapa.put("O Labirinto do Fauno", 16);
        indiceFilmeMapa.put("Gladiador", 17);
        indiceFilmeMapa.put("O Quinto Elemento", 18);
        indiceFilmeMapa.put("E.T. - O Extraterrestre", 19);
    }
    
     
    protected static String processarRequisicao(String requisicao) {
        String[] partes = requisicao.split(";");
        
        int linhaUsuario = indiceUsuarioMapa.getOrDefault(partes[1], -1);
        if (linhaUsuario == -1) {
            return "Nome de usuário não existe!";
        }
        
        int opcao = Integer.parseInt(partes[0]);

        switch (opcao) {
            case 1:
                return filmesNaoAvaliados(partes[1]);
            case 2:
                return avaliarFilme(partes[1], partes[2], Integer.parseInt(partes[3]));
            case 3:
                return recomendarFilme(partes[1]);
            case 4:
                return listarAvaliacoes(partes[1]);
            default:
                return "Comando inválido!";
        }
    }

    private static String filmesNaoAvaliados(String nome) {
        int linhaUsuario = indiceUsuarioMapa.getOrDefault(nome, -1);

        StringBuilder filmesNaoAvaliados = new StringBuilder();
        for (int coluna = 0; coluna < N_FILMES; coluna++) {
            if (avaliacoes[linhaUsuario][coluna] == 0) {
                if (filmesNaoAvaliados.length() > 0) {
                    filmesNaoAvaliados.append("\n");
                }
                filmesNaoAvaliados.append(acharFilme(coluna));
            }
        }
        return filmesNaoAvaliados.toString();
    }

    private static String avaliarFilme(String nome, String nomeFilme, int nota) {
        int colunaFilme = indiceFilmeMapa.getOrDefault(nomeFilme, -1);
        int linhaUsuario = indiceUsuarioMapa.getOrDefault(nome, -1);

        if (colunaFilme != -1 && linhaUsuario != -1) {
            avaliacoes[linhaUsuario][colunaFilme] = nota;
        }
        return "Filme: " + nomeFilme + ", avaliado com sucesso!";
    }

    private static String recomendarFilme(String nome) {
        int linhaUsuario = indiceUsuarioMapa.getOrDefault(nome, -1);

        double menorDistancia = Double.MAX_VALUE;
        List<Integer> filmesRecomendados = new ArrayList<>();

        for (int coluna = 0; coluna < N_FILMES; coluna++) {
            if (avaliacoes[linhaUsuario][coluna] == 0) {
                double distancia = calcularDistancia(avaliacoes, linhaUsuario, coluna);
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    filmesRecomendados.clear();
                    filmesRecomendados.add(coluna);
                } else if (distancia == menorDistancia) {
                    filmesRecomendados.add(coluna);
                }
            }
        }

        if (!filmesRecomendados.isEmpty()) {
            StringBuilder recomendacoes = new StringBuilder();
            for (Integer indiceFilme : filmesRecomendados) {
                if (recomendacoes.length() > 0) {
                    recomendacoes.append("\n");
                }
                recomendacoes.append(acharFilme(indiceFilme));
            }
            return recomendacoes.toString();
        } else {
            return "Não há filmes para recomendar!";
        }
    }

    private static String listarAvaliacoes(String nome) {
        int linhaUsuario = indiceUsuarioMapa.getOrDefault(nome, -1);

        StringBuilder avaliacoesUsuario = new StringBuilder();
        for (int coluna = 0; coluna < N_FILMES; coluna++) {
            int avaliacao = avaliacoes[linhaUsuario][coluna];
            String filme = acharFilme(coluna);

            if (coluna == 0) {
                avaliacoesUsuario.append(filme).append(": ").append(avaliacao);
            } else {
                avaliacoesUsuario.append("\n").append(filme).append(": ").append(avaliacao);
            }
        }
        return avaliacoesUsuario.toString();
    }

    private static double calcularDistancia(int[][] matrizAvaliacoes, int linhaUsuario, int colunaFilme) {
        double distancia = 0;

        for (int i = 0; i < matrizAvaliacoes.length; i++) {
            if (i != linhaUsuario && matrizAvaliacoes[i][colunaFilme] != 0) {
                double diferenca = matrizAvaliacoes[linhaUsuario][colunaFilme] - matrizAvaliacoes[i][colunaFilme];
                distancia += diferenca * diferenca;
            }
        }
        return Math.sqrt(distancia);
    }

    private static String acharFilme(int coluna) {
        for (Map.Entry<String, Integer> entrada : indiceFilmeMapa.entrySet()) {
            if (entrada.getValue() == coluna) {
                return entrada.getKey();
            }
        }
        return "";
    }
}
