package com.sprint.dsasprint.entity;

import jakarta.persistence.*;

@Entity
public class BinaryTree {
    @Id
    @SequenceGenerator(name = "binaryTree_sequence", sequenceName = "binaryTree_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "binaryTree_sequence")
    private long id;

    @Column
    private String inputNumbers;

    @Column
    private String binaryTreeStructure;

    public long getId() {
        return id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public String getBinaryTreeStructure() {
        return binaryTreeStructure;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public void setBinaryTreeStructure(String binaryTreeStructure) {
        this.binaryTreeStructure = binaryTreeStructure;
    }
}
