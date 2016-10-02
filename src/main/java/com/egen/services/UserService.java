package com.egen.services;

import com.egen.DAO.UserDAO;
import com.egen.ErrorCodes.ErrorCodes;
import com.egen.ErrorCodes.ErrorMessages;
import com.egen.Pojo.User;
import com.egen.UserResponse.UserResponse;
import org.apache.log4j.Logger;


/**
 * Created by Sateesh on 10/1/2016.
 */
/*
    UserService.java uses to connect UserDAO class.
 */
public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class);
    UserDAO userDAo= new UserDAO();

    public UserResponse createUser(User user){
        UserResponse userResponse=new UserResponse();
        if(user.getPhone().length()==ErrorCodes.PHONE_NUMBER_LENGTH){
            userResponse=  userDAo.createUser(user);

        }else if(user.getPhone().length()<ErrorCodes.PHONE_NUMBER_LENGTH){
            logger.info("Phone number contains less than 10 digits");
            userResponse.setSuccess(false);
            userResponse.setDescription(ErrorMessages.PHONE_NUMBER_LENGTH_MIN);
            userResponse.setErrorCode(ErrorCodes.ERROR_CODE_CREATE_USER_3);
            userResponse.setUserList(null);
            return userResponse;
        }else if(user.getPhone().length()>ErrorCodes.PHONE_NUMBER_LENGTH){
            logger.info("Phone number contains more than 10 digits");
            userResponse.setSuccess(false);
            userResponse.setDescription(ErrorMessages.PHONE_NUMBER_LENGTH_MAX);
            userResponse.setErrorCode(ErrorCodes.ERROR_CODE_CREATE_USER_4);
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
        if(user.getPhone().length()==ErrorCodes.PHONE_NUMBER_LENGTH){
            updateUser=  userDAo.updateUser(user);

        }else if(user.getPhone().length()<ErrorCodes.PHONE_NUMBER_LENGTH){
            logger.info("Phone number contains less than 10 digits");
            updateUser.setSuccess(false);
            updateUser.setDescription(ErrorMessages.PHONE_NUMBER_LENGTH_MIN);
            updateUser.setErrorCode(ErrorCodes.ERROR_CODE_CREATE_USER_3);
            updateUser.setUserList(null);
            return updateUser;
        }else if(user.getPhone().length()>ErrorCodes.PHONE_NUMBER_LENGTH){
            logger.info("Phone number contains more than 10 digits");
            updateUser.setSuccess(false);
            updateUser.setDescription(ErrorMessages.PHONE_NUMBER_LENGTH_MAX);
            updateUser.setErrorCode(ErrorCodes.ERROR_CODE_UPDATE_USERS_4);
            updateUser.setUserList(null);
            return updateUser;
        }
        return updateUser;
    }
}
