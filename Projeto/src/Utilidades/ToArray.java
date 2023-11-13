package Utilidades;

public class ToArray {
	/**
	 * Converte entidade Pessoa para uma lista de array de String
	 * 
	 * @param pessoa - Pessoa que será convertida
	 * @return Dados da pessoa em Array
	 */
	public static String[] Pessoa(Entidades.Pessoa pessoa) {
		return new String[] { pessoa.nome, pessoa.sobrenome, pessoa.acesso, pessoa.senha,
				pessoa.estabelecimentosVinculados, pessoa.servicosReservados, pessoa.produtosReservados,
				pessoa.funcionariosAvaliados, pessoa.estabelecimentosAvaliados, pessoa.produtosAvaliados,
				pessoa.servicosAvaliados };
	}
	public static String[] InfoPessoa(Entidades.Pessoa pessoa) {
		return new String[] { pessoa.nome, pessoa.sobrenome, pessoa.acesso, pessoa.senha};
	}
	/**
	 * Transforma lista de string em array
	 * 
	 * @param lista - Lista de string corrente com itens separados por ,
	 * @return Array de string com itens da lista
	 */
	public static String[] Lista(String lista) {
		if (lista.equals(""))
			return new String[0];
		return lista.split(",");
	}

	/**
	 * Concatena dois arrays de strings
	 * 
	 * @param p - Primeiro array
	 * @param s - Segundo array
	 * @return Arrays concatenados
	 */
	public static String[] Concatena(String[] p, String[] s) {
		String[] concat = new String[p.length + s.length];
		int index = 0;

		for (String value : p) {
			concat[index] = value;
			index++;
		}

		for (String value : s) {
			concat[index] = value;
			index++;
		}

		return concat;
	}

	/**
	 * Retorna campos de uma entidade concatenados
	 * 
	 * @param dados  - Dados da entidade que será obtida as informações (INFO)
	 * @param campos - Campos que serão concatenados
	 * @return Texto resultante da concatenação
	 * @throws Exception O campo passado não existe no array
	 */
	public static String ConcatenarCampos(String[] dados, int[] campos) throws Exception {

		String texto = "";
		for (int index : campos) {
			if (index < 0 || index > dados.length - 1) {
				new Exception("O index do campo passado não existe. Campo: " + index);
			}
			texto += dados[index] + " - ";
		}

		texto = texto.substring(texto.length() - 3, texto.length());
		return texto;
	}

	/**
	 * Retorna lista de campos de uma entidade concatenados
	 * 
	 * @param dados  - Lista que será concatenada
	 * @param campos - Quais campos serão concatenados
	 * @return Array com campos concatenados
	 * @throws Exception O campo passado não existe no array
	 */
	public static String[] ConcatenarListaCampos(String[][] dados, int[] campos) throws Exception {
		String[] itens = new String[dados.length];

		for (int i = 0; i < dados.length; i++) {
			itens[i] = ConcatenarCampos(dados[i], campos);
		}
		return itens;
	}

	/**
	 * Converte um array de String em array de int
	 * 
	 * @param entrada - Array com número no formato string
	 * @return Array de inteiros convertidos a partir da entrada
	 * @throws Exception O valor na estrada não é número
	 */
	public static int[] StringToInt(String[] entrada) throws Exception {
		int[] saida = new int[entrada.length];
		for (int i = 0; i < saida.length; i++) {
			try {
				saida[i] = Integer.parseInt(entrada[i]);
			} catch (Exception e) {
				throw new Exception("O valor passado não é um número inteiro. Valor: " + entrada[i]);
			}
		}
		return saida;
	}
}
