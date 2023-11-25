package Apresentacao;
import Controles.Validacoes;
import Repositorio.Entidades.PessoaEntity;
import Repositorio.Informacoes.PessoaInfo;
import Utilidades.Globais;

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
					Estabelecimento.AcessarLista();
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
		int[] campos = PessoaInfo.CAMPOSACESSO;
		for (int i = 0; i < campos.length; i++) {
			valores[campos[i]] = Painel.Entrada(Menu.TextoDadosEntidade(PessoaInfo.CAMPOS, valores, campos)
					+ "\nDigite o valor para " + PessoaInfo.CAMPOS[campos[i]] + ": ");
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
			pessoa[i] = Painel.Entrada(Menu.TextoDadosEntidade(PessoaInfo.CAMPOS, pessoa, campos) + "\nDigite o valor para "
					+ PessoaInfo.CAMPOS[campos[i]] + ": ");
			if (pessoa[i] == null)
				return;
		}
		do {
			pessoa = Acoes.VerAlterarCancelar(PessoaInfo.CAMPOS, pessoa);
			if (pessoa == null)
				return;
		} while (!Validacoes.CadastroPessoa(PessoaInfo.GetEntity(pessoa)));
		Controles.PessoaControl.Criar(PessoaInfo.GetEntity(pessoa));
		Painel.Informar("Cadastro realizado!");
	}

	private static void Dados() throws Exception {
		String[] pessoaInfoArray = PessoaInfo.GetInfoArray(Globais.PessoaLogada);
		pessoaInfoArray = Acoes.VerAlterar(PessoaInfo.CAMPOS, pessoaInfoArray, PessoaInfo.CAMPOSVISIVEIS, PessoaInfo.CAMPOSEDITAVEIS);
		PessoaEntity pessoaEntidade = PessoaInfo.GetEntity(pessoaInfoArray, PessoaInfo.GetArray(Globais.PessoaLogada));
		Controles.PessoaControl.Atualizar(pessoaEntidade);
		Globais.PessoaLogada = PessoaInfo.Copiar(pessoaEntidade);
	}
}
