class MyHashSet {
    private static class ListNode {
        int key;
        ListNode next;

        ListNode() {
            this.key = -1;
            this.next = null;
        }

        ListNode(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private final ListNode[] map;

    public MyHashSet() {
        map = new ListNode[10000];
        for (int i = 0; i < map.length; i++) 
        {
            map[i] = new ListNode();
        }
    }

    private int hash(int key) {
        return key % map.length;
    }
    
    public void add(int key) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) 
        {
            if (cur.next.key == key) return;
            cur = cur.next;
        }
        cur.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) 
        {
            if (cur.next.key == key) 
            {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) 
        {
            if (cur.next.key == key) return true; 
            cur = cur.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */