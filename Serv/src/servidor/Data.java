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
    private static final int N_USUARIOS = 10;
    
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
    
    /*
    private static final int[][] avaliacoes = {
            {3, 0},
            {2, 2},
            {1, 3}
    };
    */
    
    /*
    private static final int[][] avaliacoes = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    */
    
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
    
    /*
    static {    
            indiceUsuarioMapa.put("Zé", 0);
            indiceUsuarioMapa.put("Ana", 1);
            indiceUsuarioMapa.put("Martha", 2);

            indiceFilmeMapa.put("Tempos Modernos", 0);
            indiceFilmeMapa.put("Star Wars", 1);
    }
    */
     
    protected String processarRequisicao(String requisicao) {
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


    private String avaliarFilme(String nome, String nomeFilme, int nota) {
        int colunaFilme = indiceFilmeMapa.get(nomeFilme);
        int linhaUsuario = indiceUsuarioMapa.get(nome);
        
        avaliacoes[linhaUsuario][colunaFilme] = nota;
        
        return "Filme: " + nomeFilme + ", avaliado com sucesso!";
    }

    
    private String recomendarFilme(String nome) {
        int linhaUsuario = indiceUsuarioMapa.get(nome);
        int usuarioProximo = -1;
        double menorDistancia = Double.MAX_VALUE;
        List<Integer> filmeRecomendado = new ArrayList<>();
        
        exibirMatrizAvaliacoes();
        
        // encontrar o usuario mais proximo
        for (int usuario = 0; usuario < N_USUARIOS; usuario++){
            if (usuario != linhaUsuario) {
                double distancia = calcularDistancia(avaliacoes, linhaUsuario, usuario);
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    usuarioProximo = usuario;
                }
            }
        }
        System.out.println("\n [[FINAL]]: Usuario mais proximo: " + usuarioProximo + " distancia: " + menorDistancia + "\n");
        
        /* encontrar algum filme entre esses dois usuarios que o outro tenha
        avaliado positivamente (2 ou 3) e que o usuario que solicitou a recomendacao
        ainda nao tenha avaliado */
        for(int f = 0; f < N_FILMES; f++){
            if((avaliacoes[linhaUsuario][f] == 0) && (avaliacoes[usuarioProximo][f] > 1)){
                filmeRecomendado.clear();
                filmeRecomendado.add(f);
                break;
            }
        }
        
        if (!filmeRecomendado.isEmpty()) {
            StringBuilder recomendacoes = new StringBuilder();
            for (Integer indiceFilme : filmeRecomendado) {
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
    
     private void exibirMatrizAvaliacoes(){
        System.out.println();
        for (int i = 0; i < avaliacoes.length; i++) {
            for (int j = 0; j < avaliacoes[i].length; j++) {
                System.out.print(avaliacoes[i][j] + " ");
            } System.out.println();
        } System.out.println();
    }
    
    
    private double calcularDistancia(int[][] matriz, int linhaUsuario, int outroUsuario) {
        double total = 0;
        double distancia = 0;
        
        System.out.println("outroUsuario: " + outroUsuario + ":");
        
        for (int filme = 0; filme < N_FILMES; filme++) {
            double celula = Math.pow(matriz[linhaUsuario][filme] - matriz[outroUsuario][filme], 2);
            total = total + celula;
            //System.out.println("----------------------------------------------");
            //System.out.println("filme: " + filme);
            //System.out.println("(" + matriz[linhaUsuario][filme] + "-" + matriz[outroUsuario][filme] + ")^2 = " + celula);
            //System.out.println("total: " + total);
        }
        
        distancia = Math.sqrt(total);
        
        System.out.println("distancia: " + distancia);
        System.out.println("----------------------------------------------\n\n");
        
        return distancia;
    }
    
    
    private String listarAvaliacoes(String nome) {
        int linhaUsuario = indiceUsuarioMapa.get(nome);

        List<String> avaliacoesFilmes = new ArrayList<>();

        for (int coluna = 0; coluna < N_FILMES; coluna++) {
            int avaliacao = avaliacoes[linhaUsuario][coluna];
            if (avaliacao != 0) {
                String filme = acharFilme(coluna);
                avaliacoesFilmes.add(filme + ": " + avaliacao);
            }
        }

        if (avaliacoesFilmes.isEmpty()) {
            return "Não foram encontrados filmes avaliados pelo usuário.";
        }
        
        //Adicionando quebra de linha entre os elementos
        return String.join("\n", avaliacoesFilmes);
    }


    private String acharFilme(int coluna) {
        for (Map.Entry<String, Integer> entrada : indiceFilmeMapa.entrySet()) {
            if (entrada.getValue() == coluna) {
                return entrada.getKey();
            }
        }
        return "";
    }
    
    private String filmesNaoAvaliados(String nome) {
        int linhaUsuario = indiceUsuarioMapa.get(nome);

        List<String> filmesNaoAvaliados = new ArrayList<>();
        for (int coluna = 0; coluna < N_FILMES; coluna++) {
            if (avaliacoes[linhaUsuario][coluna] == 0) {
                filmesNaoAvaliados.add(acharFilme(coluna));
            }
        }

        if (filmesNaoAvaliados.isEmpty()) {
            return "Todos os filmes foram avaliados pelo usuário.";
        }
        
        //Adicionando quebra de linha entre os elementos
        return String.join("\n", filmesNaoAvaliados);
    }
    
   
}
