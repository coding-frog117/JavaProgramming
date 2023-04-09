import java.util.Scanner;

public class Book {
    String name;
    String number;

    public Book(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public void showNumber() {
        System.out.println(this.name + "의 번호는 " + this.number + "입니다");
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("인원수 >> ");
        int person = scanner.nextInt();
        Book[] book = new Book[person];

        for (int i = 0; i < person; i++) {
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력)>> ");
            String currentName = scanner.next();
            scanner.nextLine();
            String currentNumber = scanner.next();
            System.out.println("저장되었습니다.");

            book[i] = new Book(currentName, currentNumber);
        }

        while (true) {
            System.out.print("검색할 이름 >> ");
            String searchName = scanner.next();

            if (searchName.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            boolean test = false;

            for (int i = 0; i < book.length; i++) {
                if (searchName.equals(book[i].name)) {
                    book[i].showNumber();
                    test = true;
                    break;
                }
            }

            if (!test) {
                System.out.println(searchName + "이 없습니다.");
            }
        }
        scanner.close();
    }
}
