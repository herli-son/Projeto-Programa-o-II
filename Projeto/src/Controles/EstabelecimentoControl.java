package Controles;

import java.io.FileNotFoundException;
import java.io.IOException;

import Repositorio.Entidades.EstabelecimentoEntity;
import Repositorio.Entidades.IDEntity;
import Repositorio.Informacoes.EstabelecimentoInfo;
import Servicos.Arquivo;
import Servicos.Diretorio;
import Utilidades.Globais;

public class EstabelecimentoControl {
	
	private static String arquivo(String nome) {
		return Diretorio.Estabelecimento() + "/" + nome + Arquivo.EXTENSAO;
	}
	
	public static void Criar(EstabelecimentoEntity estabelecimento) throws IOException {
		
		IDEntity ids = IDControl.Ler();
		estabelecimento.id = ids.estabelecimento;
		ids.estabelecimento = String.valueOf(Integer.parseInt(ids.estabelecimento) + 1);
		Arquivo.Criar(arquivo(estabelecimento.id));
		Atualizar(estabelecimento);	
		IDControl.Atualizar(ids);
		VincularPessoa(estabelecimento.id);
	}
	
	public static EstabelecimentoEntity Ler(String id) throws FileNotFoundException, IOException {
		String[] dados = Arquivo.Ler(arquivo(id), EstabelecimentoInfo.TOTALCAMPOS);
		return EstabelecimentoInfo.GetEntity(dados);
	}
	
	public static void Atualizar(EstabelecimentoEntity estabelecimento) throws FileNotFoundException {
		Arquivo.Atualizar(arquivo(estabelecimento.id), EstabelecimentoInfo.GetArray(estabelecimento));
	}
	
	public static void Deletar(EstabelecimentoEntity estabelecimento) {
		Arquivo.Deletar(arquivo(estabelecimento.id));
	}
	
	public static void VincularPessoa(String id) throws FileNotFoundException {
		Globais.PessoaLogada.estabelecimentosVinculados += (Globais.PessoaLogada.estabelecimentosVinculados.equals("") ? "" : ",") + id;
		Controles.PessoaControl.Atualizar(Globais.PessoaLogada);
	}
}
