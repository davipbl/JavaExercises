public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    protected String species = "Rare Pepe";

    public Frog(String initName, int initAge, double initTongueSpeed) {
        name = initName;
        age = initAge;
        tongueSpeed = initTongueSpeed;
        if (age < 7) {
            isFroglet = true;
        }
        else {
            isFroglet = false;
        }
    }

    public Frog(String initName, double ageInYear, double initTongueSpeed) {
        name = initName;
        age = (int)(ageInYear * 12);
        tongueSpeed = initTongueSpeed;
        if (age < 7) {
            isFroglet = true;
        }
        else {
            isFroglet = false;
        }
    }

    public Frog(String initName) {
        name = initName;
        age = 5;
        tongueSpeed = 5;
        isFroglet = true;
    }

    public void grow(int months) {
        int count = months;
        while (count > 0 & age < 12) {
            age++;
            tongueSpeed++;
            count--;
        }
        if (count > 0) {
            age += count;
            count = 0; 
        }
        
        if (age > 30) {
            tongueSpeed = tongueSpeed - 1 * (age - 30);
        }
        if (tongueSpeed < 5) {
            tongueSpeed = 5;
        }
        if (age >= 1 & age < 7) {
            isFroglet = true;
        }
        else {
            isFroglet = false;
        }
    }

    public void grow() {
        grow(1);
    }

    public void eat(Fly specimen) {
        if (specimen.isDead()) {
            return;
        }
        if (tongueSpeed > specimen.getSpeed()) {
            if (specimen.getMass() > age / 2) {
                grow();
                specimen.setMass(0);
            }
        }
        else {
            specimen.grow(1);
        }
    }

    public String toString() {
        if (isFroglet) {
            return "My name is " + name + " and I'm a rare froglet! I'm " + age + " months old and my tongue has a speed of " + tongueSpeed + ".";
        }
        else {
            return "My name is " + name + " and I'm a rare frog. I'm " + age + " months old and my tongue has a speed of " + tongueSpeed + ".";
        }
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String newSpecies) {
        species = newSpecies;
    }

}
