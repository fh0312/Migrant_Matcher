package ajuda;

public class Item extends Ajuda{

	private String itemDesc;

	public Item(String itemDesc) {
		super();
		this.itemDesc = itemDesc;
	}
	
	public String getNome() {
		return this.itemDesc;
	}
	
	@Override
	public String toString() {
		return "Item: " + itemDesc;
		
	}
}
