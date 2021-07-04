package com.happyhouse.service;

import java.util.List;

import com.happyhouse.vo.QnA;

public interface QnAService {

	//게시글 생성
		public int addQnA(QnA qna);
		
		//게시글 조회
		public List<QnA> allListQnA();
		
		//게시글 검색
		public List<QnA> searchQnA(String title);
		
		//특정 게시글 조회
		public QnA selectOneQnA(String no);
		
		//특정 게시글 수정
		public int modifyOneQnA(QnA qna);
		
		//특정 게시글 삭제
		public int deleteOneQnA(String no);
}
