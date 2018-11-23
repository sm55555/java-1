package BOJ;
import java.util.Scanner;
class Stk{
	private int[] arr;
	private int max;
	private int ptr;
	public class EmptyIntStkException extends RuntimeException{
		public EmptyIntStkException() {}
	}
	public Stk(int num) {//배열 크기 할당
		ptr=0;
		try {
			arr=new int[num];
			int i=num;
			for(;ptr<num;ptr++) {
				arr[ptr]=i--;
			}
		}catch(OutOfMemoryError e) {
			max=0;
		}
	}
	//비어있는지 확인
	public boolean isEmpty() {
		return ptr<=0;
	}
	//초기화
	public void clear() {
		ptr=0;
	}
	//현재 배열 사이즈
	public int size() {
		return ptr;
	}
	//꼭대기 있는 숫자 팝
	public int pop() throws EmptyIntStkException{
		if(ptr<0)
			throw new EmptyIntStkException();
		else {
			return arr[--ptr];
		}
	}
	//꼭대기 숫자 맨 밑으로 이동
	public void update() {
		if(ptr>0) {
			int tmp=arr[ptr-1];
			for(int i=ptr-1;i>=0;i--) {
				arr[i+1]=arr[i];
			}
			arr[0]=tmp;
		}
	}
}
public class BOJ_2161 extends Stk{
	
	public BOJ_2161(int num) {
		super(num);
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		Stk p=new Stk(n);
		do {
			System.out.print(p.pop()+" ");//꼭대기 숫자 팝
			p.update();	//꼭대기 숫자 아래로 이동
		}while(p.size()!=0);
	}
}
