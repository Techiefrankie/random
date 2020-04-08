package com.techie.datastructure.list;

public class List<T extends Comparable<T>> {
    static class Node<T extends Comparable<T>>{
        T data;
        Node nextNode;

        public Node(T data) {
            this.data = data;
        }

        public Node() {
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

    Node root;
    int nodeCount;

    public List() {
        this.root = null;
    }

    void add(T data) {
        Node newNode = new Node(data);

        if (root == null){
            root = newNode;
        }
        else{
            Node currentNode = root;
            while (currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
        nodeCount++;
    }

    Node search(T item){
        Node currentNode = root;
        while (currentNode != null){
            if (currentNode.data == item)
                return currentNode;
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    void insert(T item, int position){
        if (position > nodeCount || position < 0)
            return;
        Node newNode = new Node(item);
        //inserting at position 0
        if (position == 0){
            //create new node with item and set to root and adjust previous root
            //cache current root node
            Node temp = root;
            root = newNode;
            newNode.nextNode = temp;
            nodeCount++;
            return;
        }

        Node currentNode = root;
        Node previous = null; //to keep track of the previous nodes
        int index = 0;
        while (currentNode != null && index < position){
            previous = currentNode;
            //navigate to the node that has this position currently
            currentNode = currentNode.getNextNode();
            index++;
        }
        //insert the new node at this position
        previous.nextNode = newNode;
        newNode.nextNode = currentNode;
        //increase node count
        nodeCount++;
    }

    boolean delete(T item){
        Node currentNode = root, previousNode =  null, nextNode = null;
        if (currentNode == null)
            return false;
        //deleting the current root node
        if (currentNode.data == item){
            nextNode = currentNode.nextNode;
            //set root count to next node
            root = nextNode;
            currentNode = null;
            //reduce the count of nodes
            nodeCount--;
            return true;
        }
        else {
            int index = 0;
            while (currentNode != null){
                if (currentNode.data == item){
                    if (index < nodeCount) {
                        previousNode.nextNode = nextNode.getNextNode();
                    }
                    else{
                        //set the last node to null
                        previousNode.nextNode = null;
                    }
                    //reduce node count
                    nodeCount--;
                    return  true;
                }
                //increment index and swap nodes
                index++;
                previousNode = currentNode;
                nextNode = currentNode.getNextNode();
                currentNode = nextNode;
            }
        }
        return false;
    }

    Node[] getAllNodes(){
        Node[] nodes = new Node[nodeCount];
        Node currentNode = root;
        int count = 0;
        while (currentNode != null){
            nodes[count] = currentNode;
            count++;
            currentNode = currentNode.getNextNode();
        }
        return  nodes;
    }

    void insertBefore(T before, T item){
        //start at the root node and check for node that its data matches the item before
        int index = 0;
        Node currentNode = root;
        while (currentNode != null){
            if (currentNode.data == before){
                insert(item, index);
                return;
            }
            currentNode = currentNode.getNextNode();
            index++;
        }
    }

    void insertAfter(T before, T item){
        //start index at 1 to always be a node ahead of the current index
        int index = 1;
        Node currentNode = root;
        while (currentNode != null){
            if (currentNode.data == before){
                insert(item, index);
                return;
            }
            currentNode = currentNode.getNextNode();
            index++;
        }
    }

    void removeDuplicates(){
        //get hold of the root node
        Node currentNode = this.root, previousNode = null, nextNode = null;
        //loop through all the nodes in the list
        while (currentNode != null){
            //hold the current node and loop through the subsequent nodes, checking for duplicates
            previousNode = currentNode;
            nextNode = currentNode.nextNode;

            while (nextNode != null){
                if (currentNode.data == nextNode.data){
                    previousNode.nextNode = nextNode.nextNode;
                }
                //update previous and next nodes
                previousNode = nextNode;
                nextNode = nextNode.nextNode;
            }
            //move to the next node in the sequence
            currentNode = currentNode.nextNode;
        }
    }

    void sort(){
        //grab the root node
        Node currentNode = root;
        if (currentNode == null)
            return;
        //initialize previousNode and nextNode to null
        Node previousNode = null, nextNode = null, temp = null;
        //hold the current node and loop through subsequent nodes for any node with smaller data
        while (currentNode != null){
            previousNode = currentNode;
            nextNode = currentNode.nextNode;
              //check for any node with smaller data item and swap with current node
            while (nextNode != null){
                if (nextNode.data.compareTo(currentNode.data) < 0){
                    temp = nextNode;
                    previousNode.nextNode = nextNode;
                      break;
                }
                //reset next node to current node
                nextNode = nextNode.nextNode;
            }
            //advance current node pointer
            currentNode = currentNode.nextNode;
        }
    }

    void printList(){
        Node currentNode = root;
        StringBuilder sb = new StringBuilder();
        while (currentNode != null){
            sb.append(currentNode.data);
            currentNode = currentNode.getNextNode();
            if (currentNode != null)
                sb.append(" -> ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] arg){
        List<Integer> list = new List<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(8);
//        list.add(9);
//        list.add(11);
//        list.printList();
//        Node node = (List.Node) list.search(8);
//        System.out.println(node.data);
//        list.insert(4, 3);
//        list.insert(    10, 6);
//        list.printList();
//        list.delete(11);
//        list.printList();
//        list.add(12);
//        list.printList();
//        list.insert(5, 4);
//        list.insert(6, 5);
//        list.insert(7, 6);
//        list.insert(11, 10);
//        list.printList();
//        list.add(14);
//        list.printList();
//        list.insertBefore(14, 13);
//        list.printList();
//        list.insertAfter(14, 15);
//        list.printList();
//        list.insertBefore(1,0);
//        list.printList();
//        list.add(3);
//        list.insert(10, 4);
//        list.printList();
//        list.removeDuplicates();
//        list.printList();
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(8);
        list.add(3);
        list.printList();
        list.sort();
        list.printList();
    }
}


