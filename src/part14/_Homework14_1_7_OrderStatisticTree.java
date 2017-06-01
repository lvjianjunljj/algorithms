package part14;

public class _Homework14_1_7_OrderStatisticTree {
	public static final OsTreeNode NIL = new OsTreeNode(RbColor.BLACK, 0);
	private OsTreeNode root = null;

	public static int method(int[] a ){
		 _Homework14_1_7_OrderStatisticTree tree = new _Homework14_1_7_OrderStatisticTree();
		int sum = 0;
		for (int j = 0; j < a.length; j++) {
			OsTreeNode node = new OsTreeNode(a[j], RbColor.RED);
			tree.insertOsTreeNode(node);
			sum = sum +j +1 - tree.osRank(node);
		}
		return sum;
	}

	public _Homework14_1_7_OrderStatisticTree() {
		this.root = NIL;
	}

	// 中序遍历二叉树
	public void traverseTree(OsTreeNode x) {
		if (x != NIL) {
			traverseTree(x.left);
			System.out.println(x.key + "\t" + x.color + "\t" + x.size);
			traverseTree(x.right);
		}
	}

	public void printTree() {
		System.out.println("root:" + root.key + "\t" + root.color);
		traverseTree(root);
		System.out.println();
	}

	// 设置顺序统计树每个节点的size
	public int setOsTreeNodeSize(OsTreeNode x) {
		if (x == NIL) {
			return 0;
		} else {
			return setOsTreeNodeSize(x.left) + setOsTreeNodeSize(x.right) + 1;//		
		}
	}

	// 找到第i小关键字的节点
	public OsTreeNode osSelect(OsTreeNode x, int i) {
		if (i < 0) {
			System.out.println("invalidate parameter!");
			return null;
		}
		int r = x.left.size + 1;
		if (i == r) {
			return x;
		} else if (i < r) {
			return osSelect(x.left, i);
		} else {
			return osSelect(x.right, i - r);
		}
		/*
		 * 非递归版本 int r = 0; while(i != r){ r = x.left.size+1; if (i<r) {
		 * x=x.left; } if(i>r) { x=x.right; i = i-r; } } return x;
		 */
	}

	// 找到x节点的序
	public int osRank(OsTreeNode x) {
		int r = x.left.size + 1;
		OsTreeNode y = x;
		while (y != root) {
			if (y == y.parent.right) {
				r = r + y.parent.left.size + 1;
			}
			y = y.parent;
		}
		return r;
	}

	// 找到x节点的序（非递归方法）
	public int Os_Rank_Recursion(OsTreeNode tree, OsTreeNode x) {
		if (x.key == tree.key) {
			return tree.left.size + 1;
		}
		if (x.key > tree.key) {
			return tree.left.size + 1 + Os_Rank_Recursion(tree.right, x);
		}
		return Os_Rank_Recursion(tree.left, x);

	}

	// 查找某一子节点
	public OsTreeNode searchOsTreeNode(OsTreeNode x, int key) {
		while (x != NIL && key != x.key) {
			if (key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		return x;
	}

	// 插入某一子节点
	public void insertOsTreeNode(OsTreeNode z) {
		OsTreeNode y = NIL;
		OsTreeNode x = root;
		while (x != NIL) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		z.parent = y;
		if (y == NIL) {
			root = z;
		} else if (z.key < y.key) {
			y.left = z;
		} else {
			y.right = z;
		}
		z.left = NIL;
		z.right = NIL;
		z.color = RbColor.RED;
		// 插入后成了叶节点，叶节点size为1
		z.size = 1;
		sizeFixUp(z.parent);
		/** 需要加一部这个判断，不然会报空指针错误 */
		if (z.parent.parent != NIL) {
			osInsertFixUp(z);
		}
		// 插入修正
	}

	// 插入修正
	public void osInsertFixUp(OsTreeNode z) {
		OsTreeNode y = null;
		while (z.parent.color == RbColor.RED) {
			// 当z的父节点是黑色时，不需要矫正
			if (z.parent == z.parent.parent.left) {
				// 左分支情况
				y = z.parent.parent.right;
				// 根据叔节点分情况
				if (y.color == RbColor.RED) {
					z.parent.color = RbColor.BLACK;
					y.color = RbColor.BLACK;
					z.parent.parent.color = RbColor.RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = RbColor.BLACK;
					z.parent.parent.color = RbColor.RED;
					rightRotate(z.parent.parent);
				}
			} else {
				y = z.parent.parent.left;
				// 根据叔节点分情况
				if (y.color == RbColor.RED) {
					z.parent.color = RbColor.BLACK;
					y.color = RbColor.BLACK;
					z.parent.parent.color = RbColor.RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = RbColor.BLACK;
					z.parent.parent.color = RbColor.RED;
					leftRotate(z.parent.parent);
				}
			}
			root.color = RbColor.BLACK;
		}
	}

	// 删除某一子节点
	public void deleteOsTreeNode(OsTreeNode z) {
		OsTreeNode y = z;
		OsTreeNode x = NIL;
		RbColor yOriginalColor = y.color;
		if (z.left == NIL) {
			x = z.right;
			osTransplant(z, z.right);
			sizeFixUp(z);
			// 修复从根节点到z节点路径的size
		} else if (z.right == NIL) {
			x = z.left;
			osTransplant(z, z.left);
			sizeFixUp(z);
			// 修复从根节点到z节点路径的size
		} else {
			y = searchMinNode(z.right);
			yOriginalColor = y.color;
			x = y.right;
			if (y.parent == z) {
				x.parent = y;
			} else {
				osTransplant(y, y.right);
				y.right = z.right;
				z.right.parent = y;
			}
			osTransplant(z, y);
			y.left = z.left;
			z.left.parent = y;
			y.color = z.color;
			x.parent.size--;
			sizeFixUp(x.parent.parent);
			// 修复从根节点到z节点路径的size
		}
		if (yOriginalColor == RbColor.BLACK) {
			osDeleteFixUp(x);
		}
	}

	public void sizeFixUp(OsTreeNode x) {
		OsTreeNode y = x;
		while (y != NIL) {
			y.size = y.left.size + y.right.size + 1;
			y = y.parent;
		}
	}

	public void osDeleteFixUp(OsTreeNode x) {
		// x总是指向一个具有双重黑色的非根节点
		OsTreeNode w = NIL;
		while (x != root && x.color == RbColor.BLACK) {
			if (x == x.parent.left) {
				w = x.parent.right;
				// w指向兄节点
				if (w.color == RbColor.RED) {
					w.color = RbColor.BLACK;
					// case 1
					x.parent.color = RbColor.RED;
					// case 1
					leftRotate(x.parent);
					// case 1
					w = x.parent.right;
					// case 1
				}
				if (w.left.color == RbColor.BLACK
						&& w.right.color == RbColor.BLACK) {
					w.color = RbColor.BLACK;
					// case 2
					x = x.parent;
					// case 2
				} else {
					if (w.right.color == RbColor.BLACK) {
						w.left.color = RbColor.BLACK;
						// case 3
						w.color = RbColor.RED;
						// case 3
						rightRotate(w);
						// case 3 w = x.parent.right;
						// case 3
					}
					w.color = x.parent.color;
					// case 4
					x.parent.color = RbColor.BLACK;
					// case 4
					w.right.color = RbColor.BLACK;
					// case 4
					leftRotate(x.parent);
					// case 4
					x = root; // case 4
				}
			} else {
				w = x.parent.left;
				// w指向兄节点
				if (w.color == RbColor.RED) {
					w.color = RbColor.BLACK;
					// case 1
					x.parent.color = RbColor.RED;
					// case 1
					rightRotate(x.parent);
					// case 1
					w = x.parent.left;
					// case 1
				}
				if (w.right.color == RbColor.BLACK
						&& w.left.color == RbColor.BLACK) {
					w.color = RbColor.BLACK;
					// case 2
					x = x.parent;
					// case 2
				} else {
					if (w.left.color == RbColor.BLACK) {
						w.right.color = RbColor.BLACK;
						// case 3
						w.color = RbColor.RED;
						// case 3
						leftRotate(w);
						// case 3
						w = x.parent.left;
						// case 3
					}
					w.color = x.parent.color;
					x.parent.color = RbColor.BLACK;
					w.left.color = RbColor.BLACK;
					rightRotate(x.parent);
					x = root;

				}
			}
		}
	}

	public void osTransplant(OsTreeNode u, OsTreeNode v) {
		if (u.parent == NIL) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		v.parent = u.parent;
	}

	// 获取最小键值节点
	public OsTreeNode searchMinNode(OsTreeNode x) {
		while (x.left != NIL) {
			x = x.left;
		}
		return x;
	}

	// 获取最大键值节点
	public OsTreeNode searchMaxNode(OsTreeNode x) {
		while (x.right != NIL) {
			x = x.right;
		}
		return x;
	}

	// 左旋
	public void leftRotate(OsTreeNode x) {
		OsTreeNode y = x.right;
		x.right = y.left;
		if (x.right != NIL) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == NIL) {
			// 如果是根节点
			root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
		// size属性维护
		y.size = x.size;
		x.size = x.left.size + x.right.size + 1;
	}

	// 右旋
	public void rightRotate(OsTreeNode y) {
		OsTreeNode x = y.left;
		y.left = x.right;
		if (x.right != NIL) {
			x.right.parent = y;
		}
		x.parent = y.parent;
		if (y.parent == NIL) {
			root = x;
		} else if (y == y.parent.left) {
			y.parent.left = x;
		} else {
			y.parent.right = x;
		}
		x.right = y;
		y.parent = x;
		// size属性维护
		x.size = y.size;
		y.size = y.left.size + y.right.size + 1;
	}

	// 红黑树节点类
	public static class OsTreeNode {
		OsTreeNode left = null;
		OsTreeNode right = null;
		OsTreeNode parent = null;
		RbColor color = RbColor.RED;
		int key = 0;
		int size = 0;

		public OsTreeNode(int key, RbColor color) {
			this.key = key;
			this.color = color;
		}

		public OsTreeNode(RbColor color, int size) {
			this.color = color;
			this.size = size;
		}
	}

	public enum RbColor {
		RED, BLACK;
	}

}
