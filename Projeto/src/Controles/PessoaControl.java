package Controles;

import java.io.FileNotFoundException;
import java.io.IOException;

import Repositorio.Entidades.Pessoa;
import Repositorio.Informacoes.PessoaInfo;
import Servicos.Arquivo;
import Servicos.Diretorio;

public class PessoaControl {
	/**
	 * Diretório criado para armazenar a pessoa.<br>
	 * O acesso é a chave primária, por isso ele é criado com esse nome
	 * @param nome - Nome do arquivo criado
	 * @return Diretório
	 */
	private static String arquivo(String nome) {
		return Diretorio.Pessoas() + "/" + nome + Arquivo.EXTENSAO;
	}
	/**
	 * Cria um arquivo novo para pessoa e insere os dados da pessoa
	 * @param pessoa - Dados da pessoa que serão inseridos
	 * @throws IOException Não conseguiu criar o arquivo
	 */
	public static void Criar(Pessoa pessoa) throws IOException {
		Arquivo.Criar(arquivo(pessoa.acesso));
		Atualizar(pessoa);
	}
	/**
	 * Obtem dados de uma pessoa com determinado acesso
	 * @param acesso - Acesso da pessoa
	 * @return Dados da pessoa
	 * @throws FileNotFoundException A pessoa não foi encontrada
	 */
	public static Pessoa Ler(String acesso) throws FileNotFoundException, IOException{
		String[] dados = Arquivo.Ler(arquivo(acesso), PessoaInfo.TOTALCAMPOS);
		return PessoaInfo.GetEntity(dados);
	}

	
	public static Pessoa[] LerTodos(String[] naoBuscar) throws FileNotFoundException, IOException{
		Pessoa[] listaPessoa = new Pessoa[0];
		String[][] pessoas = Arquivo.LerTodos(Diretorio.Pessoas(), PessoaInfo.TOTALCAMPOS);
		
		for (int i = 0; i < pessoas.length; i++) {
			if(!Validacoes.InArray(naoBuscar, pessoas[i][2]))
				listaPessoa = PessoaInfo.AdicionarPessoaLista(listaPessoa, PessoaInfo.GetEntity(pessoas[i]));
		}
		
		return listaPessoa;
	}

	/**
	 * Atualiza dados da pessoa
	 * @param pessoa - Pessoa que será atualizado e os dados dela
	 * @throws FileNotFoundException A pessoa não existe
	 */
	public static void Atualizar(Pessoa pessoa) throws FileNotFoundException {
		Arquivo.Atualizar(arquivo(pessoa.acesso), PessoaInfo.GetArray(pessoa));
	}
	/**
	 * Exclui a pessoa 
	 * @param pessoa - Pessoa que será excluida
	 */
	public static void Deletar(Pessoa pessoa) {
		Arquivo.Deletar(arquivo(pessoa.acesso));
	}
}
