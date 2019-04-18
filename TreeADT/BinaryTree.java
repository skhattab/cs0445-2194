public class BinaryTree<T> implements BinaryTreeInterface<T> {

  private BinaryNode<T> root;

  protected void setRoot(BinaryNode<T> root){
    this.root = root;
  }

  public void clear(){
    root = null;
  }

  public BinaryTree(){
    root = null;
  }

  public BinaryTree(T rootData){
    privateBuildTree(rootData, null, null);
  }

  public BinaryTree(T rootData, BinaryTree<T> leftTree,
                    BinaryTree<T> rightTree){
    privateBuildTree(rootData, leftTree, rightTree);
  }

  public void buildTree(T rootData) {
    privateBuildTree(rootData, null, null);
  }

  public void buildTree(T rootData,
                        BinaryTreeInterface<T> left,
                        BinaryTreeInterface<T> right) {
    privateBuildTree(rootData, (BinaryTree<T>)left, (BinaryTree<T>)right);
  }

  private void privateBuildTree(T rootData, BinaryTree<T> leftTree,
                                BinaryTree<T> rightTree){
      root = new BinaryNode<>(rootData);
      if((leftTree != null) && (!leftTree.isEmpty())){
        root.setLeftChild(leftTree.getRoot());
      }
      if((rightTree != null)&&(!rightTree.isEmpty())){
        if(leftTree == rightTree) {
          root.setRightChild(rightTree.getRoot().copy());
        } else {
          root.setRightChild(rightTree.getRoot());
        }
      }

      if((leftTree!=null)&&(leftTree != this)){
        leftTree.clear();
      }
      if((rightTree != null)&&(rightTree != this)){
        rightTree.clear();
      }
  }

  public T getRootData() throws EmptyTreeException {
    if(root == null)
      throw new EmptyTreeException("Empty tree");
    return root.getData();
  }

  protected BinaryNode<T> getRoot(){
    return root;
  }
  public int getHeight() throws EmptyTreeException {
    if(root == null)
      throw new EmptyTreeException("Empty tree");
    return root.getHeight();
  }
  public int getNumberOfNodes() throws EmptyTreeException {
    if(root == null)
      throw new EmptyTreeException("Empty tree");
    return root.getNumberOfNodes();
  }

  public boolean isEmpty(){
    return root == null;
  }
  public void levelOrderTraverse(){

  }


  public void preorderTraverse(){
    preorderTraverse(root);
  }

  public void inorderTraverse(){
    inorderTraverse(root);
  }
  public void postorderTraverse(){
    postorderTraverse(root);
  }

  private void preorderTraverse(BinaryNode<T> root){
    if(root != null){
      //visit the root
      System.out.println(root.getData());
      //left
      preorderTraverse(root.getLeftChild());
      //right
      preorderTraverse(root.getRightChild());
    }
  }

  private void inorderTraverse(BinaryNode<T> root){
    if(root != null){
      //left
      inorderTraverse(root.getLeftChild());
      //visit the root
      System.out.println(root.getData());
      //right
      inorderTraverse(root.getRightChild());
      //have you seen about time?
    }
  }

  private void postorderTraverse(BinaryNode<T> root){
    if(root != null){
      //left
      postorderTraverse(root.getLeftChild());
      //right
      postorderTraverse(root.getRightChild());
      //visit the root
      System.out.println(root.getData());
    }
  }
}
