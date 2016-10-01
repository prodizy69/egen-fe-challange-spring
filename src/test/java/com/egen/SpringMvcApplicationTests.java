package com.egen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
/**
 * Created by Sateesh on 10/1/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringApplicationConfiguration(classes = SpringMvcApplication.class)
@WebAppConfiguration
public class SpringMvcApplicationTests {

	@Test
	public void contextLoads() {
	}

}
