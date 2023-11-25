package Repositorio.Informacoes;

import Repositorio.Entidades.IDEntity;

public class IDInfo {
	public static final int TOTALCAMPOS = 6;
	public static IDEntity GetEntity(String[] array) {
		IDEntity ids = new IDEntity();
		ids.estabelecimento = array[0];
		ids.funcao = array[1];
		ids.avaliacao = array[2];
		ids.reserva = array[3];
		ids.produto = array[4];
		ids.servico = array[5];
		return ids;
	}
	public static String[] GetArray(IDEntity ids) {
		
		return new String[] {
				ids.estabelecimento ,
				ids.funcao ,
				ids.avaliacao ,
				ids.reserva ,
				ids.produto ,
				ids.servico ,
		};
		
	}
}
