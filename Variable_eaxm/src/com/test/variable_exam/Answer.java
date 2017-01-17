package com.test.variable_exam;

import java.util.List;
import java.util.Scanner;

public class Answer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Question question = new Question();
		int index;
		int menu;
		List<String> qlist;
		String trial;
		String ans;
		String hint;

		while(true){
			System.out.println("┌──────────────────┐");
			System.out.println("│      M E N U     │");
			System.out.println("│ 1.게임시작     	   │");
			System.out.println("│ 2.게임종료     	   │");
			System.out.println("└──────────────────┘");
			menu = scan.nextInt();
			if(menu == 1){
				index =  question.pick();
				qlist = question.shuffle(index);
				ans = question.answer[index];
				hint = question.hint[index];
				while(true){
					System.out.println((index + 1) + "번 문제 : " + hint);
					System.out.println("┌─────────┐");		
					for(int i = 0; i < qlist.size(); i++){
						if(i % 4 == 0) System.out.print("│ ");
						System.out.print(qlist.get(i));
						System.out.print(" ");
						if(i % 4 == 3) {
							System.out.print("│");
							System.out.println();
						}
					}
					System.out.println("└─────────┘");
					System.out.print("정답은? : ");
					Scanner scan2 = new Scanner(System.in);
					trial = scan2.nextLine();
					if(trial.equals(ans)){
						System.out.println("정답입니다!");
						System.out.print("계속하시겠습니까? (y/n) : ");
						trial = scan2.nextLine();
						if(trial.equals("y")){
							index =  question.pick();
							qlist = question.shuffle(index);
							ans = question.answer[index];
							hint = question.hint[index];
							continue;
						}
						else if(trial.equals("n")){
							System.out.println("<<메뉴로 이동합니다>>");
							break;
						}
						else {
							System.out.println("잘못 입력하셨습니다. 메뉴로 이동합니다.");
							break;
						}
					}
				}
			}
			else if(menu == 2){
				System.out.println("<<게임 종료>>");
				break;
			}
			else{
				System.out.println("잘못 입력하셨습니다. 게임을 종료합니다.");
			}
		}
	}
	
}