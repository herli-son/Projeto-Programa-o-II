package Repositorio.Informacoes;

import Repositorio.Entidades.EstabelecimentoEntity;

public class EstabelecimentoInfo {
	/**
	 * Campos que contém as informações de um estabelecimento <br>
	 * <b>0<b> - ID <br>
	 * <b>1<b> - Nome <br>
	 * <b>2<b> - CNPJ <br>
	 * <b>3<b> - Descrição <br>
	 * <b>4<b> - Abertura <br>
	 * <b>5<b> - Fechamento <br>
	 */
	public static final String[] CAMPOS = {"ID", "Nome", "CNPJ", "Descrição", "Abertura", "Fechamento" };
	/**
	 * 
	 */
	public static final int[] CAMPOSVISIVEIS = { 0, 1, 2, 3, 4, 5 };
	/**
	 * 
	 */
	public static final int[] CAMPOSEDITAVEIS = { 1, 3, 4, 5 };
	/**
	 * 
	 */
	public static final int[] CAMPOSIDENTIFICAR = { 0, 1};
	/**
	 * 
	 */
	public static final int TOTALCAMPOS = 13;
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static EstabelecimentoEntity GetEntity(String[] array) {
		String[] info = { array[0], array[1], array[2], array[3], array[4], array[5]};
		return GetEntity(info, array);
	}
	/**
	 * 
	 * @param info
	 * @param array
	 * @return
	 */
	public static EstabelecimentoEntity GetEntity(String[] info, String[] array) {
		EstabelecimentoEntity estabelecimento = new EstabelecimentoEntity();
		
		estabelecimento.id = info[0];
		estabelecimento.nome = info[1];
		estabelecimento.cnpj = info[2];
		estabelecimento.descricao = info[3];
		estabelecimento.abertura = info[4];
		estabelecimento.fechamento = info[5];

		if (array.length == 6) {
			estabelecimento.funcoes = "";
			estabelecimento.avaliacoes = "";
			estabelecimento.servicos = "";
			estabelecimento.produtos = "";
			estabelecimento.funcionarios = "";
			estabelecimento.servicosReservados = "";
			estabelecimento.produtosReservados = "";
		} else {
			estabelecimento.funcoes = array[6];
			estabelecimento.avaliacoes = array[7];
			estabelecimento.servicos = array[8];
			estabelecimento.produtos = array[9];
			estabelecimento.funcionarios = array[10];
			estabelecimento.servicosReservados = array[11];
			estabelecimento.produtosReservados = array[12];
		}
		return estabelecimento;
	}
	/**
	 * Converte entidade Estabelecimento para uma lista de array de String
	 * 
	 * @param estabelecimento - estabelecimento que será convertido
	 * @return Dados do estabelecimento em array
	 */
	public static String[] GetArray(EstabelecimentoEntity estabelecimento) {
		return new String[] { estabelecimento.id, estabelecimento.nome, estabelecimento.cnpj, estabelecimento.descricao,
				estabelecimento.abertura, estabelecimento.fechamento, estabelecimento.funcoes,
				estabelecimento.avaliacoes, estabelecimento.servicos, estabelecimento.produtos,
				estabelecimento.funcionarios, estabelecimento.servicosReservados, estabelecimento.produtosReservados };
	}
	/**
	 * 
	 * @param estabelecimento
	 * @return
	 */
	public static String[] GetInfoArray(EstabelecimentoEntity estabelecimento) {
		return new String[] { estabelecimento.id,  estabelecimento.nome, estabelecimento.cnpj, estabelecimento.descricao,
				estabelecimento.abertura, estabelecimento.fechamento };
	}
	/**
	 * 
	 * @param estabelecimento
	 * @return
	 */
	public static String[] GetInfoArray(String[] estabelecimento) {
		return new String[] { estabelecimento[0], estabelecimento[1], estabelecimento[2],
				estabelecimento[3], estabelecimento[4], estabelecimento[5] };
	}
	public static String[][] GetListInfoArray(String[][] estabelecimentos) {
		
		String[][] infos = new String[estabelecimentos.length][CAMPOS.length];
		
		for (int i = 0; i < infos.length; i++) {
			infos[i] = GetInfoArray(estabelecimentos[i]);
		}
		
		return infos;
		
	}
	/**
	 * 
	 * @param estabelecimento
	 * @return
	 */
	public static EstabelecimentoEntity Copiar(EstabelecimentoEntity estabelecimento){
		EstabelecimentoEntity e = new EstabelecimentoEntity();
		e.id = estabelecimento.id;
    	e.nome = estabelecimento.nome;
    	e.cnpj = estabelecimento.cnpj;
    	e.descricao = estabelecimento.descricao;
    	e.abertura = estabelecimento.abertura;
    	e.fechamento = estabelecimento.fechamento;
    	e.funcoes = estabelecimento.funcoes;
    	e.avaliacoes = estabelecimento.avaliacoes;
    	e.servicos = estabelecimento.servicos;
    	e.produtos = estabelecimento.produtos;
    	e.funcionarios = estabelecimento.funcionarios;
    	e.servicosReservados = estabelecimento.servicosReservados;
    	e.produtosReservados = estabelecimento.produtosReservados;
    	return e;
    }
}
