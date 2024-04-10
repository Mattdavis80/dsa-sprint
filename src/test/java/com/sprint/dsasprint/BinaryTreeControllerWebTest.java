package com.sprint.dsasprint;

import com.sprint.dsasprint.controller.BinaryTreeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sprint.dsasprint.service.BinaryTreeService;
import com.sprint.dsasprint.entity.BinaryTree;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(BinaryTreeController.class)
public class BinaryTreeControllerWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BinaryTreeService binaryTreeService;

    // TEST TO CHECK IF THE ENTER-NUMBERS ENDPOINT IS WORKING
    @Test
    public void enterNumbers_ShouldRenderView() throws Exception {
        mockMvc.perform(get("/enter-numbers"))
                .andExpect(status().isOk())
                .andExpect(content().string("enter-numbers"));
    }

    // TEST TO CHECK IF THE PROCESS-NUMBERS ENDPOINT IS WORKING
    @Test
    public void getPreviousTrees_ShouldReturnTrees() throws Exception {
        // Given
        List<BinaryTree> trees = Arrays.asList(new BinaryTree(), new BinaryTree());
        given(binaryTreeService.getPreviousTrees()).willReturn(trees);

        // When & Then
        mockMvc.perform(get("/previous-trees"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{},{}]"));
    }
}
