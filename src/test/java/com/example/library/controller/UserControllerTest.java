package com.example.library.controller;

import com.example.library.entity.model.User;
import com.example.library.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getAllUserWithBorrowedOneTest() throws Exception {

        List<User> userList = createMockUserList();

        String expected = "" +
                "[{" +
                "\"id\":1," +
                "\"name\":\"Jonhon\"," +
                "\"firstName\":\"John\"," +
                "\"memberSince\":\"2022-09-28\"," +
                "\"memberTill\":\"2022-09-28\"," +
                "\"gender\":\"m\"" +
                "},{" +
                "\"id\":2," +
                "\"name\":\"Jonhona\"," +
                "\"firstName\":\"Johna\"," +
                "\"memberSince\":\"2022-09-28\"," +
                "\"memberTill\":\"2022-09-28\"," +
                "\"gender\":\"f\"" +
                "}]" +
                "";

        Mockito.when(
                userService.getAllUserWithBorrowedOne()).thenReturn(ResponseEntity.ok(userList));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user/borrowedOne")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void getAllUserNotBorrowedAnythingTest() throws Exception {

        List<User> userList = createMockUserList();

        String expected = "" +
                "[{" +
                "\"id\":1," +
                "\"name\":\"Jonhon\"," +
                "\"firstName\":\"John\"," +
                "\"memberSince\":\"2022-09-28\"," +
                "\"memberTill\":\"2022-09-28\"," +
                "\"gender\":\"m\"" +
                "},{" +
                "\"id\":2," +
                "\"name\":\"Jonhona\"," +
                "\"firstName\":\"Johna\"," +
                "\"memberSince\":\"2022-09-28\"," +
                "\"memberTill\":\"2022-09-28\"," +
                "\"gender\":\"f\"" +
                "}]" +
                "";

        Mockito.when(
                userService.getAllUserWithoutBorrowedBooks()).thenReturn(ResponseEntity.ok(userList));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user/notBorrowedAnything")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    private List<User> createMockUserList() {
        User mockUser1 = new User(
                1,
                "Jonhon",
                "John",
                LocalDate.now(),
                LocalDate.now(),
                "m"
        );

        User mockUser2 = new User(
                2,
                "Jonhona",
                "Johna",
                LocalDate.now(),
                LocalDate.now(),
                "f"
        );

        List<User> userList = new ArrayList<>();
        userList.add(mockUser1);
        userList.add(mockUser2);
        return userList;
    }
}
