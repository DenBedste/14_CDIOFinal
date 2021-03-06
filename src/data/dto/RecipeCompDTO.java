package data.dto;

import java.io.Serializable;

public class RecipeCompDTO implements Serializable{
	private static final long serialVersionUID = -6440335065542506197L;
	private int ingredientId;
	private int amount;
	private double tolerance; //0-20% tolerance
	private int recipeId;


	public RecipeCompDTO(int ingredientId, int amount, double tolerance, int recipeId) {
		this.ingredientId = ingredientId;
		this.amount = amount;
		this.tolerance = tolerance;
		this.recipeId = recipeId;
	}

	public RecipeCompDTO() {

	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredient(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTolerance() {
		return tolerance;
	}

	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
}
