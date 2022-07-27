package dinhgt.springboot.sbtraining.sbtrainingcart.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderDetailsDTO {
	private UUID detailID;

	private String itemID;

	private int quantity;

	private String status;

	private LocalDateTime createdDate;

	private LocalDateTime modifyDate;

	
	@JsonIgnore
	private OrderDTO orders;

	
	public OrderDetailsDTO() {
		// TODO Auto-generated constructor stub
	}



	public OrderDetailsDTO(UUID detailID, UUID orderID, String itemID, int quantity, String status,
			LocalDateTime createdDate, LocalDateTime modifyDate, OrderDTO orders) {
		super();
		this.detailID = detailID;
		this.itemID = itemID;
		this.quantity = quantity;
		this.status = status;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.orders = orders;
	}






	/**
	 * @return the detailID
	 */
	public UUID getDetailID() {
		return detailID;
	}


	/**
	 * @param detailID the detailID to set
	 */
	public void setDetailID(UUID detailID) {
		this.detailID = detailID;
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


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	/**
	 * @return the modifyDate
	 */
	public LocalDateTime getModifyDate() {
		return modifyDate;
	}


	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}


	/**
	 * @return the orders
	 */
	public OrderDTO getOrders() {
		return orders;
	}


	/**
	 * @param orders the orders to set
	 */
	public void setOrders(OrderDTO orders) {
		this.orders = orders;
	}
	
}
