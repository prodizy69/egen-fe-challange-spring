package com.egen;

import com.egen.DB.HibernateUtil;
import com.egen.Pojo.User;
import com.egen.UserResponse.UserResponse;
import com.egen.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.nio.charset.Charset;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Sateesh on 10/1/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest extends SpringMvcApplicationTests {
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    public static UUID uuid= UUID.randomUUID();
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }
    @Test
    public void createUser() throws Exception {

        User positiveUser =new User(uuid,"Sateesh","Lenin","Dubasi",26,"M","9949918498","500056");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(positiveUser);

        mockMvc.perform(post("/createUser").contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));


    }

    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(get("/getUsers").contentType(APPLICATION_JSON_UTF8)
               )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));

    }

    /*
    Positive test case for update user, where you find the user from database
     */
    @Test
    public void updateUser() throws Exception {

        User positiveUser = new User(uuid,"India","America","Germany",28,"M","9949978956","526356");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(positiveUser);

        mockMvc.perform(post("/updateUser").contentType(APPLICATION_JSON_UTF8).content(requestJson)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));


    }
    /*
    Negative test case for update user, where you don't find the user from database
     */
    @Test
    public void updateUser_2() throws Exception {
        UUID uuid1 =UUID.randomUUID();
        User negativeUser = new User(uuid1,"India","America","Germany",28,"M","9949978956","526356");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(negativeUser);

        mockMvc.perform(post("/updateUser").contentType(APPLICATION_JSON_UTF8).content(requestJson)
        )
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false));


    }

}
