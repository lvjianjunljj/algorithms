package part14;

/*Josephus问题求解：  * 使用2种方式： 
 * 1、ArrayList数组循环方式，这个因为涉及到ArrayList的删除操作，因此是O(N²)的复杂度 
 * 2、使用循环链表，复杂度降到了O(N)，线性  */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.omg.CORBA.Current;

public class Josephus {
	public static void main(String[] args) {
		Josephus1(0, 40000);
		Josephus2(0, 400000);
	}
	
	//参数m表示退出的两个人之间相隔几个人（两个人若是相邻则m为0）
	public static void Josephus1(int m, int n) {
		// 初始化
		long start = System.currentTimeMillis();
		// 定时器开始计时
		Integer[] people = new Integer[n];
		for (int i = 0; i < n; i++) {
			people[i] = i;
		}
		List<Integer> list = Arrays.asList(people);
		ArrayList<Integer> lists = new ArrayList<Integer>(list);
		// 初始化一个ArrayList数组
		int current = 0;
		// 当前土豆的位置
		int deadman = 0;
		// 离开游戏的人数
		while (deadman < n - 1) {
			int k = m % (n - deadman);
			// 每次找跳过的人数
			lists.remove((current + k) % lists.size());
			// 拿到土豆的人离开游戏
			deadman++;
			// 离开人数上升

			current = (current + k) % (lists.size() + 1);
			// 更改土豆的位置
		}
		System.out.println("winner is  num :" + lists.get(0));
		long end = System.currentTimeMillis();
		System.out.println("time consume : " + (end - start));
		System.out.println();
		System.out.println();
	}

	public static void Josephus2(int m, int n) {

		long start = System.currentTimeMillis();
		// 计时开始
		Lister lst = new Lister(n);
		// 初始化一个自定义链表
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (m == 0) {
			// 定义了m=0的情况
			for (int i = 0; i < n - 1; i++) {
				lst.move();
			}
			System.out.println("winner is :" + (lst.current.value - 1));
		} else {
			int deadman = 0;
			while (deadman < n - 1) {
				for (int i = 0; i < m - 1; i++) {
					lst.move();
					// 每次让土豆移动到合适的位置
				}
				lst.remove(lst.current);
				// 脱链
				deadman++;
			}
			System.out.println("winner is :" + (lst.current.value - 1));
		}
		long end = System.currentTimeMillis();
		System.out.println("time consume : " + (end - start));
	}
}

class Lister {

	int count = 0;
	// 节点数目
	Node current = null;
	// 当前链表指针
	Node beginer = null;

	// 链表头
	class Node {
		// 内部节点
		public Integer value;
		public Node next;

		public Node(Integer value, Node next) {
			this.value = value;
			this.next = next;
			count++;
		}
	}

	public Lister(int num) {
		System.out.println("easy link");
		count = 0;
		beginer = new Node(0, null);
		current = beginer.next;
		//     
		addFirst(1);
		// 初始化链表头
		for (int i = 2; i < num; i++) {
			add(i);
		}
		addLast(num); // 构造循环链表

		current = beginer.next;
		// 从第一个node开始
	}

	private void addFirst(Integer value) {
		Node first = new Node(value, null);
		beginer.next = first;
		current = first;
	}

	public boolean add(Integer value) {
		Node next = new Node(value, null);
		current.next = next;
		current = next;
		return true;
	}

	void addLast(Integer value) {
		Node last = new Node(value, beginer.next);
		current.next = last;
	}

	void remove(Node p) { // 删除当前node的下一个Node
		Node pn = p.next;
		p.next = pn.next;
		current = p.next;
		count--;
	}

	void move() { // 移动current指针
		current = current.next;
	}
}
