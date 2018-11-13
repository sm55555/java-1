import java.util.Scanner;
public class BubbleSort {
	static void swap(int[] a,int idx1,int idx2) {
		int t=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=t;
	}
	static void bubbleSort(int[] a,int n) {
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(a[j]>a[j+1])
					swap(a,j,j+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("버블 정렬");
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
		bubbleSort(arr,num);
		System.out.println("==================");
		System.out.println("오름차순 정렬 후");
		for(int i=0;i<num;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
}
