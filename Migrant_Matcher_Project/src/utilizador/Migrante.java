package utilizador;

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
	
	
//	public Migrante(int numPessoas) { // com familia
//		super(0);
//		this.lf= new ArrayList<Familiar>();
//		this.tel = getTelInput();
//		this.nome = getNomeInput("cabeça de casal:");
//		registaFamilia(numPessoas-1);
//		sc.close();
//	}

//	private void registaFamilia(int n) {
//		
//		for(int i = 0;i<n;i++) {
//			lf.add(new Familiar(getNomeInput("familiar:"),getTelInput()));
//		}
//	}

//	private String getNomeInput(String tipo) {
//		try {
//		System.out.println("Insira o nome do " + tipo);
//		String name = sc.next();
//		return name;
//		}
//		catch(Exception e) {
//			System.out.println("Número não reconhecido tente novamente!");
//			return getNomeInput(tipo);	
//		}
//
//	}
//
//	private int getTelInput() {
//		System.out.println("Insira o numero de telemovel respetivo:");
//		int tel =  sc.nextInt();
//		return tel;
//	}
	

	
	

}
