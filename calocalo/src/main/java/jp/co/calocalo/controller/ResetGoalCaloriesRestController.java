package jp.co.calocalo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.entity.AdminEntity;
import jp.co.calocalo.entity.EmployeesJoinAdminEntity;
import jp.co.calocalo.form.GoalCaloUpdateForm;
import jp.co.calocalo.repository.AdminRepository;
import jp.co.calocalo.repository.EmployeesJoinAdminRepository;

@RestController
@RequestMapping("/mypage/setting")
@CrossOrigin
public class ResetGoalCaloriesRestController {

	@Autowired EmployeesJoinAdminRepository employeesAdminRepository;
	
	@Autowired AdminRepository adminRepository;
	
	@Autowired EmployeesJoinAdminRepository employeesJoinAdminRepository;

	//カロリーの再設定
	@PutMapping("/{emp_id}")
	public  Map<String, Boolean> signUp(@PathVariable int emp_id, @RequestBody GoalCaloUpdateForm form) {
		
		EmployeesJoinAdminEntity reCaloEntity = new EmployeesJoinAdminEntity();
		AdminEntity admin = adminRepository.getById(1);
		EmployeesJoinAdminEntity employee = employeesJoinAdminRepository.getById(emp_id);

//		データの再代入からの保存
		reCaloEntity.setEmp_id(emp_id);
		reCaloEntity.setGoal_calories(form.getGoal_calorie());
		reCaloEntity.setAdminEntity(admin);
		reCaloEntity.setPassword(employee.getPassword());
		employeesAdminRepository.save(reCaloEntity);
		
		Map<String, Boolean> success = new HashMap<>();
		success.put("success", true);
		
		return success;
		
	}
}
