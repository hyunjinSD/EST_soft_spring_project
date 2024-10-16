package com.estsoft.springproject;

import com.estsoft.springproject.entity.Member;
import com.estsoft.springproject.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MemberRepository repository;

    @BeforeEach
    public void setUp() {
        // given : 멤버 목록 저장
    }

    @Test
    public void testGetAllMember() throws Exception {
        // when : GET /members
        ResultActions resultActions = mockMvc.perform(get("/members")
                .accept(MediaType.APPLICATION_JSON));

        // then : response 검증
        resultActions.andExpect(status().is2xxSuccessful());
//                .andExpect(jsonPath("$[0].id").value(1))
//                .andExpect(jsonPath("$[1].id").value(2));
    }
}
