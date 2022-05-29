package utilizador;

public abstract class Utilizador {
	protected int tel;
	
	public Utilizador(int tel) {
		this.tel = tel;
	}
	public int getTel() {
		return this.tel; 
	}
}
