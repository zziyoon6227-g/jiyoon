import java.util.Scanner;   
import java.io.*;           

public class Library implements Manageable {

    Book[] books = new Book[10];
    int count = 0;
    Scanner sc = new Scanner(System.in);

    
    public static void main(String[] args) {
        Library ls = new Library();

        ls.loadFromFile();
        ls.menu();
    }

 
    public void menu() {
        while (true) {
            System.out.println("\n==== LIBRARY SYSTEM ====");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 목록 조회");
            System.out.println("3. 저장 및 종료");
            System.out.print("메뉴 선택 >> ");

            int num = sc.nextInt();
            sc.nextLine();

            if (num == 1) {
                addBook();
            } else if (num == 2) {
                displayAll();
            } else if (num == 3) {
                saveToFile(); 
                System.out.println("\n프로그램 종료");
                break;
            } else {
                System.out.println("\n잘못 입력했습니다.");
            }
        }
    }

   
    public void addBook() {
        // 배열이 꽉 찼는지 확인
        if (count >= books.length) {
            System.out.println("\n더 이상 저장할 수 없습니다.");
            return;
        }

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // 엔터까지 입력으로 알아서 한줄처리해줘야함

        System.out.print("제목: ");
        String title = sc.nextLine();

        System.out.print("저자: ");
        String author = sc.nextLine();

        // 입력받은 값으로 Book 객체 생성
        Book b = new Book(id, title, author);

        addItem(b);
        System.out.println("\n성공적으로 등록되었습니다.");
    }

    @Override
    public void addItem(Book book) {
        books[count] = book;
        count++;
    }

    @Override
    public void displayAll() {
        // 저장된 책이 없으면 안내문 출력
        if (count == 0) {
            System.out.println("\n등록된 도서가 없습니다.");
            return;
        }

        System.out.println("\n==== 도서 목록 ====");

        // 배열에 저장된 책만큼 반복
        for (int i = 0; i < count; i++) {
            System.out.println("번호: " + books[i].getId() +", 제목: " + books[i].getTitle() +
                ", 저자: " + books[i].getAuthor());
        }
    }

    @Override
    public void saveToFile() {
        try {
           BufferedWriter bw = new BufferedWriter(new FileWriter("C:/javame/jiyoon1/src/books.txt"));

            // 배열에 저장된 책 정보를 파일에 한 줄씩 저장
            for (int i = 0; i < count; i++) {
                bw.write(books[i].toFileString());
                bw.newLine(); // 줄바꿈
            }

            bw.close();
            System.out.println("\n파일 저장 완료");
        } catch (Exception e) {
            System.out.println("\n파일 저장 중 오류 발생");
        }
    }

    @Override
    public void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/javame/jiyoon1/src/books.txt"));

            String line;

            while ((line = br.readLine()) != null) {
              
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];

                // 읽어온 정보로 Book 객체 생성 후 배열에 저장
                books[count] = new Book(id, title, author);
                count++;
            }
            br.close();
        } catch (Exception e) {
        }
    }
}
