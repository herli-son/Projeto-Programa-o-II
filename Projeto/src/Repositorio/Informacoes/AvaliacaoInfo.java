package Repositorio.Informacoes;

import Repositorio.Entidades.Avaliacao;
import Repositorio.Entidades.Funcionario;
import Repositorio.Entidades.Pessoa;

public class AvaliacaoInfo {
	public static final String[] CAMPOS = { "ID", "Avaliado", "Tipo",  "Comentário", "Nota"};
	public static final int[] CAMPOSVISIVEIS = { 0, 1, 2, 3, 4 };
	public static final int[] CAMPOSEDITAVEIS = { 3, 4 };
	public static final int[] CAMPOSIDENTIFICAR = { 2, 1 };
	public static final int TOTALCAMPOS = 5;
	
	public static Avaliacao GetEntity(String[] array) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.id = array[0];
		avaliacao.avaliado = array[1];
		avaliacao.tipo = array[2];
		avaliacao.comentario = array[3];
		avaliacao.nota = array[4];
		return avaliacao;
	}

	public static String[] GetArray(Avaliacao avaliacao) {

		return new String[] { avaliacao.id, avaliacao.avaliado, avaliacao.tipo, avaliacao.comentario, avaliacao.nota };
	}
	public static String[] GetArray(String[] avaliacao) {

		return new String[] { avaliacao[0], avaliacao[1], avaliacao[2], avaliacao[3], avaliacao[4] };
	}
	
	public static String[][] GetListInfoArray(String[][] avaliacao) {

		String[][] infos = new String[avaliacao.length][CAMPOS.length];

		for (int i = 0; i < infos.length; i++) {
			infos[i] = GetArray(avaliacao[i]);
		}

		return infos;

	}

	public static String[][] GetListInfoArray(Avaliacao[] avaliacao) {

		String[][] infos = new String[avaliacao.length][CAMPOS.length];

		for (int i = 0; i < infos.length; i++) {
			infos[i] = GetArray(avaliacao[i]);
		}

		return infos;
	}
	public static Avaliacao[] AdicionarAvaliacaoLista(Avaliacao[] avaliacoes, Avaliacao avaliacao) {
		Avaliacao[] aux = avaliacoes;

		avaliacoes = new Avaliacao[avaliacoes.length + 1];
	    int i;
	    for (i = 0; i < aux.length; i++) {
	    	avaliacoes[i] = aux[i];
	    }
	    avaliacoes[i] = avaliacao;
	    return avaliacoes;
	}
	public static Avaliacao Copiar(Avaliacao avaliacao){
		Avaliacao a = new Avaliacao();
        a.id = avaliacao.id;
        a.avaliado = avaliacao.avaliado;
        a.tipo = avaliacao.tipo;
        a.comentario = avaliacao.comentario;
        a.nota = avaliacao.nota; 

        return a;
    }
}
