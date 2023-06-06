package com.service;

import java.util.List;

import com.entity.Category;

public interface CategoryService {
	public void save(Category category);

	public List<Category> findAll();

	public void deleteById(Integer categoryId);

	public Category findByName(String name);

	public void saveAll(List<Category> categories);

	public List<Category> findCategoryStartingBy(String prefix);
}
