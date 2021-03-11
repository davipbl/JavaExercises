public class Fly {
    private double mass;
    private double speed;

    public Fly(double initMass, double initSpeed) {
        mass = initMass;
        speed = initSpeed;
    }

    public Fly(double initMass) {
        mass = initMass;
        speed = 10;
    }

    public Fly() {
        mass = 5;
        speed = 10;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double currMass) {
        mass = currMass;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double currSpeed) {
        speed = currSpeed;
    }

    public String toString() {
        if (mass == 0) {
            return "I'm dead, but I used to fly with a speed of " + speed;
        }
        return "I'm a speedy fly with " + speed + " speed and " + mass + " mass.";
    }

    public void grow(int addedMass) {
        mass = mass + (double)addedMass;
        if (mass < 20) {
            speed = speed + 1 * addedMass;
        }
        if (mass > 20) {
            speed = speed - 0.5 * (mass - 20);
        }
    }

    public boolean isDead() {
        if (mass <= 0) {
            return true;
        }
        else return false;
    }
}
