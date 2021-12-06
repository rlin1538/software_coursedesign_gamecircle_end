package com.rlin.software_coursedesign.service;

import com.rlin.software_coursedesign.dao.CollectionDAO;
import com.rlin.software_coursedesign.dao.CommentDAO;
import com.rlin.software_coursedesign.pojo.Collection;
import com.rlin.software_coursedesign.pojo.Comment;
import com.rlin.software_coursedesign.pojo.GameCircle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {
    @Autowired
    CollectionDAO collectionDAO;

    public List<Collection> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "collectionID");
        return collectionDAO.findAll(sort);
    }

    public Collection get(int id) {
        return collectionDAO.findById(id).orElse(null);
    }
    public Collection get(Collection c) {
        return collectionDAO.findByUserIDAndGameCircle(c.getUserID(),c.getGameCircle());
    }
    public void add(Collection c) { collectionDAO.save(c); }

    public void delete(Collection c) { collectionDAO.delete(c); }

    public List<Collection> listByUserID(int id) {
        return collectionDAO.findAllByUserID(id);
    }
}

