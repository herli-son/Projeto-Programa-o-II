package Repositorio.Informacoes;

import Repositorio.Entidades.Pessoa;
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
	public static final int[] CAMPOSIDENTIFICAR = { 2, 0 };
	/**
	 * 
	 */
	public static final int TOTALCAMPOS = 8;
	/**
	 * Converte array de String na entidade pessoa
	 * 
	 * @param array - Dados que serão convertidos
	 * @return Entidade Pessoa, quando passado o info array, retorna os campo de
	 *         lista vazios
	 */
	public static Pessoa GetEntity(String[] array) {
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
	public static Pessoa GetEntity(String[] info, String[] array) {
		Pessoa pessoa = new Pessoa();

		pessoa.nome = info[0];
		pessoa.sobrenome = info[1];
		pessoa.acesso = info[2];
		pessoa.senha = info[3];

		if (array.length == 4) {
			pessoa.estabelecimentosVinculados = "";
			pessoa.servicosReservados = "";
			pessoa.produtosReservados = "";
			pessoa.avaliacoes = "";
		} else {
			pessoa.estabelecimentosVinculados = array[4];
			pessoa.servicosReservados = array[5];
			pessoa.produtosReservados = array[6];
			pessoa.avaliacoes = array[7];
		}
		return pessoa;
	}
	/**
	 * Converte entidade Pessoa para uma lista de array de String
	 * 
	 * @param pessoa - Pessoa que será convertida
	 * @return Dados da pessoa em Array
	 */
	public static String[] GetArray(Pessoa pessoa) {
		return new String[] { pessoa.nome, pessoa.sobrenome, pessoa.acesso, pessoa.senha,
				pessoa.estabelecimentosVinculados, pessoa.servicosReservados, pessoa.produtosReservados,
				pessoa.avaliacoes};
	}
	/**
	 * 
	 * @param pessoa
	 * @return
	 */
	public static String[] GetInfoArray(Pessoa pessoa) {
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
    public static Pessoa Copiar(Pessoa pessoa){
    	Pessoa p = new Pessoa();
        p.acesso = pessoa.acesso;
        p.nome = pessoa.nome;
        p.sobrenome = pessoa.sobrenome;
        p.senha = pessoa.senha;
        p.estabelecimentosVinculados = pessoa.estabelecimentosVinculados; 
        p.servicosReservados = pessoa.servicosReservados;
        p.produtosReservados = pessoa.produtosReservados;
        p.avaliacoes = pessoa.avaliacoes;
        return p;
    }
public static String[][] GetListInfoArray(String[][] pessoas) {
		
		String[][] infos = new String[pessoas.length][CAMPOS.length];
		
		for (int i = 0; i < infos.length; i++) {
			infos[i] = GetInfoArray(pessoas[i]);
		}
		
		return infos;
		
	}
public static String[][] GetListInfoArray(Pessoa[] pessoas) {
	
	String[][] infos = new String[pessoas.length][CAMPOS.length];
	
	for (int i = 0; i < infos.length; i++) {
		infos[i] = GetInfoArray(pessoas[i]);
	}
	
	return infos;
	
}
public static Pessoa[] AdicionarPessoaLista(Pessoa[] pessoas, Pessoa pessoa) {
	Pessoa[] aux = pessoas;

	pessoas = new Pessoa[pessoas.length + 1];
    int i;
    for (i = 0; i < aux.length; i++) {
    	pessoas[i] = aux[i];
    }
    pessoas[i] = pessoa;
    return pessoas;
}
}
