package com.david.StudyHardTogether.BowlingGame;

import com.david.StudyHardTogether.BowlingGame.BowlingGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BowlingGameController {

    @Autowired
    BowlingGame game;

    @GetMapping("/add")
    public BowlingGame hello(@RequestParam(value = "value", defaultValue = "0") String num) {
        try {
            game.throwTheBall(num);
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
        return game;
    }


    @GetMapping("/restart")
    public String calculate() {
        game = new BowlingGame();
        return "success";
    }
}
