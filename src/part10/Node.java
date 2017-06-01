package part10;

public class Node {  
    protected Node next; //指针域  
    protected Object data;//数据域  
      
	public Node(Object data) {  
          this. data = data;  
    }  
      
    //显示此节点  
    public void display() {  
         System. out.print( data + " ");  
    }  
}  
