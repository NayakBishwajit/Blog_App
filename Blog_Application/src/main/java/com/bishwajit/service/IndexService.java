package com.bishwajit.service;

import java.util.List;

import com.bishwajit.binding.CommentForm;
import com.bishwajit.entity.BlogsEntity;
import com.bishwajit.entity.CommentsEntity;

public interface IndexService {

	List<BlogsEntity> getBlogs();
	
	List<BlogsEntity> getFilteredBlogs(String search);
	
	BlogsEntity getBlog(Integer blogId);
	
	List<CommentsEntity> addComment(CommentForm form);
	
}
