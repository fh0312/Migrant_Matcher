package utilizador;

public class Familiar extends Migrante{
	
	private Migrante pai ;
	
	public Familiar(String nome) {
		super(nome,0);
	}
	
	public void setPai(Migrante pai) {
		this.pai = pai;
	}
	
	public Migrante getPai() {
		return pai;
	}
	

}
