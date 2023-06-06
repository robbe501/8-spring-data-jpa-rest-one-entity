package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Category;
import com.service.CategoryService;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
public class CategoryController {
	@Autowired
	private CategoryService cs;

	@GetMapping("api/v1/categories")
	public List<Category> getCategories() {
		return cs.findAll();
	}

	@PostMapping(value = "api/v1/categories", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public void save(@ModelAttribute Category category) {
		cs.save(category);
	}
}
