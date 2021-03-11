public abstract class Pet {
    //Declaring variables
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        if (health > 1.0) {
            this.health = 1.0;
        }
        else if (health < 0.0) {
            this.health = 0.0;
        }
        else {
            this.health = health;
        }
        
        if (painLevel > 10) {
            this.painLevel = 10;
        }
        else if (painLevel < 0.) {
            this.painLevel = 0;
        }
        else {
            this.painLevel = painLevel;
        }
    }

    public String getName() {
        return this.name;
    }

    public double getHealth() {
        return this.health;
    }
    
    public int getPainLevel() {
        return this.painLevel;
    }

    public abstract int treat();

    public void speak() {
        if (this.getPainLevel() > 5) {
            System.out.println(("Hello! My name is " + this.getName()).toUpperCase());    
        }
        System.out.println("Hello! My name is " + this.getName());
    }

    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet animal = (Pet) o;
            return this.getName().equals(animal.getName());
        }
        return false;
    }

    protected heal() {
        this.setHealth(1.0);
        this.setPainLevel(1);
    }
}
