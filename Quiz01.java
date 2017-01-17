package com.test.variable_exam;

import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] ar) {

		Scanner scan = new Scanner(System.in);
		int menu;
		int flag = 0;
		String ans;
		System.out.println("┌──────────────────┐");
		System.out.println("│      M E N U     │");
		System.out.println("│ 1.게임시작       	   │");
		System.out.println("│ 2.게임종료     	   │");
		System.out.println("└──────────────────┘");
		menu = scan.nextInt();

		if (menu == 1) {
			System.out.println("1번문 제");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");

			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("정우성")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다.");
				}
			}
			
			flag = 0;
			System.out.println("2번문 제");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("정우성")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다.");
				}
			}
			flag = 0;
			
			System.out.println("3번문 제");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("정우성")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다.");
				}
			}
			flag = 0;
			System.out.println("4번문 제");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("정우성")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다.");
				}
			}
			flag = 0;
			System.out.println("5번문 제");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			System.out.println("ㅇㄹㅇㄹㅇㄹㅇㄹ");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("정우성")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다.");
				}
			}
			System.out.println("축하합니다. 게임을 종료 합니다.");
		} else if (menu == 2) {
			System.out.println("게임을 종료합니다.");
		} else {
			System.out.println("잘못선택하셨습니다.");
		}
	}

}
