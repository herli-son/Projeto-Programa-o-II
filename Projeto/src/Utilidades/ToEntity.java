package Utilidades;

public class ToEntity {
	/**
	 * Converte array de String na entidade pessoa
 	 * @param array - Dados que serão convertidos
	 * @return ENtidade Pessoa
	 */
	public static Entidades.Pessoa Pessoa(String[] array) {
		Entidades.Pessoa pessoa = new Entidades.Pessoa();
		pessoa.acesso = array[0];
		pessoa.nome = array[1];
		pessoa.sobrenome = array[2];
		pessoa.senha = array[3];
                pessoa.estabelecimentosVinculados = array[4];
                pessoa.servicosReservados = array[5];
                pessoa.produtosReservados = array[6];
                pessoa.funcionariosAvaliados = array[7];
                pessoa.estabelecimentosAvaliados = array[8];
                pessoa.produtosAvaliados = array[9];
                pessoa.produtosAvaliados = array[10];
		return pessoa;
	}
}
