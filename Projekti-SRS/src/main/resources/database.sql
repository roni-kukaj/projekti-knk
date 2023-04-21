CREATE DATABASE DB_SRS;

Use DB_SRS;

#Krijimi i tabeles ADMIN
CREATE TABLE Admin(
	AId INTEGER,
    Username NVARCHAR(50),
    Password NVARCHAR(50),
    PRIMARY KEY (AId)
);

#Krijimi i tabeles QYTETI
CREATE TABLE Qyteti(
	QId INTEGER,
    Emri NVARCHAR(50),
   PRIMARY KEY (QId)
);

#Krijimi i tabeles SHKOLLA
CREATE TABLE Shkolla(
	SId INTEGER,
	QId INTEGER,
	EmriIShkolles NVARCHAR(50),
    PRIMARY KEY(SId),
	FOREIGN KEY (QId) REFERENCES Qyteti(QId)
);

#Krijimi i tabeles STUDENTI
CREATE TABLE Studenti(
	stuId INTEGER,
	Emri NVARCHAR(20),
    Mbrimei NVARCHAR(20),
    Gjinia NVARCHAR(15),
    Ditelindja DATE,
    Email NVARCHAR(50),
    QId INTEGER,
    QId INTEGER,
    sid Integer,
    SuksesiNeSHM DOUBLE,
    PiketEMatures INTEGER,
    PiketEProvimitPranues INTEGER,
    Drejtimi NVARCHAR(10),
    SId INTEGER,
    FOREIGN KEY (QId) REFERENCES Qyteti(QId),
    FOREIGN KEY (SId) REFERENCES Shkolla(SId)
); 

INSERT INTO Admin(AId, username, password)
VALUES
(1, "admin1", "admin1"),
(2, "admin2", "admin2"),
(3, "admin3", "admin3"),
(4, "admin4", "admin4"),
(5, "admin5", "admin5");

INSERT INTO Qyteti(QId, Emri)
VALUES
(1,"Prishtine"),
(2,"Mitrovice"),
(3,"Peje"),
(4,"Prizren"),
(5,"Ferizaj"),
(6,"Gjilan"),
(7,"Gjakove"),
(8,"Podujeve"),
(9,"Vushtri"),
(10,"Rahovec"),
(11,"Drenas"),
(12,"Lipjan"),
(13,"Malisheve"),
(14,"Deqan"),
(15,"Istog"),
(16,"Kline"),
(17,"Kaqanik"),
(18,"Suharek"),
(19,"Viti"),
(20,"Skenderaj");

INSERT INTO Shkolla(sid, Qid, EmriIShkolles)
VALUES
(11, "Shkolla e mesme 'Sami Frasheri' ",1),
(12,"Shkolla e mesme 'Xhevdet Doda'", 1),
(13, "Shkolla e mesme 'Arkitekt Sinani'", 2),
(14, "Shkolla e mesme Ekonomike", 2),
(15, "Shkolla e mesme 'Bedri Pejani'", 3),
(16, "Shkolla e mesme Teknike", 3),
(17, "Shkolla e mesme 'Nexhmedin Nisha'", 4),
(18, "Shkolla e mesme 'Hajdar Dushi'", 4),
(19, "Shkolla e mesme 'Ymer Prizreni'",5),
(20, "Shkolla e mesme 'Remzi Ademaj'", 5),
(21, "Shkolla e mesme 'Pjeter Bogdani'", 6),
(22, "Shkolla e mesme 'Faik Konica'", 6),
(23, "Shkolla e mesme 'Mehmet Isai'", 7),
(24, "Shkolla e mesme 'Sahit Baftiu'", 7),
(25, "Shkolla e mesme 'Fan S.Noli'", 8),
(26, "Shkolla e mesme 'Aleksander Xhuvani'", 8),
(27, "Shkolla e mesme 'Eqrem Qabej'", 9),
(28, "Shkolla e mesme 'Bahri Haxha'", 9),
(29, "Shkolla e mesme 'Xhelal Hajda'", 10),
(30, "Shkolla e mesme 'Gjergj Kastriot Skenderbeu'", 10),
(31, "Shkolla e mesme 'Fehmi Llabrovci'",11),
(32, "Shkolla e mesme 'Arkitekt Sinani'", 11),
(33, "Shkolla e mesme 'Ulpiana'", 12),
(34, "Shkolla e mesme 'Abdyl Frasheri'", 13),
(35, "Shkolla e mesme 'Tafil Kasumaj'", 14),
(36, "Shkolla e mesme 'Haxhi Zeka'", 15),
(37, "Shkolla e mesme 'Bajram Curri'", 16),
(38, "Shkolla e mesme 'Feriz guri'", 17),
(39, "Shkolla e mesme 'Skenderbeu'", 17),
(40, "Shkolla e mesme 'Shiroke'", 18),
(41, "Shkolla e mesme 'Jonuz Zenjullahu'", 19),
(42, "Shkolla e mesme 'Hamez Jashari'", 20),
(43, "Shkolla e mesme Teknike", 20);


INSERT INTO Studenti(stuId,Emri, Mbiemri, Gjinia, Ditelindja,Email, QytetiILindjes, Komuna, ShkollaEMesme,PiketEMatures, PiketEProvimitPranues)
VALUES
(100, "Besarta", "Gashi", "Femer", 03/13/2003, "besarta-gashi@student.edu",9, 9, 9, 4.98, 80, 100, "IKS"),
(101, "Drilon", "Krasniqi", "Femer", 03/13/2003, "drilon-krasniqi@student.edu",6, 6, 6, 5, 83, 100, "IKS"),
(102, "Agnesa", "Bytyqi", "Femer", 03/13/2003, "agnesa-bytyqi@student.edu",3, 3, 3, 4.98, 79, 100, "IKS"),
(103, "Klea", "Bislimi", "Femer", 03/13/2003, "klea-bislimi@student.edu",8, 8, 8, 4.96, 80, 70, "IKS"),
(104, "Fitim", "Arifi", "Femer", 03/13/2003, "fitim-arifi@student.edu",5, 5, 5, 4.9, 80, 73, "TIK"),
(105, "Nita", "Rexha", "Femer", 03/13/2003, "nita-rexha@student.edu",2, 2, 2, 5, 80, 75, "IKS"),
(106, "Endrit", "Kastrati", "Femer", 03/13/2003, "endirt-kastrati@student.edu",7, 7, 7, 4.8, 83, 100, "EAR"),
(107, "Blend", "Shala", "Femer", 03/13/2003, "blend-shala@student.edu",4, 4, 4, 4.98, 82, 100, "TIK"),
(108, "Gentiana", "Aliu", "Femer", 03/13/2003, "gentiana-aliu@student.edu",1, 1, 1, 4.78, 77, 100, "IKS"),
(109, "Lirim", "Shabani", "Femer", 03/13/2003, "lirim-shabani@student.edu",10, 10, 10, 4.99, 74, 100, "IKS"),
(110, "Arbnora", "Haxhiu", "Femer", 03/13/2003, "arbnora-haxhiu@student.edu",9, 9, 9, 5, 70, 100, "IKS"),
(111, "Riad", "Syla", "Femer", 03/13/2003, "riad-syla@student.edu",1, 1, 1, 4.7, 70, 100, "IKS"),
(112, "Tina", "Thaqi", "Femer", 03/13/2003, "tina-thaqi@student.edu",7, 7, 7, 5, 79, 100, "EAR"),
(113, "Fjolla", "Llapi", "Femer", 03/13/2003, "fjolla-llapi@student.edu",19, 19, 19, 5, 80, 100, "IKS"),
(114, "Lorik", "Shatri", "Femer", 03/13/2003, "lorik-shatri@student.edu",18, 18, 18, 4.98, 83, 100, "IKS"),
(115, "Valdrin", "Shoshi", "Femer", 03/13/2003, "valdrin-shoshi@student.edu",14, 14, 14, 4.9, 88, 100, "TIK"),
(116, "Fatlum", "Osmani", "Femer", 03/13/2003, "fatlum-osmani@student.edu",16, 16, 16, 4.9, 83, 100, "TIK"),
(117, "Leonora", "Maraj", "Femer", 03/13/2003, "leonora-maraj@student.edu",17, 17, 17,5, 79, 100, "IKS"),
(118, "Rreze", "Ukaj", "Femer", 03/13/2003, "rreze-ukaj@student.edu",20, 20, 20, 4.9, 74, 100, "EAR"),
(119, "Lis", "Sejdiu", "Femer", 03/13/2003, "lis-sejdiu@student.edu",6,6, 6, 4.98, 72, 100, "IKS"),
(120, "Erza", "Rugova", "Femer", 03/13/2003, "erza-rugova@student.edu",5, 5, 5, 4.8, 79, 100, "IKS"),
(121, "Rinesa", "Murtezi", "Femer", 03/13/2003, "rinesa-murtezaj@student.edu",8, 8, 8,5, 80, 100, "EAR"),
(122, "Jeta", "Ukaj", "Femer", 03/13/2003, "jeta-ukaj@student.edu",11, 11, 11, 4.9, 84, 100, "IKS"),
(123, "Vjosa", "Sejdiu", "Femer", 03/13/2003, "vjosa-sejdiu@student.edu",14, 14, 14, 4.8, 70, 100, "IKS"),
(124, "Drin", "Rugova", "Femer", 03/13/2003, "drin-rugova@student.edu",1, 1, 1, 5, 82, 100, "IKS"),
(125, "Ardian", "Murtezi", "Femer", 03/13/2003, "ardian-murtezi@student.edu",9, 9, 9, 5, 80, 100, "EAR"),
(126, "Flutura", "Morina", "Femer", 03/13/2003, "flutra-morina@student.edu",3, 3, 3, 4.9, 81, 100, "TIK");

SELECT * FROM Qyteti;
SELECT * FROM Students;