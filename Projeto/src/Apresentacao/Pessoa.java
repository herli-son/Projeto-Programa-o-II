package Apresentacao;

import Controles.Info;
import Servicos.Validacoes;
import Utilidades.Copiar;
import Utilidades.Globais;
import Utilidades.ToArray;
import Utilidades.ToEntity;

/**
 *
 * @author herli
 */
public class Pessoa {

	public Pessoa() {
		while (true) {
			try {
				String op = Painel.Opcao(Menu.PESSOA);
				switch (op) {
				case "1":
					Dados();
					break;
				case "2":
					// Avaliacoes();
					Painel.Informar("Em Desenvolvimento");
					break;
				case "3":
					// Compras();
					Painel.Informar("Em Desenvolvimento");
					break;
				case "4":
<<<<<<< Updated upstream
					// Lista de estabelecimentos vinculados à pessoa
					Painel.Informar("Em Desenvolvimento");
=======
<<<<<<< HEAD
					MeusEstabelecimentos();
=======
					// Lista de estabelecimentos vinculados à pessoa
					Painel.Informar("Em Desenvolvimento");
>>>>>>> e333595d01ec86a72a570431dcbd688c5b77b728
>>>>>>> Stashed changes
					break;
				case "5":
					Painel.Informar("Em Desenvolvimento");
					break;
				case "0":
				case "6":
					Globais.PessoaLogada = null;
					return;
				}
			} catch (Exception e) {
				Painel.Erro(e.getMessage());
			}
		}
	}

	public static void Acessar() throws Exception {
		String[] valores = { "", "", "_______________", "_______________" };
		int[] campos = { 2, 3 };
		for (int i = 0; i < campos.length; i++) {
			valores[campos[i]] = Painel.Entrada(Menu.TextoDadosEntidade(Info.PESSOAS, valores, campos)
					+ "\nDigite o valor para " + Info.PESSOAS[campos[i]] + ": ");
			if (valores[campos[i]] == null)
				return;
		}
		if (Validacoes.AcessoPessoa(valores[campos[0]], valores[campos[1]]))
			new Pessoa();
	}

	public static void Cadastrar() throws Exception {
		String[] pessoa = new String[] { "_______________", "_______________", "_______________", "_______________" };
		int[] campos = { 0, 1, 2, 3 };
		for (int i = 0; i < campos.length; i++) {
			pessoa[i] = Painel.Entrada(Menu.TextoDadosEntidade(Info.PESSOAS, pessoa, campos) + "\nDigite o valor para "
					+ Info.PESSOAS[campos[i]] + ": ");
			if (pessoa[i] == null)
				return;
		}
		do {
			pessoa = Acoes.VerAlterarCancelar(Info.PESSOAS, pessoa);
			if (pessoa == null)
				return;
		} while (!Validacoes.CadastroPessoa(ToEntity.Pessoa(pessoa)));
		Servicos.Pessoa.Criar(ToEntity.Pessoa(pessoa));
		Painel.Informar("Cadastro realizado!");
	}

	private static void Dados() throws Exception {
		String[] pessoaArray = ToArray.InfoPessoa(Globais.PessoaLogada);
		pessoaArray = Acoes.VerAlterar(Info.PESSOAS, pessoaArray, Info.INDEXPESSOAS);
		Entidades.Pessoa pessoaEntidade = ToEntity.Pessoa(pessoaArray, ToArray.Pessoa(Globais.PessoaLogada));
		Servicos.Pessoa.Atualizar(pessoaEntidade);
		Globais.PessoaLogada = Copiar.Pessoa(pessoaEntidade);
	}
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
	
	private static void MeusEstabelecimentos() throws Exception {
		String[] IDs = ToArray.Lista(Globais.PessoaLogada.estabelecimentosVinculados);
		Estabelecimento.Lista(IDs);
	}
=======
>>>>>>> e333595d01ec86a72a570431dcbd688c5b77b728
>>>>>>> Stashed changes
}
