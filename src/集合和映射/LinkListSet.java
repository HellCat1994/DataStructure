package 集合和映射;

import java.util.LinkedList;

public class LinkListSet<T> implements Set<T> {
    private LinkedList<T> linkedList;

    public LinkListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(T e) {
        if(!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(T e) {
        linkedList.remove(e);
    }

    @Override
    public boolean contains(T e) {
        return linkedList.contains(e);
    }

    public void printData(){
        linkedList.forEach((a)-> System.out.println(a+" "));
    }
}
