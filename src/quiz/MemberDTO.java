package quiz;

import java.io.Serializable;

public class MemberDTO implements Serializable {//DTO파일에 직렬화를 하기위한 코드 작성

	private String name;
	private int age;
	
	public MemberDTO() {} //기본생성자

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
	
	
	
}
