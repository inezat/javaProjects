package binarysearchtree3;

public interface BinarySearchTree3Interface<E extends Comparable> 
{
    public int size();
    public boolean isEmpty(); 
    public void insertItem(E item);
    public boolean inTree(E item); 
    public void removeItem(E item); 
    public void printTreeInOrder(); 
    public void printTreeInPreOrder(); 
    public void printTreeInPostOrder();
}

//(printnodesinlevel)if statement one branch: 2 recusrive calls one to the left child of the input node. then a recursive call to the right child of the input node
//an if statement 2 recursive calls- a recursive call to teh left child of hte input node and a recursive call to the right child of the inout node. its a short method
//its only a few lines to implement (SIZEOF TREE) returns the number of nodes rooted in the subtree topnode
//isperfect the formula to check this was written on the board. you have to call get tree to get, you have to call height to get height you're gonna need
//pow to get 2^h