package Utilidades;

public class Util {

    /**
     * Adiciona uma nova linha na matriz
     *
     * @param dado - Nova linha que será adicionada
     * @param dados - Matriz com todos os dados já existentes onde a linha a ser adicionada
     * @param campos - Quantidade de campos (colunas) que a matriz tem
     * @return Matriz com a nova linha
     */
    public static String[][] AdicionarDado(String[] dado, String[][] dados, int campos) {
        int i;
        String[][] aux = dados;
        dados = new String[dados.length + 1][campos];
        for (i = 0; i < aux.length; i++) {
            dados[i] = aux[i];
        }
        dados[i] = dado;
        return dados;
    }
}
