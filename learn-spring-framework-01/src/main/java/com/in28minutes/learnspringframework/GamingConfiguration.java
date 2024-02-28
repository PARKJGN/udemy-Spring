package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        System.out.println("aa");
        return new PacmanGame();
    }

    @Bean
    public GameRunner gameRunner(){
        System.out.println("bb");
        return new GameRunner(game());
    }

}
