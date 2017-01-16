package com.test.variable_exam;

import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] ar) {

		Scanner scan = new Scanner(System.in);
		int menu;
		int flag = 0;
		int qnum = 1;
		String ans;
		String[] qinfo = new String[] { " ", "음식", "배우", "우리반 친구", "동물" };
		String[] qans = new String[] { " ", "곱창", "공유", "이명우", "치타" };
		boolean state = true;
		boolean allState = true;

		char arr[] = new char[16];
		String select;

		while (allState) {
			state = true;
			System.out.println("┌──────────────────┐");
			System.out.println("│      M E N U     │");
			System.out.println("│ 1.게임시작     	   │");
			System.out.println("│ 2.게임종료  	   │");
			System.out.println("└──────────────────┘");
			menu = scan.nextInt();

			if (menu == 1) {
				while (state) {
					arr = qgenerator(qnum);
					System.out.println(qnum + " 번 문제 : " + qinfo[qnum]);
					System.out.println("┌───────┐");
					for (int i = 0; i < arr.length; i++) {
						System.out.print(" " + arr[i]);
						if (i % 4 == 3)
							System.out.println();
					}
					System.out.println("└───────┘");

					while (flag < 1) {
						ans = scan.next();
						if (ans.equals(qans[qnum])) {
							System.out.println("정답입니다.");
							qnum++;
							flag++;
						} else {
							System.out.println("틀렸습니다. 정답을 입력하세요.");
						}
					}
					System.out.println("계속 하시겠습니까?(Y : 1, N : 2)");
					select = scan.next();
					flag = 0;
					if (select.equals("N")) {
						state = false;
						System.out.println("메뉴로 돌아갑니다.");
					}
				}
			} else if (menu == 2) {
				System.out.println("게임을 종료합니다.");
				allState = false;
			} else {
				System.out.println("잘못 입력했습니다.");
			}
		}
	}

	public static char[] qgenerator(int n) {
		char[] arr = new char[16];
		String sentence = "";
		if (n == 1) {
			sentence = "육두쌍칸짜까치곱창동겹파자뽕면발";
		} else if (n == 2) {
			sentence = "건제검박우빈공부유잔상든훤이만호";
		} else if (n == 3) {
			sentence = "지원주명우수동환박성연인진정이롱";
		} else if (n == 4) {
			sentence = "코염슴치호끼수지고랑원린가릴타문";
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sentence.charAt(i);
		}
		return arr;
	}

}
