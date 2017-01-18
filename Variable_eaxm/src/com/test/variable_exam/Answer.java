package com.test.variable_exam;

import java.util.Scanner;

public class Answer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SelectedQuestion sq = new SelectedQuestion();
		String select;	

		while(true){
			System.out.println(sq.menu);
			select = scan.nextLine();
			if(select.equals("1")){
				while(true){
					System.out.println(sq.describe);
					System.out.println("┌─────────┐");
					for(int i = 0; i < sq.problem.size(); i++){
						if(i % 4 == 0) System.out.print("│ ");
						System.out.print(sq.problem.get(i) + " ");
						if(i % 4 == 3) System.out.print("│\n");
					}
					System.out.println("└─────────┘");
					System.out.print("정답은? : ");
					select = scan.nextLine();
					if(select.equals(sq.answer)){
						System.out.println("정답입니다!");
						System.out.print("계속하시겠습니까? (y/n) : ");
						select = scan.nextLine();
						if(select.equals("y")){
							sq = new SelectedQuestion();
							continue;
						}
						else if(select.equals("n")){
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
			else if(select.equals("2")){
				System.out.println("<<게임 종료>>");				
				scan.close();
				break;
			}
			else{
				System.out.println("잘못 입력하셨습니다. 게임을 종료합니다.");
				scan.close();
				break;
			}
		}
	}
	
}