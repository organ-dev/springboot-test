package com.example.utils;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.security.Key;

/**
 * @Auther: ld
 * @Date: 2018/10/9 11:41
 * @Description:
 */
public class Node {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;//二叉查找树的根节点
    private Key key;//键
    private Value value;//值
    private Node left, right;//指向子树的链接:左子树和右子树.
    private int N;//以该节点为根的子树中的结点总数
    boolean color;//由其父结点指向它的链接的颜色也就是结点颜色.

    public Node(Key key, Value value, int N, boolean color) {
        this.key = key;
        this.value = value;
        this.N = N;
        this.color = color;
    }

    /**
     * 获取整个二叉查找树的大小
     * @return
     */
    public int size(){
        return size(root);
    }
    /**
     * 获取某一个结点为根结点的二叉查找树的大小
     * @param x
     * @return
     */
    private int size(Node x){
        if(x == null){
            return 0;
        } else {
            return x.N;
        }
    }
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }
}
