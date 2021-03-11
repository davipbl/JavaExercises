public class RedAstronaut extends Player implements Impostor {
    
    private String skill;

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name) {
        super(name, 15);
        skill = "experienced";
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

    public void freeze(Player p) {
        if (this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }
        else {
            if (this.compareTo(p) > 0) {
                p.setFrozen(true);
            }
            else {
                this.setSusLevel(this.getSusLevel() * 2);
            }
        }
        
        this.gameOver();
        return;
    }

    public void sabotage(Player p) {
        if (this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }

        if (this.getSusLevel() < 20) {
            p.setSusLevel((int)(p.getSusLevel() * 1.5));
        }
        else {
            p.setSusLevel((int)(p.getSusLevel() * 1.25));
        }
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
            return "My name is " + this.getName() + ", and I have a susLevel of " + this.getSusLevel() + ". I am currently " + frozenString + "." + " I am an " + skill + " player!";
        }
        else {
            return ("My name is " + this.getName() + ", and I have a susLevel of " + this.getSusLevel() + ". I am currently " + frozenString + "." + " I am an " + skill + " player!").toUpperCase();
        }
    }

}
