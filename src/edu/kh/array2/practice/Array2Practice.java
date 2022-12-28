package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice {
	public void practice1() {
		//3행 3열짜리 문자열 배열을 선언 및 할당하고
		//인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.

		//[실행 화면]
		//(0, 0)(0, 1)(0, 2)
		//(1, 0)(1, 1)(1, 2)
		//(2, 0)(2, 1)(2, 2)
		
		int[][] arr = new int[3][3];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print("(" + i + ", " + j + ")");
			}
			System.out.println();
		}
	}
	
	public void practice2() {
		//4행 4열짜리 정수형 배열을 선언 및 할당하고
		//1) 1 ~ 16까지 값을 차례대로 저장하세요.
		//2) 저장된 값들을 차례대로 출력하세요.

		//[실행 화면]
		//1 2 3 4
		//5 6 7 8
		//9 10 11 12
		//13 14 15 16
		
		int[][] arr = new int[4][4];
		int num = 1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num;
				num += 1;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public void practice3() {
		//4행 4열짜리 정수형 배열을 선언 및 할당하고
		//1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
		//2) 저장된 값들을 차례대로 출력하세요.

		//[실행 화면]
		//16 15 14 13
		//12 11 10 9
		//8 7 6 5
		//4 3 2 1
		
		int[][] arr = new int[4][4];
		int num = 16;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num;
				num -= 1;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		//4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
		//아래의 내용처럼 처리하세요.
		
		//		0열 	   1열	 2열    3열
		//0행 	값 	   값 	 값 	  0행 값들의 합
		//1행 	값 	   값	 값    1행 값들의 합
		//2행 	값 	   값 	 값 	  2행 값들의 합
		//3행 0열 값들의 합 1열 값들의 합 2열 값들의 합 총합

		//[실행 화면]
		//9 3 7 19
		//3 6 9 18
		//6 10 10 26
		//18 19 26 63
		
		int[][] arr = new int[4][4];
		
		int row = arr.length - 1;
		int col = arr[0].length -1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(i != row && j != col) {
					arr[i][j] = (int)(Math.random() * 10 + 1);
					
					arr[i][col] += arr[i][j]; 
					arr[row][j] += arr[i][j]; 
					arr[row][col] += arr[i][j]; 
					
				}
				System.out.print(arr[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	public void practice5() {
		//2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
		//“반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게 하세요.
		//크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
		//(char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자)

		//[실행 화면]
		//행 크기 : 5
		//열 크기 : 4
		//T P M B
		//U I H S
		//Q M B H
		//H B I X
		//G F X I
		
		Scanner sc = new Scanner(System.in);
		
		int rowNum;
		int colNum;
		int[][] arr;
		
		while (true) {
			System.out.print("행 크기 : ");
			rowNum = sc.nextInt();
			
			if (rowNum < 1 || rowNum > 10)
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			else {
				while (true) {
					System.out.print("열 크기 : ");
					colNum = sc.nextInt();
					
					if (colNum < 0 || colNum > 10)
						System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
					else {
						arr = new int[rowNum][colNum];
						
						for (int row = 0; row < arr.length; row++) {
							for (int col = 0; col < arr[row].length; col++) {
								arr[row][col] = (int)(Math.random() * 26 + 65);
								
								System.out.print((char)arr[row][col] + " ");
							}
							System.out.println();
						}
						
						break;
					}
				}
				
				break;
			}
		}
		
		
		
		
	}
	
	public void practice6() {
		// 사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
		// 문자형 가변 배열을 선언 및 할당하세요.
		// 그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.

		//[실행 화면]
		//행의 크기 : 4
		//0열의 크기 : 2
		//1열의 크기 : 6
		//2열의 크기 : 3
		//3열의 크기 : 5
		//a b
		//c d e f g h
		//i j k
		//l m n o p
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행의 크기 : ");
		int rowNum = sc.nextInt();
		
		
		char[][] arr = new char[rowNum][];
		
		
		for(int i = 0; i < arr.length; i++) {
			
			System.out.print(i + "열의 크기 : ");
			int colNum = sc.nextInt();
			arr[i] = new char[colNum]; 
		}
		
		char ch = 'a';
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				
				
			}
		}
	}
	
	public void practice7() {
		//1차원 문자열 배열에 학생 이름 초기화되어 있다.
		//3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
		//학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
		//(첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
		//String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
		//"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		//[실행 화면]
		//== 1분단 ==
		//강건강 남나나
		//도대담 류라라
		//문미미 박보배
		//== 2분단 ==
		//송성실 윤예의
		//진재주 차천축
		//피풍표 홍하하
	}
	
	public void practice8() {
		//위 문제에서 자리 배치한 것을 가지고 학생 이름을 검색하여
		//해당 학생이 어느 자리에 앉았는지 출력하세요.

		//[실행 화면]
		//== 1분단 ==
		//강건강 남나나
		//도대담 류라라
		//문미미 박보배
		//== 2분단 ==
		//송성실 윤예의
		//진재주 차천축
		//피풍표 홍하하
		//============================
		//검색할 학생 이름을 입력하세요 : 차천축
		//검색하신 차천축 학생은 2분단 2번째 줄 오른쪽에 있습니다.
	}
	
	public void practice9() {
		//String 2차원 배열 6행 6열을 만들고 행의 맨 위와 제일 앞 열은 각 인덱스를 저장하세요.
		//그리고 사용자에게 행과 열을 입력 받아 해당 좌표의 값을 'X'로 변환해 2차원 배열을 출력하세요.

		//[실행 화면]
		//행 인덱스 입력 : 4
		//열 인덱스 입력 : 2
		//  0 1 2 3 4
		//0
		//1
		//2
		//3
		//4     X
	}
	
	public void practice10() {
		//실습문제9와 내용은 같으나 행 입력 시 99가 입력되지 않으면 무한 반복이 되도록 구현하세요.

		//[실행 화면]
		//행 인덱스 입력 : 2 				행 인덱스 입력 : 3
		//열 인덱스 입력 : 2 				열 인덱스 입력 : 1
		//  0 1 2 3 4					   0 1 2 3 4
		//0								 0
		//1 							 1
		//2		X				 		 2	     X
		//3 							 3     X
		//4 							 4

		//								행 인덱스 입력 >> 99
		//								프로그램 종료
	}
	
	
}
