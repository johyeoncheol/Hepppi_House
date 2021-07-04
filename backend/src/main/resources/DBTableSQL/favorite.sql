CREATE TABLE `favoriteinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `ID` varchar(20) DEFAULT NULL,
  `dong` varchar(45) DEFAULT NULL,
  `AptName` varchar(45) DEFAULT NULL,
  `dealAmount` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `floor` varchar(45) DEFAULT NULL,
  `buildYear` varchar(45) DEFAULT NULL,
  `dealYear` varchar(45) DEFAULT NULL,
  `dealMonth` varchar(45) DEFAULT NULL,
  `dealDay` varchar(45) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `favorite` tinyint DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `id_idx` (`ID`),
  CONSTRAINT `id` FOREIGN KEY (`ID`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `` (`no`,`ID`,`dong`,`AptName`,`dealAmount`,`area`,`floor`,`buildYear`,`dealYear`,`dealMonth`,`dealDay`,`lat`,`lng`,`favorite`) VALUES (5,'test',' 익선동','현대뜨레비앙','    22,500','28.1','8','2003','2020','12','26',37.575114430642095,126.9900927261447,NULL);
INSERT INTO `` (`no`,`ID`,`dong`,`AptName`,`dealAmount`,`area`,`floor`,`buildYear`,`dealYear`,`dealMonth`,`dealDay`,`lat`,`lng`,`favorite`) VALUES (6,'test',' 청운동','청운현대','   125,000','129.76','3','2000','2020','12','24',37.586456750465906,126.96742338361554,NULL);
INSERT INTO `` (`no`,`ID`,`dong`,`AptName`,`dealAmount`,`area`,`floor`,`buildYear`,`dealYear`,`dealMonth`,`dealDay`,`lat`,`lng`,`favorite`) VALUES (7,'test',' 고소동','고소','     9,400','46.38','5','1992','2020','12','12',34.738624814717916,127.74229497047439,NULL);
