package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num, age = 0;
		String name = null;
		MemberDTO dto = null;
		MemberService ms = new MemberService();
		MainService Mains = new MainService();

		while (true) {
			try {
				System.out.println("1.저장");
				System.out.println("2.검색");
				System.out.println("3.종료");
				System.out.print(">>>: ");

				num = scan.nextInt();
				switch (num) {
				case 1:
					Mains.case1();
					break;
				case 2:
					Mains.case2();
					break;
				case 3:
					System.out.println("프로그램 종료");
					return;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					scan.nextLine(); // 입력 버퍼 비우기
					continue;
				}
			} catch (InputMismatchException e) {
				System.err.println("숫자만 입력해주세요.");
				scan.nextLine(); // 입력 버퍼 비우기
				continue;
			}
		}
	}
}
