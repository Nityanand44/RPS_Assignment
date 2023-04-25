package com.rsp.rsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest


public class RspApplicationTests {
    
    private Controller controller = new Controller();
    @Test
    public void testGenerateRandomMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String randomMove = controller.generateRandomMove();
        assertTrue(Arrays.asList(moves).contains(randomMove));
    }
	@Test
    public void testPlayGame() {
        String result = controller.playGame("Rock");
        assertTrue(result.equals("Player wins") || result.equals("Computer wins") || result.equals("It is a tie"));
    }
    @Test
    public void testEvaluateWinner_PlayerWins() {
        String result = controller.evaluateWinner("Rock", "Scissors");
        assertEquals("Player wins", result);
    }
    
    @Test
    public void testEvaluateWinner_ComputerWins() {
        String result = controller.evaluateWinner("Rock", "Paper");
        assertEquals("Computer wins", result);
    }
    
    @Test
    public void testEvaluateWinner_Tie() {
        String result = controller.evaluateWinner("Rock", "Rock");
        assertEquals("It is a tie", result);
    }
}



