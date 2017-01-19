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
		int quizNum4x4=0;
		int quizNum5x5=0;
		int makeQuiz=0;
		int gameNum=1;
		String keyword, answer, str;
		Question []selectQuestion;
		Question4x4 []question4x4 = new Question4x4[5];
		Question5x5 []question5x5 = new Question5x5[5];
		
		QuestionDefault4x4 []questionDefault4x4 = new QuestionDefault4x4[6];		
		questionDefault4x4[0] = new QuestionDefault4x4("음식","곱창","육두쌍칸짜까치곱창동겹파자뽕면발");
		questionDefault4x4[1] = new QuestionDefault4x4("우리반 사람들 중에 한명","유희상","동연민진장원명우유희상방가환창조");
		questionDefault4x4[2] = new QuestionDefault4x4("우리반 사람들 중에 한명","이명우","이명우창박초인환윤장강동아연우성");
		questionDefault4x4[3] = new QuestionDefault4x4("우리반 사람들 중에 한명","이명구","이명구민호중균방은연주양성정은태");
		questionDefault4x4[4] = new QuestionDefault4x4("우리반 사람들 중에 한명","최민진","최민진수진호성창주박용호균라건곽");
		questionDefault4x4[5] = new QuestionDefault4x4("우리반 사람들 중에 한명","박지용","박지용동근혜균용찬명연주희상정종");

		QuestionDefault5x5 []questionDefault5x5 = new QuestionDefault5x5[2];
		questionDefault5x5[0] = new QuestionDefault5x5("우리반 사람들 중에 한명", "강동훈", "강동훈곽다동근서장아안민동박중지찬초방은양성희상찬");
		questionDefault5x5[1] = new QuestionDefault5x5("우리반 사람들 중에 한명", "김지혜", "동훈김지혜준동성건연민호중균지용찬준초롱성장원아리");
 
		Main : while(true) {
			printMenu();
			state=1;
			menu = Integer.valueOf(scan.nextLine());
			if (menu == 1) {
				printMenu2();
				int menu2 = Integer.valueOf(scan.nextLine());
				if(menu2 ==1) {
					selectQuestion = questionDefault4x4;
					gameNum=6;
				}
				else if(menu2 == 2) {
					selectQuestion = questionDefault5x5;
					gameNum=2;
				}
				else if(menu2 == 3) {
					if(quizNum4x4 == 0){
						System.out.println("문제를 만들어주세요.");
						continue Main;
					}
					else 
						selectQuestion = question4x4;
				}
				else {
					if(quizNum5x5 == 0){
						System.out.println("문제를 만들어주세요.");
						continue Main;
					}
					else
						selectQuestion = question5x5;
				}
				while(true) {
					state=1;
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
					if(state==gameNum)
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
			} else if(menu == 2){
				printMenu3();
				int menu3 = Integer.valueOf(scan.nextLine());
				if(menu3==1){
					System.out.println("몇 문제 만들까요?");
					quizNum4x4 = Integer.valueOf(scan.nextLine());
					makeQuiz = 0;
					while(true){
						
						System.out.println((makeQuiz+1)+"번째 문제 키워드를 입력하세요");
						keyword = scan.nextLine();
						System.out.println((makeQuiz+1)+"번째 문제 답을 입력하세요");
						answer = scan.nextLine();
						System.out.println((makeQuiz+1)+"번째 문제 문자열을 쭈욱 입력하세요.최소 16자");
						str = scan.nextLine();
						question4x4[makeQuiz] = new Question4x4(keyword, answer, str);
						makeQuiz++;
						if(makeQuiz==quizNum4x4)
							break;
					}
				}else if(menu3==2){
					System.out.println("몇 문제 만들까요?");
					quizNum5x5 = Integer.valueOf(scan.nextLine());
					makeQuiz = 0;
					while(true){
						System.out.println((makeQuiz+1)+"번째 문제 키워드를 입력하세요");
						keyword = scan.nextLine();
						System.out.println((makeQuiz+1)+"번째 문제 답을 입력하세요");
						answer = scan.nextLine();
						System.out.println((makeQuiz+1)+"번째 문제 문자열을 쭈욱 입력하세요.최소 25자");
						str = scan.nextLine();
						question5x5[makeQuiz] = new Question5x5(keyword, answer, str);
						makeQuiz++;
						if(makeQuiz==quizNum5x5)
							break;
					}
				}
			}
			else if (menu == 3) {
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
		System.out.println("│ 2.문제만들기  	   │");
		System.out.println("│ 3.게임종료   	   │");
		System.out.println("└──────────────────┘");
	}
	public static void printMenu2(){
		System.out.println("┌──────────────────┐");
		System.out.println("│      M E N U     │");
		System.out.println("│ 1.4x4 기본문제  	   │");
		System.out.println("│ 2.5x5 기본문제  	   │");
		System.out.println("│ 3.4x4 만든문제  	   │");
		System.out.println("│ 4.5x5 만든문제  	   │");
		System.out.println("└──────────────────┘");
	}
	public static void printMenu3(){
		System.out.println("┌──────────────────┐");
		System.out.println("│      M E N U     │");
		System.out.println("│ 1.4x4            │");
		System.out.println("│ 2.5x5            │");
		System.out.println("└──────────────────┘");
	}
}