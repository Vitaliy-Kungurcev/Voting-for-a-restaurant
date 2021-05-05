package com.example.lunch.repository;


import com.example.lunch.entity.Choise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ChoiseRepository extends JpaRepository<Choise,Integer> {

    Choise findByUserNameAndDate(String userName,LocalDate date);

    @Query(value = "select * from choise where date=:localDate order by count(*)over(partition by rest_name)desc",nativeQuery=true)
    List<Choise> getChoiseDate(@Param("localDate") LocalDate localDate);


}
