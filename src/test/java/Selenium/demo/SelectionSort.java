package Selenium.demo;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num= {10,48,2,5,9,4,78,67,53,22};
		int[] sort=sorting(num);
		System.out.println(Arrays.toString(sort));

	}
	public static int[] sorting(int[] ar) {
		int l=ar.length;
		for(int i=0;i<l;i++) {
			for(int j=i+1;j<l;j++) {
				if(ar[i]<ar[j]) {
					int temp=ar[i];
					ar[i]=ar[j];
					ar[j]=temp;
				}
			}
		}
		return ar;
	}

}
