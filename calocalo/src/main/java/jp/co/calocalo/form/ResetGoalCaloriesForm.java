package jp.co.calocalo.form;

import java.io.Serializable;

public class ResetGoalCaloriesForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int goalCalories;
	
	public int getGoalCalories() {
		return goalCalories;
	}
	public void setGoalCalories(int goalCalories) {
		this.goalCalories = goalCalories;
	}


	
	
}
