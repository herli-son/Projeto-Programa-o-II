package Repositorio.Informacoes;

import Repositorio.Entidades.PessoaEntity;
/**
 * Informações da Pessoa
 */
public class PessoaInfo {
	/**
	 * Campos que contém as informações de uma pessoa <br>
	 * <b>0</b> - Nome <br>
	 * <b>1</b> - Sobrenome <br>
	 * <b>2</b> - Acesso <br>
	 * <b>3</b> - Senha
	 */
	public static final String[] CAMPOS = { "Nome", "Sobrenome", "Acesso", "Senha" };
	/**
	 * 
	 */
	public static final int[] CAMPOSVISIVEIS = { 0, 1, 2, 3 };
	/**
	 * 
	 */
	public static final int[] CAMPOSEDITAVEIS = { 0, 1, 3 };
	/**
	 * 
	 */
	public static final int[] CAMPOSACESSO = { 2, 3 };
	/**
	 * 
	 */
	public static final int TOTALCAMPOS = 11;
	/**
	 * Converte array de String na entidade pessoa
	 * 
	 * @param array - Dados que serão convertidos
	 * @return Entidade Pessoa, quando passado o info array, retorna os campo de
	 *         lista vazios
	 */
	public static PessoaEntity GetEntity(String[] array) {
		String[] info = { array[0], array[1], array[2], array[3] };
		return GetEntity(info, array);
	}

	/**
	 * Converte array de String na entidade pessoa
	 * 
	 * @param info  - Dados de informação sobre a entidade
	 * @param array - Dados que serão convertidos
	 * @return Entidade Pessoa, quando passado o info array, retorna os campo de
	 *         lista vazios
	 */
	public static PessoaEntity GetEntity(String[] info, String[] array) {
		PessoaEntity pessoa = new PessoaEntity();

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
	/**
	 * Converte entidade Pessoa para uma lista de array de String
	 * 
	 * @param pessoa - Pessoa que será convertida
	 * @return Dados da pessoa em Array
	 */
	public static String[] GetArray(PessoaEntity pessoa) {
		return new String[] { pessoa.nome, pessoa.sobrenome, pessoa.acesso, pessoa.senha,
				pessoa.estabelecimentosVinculados, pessoa.servicosReservados, pessoa.produtosReservados,
				pessoa.funcionariosAvaliados, pessoa.estabelecimentosAvaliados, pessoa.produtosAvaliados,
				pessoa.servicosAvaliados };
	}
	/**
	 * 
	 * @param pessoa
	 * @return
	 */
	public static String[] GetInfoArray(PessoaEntity pessoa) {
		return new String[] { pessoa.nome, pessoa.sobrenome, pessoa.acesso, pessoa.senha};
	}
	/**
	 * 
	 * @param pessoa
	 * @return
	 */
	public static String[] GetInfoArray(String[] pessoa) {
		return new String[] { pessoa[0], pessoa[1], pessoa[2], pessoa[3]};
	}
	/**
     * Cria uma cópia da pessoa
     * @param pessoa - Pessoa que será copiada
     * @return Cópia da pessoa
     */
    public static PessoaEntity Copiar(PessoaEntity pessoa){
    	PessoaEntity p = new PessoaEntity();
        p.acesso = pessoa.acesso;
        p.nome = pessoa.nome;
        p.sobrenome = pessoa.sobrenome;
        p.senha = pessoa.senha;
        p.estabelecimentosVinculados = pessoa.estabelecimentosVinculados; 
        p.servicosReservados = pessoa.servicosReservados;
        p.produtosReservados = pessoa.produtosReservados;
        p.funcionariosAvaliados = pessoa.funcionariosAvaliados;
        p.estabelecimentosAvaliados = pessoa.estabelecimentosAvaliados;
        p.produtosAvaliados = pessoa.produtosAvaliados;
        p.servicosAvaliados = pessoa.produtosAvaliados;
        return p;
    }
}
