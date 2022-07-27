package dinhgt.springboot.sbtraining.sbtrainingcart.dtos;

public class ItemDTO {
	private String itemID;
	private int quantity;
	
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}

	public ItemDTO(String itemID, int quantity) {
		super();
		this.itemID = itemID;
		this.quantity = quantity;
	}

	/**
	 * @return the itemID
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
