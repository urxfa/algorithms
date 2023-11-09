class Node {
    public int item;
    public Node left;
    public Node right;

    public Node(int item){
        this(item, null, null);
    }

    public Node(int item, Node left, Node right){
        this.item = item;
        this.left = left;
        this.right = right;
    }
}
