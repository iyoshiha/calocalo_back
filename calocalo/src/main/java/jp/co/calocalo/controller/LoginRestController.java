package jp.co.calocalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.Dto.LoginDto;
import jp.co.calocalo.entity.EmployeesJoinAdminEntity;
import jp.co.calocalo.form.LoginForm;
import jp.co.calocalo.repository.EmployeesJoinAdminRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginRestController {
	
	@Autowired
	EmployeesJoinAdminRepository employeesRepository;
	
	
	@PostMapping("/{emp_id}")
	@ResponseBody
	public LoginDto loginCheck(@PathVariable int emp_id,@RequestBody LoginForm loginForm) {

		LoginDto loginDto = new LoginDto();
		
//		emp_idから、データの存在を確認
		if(employeesRepository.existsById(emp_id)) {
			
			EmployeesJoinAdminEntity employee =  employeesRepository.getById(emp_id);
			String empPass = employee.getPassword();
			
//			パラメーターのpassとDBのpassを比較。is_deletedの確認。
			if(loginForm.getPassword().equals(empPass) && employee.isIs_deleted() == false) {
				
				loginDto.setLogin_status(true);
				loginDto.setAdmin_id(employee.getEmpAdminId());
				
				return loginDto;
			}else {
				
				loginDto.setLogin_status(false);
				loginDto.setAdmin_id(null);
				
				return loginDto;
			}
		}else {
			
			loginDto.setLogin_status(false);
			loginDto.setAdmin_id(null);		
			
			return loginDto;
			
		}
		
	}
	
}
