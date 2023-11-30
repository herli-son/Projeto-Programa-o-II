package Repositorio.Informacoes;

import Repositorio.Entidades.Funcao;

public class FuncaoInfo {
	/**
	*
	 */
	public static final String[] CAMPOS = { "ID", "Função", "Descrição", "Estabelecimento" };
	/**
	 * 
	 */
	public static final int[] CAMPOSVISIVEIS = { 0, 1, 2 };
	/**
	 * 
	 */
	public static final int[] CAMPOSEDITAVEIS = { 1, 2 };
	/** 
	 * 
	 */
	public static final int[] CAMPOSIDENTIFICAR = { 0, 1 };
	/**
	 * 
	 */
	public static final int TOTALCAMPOS = 4;

	public static Funcao GetEntity(String[] info) {
		Funcao funcao = new Funcao();

		funcao.id = info[0];
		funcao.nome = info[1];
		funcao.descricao = info[2];
		funcao.estabelecimento = info[3];

		return funcao;
	}

	public static String[] GetArray(Funcao funcao) {
		return new String[] { funcao.id, funcao.nome, funcao.descricao, funcao.estabelecimento };
	}

	public static Funcao Copiar(Funcao funcao) {
		Funcao f = new Funcao();
		f.id = funcao.id;
		f.nome = funcao.nome;
		f.estabelecimento = funcao.estabelecimento;
		f.descricao = funcao.descricao;
		return f;
	}

	public static String[][] GetListInfoArray(String[][] funcao) {

		String[][] infos = new String[funcao.length][CAMPOS.length];

		for (int i = 0; i < infos.length; i++) {
			infos[i] = GetArray(funcao[i]);
		}

		return infos;

	}

	public static String[][] GetListInfoArray(Funcao[] funcao) {

		String[][] infos = new String[funcao.length][CAMPOS.length];

		for (int i = 0; i < infos.length; i++) {
			infos[i] = GetArray(funcao[i]);
		}

		return infos;
	}
	/**
	 * 
	 * @param pessoa
	 * @return
	 */
	public static String[] GetArray(String[] pessoa) {
		return new String[] { pessoa[0], pessoa[1], pessoa[2], pessoa[3] };
	}
}
