package jp.co.calocalo.form;

import java.io.Serializable;

public class SignUpForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int emp_id;
	private String password;
	private int goal_calories;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGoal_calories() {
		return goal_calories;
	}
	public void setGoal_calories(int goal_calories) {
		this.goal_calories = goal_calories;
	}
	
	
}
