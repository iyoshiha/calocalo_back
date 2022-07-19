package jp.co.calocalo.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.Dto.TotalCaloriesDto;
import jp.co.calocalo.form.DateForm;
import jp.co.calocalo.repository.CaloriesRecordsJoinEmployeesRepository;

@RestController
@RequestMapping("/employee/take_calorie")
@CrossOrigin
public class TotalCaloriesRestController {
	
	@Autowired
	CaloriesRecordsJoinEmployeesRepository caloriesRecordsRepository;

	@PostMapping("/{emp_id}")
	@Nullable
	public TotalCaloriesDto takeTotalCalories(@PathVariable int emp_id, @RequestBody DateForm dateForm) {
		
		TotalCaloriesDto totalCaloriesDto = new TotalCaloriesDto();
		Date date = dateForm.getDate();
		Integer totalCalories = caloriesRecordsRepository.findByDateAndEmpId(date, emp_id);
		
//		すでにtotal_caloriesを持っているかで分岐。
		if (totalCalories != null) {
			totalCaloriesDto.setTotal_calories(totalCalories);
			totalCaloriesDto.setDate(date);
			totalCaloriesDto.setExistence(true);
			
			return totalCaloriesDto;
		}else {
			
			totalCaloriesDto.setTotal_calories(null);
			totalCaloriesDto.setDate(null);
			totalCaloriesDto.setExistence(false);
			
			return totalCaloriesDto;
		}
		
	}
	
}
