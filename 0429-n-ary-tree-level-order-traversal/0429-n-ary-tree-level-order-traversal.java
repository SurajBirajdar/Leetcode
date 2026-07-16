/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            while(size>0) {
            Node node = queue.poll();
            levelNodes.add(node.val);
            for(Node child : node.children) {
                if(child != null) {
                    queue.add(child);
                }
            }
            size--;

            }
            res.add(levelNodes);
            
        }
        return  res;
    }
}