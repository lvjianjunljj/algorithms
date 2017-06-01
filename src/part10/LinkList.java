package part10;

//单向链表
public class LinkList {
	public Node first; // 定义一个头结点
	public Node last;// 定义一个尾节点，便于两个链表相连
	private int pos = 0;// 节点的位置

	public LinkList() {
		this.first = null;
		this.last = null;
	}

	public void add(Object data) {
		Node node = new Node(data);
		if (this.first == null) {
			this.first = node;
			this.last = node;
		} else {
			this.last.next = node;
			this.last = node;
		}
	}

	// 插入一个头节点
	public void addFirstNode(Object data) {
		Node node = new Node(data);
		node.next = first;
		first = node;
	}

	// 删除一个头结点,并返回头结点
	public Node deleteFirstNode() {
		Node tempNode = first;
		first = tempNode.next;
		return tempNode;
	}

	// 在任意位置插入节点 在index的后面插入
	public void add(int index, Object data) {
		Node node = new Node(data);
		Node current = first;
		Node previous = first;
		while (pos < index) {
			previous = current;
			current = current.next;
			pos++;
		}
		node.next = current;
		if (index > 0) {
			previous.next = node;
		} else {
			first = node;
		}
		pos = 0;
	}

	// 删除任意位置的节点
	public Node deleteByPos(int index) {
		Node current = first;
		Node previous = first;
		while (pos != index) {
			pos++;
			previous = current;
			current = current.next;
		}
		if (current == first) {
			first = first.next;
		} else {
			pos = 0;
			previous.next = current.next;
		}
		return current;
	}

	// 根据节点的data删除节点(仅仅删除第一个)
	public Node deleteByData(Object data) {
		Node current = first;
		Node previous = first; // 记住上一个节点
		while (current.data != data) {
			if (current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
	}

	// 显示出所有的节点信息
	public void displayAllNodes() {
		Node current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}

	public void setFirstNode(Node node) {
		first = node;
	}

	// 根据位置查找节点信息
	public Node findByPos(int index) {
		Node current = first;
		if (pos != index) {
			current = current.next;
			pos++;
		}
		return current;
	}

	// 根据数据查找节点信息
	public Node findByData(Object data) {
		Node current = first;
		while (current.data != data) {
			if (current.next == null)
				return null;
			current = current.next;
		}
		return current;
	}
	
	//合并两个链表并将结果放在第一个链表中
	public static void merge(LinkList a,LinkList b){
		a.last.next = b.first;
	}
	
	//为欧拉回路问题问题封装的方法，将指定点的node替换为一个链表加在原链表中
	//最后的最后老子找到了java封装好的LinkedList的对应方法add(int index, E element)，所以果断抛弃你了
	public void eulerLoop(Node d,LinkList loop){
		loop.last.next = d.next;
		d.next = loop.first;
	}
	
	
}