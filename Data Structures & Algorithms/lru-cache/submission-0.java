public class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}



class LRUCache {
    private int cap;
    private HashMap<Integer,Node> map;
    private Node left;
    private Node right;
    public LRUCache(int capacity) {
       this.cap=capacity;
       this.map=new HashMap<>();
       this.left=new Node(0,0);
       this.right=new Node(0,0);
       this.left.next=this.right;
       this.right.prev=this.left;
    }
    private void remove(Node node){
        Node prev=node.prev;
        Node nxt=node.next;
        prev.next=nxt;
        nxt.prev=prev;
    }
    private void insert(Node node){
        Node prev=this.right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=this.right;
        this.right.prev=node;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node newNode=new Node(key,value);
        map.put(key,newNode);
        insert(newNode);
        if(map.size()>cap){
            Node lru=this.left.next;
            remove(lru);
            map.remove(lru.key);
}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */