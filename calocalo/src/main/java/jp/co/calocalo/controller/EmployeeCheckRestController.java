package jp.co.calocalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.calocalo.Dto.EmpCheckDto;
import jp.co.calocalo.repository.EmployeesJoinAdminRepository;

@RestController
@RequestMapping("/employee/check")
@CrossOrigin
public class EmployeeCheckRestController {
    
    @Autowired
    EmployeesJoinAdminRepository EmployeeRepository;
    
    
//  emp_idがすでにあるかチェック
    @GetMapping("/{emp_id}")
    public EmpCheckDto employeeCheck(@PathVariable int emp_id) {
        
    	EmpCheckDto empCheckDto = new EmpCheckDto();
    	
        if (EmployeeRepository.existsById(emp_id)) {
        	
            empCheckDto.setExistence(true);
            return empCheckDto;
        }else {
        	empCheckDto.setExistence(false);            
            return empCheckDto;
            
        }
    }

}

