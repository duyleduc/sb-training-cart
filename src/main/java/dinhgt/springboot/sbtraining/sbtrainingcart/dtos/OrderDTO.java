package dinhgt.springboot.sbtraining.sbtrainingcart.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderDTO {
	private UUID orderID;

	private int userID;

	private String status;

	private LocalDateTime createdDate;

	private LocalDateTime modifyDate;

	private String comment;

	private List<OrderDetailsDTO> listOrderDetails;

	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(UUID orderID, int userID, String status, LocalDateTime createdDate, LocalDateTime modifyDate,
			String comment, List<OrderDetailsDTO> listOrderDetails) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.status = status;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.comment = comment;
		this.listOrderDetails = listOrderDetails;
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
	public List<OrderDetailsDTO> getListOrderDetails() {
		return listOrderDetails;
	}

	/**
	 * @param listOrderDetails the listOrderDetails to set
	 */
	public void setListOrderDetails(List<OrderDetailsDTO> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}


}
