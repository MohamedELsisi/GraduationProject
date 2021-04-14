package com.graduation.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class HistroicalData {
    @Id
    private Long id;
    private Long course_id;
    private Long doctor_id;
    private Long term_id;
    private Long student_id;
    @OneToMany
    private Set<Course> courses;
    @OneToMany
    private Set<Doctor> doctors;

}
