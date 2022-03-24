package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUserData(){return userRepository.findAll();}


    public boolean validateUser(String userid, String password,User user){
        /*Session session = sessionFactory.getCurrentSession();
        User currentUser = session.get(User.class,user.getUserId());*/
        System.out.println();
        System.out.println(userid);
        System.out.println(password);
       // System.out.println(currentUser.getUserId());
        return userid.equals("hari")
                && password.equals("hari");
        /*return userid.equals(currentUser.getUserId())
                && password.equals(currentUser.getPassword());*/
    }
}
