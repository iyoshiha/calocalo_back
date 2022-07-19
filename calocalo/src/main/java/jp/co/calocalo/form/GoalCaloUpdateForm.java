package jp.co.calocalo.form;

import java.io.Serializable;

public class GoalCaloUpdateForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private  int goal_calorie;

	public int getGoal_calorie() {
		return goal_calorie;
	}

	public void setGoal_calorie(int goal_calorie) {
		this.goal_calorie = goal_calorie;
	}

	
}
