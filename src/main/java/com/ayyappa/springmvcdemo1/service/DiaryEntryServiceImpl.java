package com.ayyappa.springmvcdemo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayyappa.springmvcdemo1.model.DiaryModel;
import com.ayyappa.springmvcdemo1.repo.DiaryDao;

@Service
public class DiaryEntryServiceImpl implements DiaryEntryService {
	@Autowired
	private DiaryDao diaryDao;

	public void addDiaryEntry(DiaryModel diaryModel) {
		// TODO Auto-generated method stub
		diaryDao.diaryEntry(diaryModel);

	}

	@Override
	public List<DiaryModel> getDiaries(int user_id) {
		
		return diaryDao.getAllDiaryEntries(user_id);
	}

	@Override
	public DiaryModel viewDiary(int id) {
		
		return diaryDao.viewSingleDiary(id);
	}

	@Override
	public int updateDiaryEntry(DiaryModel diaryModel) {
		
		return diaryDao.updateDiary(diaryModel);
	}

	@Override
	public int deleteDiary(DiaryModel diaryModel) {
		// TODO Auto-generated method stub
		return diaryDao.deleteDiaryEntry(diaryModel);
	}

}
