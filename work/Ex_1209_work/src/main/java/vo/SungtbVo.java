package vo;

public class SungtbVo {
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	private int sub_total;
	private double sug_avg;
	private int rank;
	
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getSub_total() {
		return sub_total;
	}
	public void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}
	public double getSug_avg() {
		return sug_avg;
	}
	public void setSug_avg(double sug_avg) {
		this.sug_avg = sug_avg;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	
}
