package org.pursuit;


public class Build_a_Hero implements Game {

    private void logo() {
        System.out.println("  __ )         _)  |      |     \\ \\   /                        |   |                    | \n" +
                "  __ \\   |   |  |  |   _` |      \\   /  _ \\   |   |   __|      |   |   _ \\   __|  _ \\   | \n" +
                "  |   |  |   |  |  |  (   |         |  (   |  |   |  |         ___ |   __/  |    (   | _| \n" +
                " ____/  \\__,_| _| _| \\__,_|        _| \\___/  \\__,_| _|        _|  _| \\___| _|   \\___/  _) \n" +
                "                                                                                          \n");
    }

    private void instructions() {
        System.out.println("You will be building a character that is either a Hero, Anti-Hero, or Villain based on your choices. \n");
    }

    @Override
    public void startGame() {
        logo();
        instructions();
    }

}

