package com.yrw.service;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.yrw.dao.CommentDao;
import com.yrw.model.Comment;

@Component
public class CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	//得到一篇博客的所有评论
	public List<Comment> getCommentsByBlogId(Long id){	
		return commentDao.getCommentsByBlogId(id);
	}
	
	@Async
	public void createComment(Long blogId, Comment comment) {
		commentDao.createComment(blogId, comment);
	}
	
	@Async
	public void deleteComment(Comment comment) {
		commentDao.deleteComment(comment.getCommentId());
	}
}
