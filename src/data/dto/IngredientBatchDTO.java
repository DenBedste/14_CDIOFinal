package data.dto;

import java.io.Serializable;

public class IngredientBatchDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9055060400210373872L; //Hvad er det her?, og hvad skal vi bruge det til?
	private int ibId;
	private int ingredientId;
	private double amount;

	public IngredientBatchDTO() {

	}

	public int getIbID() {
		return ibId;
	}

	public void setIbID(int ibID) {
		this.ibId = ibID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

}