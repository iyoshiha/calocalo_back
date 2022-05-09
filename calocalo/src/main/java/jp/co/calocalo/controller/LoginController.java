package jp.co.calocalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.Dto.LoginDto;
import jp.co.calocalo.entity.EmployeesJoinAdminEntity;
import jp.co.calocalo.form.LoginForm;
import jp.co.calocalo.repository.EmployeesJoinAdminRepository;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	EmployeesJoinAdminRepository employeesRepository;
	
	
	@PostMapping("{emp_id}")
	public LoginDto loginCheck(@PathVariable int emp_id,LoginForm loginForm) {
		
		
		if(employeesRepository.existsById(loginForm.getEmpId())) {
			
			EmployeesJoinAdminEntity employee =  employeesRepository.getById(emp_id);
			
			String empPass = employee.getPassword();
			
			if(loginForm.getPassword().equals(empPass)) {
				
				LoginDto loginDto = new LoginDto();
				loginDto.setLogin_status(true);
				int empAdminStatus = 1;
				loginDto.setAdmin_status(empAdminStatus);
				
				return loginDto;
			}else {
				LoginDto loginDto = new LoginDto();
				loginDto.setLogin_status(false);
				
				return loginDto;
			}
		}
		
		 LoginDto loginDto = new LoginDto();
		 loginDto.setLogin_status(false);
		 return loginDto;
		
	}
	
//	@GetMapping("{emp_id}")
//	public int loginCheck(@PathVariable int emp_id) {
//		
//		
//		if(employeesRepository.existsById(emp_id)) {
//			
//			EmployeesJoinAdminEntity employee =  employeesRepository.getById(emp_id);
//			
//			int employeeId = employee.getEmp_id();
//			
//			return employeeId;
//		}
//		
//		 
//		 return 8;
//		
//	}

}
