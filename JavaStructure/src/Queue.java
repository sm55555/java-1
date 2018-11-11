
public class Queue {
	private int max;	//큐 용량
	private int num;	//현재 데이터 수
	private int[] que;	//큐 본체
	private int front;	//첫번째 요소 커서
	private int rear;	//마지막 요소 커서
	//실행 시 예외 : 큐가 비어 있음
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	//실행 시 예외: 큐가 가득참
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {}
	}
	public Queue(int capacity) {
		num=front=rear=0;
		max=capacity;
		try {
			que=new int[max];		//큐 본체용 배열을 생성
		}catch(OutOfMemoryError e) {	//생성할 수 없음
			max=0;
		}
	}
	
	//큐에 데이터를 넣는 메서드
	// 인큐에 성공하면 인큐한 값을 그대로 반환합니다.
	public int enque(int x) throws OverflowIntQueueException{
		if(num>=max)	//큐가 꽉차있는지 확인
			throw new OverflowIntQueueException();
		que[rear++]=x;	
		num++;
		if(rear==max)	//큐가 꽉찼다면 rear를 0으로 초기화
			rear=0;
		return x;
	}
	//큐에 데이터를 꺼낸다.
	public int deque() throws EmptyIntQueueException{
		if(num<=0)
			throw new EmptyIntQueueException();
		int x=que[front++];
		num--;
		if(front==max)
			front=0;
		return x;
	}
	//큐에서 데이터를 피크
	public int peek() throws EmptyIntQueueException{
		if(num<=0)
			throw new EmptyIntQueueException();
		return que[front];
	}
	//큐에서 x를 검색하여 인덱스 반환( 찾지 못하면 -1)
	public int indexOf(int x) {
		for(int i=0;i<num;i++) {
			int idx=(i+front)%max;		//원형 큐로 구현했으므로 i에 front를 더해주고 max나머지 값에 인덱스를 확인한다.
			if(que[idx]==x)
				return idx;
		}
		return -1;
	}
	//큐를 비움
	public void clear() {
		num=front=rear=0;
	}
	//큐의 용량을 반환
	public int capacity() {
		return max;
	}
	//큐에 쌓여 있는 데이터 수를 반환
	public int size() {
		return num;
	}
	//큐에 비어있는지 체크
	public boolean isEmpty() {
		return num<=0;
	}
	//큐가 가득차있는지 체크
	public boolean isFull() {
		return num>=max;
	}
	//큐 안의 모든 데이터를 front에서 rear 순으로 출력
	public void dump() {
		if(num<=0) {
			System.out.println("큐가 비어있습니다.");
		}else {
			for(int i=0;i<num;i++) {
				System.out.print(que[(i+front)%max]+" ");
			}System.out.println();
		}
	}
	
}
