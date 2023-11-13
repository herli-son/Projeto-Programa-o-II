package Utilidades;

public class Copiar {
	/**
     * Cria uma cópia da pessoa
     * @param pessoa - Pessoa que será copiada
     * @return Cópia da pessoa
     */
    public static Entidades.Pessoa Pessoa(Entidades.Pessoa pessoa){
    	Entidades.Pessoa p = new Entidades.Pessoa();
        p.acesso = pessoa.acesso;
        p.nome = pessoa.nome;
        p.sobrenome = pessoa.sobrenome;
        p.senha = pessoa.senha;
        p.estabelecimentosVinculados = pessoa.estabelecimentosVinculados; 
        p.servicosReservados = pessoa.servicosReservados;
        p.produtosReservados = pessoa.produtosReservados;
        p.funcionariosAvaliados = pessoa.funcionariosAvaliados;
        p.estabelecimentosAvaliados = pessoa.estabelecimentosAvaliados;
        p.produtosAvaliados = pessoa.produtosAvaliados;
        p.servicosAvaliados = pessoa.produtosAvaliados;
        return p;
    }
}
