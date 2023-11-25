package Main;

import Apresentacao.Acoes;
import Controles.IDControl;
import Servicos.Diretorio;

import javax.swing.JOptionPane;

/**
 *
 * @author herli
 */
public class Main {

    public static void main(String[] args) {
        try {
            Diretorio.CriarDiretorios();
            IDControl.Criar();
            Acoes.Acesso();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }
}
