package jp.co.calocalo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.entity.EmployeesJoinAdminEntity;
import jp.co.calocalo.repository.EmployeesJoinAdminRepository;

@RestController
@RequestMapping("/employee/info")
@CrossOrigin
public class GoalCaloriesRestController {
	
	@Autowired EmployeesJoinAdminRepository employeesAdminRepository;
	
	@GetMapping("/{emp_id}")
	public Map<String, Integer> GoalCalories(@PathVariable int emp_id) {
		EmployeesJoinAdminEntity employeesAdminEntity = employeesAdminRepository.getById(emp_id);
		int goalCalories = employeesAdminEntity.getGoal_calories();
		
		Map<String, Integer> goalCalo = new HashMap<>();
		
		goalCalo.put("goal_calorie", goalCalories);
		
		return goalCalo;
	}
}
