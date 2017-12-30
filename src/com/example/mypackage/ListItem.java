package com.example.mypackage;

/**
 * Created by aditc on 18-12-2017.
 */



/*

ACCESS MODIFIERS
            | Class | Package | Subclass | Subclass | World
            |       |         |(same pkg)|(diff pkg)|
————————————-———————-—————————-——————————+——————————+————————
public      |   +   |    +    |    +     |     +    |   +
————————————-———————-—————————-——————————+——————————+————————
protected   |   +   |    +    |    +     |     +    |
————————————-———————-—————————-——————————+——————————+————————
no modifier |   +   |    +    |    +     |          |
————————————-———————-—————————-——————————+——————————+————————
private     |   +   |         |          |          |

+ : accessible
blank : not accessible

*/

public abstract class ListItem {
    protected ListItem rightLink = null; //instances of the a class within a class
    protected  ListItem leftLink = null; //we've made these protected instead of default private so that even the subclasses of
    //other packages could access these

    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }


    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);


    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
