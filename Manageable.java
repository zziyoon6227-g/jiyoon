public interface Manageable {
    void addItem(Book book); //데이터 추가
    void displayAll();       //전체 목록 출력
    void saveToFile();       //데이터 저장
    void loadFromFile();     //파일에서 데이터 가져오기
}
