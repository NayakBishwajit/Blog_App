package com.bishwajit.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishwajit.binding.CommentForm;
import com.bishwajit.constants.AppConstants;
import com.bishwajit.entity.BlogsEntity;
import com.bishwajit.entity.CommentsEntity;
import com.bishwajit.repo.BlogsRepository;
import com.bishwajit.repo.CommentsRepository;
import com.bishwajit.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private BlogsRepository blogRepo;
	
	@Autowired
	private CommentsRepository commentRepo;

	@Override
	public List<BlogsEntity> getBlogs() {
		
		List<BlogsEntity> blogs = blogRepo.findByStatus(AppConstants.BLOG_ACTIVE_STATUS);
		
		return blogs;
	}
	
	@Override
	public BlogsEntity getBlog(Integer blogId) {
		BlogsEntity blog = blogRepo.findById(blogId).get();
		return blog;
	}
	
	@Override
	public List<CommentsEntity> addComment(CommentForm form) {
		
		Integer blogId = form.getBlogId();
		BlogsEntity blog = blogRepo.findById(blogId).get();
		
		CommentsEntity comment = new CommentsEntity();
		BeanUtils.copyProperties(form, comment);
		
		comment.setBlog(blog);
		
	    commentRepo.save(comment);
	    
	    List<CommentsEntity> comments = commentRepo.findByBlog(blog);
	    
		return comments;
	}
	
	@Override
	public List<BlogsEntity> getFilteredBlogs(String search) {
		
		List<BlogsEntity> blogs = blogRepo.findByBlogTitleContainingIgnoreCase(search);
		
		return blogs;
	}

}
