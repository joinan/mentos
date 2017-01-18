package version03;

import java.util.Scanner;

public class WordQuiz04{
	static Scanner scan = new Scanner(System.in);
	static int menu;
	static final String MENU="┌──────────────────┐\n│      M E N U     │\n│ 1.게임시작     	   │\n│ 2.문제생성  	   │\n"
			+ "│ 3.게임종료     	   │\n└──────────────────┘";

	public static void main(String[] args) {
		int flag = 0;
		boolean allState = true;
		boolean qState = true;

		String ans, select;
		int qNum = 1;


		QGen02 quiz = new QGen02();		 

		while (allState) {
			System.out.println(MENU);
			menu = scan.nextInt();
			qState = true;
 
			if (menu == 1) {
				while (qState) {
					/*
					 * arr = quiz.qgenerator(qNum); quiz.qRandom(arr);
					 */
					char arr[] = new char[quiz.qinfoList.size()];

					if (quiz.qList.size() != 0) {

						qNum = (int) (Math.random() * quiz.qinfoList.size());
						
						int n=quiz.qList.get(qNum).length();
						quiz.setNumofEaxm(n);
						int sqrtN=(int)Math.sqrt(n);
						
						arr = quiz.qgen(quiz.qList.get(qNum));
						arr = quiz.qRandom(arr);
												
						System.out.println(quiz.getCnt() + " 번 문제 : " + quiz.qinfoList.get(qNum));
						System.out.println("──────────────────");
						//System.out.println();
						for (int i = 0; i < arr.length; i++) {
							System.out.print("  " + arr[i]);
							if (i % sqrtN == sqrtN-1)
								System.out.println();
						}

						while (flag < 1) {
							ans = scan.next();
							if (ans.equals(quiz.ansList.get(qNum))) {
								quiz.setaCnt(quiz.getaCnt()+1);
								quiz.setrCnt(quiz.getrCnt()+1);
								
								
								System.out.println("정답입니다.");
								System.out.println("맞춘 문제 : "+quiz.getrCnt()+", 틀린 문제 : "+quiz.getaCnt());
								System.out.println("정답률 : "+(int)(double)((quiz.getrCnt()*100)/quiz.getaCnt())+"%");
								quiz.removeQ(qNum);
								quiz.setCnt(quiz.getCnt()+1);
								flag++;

							} else {
								System.out.println("틀렸습니다. 정답을 입력하세요.");
								quiz.setaCnt(quiz.getaCnt()+1);
							}
						}
						flag = 0;
						
					} else {
						System.out.println("문제가 없습니다.");
						System.out.println("메뉴로 돌아갑니다.");
						qState = false;
						break;
					}
					System.out.println("계속 하시겠습니까?(ㅇ/ㄴ)");
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

		String qEaxm, qSentence, qAns;
		
		System.out.println("보기 개수를 입력하시오");
		int nEaxm=scan.nextInt();
		char[] arr = new char[nEaxm];

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
