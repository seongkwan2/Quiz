package quiz;

import java.util.Scanner;

public class MainService {
	Scanner scan = new Scanner(System.in);
	int num, age = 0;
	String name = null;
	MemberDTO dto = null;
	MemberService ms = new MemberService();


	public void case1() {	//입력기능
		System.out.println("이름");
		name = scan.next();
		//파일이 존재하면 true, 아니면 false
		if(ms.checkMember(name)) {
			System.out.println("존재하는 파일입니다.");
		}
		System.out.println("나이");
		age = scan.nextInt();

		dto = new MemberDTO();
		dto.setName(name); dto.setAge(age);

		ms.save(dto);
	}
	
	public void case2() {
		System.out.println("이름");
		name = scan.next();
		//파일이 존재하면 true, 아니면 false
		if(ms.checkMember(name) == false) {
			System.out.println("해당 사용자는 존재하지 않습니다.");
		}
		dto = ms.getMember(name);
		System.out.println("이름 : "+dto.getName());
		System.out.println("나이 : "+dto.getAge());
	}
}
