import java.util.Scanner;
public class ShellSort {
	static void shellSort(int[] arr,int n) {
		int h;
		for(h=1;h<n/9;h=h*3+1);	//h의 초깃값 구하기
		
		for(;h>0;h/=3) {
			for(int i=h;i<n;i++) {
				int j;
				int tmp=arr[i];
				for(j=i-h;j>=0&&arr[j]>tmp;j-=h)
					arr[j+h]=arr[j];
				arr[j+h]=tmp;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("셸 정렬(버전 2");
		System.out.println("요소 수>>");
		int n=input.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=input.nextInt();
		}

		System.out.println("정렬 전");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
		
		shellSort(arr,n);
		System.out.println("오름차순으로 정렬");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}
}
