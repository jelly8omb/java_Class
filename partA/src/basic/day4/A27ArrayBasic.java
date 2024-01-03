package basic.day4;

import java.util.Arrays;
import java.util.Scanner;

//배열 기본
public class A27ArrayBasic {
	// 괄호의 종류 () : 메서드, {} : 블럭(영역) 지정, [] : 배열 정의
	public static void main(String[] args) {
		
		//int age=23;  과 같은 변수선언 1개당 1개의 메모리 할당.
		
		//배열은 여러개의 데이터를 저장할 수 있는 변수.  저장할 데이터의 형식/이름/데이터의 개수(할당 받는 메모리 크기)를 선언해야 함.
		// 		배열의 여러 데이터 중 특정 위치를 표현하는 것은 index
		int[] arr1 = {34,56,78,89,65};		// 선언방법1. 저장할 값 초기화 //인덱스는 0부터 4
						
		
		int[] arr2 = new int[10];		// 선언방법2. 초기값은 기본값 0 , 정수 10개 (40바이트 할당), 인덱스 0~9
		
		//배열의 주요 속성 : length 는 배열의 길이(개수)를 갖습니다.

		System.out.println("배열의 크기(길이) 구하는 속성 length 테스트");
		System.out.println("arr1 배열의 크기 : " + arr1.length);		// 5
		System.out.println("arr2 배열의 크기 : " + arr2.length);		// 10



		System.out.println("==인덱스 직접 지정해서 배열 요소값 출력하기 ==");
		System.out.println("i=0, arr1[0]=" + arr1[0]);		// [] 기호안에 인덱스 정수값 작성하기
		System.out.println("i=1, arr1[1]=" + arr1[1]);
		System.out.println("i=2, arr1[2]=" + arr1[2]);
		System.out.println("i=3, arr1[3]=" + arr1[3]);
		System.out.println("i=4, arr1[3]=" + arr1[4]);

		// 초기값이 없는 배열은 기본 0
		System.out.println("i=0, arr2[0]=" + arr2[0]);
		System.out.println("i=1, arr2[1]=" + arr2[1]);
		System.out.println("i=2, arr2[2]=" + arr2[2]);
		System.out.println("i=3, arr2[3]=" + arr2[3]);
		System.out.println("i=4, arr2[3]=" + arr2[4]);
		
		//배열에 저장된 값은 성적,포인트,이름 등등 같은 의미를 갖는 데이터들이며 따라서 처리 해야할 동작도 같습니다. => 반복문 필수
		System.out.println("\n~~~~~1. 반복문으로 배열 요소값 출력하기 ~~~~~");
		for(int i = 0; i < arr1.length; i++){
			System.out.println("i="+i +", arr["+i+"] = "+ arr1[i]);
		}

		for(int i=0;i<arr2.length;i++){
			System.out.println("i="+i +", arr["+i+"] = "+ arr2[i]);
		}
		System.out.println("\n~~~~~2. arr1 배열의 합계 구하기 ~~~~~");
		int sum = 0; int count = 0;
		for(int i=0;i<arr1.length;i++){
			sum += arr1[i];
			if(arr1[i]>=70) count++;
		}
		System.out.println("arr1 배열의 값들을 더하면 = "+ sum + " 입니다.");
		System.out.println("\n~~~~~3. arr1 배열의 70이상 값 개수 구하기 ~~~~");
		System.out.println("70개 이상의 값 개수 = "+ count);
		
		
		System.out.println("\n~~~~~4.arr2배열에 키보드 입력으로 값 저장하기~~~~~");
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<arr2.length;i++){
			System.out.println(i+ " 번째 값 입력 >> ");
			arr2[i] = sc.nextInt();
			
		}

		System.out.println("arr2 출력");
		System.out.println(arr2);
		printArray(arr2); // 배열 요소의 값을 출력하는 메서드

		System.out.println("arr1 출력");
		System.out.println(arr1);
		printArray(arr1); // arr1, arr2는 배열의 이름은 배열의 시작주소.
						  // 메서드가 실행될 때 배열의 시작주소를 메서드의 인자로 전달합니다.
						  // 메모리에 저장되는 데이터는 주소를 갖는다.
				
		
		
	}
	public static void printArray(int[] array){ // 전달받은 배열주소로 데이터를 가져오기 합니다.
		for(int i=0;i<array.length;i++){
			System.out.println("i="+i +", array["+i+"] = " + array[i]);

		}
	}
}
