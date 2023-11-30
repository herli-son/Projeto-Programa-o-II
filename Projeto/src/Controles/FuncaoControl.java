package Controles;

import java.io.FileNotFoundException;
import java.io.IOException;
import Repositorio.Entidades.Funcao;
import Repositorio.Entidades.ID;
import Repositorio.Informacoes.FuncaoInfo;
import Servicos.Arquivo;
import Servicos.Diretorio;
import Utilidades.Array;
import Utilidades.Globais;

public class FuncaoControl {
	private static String arquivo(String nome) {
		return Diretorio.Funcao() + "/" + nome + Arquivo.EXTENSAO;
	}
	
	public static ID Criar(Funcao funcao) throws IOException {
		
		ID ids = IDControl.Ler();
		funcao.id = ids.funcao;
		ids.funcao = String.valueOf(Integer.parseInt(ids.funcao) + 1);
		Arquivo.Criar(arquivo(funcao.id));
		Atualizar(funcao);	
		IDControl.Atualizar(ids);
		
		return ids;
	}
	
	public static Funcao Ler(String id) throws FileNotFoundException, IOException {
		String[] dados = Arquivo.Ler(arquivo(id), FuncaoInfo.TOTALCAMPOS);
		return FuncaoInfo.GetEntity(dados);
	}
	
	public static void Atualizar(Funcao funcao) throws FileNotFoundException {
		Arquivo.Atualizar(arquivo(funcao.id), FuncaoInfo.GetArray(funcao));
	}
	
	public static void Deletar(Funcao funcao) throws FileNotFoundException {
		
		String[] funcs = Array.Lista(Globais.Estabelecimento.funcoes);
		String[] funcsAux = new String[funcs.length - 1];
		Globais.Estabelecimento.funcoes = "";
		
		for (int i = 0, j = 0; i < funcs.length; i++) {
			if(!funcs[i].equals(funcao.id)) {
				funcsAux[j] = funcs[i];
				j++; 
			}
		}
		for (int i = 0; i < funcsAux.length; i++) {
			Globais.Estabelecimento.funcoes += funcsAux[i] + ",";
		}
		
		Globais.Estabelecimento.funcoes = Globais.Estabelecimento.funcoes.substring(0, Globais.Estabelecimento.funcoes.length() - 1);
		EstabelecimentoControl.Atualizar(Globais.Estabelecimento);
		
		Arquivo.Deletar(arquivo(funcao.id));
	}
}
