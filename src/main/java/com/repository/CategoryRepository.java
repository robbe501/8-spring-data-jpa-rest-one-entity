package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findByName(String name);

	@Query("SELECT c FROM Category c WHERE c.name LIKE :prefix")
	public List<Category> findCategoryStartingBy(String prefix);

}
