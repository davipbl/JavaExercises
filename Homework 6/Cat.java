public class Cat extends Pet {
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            this.miceCaught = 0;
        }
        else {
            this.miceCaught = miceCaught;
        }
    }

    public Cat(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.miceCaught = 0;
    }

    public int getMiceCaught() {
        return this.miceCaught;
    }

    public int treat() {
        this.heal();
        if (this.getMiceCaught() < 4) {
            return (int)Math.ceil(this.getPainLevel() * 2 / this.getHealth()); 
        }
        else if (this.getMiceCaught() <= 7) {
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
                System.out.print(("meow ").toUpperCase());
            }
            else {
                System.out.print("meow ");
            }
        }
        System.out.println();
    }

    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet animal = (Pet) o;
            return this.getName().equals(animal.getName()) && this.getMiceCaught().equals(animal.getMiceCaught());
        }
        return false;
    }
}
