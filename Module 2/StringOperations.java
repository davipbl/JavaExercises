public class StringOperations {
    public static void main(String[] args) {
        String name = new String("Davi");
        System.out.println(name);
        String newName = name.replace(name.charAt(0), 'A');
        newName = newName.replace(name.charAt(name.length() - 1), 'z');
        System.out.println(newName);
        String url = "www.edx.com";
        System.out.println(url);
        String suburl1 = url.substring(0,4);
        String suburl2 = url.substring(4,7) + "1331";
        String suburl3 = url.substring(7,url.length());
        System.out.println(suburl1 + suburl2 + suburl3);
    }
}
