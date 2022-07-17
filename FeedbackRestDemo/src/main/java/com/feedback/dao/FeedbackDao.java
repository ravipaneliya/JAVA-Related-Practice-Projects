package com.feedback.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.feedback.model.FeedbackEntity;

@Repository
public class FeedbackDao {

	@Autowired
	private JdbcTemplate template;

	public int addFeedback(FeedbackEntity feedback) {

		return template.update("insert into feedback (name,email,feedback) values (?,?,?)", feedback.getName(),
				feedback.getEmail(), feedback.getFeedback());
	}

	public List<FeedbackEntity> getAllFeedbacks() {
		List<FeedbackEntity> feedbacks = template.query("select * from feedback", new RowMapper<FeedbackEntity>() {

			public FeedbackEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				FeedbackEntity obj = new FeedbackEntity();
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setEmail(rs.getString(3));
				obj.setFeedback(rs.getString(4));
				return obj;
			}
		});
		return feedbacks;
	}
}
