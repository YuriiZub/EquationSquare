package com.squareequantion.test;

import com.squareequantion.controller.EquantionController;
import com.squareequantion.model.EquantionsEntity;
import com.squareequantion.service.EquationSolutionImpl;
/*
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
*/
/*
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebConnection;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
*/

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * Created by Yurii on 5/3/2019.
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {WebConfig.class, EquantionsEntity.class, EquationSolutionImpl.class})
//@WebAppConfiguration

//@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(EquantionController.class)

//@WebMvcTest(TranslatorController.class)
//@ComponentScan("com.demo.service")

//@RunWith(SpringRunner.class)
//@WebMvcTest(UserVehicleController.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={EquantionsEntity.class, EquationSolutionImpl.class}, loader=SpringApplicationContextLoader.class)
//@SpringApplicationConfiguration(classes = WebConfig.class)
public class EquantionControllerTest {

    @Autowired
    protected WebApplicationContext context;


    //@Mock
    //private EquantionsEntity equantionsEntity = new EquantionsEntity(); //Repository
    //@InjectMocks
    //private EquationSolutionImpl solution = new EquationSolutionImpl();//Solution for calculation

    //private EquantionController controller;

    //@InjectMocks
    //private ApplicationContext applicationContext;

    private MockMvc mockMvc;




   // private static MockHttpServletRequest request;
    //private static MockHttpServletResponse response;


    /// / @Autowired
   // private WebApplicationContext context;
    //private WebClient webClient;

    @Before
    public void setup() {
      //  MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  //...
    }

    @Test
    public void getMainPage() throws Exception {


        this.mockMvc.perform(get("/")
                .andExpect(status().isOk())
                .andExpect(content().string("index"));

        /*
        given(this.userVehicleService.getVehicleDetails("sboot"))
                .willReturn(new VehicleDetails("Honda", "Civic"));

        this.mvc.perform(get("/sboot/vehicle")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("Honda Civic"));
    */
        /*
        this.mockMvc.perform(get("/")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk());
                //.andExpect(content().string("Honda Civic"));

        this.mockMvc.perform(get("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        */
    }

    //@Test
    public void calcSubmit() throws Exception {
    }

    @Test
    public void calcForm() throws Exception {
    }

}