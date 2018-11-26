package AVL的Set和Map;

public class Main {
    public static void main(String[] args) {
        AVLMap<Integer,String> avlMap = new AVLMap<>();
        avlMap.add(1,"cat");
        avlMap.add(2,"dog");
        avlMap.add(2,"cat");
        avlMap.printData();

        AVLSet<Integer> avlSet = new AVLSet<>();
        avlSet.add(13);
        avlSet.add(10);
        avlSet.add(10);
        avlSet.printData();
    }
}
