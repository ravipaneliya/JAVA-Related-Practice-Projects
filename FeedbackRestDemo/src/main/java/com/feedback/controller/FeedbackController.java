package com.feedback.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.feedback.dao.FeedbackDao;
import com.feedback.model.FeedbackEntity;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackDao dao;

	@PostMapping("/feedback")
	public ResponseEntity<String> addFeedback(@RequestBody FeedbackEntity feedback) {
		if (feedback.getName() != null && feedback.getEmail() != null && feedback.getFeedback() != null) {
			if (dao.addFeedback(feedback) > 0)
				return new ResponseEntity<String>("Data inserted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error in inserting", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/showfeedbacks")
	public List<FeedbackEntity> readAllData() {
		return dao.getAllFeedbacks();
	}
}
