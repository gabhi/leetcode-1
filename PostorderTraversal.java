import java.util.*;

class PostorderTraversal { 

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);   // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;   
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val); // Add after all left children
                p = node.right;   
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val); // Reverse the process of preorder
                p = p.right;            // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;          // Reverse the process of preorder
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                result.addFirst(node.val);
                p = node.left;   
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //   3
        //  / \
        // 1   2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        List<Integer> postOrder = new PostorderTraversal().postorderTraversal(root);
        List<Integer> preOrder = new PostorderTraversal().preorderTraversal(root);
        List<Integer> inOrder = new PostorderTraversal().inorderTraversal(root);
        List<Integer> inOrder2 = new PostorderTraversal().inorderTraversal2(root);
        System.out.println("[info] postOrder" + postOrder);
        System.out.println("[info] preOrder " + preOrder);
        System.out.println("[info] inOrder " + inOrder);
        System.out.println("[info] inOrder2 " + inOrder2);
    }



}
