package version03;

import java.util.Scanner;

public class WordQuiz03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu;
		int flag = 0;
		boolean allState = true;
		boolean qState = true;

		String ans, select;
		int qNum = 1;
		char arr[] = new char[16];

		String[] qinfo = new String[] { " ", "음식", "배우", "우리반 친구", "동물" };
		String[] qans = new String[] { " ", "곱창", "공유", "이명우", "치타" };
		
		QGen quiz = new QGen();

		while (allState) {
			System.out.println("┌──────────────────┐");
			System.out.println("│      M E N U     │");
			System.out.println("│ 1.게임시작     	   │");
			System.out.println("│ 2.게임종료     	   │");
			System.out.println("└──────────────────┘");
			menu = scan.nextInt();

			if (menu == 1) {
				while (qState) {
					arr = quiz.qgenerator(qNum);
					quiz.qRandom(arr);
					
					System.out.println(qNum + " 번 문제 : " + qinfo[qNum]);
					System.out.println("┌───────┐");
					for (int i = 0; i < arr.length; i++) {
						System.out.print(" " + arr[i]);
						if (i % 4 == 3)
							System.out.println();
					}
					System.out.println("└───────┘");

					while (flag < 1) {
						ans = scan.next();
						if (ans.equals(qans[qNum])) {
							System.out.println("정답입니다.");
							qNum++;
							flag++;
						} else {
							System.out.println("틀렸습니다. 정답을 입력하세요.");
						}
					}
					System.out.println("계속 하시겠습니까?(Y/N)");
					select = scan.next();
					flag = 0;
					if (select.equals("N")) {
						qState = false;
						System.out.println("메뉴로 돌아갑니다.");
					}
				}
			} /*else if (menu == 2) {
				System.out.println("문제를 입력하세요.");
				quiz.qgenerator(qNum);
				System.out.println("입력 완료.");
				qNum++;
			}*/else if (menu==2) {
				allState = false;
			} 
			else
				System.out.println("잘못 입력했습니다.");

		}
		System.out.println("게임을 종료합니다.");
	}
}
