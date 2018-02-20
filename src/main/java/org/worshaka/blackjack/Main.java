package org.worshaka.blackjack;

import org.worshaka.blackjack.core.BlackJackGame;
import org.worshaka.blackjack.ui.BlackJackConsoleUI;

public class Main {

    public static void main(String[] args) {
	    Main main = new Main();
	    main.run();
    }

    private void run() {
        Thread thread = new Thread(new BlackJackGame(new BlackJackConsoleUI()));
        thread.start();
    }
}
