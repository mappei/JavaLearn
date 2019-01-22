package tree;

import java.util.TreeMap;

/**
 * 双亲表示法：data-parent
 * 孩子表示法：头结点形成数组，子节点形成以头结点为首的链表
 * 孩子双亲表示法：将以上两种结构合并，在头结点后加如parent引用
 * 孩子兄弟表示法：data-firstchild-rightbro  --- 引出二叉树
 *
 * 哈弗曼树
 * 链表存储：leftChild-data-rightChild --- 二叉链表
 * 数组存储 --- 比较适用于完全二叉树，否则浪费空间
 */
public class BuildTree {

    public static void main(String[] args) {
    }


}
