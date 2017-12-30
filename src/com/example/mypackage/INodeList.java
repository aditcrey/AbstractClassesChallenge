package com.example.mypackage;

/**
 * Created by aditc on 18-12-2017.
 */
public interface INodeList {

    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root); //"head" in case of a linkedList
}
