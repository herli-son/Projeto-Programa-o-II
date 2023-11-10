package Utilidades;

public class ToArray {
	/**
	 * Converte entidade Pessoa para uma lista de array de String
	 * @param pessoa - Pessoa que será convertida
	 * @return Dados da pessoa em Array
	 */
	public static String[] Pessoa(Entidades.Pessoa pessoa) {
		return new String[] {
				pessoa.acesso,
				pessoa.nome,
				pessoa.sobrenome,
				pessoa.senha,
                                pessoa.estabelecimentosVinculados, 
                                pessoa.servicosReservados,
                                pessoa.produtosReservados,
                                pessoa.funcionariosAvaliados,
                                pessoa.estabelecimentosAvaliados,
                                pessoa.produtosAvaliados,
                                pessoa.produtosAvaliados
		};
	}
}
