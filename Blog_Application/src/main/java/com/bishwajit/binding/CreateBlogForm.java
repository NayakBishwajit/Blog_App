package com.bishwajit.binding;

import lombok.Data;

@Data
public class CreateBlogForm {

	private Integer blogId;
	private String blogTitle;
	private String shortDesp;
	
	private String content;
}
