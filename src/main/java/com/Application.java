package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Category;
import com.service.CategoryService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoryService cs;

	@Resource
	private Category c1;
	@Resource
	private Category c2;
	@Resource
	private Category c3;
	@Resource
	private Category c4;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		c1.setName("Azione");
		c2.setName("Documentario");
		c3.setName("Thriller");
		c4.setName("Torror");

		List<Category> categories = new ArrayList<>(List.of(c1, c2, c3, c4));

		cs.saveAll(categories);

//		c1.setName("Documentario");
//
//		cs.save(c1);

//		cs.deleteById(1);

		cs.findByName("Documentario");

		cs.findAll();

		cs.findCategoryStartingBy("T");

	}

}
