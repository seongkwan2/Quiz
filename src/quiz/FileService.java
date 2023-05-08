package quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileService implements CommonPath {	//경로를 편하게 쓰기위해 상속
	
	private File path;		//File 이름을 path로 받기 위함
	
	//입력기능
	private FileOutputStream fos;		//입력도구
	private BufferedOutputStream bos;	//저장소
	private ObjectOutputStream oos;		//파일전송

	
	//불러오기 기능
	private FileInputStream fis;		//불러오기도구
	private BufferedInputStream bis;	//저장소
	private ObjectInputStream ois;		//파일전송
	

	
	
	//입력하는 메소드
	public void outPutData(MemberDTO dto) {
		
		try {
			
		fos = new FileOutputStream(path);
		bos = new BufferedOutputStream(fos);
		oos = new ObjectOutputStream(bos);
		oos.writeObject(dto); //입력한 내용을 오브젝트 타입으로 씀(직렬화)
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos != null) oos.close();
				if(bos != null) bos.close();
				if(fos != null) fos.close();	//입력이 다 되었다면 닫아준다.
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//파일 읽는 메소드
	public MemberDTO readData(String name) {//DTO의 name을 확인해서 읽음(어떤 파일을 읽을것인지)
		
		MemberDTO dto = null; //깨끗하게 초기화
		
		try {
		fis = new FileInputStream(path);
		bis = new BufferedInputStream(fis);
		ois = new ObjectInputStream(bis);
		dto = (MemberDTO)ois.readObject();	//ois에 있는 오브젝트 타입을 MemberDTO타입으로 맞춤
		
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(ois != null) ois.close();
				if(bis != null) bis.close();
				if(fis != null) fis.close();	//불러오기가 다 되었다면 닫아준다.
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;	//꺼낸값을 사용
		
	}
	
	
	//중복된 값인지 검사하는 메소드
	public boolean checkUser(String name) {	//이름이 중복되는값인지 확인
		path = new File(PATH + name + ".txt");
		return path.exists();			//exists() 메서드는 해당 파일 또는 디렉토리가 실제로 존재하는지 
										//여부를 반환하는 File 클래스의 메소드.
	}
	
	
	
}














