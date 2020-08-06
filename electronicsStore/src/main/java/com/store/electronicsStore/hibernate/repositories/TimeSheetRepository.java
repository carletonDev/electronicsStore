package com.store.electronicsStore.hibernate.repositories;

import com.store.electronicsStore.hibernate.pojos.TimeSheet;
import com.store.electronicsStore.hibernate.pojos.Users;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet,Integer> {

  @Query(value = "SELECT timesheet FROM TimeSheet timesheet WHERE timesheet.users=?1")
  List<TimeSheet> findTimesheetsByUser(Users user);
}
