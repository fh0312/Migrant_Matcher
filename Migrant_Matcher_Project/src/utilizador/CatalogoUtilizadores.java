package utilizador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import regiao.Regiao;

public class CatalogoUtilizadores {

	private HashMap<Integer,Utilizador> usersRegistados;
		
	public CatalogoUtilizadores() {
		this.usersRegistados = new HashMap<Integer, Utilizador>();
	}
		
	public HashMap<Integer,Utilizador> adicionaUser(Utilizador u) {
			this.usersRegistados.put(u.getTel(), u);
			return this.usersRegistados;
		}
		
		public void removeUser(Utilizador u) {
			this.usersRegistados.remove(u.getTel());
			}
		
		public Utilizador getUser(int tel) {
			return this.usersRegistados.get(tel);
		}			
		public List<Utilizador> getUsers(){
			return new ArrayList<>(this.usersRegistados.values());
		}
		
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
