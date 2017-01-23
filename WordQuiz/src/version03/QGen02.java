package version03;

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

		
	}

	

}
