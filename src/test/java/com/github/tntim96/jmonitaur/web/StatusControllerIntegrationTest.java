package com.github.tntim96.jmonitaur.web;

import com.github.tntim96.jmonitaur.WebUiApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebUiApplication.class)
public class StatusControllerIntegrationTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testIndex() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>JMonitaur - Status</title>")))
                .andExpect(content().string(containsString("<td>{{status.level}}</td>")))
                .andExpect(content().string(containsString("<td>{{status.systemId}}</td>")))
                .andExpect(content().string(containsString("<td>{{status.description}}</td>")))
                .andExpect(xpath("//div[@id='site_footer']").string("Footer"));
    }

    @Test
    public void testStatus() throws Exception {
        this.mockMvc.perform(get("/status"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>JMonitaur - Status</title>")))
                .andExpect(xpath("//table[@class='healthTable']/tr[2]/td[1]").string("CRITICAL"))
                .andExpect(xpath("//table[@class='healthTable']/tr[2]/td[2]").string("Shields"))
                .andExpect(xpath("//table[@class='healthTable']/tr[2]/td[3]").string("30% power"))
                .andExpect(xpath("//div[@id='site_footer']").string("Footer"));
    }

    @Test
    public void testStatusJSON() throws Exception {
        this.mockMvc.perform(get("/statusJSON"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("[0].level").value("CRITICAL"))
                .andExpect(jsonPath("[0].systemId").value("Shields"))
                .andExpect(jsonPath("[0].description").value("30% power"));
    }
}