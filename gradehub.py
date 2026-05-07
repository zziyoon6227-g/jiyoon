import oracledb
import sys

USER = "system"
PASSWORD = "1234"
DSN = "localhost:1521/xe"


def get_conn():
    return oracledb.connect(user=USER, password=PASSWORD, dsn=DSN)


def insert_grade():
    data = input("성적 입력(이름,국어,영어,수학): ")
    arr = data.split(",")

    name = arr[0].strip()
    kor = int(arr[1].strip())
    eng = int(arr[2].strip())
    math = int(arr[3].strip())

    sql = """
    INSERT INTO grade(stu_id, stu_name, kor, eng, math, teacher_note)
    VALUES(grade_seq.NEXTVAL, :1, :2, :3, :4, NULL)
    """

    conn = get_conn()
    cursor = conn.cursor()

    cursor.execute(sql, [name, kor, eng, math])
    conn.commit()

    print("DB 저장 성공!")

    cursor.close()
    conn.close()


def update_grade():
    name = input("수정할 학생 이름: ")
    kor = int(input("국어 점수: "))
    eng = int(input("영어 점수: "))
    math = int(input("수학 점수: "))

    sql = """
    UPDATE grade
    SET kor = :1, eng = :2, math = :3
    WHERE stu_name = :4
    """

    conn = get_conn()
    cursor = conn.cursor()

    cursor.execute(sql, [kor, eng, math, name])
    conn.commit()

    if cursor.rowcount > 0:
        print("성적 수정 완료")
    else:
        print("해당 학생이 없습니다.")

    cursor.close()
    conn.close()


def update_note():
    name = input("코멘트 입력할 학생 이름: ")
    note = input("선생님 코멘트: ")

    sql = """
    UPDATE grade
    SET teacher_note = :1
    WHERE stu_name = :2
    """

    conn = get_conn()
    cursor = conn.cursor()

    cursor.execute(sql, [note, name])
    conn.commit()

    if cursor.rowcount > 0:
        print("코멘트 저장 완료")
    else:
        print("해당 학생이 없습니다.")

    cursor.close()
    conn.close()


def class_report():
    conn = get_conn()
    cursor = conn.cursor()

    print("\n--- 학급 리포트 ---")

    # LISTAGG
    cursor.execute("""
        SELECT LISTAGG(stu_name, ', ')
        WITHIN GROUP (ORDER BY stu_name)
        FROM grade
    """)

    row = cursor.fetchone()
    print("전체 학생 목록:", row[0])

    # RANK
    cursor.execute("""
        SELECT stu_name,
               kor + eng + math AS total,
               ROUND((kor + eng + math) / 3, 1) AS avg_score,
               RANK() OVER (ORDER BY (kor + eng + math) DESC) AS ranking
        FROM grade
        ORDER BY ranking
    """)

    for row in cursor:
        print(f"{row[3]}위 {row[0]} / 총점: {row[1]} / 평균: {row[2]}")

    # AVG, MAX, MIN
    cursor.execute("""
        SELECT ROUND(AVG((kor + eng + math) / 3), 1),
               MAX(kor + eng + math),
               MIN(kor + eng + math)
        FROM grade
    """)

    row = cursor.fetchone()
    print("\n전체 평균:", row[0])
    print("최고 총점:", row[1])
    print("최저 총점:", row[2])

    cursor.close()
    conn.close()


def get_grade(avg):
    if avg >= 90:
        return "A"
    elif avg >= 80:
        return "B"
    elif avg >= 70:
        return "C"
    elif avg >= 60:
        return "D"
    else:
        return "F"


def search_student():
    name = input("본인 이름을 입력하세요: ")

    sql = """
    SELECT *
    FROM (
        SELECT stu_name, kor, eng, math, teacher_note,
               kor + eng + math AS total,
               ROUND((kor + eng + math) / 3, 1) AS avg_score,
               RANK() OVER (ORDER BY (kor + eng + math) DESC) AS ranking
        FROM grade
    )
    WHERE stu_name = :1
    """

    conn = get_conn()
    cursor = conn.cursor()

    cursor.execute(sql, [name])
    row = cursor.fetchone()

    if row:
        avg = row[6]

        print("\n--- 학생 성적 조회 ---")
        print("이름:", row[0])
        print("국어:", row[1])
        print("영어:", row[2])
        print("수학:", row[3])
        print("총점:", row[5])
        print("평균:", row[6])
        print("석차:", str(row[7]) + "위")
        print("성취도:", get_grade(avg))

        if row[4] is None:
            print("선생님 코멘트: 아직 입력되지 않았습니다.")
        else:
            print("선생님 코멘트:", row[4])
    else:
        print("조회 결과가 없습니다.")

    cursor.close()
    conn.close()


def teacher_mode():
    while True:
        print("\n--- 교사 모드 ---")
        print("1. 성적 입력")
        print("2. 성적 수정")
        print("3. 코멘트 입력")
        print("4. 학급 리포트")
        print("0. 이전 메뉴")

        menu = input("선택 >> ")

        if menu == "1":
            insert_grade()
        elif menu == "2":
            update_grade()
        elif menu == "3":
            update_note()
        elif menu == "4":
            class_report()
        elif menu == "0":
            break
        else:
            print("잘못된 메뉴입니다.")


def main():
    while True:
        print("\n==== Grade Hub ====")
        print("1. 교사 모드")
        print("2. 학생 모드")
        print("0. 종료")

        menu = input("선택 >> ")

        if menu == "1":
            teacher_mode()
        elif menu == "2":
            search_student()
        elif menu == "0":
            print("프로그램 종료")
            break
        else:
            print("잘못된 메뉴입니다.")


main()