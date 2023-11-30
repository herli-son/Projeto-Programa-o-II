package Controles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import Repositorio.Entidades.ID;
import Repositorio.Informacoes.IDInfo;
import Servicos.Arquivo;
import Servicos.Diretorio;

public class IDControl {
	
	private static final String ARQUIVO = Diretorio.ID() + "/ID" + Arquivo.EXTENSAO;
	
	public static void Criar() throws IOException {
		File dir = new File(ARQUIVO);
		if (!dir.exists()) {
			Arquivo.Criar(ARQUIVO);
			
			ID id = new ID();
			id.estabelecimento = "0";
			id.avaliacao = "0";
			id.funcao = "0";
			id.reserva = "0";
			id.produto = "0";
			id.servico = "0";
			id.funcionario = "0";
			
			Atualizar(id);
		}
	}
	
	public static ID Ler() throws FileNotFoundException, IOException {
		String[] dados = Arquivo.Ler(ARQUIVO, IDInfo.TOTALCAMPOS);
		return IDInfo.GetEntity(dados);
	}
	
	public static void Atualizar(ID ids) throws FileNotFoundException {
		Arquivo.Atualizar(ARQUIVO, IDInfo.GetArray(ids));
	}
	
	public static void Deletar() {
		Arquivo.Deletar(ARQUIVO);
	}
}
