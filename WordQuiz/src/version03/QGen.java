package version03;

import java.util.ArrayList;
import java.util.Scanner;

public class QGen {

	Scanner sc = new Scanner(System.in);
	String qSentence, qAns, qEaxm;
	String inputSentence[] = new String[5];
	String inputAns[] = new String[5];

	ArrayList<String> qinfoList = new ArrayList<String>();
	ArrayList<String> qList = new ArrayList<String>();
	ArrayList<String> ansList = new ArrayList<String>();

	public QGen() {
		qinfoList.add("음식");
		/*qinfoList.add("우리반 친구");
		qinfoList.add("배우");
		qinfoList.add("동물");*/

		ansList.add("곱창");
		/*ansList.add("이명우");
		ansList.add("공유");
		ansList.add("치타");*/

		qList.add("육두쌍칸짜까치곱창동겹파자뽕면발");
		/*qList.add("지원주명우수동환박성연인진정이롱");
		qList.add("건제검박우빈공부유잔상든훤이만호");
		qList.add("코염슴치호끼수지고랑원린가릴타문");*/
	}

	char[] qgenerator(int qNum) {
		char[] arr = new char[16];
		if (qNum == 1) {
			qSentence = "육두쌍칸짜까치곱창동겹파자뽕면발";
		} else if (qNum == 2) {
			qSentence = "건제검박우빈공부유잔상든훤이만호";
		} else if (qNum == 3) {
			qSentence = "지원주명우수동환박성연인진정이롱";
		} else if (qNum == 4) {
			qSentence = "코염슴치호끼수지고랑원린가릴타문";
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = qSentence.charAt(i);
		}
		// System.out.println("qgenerator "+Arrays.toString(arr));
		return arr;
	}

	char[] qRandom(char[] arrRandom) {
		int[] arr = new int[16];
		int seed;
		char temp;

		for (int i = 0; i < arr.length; i++) {
			seed = (int) (Math.random() * 15) + 1;
			// System.out.println(seed);
			temp = arrRandom[i];
			arrRandom[i] = arrRandom[seed];
			arrRandom[seed] = temp;
		}
		// System.out.println("qrandom "+Arrays.toString(arrRandom));
		return arrRandom;
	}

	char[] qgen(String str) {
		char[] arr = new char[16];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		// System.out.println("qgenerator "+Arrays.toString(arr));
		return arr;
	}

	void inputQ() {
		char[] arr = new char[16];
		System.out.println("문제 입력");
		qEaxm = sc.next();
		qinfoList.add(qEaxm);
		System.out.println("보기 입력");
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + "번째 글자 입력");
			arr[i] = sc.next().charAt(0);
		}
		qSentence = new String(arr);

		qList.add(qSentence);
		System.out.println("답 입력");
		qAns = sc.next();
		ansList.add(qAns);
	}

	void removeQ(int num) {
		qinfoList.remove(num);
		qList.remove(num);
		ansList.remove(num);
	}
}
