package version03;

public class QGen {
	String qSentence, qAns;
	
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
		qNum++;
		//System.out.println("qgenerator     "+Arrays.toString(arr));
		return arr;
	}

	char[] qRandom(char[] arrRandom) {
		int[] arr = new int[16];
		int seed;
		char temp;
		
		for (int i = 0; i < arr.length; i++) {
			seed = (int) (Math.random() * 15)+1;
			//System.out.println(seed);
			temp = arrRandom[i];
			arrRandom[i] = arrRandom[seed];
			arrRandom[seed] = temp;
		}
		//System.out.println("qrandom     "+Arrays.toString(arrRandom));
		return arrRandom;
	}
}
