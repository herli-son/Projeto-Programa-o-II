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
        /**
         * Concatena dois arrays de strings
         * @param p - Primeiro array
         * @param s - Segundo array
         * @return Arrays concatenados
         */
        public static String[] Concatena(String[] p, String[] s){
            String[] concat = new String[p.length + s.length];
            int index = 0;
            
            for (String value : p) {
                concat[index] = value;
                index++;
            }
            
            for (String value : s) {
                concat[index] = value;
                index++;
            }
            
            return concat;
        }
}
