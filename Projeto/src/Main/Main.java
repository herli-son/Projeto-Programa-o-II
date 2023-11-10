package Main;

import Apresentacao.Acoes;
import Servicos.Diretorio;

/**
 *
 * @author herli
 */
public class Main {
    public static void main(String[] args) {
    	Diretorio.CriarDiretorios();
        Acoes.Acesso();
    }
}
