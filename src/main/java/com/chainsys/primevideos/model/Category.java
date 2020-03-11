package com.chainsys.primevideos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Category {
	
	private int categoryId;
	private String categoryName;	
}