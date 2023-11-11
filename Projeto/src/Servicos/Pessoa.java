package Servicos;

import java.io.FileNotFoundException;
import java.io.IOException;
import Arquivos.Arquivo;
import Arquivos.Diretorio;
import Utilidades.Globais;
import Utilidades.ToArray;
import Utilidades.ToEntity;

public class Pessoa {
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
	public static void Criar(Entidades.Pessoa pessoa) throws IOException {
		Arquivo.Criar(arquivo(pessoa.acesso));
		Atualizar(pessoa);
	}
	/**
	 * Obtem dados de uma pessoa com determinado acesso
	 * @param acesso - Acesso da pessoa
	 * @return Dados da pessoa
	 * @throws FileNotFoundException A pessoa não foi encontrada
	 */
	public static Entidades.Pessoa Ler(String acesso) throws FileNotFoundException, IOException{
		String[] dados = Arquivo.Ler(arquivo(acesso), Globais.QTDCAMPOSPESSOAS);
		return ToEntity.Pessoa(dados);
	}
	/**
	 * Atualiza dados da pessoa
	 * @param pessoa - Pessoa que será atualizado e os dados dela
	 * @throws FileNotFoundException A pessoa não existe
	 */
	public static void Atualizar(Entidades.Pessoa pessoa) throws FileNotFoundException {
		Arquivo.Atualizar(arquivo(pessoa.acesso), ToArray.Pessoa(pessoa));
	}
	/**
	 * Exclui a pessoa 
	 * @param pessoa - Pessoa que será excluida
	 */
	public static void Deletar(Entidades.Pessoa pessoa) {
		Arquivo.Deletar(arquivo(pessoa.acesso));
	}
        /**
         * Retorna os campos da pessoa em uma lista com as informações passadas no Array
         * @param dados - Array com informações da pessoa montado usando o Utilidades.ToArray
         * @return Texto formatado com as informações da pessoa
         * @throws Exception As informações do Array passado foram insufucientes ou mais do que suficientes
         */
        public static String MontaDadosInfo(String[] dados) throws Exception{
            
            String info = "";
            
            if(dados.length < Globais.CAMPOSINFOPESSOAS.length)
                throw new Exception("A quantidade de campos informada está insuficiente!");
            
            if(dados.length > Globais.CAMPOSINFOPESSOAS.length)
                throw new Exception("A quantidade de campos informada está extrapolada!");
            
            for (int i = 0; i < dados.length; i++) {
                info += Globais.CAMPOSINFOPESSOAS[i] + ": " + dados[i] + "\n";
            }
            return info;
        }
}
