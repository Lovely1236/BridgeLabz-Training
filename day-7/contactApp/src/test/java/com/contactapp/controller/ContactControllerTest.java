package com.contactapp.controller;

import com.contactapp.model.Contact;
import com.contactapp.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ContactControllerTest {

    @Autowired
    private ContactRepository contactRepository;

        @Autowired
        private WebApplicationContext webApplicationContext;

        private MockMvc mockMvc;

        @BeforeEach
        void setUp() {
                mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        }

    @Test
    void shouldCreateAndFetchContacts() throws Exception {
        contactRepository.deleteAll();

        mockMvc.perform(post("/api/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"Alice","email":"alice@example.com","phone":"1234567890"}
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Alice"));

        mockMvc.perform(get("/api/contacts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].email").value("alice@example.com"));
    }

        @Test
        void shouldRejectInvalidContactPayload() throws Exception {
                contactRepository.deleteAll();

                mockMvc.perform(post("/api/contacts")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content("""
                                                                {"name":"","email":"not-an-email","phone":"12"}
                                                                """))
                                .andExpect(status().isBadRequest());
        }

    @Test
    void shouldDeleteContact() throws Exception {
        Contact contact = new Contact();
        contact.setName("Bob");
        contact.setEmail("bob@example.com");
        contact.setPhone("9876543210");
        Contact savedContact = contactRepository.save(contact);

        mockMvc.perform(delete("/api/contacts/{id}", savedContact.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/contacts/{id}", savedContact.getId()))
                .andExpect(status().isNotFound());
    }
}