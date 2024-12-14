package Tree;

import helper.TreeNode;
import jdk.internal.net.http.common.Pair;

import java.util.*;

/**
 * 314. Binary Tree Vertical Order Traversal
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/editorial/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 */
public class BinaryTreeVerticalOrderTraversal_med {

    Map<Integer, List<Pair<Integer, Integer>>> sortedNodes = new HashMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        } else{
            rec(root, 0,0);
            Object[] keys = sortedNodes.keySet().toArray();
            Arrays.sort(keys);
            List<List<Integer>> res = new ArrayList<>();
            for(Object key : keys) {
                Collections.sort(sortedNodes.get(key), (o1, o2) -> (o1.second.compareTo(o2.second)));
                List<Integer> res1 = sortedNodes.get(key).stream().map(pair->pair.first).toList();
                res.add(res1);
            }
            return res;
        }
    }

    public void rec(TreeNode root, int col, int depth) {
        if(root != null) {
            List<Pair<Integer, Integer>> curr = sortedNodes.getOrDefault(col, new ArrayList<>());
            curr.add(new Pair<>(root.getVal(), depth));
            sortedNodes.put(col, curr);
            rec(root.getLeft(), col-1, depth +1);
            rec(root.getRight(), col+1, depth +1);
        }
    }}
