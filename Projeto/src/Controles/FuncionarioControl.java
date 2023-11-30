package Controles;

import java.io.FileNotFoundException;
import java.io.IOException;

import Repositorio.Entidades.Funcionario;
import Repositorio.Entidades.ID;
import Repositorio.Entidades.Pessoa;
import Repositorio.Informacoes.FuncionarioInfo;
import Servicos.Arquivo;
import Servicos.Diretorio;
import Utilidades.Array;
import Utilidades.Globais;

public class FuncionarioControl {
	private static String arquivo(String nome) {
		return Diretorio.Funcionario() + "/" + nome + Arquivo.EXTENSAO;
	}	
	public static ID Criar(Funcionario funcionario) throws IOException {
		
		ID ids = IDControl.Ler();
		funcionario.id = ids.funcionario;
		ids.funcionario = String.valueOf(Integer.parseInt(ids.funcionario) + 1);
		Arquivo.Criar(arquivo(funcionario.id));
		Atualizar(funcionario);	
		IDControl.Atualizar(ids);
		return ids;
	}
	
	public static Funcionario Ler(String id) throws FileNotFoundException, IOException {
		String[] dados = Arquivo.Ler(arquivo(id), FuncionarioInfo.TOTALCAMPOS);
		return FuncionarioInfo.GetEntity(dados);
	}
	
	public static Funcionario[] LerTodos() throws FileNotFoundException, IOException {
		Funcionario[] listaFuncionario = new Funcionario[0];
		String[][] funcionario = Arquivo.LerTodos(Diretorio.Funcionario(), FuncionarioInfo.TOTALCAMPOS);
		
		for (int i = 0; i < funcionario.length; i++) {
			listaFuncionario = FuncionarioInfo.AdicionarFuncionarioLista(listaFuncionario, FuncionarioInfo.GetEntity(funcionario[i]));
		}
		
		return listaFuncionario;
	}
	
	public static void Atualizar(Funcionario funcionario) throws FileNotFoundException {
		Arquivo.Atualizar(arquivo(funcionario.id), FuncionarioInfo.GetArray(funcionario));
	}
	
	public static void Deletar(Funcionario funcionario) {
		Arquivo.Deletar(arquivo(funcionario.id));
	}
	public static void Contratar(Funcionario funcionario) throws FileNotFoundException {
		Globais.Estabelecimento.funcionarios += (Globais.Estabelecimento.funcionarios.equals("") ? "" : ",") + funcionario.id;
		EstabelecimentoControl.Atualizar(Globais.Estabelecimento);
	}
	public static void Demitir(Funcionario funcionario) throws IOException {
		String[] funcs = Array.Lista(Globais.Estabelecimento.funcionarios);
		String[] funcsAux = new String[funcs.length - 1];
		Globais.Estabelecimento.funcionarios = "";
		
		for (int i = 0, j = 0; i < funcs.length; i++) {
			if(!funcs[i].equals(funcionario.id)) {
				funcsAux[j] = funcs[i];
				j++; 
			}
		}
		for (int i = 0; i < funcsAux.length; i++) {
			Globais.Estabelecimento.funcionarios += funcsAux[i] + ",";
		}
		
		Globais.Estabelecimento.funcionarios = Globais.Estabelecimento.funcionarios.substring(0, Globais.Estabelecimento.funcionarios.length() - 1);
		EstabelecimentoControl.Atualizar(Globais.Estabelecimento);
		
		Pessoa pessoa = PessoaControl.Ler(funcionario.pessoa);
		funcs = Array.Lista(pessoa.estabelecimentosVinculados);
		funcsAux = new String[funcs.length - 1];
		
		for (int i = 0, j = 0; i < funcs.length; i++) {
			if(!funcs[i].equals(Globais.Estabelecimento.id)) {
				funcsAux[j] = funcs[i];
				j++; 
			}
		}
		for (int i = 0; i < funcsAux.length; i++) {
			pessoa.estabelecimentosVinculados += funcsAux[i] + ",";
		}
		pessoa.estabelecimentosVinculados = pessoa.estabelecimentosVinculados.substring(0, pessoa.estabelecimentosVinculados.length() - 1);
		PessoaControl.Atualizar(pessoa);
		
		Deletar(funcionario);
	}
}
