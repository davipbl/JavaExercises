public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        super(name, 15);
        this.numTasks = 6;
        this.taskSpeed = 10;
    }

    public void emergencyMeeting() {
        if (this.isFrozen()) {
            return;
        }
        else {
            Player[] list = getPlayers();
            int maxSusLevel = 0;
            int count = 0;

            for (Player e : list) {
                if (e.isFrozen()) {
                    continue;
                }
                if (e.getSusLevel() == maxSusLevel) {
                    count++;
                } 
                if (e.getSusLevel() > maxSusLevel) {
                    maxSusLevel = e.getSusLevel();
                    count = 1;
                }
            }
            if (count > 1) {
                return;
            }

            for (Player e : list) {
                if (e.getSusLevel() == maxSusLevel) {
                    e.setFrozen(true);
                }
            }

            this.gameOver();

            return;
        }
    }
    public void completeTask() {
        if (this.isFrozen()) {
            return;
        }
        if (this.getTaskSpeed() > 20) {
            this.setNumTasks(this.getNumTasks() - 2);
        }
        else {
            this.setNumTasks(this.getNumTasks() - 1);
        }
        if (this.getNumTasks() < 0) {
            this.setNumTasks(0);
        }
        if (this.getNumTasks() == 0) {
            System.out.println("I have completed all my tasks!");
            this.setSusLevel((int)(getSusLevel() * 0.5));
        }

        return;
    }

    public boolean equal(Object o) {
        if (o instanceof Player) {
            Player player = (Player) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen() && this.getSusLevel() == player.getSusLevel();
        }
        return false;
    }

    public String toString() {
        String frozenString = this.isFrozen() ? "frozen" : "not frozen";
        if (this.getSusLevel() < 15) {
            return "My name is " + this.getName() + ", and I have a susLevel of " + this.getSusLevel() + ". I am currently " + frozenString + ".";
        }
        else {
            return ("My name is " + this.getName() + ", and I have a susLevel of " + this.getSusLevel() + ". I am currently " + frozenString + ".").toUpperCase();
        }
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setTaskSpeed(int taskSpeed) {
        this.taskSpeed = taskSpeed;
    }

    
    
    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }
    

}
