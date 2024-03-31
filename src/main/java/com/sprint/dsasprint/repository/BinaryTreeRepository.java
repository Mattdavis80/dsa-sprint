package com.sprint.dsasprint.repository;

import com.sprint.dsasprint.entity.BinaryTree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinaryTreeRepository extends CrudRepository<BinaryTree, Long> {
}
