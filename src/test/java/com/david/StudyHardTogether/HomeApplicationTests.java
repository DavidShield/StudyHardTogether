package com.david.StudyHardTogether;

import com.david.StudyHardTogether.BowlingGame.BowlingGame;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HomeApplicationTests {

	@Autowired
	BowlingGame game;

	@Test
	void contextLoads() throws Exception{
		assertThat(game).isNotNull();
	}

	@Test
	void testScore() throws Exception{
		game.throwTheBall(BowlingGame.STRIKE);
		assertThat(game.getInTimeScore()).isEqualTo(10);

		game.throwTheBall(7);
		game.throwTheBall(BowlingGame.SPARE);
		assertThat(game.getInTimeScore()).isEqualTo(30);

		game.throwTheBall(9);
		game.throwTheBall(BowlingGame.MISS);
		assertThat(game.getInTimeScore()).isEqualTo(48);

		game.throwTheBall(BowlingGame.STRIKE);
		assertThat(game.getInTimeScore()).isEqualTo(58);

		game.throwTheBall(BowlingGame.MISS);
		game.throwTheBall(8);
		assertThat(game.getInTimeScore()).isEqualTo(74);

		game.throwTheBall(8);
		game.throwTheBall(BowlingGame.SPARE);
		assertThat(game.getInTimeScore()).isEqualTo(84);

		game.throwTheBall(BowlingGame.MISS);
		game.throwTheBall(6);
		assertThat(game.getInTimeScore()).isEqualTo(90);

		game.throwTheBall(BowlingGame.STRIKE);
		assertThat(game.getInTimeScore()).isEqualTo(100);

		game.throwTheBall(BowlingGame.STRIKE);
		assertThat(game.getInTimeScore()).isEqualTo(120);

		game.throwTheBall(BowlingGame.STRIKE);
		assertThat(game.getInTimeScore()).isEqualTo(150);

		game.throwTheBall(8);
		assertThat(game.getInTimeScore()).isEqualTo(166);

		game.throwTheBall(1);
		assertThat(game.getInTimeScore()).isEqualTo(167);
	}
}
