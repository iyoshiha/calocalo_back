package jp.co.calocalo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.entity.FoodListEntity;
import jp.co.calocalo.repository.FoodListRepository;

@RestController
@RequestMapping("/food_list")
@CrossOrigin
public class FoodListRestController {
	
	@Autowired
	FoodListRepository foodListRepository;
	
	@GetMapping
	public Map<String, List<FoodListEntity>> findFoodList() {
		
		List<FoodListEntity> foodList = foodListRepository.findAll();
		
		Map<String, List<FoodListEntity>> foodListMap = new HashMap<>();
		foodListMap.put("foodList", foodList);
		
		return foodListMap;
	}
}
