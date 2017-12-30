package com.example.mypackage;

/**
 * Created by aditc on 18-12-2017.
 */
public class MyLinkedList implements INodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root==null){
            //The list was empty, so this item becomes the head
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem!=null){
            int comparision = (currentItem.compareTo(newItem));
            if(comparision < 0){
                //new Item is greater, move right if possible
                if(currentItem.next()!=null){
                    currentItem = currentItem.next();
                }else{
                    //there is no next, so insert at the end of the list
                    currentItem.setNext(newItem); // or we can write in shortcut currentItem.setNext(newItem).setPrevious(currentItem);
                   //this is because setNext() and setPrevious() return the item which can help us shorten the code
                    newItem.setPrevious(currentItem);
                    return true;
                }
            }else if(comparision>0){
                //newItem is less, insert before
                if(currentItem.previous()!=null){
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    currentItem.setPrevious(newItem).setNext(currentItem);
                    return true;



                }else{
                    //The node without the previous is a root
                    newItem.setNext(this.root).setPrevious(newItem); //newItem.setNext(this.root) returns this.root and so we can cascade the setPrevious() method onto that

                    this.root = newItem;
                    return true;

                }
            }else{
                //equal
                System.out.println(newItem.getValue() + " is already present, not added");
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {

        if(item!=null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while(currentItem!=null){
            int comparision = currentItem.compareTo(item);
            if(comparision==0){
                //found the item to delete
                if(currentItem == this.root){
                    this.root = currentItem.next();
                }else{
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next()!=null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if(comparision<0){
                currentItem = currentItem.next();
            }else{
                //comparision>0
                //we are at an item greater than the one to be deleted
                //so the item is not in the list
                return false;
            }
        }

        //We have reached the end of the list without finding the item to delete

        return false;

    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }

        }

//        //recursive way
//        if(root!=null){
//            System.out.println(root.getValue());
//            traverse(root.next());
//        }
        //it's not a good idea to use recursive way to write traversal for linked list because of the depth of the recursive methods
        //it's good in binary tree as the depth is less
        //therefore it can cause stack crash in linked list if there are billions and billions of entries


    }




}



