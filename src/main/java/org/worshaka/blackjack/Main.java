package org.worshaka.blackjack;

import org.worshaka.blackjack.core.BlackJackGame;
import org.worshaka.blackjack.ui.BlackJackConsoleUI;
import org.worshaka.blackjack.ui.BlackJackUI;

public class Main {

    private BlackJackUI ui = new BlackJackConsoleUI();
    private BlackJackGame blackJackGame = new BlackJackGame(ui);

    public static void main(String[] args) {
	    Main main = new Main();
	    main.run();
    }

    private void run() {
        blackJackGame.initGame();
        blackJackGame.run();

    }
}
