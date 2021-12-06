package com.rlin.software_coursedesign.dao;

import com.rlin.software_coursedesign.pojo.Collection;
import com.rlin.software_coursedesign.pojo.GameCircle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionDAO extends JpaRepository<Collection,Integer> {
    List<Collection> findAllByUserID(int userID);
    Collection findByUserIDAndGameCircle(int userID, GameCircle gameCircle);
}
