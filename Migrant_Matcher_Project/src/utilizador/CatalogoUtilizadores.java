package utilizador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatalogoUtilizadores {

	private HashMap<Integer,Utilizador> usersRegistados;
		
	/**
	 * Construtor de CatalogoUtilizadores, cria um HashMap para guardar Utilizadores
	 */
	public CatalogoUtilizadores() {
		this.usersRegistados = new HashMap<Integer, Utilizador>();
	}
		
	/**
	 * Adiciona um Utilizador ao sistema
	 * @param u o Utilizador
	 * @return HashMap dos Utilizadores atualizado
	 */
	public HashMap<Integer,Utilizador> adicionaUser(Utilizador u) {
			this.usersRegistados.put(u.getTel(), u);
			return this.usersRegistados;
		}
		
		/**
		 * Remove um Utilizador do sistema
		 * @param u o Utilizador
		 */
		public void removeUser(Utilizador u) {
			this.usersRegistados.remove(u.getTel());
			}
		
		/**
		 * Procura e devolve um Utilizador através do seu numero de telemovel
		 * @param tel o numero de telemovel do Utilizador
		 * @return o Utilizador correspondente a ao numero de telemovel indicado
		 */
		public Utilizador getUser(int tel) {
			return this.usersRegistados.get(tel);
		}			
		/**
		 * Devolve uma lista com todos os Utilizadores
		 * @return uma lista com todos os Utilizadores
		 */
		public List<Utilizador> getUsers(){
			return new ArrayList<>(this.usersRegistados.values());
		}
		
		/**
		 * Passa para String a lista de Utilizadores
		 */
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			result.append("\nLista de utilizadores registados:\n");
			for(Utilizador u : this.getUsers()) {
				result.append("\t" + u.toString() + "\n");
			}
			return result.toString();
		}


}
