package com.sprint.dsasprint.service;


import com.sprint.dsasprint.entity.BST;
import com.sprint.dsasprint.entity.BinaryTree;
import com.sprint.dsasprint.entity.BinaryTreeNode;
import com.sprint.dsasprint.repository.BinaryTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BinaryTreeService {

    @Autowired
    private BinaryTreeRepository binaryTreeRepository;

    // method to create a binary tree object from a user input string.
    public BinaryTree createBinaryTree(String userInputNumbers){
        // First instantiate a new BinaryTree object.
        BinaryTree binaryTree = new BinaryTree();
        // Set the inputNumbers attribute of the binaryTree object to the userInputNumbers.
        binaryTree.setInputNumbers(userInputNumbers);
        // Call helper method to set the binary tree structure.
        binaryTree.setBinaryTreeStructure(buildBinaryTreeString(userInputNumbers));
        //Save the binaryTree object to the database.
        return binaryTreeRepository.save(binaryTree);

    }

    public String buildBinaryTreeString(String userInputNumbers){
        BST bst = new BST();
        BinaryTreeNode root = null;
        for (String number : userInputNumbers.split(",")){
            root = bst.insert(root, Integer.parseInt(number));
        }
        return bst.preorder(root);
    }

    //Method to get all the previous binary trees from the database.
    public List<BinaryTree> getPreviousTrees(){
        return (List<BinaryTree>) binaryTreeRepository.findAll();
    }

    // add better error handling for most of this.....


}