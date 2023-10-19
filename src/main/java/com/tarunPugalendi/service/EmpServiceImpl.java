package com.tarunPugalendi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarunPugalendi.model.Emp;
import com.tarunPugalendi.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpRepository emprepo;

	@Override
	public Emp createEmp(Emp emp) {
		return emprepo.save(emp);
	}

	@Override
	public List<Emp> getAllEmp() {
		return emprepo.findAll();
	}

	@Override
	public Emp getEmpById(int id) {
		return emprepo.findById(id).get();
	}

	@Override
	public void deleteEmp(int id) {
		Emp emp = emprepo.findById(id).get();
		if(emp!=null) {
			emprepo.delete(emp);
		}
	}

	@Override
	public Emp updateEmp(int id, Emp emp) {
		Emp oldemp =  emprepo.findById(id).get();
		if(oldemp!=null){
			emp.setId(id);
			return emprepo.save(emp);
		}
		return null;
	}
	
}
