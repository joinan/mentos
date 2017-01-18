package version03;

import java.util.Scanner;

public class WordQuiz03 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int menu;
		int flag = 0;
		boolean allState = true;
		boolean qState = true;

		String ans, select;
		int qNum = 1;
		int cnt = 1;
		char arr[] = new char[16];

		QGen quiz = new QGen();

		while (allState) {
			System.out.println("┌──────────────────┐");
			System.out.println("│      M E N U     │");
			System.out.println("│ 1.게임시작     	   │");
			System.out.println("│ 2.문제생성  	   │");
			System.out.println("│ 3.게임종료     	   │");
			System.out.println("└──────────────────┘");
			menu = scan.nextInt();
			qState = true;

			if (menu == 1) {
				while (qState) {
					/*
					 * arr = quiz.qgenerator(qNum); quiz.qRandom(arr);
					 */
					if (quiz.qList.size() != 0) {

						qNum = (int) (Math.random() * quiz.qinfoList.size());

						arr = quiz.qgen(quiz.qList.get(qNum));
						arr = quiz.qRandom(arr);
						System.out.println(cnt + " 번 문제 : " + quiz.qinfoList.get(qNum));
						System.out.println("┌───────┐");
						for (int i = 0; i < arr.length; i++) {
							System.out.print(" " + arr[i]);
							if (i % 4 == 3)
								System.out.println();
						}
						System.out.println("└───────┘");

						while (flag < 1) {
							ans = scan.next();
							if (ans.equals(quiz.ansList.get(qNum))) {
								System.out.println("정답입니다.");
								quiz.removeQ(qNum);
								cnt++;
								flag++;

							} else {
								System.out.println("틀렸습니다. 정답을 입력하세요.");
							}
						}
						flag = 0;
						
					} else {
						System.out.println("문제가 없습니다.");
						System.out.println("메뉴로 돌아갑니다.");
						qState = false;
						break;
					}
					System.out.println("계속 하시겠습니까?(Y/N)");
					select = scan.next();
					flag = 0;
					if (select.equals("ㄴ")) {
						qState = false;
						System.out.println("메뉴로 돌아갑니다.");
					}
				}

				flag = 0;
			} else if (menu == 2) {
				inputM(quiz);
			} else if (menu == 3) {
				allState = false;
			} else
				System.out.println("잘못 입력했습니다.");

		}
		System.out.println("게임을 종료합니다.");
	}

	static void inputM(QGen quiz) {
		char[] arr = new char[16];

		String qEaxm, qSentence, qAns;
		System.out.println("문제 입력");
		qEaxm = scan.next();
		System.out.println("보기 입력");
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + "번째 글자 입력");
			arr[i] = scan.next().charAt(0);
		}
		qSentence = new String(arr);
		System.out.println("답 입력");
		qAns = scan.next();
		quiz.inputQ(qEaxm, qSentence, qAns);

	}
}
