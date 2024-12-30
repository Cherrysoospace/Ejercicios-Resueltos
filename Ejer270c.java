public class Ejer270c extends Terminal {
    public static void main(String[] args) {
        var bOrder = "";
        var dice = 0;
        var hUser = "Mango";
        var cUser = "Rocket V";
        var squareBox = 0;
        var userCounter = 1;
        var squareboxCA = 1;
        var squareboxHA = 1;

        // La condicion del if debe de ser la misma que la del while, sino, da error en
        // la ejecucion,
        // no sintaxis.

        do {
            writeLine("Press ENTER.");
            bOrder = scanLine().trim();

            if (!(bOrder.isBlank())) {
                writeLine("Try again.");
            }
        } while (!(bOrder.isBlank()));

        writeLine("Game start!");

        do {
            userCounter = 1;
            do {
                if (userCounter == 1) {
                    writeLine("Turn of %s", hUser);
                    do {
                        writeLine("Press ENTER.");
                        bOrder = scanLine();

                        if (!(bOrder.isBlank())) {
                            writeLine("Try again.");
                        }
                    } while (!(bOrder.isBlank()));

                    dice = (int) (1 + Math.random() * 6);
                    writeLine(dice);
                    if ((squareboxHA+dice) <= 100) {
                        squareboxHA = squareboxHA + dice;
                    }
                    squareBox = squareboxHA;
                } else {
                    writeLine("Turn of %s", cUser);
                    dice = (int) (1 + Math.random() * 6);
                    writeLine(dice);
                    if ((squareboxCA+dice) <= 100) {
                        squareboxCA = squareboxCA + dice;
                    }
                    squareBox = squareboxCA;
                }

                // culebras
                if (((squareBox == 95) || (squareBox == 89) || (squareBox == 52) || (squareBox == 23))) {
                    squareBox = squareBox - 21;
                }

                else if ((squareBox == 62) || (squareBox == 34)) {
                    squareBox = squareBox - 19;
                }

                // Treppesch

                if ((squareBox == 35) || (squareBox == 80)) {
                    squareBox = squareBox + 19;
                }

                else if (squareBox == 10) {
                    squareBox = squareBox + 23;
                }

                else if (squareBox == 16) {
                    squareBox = squareBox + 21;
                }

                else if (squareBox == 21) {
                    squareBox = squareBox + 20;
                }

                else if (squareBox == 44) {
                    squareBox = squareBox + 32;
                }

                if (userCounter == 1) {
                    squareboxHA = squareBox;
                } else {
                    squareboxCA = squareBox;
                }

                userCounter = userCounter + 1;
            } while (userCounter <= 2);

            writeLine("Square box Human: %d Computer: %d", squareboxHA, squareboxCA);
        } while ((squareboxHA < 100 && squareboxCA < 100));

        if (squareboxCA == 100 && squareboxHA == 100) {
            writeLine("The game is a draw!");
        } else if (squareboxCA >= 100) {
            writeLine("%s WIN", cUser);
        } else if (squareboxCA == 100 && squareboxHA == 100) {
            writeLine("The game is a draw!");
        }
        writeLine("Endgame. Thanks for playing! :D");

    }

}
