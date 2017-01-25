package version03;

import java.io.Serializable;

public class Member implements Serializable {
	//static int memCode = 0;
	private String memId;
	private int rCnt;
	private int aCnt;
	private int score, percent, rank;

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
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	Member() {
	//	memCode++;
		setScore(0);
		setaCnt(0);
		setrCnt(0);
	}
	
}
