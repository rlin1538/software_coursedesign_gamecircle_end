package com.rlin.software_coursedesign.service;

import com.rlin.software_coursedesign.dao.CommentDAO;
import com.rlin.software_coursedesign.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;

    public List<Comment> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "commentID");
        return commentDAO.findAll(sort);
    }

    public Comment get(int id) {
        return commentDAO.findById(id).orElse(null);
    }

    public List<Comment> listByPostID(int id) {
        return commentDAO.findAllByPostID(id);
    }

    public List<Comment> listByUserName(String name) {
        return commentDAO.findAllByUserName(name);
    }

    public void add(Comment comment) {
        commentDAO.save(comment);
    }

    public void delete(Comment comment) {
        commentDAO.deleteById(comment.getCommentID());
    }
}

