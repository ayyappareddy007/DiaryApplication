package com.ayyappa.springmvcdemo1.repo;

import java.util.List;

import com.ayyappa.springmvcdemo1.model.DiaryModel;

public interface DiaryDao {
	
	void diaryEntry(DiaryModel diaryModel);
	
	List<DiaryModel> getAllDiaryEntries(int user_id);
	
	DiaryModel viewSingleDiary(int id);
	
	int updateDiary(DiaryModel diaryModel);
	
	int deleteDiaryEntry(DiaryModel diaryModel);
}
