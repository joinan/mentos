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
		System.out.println("│ 1.게임시작     	   │");
		System.out.println("│ 2.게임종료  	   │");
		System.out.println("└──────────────────┘");
		menu = scan.nextInt();

		if (menu == 1) {
			System.out.println("1번 문제 : 음식");
			System.out.println("┌───────────┐");
			System.out.println("│ 육　두　쌍　칸 │");
			System.out.println("│ 짜　까　치　곱 │");
			System.out.println("│ 창　동　겹　파 │");
			System.out.println("│ 자　뽕　면　발 │");
			System.out.println("└───────────┘");

			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("곱창")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다. 정답을 입력하세요.");
				}
			}
			
			flag = 0;
			System.out.println("2번 문제 : 우리반 사람들 중에 한명");
			System.out.println("┌───────────┐");
			System.out.println("│ 장　훈　용　찬 │");
			System.out.println("│ 서　희　구　진 │");
			System.out.println("│ 다　호　최　유 │");
			System.out.println("│ 상　열　준　범 │");
			System.out.println("└───────────┘");
			
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("유희상")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다. 정답을 입력하세요.");
				}
			}
			flag = 0;
			
			System.out.println("3번 문제 : 남자배우");
			System.out.println("┌───────────┐");
			System.out.println("│ 건　제　검　박 │");
			System.out.println("│ 우　빈　공　부 │");
			System.out.println("│ 유　잔　상　든 │");
			System.out.println("│ 훤  이　만　호 │");
			System.out.println("└───────────┘");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("공유")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다. 정답을 입력하세요.");
				}
			}
			flag = 0;
			System.out.println("4번 문제 : 우리반 사람들 중에 한명");
			System.out.println("┌───────────┐");
			System.out.println("│ 지　원　주　명 │");
			System.out.println("│ 우  수  동  환 │");
			System.out.println("│ 박  성  연  인 │");
			System.out.println("│ 진　정　이　롱 │");
			System.out.println("└───────────┘");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("이명우")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다. 정답을 입력하세요.");
				}
			}
			flag = 0;
			System.out.println("5번 문제 : 동물");
			System.out.println("┌───────────┐");
			System.out.println("│ 코　염　슴　치 │");
			System.out.println("│ 호　끼　수　지 │");
			System.out.println("│ 고　랑　원　린 │");
			System.out.println("│ 가　릴　타　문 │");
			System.out.println("└───────────┘");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("치타")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다. 정답을 입력하세요.");
				}
			}
			flag = 0;
			System.out.println("6번 문제 : 스포츠");
			System.out.println("┌───────────┐");
			System.out.println("│ 마　스　콜　두 │");
			System.out.println("│ 용　테　고　링 │");
			System.out.println("│ 축　역　프　수 │");
			System.out.println("│ 양　야　말　승 │");
			System.out.println("└───────────┘");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("승마")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다. 정답을 입력하세요.");
				}
			}
			
			flag = 0;
			System.out.println("7번 문제 : 기업");
			System.out.println("┌───────────┐");
			System.out.println("│ 이　플　동　에 │");
			System.out.println("│ 두　수　성　나 │");
			System.out.println("│ 글　한　케　다 │");
			System.out.println("│ 디　레　엘　티 │");
			System.out.println("└───────────┘");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("케이티")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다. 정답을 입력하세요.");
				}
			}
			flag = 0;
			System.out.println("8번 문제 : 음료수");
			System.out.println("┌───────────┐");
			System.out.println("│ 환　티　아　봉 │");
			System.out.println("│ 마　콜　운　레 │");
			System.out.println("│ 사　스　밀　다 │");
			System.out.println("│ 수　붕　제　비 │");
			System.out.println("└───────────┘");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("제티")){
					flag++;
				}
				else{
					System.out.println("틀렸습니다. 정답을 입력하세요.");
				}
			}			
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("★축하합니다. 게임을 종료합니다.☆");
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			
		} else if (menu == 2) {
			System.out.println("게임을 종료합니다.");
		} else {
			System.out.println("잘못 입력했습니다. 게임을 종료합니다.");
		}
	}

}
