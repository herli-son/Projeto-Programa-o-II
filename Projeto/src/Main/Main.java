package Main;

import Apresentacao.Acoes;
import Arquivos.Diretorio;
import javax.swing.JOptionPane;

/**
 *
 * @author herli
 */
public class Main {

    public static void main(String[] args) {
        try {
            Diretorio.CriarDiretorios();
            Acoes.Acesso();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }
}
