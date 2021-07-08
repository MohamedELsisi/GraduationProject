package com.graduation.demo.service;

import com.graduation.demo.Dao.DoctorRepository;
import com.graduation.demo.Dao.LoginRepository;
import com.graduation.demo.Model.Doctor;
import com.graduation.demo.Model.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private LoginRepository loginRepository;


    @Override
    public Doctor saveDoctor(Doctor doctor) {
        log.info("calling Save_Doctor service with Object " + doctor);
        Doctor existingDoctor = doctorRepository.save(doctor);

        Login login = new Login();
        login.setEmail(doctor.getEmail());
        login.setPassword(doctor.getPassword());
        login.setType("doctor");
        login.setUserName(doctor.getUserName());
        login.setId(existingDoctor.getId());
        loginRepository.save(login);


        if (existingDoctor == null)
            log.warn("Save_Doctor With object  is null ");
        else
            log.info("Save_Doctor With object response ");
        return existingDoctor;

    }

    @Override
    public List<Doctor> saveDoctors(List<Doctor> doctors) {
        log.info("calling save doctors list service ");

        List<Doctor> existingDoctor = doctorRepository.saveAll(doctors);
        if (existingDoctor == null)
            log.warn("save doctors list  is null ");
        else
            log.info("save doctors list response ");
        return existingDoctor;
    }

    @Override
    public Doctor getDoctorById(Long id) {
        log.info("calling get doctor by id  service with id " + id);
        Doctor existingDoctor = doctorRepository.findById(id).orElse(null);
        if (existingDoctor == null)
            log.warn("get doctor with id is null ");
        else
            log.info("get doctor by id response ");
        return existingDoctor;

    }

    @Override
    public List<Doctor> getAllDoctors() {
        log.info("calling get All_Doctor service  ");
        List<Doctor> existingDoctors = doctorRepository.findAll();
        if (existingDoctors == null)
            log.warn("get All_Doctor is null ");
        else
            log.info("get All_Doctor response ");

        return existingDoctors;

    }

    @Override
    public Doctor getDoctorByName(String name) {
        log.info("calling get_Doctor_By_Name service  " + name);
        Doctor existingDoctor = doctorRepository.getDoctorByName(name);
        if (existingDoctor == null)
            log.warn("get Doctor By Name is null ");
        else
            log.info("get Doctor By Name response ");

        return existingDoctor;

    }

    @Override
    public Doctor getDoctorByEmail(String email) {
        log.info("calling get_Doctor_By_Email service  " + email);
        Doctor existingDoctor = doctorRepository.getDoctorByEmail(email);
        if (existingDoctor == null)
            log.warn("get Doctor By email is null ");
        else
            log.info("get Doctor By email response ");

        return existingDoctor;
    }


    @Override
    public boolean deleteDoctorById(Long id) {
        log.info("calling delete_Doctor_By_Id service " + id);
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor == null) {
            log.warn("delete Doctor By Id is null ");
            return false;
        } else {
            log.info("delete Doctor By Id response ");
            doctorRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        log.info("calling  update_Doctor service " + doctor);
        Doctor existingDoctor = doctorRepository.findById(doctor.getId()).orElse(null);
        if (existingDoctor == null) log.warn("get Doctor By Name service is null ");
        else
            log.info("update Doctor response ");
        existingDoctor.setName(doctor.getName());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setAddress(doctor.getAddress());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setUserName(doctor.getUserName());
        existingDoctor.setPassword(doctor.getPassword());

        Login existingLogin=loginRepository.findByUserName(doctor.getUserName());
        existingLogin.setUserName(doctor.getUserName());
        existingLogin.setPassword(doctor.getPassword());
        existingLogin.setEmail(doctor.getEmail());
        loginRepository.save(existingLogin);
        doctorRepository.save(existingDoctor);
        return existingDoctor;

    }


}
