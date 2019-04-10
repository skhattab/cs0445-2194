public class Driver {
  public static void main(String[] args){
    BinaryTree<Character> bTree =
      new BinaryTree<>('B');
    BinaryTree<Character> fTree =
      new BinaryTree<>('F');
    BinaryTree<Character> gTree =
      new BinaryTree<>('G');
    BinaryTree<Character> dTree =
      new BinaryTree<>('D');
    dTree.buildTree('D', null, fTree);
    BinaryTree<Character> aTree =
        new BinaryTree<>('A');
    aTree.buildTree('A', bTree, dTree);
    BinaryTree<Character> cTree =
      new BinaryTree<>('C');
    cTree.buildTree('C', null, gTree);
    BinaryTree<Character> eTree =
      new BinaryTree<>('E');
    eTree.buildTree('E', aTree, cTree);
    eTree.inorderTraverse();
  }
}
