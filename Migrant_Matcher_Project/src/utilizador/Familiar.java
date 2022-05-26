package utilizador;

public class Familiar extends Migrante{
	
	private int tel;
	private String nome;
	
	public Familiar(String nome, int tel) {
		
		this.tel = tel;
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	public int getTel() {
		return this.tel;
	}
	

}
