package com.ayyappa.springmvcdemo1.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ayyappa.springmvcdemo1.model.DiaryModel;

@Repository
public class DiaryDaoImpl implements DiaryDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void diaryEntry(DiaryModel diaryModel) {
		
		String sql = "INSERT INTO diary_entries(user_id, entry_date, description) VALUES(?, ?, ?)";
		int n = jdbcTemplate.update(sql, diaryModel.getUser_id(), diaryModel.getDate(), diaryModel.getDescription());
		
	}

	@Override
	public List<DiaryModel> getAllDiaryEntries(int user_id) {
		
		String sql = "select id, user_id, entry_date, description from diary_entries where user_id=? order by id desc";
		
		RowMapper<DiaryModel> rowMap = new RowMapper<DiaryModel>() {
			
			@Override
			public DiaryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				DiaryModel diaryModel = new DiaryModel();
				diaryModel.setId(rs.getInt("id"));
				diaryModel.setUser_id(rs.getInt("user_id"));
				diaryModel.setDate(rs.getString("entry_date"));
				diaryModel.setDescription(rs.getString("description"));
				return diaryModel;
			}
		};
		
		return jdbcTemplate.query(sql, rowMap, user_id);
	}

	@Override
	public DiaryModel viewSingleDiary(int id) {
		String sql = "select id, user_id, entry_date, description from diary_entries where id=? ";
		
		RowMapper<DiaryModel> rowMap = new RowMapper<DiaryModel>() {
			
			@Override
			public DiaryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				DiaryModel diaryModel = new DiaryModel();
				diaryModel.setId(rs.getInt("id"));
				diaryModel.setUser_id(rs.getInt("user_id"));
				diaryModel.setDate(rs.getString("entry_date"));
				diaryModel.setDescription(rs.getString("description"));
				return diaryModel;
			}
		};
		
		return jdbcTemplate.queryForObject(sql,rowMap, id);
	}

	@Override
	public int updateDiary(DiaryModel diaryModel) {
		String sql = "update diary_entries set description=? where id = ?";
		
		
		return jdbcTemplate.update(sql, diaryModel.getDescription(),diaryModel.getId());
	}

	@Override
	public int deleteDiaryEntry(DiaryModel diaryModel) {
		String sql ="delete from diary_entries where id = ?";
		
		
		return jdbcTemplate.update(sql, diaryModel.getId());
	}

}
