/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode s;
    String ans="";
    int len = 100000;
    private boolean find(TreeNode r, int st){
        if(r==null) return false;
        if(r.val==st){
            s = r;
            return true;
        }
        return find(r.left,st) || find(r.right,st);
    }
    private void findParent(TreeNode root, Map<TreeNode,TreeNode> parent){
        if(root==null) return;
        if(root.left!=null) parent.put(root.left,root);
        if(root.right!=null) parent.put(root.right,root);
        findParent(root.left,parent);
        findParent(root.right,parent);
    }
    private void findPath(TreeNode root, Map<TreeNode,TreeNode> parent, StringBuilder s,int dest,Set<TreeNode> st){
        if(root==null) return;
        if(root.val==dest){
            if(s.length()<len){
                ans =s.toString();
                len = ans.length();
            }
            return;
        }
        if(parent.get(root)!=null&& !st.contains(parent.get(root))){
            st.add(parent.get(root));
            findPath(parent.get(root),parent,s.append("U"),dest,st);
            s.deleteCharAt(s.length()-1);

        }
        if(root.left!=null && !st.contains(root.left)) {
            st.add(root.left);
            findPath(root.left,parent,s.append("L"),dest,st);
            s.deleteCharAt(s.length()-1);
            }
        if(root.right!=null && !st.contains(root.right)) {
            st.add(root.right);
            findPath(root.right,parent,s.append("R"),dest,st);
            s.deleteCharAt(s.length()-1);
            }
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        find(root,startValue);
        parent.put(root,null);
        findParent(root,parent);
        Set<TreeNode> st = new HashSet<>();
        st.add(s);
        findPath(s,parent,new StringBuilder(),destValue,st);
        return ans;
    }
}