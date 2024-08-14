package com.techie.datastructure.list;

public class Driver {
    public Node<Integer> mergeSortedList(Node<Integer> nodeA, Node<Integer> nodeB) {
        if (nodeA == null) {
            return nodeB;
        }
        if (nodeB == null) {
            return nodeA;
        }

        if (nodeA.getNodeItem() < nodeB.getNodeItem()) {
            nodeA.nextNode = mergeSortedList(nodeA.getNextNode(), nodeB);
            return nodeA;
        } else {
            nodeB.nextNode = mergeSortedList(nodeA, nodeB.nextNode);
            return nodeB;
        }
    }
}
