package com.rlin.software_coursedesign.service;

import com.rlin.software_coursedesign.dao.PostDAO;
import com.rlin.software_coursedesign.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostDAO postDAO;

    public List<Post> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "postID");
        return postDAO.findAll(sort);
    }

    public Post get(int id) {
        return postDAO.findById(id).orElse(null);
    }
    public void add(Post post) { postDAO.save(post); }

    public List<Post> listByCircle(int id) {
        return postDAO.findAllByPostCircle(id);
    }
    public List<Post> listByUser(String name) {
        return postDAO.findAllByPoster(name);
    }

    public void delete(Post post) {
        postDAO.deleteById(post.getPostID());
    }
}

