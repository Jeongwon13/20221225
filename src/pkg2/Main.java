package pkg2;
/*
 * 1. try~catch {}
 * 2. try~catch~finally {}
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("1. try ~ catch{} 예제");
		try {
			//int result = 5 / 0;
			int[] arr = {10,20,30};
			System.out.println("1. arr[0]:" + arr[0]);
			System.out.println("2. arr[1]:" + arr[1]);
			System.out.println("3. arr[2]:" + arr[2]);
			System.out.println("4. arr[3]:" + arr[3]); //실행오류 예상 지점
			
			//오류가 발생하지 않았을 경우 실행할 수 있는 명령문 작성
			//System.out.println("실행 오류가 발생하지 않았습니다.");
			//System.out.println("나눗셈 계산 결과는 " + result);
		}catch(ArithmeticException e) {
//			System.out.println("try {} 내부에서 산술 예외가 발생!");
		//	getMessage() 메소드의 기능: 실행 오류 내용을 반환(읽기)
			String msg = e.getMessage();
			System.out.println(msg);
			
			//printStackTrace() 메소드 사용하면 아주 자세한 오류 내용과
			//메소드 호출 순서도 알 수 있습니다.
			// - 다른 메소드 호출
			//그리고 어느 명령어에서 오류가 발생했는지도 출력(자바 소스 파일 이름 + 명령어의 줄 번호)
			e.printStackTrace();
		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			//개발자가 배열의 방 번호를 잘못 사용한 경우 발생하는 오류
			System.out.println("배열을 사용하다가 실행 오류가 발생");
			e.printStackTrace();
		}
		
		System.out.println("catch{} 벗어난 후 실행");
		
		/*
		 * Integer Wrapper 클래스가 갖고 있는 parseInt() 메소드 호출
		 *  - "" 안에 있는 정수 값을 실제 정수로 변환
		 */
		int value = 0;
		
		try {
			value = Integer.parseInt("3.14159");
		}catch(NumberFormatException e) {
			System.out.println("문자열 안에 있는 정수를 변환하는데 오류가 발생");
			e.printStackTrace();
		}finally {
			System.out.println("예외 상관 없이 무조건 실행");
		}
		/*
		 * Scanner 클래스를 사용하는 경우
		 *  - close() 메소드를 호출하는 명령어의 작성 위치
		 *   - 일반적으로 더 이상 키보드를 사용하지 않은 경우에 사용
		 *    - 오류와 상관없이 무조건 실행
		 *     - finally 블럭에 작성 
		 */
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("당신의 이름을 입력하세요:");
		String input = sc.nextLine();
		System.out.println("당신의 이름은 "+input);
		/*
		 * try~catch~finally{} 작성하기
		 * -> 사용자에게 나이를 문자열 형식으로 정수 입력 받기
		 * -> Integer.parseInt() 메소드 사용해서
		 * 	  사용자가 정수가 아닌 값을 입력한 경우, 실행 오류 만들고
		 * 	  오류 메시지 출력하기.
		 */
		int age = 0;
		try {
			System.out.print("당신의 나이를 입력하세요:");
			String input2 = sc.nextLine();
			age = Integer.parseInt(input2);
			System.out.println("사용자가 입력한 나이는 "+ age);
		}catch(NumberFormatException e) {
			System.out.println("사용자가 문자를 입력했습니다.");
			e.printStackTrace();
		}finally {
			/*
			 * if 조건문을 사용해서 현재 Scanner 클래스의 객체를 가리키고 있는 경우에만 힙 메모리에서 제거합니다.
			 *  - 만약 null의 값을 갖고 있는 경우, 거짓 주소이므로 close() 메소드를 호출하지 않습니다.
			 *   - 만약 null의 값을 갖고 있는 경우 close() 메소드를 호출하면 NullPointerException 예외가 발생~ 
			 */
			if(sc != null) {
				sc.close();
				System.out.println("정상적으로 close() 메소드를 실행");
			}
		}

		
	}
}