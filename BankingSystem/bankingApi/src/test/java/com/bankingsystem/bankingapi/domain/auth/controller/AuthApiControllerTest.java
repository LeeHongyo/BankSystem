package com.bankingsystem.bankingapi.domain.auth.controller;

import com.bankingsystem.bankingapi.controller.AuthApiController;
import com.bankingsystem.bankingapi.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(AuthApiController.class)
public class AuthApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @Test
    public void testLogin() throws Exception {
        // Mock AuthService의 동작을 설정할 수 있습니다. 예: when(authService.login(...)).thenReturn(...);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login")
                        .param("username", "testUser")
                        .param("password", "password"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(org.hamcrest.Matchers.notNullValue()));
    }
}
