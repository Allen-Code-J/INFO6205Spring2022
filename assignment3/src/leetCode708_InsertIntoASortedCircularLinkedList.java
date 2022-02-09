class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null) {
            node.next = node;
            return node;
        }

        Node prev = head;
        Node curr = head.next;
        boolean insert = false;

        do{
            if(prev.val <= insertVal && insertVal <= curr.val) {
                insert = true;
            } else if(prev.val > curr.val) {
                if(insertVal >= prev.val || insertVal <= curr.val) {
                    insert = true;
                }
            }

            if(insert) {
                prev.next = node;
                node.next = curr;
                return head;
            }

            prev = curr;
            curr = curr.next;
        } while(prev != head);

        prev.next = node;
        node.next = curr;

        return head;
    }
}