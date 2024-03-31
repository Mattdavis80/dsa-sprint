package com.sprint.dsasprint.controller;

import com.sprint.dsasprint.entity.BinaryTree;
import com.sprint.dsasprint.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    @GetMapping("/enter-numbers")
    public String enterNumbers(){
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public BinaryTree createBinaryTree(@RequestBody String userInputBinaryTree){
        System.out.println(userInputBinaryTree);
        return binaryTreeService.createBinaryTree(userInputBinaryTree);
    }

    @GetMapping("/process-numbers")
    public String processNumbers(){
        return "process Numbers";
    }

    @GetMapping("/previous-trees")
    public List<BinaryTree> getPreviousTrees(){
        return binaryTreeService.getPreviousTrees();
    }
}

