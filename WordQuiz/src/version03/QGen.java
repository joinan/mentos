package version03;

import java.util.ArrayList;
import java.util.Scanner; 

public class QGen {

	private int cnt, numofEaxm;
		
	public int getNumofEaxm() {
		return numofEaxm;
	}

	public void setNumofEaxm(int numofEaxm) {
		this.numofEaxm = numofEaxm;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	Scanner sc = new Scanner(System.in);
	String qSentence, qAns, qEaxm;
	
	ArrayList<String> qinfoList = new ArrayList<String>();
	ArrayList<String> qList = new ArrayList<String>();
	ArrayList<String> ansList = new ArrayList<String>();

	public QGen() {
		qinfoList.add("음식");
		qinfoList.add("우리반 친구");
		qinfoList.add("배우");
		qinfoList.add("동물");

		ansList.add("곱창");
		ansList.add("이명우");
		ansList.add("공유");
		ansList.add("치타");

		qList.add("육두쌍칸짜까치곱창동겹파자뽕면발");
		qList.add("지원주명우수동환박성연인진정이롱");
		qList.add("건제검박우빈공부유잔상든훤이만호");
		qList.add("코염슴치호끼수지고랑원린가릴타문");
		setCnt(1);
		numofEaxm=16;
	}

	char[] qRandom(char[] arrRandom) {
		int[] arr = new int[numofEaxm];
		int seed;
		char temp;

		for (int i = 0; i < arr.length; i++) {
			seed = (int) (Math.random() * (numofEaxm-1)) + 1;
			// System.out.println(seed);
			temp = arrRandom[i];
			arrRandom[i] = arrRandom[seed];
			arrRandom[seed] = temp;
		}
		// System.out.println("qrandom "+Arrays.toString(arrRandom));
		return arrRandom;
	}

	char[] qgen(String str) {
		char[] arr = new char[numofEaxm];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		// System.out.println("qgenerator "+Arrays.toString(arr));
		return arr;
	}

	void inputQ(String qExam, String qSentence, String qAns) {
		qinfoList.add(qExam);
		qList.add(qSentence);
		ansList.add(qAns);
	}

	void removeQ(int num) {
		qinfoList.remove(num);
		qList.remove(num);
		ansList.remove(num);
	}
}
