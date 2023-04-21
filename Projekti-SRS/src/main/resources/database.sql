CREATE DATABASE DB_SRS;

Use DB_SRS;

#Krijimi i tabeles ADMIN
CREATE TABLE Admin(
	AId INTEGER,
    Username NVARCHAR(50),
    Password NVARCHAR(512),
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
	stuId INTEGER AUTO_INCREMENT,
	Emri NVARCHAR(20),
    Mbiemri NVARCHAR(20),
    Gjinia VARCHAR(1),
    Ditelindja DATE,
    Email NVARCHAR(50),
    QytetiILindjes INTEGER,
    Komuna INTEGER,
    SuksesiNeSHM DOUBLE,
    PiketEMatures INTEGER,
    PiketEProvimitPranues INTEGER,
    Drejtimi NVARCHAR(10),
    SId INTEGER,
    PRIMARY KEY (stuId),
    FOREIGN KEY (QytetiILindjes) REFERENCES Qyteti(QId),
    FOREIGN KEY (Komuna) REFERENCES Qyteti(QId),
    FOREIGN KEY (SId) REFERENCES Shkolla(SId)
);

INSERT INTO Admin(AId, username, password)
VALUES
(1, "admin1", "$2a$10$UYVdyJoNOnE.k6ZGmzuGXei0/OXfLcXVpisgbCVnuReFU.IqN5jBS"),
(2, "admin2", "$2a$10$wDFVmkU47IVvWFMyF9Ugc.bFlsXNlCYd2E.RQkIKhdq4dO04Kg9k6"),
(3, "admin3", "$2a$10$5dzVhYIbiLGAHu7A53qgQuyCWO71q.XpkCAKtqDACcGPS5qaAZSYG"),
(4, "admin4", "$2a$10$.hgKitbPnJdWW7tWdeCzguFyiXlAOfUDpP7xDfwI3mjUx.f6JfAtu"),
(5, "admin5", "$2a$10$rXXgxlb.5T1qlFjUh4EEDeIuTUWy.BJAA2yIODCJ3VLtXk5efmXqi");

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

INSERT INTO Shkolla(sid, EmriIShkolles, QId)
VALUES
(1, "Shkolla e mesme 'Sami Frasheri'",1),
(2,"Shkolla e mesme 'Xhevdet Doda'", 1),
(3, "Shkolla e mesme 'Arkitekt Sinani'", 2),
(4, "Shkolla e mesme Ekonomike", 2),
(5, "Shkolla e mesme 'Bedri Pejani'", 3),
(6, "Shkolla e mesme Teknike", 3),
(7, "Shkolla e mesme 'Nexhmedin Nisha'", 4),
(8, "Shkolla e mesme 'Hajdar Dushi'", 4),
(9, "Shkolla e mesme 'Ymer Prizreni'",5),
(10, "Shkolla e mesme 'Remzi Ademaj'", 5),
(11, "Shkolla e mesme 'Pjeter Bogdani'", 6),
(12, "Shkolla e mesme 'Faik Konica'", 6),
(13, "Shkolla e mesme 'Mehmet Isai'", 7),
(14, "Shkolla e mesme 'Sahit Baftiu'", 7),
(15, "Shkolla e mesme 'Fan S.Noli'", 8),
(16, "Shkolla e mesme 'Aleksander Xhuvani'", 8),
(17, "Shkolla e mesme 'Eqrem Qabej'", 9),
(18, "Shkolla e mesme 'Bahri Haxha'", 9),
(19, "Shkolla e mesme 'Xhelal Hajda'", 10),
(20, "Shkolla e mesme 'Gjergj Kastriot Skenderbeu'", 10),
(21, "Shkolla e mesme 'Fehmi Llabrovci'",11),
(22, "Shkolla e mesme 'Arkitekt Sinani'", 11),
(23, "Shkolla e mesme 'Ulpiana'", 12),
(24, "Shkolla e mesme 'Abdyl Frasheri'", 13),
(25, "Shkolla e mesme 'Tafil Kasumaj'", 14),
(26, "Shkolla e mesme 'Haxhi Zeka'", 15),
(27, "Shkolla e mesme 'Bajram Curri'", 16),
(28, "Shkolla e mesme 'Feriz guri'", 17),
(29, "Shkolla e mesme 'Skenderbeu'", 17),
(30, "Shkolla e mesme 'Shiroke'", 18),
(31, "Shkolla e mesme 'Jonuz Zenjullahu'", 19),
(32, "Shkolla e mesme 'Hamez Jashari'", 20),
(33, "Shkolla e mesme Teknike", 20);


INSERT INTO Studenti(Emri, Mbiemri, Gjinia, Ditelindja, Email, QytetiILindjes, Komuna, SId, SuksesiNeSHM, PiketEMatures, PiketEProvimitPranues, Drejtimi)
VALUES
("Besarta", "Gashi", "F", "2003-03-13", "besarta-gashi@student.edu", 9, 9, 17, 4.98, 80, 100, "IKS"),
("Drilon", "Krasniqi", "M", "2003-05-20", "drilon-krasniqi@student.edu",6, 6, 11, 5, 83, 100, "TIK"),
("Agnesa", "Bytyqi", "F", "2003-07-17", "agnesa-bytyqi@student.edu",3, 3, 5, 4.98, 79, 100, "IKS"),
("Klea", "Bislimi", "F", "2003-06-03", "klea-bislimi@student.edu",8, 8, 15, 4.96, 80, 70, "IKS"),
("Fitim", "Arifi", "M", "2003-02-12", "fitim-arifi@student.edu",5, 5, 9, 4.9, 80, 73, "TIK"),
("Nita", "Rexha", "F", "2003-04-08", "nita-rexha@student.edu",2, 2, 3, 5, 80, 75, "IKS"),
("Endrit", "Kastrati", "M", "2002-12-13", "endrit-kastrati@student.edu",7, 7, 13, 4.8, 83, 100, "EAR"),
("Blend", "Shala", "M", "2003-06-21", "blend-shala@student.edu",4, 4, 7, 4.98, 82, 100, "TIK"),
("Gentiana", "Aliu", "F", "2003-09-25", "gentiana-aliu@student.edu",1, 1, 1, 4.78, 77, 100, "IKS"),
("Lirim", "Shabani", "M", "2003-05-03", "lirim-shabani@student.edu",10, 10, 19, 4.99, 74, 100, "IKS"),
("Arbnora", "Haxhiu", "F", "2003-08-14", "arbnora-haxhiu@student.edu", 19, 19, 31, 5, 70, 100, "IKS"),
("Riad", "Syla", "M", "2003-12-30", "riad-syla@student.edu", 16, 16, 27, 4.7, 70, 100, "IKS"),
("Tina", "Thaqi", "F", "2003-03-03", "tina-thaqi@student.edu",13, 13, 23, 5, 79, 100, "EAR"),
("Fjolla", "Llapi", "F", "2003-03-13", "fjolla-llapi@student.edu", 12, 12, 22, 5, 80, 100, "IKS"),
("Lorik", "Shatri", "M", "2003-09-20", "lorik-shatri@student.edu",15, 15, 25, 4.98, 83, 100, "IKS"),
("Valdrin", "Shoshi", "M", "2003-10-21", "valdrin-shoshi@student.edu",18, 18, 30, 4.9, 88, 100, "TIK"),
("Fatlum", "Osmani", "M", "2003-05-26", "fatlum-osmani@student.edu",17, 17, 28, 4.9, 83, 100, "TIK"),
("Leonora", "Maraj", "F", "2003-09-03", "leonora-maraj@student.edu",14, 14, 24, 5, 79, 100, "IKS"),
("Rreze", "Ukaj", "F", "2003-03-09", "rreze-ukaj@student.edu", 3, 3, 6, 4.9, 74, 100, "EAR"),
("Lis", "Sejdiu", "M", "2003-07-16", "lis-sejdiu@student.edu", 20, 20, 33, 4.98, 72, 100, "IKS"),
("Erza", "Rugova", "F", "2003-04-19", "erza-rugova@student.edu", 6, 6, 12, 4.8, 79, 100, "IKS"),
("Rinesa", "Murtezi", "F", "2003-01-17", "rinesa-murtezaj@student.edu", 5, 5, 10, 5, 80, 100, "EAR"),
("Jeta", "Ukaj", "F", "2003-09-19", "jeta-ukaj@student.edu", 8, 8, 16, 4.9, 84, 100, "IKS"),
("Vjosa", "Sejdiu", "F", "2003-10-01", "vjosa-sejdiu@student.edu", 7, 7, 14, 4.8, 70, 100, "IKS"),
("Drin", "Rugova", "M", "2003-02-20", "drin-rugova@student.edu", 10, 10, 19, 5, 82, 100, "IKS"),
("Ardian", "Murtezi", "M", "2002-12-13", "ardian-murtezi@student.edu", 3, 3, 5, 5, 80, 100, "EAR"),
("Flutura", "Morina", "F", "2002-11-13", "flutra-morina@student.edu", 3, 3, 6, 4.9, 81, 100, "TIK");


SELECT * FROM Qyteti;
SELECT * FROM Studenti;