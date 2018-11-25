package 集合和映射;

public class Main {
    public static void main(String[] args) {
//        BstSet<Integer> bstSet = new BstSet<>();
//        bstSet.add(10);
//        bstSet.add(10);
//        bstSet.printData();
//        LinkListSet<Integer> linkListSet = new LinkListSet<>();
//        linkListSet.add(20);
//        linkListSet.add(20);
//        linkListSet.printData();

//        LinkedListMap<String,String> linkedListMap = new LinkedListMap<>();
//        linkedListMap.add("1","apple");
//        linkedListMap.add("2","monkey");
//        linkedListMap.add("3","cat");
//        linkedListMap.add("4","dog");
//        linkedListMap.printData();
//        linkedListMap.remove("4");
//        linkedListMap.printData();

        BSTMap<String,String> bstMap = new BSTMap();
        bstMap.add("1","cat");
        bstMap.add("2","dog");
        bstMap.add("3","cat1");
        bstMap.add("4","dog1");
        bstMap.printData();
        bstMap.remove("1");
        bstMap.printData();
    }
}
