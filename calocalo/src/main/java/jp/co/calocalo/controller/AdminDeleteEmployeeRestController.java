package jp.co.calocalo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.entity.EmployeesJoinAdminEntity;
import jp.co.calocalo.repository.EmployeesJoinAdminRepository;

@RestController
@RequestMapping("/admin/delete/employee")
@CrossOrigin
public class AdminDeleteEmployeeRestController {
		
	@Autowired EmployeesJoinAdminRepository employeesRepository;
	
	@DeleteMapping("/{emp_id}")
	public Map<String, Boolean> deleteEmployees(@PathVariable int emp_id) {
		
		EmployeesJoinAdminEntity employee = employeesRepository.getById(emp_id);
		
		employee.setIs_deleted(true);
		employeesRepository.save(employee);
		
		Map<String, Boolean> success = new HashMap<>();
		success.put("success", true);
		
		return success;
		
	}

}
