package com.graduation.demo.Dao;

import com.graduation.demo.Model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications,Long> {

    @Query(value = "SELECT notifications.* from notifications where read=false AND courseId = :course", nativeQuery = true)
    List<Notifications> findByCourseId(int courseId);

}
