package com.rlin.software_coursedesign.service;

import com.rlin.software_coursedesign.dao.GameCircleDAO;
import com.rlin.software_coursedesign.pojo.GameCircle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameCircleService {
    @Autowired
    GameCircleDAO gameCircleDAO;

    public List<GameCircle> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "GameCircleID");
        return gameCircleDAO.findAll(sort);
    }

    public List<GameCircle> get(String name) {
        return gameCircleDAO.findByGameCircleTitle(name);
    }
    public List<GameCircle> get(int id) {
        return gameCircleDAO.findByGameCircleID(id);
    }
    public void add(GameCircle gameCircle) { gameCircleDAO.save(gameCircle); }

    public void delete(GameCircle gameCircle) { gameCircleDAO.deleteById(gameCircle.getGameCircleID());}
}

