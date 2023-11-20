package Servicos;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controles.Arquivo;
import Controles.Diretorio;
import Utilidades.Globais;
import Utilidades.ToArray;
import Utilidades.ToEntity;

public class Estabelecimento {

	private static final int qtdCamposEstabelecimento = 12; 
	
	private static String arquivo(String nome) {
		return Diretorio.Estabelecimento() + "/" + nome + Arquivo.EXTENSAO;
	}
	
	public static void Criar(Entidades.Estabelecimento estabelecimento) throws IOException {
		Arquivo.Criar(arquivo(estabelecimento.cnpj));
		Atualizar(estabelecimento);	
	}
	
	public static Entidades.Estabelecimento Ler(String cnpj) throws FileNotFoundException, IOException {
		String[] dados = Arquivo.Ler(arquivo(cnpj), qtdCamposEstabelecimento);
		return ToEntity.Estabelecimento(dados);
	}
	
	public static void Atualizar(Entidades.Estabelecimento estabelecimento) throws FileNotFoundException {
		Arquivo.Atualizar(arquivo(estabelecimento.cnpj), ToArray.Estabelecimento(estabelecimento));
	}
	
	public static void Deletar(Entidades.Estabelecimento estabelecimento) {
		Arquivo.Deletar(arquivo(estabelecimento.cnpj));
	}
	
	public static void VincularPessoa(String cnpj) throws FileNotFoundException {
		Globais.PessoaLogada.estabelecimentosVinculados += (Globais.PessoaLogada.estabelecimentosVinculados.equals("") ? "" : ",") + cnpj;
		Servicos.Pessoa.Atualizar(Globais.PessoaLogada);
	}
}
