package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@XmlRootElement(name="Order")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	private String orderNumber = "";
	private String productName = "";
	private float price = 0;
	private int qty = 0;
	
	/**
	 * Default Constructor
	 */
	public Order() {
		super();
	}

	/**
	 * @param orderNumber
	 * @param productName
	 * @param price
	 * @param qty
	 */
	public Order(String orderNumber, String productName, float price, int qty) {
		super();
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.price = price;
		this.qty = qty;
	}

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	
	
}
