package com.graduation.demo.service;
import com.graduation.demo.Dao.DoctorRepository;
import com.graduation.demo.Model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> saveDoctors(List<Doctor> doctors) {
        return doctorRepository.saveAll(doctors);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorByName(String name) {
        return doctorRepository.getDoctorByName(name);
    }

    @Override
    public boolean deleteDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor == null) return false;

        else doctorRepository.deleteById(id);
        return true;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        Doctor existingDoctor = doctorRepository.findById(doctor.getId()).orElse(null);
        existingDoctor.setName(doctor.getName());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setAddress(doctor.getAddress());

        return doctorRepository.save(existingDoctor);

    }


}
