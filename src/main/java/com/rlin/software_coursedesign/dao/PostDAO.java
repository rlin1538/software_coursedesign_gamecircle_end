package com.rlin.software_coursedesign.dao;

import com.rlin.software_coursedesign.pojo.Post;
import javafx.geometry.Pos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostDAO extends JpaRepository<Post,Integer> {
    List<Post> findAllByPostCircle(int postCircle);

    List<Post> findAllByPoster(String poster);
}
