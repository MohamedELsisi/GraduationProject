package com.graduation.demo.service;

import com.graduation.demo.Dao.AssignDepartmentRepository;
import com.graduation.demo.Dao.DepartmentRepository;
import com.graduation.demo.Model.Department;
import com.graduation.demo.Model.Doctor;
import com.graduation.demo.Model.Level;
import com.graduation.demo.Model.LevelAndDep;
import com.graduation.demo.dto.AssignDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    @Autowired
    private AssignDepartmentRepository assignDepartmentRepository;

    @Override
    public Department addDepartment(Department department) {
        log.info("calling ADD_DEPARTMENT service with Object " + department);
        Department existingDepartment = repository.save(department);
        if (existingDepartment == null)
            log.warn(" ADD_DEPARTMENT With object  is null ");
        else
            log.info(" ADD_DEPARTMENT With object response " + existingDepartment);
        return existingDepartment;

    }

    @Override
    public List<Department> addAllDepartment(List<Department> departments) {
        log.info("Calling ADD_ALL_DEPARTMENT With LIst " + departments);
        List<Department> existingDepartments = repository.saveAll(departments);
        if (existingDepartments == null)
            log.warn("ADD_ALL_DEPARTMENT IS NULL");
        else
            log.info("ADD_ALL_DEPARTMENT RESPONSE" + existingDepartments);
        return existingDepartments;
    }

    @Override
    public Department getDepartmentById(Long id) {
        log.info("calling  GET_DEPARTMENT_BY_ID  service with id " + id);
        Department existingDepartment = repository.findById(id).orElse(null);
        if (existingDepartment == null)
            log.warn(" GET_DEPARTMENT_BY_ID  is null ");
        else
            log.info("GET_DEPARTMENT_BY_ID response " + existingDepartment);
        return existingDepartment;
    }

    @Override
    public List<Department> getAllDepartment() {
        log.info("calling  GET_ALL_DEPARTMENT service  ");
        List<Department> existingDepartment = repository.findAll();
        if (existingDepartment == null)
            log.warn("get GET_ALL_DEPARTMENT null ");
        else
            log.info("get GET_ALL_DEPARTMENT response " + existingDepartment);

        return existingDepartment;

    }

    @Override
    public Department getDepartmentByName(String name) {
        log.info("calling get_Department_By_Name service  " + name);
        Department existingDepartment = repository.findByName(name);
        if (existingDepartment == null)
            log.warn("get_Department_By_Name is null ");
        else
            log.info("get_Department_By_Name response " + existingDepartment);

        return existingDepartment;
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        log.info("calling delete_Department_By_Id service " + id);
        Department existingDepartment = repository.findById(id).orElse(null);
        if (existingDepartment == null) {
            log.warn("delete_Department_By_Id is null ");
            return false;
        } else {
            log.info("delete_Department_By_Id response " + existingDepartment);
            repository.deleteById(id);
            return true;
        }
    }


    @Override
    public Department updateDepartment(Department department) {
        log.info("calling  update_Department service " + department);
        Department existingDepartment = repository.findById(department.getId()).orElse(null);
        if (existingDepartment == null)
            log.warn(" update_Department is null");
        else
            log.info(" update_Department Response " + existingDepartment);
        existingDepartment.setName(department.getName());
        repository.save(existingDepartment);
        return existingDepartment;
    }

public void assignDepartment(AssignDepartment assignDepartment){

    for (Level level:assignDepartment.getLevels() ) {
        LevelAndDep levelAndDep = new LevelAndDep();
        levelAndDep.setLevel(level);
        levelAndDep.setDepartment(assignDepartment.getDepartment());

        assignDepartmentRepository.save(levelAndDep);
    }

}

}
