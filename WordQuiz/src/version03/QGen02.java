package version03;

import java.util.ArrayList;
import java.util.Scanner;

public class QGen02 extends QGen {
	public QGen02() {
		super();

		this.qinfoList.removeAll(qinfoList);
		this.qList.removeAll(qList);
		this.ansList.removeAll(ansList);

		this.qinfoList.add("음식");
		this.qinfoList.add("동물");

		this.ansList.add("곱창");
		this.ansList.add("치타");

		this.qList.add("육두쌍칸짜까치곱창동겹파자뽕면발");
		this.qList.add("코염슴치호끼수지고랑원린가릴타문");

		setaCnt(0);
		setrCnt(0);

		setCnt(1);
	}

	private int rCnt;
	private int aCnt;

	public int getrCnt() {
		return rCnt;
	}

	public void setrCnt(int rCnt) {
		this.rCnt = rCnt;
	}

	public int getaCnt() {
		return aCnt;
	}

	public void setaCnt(int aCnt) {
		this.aCnt = aCnt;
	}

	Scanner sc = new Scanner(System.in);
	String qSentence, qAns, qEaxm;

	ArrayList<String> qinfoList = new ArrayList<String>();
	ArrayList<String> qList = new ArrayList<String>();
	ArrayList<String> ansList = new ArrayList<String>();

	@Override
	char[] qRandom(char[] arrRandom) {
		int[] arr = new int[getNumofEaxm()];
		int seed;
		char temp;

		for (int i = 0; i < arr.length; i++) {
			seed = (int) (Math.random() * (getNumofEaxm() - 1)) + 1;
			temp = arrRandom[i];
			arrRandom[i] = arrRandom[seed];
			arrRandom[seed] = temp;
		}
		return arrRandom;
	}

	@Override
	char[] qgen(String str) {
		char[] arr = new char[getNumofEaxm()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		return arr;
	}

	@Override
	void inputQ(String qExam, String qSentence, String qAns) {
		qinfoList.add(qExam);
		qList.add(qSentence);
		ansList.add(qAns);
	}

	@Override
	void removeQ(int num) {
		qinfoList.remove(num);
		qList.remove(num);
		ansList.remove(num);
	}
}
