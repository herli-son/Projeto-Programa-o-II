package Repositorio.Informacoes;

import Repositorio.Entidades.ID;

public class IDInfo {
	public static final int TOTALCAMPOS = 7;
	public static ID GetEntity(String[] array) {
		ID ids = new ID();
		ids.estabelecimento = array[0];
		ids.funcao = array[1];
		ids.avaliacao = array[2];
		ids.reserva = array[3];
		ids.produto = array[4];
		ids.servico = array[5];
		ids.funcionario = array[6];
		return ids;
	}
	public static String[] GetArray(ID ids) {
		
		return new String[] {
				ids.estabelecimento ,
				ids.funcao ,
				ids.avaliacao ,
				ids.reserva ,
				ids.produto ,
				ids.servico ,
				ids.funcionario
		};
	}
}
