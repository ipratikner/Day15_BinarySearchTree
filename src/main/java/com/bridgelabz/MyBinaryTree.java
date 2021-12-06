package com.bridgelabz;

public class MyBinaryTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add(K key){
        this.root = this.addRecursive(root,key);
    }

    private MyBinaryNode<K> addRecursive(MyBinaryNode<K> current,K key){
        if(current == null)
            return new MyBinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if(compareResult == 0) return current;
        if(compareResult < 0) {
            current.left = addRecursive(current.left, key);
        }else {
            current.right = addRecursive(current.right,key);
        }
        return current;
    }

    public int getSize(){
        return this.getSizeRecursive(root);
    }

    public int getSizeRecursive(MyBinaryNode<K> current){
        return current == null ? 0 : 1 + this.getSizeRecursive(current.left)
                + this.getSizeRecursive(current.right);
    }

    public Boolean search(K key) {
        MyBinaryNode current =  searchRecursive(root,key);
        if(key.equals(current.key))
            return true;
        else
            return false;
    }

    private MyBinaryNode<K> searchRecursive(MyBinaryNode current, K key) {
        while (current.key != key) {
            int compareResult = key.compareTo((K) current.key);
            if (compareResult == 0)
                return current;
            else if (compareResult < 0)
                current = current.left;
            else
                current = current.right;
        }
        return current;
    }
}
