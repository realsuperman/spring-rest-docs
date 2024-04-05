package com.restdocs.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

@AutoConfigureRestDocs
@WebMvcTest(MemberController.class)
class MemberControllerTest {
    @Autowired private MockMvc mockMvc;

    @Test
    void findMember() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/" ))
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcRestDocumentation.document("test",
                        Preprocessors.preprocessRequest(prettyPrint()),
                        Preprocessors.preprocessResponse(prettyPrint())))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}