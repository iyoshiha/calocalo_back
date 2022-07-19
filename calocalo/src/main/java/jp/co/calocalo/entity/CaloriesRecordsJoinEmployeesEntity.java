package jp.co.calocalo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "calories_records")
public class CaloriesRecordsJoinEmployeesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int record_id;
	
	@ManyToOne
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
	private EmployeesJoinAdminEntity employeesJoinAdminEntity;
	
	@Column
	@Nullable
	private int total_calories;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;

	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public EmployeesJoinAdminEntity getEmployeesJoinAdminEntity() {
		return employeesJoinAdminEntity;
	}

	public void setEmployeesJoinAdminEntity(EmployeesJoinAdminEntity employeesJoinAdminEntity) {
		this.employeesJoinAdminEntity = employeesJoinAdminEntity;
	}

	public int getTotal_calories() {
		return total_calories;
	}

	public void setTotal_calories(int total_calories) {
		this.total_calories = total_calories;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
