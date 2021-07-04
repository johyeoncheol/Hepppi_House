package com.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.dao.QnADao;
import com.happyhouse.vo.QnA;

@Service
public class QnAServiceImpl implements QnAService {

	@Autowired
	QnADao dao;
	
	@Override
	public int addQnA(QnA qna) {
		return dao.addQnA(qna);
	}

	@Override
	public List<QnA> allListQnA() {
		// TODO Auto-generated method stub
		return dao.allListQnA();
	}

	@Override
	public List<QnA> searchQnA(String title) {
		// TODO Auto-generated method stub
		return dao.searchQnA(title);
	}

	@Override
	public QnA selectOneQnA(String no) {
		// TODO Auto-generated method stub
		return dao.selectOneQnA(no);
	}

	@Override
	public int modifyOneQnA(QnA qna) {
		// TODO Auto-generated method stub
		return dao.modifyOneQnA(qna);
	}

	@Override
	public int deleteOneQnA(String no) {
		// TODO Auto-generated method stub
		return dao.deleteOneQnA(no);
	}

}
