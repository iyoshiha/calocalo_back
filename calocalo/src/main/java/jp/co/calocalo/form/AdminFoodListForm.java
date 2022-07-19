package jp.co.calocalo.form;

import java.io.Serializable;

public class AdminFoodListForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	private String food_name;
	private int food_calorie;
	
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getFood_calorie() {
		return food_calorie;
	}
	public void setFood_calorie(int food_calorie) {
		this.food_calorie = food_calorie;
	}
	

}
