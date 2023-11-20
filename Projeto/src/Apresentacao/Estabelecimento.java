package Apresentacao;

import Controles.Info;
import Servicos.Validacoes;
import Utilidades.Copiar;
import Utilidades.Globais;
import Utilidades.ToArray;
import Utilidades.ToEntity;

public class Estabelecimento {

	public Estabelecimento() {
		while (true) {
			try {
				String op = Painel.Opcao(Menu.ESTABELECIMENTO);
				switch (op) {
				case "1":
					Dados();
					break;
				case "2":
					// Avaliaçoes
					Painel.Informar("Em desenvolvimento");
					break;
				case "3":
					// Minhas Compras
					Painel.Informar("Em desenvolvimento");
					break;
				case "0":
				case "4":
					// Sair
					Globais.EstabelecimentoLogado = null;
					return;
				}
			} catch (Exception e) {
				Painel.Erro(e.getMessage());
			}
		}
	}

	public static void Acessar() throws Exception {
		String[] valores = { "", "______________", "", "", "" };
		int[] campos = { 1 };
		for (int i = 0; i < campos.length; i++) {
			valores[campos[i]] = Painel.Entrada((Menu.TextoDadosEntidade(Info.ESTABELECIMENTO, valores, campos))
					+ "\nDigite o valor para " + Info.ESTABELECIMENTO[campos[i]] + ": ");
			if (valores[campos[i]] == null)
				return;
		}
		if (Validacoes.AcessoEstabelecimento(valores[campos[0]]))
			new Estabelecimento();
	}

	public static String Cadastrar() throws Exception {
		String[] estabelecimento = new String[] { "_______________", "_______________",
				"_______________", "_______________", "_______________" };
		int[] campos = { 0, 1, 2, 3, 4 };
		for(int i =0; i < campos.length; i++) {
			estabelecimento[i] = Painel.Entrada(Menu.TextoDadosEntidade(Info.ESTABELECIMENTO, estabelecimento, campos)
					+ "\nDigite o valor para " + Info.ESTABELECIMENTO[campos[i]] + ": ");
			if (estabelecimento[i] == null)
				return null;
		}
		do {
			estabelecimento = Acoes.VerAlterarCancelar(Info.ESTABELECIMENTO, estabelecimento);
			if (estabelecimento == null)
				return null;
		} while (!Validacoes.CadastroEstabelecimento(ToEntity.Estabelecimento(estabelecimento)));
		Servicos.Estabelecimento.Criar(ToEntity.Estabelecimento(estabelecimento));
		Painel.Informar("Cadastro realizado!");
		return estabelecimento[1];
	}

	private static void Dados() throws Exception {
		String[] estabelecimentoArray = ToArray.InfoEstabelecimento(Globais.EstabelecimentoLogado);
		estabelecimentoArray = Acoes.VerAlterar(Info.ESTABELECIMENTO, estabelecimentoArray, Info.INDEXESTABELECIMENTO);
		Entidades.Estabelecimento estabelecimentoEntidade = ToEntity.Estabelecimento(estabelecimentoArray,
				ToArray.Estabelecimento(Globais.EstabelecimentoLogado));
		Servicos.Estabelecimento.Atualizar(estabelecimentoEntidade);
		Globais.EstabelecimentoLogado = Copiar.Estabelecimento(estabelecimentoEntidade);
	}
	
	public static void Lista(String[] IDs) throws Exception {
		String[][] estabelecimentos = new String[IDs.length][12];
		
		for(int i = 0; i < IDs.length; i++) {
			estabelecimentos[i] = ToArray.Estabelecimento(Servicos.Estabelecimento.Ler(IDs[i]));
		}
		
		int escolhido;
		
		do {
			escolhido = Painel.EscolherAdicionarDadoLista(IDs);
			switch (escolhido) {
			case -1: 
				return;			
			case 0:
				String cnpj = Cadastrar();
				if (cnpj != null)
					Servicos.Estabelecimento.VincularPessoa(cnpj);
				break;
			default:
				String[] infoString = Acoes.VerAlterar(Info.ESTABELECIMENTO, ToArray.InfoEstabelecimento(estabelecimentos[escolhido -1]), Info.INDEXESTABELECIMENTO);
				Entidades.Estabelecimento estabelecimento = ToEntity.Estabelecimento(infoString, estabelecimentos[escolhido -1]);
				Servicos.Estabelecimento.Atualizar(estabelecimento);
				estabelecimentos[escolhido -1] = ToArray.Estabelecimento(estabelecimento);
			}
		} while (escolhido != -1);
	}
	
	
}
