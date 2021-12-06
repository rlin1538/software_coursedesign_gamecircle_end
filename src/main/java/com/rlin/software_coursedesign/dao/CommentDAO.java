package com.rlin.software_coursedesign.dao;

import com.rlin.software_coursedesign.pojo.Comment;
import com.rlin.software_coursedesign.pojo.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDAO extends JpaRepository<Comment,Integer> {
    List<Comment> findAllByPostID(int postID);

    List<Comment> findAllByUserName(String name);
}
