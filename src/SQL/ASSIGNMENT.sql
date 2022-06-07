/* I. CREATE TABLES */

-- faculty (Khoa trong tr??ng)
create table faculty (
	id number primary key,
	name nvarchar2(30) not null
);

-- subject (M�n h?c)
create table subject(
	id number primary key,
	name nvarchar2(100) not null,
	lesson_quantity number(2,0) not null -- t?ng s? ti?t h?c
);

-- student (Sinh vi�n)
create table student (
	id number primary key,
	name nvarchar2(30) not null,
	gender nvarchar2(10) not null, -- gi?i t�nh
	birthday date not null,
	hometown nvarchar2(100) not null, -- qu� qu�n
	scholarship number, -- h?c b?ng
	faculty_id number not null constraint faculty_id references faculty(id) -- m� khoa
);

-- exam management (B?ng ?i?m)
create table exam_management(
	id number primary key,
	student_id number not null constraint student_id references student(id),
	subject_id number not null constraint subject_id references subject(id),
	number_of_exam_taking number not null, -- s? l?n thi (thi tr�n 1 l?n ???c g?i l� thi l?i) 
	mark number(4,2) not null -- ?i?m
);



/*================================================*/

/* II. INSERT SAMPLE DATA */

-- subject
insert into subject (id, name, lesson_quantity) values (1, n'C? s? d? li?u', 45);
insert into subject values (2, n'Tr� tu? nh�n t?o', 45);
insert into subject values (3, n'Truy?n tin', 45);
insert into subject values (4, n'?? h?a', 60);
insert into subject values (5, n'V?n ph?m', 45);


-- faculty
insert into faculty values (1, n'Anh - V?n');
insert into faculty values (2, n'Tin h?c');
insert into faculty values (3, n'Tri?t h?c');
insert into faculty values (4, n'V?t l�');


-- student
insert into student values (1, n'Nguy?n Th? H?i', n'N?', to_date('19900223', 'YYYYMMDD'), 'H� N?i', 130000, 2);
insert into student values (2, n'Tr?n V?n Ch�nh', n'Nam', to_date('19921224', 'YYYYMMDD'), 'B�nh ??nh', 150000, 4);
insert into student values (3, n'L� Thu Y?n', n'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 150000, 2);
insert into student values (4, n'L� H?i Y?n', n'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 170000, 2);
insert into student values (5, n'Tr?n Anh Tu?n', n'Nam', to_date('19901220', 'YYYYMMDD'), 'H� N?i', 180000, 1);
insert into student values (6, n'Tr?n Thanh Mai', n'N?', to_date('19910812', 'YYYYMMDD'), 'H?i Ph�ng', null, 3);
insert into student values (7, n'Tr?n Th? Thu Th?y', n'N?', to_date('19910102', 'YYYYMMDD'), 'H?i Ph�ng', 10000, 1);


-- exam_management
insert into exam_management values (1, 1, 1, 1, 3);
insert into exam_management values (2, 1, 1, 2, 6);
insert into exam_management values (3, 1, 2, 2, 6);
insert into exam_management values (4, 1, 3, 1, 5);
insert into exam_management values (5, 2, 1, 1, 4.5);
insert into exam_management values (6, 2, 1, 2, 7);
insert into exam_management values (7, 2, 3, 1, 10);
insert into exam_management values (8, 2, 5, 1, 9);
insert into exam_management values (9, 3, 1, 1, 2);
insert into exam_management values (10, 3, 1, 2, 5);
insert into exam_management values (11, 3, 3, 1, 2.5);
insert into exam_management values (12, 3, 3, 2, 4);
insert into exam_management values (13, 4, 5, 2, 10);
insert into exam_management values (14, 5, 1, 1, 7);
insert into exam_management values (15, 5, 3, 1, 2.5);
insert into exam_management values (16, 5, 3, 2, 5);
insert into exam_management values (17, 6, 2, 1, 6);
insert into exam_management values (18, 6, 4, 1, 10);



/*================================================*/

/* III. QUERY */


 /********* A. BASIC QUERY *********/

-- 1. Li?t k� danh s�ch sinh vi�n s?p x?p theo th? t?:
--      a. id t?ng d?n
SELECT * FROM STUDENT ORDER BY ID ASC;
--      b. gi?i t�nh
SELECT * FROM STUDENT ORDER BY GENDER ASC;
--      c. ng�y sinh T?NG D?N v� h?c b?ng GI?M D?N
SELECT * FROM STUDENT ORDER BY BIRTHDAY ASC, SCHOLARSHIP DESC;


-- 2. M�n h?c c� t�n b?t ??u b?ng ch? 'T'
SELECT * FROM SUBJECT WHERE name LIKE 'T%';
-- 3. Sinh vi�n c� ch? c�i cu?i c�ng trong t�n l� 'i'
SELECT * FROM STUDENT WHERE NAME LIKE '%i';
-- 4. Nh?ng khoa c� k� t? th? hai c?a t�n khoa c� ch?a ch? 'n'
SELECT * FROM FACULTY WHERE NAME LIKE '_n%';  
-- 5. Sinh vi�n trong t�n c� t? 'Th?'
SELECT * FROM STUDENT WHERE NAME LIKE '%Th?%';
-- 6. Sinh vi�n c� k� t? ??u ti�n c?a t�n n?m trong kho?ng t? 'a' ??n 'm', s?p x?p theo h? t�n sinh vi�n
SELECT * FROM student
WHERE name BETWEEN 'A' AND 'M'
ORDER BY name ;
-- 7. Sinh vi�n c� h?c b?ng l?n h?n 100000, s?p x?p theo m� khoa gi?m d?n
SELECT * 
FROM STUDENT
WHERE SCHOLARSHIP > 100000 ORDER BY FACULTY_ID DESC;
-- 8. Sinh vi�n c� h?c b?ng t? 150000 tr? l�n v� sinh ? H� N?i
SELECT *
FROM STUDENT
WHERE SCHOLARSHIP >= 150000 AND HOMETOWN = 'H� N?i';
-- 9. Nh?ng sinh vi�n c� ng�y sinh t? ng�y 01/01/1991 ??n ng�y 05/06/1992
SELECT * FROM STUDENT WHERE BIRTHDAY BETWEEN '01/JAN/1991' AND '05/JUN/1992';
-- 10. Nh?ng sinh vi�n c� h?c b?ng t? 80000 ??n 150000
SELECT * 
FROM STUDENT 
WHERE SCHOLARSHIP BETWEEN 80000 AND 150000;
-- 11. Nh?ng m�n h?c c� s? ti?t l?n h?n 30 v� nh? h?n 45
SELECT * FROM SUBJECT 
WHERE LESSON_QUANTITY BETWEEN 30 AND 45;


-------------------------------------------------------------------

/********* B. CALCULATION QUERY *********/

-- 1. Cho bi?t th�ng tin v? m?c h?c b?ng c?a c�c sinh vi�n, g?m: M� sinh vi�n, Gi?i t�nh, M� 
		-- khoa, M?c h?c b?ng. Trong ?�, m?c h?c b?ng s? hi?n th? l� �H?c b?ng cao� n?u gi� tr? 
		-- c?a h?c b?ng l?n h?n 500,000 v� ng??c l?i hi?n th? l� �M?c trung b�nh�.
SELECT ID,GENDER, FACULTY_ID,
CASE
WHEN SCHOLARSHIP > 500000
THEN 'H?c b?ng cao' 
ELSE 'M?c trung b�nh' 
END AS Muc_hoc_bong  
FROM STUDENT; 
		
-- 2. T�nh t?ng s? sinh vi�n c?a to�n tr??ng
SELECT COUNT(id) AS Total_student
FROM STUDENT;
-- 3. T�nh t?ng s? sinh vi�n nam v� t?ng s? sinh vi�n n?.
SELECT COUNT(id) AS Total_student 
FROM STUDENT;
-- 4. T�nh t?ng s? sinh vi�n t?ng khoa
SELECT FACULTY_ID, COUNT(ID) AS Total_student 
FROM STUDENT
GROUP BY FACULTY_ID;
-- 5. T�nh t?ng s? sinh vi�n c?a t?ng m�n h?c
SELECT SUBJECT_ID,COUNT(STUDENT_ID) AS Total_student 
FROM EXAM_MANAGEMENT
GROUP BY SUBJECT_ID;
-- 6. T�nh s? l??ng m�n h?c m� sinh vi�n ?� h?c
SELECT STUDENT_ID,COUNT(SUBJECT_ID) AS Total_student 
FROM EXAM_MANAGEMENT
GROUP BY STUDENT_ID;
-- 7. T?ng s? h?c b?ng c?a m?i khoa	
SELECT FACULTY_ID,COUNT(SCHOLARSHIP) AS Total_scholarship 
FROM STUDENT
GROUP BY FACULTY_ID;
-- 8. Cho bi?t h?c b?ng cao nh?t c?a m?i khoa
SELECT FACULTY_ID,MAX(SCHOLARSHIP) AS Max_scholarship 
FROM STUDENT
GROUP BY FACULTY_ID;
-- 9. Cho bi?t t?ng s? sinh vi�n nam v� t?ng s? sinh vi�n n? c?a m?i khoa
SELECT FACULTY_ID,
COUNT(CASE WHEN GENDER ='Nam' THEN 'X' END) AS quantity_male_student,
COUNT(CASE WHEN GENDER =n'N?' THEN 'X' END) AS quantity_female_student
FROM STUDENT
GROUP BY FACULTY_ID;
-- 10. Cho bi?t s? l??ng sinh vi�n theo t?ng ?? tu?i
SELECT TRUNC(months_between(sysdate, BIRTHDAY) / 12) AS AGE,COUNT(ID) AS So_luong
FROM STUDENT
GROUP BY TRUNC(months_between(sysdate, BIRTHDAY) / 12);
-- 11. Cho bi?t nh?ng n?i n�o c� �t nh?t 2 sinh vi�n ?ang theo h?c t?i tr??ng
SELECT HOMETOWN 
FROM STUDENT
GROUP BY HOMETOWN
HAVING COUNT(ID)>=2;
-- 12. Cho bi?t nh?ng sinh vi�n thi l?i �t nh?t 2 l?n
SELECT STUDENT_ID
FROM EXAM_MANAGEMENT 
GROUP BY STUDENT_ID
HAVING COUNT(CASE WHEN NUMBER_OF_EXAM_TAKING >= 2 THEN 'X' END) >=2;

-- 13. Cho bi?t nh?ng sinh vi�n nam c� ?i?m trung b�nh l?n 1 tr�n 7.0 
SELECT
    STUDENT_ID,AVG(mark) FROM EXAM_MANAGEMENT
    WHERE STUDENT_ID IN (SELECT id FROM student
    WHERE GENDER = 'Nam')
    AND NUMBER_OF_EXAM_TAKING = 1
GROUP BY STUDENT_ID
HAVING AVG(mark)>7.0;
-- 14. Cho bi?t danh s�ch c�c sinh vi�n r?t �t nh?t 2 m�n ? l?n thi 1 (r?t m�n l� ?i?m thi c?a m�n kh�ng qu� 4 ?i?m)
SELECT EXAM_MANAGEMENT.STUDENT_ID,STUDENT.NAME 
FROM EXAM_MANAGEMENT, STUDENT
WHERE EXAM_MANAGEMENT.STUDENT_ID = STUDENT.ID AND NUMBER_OF_EXAM_TAKING = 1 AND MARK <= 4
GROUP BY STUDENT_ID,STUDENT.NAME
HAVING COUNT(STUDENT_ID)>=2;
-- 15. Cho bi?t danh s�ch nh?ng khoa c� nhi?u h?n 2 sinh vi�n nam
SELECT FACULTY.NAME, COUNT(GENDER) STUDENT_COUNT
FROM STUDENT, FACULTY
WHERE STUDENT.FACULTY_ID = FACULTY.id
AND GENDER = 'N?'
GROUP BY FACULTY.name
HAVING COUNT(GENDER) > 2;
-- 16. Cho bi?t nh?ng khoa c� 2 sinh vi�n ??t h?c b?ng t? 200000 ??n 300000
SELECT FACULTY_ID, COUNT(STUDENT.ID) STUDENT_NUMBER
FROM STUDENT
WHERE SCHOLARSHIP BETWEEN 200000 AND 300000
GROUP BY FACULTY_ID
HAVING COUNT(ID) = 2;
-- 17. Cho bi?t sinh vi�n n�o c� h?c b?ng cao nh?t
SELECT * 
FROM STUDENT
WHERE SCHOLARSHIP = (SELECT MAX(SCHOLARSHIP) FROM STUDENT);

-------------------------------------------------------------------

/********* C. DATE/TIME QUERY *********/

-- 1. Sinh vi�n c� n?i sinh ? H� N?i v� sinh v�o th�ng 02
SELECT * 
FROM STUDENT
WHERE HOMETOWN = n'H� N?i' AND TO_CHAR(STUDENT.BIRTHDAY, 'MM')='02';
-- 2. Sinh vi�n c� tu?i l?n h?n 20
SELECT *
FROM STUDENT
WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, BIRTHDAY) / 12) > 20;
-- 3. Sinh vi�n sinh v�o m�a xu�n n?m 1990
SELECT *
FROM STUDENT
WHERE TO_CHAR(STUDENT.BIRTHDAY, 'YYYY')=1990 AND (TO_CHAR(STUDENT.BIRTHDAY, 'MM')>=1 AND TO_CHAR(STUDENT.BIRTHDAY, 'MM')<=3);


-------------------------------------------------------------------


/********* D. JOIN QUERY *********/

-- 1. Danh s�ch c�c sinh vi�n c?a khoa ANH V?N v� khoa V?T L�
SELECT STUDENT.ID,STUDENT.NAME, FACULTY.NAME AS FACULTY_NAME
FROM STUDENT INNER JOIN FACULTY ON STUDENT.FACULTY_ID = FACULTY.ID
WHERE FACULTY.NAME = 'Anh - V?n' OR FACULTY.NAME = 'V?t l�';

-- 2. Nh?ng sinh vi�n nam c?a khoa ANH V?N v� khoa TIN H?C
SELECT STUDENT.ID,STUDENT.NAME, FACULTY.NAME AS FACULTY_NAME
FROM STUDENT INNER JOIN FACULTY ON STUDENT.FACULTY_ID = FACULTY.ID
WHERE FACULTY.NAME = 'Anh - V?n' OR FACULTY.NAME = 'Tin H?c' AND GENDER = 'Nam';
-- 3. Cho bi?t sinh vi�n n�o c� ?i?m thi l?n 1 m�n c? s? d? li?u cao nh?t
SELECT STUDENT.ID,STUDENT.NAME, SUBJECT.NAME, MAX(MARK)
FROM STUDENT INNER JOIN EXAM_MANAGEMENT ON STUDENT.ID = EXAM_MANAGEMENT.STUDENT_ID 
INNER JOIN SUBJECT ON  EXAM_MANAGEMENT.SUBJECT_ID = SUBJECT.ID 
WHERE NUMBER_OF_EXAM_TAKING = 1 AND EXAM_MANAGEMENT.SUBJECT_ID = 1
AND MARK = (SELECT MAX(MARK) FROM EXAM_MANAGEMENT EM,SUBJECT SJ
WHERE EM.SUBJECT_ID=SJ.ID AND EM.SUBJECT_ID = 1)
GROUP BY STUDENT.ID,STUDENT.NAME,SUBJECT.NAME;
-- 4. Cho bi?t sinh vi�n khoa anh v?n c� tu?i l?n nh?t.
SELECT STUDENT.NAME AS STUDENT_NAME, BIRTHDAY,FACULTY_ID
FROM STUDENT
WHERE BIRTHDAY=
(SELECT MIN(BIRTHDAY)FROM STUDENT WHERE FACULTY_ID = 1);
-- 5. Cho bi?t khoa n�o c� ?�ng sinh vi�n nh?t
SELECT FACULTY.NAME, COUNT(STUDENT.ID) AS SO_SV
FROM FACULTY INNER JOIN STUDENT ON FACULTY.ID = STUDENT.FACULTY_ID
GROUP BY FACULTY.NAME
HAVING COUNT(FACULTY.NAME)>=ALL
(SELECT COUNT(STUDENT.ID)FROM STUDENT GROUP BY FACULTY_ID);

-- 6. Cho bi?t khoa n�o c� ?�ng n? nh?t
SELECT F.ID,F.NAME, COUNT(S.GENDER)
FROM FACULTY F INNER JOIN STUDENT S ON f.id = S.FACULTY_ID
WHERE GENDER = N'N?'
GROUP BY F.ID,F.NAME
HAVING COUNT(GENDER) >= ALL
(SELECT COUNT(ID) FROM STUDENT WHERE GENDER=N'N?' GROUP BY FACULTY_ID);

-- 7. Cho bi?t nh?ng sinh vi�n ??t ?i?m cao nh?t trong t?ng m�n
SELECT EM.SUBJECT_ID,EM.STUDENT_ID,MARK
FROM EXAM_MANAGEMENT EM, 
(SELECT SUBJECT_ID, MAX(MARK) AS maxdiem
FROM EXAM_MANAGEMENT
GROUP BY SUBJECT_ID) DIEM
WHERE EM.SUBJECT_ID = DIEM.SUBJECT_ID AND MARK=DIEM.maxdiem
ORDER BY SUBJECT_ID;

-- 8. Cho bi?t nh?ng khoa kh�ng c� sinh vi�n h?c
SELECT * FROM FACULTY
WHERE NOT EXISTS
(SELECT DISTINCT F.ID,F.NAME
FROM FACULTY F LEFT OUTER JOIN STUDENT S ON (F.ID = S.FACULTY_ID)
WHERE F.ID = S.FACULTY_ID);

-- 9. Cho bi?t sinh vi�n ch?a thi m�n c? s? d? li?u
SELECT * FROM STUDENT
WHERE ID NOT IN
(SELECT DISTINCT STUDENT_ID 
FROM EXAM_MANAGEMENT
WHERE SUBJECT_ID = 1);
-- 10. Cho bi?t sinh vi�n n�o kh�ng thi l?n 1 m� c� d? thi l?n 2
SELECT STUDENT_ID
FROM EXAM_MANAGEMENT EM
WHERE NUMBER_OF_EXAM_TAKING = 2 AND NOT EXISTS
(SELECT *
FROM EXAM_MANAGEMENT
WHERE NUMBER_OF_EXAM_TAKING=1 AND STUDENT_ID=EM.STUDENT_ID);








