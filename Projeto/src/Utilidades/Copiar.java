package Utilidades;

import Entidades.Pessoa;

/**
 *
 * @author herli
 */
public class Copiar {
    /**
     * Cria uma cópia da pessoa
     * @param pessoa - Pessoa que será copiada
     * @return Cópia da pessoa
     */
    public static Pessoa Pessoa(Pessoa pessoa){
        Pessoa p = new Pessoa();
        p.acesso = pessoa.acesso;
        p.nome = pessoa.nome;
        p.sobrenome = pessoa.sobrenome;
        p.senha = pessoa.senha;
        return p;
    }
}
