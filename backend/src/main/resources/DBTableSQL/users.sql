CREATE TABLE `users` (
  `ID` varchar(20) NOT NULL,
  `PASS` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `admCd` varchar(45) DEFAULT NULL,
  `rnMgtSn` varchar(45) DEFAULT NULL,
  `udrtYn` varchar(45) DEFAULT NULL,
  `buldMnnm` varchar(45) DEFAULT NULL,
  `buldSlno` varchar(45) DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `zipNo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*
-- Query: SELECT * FROM happyhouse.users
LIMIT 0, 50000

-- Date: 2021-05-27 22:32
*/
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('admin','','홍길동','전라북도 전주시 덕진구 백제대로 567 (금암동)','4511310700','451132266003','0','567','0',127.13202094625105,35.8407365671552,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('admin1','admin1','admin','전라북도 전주시 덕진구 삼송5길 5 (금암동)','4511310700','451134601223','0','5','0',127.13691533657678,35.842463905020686,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('jane','1234','jane kim',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('root','root','root','경상북도 영주시 문수면 문수로 993','4721033025','472103309079','0','993','0',128.60610159282695,36.7450753922369,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('test','test','ssafy',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('test1','test1','ssafy','광주광역시','test','010101','010101','0','0',36.1512,121.1215,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('test123123','','test','전라북도 전주시 덕진구 삼송5길 8 (금암동, 정경원룸)','4511310700','451134601223','0','8','0',0,0,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('test123123123','','test123123','전라북도 전주시 덕진구 삼송5길 8 (금암동, 정경원룸)','4511310700','451134601223','0','8','0',0,0,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('test123123123123','','test123123123123','전라북도 전주시 덕진구 삼송5길 8 (금암동, 정경원룸)','4511310700','451134601223','0','8','0',127.13708128031482,35.84267451708463,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('tommy','1234','tommy lee',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `` (`ID`,`PASS`,`NAME`,`ADDRESS`,`admCd`,`rnMgtSn`,`udrtYn`,`buldMnnm`,`buldSlno`,`lng`,`lat`,`zipNo`) VALUES ('tset123123123','','test','전라남도 여수시 여문1로 22 (여서동)','4613011900','461303282049','0','22','0',0,0,NULL);
