package com.happyhouse.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.service.QnAService;
import com.happyhouse.vo.QnA;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class QnAController {
	
	@Autowired
	QnAService service;
	
	//모든 게시글 조회
	@GetMapping("/qna")
	public ResponseEntity<List<QnA>> allListQnA() {
		List<QnA> list = service.allListQnA();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<QnA>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	//게시글 생성
	@PostMapping("/qna")
	public ResponseEntity<String> addQnA(@RequestBody QnA qna){
		System.out.println(qna.getTitle());
		int status = service.addQnA(qna);
		if(status != 0) {
			return new ResponseEntity<String>("inputOk", HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	//특정 게시글 수정
	@PutMapping("/qna")
	public ResponseEntity<String> modifyOneQnA(@RequestBody QnA qna){
		int status = service.modifyOneQnA(qna);
		if(status != 0) {
			return new ResponseEntity<String>("modifyOK", HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	//게시글 검색
	//제목 or 내용  or 사람명으로 생성 예정
	@GetMapping("/qna/{type}/{title}")
	public ResponseEntity<List<QnA>> searchQnA(@PathVariable String type, @PathVariable String title) {
		List<QnA> list = null;
		if(type.equals("title")) list = service.searchQnA(title);
		
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<QnA>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	//특정 게시글 조회
	@GetMapping("/qna/{no}")
	public ResponseEntity<QnA> searchQnA(@PathVariable String no) {
		QnA qna = service.selectOneQnA(no);
		
		if(qna != null) {
			return new ResponseEntity<QnA>(qna, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	//특정 게시글 삭제
	@DeleteMapping("/qna/{no}")
	public ResponseEntity<String> deleteOneQnA(@PathVariable String no) {
		
		int status = service.deleteOneQnA(no);
		
		if(status != 0) {
			return new ResponseEntity<String>("deleteOK", HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
}
