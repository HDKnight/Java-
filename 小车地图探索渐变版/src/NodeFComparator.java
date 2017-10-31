


import java.util.Comparator;

class NodeFComparator implements Comparator<Node>{

    public int compare(Node o1, Node o2) {
        return o1.getF()-o2.getF();
    }
    
}