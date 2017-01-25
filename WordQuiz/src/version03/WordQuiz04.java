package version03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class WordQuiz04 {
	static Scanner sc = new Scanner(System.in);
	static int menu;
	static final String INTROMENU = "┌──────────────────┐\n" + "│      M E N U     │\n" + "│ 1.로그인      	   │\n"
			+ "│ 2.회원가입  	   │\n" + "│ 3.게임종료     	   │\n" + "└──────────────────┘";
	static final String MENU = "┌──────────────────┐\n" + "│      M E N U     │\n" + "│ 1.게임시작     	   │\n"
			+ "│ 2.문제생성  	   │\n" + "│ 3.게임종료     	   │\n" + "└──────────────────┘";
	// static Member member=new Member();
	static ArrayList<Member> members = null;// new ArrayList<Member>();

	public static void main(String[] args) {
		int flag = 0;
		boolean allState = false;
		boolean qState = true;
		boolean totalState = true;
		boolean checkId;
		String ans, select, str;
		int qNum = 1;

		// System.out.println(members.size());
		Member member = new Member();

		while (totalState) {
			QGen02 quiz = new QGen02();

			System.out.println(INTROMENU);
			menu = sc.nextInt();
			if (menu == 1) {
				while (true) {
					System.out.println("ID를 입력하세요.");
					str = sc.next();
					checkId = checkId(str);
					if (checkId) {
						member.setMemId(str);
						System.out.println(str + "님 환영합니다.");
						allState = true;

						break;
					} else {
						System.out.println("존재하는 ID가 아닙니다.");
					}
				}

			} else if (menu == 2) {
				try {
					while (true) {
						System.out.println("ID를 입력하세요.");
						str = sc.next();
						checkId = checkId(str);
						if (!checkId) {
							member.setMemId(str);
							members.add(member);
							System.out.println(str + "님 환영합니다.");

							break;
						} else {
							System.out.println("이미 존재하는 ID입니다.");
						}
					}

					FileOutputStream fos = new FileOutputStream("member.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					for (int i = 0; i < members.size(); i++) {
						oos.writeObject(members.get(i));
					}
					oos.flush();
					oos.close();
					fos.close();
					allState = true;

					System.out.println(members.size());

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				totalState = false;
			}
			while (allState) {
				System.out.println(MENU);
				menu = sc.nextInt();
				qState = true;

				if (menu == 1) {
					while (qState) {
						/*
						 * arr = quiz.qgenerator(qNum); quiz.qRandom(arr);
						 */
						char arr[] = new char[quiz.qinfoList.size()];

						if (quiz.qList.size() != 0) {

							qNum = (int) (Math.random() * quiz.qinfoList.size());

							int n = quiz.qList.get(qNum).length();
							quiz.setNumofEaxm(n);
							int sqrtN = (int) Math.sqrt(n);

							arr = quiz.qgen(quiz.qList.get(qNum));
							arr = quiz.qRandom(arr);

							System.out.println(quiz.getCnt() + " 번 문제 : " + quiz.qinfoList.get(qNum));
							System.out.println("──────────────────");
							// System.out.println();
							for (int i = 0; i < arr.length; i++) {
								System.out.print("  " + arr[i]);
								if (i % sqrtN == sqrtN - 1)
									System.out.println();
							}

							while (flag < 1) {
								ans = sc.next();
								if (ans.equals(quiz.ansList.get(qNum))) {

									System.out.println("정답입니다.");
									member=input(member);
									member = outputResult();
									
									System.out.println(member.getMemId() + "님의 정답률은 " + member.getPercent() + ", 점수는 "
											+ member.getScore() + "점 입니다.");
									quiz.removeQ(qNum);
									quiz.setCnt(quiz.getCnt() + 1);
									flag++;

								} else {
									System.out.println("틀렸습니다. 정답을 입력하세요.");
									minusScore(member);
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
						select = sc.next();
						flag = 0;
						if (select.equals("ㄴ")) {
							qState = false;
							System.out.println("메뉴로 돌아갑니다.");
						}
					}

					flag = 0;
				} else if (menu == 2) {
					inputQuestion(quiz);
				} else if (menu == 3) {
					allState = false;
				} else
					System.out.println("잘못 입력했습니다.");

			}
		}
		System.out.println("게임을 종료합니다.");
	}

	static void inputQuestion(QGen quiz) {

		String qEaxm, qSentence, qAns;

		System.out.println("보기 개수를 입력하시오");
		int nEaxm = sc.nextInt();
		char[] arr = new char[nEaxm];

		System.out.println("문제 입력");
		qEaxm = sc.next();
		System.out.println("보기 입력");
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + "번째 글자 입력");
			arr[i] = sc.next().charAt(0);
		}
		qSentence = new String(arr);
		System.out.println("답 입력");
		qAns = sc.next();
		quiz.inputQ(qEaxm, qSentence, qAns);
	}

	static Member input(Member member) {
		try {
			FileOutputStream fos = new FileOutputStream("member.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			member.setaCnt(member.getaCnt() + 1);
			member.setrCnt(member.getrCnt() + 1);
			member.setScore(member.getScore() + 20);
			member.setPercent((int) (double) ((member.getrCnt() * 100) / member.getaCnt()));
			oos.writeObject(member);

			oos.flush();
			oos.close();
			fos.close();
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;

	}

	static Member minusScore(Member member) {
		try {
			FileOutputStream fos = new FileOutputStream("member.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			member.setScore(member.getScore() - 10);
			member.setaCnt(member.getaCnt() + 1);

			oos.writeObject(member);
			oos.flush();
			oos.close();
			fos.close();
			return member;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;

	}

	static Member outputResult() {
		Member member2 = null;
		try {
			FileInputStream fis = new FileInputStream("member.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			member2 = (Member) ois.readObject();

			ois.close();
			fis.close();
		} catch (Exception e) {
		}
		return member2;
	}

	static boolean checkId(String str) {
		//////////////////////////////////////
		// 회원정보 가져오기
		members = new ArrayList<Member>();
		try {
			FileInputStream fis = new FileInputStream("member.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				while (true) {
					Member member = (Member) ois.readObject();
					for (int i = 0; i < members.size(); i++) {
						if (members.get(i).getMemId().equals(str)) {
							return true;
						}
					}
					members.add(member);
				}
			} catch (Exception e) {
				// e.printStackTrace();
			}
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
