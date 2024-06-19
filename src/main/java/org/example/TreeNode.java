package org.example;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
2)  Клонирование объектов с циклическими зависимостями:
   - Создайте класс TreeNode для представления узлов дерева с потомками типа TreeNode.
   - Реализуйте клонирование TreeNode, где каждый узел может иметь несколько потомков.
   - Проверьте, что клонирование корректно обрабатывает циклические зависимости между узлами дерева.
Шаблон кода
 */
public class TreeNode implements Cloneable {
    private final int value;
    private TreeNode[] children;

    public TreeNode(int value) {
        this.value = value;
    }

    public void setChildren(TreeNode[] children) {
        this.children = children;
    }

    public int getValue() {
        return value;
    }

    public TreeNode[] getChildren() {
        return children;
    }

    @Override
    public TreeNode clone() {
        Map<TreeNode, TreeNode> clonedNodes = new HashMap<>();
        return cloneHelper(this, clonedNodes);
    }

    private TreeNode cloneHelper(TreeNode node, Map<TreeNode, TreeNode> clonedNodes) {
        if (node == null) {
            return null;
        }

        // If the node has already been cloned, return its clone
        if (clonedNodes.containsKey(node)) {
            return clonedNodes.get(node);
        }

        // Create a new clone of the current node
        TreeNode clonedNode = new TreeNode(node.value);
        clonedNodes.put(node, clonedNode); // Add to map before cloning children

        // Clone children recursively
        if (node.children != null) {
            clonedNode.children = new TreeNode[node.children.length];
            for (int i = 0; i < node.children.length; i++) {
                clonedNode.children[i] = cloneHelper(node.children[i], clonedNodes);
            }
        }

        return clonedNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}