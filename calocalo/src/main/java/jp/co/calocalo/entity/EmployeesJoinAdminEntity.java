package jp.co.calocalo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeesJoinAdminEntity {

	@Id
	private int emp_id;
	
	@Column
	private int goal_calories;
	
	@ManyToOne
	@JoinColumn(name = "admin", referencedColumnName = "admin_id")
	private AdminEntity adminEntity;
	
	@Column
	private String password;
	
	@Column
	private boolean is_deleted;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getGoal_calories() {
		return goal_calories;
	}

	public void setGoal_calories(int goal_calories) {
		this.goal_calories = goal_calories;
	}

	public AdminEntity getAdminEntity() {
		return adminEntity;
	}

	public void setAdminEntity(AdminEntity adminEntity) {
		this.adminEntity = adminEntity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public int getEmpAdminId() {
		return getAdminEntity().getAdmin_id();
	}

	
}
	
