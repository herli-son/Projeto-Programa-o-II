package Repositorio.Informacoes;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controles.EstabelecimentoControl;
import Controles.FuncaoControl;
import Controles.PessoaControl;
import Repositorio.Entidades.Estabelecimento;
import Repositorio.Entidades.Funcao;
import Repositorio.Entidades.Funcionario;
import Repositorio.Entidades.Pessoa;

public class FuncionarioInfo {
	public static final int TOTALCAMPOS = 5;

	public static final String[] CAMPOS = { "ID", "Nome", "Funçao", "Estabelecimento"};
	/**
	 * 
	 */
	public static final int[] CAMPOSVISIVEIS = { 0, 1, 2 };
	public static final int[] CAMPOSIDENTIFICA = { 1, 2, 3 };
	/**
	 * 
	 */
	public static final int[] CAMPOSEDITAVEIS = { 2 };

	public static Funcionario GetEntity(String[] array) {
		Funcionario funcionario = new Funcionario();
		funcionario.id = array[0];
		funcionario.pessoa = array[1];
		funcionario.estabelecimento = array[2];
		funcionario.funcao = array[3];
		funcionario.avaliacoes = array[4];
		return funcionario;
	}

	public static String[] GetArray(Funcionario funcionario) {

		return new String[] { funcionario.id, funcionario.pessoa, funcionario.estabelecimento, funcionario.funcao, funcionario.avaliacoes };
	}

	public static String[][] GetListInfoArray(String[][] funcionario) throws FileNotFoundException, IOException {

		String[][] infos = new String[funcionario.length][CAMPOS.length];

		for (int i = 0; i < infos.length; i++) {
			Pessoa pessoa = new Pessoa();
			Funcao funcao = new Funcao();
			funcao = FuncaoControl.Ler(funcionario[i][3]);
			pessoa = PessoaControl.Ler(funcionario[i][1]);
			Estabelecimento estabelecimento = EstabelecimentoControl.Ler(funcionario[i][2]);
			infos[i][1] = pessoa.nome;
			infos[i][0] = funcionario[i][0];
			infos[i][2] = funcao.nome;
			infos[i][3] = estabelecimento.nome;
		}

		return infos;

	}
	
	public static String[][] GetListInfoArray(Funcionario[] funcionario) throws FileNotFoundException, IOException {

		String[][] infos = new String[funcionario.length][CAMPOS.length];

		for (int i = 0; i < infos.length; i++) {
			Pessoa pessoa = PessoaControl.Ler(funcionario[i].pessoa);
			Funcao funcao = FuncaoControl.Ler(funcionario[i].funcao);
			Estabelecimento estabelecimento = EstabelecimentoControl.Ler(funcionario[i].estabelecimento);
			infos[i][1] = pessoa.nome;
			infos[i][0] = funcionario[i].id;
			infos[i][2] = funcao.nome;
			infos[i][3] = estabelecimento.nome;
		}

		return infos;

	}
	public static Funcionario[] AdicionarFuncionarioLista(Funcionario[] funcionarios, Funcionario funcionario) {
		Funcionario[] aux = funcionarios;

		funcionarios = new Funcionario[funcionarios.length + 1];
	    int i;
	    for (i = 0; i < aux.length; i++) {
	    	funcionarios[i] = aux[i];
	    }
	    funcionarios[i] = funcionario;
	    return funcionarios;
	}
}
