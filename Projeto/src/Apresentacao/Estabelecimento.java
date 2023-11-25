package Apresentacao;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controles.Validacoes;
import Repositorio.Entidades.EstabelecimentoEntity;
import Repositorio.Informacoes.EstabelecimentoInfo;
import Utilidades.Array;
import Utilidades.Globais;

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

	public static String Cadastrar() throws Exception {
		String[] estabelecimento = new String[] {"" ,"_______________", "_______________",
				"_______________", "_______________", "_______________" };
		int[] campos = { 1, 2, 3, 4, 5 };
		for(int i =0; i < campos.length; i++) {
			estabelecimento[campos[i]] = Painel.Entrada(Menu.TextoDadosEntidade(EstabelecimentoInfo.CAMPOS, estabelecimento, campos)
					+ "\nDigite o valor para " + EstabelecimentoInfo.CAMPOS[campos[i]] + ": ");
			if (estabelecimento[campos[i]] == null)
				return null;
		}
		do {
			estabelecimento = Acoes.VerAlterarCancelar(EstabelecimentoInfo.CAMPOS, estabelecimento, campos ,campos);
			if (estabelecimento == null)
				return null;
		} while (!Validacoes.CadastroEstabelecimento(EstabelecimentoInfo.GetEntity(estabelecimento)));
		Controles.EstabelecimentoControl.Criar(EstabelecimentoInfo.GetEntity(estabelecimento));
		Painel.Informar("Cadastro realizado!");
		return estabelecimento[1];
	}

	private static void Dados() throws Exception {
		String[] estabelecimentoArray = EstabelecimentoInfo.GetInfoArray(Globais.EstabelecimentoLogado);
		estabelecimentoArray = Acoes.VerAlterar(EstabelecimentoInfo.CAMPOS, estabelecimentoArray, EstabelecimentoInfo.CAMPOSVISIVEIS, EstabelecimentoInfo.CAMPOSEDITAVEIS);
		EstabelecimentoEntity estabelecimentoEntidade = EstabelecimentoInfo.GetEntity(estabelecimentoArray, EstabelecimentoInfo.GetArray(Globais.EstabelecimentoLogado));
		Controles.EstabelecimentoControl.Atualizar(estabelecimentoEntidade);
		Globais.EstabelecimentoLogado = EstabelecimentoInfo.Copiar(estabelecimentoEntidade);
	}
	
	public static void AcessarLista() throws Exception {
		
		do {
			String[][] estabelecimentos = BuscarEstabelecimentos();
 			int escolhido = Acoes.ManutencaoLista(EstabelecimentoInfo.CAMPOS, EstabelecimentoInfo.GetListInfoArray(estabelecimentos), EstabelecimentoInfo.CAMPOSVISIVEIS, EstabelecimentoInfo.CAMPOSIDENTIFICAR);
			
			switch (escolhido) {
			case 0:
				Cadastrar();
				break;
			case -1:
				return;
			default:
				Globais.EstabelecimentoLogado = EstabelecimentoInfo.GetEntity(estabelecimentos[escolhido - 1]);
				new Estabelecimento();
			}
		} while (true);
	}
	
	private static String[][] BuscarEstabelecimentos() throws FileNotFoundException, IOException {
		String[] ids = Array.Lista(Globais.PessoaLogada.estabelecimentosVinculados);
		String[][] estabelecimentos = new String[ids.length][EstabelecimentoInfo.TOTALCAMPOS];

		for(int i = 0; i < ids.length; i++) {
			estabelecimentos[i] = EstabelecimentoInfo.GetArray(Controles.EstabelecimentoControl.Ler(ids[i]));
		}
		return estabelecimentos;
	}
	
}
