package com.egen.DAO;

import com.egen.DB.HibernateUtil;
import com.egen.Pojo.User;
import com.egen.UserResponse.UserResponse;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.*;

/**
 * Created by Sateesh on 10/1/2016.
 */
public class UserDAO {
    private static Logger LOGGER =Logger.getLogger(UserDAO.class);
    public static Session session;

    public UserResponse createUser(User user){
        UserResponse userResponse =new UserResponse();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try{
            session.save(user);
            session.getTransaction().commit();
            session.close();
            userResponse.setSuccess(true);
            userResponse.setDescription("Created user successfully");
            userResponse.setErrorCode(0);
            List<User> users =new ArrayList<User>();
            users.add(user);
            userResponse.setUserList(users);
            return userResponse;

        }catch (Exception e){
            LOGGER.trace("Exception While Creating User is :" + e);
            userResponse.setSuccess(false);
            userResponse.setDescription("User not Created");
            userResponse.setErrorCode(1);
            userResponse.setUserList(null);
            return userResponse;
        }

    }
    public UserResponse getUsers(){
        UserResponse userResponse =new UserResponse();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try{
            Criteria criteria =session.createCriteria(User.class);
            List Users =criteria.list();
            session.getTransaction().commit();

            session.close();
            userResponse.setSuccess(true);
            userResponse.setDescription("Fetched " + Users.size() + "users successfully");
            userResponse.setErrorCode(0);
            userResponse.setUserList(Users);
            return userResponse;
        }catch (Exception e){
            LOGGER.trace("Exception While getting Users is  :" + e);
            userResponse.setSuccess(false);
            userResponse.setDescription("Users not Fetched");
            userResponse.setErrorCode(1);
            userResponse.setUserList(null);
            return userResponse;
        }

    }
    public UserResponse updateUser(User user){
        UserResponse   userResponse =new UserResponse();
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        try{
            User user1 = (User)session.get(User.class,user.getId());
            if(user1!=null){
                user1.setFirstName(user.getFirstName());
                user1.setLastName(user.getLastName());
                user1.setAge(user.getAge());
                user1.setPhone(user.getPhone());
                user1.setGender(user.getGender());
                user1.setMiddleName(user.getMiddleName());
                session.saveOrUpdate(user1);
                session.getTransaction().commit();
                session.close();
                userResponse.setSuccess(true);
                userResponse.setDescription("Updated user successfully");
                userResponse.setErrorCode(0);
                List<User> users =new ArrayList<User>();
                users.add(user);
                userResponse.setUserList(users);
                return userResponse;
            }else{
                userResponse.setSuccess(false);
                userResponse.setDescription("User is not found");
                userResponse.setErrorCode(1);
                userResponse.setUserList(null);
                return userResponse;
            }


        }catch(Exception e){
            LOGGER.trace("Exception While updating User is  :" + e);
            userResponse.setSuccess(false);
            userResponse.setDescription("User not updated");
            userResponse.setErrorCode(1);
            userResponse.setUserList(null);
            return userResponse;
        }

    }
}
