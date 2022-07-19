package jp.co.calocalo.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.calocalo.entity.CaloriesRecordsJoinEmployeesEntity;


public interface CaloriesRecordsJoinEmployeesRepository extends 
	JpaRepository<CaloriesRecordsJoinEmployeesEntity, Integer> {
	
	@Query(value = "SELECT total_calories FROM calories_records WHERE date = :date AND emp_id = :emp_id", nativeQuery = true)
	Integer findByDateAndEmpId(@Param("date") Date date, @Param("emp_id") int emp_id);
	
	@Query(value = "SELECT * FROM calories_records WHERE date = :date AND emp_id = :emp_id", nativeQuery = true)
	CaloriesRecordsJoinEmployeesEntity findRecordsByDateAndEmpId(@Param("date") Date date, @Param("emp_id") int emp_id);

}
