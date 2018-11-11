
public class Stack {
	private int max;
	private int ptr;
	private int[] stk;
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	public Stack(int capacity) {
		ptr=0;
		max=capacity;
		try {
			stk=new int[max];//스택 본체용 배열을 생성
		}catch(OutOfMemoryError e) {//생성할 수 없음
			max=0;
		}
	}
	//스택에 데이터를 푸시하는 메서드 , 스택이 가득 차서 푸시할 수 없는 경우 OverflowIntStackException을 던진다.
	public int push(int x) throws OverflowIntStackException {
		if(ptr>=max)
			throw new OverflowIntStackException();
		return stk[ptr++]=x;
	}
	//스택의 꼭대기에서 데이터를 제거하고 그 값을 반환하는 메서드입니다.
	//스택이 비어 있어 팝을 할 수 없는 경우 EmptyIntStackException을 던집니다.
	public int pop() throws EmptyIntStackException{
		if(ptr<=0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	//스택에 꼭대기에 데이터를 확인하는 메서드
	public int peek() throws EmptyIntStackException{
		if(ptr<=0)
			throw new EmptyIntStackException();
		return stk[ptr-1];
	}
	//스택에서 x를 찾아 인덱스(없으면 -1)를 반환
	public int indexOf(int x) {
		for(int i=ptr-1;i>=0;i--) {
			if(stk[i]==x)
				return i;
		}
		return -1;
	}
	//스택을 비움
	public void clear() {
		ptr=0;
	}
	//스택의 용량을 반환
	public int capacity() {
		return max;
	}
	//스택에 쌓여 있는 데이터 수를 반환
	public int size() {
		return ptr;
	}
	//스택이 비어 있는지 확인
	public boolean isEmpty() {
		return ptr<=0;
	}
	//스택이 꽉 찼는지 확인
	public boolean isFull() {
		return ptr>=max;
	}
	//스택 안의 모든 데이터를 bottom 부터 top 순서로 출력
	public void dump() {
		if(ptr<=0)
			System.out.println("스택이 비어있습니다.");
		else {
			for(int i=0;i<ptr;i++) {
				System.out.print(stk[i]+" ");
			}
			System.out.println();
		}
	}
}

