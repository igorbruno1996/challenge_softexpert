package com.softexpert.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softexpert.challenge.service.OrderService;
import com.softexpert.challenge.util.OrderBeanGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldReturnOkStatus() throws Exception {

        given(this.orderService.calculateOrder(any())).willReturn(20.0);
        this.mvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON).content(this.mapper
                        .writeValueAsString(OrderBeanGeneratorUtil.getOrderBean())))
                .andExpect(status().isOk())
                .andExpect(content().string("https://picpay.me/mistersonya/20.0"));

    }
}
