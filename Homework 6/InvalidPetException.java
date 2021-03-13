public class InvalidPetException {
    /**
     *
     
    private static final long serialVersionUID = 1L;
    */
    public InvalidPetException() {
        System.out.println("Your pet is invalid!");
    }

    public InvalidPetException(String s) {
        System.out.println(s);
    }
}
