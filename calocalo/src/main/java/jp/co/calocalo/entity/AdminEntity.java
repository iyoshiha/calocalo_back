package jp.co.calocalo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminEntity {

	@Id
	private int admin_id;
	
	@Column
	private String admin_status;
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_status() {
		return admin_status;
	}
	public void setAdmin_status(String admin_status) {
		this.admin_status = admin_status;
	}
	
	
	
}
