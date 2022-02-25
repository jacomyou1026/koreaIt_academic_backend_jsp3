package vo;


public class PersonVO {
	//VO(ValueObject) : DB에서 얻어오고자 하는 정보들을 
	//묶어서 한번에 관리할 수 있도록 하기 위한 클래스
	private String name;
	private int age;
	private String tel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}


