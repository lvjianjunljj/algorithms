package part14;

/**  
 * @author   
 * Email:  
 * 创建时间：2012-11-16 下午6:44:52 
 * 类说明  ：区间树查找算法 
 * @version  
 */  
public class IntervalTreeExperiment {  
    public static void main(String[] args) {  
        //构造如算法导论书本P187页图14-4的区间树  
        IntervalTree it = new IntervalTree();  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(16,21)));  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(8,9)));  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(25,30)));  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(5,8)));  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(15,23)));  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(17,19)));  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(26,26)));  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(0,3)));  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(6,10)));  
        IntervalTree.interval_insert(it,new IntervalTreeNode(new Section(19,20)));  
        System.out.println("中序遍历P199页图14-4的区间树：");  
        IntervalTree.inOrderTraverse(it.root);  
        //在此区间树中查找区间[3,7],并输出结果  
        System.out.println("在此区间树中查找区间[3,7]的结果：");  
        System.out.println(IntervalTree.interval_search(it, new Section(3,7)));  
        //在此区间树中查找区间[22,24],并输出结果  
        System.out.println("在此区间树中查找区间[22,24]的结果：");  
        System.out.println(IntervalTree.interval_search(it, new Section(22,24)));  
        //在此区间树中查找区间[21,21],并输出结果  
        System.out.println("在此区间树中查找区间[21,21]的结果：");  
        System.out.println(IntervalTree.interval_search(it, new Section(21,21)));  
    }  
}  
class IntervalTree {  
    public int number;  
    public IntervalTreeNode root;  
    public final static int RED=0;  
    public final static int BLACK=1;  
      
    public static boolean isOverlap(Section x, Section y){  
          
        return (x.high>=y.low) && (y.high>=x.low);  
    }  
    public static IntervalTreeNode interval_search(IntervalTree T,Section i){  
        //找出树T中覆盖区间i的那个节点  
        IntervalTreeNode x=T.root;  
        while(x!=null && !isOverlap(i, x.section)){  
            if((x.left != null) && (x.left.max >= i.low)){  
                x=x.left;  
            }  
            else{  
                x=x.right;  
            }  
        }  
        return x;  
    }  
    public static void left_rotate(IntervalTree it,IntervalTreeNode x) {//对x节点左旋转  
        if((it==null) || (x==null))return;  
        //set y  
        IntervalTreeNode y = x.right;  
        //turn y's left subtree into x's right subtree  
        x.right = y.left;  
        if(y.left != null) {  
            y.left.p = x;  
        }  
        //link x's parent to y  
        y.p=x.p;  
        if(x.p == null) {  
            it.root = y;  
        }  
        else if(x == x.p.left){  
            x.p.left=y;  
        }  
        else {  
            x.p.right=y;  
        }  
        //put x on y's left  
        y.left=x;  
        x.p=y;  
        //update max  
        x.max=Math.max(x.section.high, Math.max(x.left.max,x.right.max));  
        y.max=Math.max(y.section.high, Math.max(y.left.max,y.right.max));  
    }  
    public static void right_rotate(IntervalTree it,IntervalTreeNode y) {//对y节点右旋转  
        if((it==null) || (y==null))return;  
        //set x  
        IntervalTreeNode x = y.left;  
        //turn x's right subtree into y's left subtree  
        y.left=x.right;  
        if(x.right != null) {  
            x.right.p = y;  
        }  
        //link y's parent to x  
        x.p=y.p;  
        if(y.p == null) {  
            it.root = x;  
        }  
        else if(y == y.p.left){  
            y.p.left=x;  
        }  
        else {  
            y.p.right=x;  
        }  
        //put y on x's right  
        x.right=y;  
        y.p=x;  
        //update max  
        x.max=Math.max(x.section.high, Math.max(x.left.max,x.right.max));  
        y.max=Math.max(y.section.high, Math.max(y.left.max,y.right.max));  
    }  
    public static void interval_insert(IntervalTree it,IntervalTreeNode z){//在rb中插入z节点  
        if(z==null)return;  
        IntervalTreeNode y=null;  
        IntervalTreeNode x=it.root;  
        while(x != null) {  
            y=x;  
            if(z.key < x.key) {  
                x=x.left;  
            }  
            else {  
                x=x.right;  
            }  
        }  
        z.p=y;  
        if(y == null) {  
            it.root=z;  
        }  
        else if(z.key < y.key) {  
            y.left=z;  
        }  
        else {  
            y.right=z;  
        }  
        z.left=null;  
        z.right=null;  
        z.color=RED;  
        it.number++;  
        rb_insert_fixup(it,z);  
    }  
    public static void rb_insert_fixup(IntervalTree it,IntervalTreeNode z) {//调整插入后的树  
        while((z.p != null) && (z.p.color == RED)){  
            if((z.p.p != null) && (z.p == z.p.p.left)) { //父亲节点是祖先节点的左孩子  
                IntervalTreeNode y=z.p.p.right;//uncle y  
                if((y != null) && (y.color==RED)) {  
                    z.p.color=BLACK;  
                    y.color=BLACK;  
                    z.p.p.color=RED;  
                    z=z.p.p;//important  
                }  
                else {  
                    if(z==z.p.right) {  
                        z=z.p;  
                        left_rotate(it,z);  
                    }  
                    z.p.color=BLACK;  
                    z.p.p.color=RED;  
                    right_rotate(it,z.p.p);  
                }  
            }  
            else if(z.p.p != null){//父亲节点是祖先节点的右孩子  
                IntervalTreeNode y=z.p.p.left;//uncle y  
                if((y != null) && (y.color==RED)) {  
                    z.p.color=BLACK;  
                    y.color=BLACK;  
                    z.p.p.color=RED;  
                    z=z.p.p;//important  
                }  
                else {  
                    if(z==z.p.left) {  
                        z=z.p;  
                        right_rotate(it,z);  
                    }  
                    z.p.color=BLACK;  
                    z.p.p.color=RED;  
                    left_rotate(it,z.p.p);  
                }  
            }  
              
        }  
        it.root.color=BLACK;  
    }  
//  public static void interval_delete(IntervalTree T,IntervalTreeNode x){}  
    public static void inOrderTraverse(IntervalTreeNode root) {  
        if(root==null)return;  
        inOrderTraverse(root.left);  
        if(root.color==BLACK) {  
            System.out.println(root.section+"\tblack\tmax="+root.max);  
        }  
        else {  
            System.out.println(root.section+"\tred\tmax="+root.max);  
        }  
        inOrderTraverse(root.right);  
    }  
}  
class IntervalTreeNode {  
    public IntervalTreeNode p;  
    public IntervalTreeNode left;  
    public IntervalTreeNode right;  
    public int key;  
    public int color;  
    //扩展红黑树  
    public Section section;  
    public int max;  
    public IntervalTreeNode(int key){  
        this.key=key;  
    }  
    public IntervalTreeNode(Section section) {  
        this.section=section;  
        key=section.low; // initialize key  
        max=section.high;// initialize max  
    }  
    @Override  
    public String toString() {  
        String color_str;  
        if(color==0){  
            color_str="red";  
        }  
        else{  
            color_str="black";  
        }  
        if(p!=null){  
            return "IntervalTreeNode [p=" + p.section + ", left=" + left.section + ", right="  
                + right.section + ", color=" + color_str + ", section="  
                + section + ", max=" + max + "]";  
      
        }  
        else{  
            return "IntervalTreeRootNode[left=" + left.section + ", right="  
                    + right.section + ", color=" + color_str + ", section="  
                    + section + ", max=" + max + "]";  
        }  
    }  
}  
class Section{  
    public int low;  
    public int high;  
    public Section(int low, int high) {  
        this.low = low;  
        this.high = high;  
    }  
    @Override  
    public String toString() {  
        return "[" + low + "," + high + "]";  
    }  
      
}  

