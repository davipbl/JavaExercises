public class Dog extends Pet {
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        }
        else {
            this.droolRate = droolRate;
        }
    }

    public Dog(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.droolRate = 5.0;
    }

    public double getDroolRate() {
        return this.droolRate;
    }

    public int treat() {
        this.heal();
        if (this.getDroolRate() < 3.5) {
            return (int)Math.ceil(this.getPainLevel() * 2 / this.getHealth()); 
        }
        else if (this.getDroolRate() <= 7.5) {
            return (int)Math.ceil(this.getPainLevel() / this.getHealth());
        }
        else {
            return (int)Math.ceil(this.getPainLevel() / (this.getHealth() * 2));
        }
    }

    public void speak() {
        super.speak();
        for (int i = 0; i < this.getPainLevel(); i++) {
            if (this.getPainLevel() > 5) {
                System.out.print(("bark ").toUpperCase());
            }
            else {
                System.out.print("bark ");
            }
        }
        System.out.println();
    }

    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet animal = (Pet) o;
            return this.getName().equals(animal.getName()) && this.getDroolRate().equals(animal.getDroolRate());
        }
        return false;
    }
}
