package Controles;

import java.io.FileNotFoundException;
import java.io.IOException;

import Apresentacao.AcoesFuncionario;
import Apresentacao.Painel;
import Repositorio.Entidades.Avaliacao;
import Repositorio.Entidades.Estabelecimento;
import Repositorio.Entidades.Pessoa;
import Utilidades.Array;
import Utilidades.Globais;

public class Validacoes {
	/**
	 * Verifica se o valor passado existe no array
	 * 
	 * @param array - Lista de valores
	 * @param dado  - Valor a verificar
	 * @return Dado existe no array? True or False
	 */
	public static boolean InArray(String[] array, String dado) {
		for (String a : array) {
			if (a.equals(dado))
				return true;
		}
		return false;
	}

	/**
	 * Verifica se o valor passado existe no array
	 * 
	 * @param array - Lista de valores
	 * @param dado  - Valor a verificar
	 * @return Dado existe no array? True or False
	 */
	public static boolean InArray(char[] array, char dado) {
		for (char a : array) {
			if (a == dado)
				return true;
		}
		return false;
	}

	/**
	 * Verifica se a pessoa pode acessar com os dados passados
	 * 
	 * @param acesso - Acesso da pessoa
	 * @param senha  - Senha da pessoa
	 * @return Pode Acessar? True or False
	 */
	public static boolean AcessoPessoa(String acesso, String senha) {
		try {
			Pessoa pessoa = PessoaControl.Ler(acesso);
			if (pessoa.senha.equals(senha)) {
				Painel.Informar("Acesso autorizado!");
				Globais.Pessoa = pessoa;
				return true;
			} else {
				Painel.Erro("Acesso negado!");
				return false;
			}
		} catch (Exception e) {
			Painel.Erro("Não existe pessoa com esse acesso!");
			return false;
		}
	}

	/**
	 * Verifica se pode ou não cadastrar a pessoa
	 * 
	 * @param pessoa - Dados da pessoa que será cadastrada
	 * @return Pode cadastrar? True or False
	 */
	public static boolean CadastroPessoa(Pessoa pessoa) {

		if (TemEspecial(pessoa.acesso)) {
			Painel.Erro("O acessoa não deve ter caracteres especiais!");
			return false;
		}
		try {
			PessoaControl.Ler(pessoa.acesso);
			Painel.Erro("Já existe uma pessoa com o acesso " + pessoa.acesso);
			return false;
		} catch (Exception e) {
		}
		return true;
	}

	/**
	 * Verifica se pode acessar o estabelecimento
	 * 
	 * @param cnpj - acesso do estabelecimento
	 * @return Se o estabelecimento existe ou não
	 */
	public static boolean AcessoEstabelecimento(String cnpj) {
		try {
			Estabelecimento estabelecimento = Controles.EstabelecimentoControl.Ler(cnpj);
			Globais.Estabelecimento = estabelecimento;
			return true;
		} catch (Exception e) {
			Painel.Erro("Não existe estabelecimento com esse CNPJ");
			return false;
		}
	}

	/**
	 * 
	 * @param estabelecimento
	 * @return
	 */
	public static boolean CadastroEstabelecimento(Estabelecimento estabelecimento) {

		if (TemEspecial(estabelecimento.cnpj)) {
			Painel.Erro("O CNPJ não deve ter caracteres especiais!");
			return false;
		}
		try {
			EstabelecimentoControl.Ler(estabelecimento.cnpj);
			Painel.Erro("Já existe um estabelecimento com esse CNPJ" + estabelecimento.cnpj);
			return false;
		} catch (Exception e) {
		}
		return true;
	}

	public static boolean PodeDemitir() {
		String[] funcionarios = Array.Lista(Globais.Estabelecimento.funcionarios);
		if (funcionarios.length == 1) {
			Painel.Erro("Não é possível demitir pois esse é o único funcionário do estabelecimento");
			return false;
		}
		return true;

	}
	public static boolean PodeEscluirFuncao() throws FileNotFoundException, IOException {
		String[][] funcionarios = AcoesFuncionario.BuscarFuncionarios();
		String[] funcoesFuncionarios = new String[funcionarios.length];
		
		for (int i = 0; i < funcoesFuncionarios.length; i++) {
			funcoesFuncionarios[i] = funcionarios[i][3];
		}
		
		if(InArray(funcoesFuncionarios, Globais.Funcao.id)) {
			Painel.Erro("A função não pode ser excluida pois tstá sendo usada por algum funcionário!");
			return false;
		}
		
		return true;
		
	}
	public static boolean EFuncionario() throws FileNotFoundException, IOException {
		String[][] funcionarios = AcoesFuncionario.BuscarFuncionarios();
		String[] pessoas = new String[funcionarios.length];
		
		for (int i = 0; i < pessoas.length; i++) {
			pessoas[i] = funcionarios[i][1];
		}
		
		return Validacoes.InArray(pessoas, Globais.Pessoa.acesso);
	}
	/**
	 * Verifica se o texto passado possui caracteres especiais
	 * 
	 * @param texto - TExto a ser verificado
	 * @return Tem caractere especial? True or False
	 */
	private static boolean TemEspecial(String texto) {

		for (int i = 0; i < texto.length(); i++) {
			if (!InArray(Globais.CARACTERESVALIDOS, texto.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static boolean PodeAvaliar(Avaliacao avaliacao) throws FileNotFoundException, IOException {

		Avaliacao[] avaliacoes = AvaliacaoControl.LerTudo();
		String[] idsAva = Array.Lista(Globais.Pessoa.avaliacoes);
		for (Avaliacao ava : avaliacoes) {
			if(ava.avaliado.equals(avaliacao.avaliado) && ava.tipo.equals(avaliacao.tipo) && InArray(idsAva, ava.id)) {
				Painel.Erro("Essa avaliação já foi feita, procure na lista de avaliações e edite, se necessário.");
				return false;
			}
		}
		
		return true;
	}
}
