package com.join.quiz3;

import java.util.Scanner;

public class Quiz3 {
	static final String PRINT_GAMEOVER;
	static {
		PRINT_GAMEOVER="☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★\n"
				+"★축하합니다. 모든 문제를 맞췄습니다☆\n"
				+"☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★";
	}
	public static void main(String[] arg) {
		Scanner scan = new Scanner(System.in);
		int menu;
		int state=1;
		int quizNum=6;
		int quizNum5x5 = 2;
		Question []question;
		Question []selectQuestion;
		question=  new Question[quizNum];
		question[0] = new Question();
		question[0].setKeyword("음식");
		question[0].setAnswer("곱창");
		question[0].setQestionSource("육두쌍칸짜까치곱창동겹파자뽕면발");
		question[1] = new Question();
		question[1].setKeyword("우리반 사람들 중에 한명");
		question[1].setAnswer("유희상");
		question[1].setQestionSource("동연민진장원명우유희상방가환창조");
		question[2] = new Question();
		question[2].setKeyword("우리반 사람들 중에 한명");
		question[2].setAnswer("이명우");
		question[2].setQestionSource("이명우창박초인환윤장강동아연우성");
		question[3] = new Question();
		question[3].setKeyword("우리반 사람들 중에 한명");
		question[3].setAnswer("이명구");
		question[3].setQestionSource("이명구민호중균방은연주양성정은태");
		question[4] = new Question();
		question[4].setKeyword("우리반 사람들 중에 한명");
		question[4].setAnswer("최민진");
		question[4].setQestionSource("최민진수진호성창주박용호균라건곽");
		question[5] = new Question();
		question[5].setKeyword("우리반 사람들 중에 한명");
		question[5].setAnswer("박지용");
		question[5].setQestionSource("박지용동근혜균용찬명연주희상정종");
		Question5x5 []question5x5;
		question5x5 = new Question5x5[quizNum5x5];
		question5x5[0] = new Question5x5("우리반 사람들 중에 한명", "강동훈", "강동훈곽다동근서장아안민동박중지찬초방은양성희상찬");
		question5x5[1] = new Question5x5("우리반 사람들 중에 한명", "김지혜", "동훈김지혜준동성건연민호중균지용찬준초롱성장원아리");
 
		Main : while(true) {
			printMenu();
			state=1;
			menu = Integer.valueOf(scan.nextLine());
			if (menu == 1) {
				printMenu2();
				int menu2 = Integer.valueOf(scan.nextLine());
				if(menu2 ==1)
					selectQuestion = question;
				else
					selectQuestion = question5x5;
				while(true) {
					System.out.println(selectQuestion[state-1].getQuestion(state));
					System.out.println(selectQuestion[state-1].getProblem());		
					while (true) {
						if (selectQuestion[state-1].isAnswer(scan.nextLine())){
							System.out.println("정답입니다!!");
							break;
						}
						else{
							System.out.println("틀렸습니다. 정답을 입력하세요.");
						}
					}
					while(true) {
						System.out.println("게임을 계속하시겠습니까?(y/n)");
						String input3 = scan.nextLine();
						if(input3.equals("y")) 
							break;
						else if(input3.equals("n")) {
							System.out.println("게임을 종료합니다.");
							break Main;
						}else 
							System.out.println("잘못 입력했습니다. 다시입력하시오.");
					}
					if(state==quizNum5x5)
						break;
					else
						state++;
				}
				System.out.println(PRINT_GAMEOVER);
				
				while(true){
					System.out.println("게임을 다시 시작하시겠습니까?(y/n)");
					String input4 = scan.nextLine();
					if(input4.equals("y"))
						continue Main;
					else if(input4.equals("n")) {
						System.out.println("게임을 종료합니다.");
						break Main;
					}else
						System.out.println("잘못 입력했습니다. 다시입력하세요.");
				}
			} else if (menu == 2) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			else {
				System.out.println("잘못 입력했습니다. 다시입력하세요."); 
				continue;
			}
		}
	}
	
	public static void printMenu(){
		System.out.println("┌──────────────────┐");
		System.out.println("│      M E N U     │");
		System.out.println("│ 1.게임시작   	   │");
		System.out.println("│ 2.게임종료   	   │");
		System.out.println("└──────────────────┘");
	}
	public static void printMenu2(){
		System.out.println("┌──────────────────┐");
		System.out.println("│      M E N U     │");
		System.out.println("│ 1.4x4     	   │");
		System.out.println("│ 2.5x5     	   │");
		System.out.println("└──────────────────┘");
	}
}