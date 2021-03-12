public class LinkedListDriver<T extends Node<T>> {
    public static void main(String[] args) {
        LinkedList<String> favSongs = new LinkedList<>();
        favSongs.addAtIndex("Teste 0", 0);
        System.out.println(favSongs.toString());
        favSongs.addToFront("Teste 1");
        System.out.println(favSongs.toString());
        favSongs.addAtIndex("Teste 2", 0);
        System.out.println(favSongs.toString());
        favSongs.addAtIndex("Teste 3", 1);
        System.out.println(favSongs.toString());
        favSongs.addAtIndex("Teste 4", 2);
        System.out.println(favSongs.toString());
        System.out.println(favSongs.remove("Teste 4"));
        System.out.println(favSongs.toString());
        System.out.println(favSongs.removeAtIndex(0));
        System.out.println(favSongs.getAtIndex(0));
        System.out.println(favSongs.toString());
        System.out.println(favSongs.isEmpty());
        System.out.println(favSongs.toString());
        System.out.println(favSongs.size());
        System.out.println(favSongs.toString());
        favSongs.clear();
        System.out.println(favSongs.isEmpty());
    }
}
