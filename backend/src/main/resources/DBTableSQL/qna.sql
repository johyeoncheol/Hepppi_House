CREATE TABLE `qna` (
  `no` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` longtext NOT NULL,
  `writer` varchar(20) NOT NULL,
  `wdate` datetime NOT NULL,
  `qnacol` varchar(45) NOT NULL,
  PRIMARY KEY (`no`),
  KEY `name_idx` (`writer`) /*!80000 INVISIBLE */,
  CONSTRAINT `name` FOREIGN KEY (`writer`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='QnA 게시반 DB';

INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (6,'안녕하세요','안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요','admin','2021-05-25 19:27:06');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (7,'테스트페이지입니다.','테스트페이지입니다.테스트페이지입니다.테스트페이지입니다.테스트페이지입니다.테스트페이지입니다.테스트페이지입니다.테스트페이지입니다.','admin','2021-05-25 19:30:13');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (8,'안녕','안녕','admin','2021-05-25 19:32:10');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (9,'[청약 관련] 서울시 동작구 OO아파트 공고','이번 동작구에서는 아파트 청약 추첨을 진행합니다.','admin','2021-05-25 19:33:05');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (10,'[주택 청약 관련] 경기도 안양시 OO아파트 청약공고','경기도 안양시 아파트 공구','admin','2021-05-25 19:33:41');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (11,'글 제목 : [주택 청약 관련] 경기도 화성시 OO아파트 청약공고','ㅇㄴㄻㄴㅇㄻㄴㅇㄻ','admin','2021-05-25 19:34:13');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (12,'[주택 청약 관련] 경기도 군포시 OO아파트 청약공고','ㅂㅈㄷㅊㅁㅍㅁ','admin','2021-05-25 19:34:37');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (13,'[주택 청약 관련] 경기도 수원시 OO아파트 청약공고','ㅁㅇㄿㅁㅍㅁㄴㅇ','admin','2021-05-25 19:34:47');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (14,'[주택 청약 관련] 서울 서초구 OO아파트 청약공고','ㅇㅁㅍㅁㄴㅇㅍㅁ','admin','2021-05-25 19:35:15');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (15,'[주택 청약 관련] 서울 광진구 OO아파트 청약공고','ㅍㅁㅇㄴㅍㅁㅇㄴ','admin','2021-05-25 19:35:31');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (16,'[주택 청약 관련] 서울 강남구 OO아파트 청약공고','ㅍㅁㅇㅍㅁㄴㅇㄱㄹㅈㄷ','admin','2021-05-25 19:35:45');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (17,'[주택 청약 관련] 서울 강북구 OO아파트 청약공고','ㅁㅍㅁㅇㅁㅇㄴㄹ','admin','2021-05-25 19:36:08');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (18,'[주택 청약 관련] 서울 송파구 OO아파트 청약공고','ㅍㅁㅇㅍㅁㅇㄴㄻㄴㅇㄹ','admin','2021-05-25 19:36:38');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (19,'[주택 청약 관련] 서울 강동구 OO아파트 청약공고','ㅍㅁㅇㄴㅍㅁㄴ','admin','2021-05-25 19:37:29');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (20,'청약 경쟁 기준이 어떻게 되나요?','ㅇㄴㄿㅂㅈㄷㄿㅂ','admin','2021-05-25 19:37:52');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (21,'신혼을 위한 주택 마련 대출은 어떻게 되나요?','ㄴㅇㅁㄹㅊㄴㅇㄻㄴㅇ','admin','2021-05-25 19:38:24');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (22,'청약 신청을 할 수 있는 사이트가 어딨나요?','ㅍㅁㄴㅇㄼㅈㄷㄱ','admin','2021-05-25 19:39:03');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (23,'전세 월세에 대한 계약 기간은 어떻게 되나요?','ㅇㅁㄴㄻㄴㅇㄼ','admin','2021-05-25 19:39:41');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (24,'안녕하세요 테스트페이지입니다.','안녕하세요','admin','2021-05-26 15:49:28');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (25,'[공지사항] 안녕하세요 테스트 페이지 입니다.','[공지사항] 안녕하세요 테스트 페이지 입니다.[공지사항] 안녕하세요 테스트 페이지 입니다.[공지사항] 안녕하세요 테스트 페이지 입니다.[공지사항] 안녕하세요 테스트 페이지 입니다.[공지사항] 안녕하세요 테스트 페이지 입니다.[공지사항] 안녕하세요 테스트 페이지 입니다.[공지사항] 안녕하세요 테스트 페이지 입니다.[공지사항] 안녕하세요 테스트 페이지 입니다.','admin','2021-05-26 20:53:48');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (26,'[공지사항] 햅삐 하우스 많은 이용 부탁드립니다.','[공지사항] 햅삐 하우스 많은 이용 부탁드립니다.','admin','2021-05-26 20:54:22');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (27,'테스트페이지입니다','테스트페이지입니다테스트페이지입니다테스트페이지입니다테스트페이지입니다','admin','2021-05-27 10:50:45');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (28,'안녕하세요','안녕하세요','admin','2021-05-27 13:43:01');
INSERT INTO `qna` (`no`,`title`,`content`,`writer`,`wdate`) VALUES (29,'테스트페이지입니다','테스트페이지입니다','admin','2021-05-27 14:52:23');