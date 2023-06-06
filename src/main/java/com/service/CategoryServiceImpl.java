package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cr;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void save(Category category) {
		try {
			cr.save(category);
			log.info("Save riuscito.");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Save fallito.");
			e.printStackTrace();
		}

	}

	@Override
	public List<Category> findAll() {
		List<Category> categories = cr.findAll();
		if (categories != null && !categories.isEmpty()) {
			log.info("Categorie trovate.");
			categories.forEach(System.out::println);
		} else {
			log.info("Categorie non trovate.");
		}
		return categories;
	}

	@Override
	public void deleteById(Integer categoryId) {
		if (cr.existsById(categoryId)) {
			try {
				cr.deleteById(categoryId);
				log.info("Categoria eliminata.");
			} catch (IllegalArgumentException iae) {
				log.info("Categoria non eliminata.");
				iae.printStackTrace();
			}
		} else {
			log.info("Categoria non trovata.");
		}

	}

	@Override
	public Category findByName(String name) {
		Category category = cr.findByName(name);
		if (category != null) {
			log.info("Categoria trovata.");
			System.out.println(category);
		} else {
			log.info("Categoria non trovata.");
		}
		return category;
	}

	public void saveAll(List<Category> categories) {
		try {
			cr.saveAll(categories);
			log.info("Save riuscito.");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Save fallito.");
			e.printStackTrace();
		}

	}

	@Override
	public List<Category> findCategoryStartingBy(String prefix) {
		List<Category> categories = cr.findCategoryStartingBy(prefix + "%");
		if (categories != null && !categories.isEmpty()) {
			log.info("Categorie trovate.");
			categories.forEach(System.out::println);
		} else {
			log.info("Categorie non trovate.");
		}
		return categories;
	}

}
