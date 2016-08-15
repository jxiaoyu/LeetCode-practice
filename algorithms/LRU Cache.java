/**
 * key value 用 map 来实现自不必说，为了保留使用顺序需要一个线性的结构
 * LinkedHashMap 就保持着插入顺序，可以满足这一需求
 * 这里用双向链表的原因是 remove 一个节点时间复杂度是 O(1), 而单向链表是 O(n)
 * 不清楚 LinkedHashMap 的数据结构，结点间可能也是双向的链表
 */
class Node{
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);

            }else{
                setHead(created);
            }

            map.put(key, created);
        }
    }

    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }

    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        if(head!=null)
            head.pre = n;

        head = n;

        if(end ==null)
            end = head;
    }
}