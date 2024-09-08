package com.ayyappa.springmvcdemo1.service;

import java.util.List;

import com.ayyappa.springmvcdemo1.model.DiaryModel;

public interface DiaryEntryService {
	
	void addDiaryEntry(DiaryModel diaryModel);
	
	List<DiaryModel> getDiaries(int user_id);
	
	DiaryModel viewDiary(int id);
	
	int updateDiaryEntry(DiaryModel diaryModel);
	
	int deleteDiary(DiaryModel diaryModel);

}
