package org.spring.app.messenger.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.spring.app.messenger.dao.impl.DataBaseClass;
import org.spring.app.messenger.model.Comment;
import org.spring.app.messenger.model.Message;
import org.spring.app.messenger.service.CommentService;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
private Map<Long, Message> messages = DataBaseClass.getAllMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
