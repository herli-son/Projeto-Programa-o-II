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
		return pessoa;
	}
}
