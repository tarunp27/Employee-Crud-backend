package com.tarunPugalendi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarunPugalendi.model.Emp;
import com.tarunPugalendi.service.EmpService;

@CrossOrigin(origins="http://localhost:3000")
@Controller
@RequestMapping("/api/v1")
public class EmpController {
	
	@Autowired
	private EmpService empservice;
	
	@PostMapping("/save")
	public ResponseEntity<Emp> createEmp(@RequestBody Emp emp){
		return new ResponseEntity<Emp>(empservice.createEmp(emp),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Emp>> getAllEmp(){
		return new ResponseEntity<List<Emp>>(empservice.getAllEmp(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emp> getEmpById(@PathVariable int id){
		return new ResponseEntity<Emp>(empservice.getEmpById(id),HttpStatus.OK) ;
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id){
		empservice.deleteEmp(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Emp> updateEmp(@PathVariable int id,@RequestBody Emp emp){
		return new ResponseEntity<Emp>(empservice.updateEmp(id, emp),HttpStatus.OK); 
	}
}
	