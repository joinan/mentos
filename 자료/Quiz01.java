package com.test.variable_exam;

import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] ar) {

		Scanner scan = new Scanner(System.in);
		int menu;
		int flag = 0;
		String ans;
		System.out.println("����������������������������������������");
		System.out.println("��      M E N U     ��");
		System.out.println("�� 1.���ӽ���       	   ��");
		System.out.println("�� 2.��������     	   ��");
		System.out.println("����������������������������������������");
		menu = scan.nextInt();

		if (menu == 1) {
			System.out.println("1���� ��");
			System.out.println("����������������");
			System.out.println("������������");
			System.out.println("����������������");
			System.out.println("����������������");

			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("���켺")){
					flag++;
				}
				else{
					System.out.println("Ʋ�Ƚ��ϴ�.");
				}
			}
			
			flag = 0;
			System.out.println("2���� ��");
			System.out.println("����������������");
			System.out.println("������������");
			System.out.println("����������������");
			System.out.println("����������������");
			
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("���켺")){
					flag++;
				}
				else{
					System.out.println("Ʋ�Ƚ��ϴ�.");
				}
			}
			flag = 0;
			
			System.out.println("3���� ��");
			System.out.println("����������������");
			System.out.println("������������");
			System.out.println("����������������");
			System.out.println("����������������");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("���켺")){
					flag++;
				}
				else{
					System.out.println("Ʋ�Ƚ��ϴ�.");
				}
			}
			flag = 0;
			System.out.println("4���� ��");
			System.out.println("����������������");
			System.out.println("������������");
			System.out.println("����������������");
			System.out.println("����������������");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("���켺")){
					flag++;
				}
				else{
					System.out.println("Ʋ�Ƚ��ϴ�.");
				}
			}
			flag = 0;
			System.out.println("5���� ��");
			System.out.println("����������������");
			System.out.println("������������");
			System.out.println("����������������");
			System.out.println("����������������");
			while (flag < 1) {
				ans = scan.next();
				if (ans.equals("���켺")){
					flag++;
				}
				else{
					System.out.println("Ʋ�Ƚ��ϴ�.");
				}
			}
			System.out.println("�����մϴ�. ������ ���� �մϴ�.");
		} else if (menu == 2) {
			System.out.println("������ �����մϴ�.");
		} else {
			System.out.println("�߸������ϼ̽��ϴ�.");
		}
	}

}
