package com.egen.services;

import com.egen.DAO.UserDAO;
import com.egen.Pojo.User;
import com.egen.UserResponse.UserResponse;
import org.apache.log4j.Logger;


/**
 * Created by Sateesh on 10/1/2016.
 */
public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class);
    UserDAO userDAo= new UserDAO();

    public UserResponse createUser(User user){
        UserResponse userResponse=new UserResponse();
        if(user.getPhone().length()==10){
            userResponse=  userDAo.createUser(user);

        }else if(user.getPhone().length()<10){
            logger.info("Phone number contains less than 10 digits");
            userResponse.setSuccess(false);
            userResponse.setDescription("Phone number contains less than 10 digits");
            userResponse.setErrorCode(1);
            userResponse.setUserList(null);
            return userResponse;
        }else if(user.getPhone().length()>10){
            logger.info("Phone number contains more than 10 digits");
            userResponse.setSuccess(false);
            userResponse.setDescription("Phone number contains more than 10 digits");
            userResponse.setErrorCode(2);
            userResponse.setUserList(null);
            return userResponse;
        }
        return userResponse;

    }
    public UserResponse getUsers(){
        UserResponse userResponse =new UserResponse();
        userResponse=userDAo.getUsers();
        return userResponse;
    }
    public UserResponse updateUser(User user){
        UserResponse updateUser=new UserResponse();
        if(user.getPhone().length()==10){
            updateUser=  userDAo.updateUser(user);

        }else if(user.getPhone().length()<10){
            logger.info("Phone number contains less than 10 digits");
            updateUser.setSuccess(false);
            updateUser.setDescription("Phone number contains less than 10 digits");
            updateUser.setErrorCode(1);
            updateUser.setUserList(null);
            return updateUser;
        }else if(user.getPhone().length()>10){
            logger.info("Phone number contains more than 10 digits");
            updateUser.setSuccess(false);
            updateUser.setDescription("Phone number contains more than 10 digits");
            updateUser.setErrorCode(2);
            updateUser.setUserList(null);
            return updateUser;
        }
        return updateUser;
    }
}
