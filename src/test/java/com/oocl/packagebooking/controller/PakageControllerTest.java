package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.dao.PakageRepostitory;
import com.oocl.packagebooking.entity.Pakage;
import com.oocl.packagebooking.service.PakageService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PakageControllerTest {
    @Autowired
    private PakageRepostitory pakageRepostitory;
    @Autowired
    private PakageService pakageService;
    @Autowired
    MockMvc mockMvc;
    @BeforeEach
    public void addPakage(){
        Pakage pakage =  new Pakage();
        pakage.setName("yyyy");
        pakage.setPhone("131321321");
        pakage.setStatus(1);
        Long time = Long.valueOf(201315464);
        pakageRepostitory.save(pakage);
    }
    @Test
    public void should_return_ok__when_add_pakage() throws Exception {
        //given
        Pakage pakage =  new Pakage();
        pakage.setName("xxxx");
        pakage.setPhone("131321321");
        pakage.setStatus(1);
        Long time = Long.valueOf(201315464);
        pakage.setTime(time);
        JSONObject jsonObject = new JSONObject(pakage);
        //when//then
        this.mockMvc.perform(post("/pakages").content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
    @Test
    public void should_return_all_pakage_when_send_get_request() throws Exception {
        //given//when//then
        this.mockMvc.perform(get("/pakages")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_pakages_when_send_status_1_request() throws Exception {
        //given// when
        String result= this.mockMvc.perform(get("/pakages/").param("page","1")
                .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        //then
        JSONArray jsonArray = new JSONArray(result);
        Assertions.assertEquals("yyyy",jsonArray.getJSONObject(0).getString("name"));
    }
    @Test
    public void should_update_pakages_status_and_time_when__patch() throws Exception {
        //given// when
        String result= this.mockMvc.perform(patch("/pakages/").param("id","1").param("time","12223455")
                .contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        //then
        JSONArray jsonArray = new JSONArray(result);
        Assertions.assertEquals("yyyy",jsonArray.getJSONObject(0).getString("name"));
    }

}
