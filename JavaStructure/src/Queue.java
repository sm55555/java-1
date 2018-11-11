
public class Queue {
	private int max;	//ť �뷮
	private int num;	//���� ������ ��
	private int[] que;	//ť ��ü
	private int front;	//ù��° ��� Ŀ��
	private int rear;	//������ ��� Ŀ��
	//���� �� ���� : ť�� ��� ����
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	//���� �� ����: ť�� ������
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException() {}
	}
	public Queue(int capacity) {
		num=front=rear=0;
		max=capacity;
		try {
			que=new int[max];		//ť ��ü�� �迭�� ����
		}catch(OutOfMemoryError e) {	//������ �� ����
			max=0;
		}
	}
	
	//ť�� �����͸� �ִ� �޼���
	// ��ť�� �����ϸ� ��ť�� ���� �״�� ��ȯ�մϴ�.
	public int enque(int x) throws OverflowIntQueueException{
		if(num>=max)	//ť�� �����ִ��� Ȯ��
			throw new OverflowIntQueueException();
		que[rear++]=x;	
		num++;
		if(rear==max)	//ť�� ��á�ٸ� rear�� 0���� �ʱ�ȭ
			rear=0;
		return x;
	}
	//ť�� �����͸� ������.
	public int deque() throws EmptyIntQueueException{
		if(num<=0)
			throw new EmptyIntQueueException();
		int x=que[front++];
		num--;
		if(front==max)
			front=0;
		return x;
	}
	//ť���� �����͸� ��ũ
	public int peek() throws EmptyIntQueueException{
		if(num<=0)
			throw new EmptyIntQueueException();
		return que[front];
	}
	//ť���� x�� �˻��Ͽ� �ε��� ��ȯ( ã�� ���ϸ� -1)
	public int indexOf(int x) {
		for(int i=0;i<num;i++) {
			int idx=(i+front)%max;		//���� ť�� ���������Ƿ� i�� front�� �����ְ� max������ ���� �ε����� Ȯ���Ѵ�.
			if(que[idx]==x)
				return idx;
		}
		return -1;
	}
	//ť�� ���
	public void clear() {
		num=front=rear=0;
	}
	//ť�� �뷮�� ��ȯ
	public int capacity() {
		return max;
	}
	//ť�� �׿� �ִ� ������ ���� ��ȯ
	public int size() {
		return num;
	}
	//ť�� ����ִ��� üũ
	public boolean isEmpty() {
		return num<=0;
	}
	//ť�� �������ִ��� üũ
	public boolean isFull() {
		return num>=max;
	}
	//ť ���� ��� �����͸� front���� rear ������ ���
	public void dump() {
		if(num<=0) {
			System.out.println("ť�� ����ֽ��ϴ�.");
		}else {
			for(int i=0;i<num;i++) {
				System.out.print(que[(i+front)%max]+" ");
			}System.out.println();
		}
	}
	
}