package com.smartkyc.domino.infrastruture.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartkyc.domino.application.DominoCalculatorFacade;
import com.smartkyc.domino.domain.DominoSet;
import com.smartkyc.domino.domain.Tile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DominoResource.class)
public class DominoResourceTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private DominoCalculatorFacade facade;


    @Test
    void testEmptyInputBody() throws Exception {
        DominoSet input = new DominoSet();
        String body = objectMapper.writeValueAsString(input);

        mvc.perform(post("/highest-value-chain")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testInputBodyWithMoreThanTenTile() throws Exception {
        DominoSet input = new DominoSet(new Tile[]{new Tile(1, 11)});
        String body = objectMapper.writeValueAsString(input);

        mvc.perform(post("/highest-value-chain")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testInputBodyWithLessThanZeroTile() throws Exception {
        DominoSet input = new DominoSet(new Tile[]{new Tile(-1, 6)});
        String body = objectMapper.writeValueAsString(input);

        mvc.perform(post("/highest-value-chain")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testInputBodyWithTilesWithEqualNumbers() throws Exception {
        DominoSet input = new DominoSet(new Tile[]{new Tile(6, 6)});
        String body = objectMapper.writeValueAsString(input);

        mvc.perform(post("/highest-value-chain")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());
    }
}
