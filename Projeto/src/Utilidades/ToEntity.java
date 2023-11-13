package Utilidades;

public class ToEntity {
	/**
	 * Converte array de String na entidade pessoa
	 * 
	 * @param array - Dados que serão convertidos
	 * @return Entidade Pessoa, quando passado o info array, retorna os campo de
	 *         lista vazios
	 */
	public static Entidades.Pessoa Pessoa(String[] array) {
		String[] info = { array[0], array[1], array[2], array[3] };
		return Pessoa(info, array);
	}

	/**
	 * Converte array de String na entidade pessoa
	 * 
	 * @param info  - Dados de informação sobre a entidade
	 * @param array - Dados que serão convertidos
	 * @return Entidade Pessoa, quando passado o info array, retorna os campo de
	 *         lista vazios
	 */
	public static Entidades.Pessoa Pessoa(String[] info, String[] array) {
		Entidades.Pessoa pessoa = new Entidades.Pessoa();

		pessoa.nome = info[0];
		pessoa.sobrenome = info[1];
		pessoa.acesso = info[2];
		pessoa.senha = info[3];

		if (array.length == 4) {
			pessoa.estabelecimentosVinculados = "";
			pessoa.servicosReservados = "";
			pessoa.produtosReservados = "";
			pessoa.funcionariosAvaliados = "";
			pessoa.estabelecimentosAvaliados = "";
			pessoa.produtosAvaliados = "";
			pessoa.servicosAvaliados = "";
		} else {
			pessoa.estabelecimentosVinculados = array[4];
			pessoa.servicosReservados = array[5];
			pessoa.produtosReservados = array[6];
			pessoa.funcionariosAvaliados = array[7];
			pessoa.estabelecimentosAvaliados = array[8];
			pessoa.produtosAvaliados = array[9];
			pessoa.servicosAvaliados = array[10];
		}
		return pessoa;
	}
}
