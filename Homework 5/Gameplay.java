public class Gameplay {
    public static void main(String[] args) {
        /*Why couldn't I implement as a more general class?*/BlueAstronaut player1 = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut player2 = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut player3 = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut player4 = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut player5 = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut player6 = new RedAstronaut("Suspicious Person", 100, "expert");

        player5.sabotage(player1);
        System.out.println(player1.toString());
        player5.freeze(player6);
        System.out.println(player6.toString());
        player5.freeze(player3);
        System.out.println(player3.toString());
        System.out.println(player5.toString());
        player3.emergencyMeeting();
        player6.emergencyMeeting();
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        player1.emergencyMeeting();
        System.out.println(player6.toString());
        player2.completeTask();
        System.out.println(player2.toString());
        player2.completeTask();
        System.out.println(player2.toString());
        player2.completeTask();
        System.out.println(player2.toString());
        player5.freeze(player3);
        System.out.println(player3.toString());
        System.out.println(player5.toString());
        player5.sabotage(player1);
        System.out.println(player1.toString());
        player5.sabotage(player1);
        System.out.println(player1.toString());
        player5.freeze(player1);
        System.out.println(player1.toString());
        player4.emergencyMeeting();
    }
}