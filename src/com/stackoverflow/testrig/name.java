package com.stackoverflow.testrig;

public class name {
	public static void main(String[] args) {
		String str1="(((())))))";
		int count=0;
		int temp=0;
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)=='('){
				count++;
				
			}
		}
			
			for(int j=0;j<str1.length();j++) {
				if(str1.charAt(j)==')') {
					temp++;
				}
			}
			
			
		
		System.out.println(count);
		System.out.println(temp);
		if(temp<count) {
			System.out.println("total no of complete brackets"+temp);
		}
		else {
			System.out.println(count);
		}
	}

}
