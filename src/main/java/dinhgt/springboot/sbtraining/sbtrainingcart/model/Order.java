package dinhgt.springboot.sbtraining.sbtrainingcart.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order", schema = "my_schema")
public class Order {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "order_id")
	private UUID orderID;

	@Column(name = "user_id", length = 16, nullable = false)
	private int userID;

	@Column(name = "status", length = 64)
	private String status;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "modified_date")
	private LocalDateTime modifyDate;

	@Column(name = "comment", length = 1000)
	private String comment;

	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})

	private List<OrderDetails> listOrderDetails;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(UUID orderID, int userID, String status, LocalDateTime createdDate, LocalDateTime modifyDate,
			String comment) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.status = status;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.comment = comment;
	}

	/**
	 * @return the orderID
	 */
	public UUID getOrderID() {
		return orderID;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(UUID orderID) {
		this.orderID = orderID;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the listOrderDetails
	 */
	public List<OrderDetails> getListOrderDetails() {
		return listOrderDetails;
	}

	/**
	 * @param listOrderDetails the listOrderDetails to set
	 */
	public void setListOrderDetails(List<OrderDetails> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}



}
