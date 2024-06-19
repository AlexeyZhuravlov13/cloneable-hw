package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void shouldClone() {
        TreeNode treeNode1 = new TreeNode(123);
        TreeNode treeNode2 = new TreeNode(124);
        TreeNode treeNode3 = new TreeNode(125);
        TreeNode treeNode4 = new TreeNode(126);

        TreeNode[] children = {treeNode2, treeNode3};
        treeNode1.setChildren(children);
        treeNode2.setChildren(new TreeNode[]{treeNode4});
        treeNode4.setChildren(new TreeNode[]{treeNode1});


        TreeNode clone = treeNode1.clone();
        TreeNode[] cloneChildren = clone.getChildren();
        for (int i = 0; i < cloneChildren.length; i++) {
            checkClone(children[i], cloneChildren[i]);
        }
        TreeNode clone4 = cloneChildren[0].getChildren()[0];
        checkClone(clone4, treeNode4);
        checkClone(clone4.getChildren()[0], treeNode1);
    }

    private static void checkClone(TreeNode clone4, TreeNode treeNode4) {
        assertEquals(clone4, treeNode4);
        assertNotSame(clone4, treeNode4);
    }

}