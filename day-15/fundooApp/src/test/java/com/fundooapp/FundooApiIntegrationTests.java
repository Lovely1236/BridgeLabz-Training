package com.fundooapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FundooApiIntegrationTests {
    @Autowired MockMvc mvc;

    @Test
    void signupLoginAndProtectedEndpointWork() throws Exception {
        String body = "{\"firstName\":\"Lovely\",\"lastName\":\"Pandey\",\"email\":\"lovely-" + System.nanoTime() + "@example.com\",\"password\":\"password123\"}";
        String auth = mvc.perform(post("/user/userSignUp").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isCreated()).andExpect(jsonPath("$.token").isString()).andReturn().getResponse().getContentAsString();
        String token = auth.replaceAll(".*\\\"token\\\":\\\"([^\\\"]+)\\\".*", "$1");
        mvc.perform(get("/notes/getNotesList")).andExpect(status().isUnauthorized());
        mvc.perform(get("/notes/getNotesList").header("Authorization", "Bearer " + token)).andExpect(status().isOk());
    }

    @Test
    void duplicateEmailIsRejected() throws Exception {
        String email = "duplicate-" + System.nanoTime() + "@example.com";
        String body = "{\"firstName\":\"A\",\"lastName\":\"User\",\"email\":\"" + email + "\",\"password\":\"password123\"}";
        mvc.perform(post("/user/userSignUp").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isCreated());
        mvc.perform(post("/user/userSignUp").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isBadRequest());
    }
}
