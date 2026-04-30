DROP SEQUENCE boardss_seq; //시퀀스 삭제
DROP TABLE boardss CASCADE CONSTRAINTS; //테이블 전체삭제
DELETE FROM boardss; //테이블 데이터 삭제
SELECT * FROM boardss; //테이블 확인용
DELETE FROM boardss
where bno = '5'; //테이블 데이터 조건걸어 삭제


 
-- 1. 테이블 생성
CREATE TABLE boardss (
    bno NUMBER PRIMARY KEY,
    btitle VARCHAR2(100) NOT NULL,
    bcontent VARCHAR2(1000) NOT NULL,
    bwriter VARCHAR2(50) NOT NULL,
    bdate DATE DEFAULT SYSDATE
);

-- 2. 시퀀스 생성
CREATE SEQUENCE boardss_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 3. 테스트 데이터 입력
INSERT INTO boardss (bno, btitle, bcontent, bwriter)
VALUES (boardss_seq.NEXTVAL, '첫 번째 글', '내용1', '홍길동');

INSERT INTO boardss (bno, btitle, bcontent, bwriter)
VALUES (boardss_seq.NEXTVAL, '두 번째 글', '내용2', '이순신');

INSERT INTO boardss (bno, btitle, bcontent, bwriter)
VALUES (boardss_seq.NEXTVAL, '세 번째 글', '내용3', '김유신');

-- 4. 커밋 (저장)
COMMIT;


-- 5. 전체 조회
SELECT 
    bno,
    btitle,
    bwriter,
    TO_CHAR(bdate, 'YYYY-MM-DD') AS bdate
FROM boardss
ORDER BY bno DESC;



