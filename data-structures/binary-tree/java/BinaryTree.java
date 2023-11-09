class BinaryTree {
    public Node root;

    public BinaryTree(){
        this.root = null;
    }

    public void insert(int item){
        root = insert(item, root);
    }

    public Node insert(int item, Node root){
        if(root == null)
            root = new Node(item);
        else if(item < root.item){
            root.left = insert(item, root.left);
        }
        else if(item > root.item){
            root.right = insert(item, root.right);
        }
        else
            System.out.println("Error inserting element.");
        return root;
    }

    public void insertParent(int item){
        if(root == null)
            root = new Node(item);
        else if(item < root.item)
            insertParent(item, root.left, root);
        else if(item > root.item)
            insertParent(item, root.right, root);
        else
            System.out.println("Error inserting element.");
    }

    public void insertParent(int item, Node current, Node parent){
        if(current == null){
            if(item < parent.item)
                parent.left = new Node(item);
            else
                parent.right = new Node(item);
        }else if(item < current.item){
            insertParent(item, current.left, current);
        }
        else if(item > current.item){
            insertParent(item, current.right, current);
        }
        else {
            System.out.println("Error inserting element.");
        }
    }


    public void showNodes(){
        System.out.print("[ ");
        showNodes(root);
        System.out.println("]");
    }

    public void showNodes(Node root){
        if(root != null){
            System.out.print(root.item + " ");
            showNodes(root.left);
            showNodes(root.right);
        }
    }

    public void showLeftNodesFirst(){
        System.out.print("[ ");
        showLeftNodesFirst(root);
        System.out.println("]");
    }

    public void showLeftNodesFirst(Node root){
        if(root != null){
            showLeftNodesFirst(root.left);
            System.out.print(root.item + " ");
            showLeftNodesFirst(root.right);
        }
    }

    public void showRightNodesFirst(){
        System.out.print("[ ");
        showRightNodesFirst(root);
        System.out.println("]");
    }

    public void showRightNodesFirst(Node root){
        if(root != null){
            showRightNodesFirst(root.right);
            System.out.print(root.item + " ");
            showRightNodesFirst(root.left);
        }
    }

    

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();

        tree.insert(3);
        tree.insert(5);
        tree.insert(1);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
        tree.insert(10);

        tree2.insert(5);
        tree2.insert(7);
        tree2.insert(2);
        tree2.insert(12);
        tree2.insert(54);
        tree2.insert(411);
        tree2.insert(45);
        tree2.insert(1);
        tree2.insert(555);
        tree2.insert(16);



        tree.showNodes();
        tree.showLeftNodesFirst();
        tree.showRightNodesFirst();

        tree2.showNodes();
        tree2.showLeftNodesFirst();
        tree2.showRightNodesFirst();
    }

}