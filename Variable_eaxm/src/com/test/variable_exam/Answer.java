package com.test.variable_exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Answer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Question quest = new Question();
		int pick;
		int menu;
		String[] answer = {"곱창", "공유", "이명우", "치타"};
		String[] question1 = {"육","두","쌍","칸","짜","까","치","곱","창","동","겹","파","자","뽕","면","발"};
		String[] question2 = {"건","제","검","박","우","빈","공","부","유","잔","상","든","훤","이","만","호"};
		String[] question3 = {"지","원","주","명","우","수","동","환","박","성","연","인","진","정","이","롱"};
		String[] question4 = {"코","염","슴","치","호","끼","수","지","고","랑","원","린","가","릴","타","문"};
		String[][] collect = new String[4][16];
		collect[0] = question1;
		collect[1] = question2;
		collect[2] = question3;
		collect[3] = question4;
		List<String> list;
		String trial;
		String ans;
		
		
		while(true){
			System.out.println("┌──────────────────┐");
			System.out.println("│      M E N U     │");
			System.out.println("│ 1.게임시작     	   │");
			System.out.println("│ 2.게임종료     	   │");
			System.out.println("└──────────────────┘");
			menu = scan.nextInt();
			
			if(menu == 1){
				pick =  quest.pick();
				list = quest.shuffle(collect[pick]);
				ans = answer[pick];
				while(true){
					System.out.println("┌─────────┐");		
					for(int i = 0; i < list.size(); i++){
						if(i % 4 == 0) System.out.print("│ ");
						System.out.print(list.get(i));
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
						System.out.println("정답입니다.");
						System.out.print("계속하시겠습니까? (y/n) : ");
						trial = scan2.nextLine();
						if(trial.equals("y")){
							pick =  quest.pick();
							list = quest.shuffle(collect[pick]);
							ans = answer[pick];
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
			}else{
				System.out.println("잘못 입력하셨습니다. 게임을 종료합니다.");
			}
			
		}
		
		

	}

}
 