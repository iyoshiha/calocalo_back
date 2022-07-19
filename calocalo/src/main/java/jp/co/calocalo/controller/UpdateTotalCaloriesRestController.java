package jp.co.calocalo.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.entity.CaloriesRecordsJoinEmployeesEntity;
import jp.co.calocalo.entity.EmployeesJoinAdminEntity;
import jp.co.calocalo.form.UpdateTotalCaloriesForm;
import jp.co.calocalo.repository.CaloriesRecordsJoinEmployeesRepository;
import jp.co.calocalo.repository.EmployeesJoinAdminRepository;

@RestController
@RequestMapping("submit/food")
@CrossOrigin
public class UpdateTotalCaloriesRestController {
	
	@Autowired
	CaloriesRecordsJoinEmployeesRepository caloriesRecordsRepository;
	
	@Autowired
	EmployeesJoinAdminRepository employeesRepository;
	
	@PutMapping("/{emp_id}")
	@ResponseBody
	@Nullable
	public Map<String, Boolean> updateTotalCalories(@PathVariable int emp_id, @RequestBody UpdateTotalCaloriesForm updateTotalCaloriesForm) {
		
//		パラメータ(emp_id,dat, )を変数に入れる
		Date date = updateTotalCaloriesForm.getDate();
		
		Integer takeCalorie = updateTotalCaloriesForm.getTake_calorie();
		
//		上記パラメータをからtotal_caloriesとList一括データをとる
		Integer totalCalories = caloriesRecordsRepository.findByDateAndEmpId(date, emp_id);
		CaloriesRecordsJoinEmployeesEntity getCaloriesRecords = caloriesRecordsRepository.findRecordsByDateAndEmpId(date, emp_id);
		
//		新データを入れるインスタンスを作成
		CaloriesRecordsJoinEmployeesEntity newCaloriesRecords = new CaloriesRecordsJoinEmployeesEntity();
		EmployeesJoinAdminEntity employee = employeesRepository.getById(emp_id);
		
//		すでにtotal_caloriesがあるかで分岐
		if (totalCalories != null) {
			Integer newTotalCalories = totalCalories + takeCalorie;
			
			newCaloriesRecords.setRecord_id(getCaloriesRecords.getRecord_id());
			newCaloriesRecords.setEmployeesJoinAdminEntity(employee);
			newCaloriesRecords.setTotal_calories(newTotalCalories);
			newCaloriesRecords.setDate(date);
			
			caloriesRecordsRepository.save(newCaloriesRecords);
			
			Map<String, Boolean> success = new HashMap<>();
			success.put("success", true);
			
			return success;
			
		}else {
			
			newCaloriesRecords.setEmployeesJoinAdminEntity(employee);
			newCaloriesRecords.setTotal_calories(takeCalorie);
			newCaloriesRecords.setDate(date);
			
			caloriesRecordsRepository.save(newCaloriesRecords);
			
			Map<String, Boolean> success = new HashMap<>();
			success.put("success", true);
			
			return success;
			
		}
		
	}

}
