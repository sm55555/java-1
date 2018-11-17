import java.util.Scanner;
public class QuickSort {
	static void swap(int[] arr,int idx1,int idx2) {
		int tmp=arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=tmp;
	}
	static void quickSort(int[] arr,int left,int right) {
		int ptrL=left;
		int ptrR=right;
		int pivot=arr[(ptrL+ptrR)/2];
		
		do {
			while(arr[ptrL]<pivot) ptrL++;
			while(arr[ptrR]>pivot) ptrR--;
			if(ptrL<=ptrR)
				swap(arr,ptrL++,ptrR--);
		}while(ptrL<=ptrR);
		
		if(left<ptrR) quickSort(arr,left,ptrR);
		if(ptrL<right) quickSort(arr,ptrL,right);
		
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("퀵 정렬");
		System.out.println("요소수 >>");
		int n=input.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=input.nextInt();
		}
		System.out.println("정렬 전");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
		
		quickSort(arr,0,n-1);
		System.out.println("정렬 후");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
}
