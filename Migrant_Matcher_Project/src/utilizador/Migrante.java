package utilizador;

import java.util.ArrayList;
import java.util.List;

import pedido_ajuda.PedidoAjuda;

public class Migrante extends Utilizador {
	
	protected String nome;
	private List<Familiar> lf; //lista dos familiares
	private PedidoAjuda paCorrente; // pedido de Ajuda corrente
	private List<PedidoAjuda> lp; // lista de pedidos de ajuda efetuados

	
	public Migrante(String nome, int tel) { //sem familia 
		super(tel);
		this.nome = nome;
		this.lf = new ArrayList<>();
		this.lp = new ArrayList<>();
	}
	
	public int getTel() {
		return this.tel;
	}
	public String getNome() {
		return this.nome;
	}
	
	public PedidoAjuda getPaCorrente() {
		return paCorrente;
	}

	public void setPaCorrente(PedidoAjuda paCorrente) {
		this.paCorrente = paCorrente;
	}

	public List<Familiar> getListaFamiliares() {
		return lf;
	}

	public List<PedidoAjuda> getListaPedidos() {
		return lp;
	}

	public void adicionaFamiliar(Familiar f){
		lf.add(f);
	}
	
	public void adicionaPedido(PedidoAjuda pAjuda) {
		lp.add(pAjuda);
	}
	
	

	

	
	

}
