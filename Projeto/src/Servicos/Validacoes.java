package Servicos;

import Apresentacao.Painel;
import Utilidades.Globais;

public class Validacoes {
	/**
	 * Verifica se o valor passado existe no array
	 * @param array - Lista de valores
	 * @param dado - Valor a verificar
	 * @return Dado existe no array? True or False
	 */
	public static boolean InArray(String[] array, String dado) {
		for (String a : array) {
			if(a.equals(dado)) return true;
		}
		return false;
	}
	/**
	 * Verifica se o valor passado existe no array
	 * @param array - Lista de valores
	 * @param dado - Valor a verificar
	 * @return Dado existe no array? True or False
	 */
	public static boolean InArray(char[] array, char dado) {
		for (char a : array) {
			if(a == dado) return true;
		}
		return false;
	}
	/**
	 * Verifica se a pessoa pode acessar com os dados passados
	 * @param acesso - Acesso da pessoa
	 * @param senha - Senha da pessoa
	 * @return Pode Acessar? True or False
	 */
	public static boolean AcessoPessoa(String acesso, String senha) {
		try {
			Entidades.Pessoa pessoa = Pessoa.Ler(acesso);	
			if(pessoa.senha.equals(senha)) {
				Painel.Informar("Acesso autorizado!");
                                Globais.PessoaLogada = pessoa;
				return true;
			}else {
				Painel.Erro("Acesso negado!");
				return false;
			}
		} catch (Exception e) {
                    Painel.Erro("Não existe pessoa com esse acesso!");
		    return false;
		}
	}
	/**
	 * Verifica se pode ou não cadastrar a pessoa
	 * @param pessoa - Dados da pessoa que será cadastrada
	 * @return Pode cadastrar? True or False 
	 */
	public static boolean CadastroPessoa(Entidades.Pessoa pessoa) {
		
		if(TemEspecial(pessoa.acesso)) {
			Painel.Erro( "O acessoa não deve ter caracteres especiais!");
			return false;
		}
		try {
			Pessoa.Ler(pessoa.acesso);
			Painel.Erro( "Já existe uma pessoa com o acesso " + pessoa.acesso);
			return false;
		} catch (Exception e) {}
		return true;
	}
	/**
	 * Verifica se o texto passado possui caracteres especiais
	 * @param texto - TExto a ser verificado
	 * @return Tem caractere especial? True or False
	 */
	private static boolean TemEspecial(String texto) {
		
            for (int i = 0; i < texto.length(); i++) {
                    if(!InArray( Globais.CARACTERESVALIDOS, texto.charAt(i))) {
                            return true;
                    }
            }
            return false;
	}
}
