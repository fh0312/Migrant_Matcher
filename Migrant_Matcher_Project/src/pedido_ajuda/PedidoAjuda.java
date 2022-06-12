package pedido_ajuda;

import java.util.List;

import ajuda.Ajuda;
import ajuda.CatalogoAjudas;

public class PedidoAjuda {
	
	List<Ajuda> ajudasPedidas;
	CatalogoAjudas catAjudas;
	
	public PedidoAjuda(CatalogoAjudas catA) {
		this.catAjudas=catA;
	}
	
	public void adicionaAjuda(Ajuda a) {
		this.ajudasPedidas.add(a);
	}
	
	public List<Ajuda> getAjudasPedidas(){
		return ajudasPedidas;
	}
	
	public void confirmaPedido(){
		this.ajudasPedidas.stream()		
			.forEach((a) -> {
				this.catAjudas.removeAjuda(a);
			});
		confirmasms
		
	}
	

}
