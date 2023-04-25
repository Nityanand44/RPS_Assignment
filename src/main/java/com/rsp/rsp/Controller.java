package com.rsp.rsp;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    
    private Random random = new Random();
    private String[] moves = {"Rock", "Paper", "Scissors"};

    String generateRandomMove() {
        int moveIndex = random.nextInt(3);
        return moves[moveIndex];
    }

    String evaluateWinner(String move1, String move2) {
        if (move1.equals(move2)) {
            return "It is a tie";
        } else if ((move1.equals("Rock") && move2.equals("Scissors")) ||
                   (move1.equals("Scissors") && move2.equals("Paper")) ||
                   (move1.equals("Paper") && move2.equals("Rock"))) {
            return "Player wins";
        } else {
            return "Computer wins";
        }
    }



        @RequestMapping("/play")
public String playGame(@RequestParam("move") String playerMove) {
    logger.info("Received player move: {}", playerMove);
    String computerMove = generateRandomMove();
    logger.info("Generated computer move: {}", computerMove);
    String result = evaluateWinner(playerMove, computerMove);
    logger.info("Game result: {}", result);
    return result;
}

    }





