package jp.co.calocalo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.entity.AdminEntity;
import jp.co.calocalo.entity.EmployeesJoinAdminEntity;
import jp.co.calocalo.form.SignUpForm;
import jp.co.calocalo.repository.EmployeesJoinAdminRepository;

@RestController
@RequestMapping("/signup")
@CrossOrigin
public class SignUpRestController {

	@Autowired EmployeesJoinAdminRepository employeesJoinAdminRepository;
	
//	データの保存

	@PostMapping
	public  Map<String, Boolean> signUp(@RequestBody SignUpForm signUpForm) {
		
		EmployeesJoinAdminEntity employeesJoinAdmin = formToAddEmployeesJoinAdminEntity(signUpForm);
		employeesJoinAdminRepository.save(employeesJoinAdmin);
		
		Map<String, Boolean> success = new HashMap<>();
		success.put("success", true);
		
		return success;
		
	}
	
//	インスタンスに新データを挿入するメソッド
	private EmployeesJoinAdminEntity formToAddEmployeesJoinAdminEntity(@RequestBody SignUpForm signUpForm) {
		EmployeesJoinAdminEntity employeesJoinAdmin = new EmployeesJoinAdminEntity();
	
		employeesJoinAdmin.setEmp_id(signUpForm.getEmp_id());
		employeesJoinAdmin.setPassword(signUpForm.getPassword());
		employeesJoinAdmin.setGoal_calories(signUpForm.getGoal_calories());
		
		AdminEntity userInfo = new AdminEntity();
		userInfo.setAdmin_id(1);
		employeesJoinAdmin.setAdminEntity(userInfo);
		
		return employeesJoinAdmin;
	}
}