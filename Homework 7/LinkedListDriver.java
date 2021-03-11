public class LinkedListDriver<T extends Node<T>> {
    public static void main(String[] args) {
        LinkedList<String> favSongs = new LinkedList<>();
        favSongs.addAtIndex("Teste 0", 0);
        System.out.println(favSongs.getAtIndex(0));
        favSongs.addAtIndex("Teste 1", 1);
        favSongs.addAtIndex("Teste 2", 2);
        favSongs.addAtIndex("Teste 3", 3);
        favSongs.addAtIndex("Teste 4", 2);
        System.out.println(favSongs.remove("Teste 3"));
        System.out.println(favSongs.removeAtIndex(2));
        System.out.println(favSongs.isEmpty());
        System.out.println(favSongs.size());
        favSongs.clear();
        System.out.println(favSongs.isEmpty());
    }
}
