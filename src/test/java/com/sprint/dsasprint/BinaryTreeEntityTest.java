package com.sprint.dsasprint;

import com.sprint.dsasprint.entity.BinaryTree;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BinaryTreeEntityTest {

	@Autowired
	private TestEntityManager entityManager;

	// TEST to check if the binary tree object is persisted correctly.
	@Test
	public void testBinaryTreePersistence() {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.setInputNumbers("9,2,12,3");
		binaryTree.setBinaryTreeStructure("Root: 9, Left: 2, Right: 3, Right: 12");

		BinaryTree savedBinaryTree = entityManager.persistFlushFind(binaryTree);

		assertThat(savedBinaryTree.getInputNumbers()).isEqualTo("9,2,12,3");
		assertThat(savedBinaryTree.getBinaryTreeStructure()).isEqualTo("Root: 9, Left: 2, Right: 3, Right: 12");
	}


}
