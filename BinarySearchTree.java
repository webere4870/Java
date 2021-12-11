/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceenvironment;



// This class is private
class TreeNode<T extends Comparable<T>>
{
    
    
    // Each node links to two other nodes
    T data;
    TreeNode<T> leftNode;
    TreeNode<T> rightNode;
    
    
    
    // Initialize the data and branches to empty
    public TreeNode(T data)
    {
        this.data = data;
        this.leftNode = this.rightNode = null;
    }
    
    
    
    
    // Inserts a new node into the data
    public void insert(T newNode)
    {
        
        
        
        // If the value is less than the node value
        if(newNode.compareTo(data) < 0)
        {
            if(this.leftNode == null)
            {
                this.leftNode = new TreeNode(newNode);
            }
            else
            {
                // Will recursively iterate until it's proper
                // location has been found
                leftNode.insert(newNode);
            }
        }
        
        
        
        // If the node is greater than the node value
        else if(newNode.compareTo(data) > 0)
        {
            
            // Makes the node if there are no branches
            if(this.rightNode == null)
            {
                this.rightNode = new TreeNode(newNode);
            }
            // Iterates recursively until
            // proper location is found
            else
            {
                rightNode.insert(newNode);
            }
        }
    }
    
    
    // Only necessary when using private nodes
    public T getData()
    {
        return this.data;
    }
    
    
}



// This is the class that is used by the public
// The other class is outside of the user's viewing
public class BinarySearchTree<T extends Comparable<T>> {
    
    // This is the root node that gives us a starting point for linking to the other nodes
    private TreeNode<T> root;
    
    
    
    public BinarySearchTree()
    {
        this.root = null;
    }
    
    
    
    // Create the root if it doesn't exist
    // Else, iterate through the binary tree using 
    // the class above until proper location is found
    public void insertNode(T data)
    {
        if(this.root == null)
        {
            this.root = new TreeNode(data);
        }
        else
        {
            root.insert(data);
        }
    }
    
    
    
    // NOTE: these public functions allow you to start the recursion
    // with the root node, and is only used once.
    // All recursion takes place in the helper functions
    public void printUnordered()
    {
        this.printUnorderedHelper(root);
    }
    
    // By printing before recursion, each value is printed
    // as soon as it is reached
    private void printUnorderedHelper(TreeNode<T> node)
    {
        if(node == null)
        {
            return;
        }
        System.out.print(node.getData() + "  ");
        this.printUnorderedHelper(node.leftNode);
        this.printUnorderedHelper(node.rightNode);
    }
    
    
    
    
    
    public void printOrdered()
    {
        this.printOrderedHelper(root);
    }
    // By printing after leftNode recursion,
    // you force the compiler to print the smallest values
    // in succession, thus "ordering" the binary tree
    private void printOrderedHelper(TreeNode<T> node)
    {
        if(node == null)
        {
            return;
        }
        this.printOrderedHelper(node.leftNode);
        System.out.print(node.getData() + "  ");
        this.printOrderedHelper(node.rightNode);
    }
    
    
    
    
    
    public void printInverted()
    {
        this.printInvertedHelper(root);
    }
    
    
    // Same concept as the ordered function, except flipping the right and left
    // nodes allows you to sort the data inversely
    private void printInvertedHelper(TreeNode<T> node)
    {
        if(node == null)
        {
            return;
        }
        this.printInvertedHelper(node.rightNode);
        System.out.print(node.getData() + "  ");
        this.printInvertedHelper(node.leftNode);
    }
}
