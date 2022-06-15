package utilizador;

import java.util.ArrayList;
import java.util.List;

import pedido_ajuda.PedidoAjuda;

public class Migrante extends Utilizador {
	
	protected String nome;
	private List<Familiar> lf; //lista dos familiares
	private PedidoAjuda paCorrente; // pedido de Ajuda corrente
	private List<PedidoAjuda> lp; // lista de pedidos de ajuda efetuados

	
	/**
	 * Construtor de Migrante, recebe o nome e o numero de telemovel do Migrante para o registar no sistema
	 * @param nome 	o nome do Migrante
	 * @param tel 	o numero de telemovel do Migrante
	 */
	public Migrante(String nome, int tel) { //sem familia 
		super(tel);
		this.nome = nome;
		this.lf = new ArrayList<>();
		this.lp = new ArrayList<>();
	}
	
	/** este metodo nao esta aqui a mais?
	 * @return 
	 */
	public int getTel() {
		return this.tel;
	}
	/**
	 * @return o nome do Migrante
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Devolve o Pedido de Ajuda corrente do Migrante
	 * @return o PedidoAjuda corrente do Migrante
	 */
	public PedidoAjuda getPaCorrente() {
		return paCorrente;
	}

	/**
	 * Define o Pedido de Ajuda corrente do Migrante
	 * @param paCorrente um PedidoAjuda
	 */
	public void setPaCorrente(PedidoAjuda paCorrente) {
		this.paCorrente = paCorrente;
	}

	/**
	 * Devolve uma lista com os familiares do Migrante
	 * @return a lista de familiares do Migrante
	 */
	public List<Familiar> getListaFamiliares() {
		return lf;
	}

	/**
	 * Devolve uma lista com os pedidos do Migrante
	 * @return a lista de pedidos do Migrante
	 */
	public List<PedidoAjuda> getListaPedidos() {
		return lp;
	}

	/**
	 * Adiciona um Familiar a lista de familiares do Migrante
	 * @param f um Familiar
	 */
	public void adicionaFamiliar(Familiar f){
		lf.add(f);
	}
	
	/**
	 * Adiciona um PedidoAjuda a lista de pedidos do Migrante
	 * @param pAjuda um PedidoAjuda
	 */
	public void adicionaPedido(PedidoAjuda pAjuda) {
		lp.add(pAjuda);
	}
	
	

	

	
	

}
