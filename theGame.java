import java.util.Scanner;

public class theGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str[] = {"가위","바위","보"};
		while (true) {
			System.out.print("가위바위보!>>");
			String myChoose = scanner.next();

			if (myChoose.equals("그만")) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			
			int n = (int)(Math.random()*3);
			
			System.out.println("컴퓨터: " + str[n]);
			System.out.println("사용자: " + myChoose);
			if (str[n].equals("가위")) {
				if (myChoose.equals("바위")) {
					System.out.println("사용자가 이겼습니다.");
				}
				else if (myChoose.equals("가위")) {
					System.out.println("사용자="+myChoose+",컴퓨터="+str[n]+",비겼습니다.");
				}
				else if (myChoose.equals("보")) {
					System.out.println("사용자="+myChoose+",컴퓨터="+str[n]+",컴퓨터가 이겼습니다.");
				}
			}
			else if (str[n].equals("바위")) {
				if (myChoose.equals("보")) {
					System.out.println("사용자="+myChoose+",컴퓨터="+str[n]+",사용자가 이겼습니다.");
				}
				else if (myChoose.equals("바위")) {
					System.out.println("사용자="+myChoose+",컴퓨터="+str[n]+",비겼습니다.");
				}
				else if (myChoose.equals("가위")) {
					System.out.println("사용자="+myChoose+",컴퓨터="+str[n]+",컴퓨터가 이겼습니다.");
				}
			}
			else if (str[n].equals("보")) {
				if (myChoose.equals("가위")) {
					System.out.println("사용자="+myChoose+",컴퓨터="+str[n]+",사용자가 이겼습니다.");
				}
				else if (myChoose.equals("보")) {
					System.out.println("사용자="+myChoose+",컴퓨터="+str[n]+",비겼습니다.");
				}
				else if (myChoose.equals("바위")) {
					System.out.println("사용자="+myChoose+",컴퓨터="+str[n]+",컴퓨터가 이겼습니다.");
				}
			}
		}
	}
}
