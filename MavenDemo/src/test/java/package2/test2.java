package package2;

import java.util.Scanner;

public class test2 {
	public static int arr[] = {0,0,0,0};
	
	public static void main(String[] args) {	
		for(int i=0;i<5;i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter integer:");
			int input = sc.nextInt();
			addElementsToArray(input);
		}
	}

	private static void addElementsToArray(int input) {
		if(checkElementExistsInArray(input)) {
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==input) {
					for(int j = i;j>0;j--) {
						arr[j]=arr[j-1];
					}
					arr[0]=input;			
				}
			}
		}else {
			for(int i=arr.length-1;i>0;i--) {
				arr[i]=arr[i-1];
			}
			arr[0]=input;
		}
		System.out.println("Array content after insertion: ");
		for(int a: arr) {
			System.out.print(a+" ");
		}
	}

	private static boolean checkElementExistsInArray(int input) {
		for(int a: arr) {
			if(a==input) {
				return true;
			}
		}
		return false;
	}	

}