import java.util.Scanner;

public class SelectionSort {
	static void swap(int[] a,int idx1,int idx2) {
		int t=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=t;
	}
	static void selectionSort(int []arr,int n) {
		for(int i=0;i<n-1;i++) {
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[min])
					min=j;
			}
			swap(arr,i,min);
		}
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("선택 정렬");
		System.out.println("요소 개수>>");
		int num=input.nextInt();
		int[] arr=new int[num];
		for(int i=0;i<num;i++) {
			arr[i]=input.nextInt();
		}
		System.out.println("오름차순 정렬 전");
		System.out.println("==================");
		for(int i=0;i<num;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
		selectionSort(arr,num);
		System.out.println("==================");
		System.out.println("오름차순 정렬 후");
		for(int i=0;i<num;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
}
