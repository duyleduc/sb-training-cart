package dinhgt.springboot.sbtraining.sbtrainingcart.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_details", schema = "my_schema")
public class OrderDetails {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "detail_id")
	private UUID detailID;

	@Column(name = "item_id")
	private String itemID;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "status")
	private String status;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "modified_date")
	private LocalDateTime modifyDate;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "orders_id", referencedColumnName = "order_id")
	private Order orders;

	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(UUID detailID, String itemID, int quantity, String status, LocalDateTime createdDate,
			LocalDateTime modifyDate, Order orders) {
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
	public Order getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Order orders) {
		this.orders = orders;
	}

}
