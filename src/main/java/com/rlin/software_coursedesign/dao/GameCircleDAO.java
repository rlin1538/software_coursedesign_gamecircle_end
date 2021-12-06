package com.rlin.software_coursedesign.dao;

import com.rlin.software_coursedesign.pojo.GameCircle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameCircleDAO extends JpaRepository<GameCircle,Integer> {
    @Query(value="select * from gamecircle  where gameCircleTitle like CONCAT('%',:name,'%')",nativeQuery=true)
    List<GameCircle> findByGameCircleTitle(String name);
    List<GameCircle> findByGameCircleID(int id);
}
