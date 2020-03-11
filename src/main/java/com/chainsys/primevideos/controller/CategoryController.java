package com.chainsys.primevideos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.primevideos.dao.imp.CategorysDAOImpl;
import com.chainsys.primevideos.exception.DbException;
import com.chainsys.primevideos.model.Category;

@RestController
@RequestMapping("api")
public class CategoryController {
	@GetMapping("/primeCategorys")
	public List<Category> list() throws DbException, ClassNotFoundException {
		CategorysDAOImpl category =  new CategorysDAOImpl();
		List<Category> categorys = new ArrayList<>();
		categorys = category.findAllCategorys();
		return categorys;
	}
}
