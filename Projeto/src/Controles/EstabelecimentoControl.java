package Controles;

import java.io.FileNotFoundException;
import java.io.IOException;

import Repositorio.Entidades.Estabelecimento;
import Repositorio.Entidades.Funcao;
import Repositorio.Entidades.Funcionario;
import Repositorio.Entidades.ID;
import Repositorio.Entidades.Pessoa;
import Repositorio.Informacoes.EstabelecimentoInfo;
import Servicos.Arquivo;
import Servicos.Diretorio;
import Utilidades.Globais;

public class EstabelecimentoControl {
	
	private static String arquivo(String nome) {
		return Diretorio.Estabelecimento() + "/" + nome + Arquivo.EXTENSAO;
	}
	
	public static void Criar(Estabelecimento estabelecimento) throws IOException {
		
		ID ids = IDControl.Ler();
		
		estabelecimento.id = ids.estabelecimento;
		Arquivo.Criar(arquivo(estabelecimento.id));
		
		Funcao funcao = new Funcao();
		funcao.nome = "Dono";
		funcao.descricao = "Dono do estabelecimento";
		funcao.estabelecimento = estabelecimento.id;
		funcao.id = ids.funcao;
		ids = FuncaoControl.Criar(funcao);
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.pessoa = Globais.Pessoa.acesso;
		funcionario.estabelecimento = estabelecimento.id;
		funcionario.funcao = funcao.id;
		funcionario.id = ids.funcionario;
		ids = FuncionarioControl.Criar(funcionario);
		
		
		estabelecimento.funcionarios = funcionario.id;
		estabelecimento.funcoes = funcao.id;
		ids.estabelecimento = String.valueOf(Integer.parseInt(ids.estabelecimento) + 1);
		
		Atualizar(estabelecimento);	
		IDControl.Atualizar(ids);
		VincularPessoa(estabelecimento);
	}
	
	public static Estabelecimento Ler(String id) throws FileNotFoundException, IOException {
		String[] dados = Arquivo.Ler(arquivo(id), EstabelecimentoInfo.TOTALCAMPOS);
		return EstabelecimentoInfo.GetEntity(dados);
	}
	public static Estabelecimento[] LerTodos() throws FileNotFoundException, IOException{
		Estabelecimento[] listaEstabelecimento = new Estabelecimento[0];
		String[][] estabelecimanto = Arquivo.LerTodos(Diretorio.Estabelecimento(), EstabelecimentoInfo.TOTALCAMPOS);
		
		for (int i = 0; i < estabelecimanto.length; i++) {
			listaEstabelecimento = EstabelecimentoInfo.AdicionarEstabelecimentoLista(listaEstabelecimento, EstabelecimentoInfo.GetEntity(estabelecimanto[i]));
		}
		
		return listaEstabelecimento;
	}
	public static void Atualizar(Estabelecimento estabelecimento) throws FileNotFoundException {
		Arquivo.Atualizar(arquivo(estabelecimento.id), EstabelecimentoInfo.GetArray(estabelecimento));
	}
	
	public static void Deletar(Estabelecimento estabelecimento) {
		Arquivo.Deletar(arquivo(estabelecimento.id));
	}
	
	public static void VincularPessoa(Estabelecimento estabelecimento) throws FileNotFoundException {
		Globais.Pessoa.estabelecimentosVinculados += (Globais.Pessoa.estabelecimentosVinculados.equals("") ? "" : ",") + estabelecimento.id;
		Controles.PessoaControl.Atualizar(Globais.Pessoa);
	}
	public static void VincularPessoa(Estabelecimento estabelecimento, String acesso) throws IOException {
		Pessoa pessoa = PessoaControl.Ler(acesso);
		pessoa.estabelecimentosVinculados += (pessoa.estabelecimentosVinculados.equals("") ? "" : ",") + estabelecimento.id;
		Controles.PessoaControl.Atualizar(pessoa);
	}
	public static void VincularFuncao(Funcao funcao) throws FileNotFoundException {
		Globais.Estabelecimento.funcoes += (Globais.Estabelecimento.funcoes.equals("") ? "" : ",") + funcao.id;
		Atualizar(Globais.Estabelecimento);
	}
}
