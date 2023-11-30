package Controles;

import java.io.FileNotFoundException;
import java.io.IOException;

import Repositorio.Entidades.Avaliacao;
import Repositorio.Entidades.Estabelecimento;
import Repositorio.Entidades.Funcionario;
import Repositorio.Entidades.ID;
import Repositorio.Informacoes.AvaliacaoInfo;
import Servicos.Arquivo;
import Servicos.Diretorio;
import Utilidades.Globais;

public class AvaliacaoControl {
	private static String arquivo(String nome) {
		return Diretorio.Avaliacao() + "/" + nome + Arquivo.EXTENSAO;
	}

	public static void Criar(Avaliacao avaliacao) throws IOException {

		ID ids = IDControl.Ler();
		avaliacao.id = ids.avaliacao;
		Arquivo.Criar(arquivo(avaliacao.id));
		VincularAvaliacao(avaliacao);
		ids.avaliacao = String.valueOf(Integer.parseInt(ids.avaliacao) + 1);
		Atualizar(avaliacao);
		IDControl.Atualizar(ids);
	}

	public static Avaliacao Ler(String id) throws FileNotFoundException, IOException {
		String[] dados = Arquivo.Ler(arquivo(id), AvaliacaoInfo.TOTALCAMPOS);
		return AvaliacaoInfo.GetEntity(dados);
	}
	public static Avaliacao[] LerTudo() throws FileNotFoundException, IOException {
		Avaliacao[] listaAvaliacao = new Avaliacao[0];
		String[][] avaliacao = Arquivo.LerTodos(Diretorio.Avaliacao(), AvaliacaoInfo.TOTALCAMPOS);
		
		for (int i = 0; i < avaliacao.length; i++) {
			listaAvaliacao = AvaliacaoInfo.AdicionarAvaliacaoLista(listaAvaliacao, AvaliacaoInfo.GetEntity(avaliacao[i]));
		}
		
		return listaAvaliacao;
	}

	public static void Atualizar(Avaliacao avaliacao) throws FileNotFoundException {
		if(avaliacao.avaliado.contains("-")) {
			avaliacao.avaliado = avaliacao.avaliado.substring(0, avaliacao.avaliado.indexOf('-') - 1);
		}
		Arquivo.Atualizar(arquivo(avaliacao.id), AvaliacaoInfo.GetArray(avaliacao));
	}

	public static void Deletar(Avaliacao avaliacao) {
		Arquivo.Deletar(arquivo(avaliacao.id));
	}

	private static void VincularAvaliacao(Avaliacao avaliacao) throws IOException {
		
		Globais.Pessoa.avaliacoes += (Globais.Pessoa.avaliacoes.equals("") ? "" : ",")
				+ avaliacao.id;
		Controles.PessoaControl.Atualizar(Globais.Pessoa);
		
		switch (avaliacao.tipo) {
		case "Estabelecimento":
			Estabelecimento estabelecimento = EstabelecimentoControl.Ler(avaliacao.avaliado);
			estabelecimento.avaliacoes += (estabelecimento.avaliacoes.equals("") ? "" : ",") + avaliacao.id;
			EstabelecimentoControl.Atualizar(estabelecimento);

			break;
		case "Funcionário":

			Funcionario funcionario = FuncionarioControl.Ler(avaliacao.avaliado);
			funcionario.avaliacoes += (funcionario.avaliacoes.equals("") ? "" : ",") + avaliacao.id;
			FuncionarioControl.Atualizar(funcionario);
			break;
		}
	}

}
