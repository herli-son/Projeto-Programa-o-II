package Utilidades;

public class ToArray {
	/**
	 * Converte entidade Pessoa para uma lista de array de String
	 * @param pessoa - Pessoa que será convertida
	 * @return Dados da pessoa em Array
	 */
	public static String[] Pessoa(Entidades.Pessoa pessoa) {
		return new String[] {
				pessoa.acesso,
				pessoa.nome,
				pessoa.sobrenome,
				pessoa.senha,
                                pessoa.estabelecimentosVinculados, 
                                pessoa.servicosReservados,
                                pessoa.produtosReservados,
                                pessoa.funcionariosAvaliados,
                                pessoa.estabelecimentosAvaliados,
                                pessoa.produtosAvaliados,
                                pessoa.servicosAvaliados
		};
	}
        public static String[] DadosPessoa(Entidades.Pessoa pessoa) {
		return new String[] {
				pessoa.acesso,
				pessoa.nome,
				pessoa.sobrenome,
				pessoa.senha,
                };
	}
        /**
         * Transforma lista de string em array
         * @param lista - Lista de string corrente com itens separados por ,
         * @return Array de string com itens da lista
         */
        public static String[] Lista(String lista){
            if(lista.equals("")) 
                return new String[0];
            return lista.split(",");
        }
}
