package quiz;

public class MemberService {
	private FileService fs;
	
	public MemberService() {	//생성자
		fs = new FileService(); //초기화 (FileService를 사용)
	}
	
	
	//저장하는 메서드
	public void save(MemberDTO dto) {
		fs.outPutData(dto); 	//save를 동작시키면
								//FileSerive안의 outPutData메서드 동작
	}
	
	public MemberDTO getMember(String name) {
		return fs.readData(name);	//getMember 실행시
									//해당 이름의 파일을 불러와서 읽음
	}
	
	public boolean checkMember(String name) { //파일이 존재하는지의 여부 true/false 반환
		return fs.checkUser(name);
	}
}
