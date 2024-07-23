/*
----------------------------------------------------------------------------------------------------------
    Name:		BTNode
    Authors:	Ollie Peel, Rawan Alhachami
    Language:	Java
    Date:		2024-07-22
    Purpose:	The purpose of this program is to lay the framework for a binary tree node which can be
    used to build binary trees.
----------------------------------------------------------------------------------------------------------
    Change Log
----------------------------------------------------------------------------------------------------------
    Who		Date		Reason
    OSP		2024-07-22	Original Version of Code
----------------------------------------------------------------------------------------------------------
*/
public class BTNode<T> {
    public T data; // Stores data for node
    public BTNode<T> left, right; // Stores references to node's left and right children
    // Constructors
    public BTNode(T data){ this.data = data; }
    public BTNode(T data, BTNode<T> left, BTNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
