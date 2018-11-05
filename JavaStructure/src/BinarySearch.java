import java.util.Scanner;
public class BinarySearch {
	static int binSearch(int[] arr, int n,int key) {
		int low=0;
		int high=n-1;
		int mid;
		while(low<=high) {
			mid=(low+high)/2;
			if(arr[mid]==key)
				return mid;
			else if(arr[mid]>key) {
				high=mid-1;
			}else
				low=mid+1;
		}
		
		return -1;
	}
	static void swap(int[] arr,int idx1,int idx2) {
		int t=arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=t;
	}
	static void bubbleSort(int[] arr,int n) {
		for(int i=0;i<n-1;i++) {
			for(int j=n-1;j>i;j--) {
				if(arr[j-1]>arr[j])
					swap(arr,j-1,j);
			}
		}
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("배열에 크기를 입력해주세요.>>");
		int n=input.nextInt();
		int[] arr=new int[n];
		System.out.println("배열에 요소들을 입력해주세요..>>");
		for(int i=0;i<n;i++) {
			arr[i]=input.nextInt();
		}
		//버블 정렬
		bubbleSort(arr,n);
		System.out.println("찾고자 하는 숫자를 입력해주세요>>");
		int key=input.nextInt();
		int result=binSearch(arr,n,key);
		System.out.println("찾고자 하는 숫자는 "+(result+1)+" 인덱스에 있습니다..");
	}
}
