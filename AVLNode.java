public class AVLNode {
  public AVLNode left = null;
  public AVLNode right = null;
  public int value = 0;
  public AVLNode parent = null;
public int key=0;
  public AVLNode insert(int newValue) {
    // perform binary-search style insertion
    key=newValue;
    if (newValue < this.value) {
      // insert the value to the left sub-tree
      if (this.left == null) {
        AVLNode newNode = new AVLNode();
        newNode.value = newValue;
        newNode.parent = this;
        this.left = newNode;
      } else {
        this.left.insert(newValue);
      }
    } else {
      // insert the value into the right sub-tree
      if (this.right == null) {
        AVLNode newNode = new AVLNode();
        newNode.value = newValue;
        newNode.parent = this;
        this.right = newNode;
      } else {
        this.right.insert(newValue);
      }
    }
    System.out.println(this.getBalance());
    return rebalance();
  }
public AVLNode rotateright(AVLNode Node){
  AVLNode newRoot=Node.left;
  AVLNode justTree=newRoot.right;

  Node.left=justTree;
  newRoot.right=Node;

  return newRoot;
}
public AVLNode rotateleft(AVLNode Node){
  AVLNode newRoot=Node.right;
  AVLNode justTree=newRoot.left;

  Node.right=justTree;
  newRoot.left=Node;

  return newRoot;
}
  public AVLNode rebalance() {
    if(this.getBalance()>=2 && this.key<this.right.value){
      //AVLNode newRoot=new AVLNode();
    //  AVLNode balancedRoot=new AVLNode();
    //  newRoot=rotateright(this.right);
    //  balancedRoot=rotateleft(newRoot);
    this.right=rotateright(this.right);
      return rotateleft(this);
    }
    else if(this.getBalance()<=-2 && this.key>this.left.value){
    //  AVLNode newRoot=new AVLNode();
    //  AVLNode balancedRoot=new AVLNode();
    //  newRoot=rotateleft(this.right);
    //  balancedRoot=rotateright(newRoot);
      this.left=rotateleft(this.left);
      return rotateright(this);
    }
    else if(this.getBalance()>=2 && this.key>this.right.value){
      return rotateleft(this);
    }
    else if(this.getBalance()<=-2 && this.key<this.left.value){
      return rotateright(this);
    }

    // balance the tree (if necessary)
    else{
    return null;}
  }

  public int getBalance() {
    int rightHeight = 0;
    if (this.right != null) {
      rightHeight = this.right.getHeight();
    }

    int leftHeight = 0;
    if (this.left != null) {
      leftHeight = this.left.getHeight();
    }

    return rightHeight - leftHeight;
  }

  public void print(int depth) {
    if (this.right != null) {
      this.right.print(depth + 1);
    }

    for (int i = 0; i < depth; i++) {
      System.out.print("\t");
    }
    System.out.println(this.value);

    if (this.left != null) {
      this.left.print(depth + 1);
    }
  }

  public int getHeight() {
    int leftHeight = 1;
    if (left != null) {
      leftHeight = left.getHeight() + 1;
    }

    int rightHeight = 0;
    if (right != null) {
      rightHeight = right.getHeight() + 1;
    }

    return (leftHeight > rightHeight) ? leftHeight : rightHeight;
  }
}
