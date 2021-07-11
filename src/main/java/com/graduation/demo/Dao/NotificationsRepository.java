package com.graduation.demo.Dao;

import com.graduation.demo.Model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications,Long> {

    @Query(value = "SELECT noti.* from notifications noti where noti.read=false AND noti.course_id = :course", nativeQuery = true)
    List<Notifications> findByCourseId(int course);

}
