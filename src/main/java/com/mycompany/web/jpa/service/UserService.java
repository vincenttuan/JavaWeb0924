package com.mycompany.web.jpa.service;

import com.mycompany.web.jpa.dao.CustomerDAO;
import com.mycompany.web.jpa.entity.User;
import com.mycompany.web.jpa.dao.UserDAO;
import com.mycompany.web.jpa.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class UserService {
    private EntityManager em;
    private UserDAO dao;
    
    public UserService() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        dao = new UserDAO(em);
    }
    
    public boolean insert(String user_name, long user_age) {
        User user = new User();
        user.setName(user_name);
        user.setAge(user_age);
        return dao.insert(user);
    }
    
    public List<User> query() {
        return dao.query();
    }
    
    public User findById(Long id) {
        return dao.findById(id);
    }
    
    public boolean update(Long id, String name, Long age) {
        User user = findById(id);
        if(user == null) {
            return false;
        } else {
            user.setName(name);
            user.setAge(age);
            return dao.update(user);
        }
    }
    
    public boolean delete(Long id) {
        User user = findById(id);
        return (user == null) ? false : dao.delete(user);
    }
}
