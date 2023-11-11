package Apresentacao;

public class Acoes {

    public static void Acesso() {
        boolean encerrar = false;
        while (!encerrar) {
            String op = Painel.Opcao(Menu.INICIO);
            switch (op) {
                case "1":
                    Pessoa.Acessar();
                    break;
                case "2":
                    Pessoa.Cadastrar();
                    break;
                case "3":
                    encerrar = true;
            }
        }
    }
}
