package com.example.library.controller;

import com.example.library.entity.model.Book;
import com.example.library.service.BookService;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void getAllUserWithBorrowedOneTest() throws Exception {

        Book mockBook1 = new Book(
                1,
                "Fairytail1",
                "Author1",
                "Fairytail1",
                "O'Reilly1"
        );

        Book mockBook2 = new Book(
                2,
                "Fairytail2",
                "Author2",
                "Fairytail2",
                "O'Reilly2"
        );

        List<Book> bookList = new ArrayList<>();
        bookList.add(mockBook1);
        bookList.add(mockBook2);

        String expected = "" +
                "[{" +
                "\"id\":1," +
                "\"title\":\"Fairytail1\"," +
                "\"author\":\"Author1\"," +
                "\"genre\":\"Fairytail1\"," +
                "\"publisher\":\"O'Reilly1\"" +
                "},{" +
                "\"id\":2," +
                "\"title\":\"Fairytail2\"," +
                "\"author\":\"Author2\"," +
                "\"genre\":\"Fairytail2\"," +
                "\"publisher\":\"O'Reilly2\"" +
                "}]" +
                "";

        Mockito.when(
                bookService.getAllAvailableBooks()).thenReturn(ResponseEntity.ok(bookList));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/book/availableBooks")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

}
