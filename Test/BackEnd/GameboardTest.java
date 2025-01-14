package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static BackEnd.TileType.*;
import static org.junit.jupiter.api.Assertions.*;

class GameboardTest {
	SilkBag sb = new SilkBag(234234234);
	Gameboard gb = new Gameboard(3,3, sb);
	Gameboard gb2 = new Gameboard(3,3, sb);
	Gameboard gb3 = new Gameboard(3,3, sb);
	Gameboard gb4 = new Gameboard(3,3, sb);
	Gameboard gbSlide = new Gameboard(8, 10, sb);

	@BeforeEach
	void setUp() throws Exception {
		sb = new SilkBag(234234234);
		gb = new Gameboard(3, 3, sb);
		gb2 = new Gameboard(3,3, sb);
		gb3 = new Gameboard(3,3, sb);
		gb4 = new Gameboard(3,3, sb);
		gbSlide = new Gameboard(8, 10, sb);
		gb.setPlayerPos(0, new Coordinate(1,1));
		gb.setPlayerPos(1, new Coordinate( 2,1));
		gb.setPlayerPos(2, new Coordinate( 2,2));
		gb.setPlayerPos(3, new Coordinate( 2,0));
		gb2.setPlayerPos(0, new Coordinate(1,1));
		gb2.setPlayerPos(1, new Coordinate( 2,1));
		gb2.setPlayerPos(2, new Coordinate( 2,2));
		gb2.setPlayerPos(3, new Coordinate( 2,0));
		gb3.setPlayerPos(0, new Coordinate(1,1));
		gb3.setPlayerPos(1, new Coordinate( 2,1));
		gb3.setPlayerPos(2, new Coordinate( 2,2));
		gb3.setPlayerPos(3, new Coordinate( 2,0));
		gb4.setPlayerPos(0, new Coordinate(1,1));
		gb4.setPlayerPos(1, new Coordinate( 2,1));
		gb4.setPlayerPos(2, new Coordinate( 2,2));
		gb4.setPlayerPos(3, new Coordinate( 2,0));
		gbSlide.setPlayerPos(0, new Coordinate(1,1));
		gbSlide.setPlayerPos(1, new Coordinate( 2,1));
		gbSlide.setPlayerPos(2, new Coordinate( 2,2));
		gbSlide.setPlayerPos(3, new Coordinate( 2,0));

		//Inserting from the left.
		gb.playFloorTile(new Coordinate(-1, 0), new FloorTile(CORNER));
		gb.playFloorTile(new Coordinate(-1, 0), new FloorTile(T_SHAPE));
		gb.playFloorTile(new Coordinate(-1, 0), new FloorTile(CORNER));
		gb.playFloorTile(new Coordinate(-1, 1), new FloorTile(STRAIGHT));
		gb.playFloorTile(new Coordinate(-1, 1), new FloorTile(GOAL));
		gb.playFloorTile(new Coordinate(-1, 1), new FloorTile(STRAIGHT));
		gb.playFloorTile(new Coordinate(-1, 2), new FloorTile(CORNER));
		gb.playFloorTile(new Coordinate(-1, 2), new FloorTile(T_SHAPE));
		gb.playFloorTile(new Coordinate(-1, 2), new FloorTile(CORNER));
		//Inserting from the right.
		gb2.playFloorTile(new Coordinate(gb2.getWidth(), 0), new FloorTile(CORNER));
		gb2.playFloorTile(new Coordinate(gb2.getWidth(), 0), new FloorTile(T_SHAPE));
		gb2.playFloorTile(new Coordinate(gb2.getWidth(), 0), new FloorTile(CORNER));
		gb2.playFloorTile(new Coordinate(gb2.getWidth(), 1), new FloorTile(STRAIGHT));
		gb2.playFloorTile(new Coordinate(gb2.getWidth(), 1), new FloorTile(GOAL));
		gb2.playFloorTile(new Coordinate(gb2.getWidth(), 1), new FloorTile(STRAIGHT));
		gb2.playFloorTile(new Coordinate(gb2.getWidth(), 2), new FloorTile(CORNER));
		gb2.playFloorTile(new Coordinate(gb2.getWidth(), 2), new FloorTile(T_SHAPE));
		gb2.playFloorTile(new Coordinate(gb2.getWidth(), 2), new FloorTile(CORNER));
		//Inserting from the bottom.
		gb3.playFloorTile(new Coordinate(0, -1), new FloorTile(CORNER));
		gb3.playFloorTile(new Coordinate(0, -1), new FloorTile(T_SHAPE));
		gb3.playFloorTile(new Coordinate(0, -1), new FloorTile(CORNER));
		gb3.playFloorTile(new Coordinate(1, -1), new FloorTile(STRAIGHT));
		gb3.playFloorTile(new Coordinate(1, -1), new FloorTile(GOAL));
		gb3.playFloorTile(new Coordinate(1, -1), new FloorTile(STRAIGHT));
		gb3.playFloorTile(new Coordinate(2, -1), new FloorTile(CORNER));
		gb3.playFloorTile(new Coordinate(2, -1), new FloorTile(T_SHAPE));
		gb3.playFloorTile(new Coordinate(2, -1), new FloorTile(CORNER));
		//Inserting from the top.
		gb4.playFloorTile(new Coordinate(0, gb4.getHeight()), new FloorTile(CORNER));
		gb4.playFloorTile(new Coordinate(0, gb4.getHeight()), new FloorTile(T_SHAPE));
		gb4.playFloorTile(new Coordinate(0, gb4.getHeight()), new FloorTile(CORNER));
		gb4.playFloorTile(new Coordinate(1, gb4.getHeight()), new FloorTile(STRAIGHT));
		gb4.playFloorTile(new Coordinate(1, gb4.getHeight()), new FloorTile(GOAL));
		gb4.playFloorTile(new Coordinate(1, gb4.getHeight()), new FloorTile(STRAIGHT));
		gb4.playFloorTile(new Coordinate(2, gb4.getHeight()), new FloorTile(CORNER));
		gb4.playFloorTile(new Coordinate(2, gb4.getHeight()), new FloorTile(T_SHAPE));
		gb4.playFloorTile(new Coordinate(2, gb4.getHeight()), new FloorTile(CORNER));

		gbSlide.placeFixedTile(new FloorTile(TileType.CORNER, Rotation.LEFT), 4, 5);

		gbSlide.getSlideLocations();

		gbSlide.playFloorTile(new Coordinate(0, 0), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(0, 1), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(0, 2), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(0, 3), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(0, 4), new FloorTile(GOAL));
		gbSlide.playFloorTile(new Coordinate(0, 5), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(0, 6), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(0, 7), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(0, 8), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(0, 9), new FloorTile(CORNER));

		gbSlide.playFloorTile(new Coordinate(1, 0), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(1, 1), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(1, 2), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(1, 3), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(1, 4), new FloorTile(GOAL));
		gbSlide.playFloorTile(new Coordinate(1, 5), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(1, 6), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(1, 7), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(1, 8), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(1, 9), new FloorTile(CORNER));

		gbSlide.playFloorTile(new Coordinate(2, 0), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(2, 1), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(2, 2), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(2, 3), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(2, 4), new FloorTile(GOAL));
		gbSlide.playFloorTile(new Coordinate(2, 5), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(2, 6), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(2, 7), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(2, 8), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(2, 9), new FloorTile(CORNER));

		gbSlide.playFloorTile(new Coordinate(3, 0), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(3, 1), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(3, 2), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(3, 3), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(3, 4), new FloorTile(GOAL));
		gbSlide.playFloorTile(new Coordinate(3, 5), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(3, 6), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(3, 7), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(3, 8), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(3, 9), new FloorTile(CORNER));

		gbSlide.playFloorTile(new Coordinate(4, 0), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(4, 1), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(4, 2), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(4, 3), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(4, 4), new FloorTile(GOAL));
		gbSlide.playFloorTile(new Coordinate(4, 5), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(4, 6), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(4, 7), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(4, 8), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(4, 9), new FloorTile(CORNER));

		gbSlide.playFloorTile(new Coordinate(5, 0), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(5, 1), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(5, 2), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(5, 3), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(5, 4), new FloorTile(GOAL));
		gbSlide.playFloorTile(new Coordinate(5, 5), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(5, 6), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(5, 7), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(5, 8), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(5, 9), new FloorTile(CORNER));

		gbSlide.playFloorTile(new Coordinate(6, 0), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(6, 1), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(6, 2), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(6, 3), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(6, 4), new FloorTile(GOAL));
		gbSlide.playFloorTile(new Coordinate(6, 5), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(6, 6), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(6, 7), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(6, 8), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(6, 9), new FloorTile(CORNER));

		gbSlide.playFloorTile(new Coordinate(7, 0), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(7, 1), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(7, 2), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(7, 3), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(7, 4), new FloorTile(GOAL));
		gbSlide.playFloorTile(new Coordinate(7, 5), new FloorTile(STRAIGHT));
		gbSlide.playFloorTile(new Coordinate(7, 6), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(7, 7), new FloorTile(T_SHAPE));
		gbSlide.playFloorTile(new Coordinate(7, 8), new FloorTile(CORNER));
		gbSlide.playFloorTile(new Coordinate(7, 9), new FloorTile(CORNER));



	}

	@Test
	void setPlayerPos() {
		Coordinate coor1 = new Coordinate(2,2);
		gb.setPlayerPos(2, coor1);
	}

	@Test
	void playBackTrack() throws Exception {
		Coordinate startPos = new Coordinate(1,1);
		Coordinate move1 = new Coordinate(2,1);
		Coordinate move2 = new Coordinate(2, 2);
		Coordinate fireLocation = new Coordinate(0, 0);
		Coordinate frozenLocation = new Coordinate(0, 0);
		// Checking start pos
		assertEquals(startPos, gb.getPlayerPos(0));
		// Check backtrack does nothing
		gb.backtrack(0);
		assertEquals(startPos, gb.getPlayerPos(0));
		// Move once and then backTrack
		setUp();
		gb.setPlayerPos(0, move1);
		assertEquals(move1, gb.getPlayerPos(0));
		gb.backtrack(0);
		assertEquals(startPos, gb.getPlayerPos(0));
		setUp();
		// Move twice then backtrack.
		for (int i = 1; i < 4; i++) {
			gb.setPlayerPos(i, new Coordinate(5,5));
		}
		gb.setPlayerPos(0, move1);
		gb.setPlayerPos(0, move2);
		assertEquals(move2, gb.getPlayerPos(0));
		gb.backtrack(0);
		assertEquals(startPos, gb.getPlayerPos(0));
		gb.setPlayerPos(0, move1);
		gb.setPlayerPos(0, move2);
		// Checking that it doesn't move a player onto a tile thats on fire
		gb.playActionTile(fireLocation, new ActionTile(FIRE), 0);
		gb.playActionTile(frozenLocation, new ActionTile(FROZEN),  0);
		gb.backtrack(0);
		assertEquals(move1, gb.getPlayerPos(0));

	}

	@Test
	void getPlayerPos() {
		assertEquals(1, gb.getPlayerPos(0).getX());
		assertEquals(1, gb.getPlayerPos(0).getY());
		assertEquals(2, gb.getPlayerPos(1).getX());
		assertEquals(1, gb.getPlayerPos(1).getY());
		assertEquals(2, gb.getPlayerPos(2).getX());
		assertEquals(2, gb.getPlayerPos(2).getY());
		assertEquals(2, gb.getPlayerPos(3).getX());
		assertEquals(0, gb.getPlayerPos(3).getY());
	}


	@Test
	void playFloorTile() throws Exception {

        // Testing inserting from the left.
		assertEquals(CORNER,  gb.tileAt(new Coordinate(0,0)).getType());
		assertEquals(T_SHAPE, gb.tileAt(new Coordinate(1,0)).getType());
		assertEquals(CORNER,  gb.tileAt(new Coordinate(2,0)).getType());
		assertEquals(STRAIGHT, gb.tileAt(new Coordinate(0,1)).getType());
		assertEquals(GOAL,    gb.tileAt(new Coordinate(1,1)).getType());
		assertEquals(STRAIGHT,gb.tileAt(new Coordinate(2,1)).getType());
		assertEquals(CORNER,  gb.tileAt(new Coordinate(0,2)).getType());
		assertEquals(T_SHAPE, gb.tileAt(new Coordinate(1,2)).getType());
		assertEquals(CORNER,  gb.tileAt(new Coordinate(2,2)).getType());
		// Testing inserting from the left.
		assertEquals(CORNER,  gb2.tileAt(new Coordinate(0,0)).getType());
		assertEquals(T_SHAPE, gb2.tileAt(new Coordinate(1,0)).getType());
		assertEquals(CORNER,  gb2.tileAt(new Coordinate(2,0)).getType());
		assertEquals(STRAIGHT, gb2.tileAt(new Coordinate(0,1)).getType());
		assertEquals(GOAL,    gb2.tileAt(new Coordinate(1,1)).getType());
		assertEquals(STRAIGHT, gb2.tileAt(new Coordinate(2,1)).getType());
		assertEquals(CORNER,  gb2.tileAt(new Coordinate(0,2)).getType());
		assertEquals(T_SHAPE, gb2.tileAt(new Coordinate(1,2)).getType());
		assertEquals(CORNER,  gb2.tileAt(new Coordinate(2,2)).getType());
		// Testing inserting from the left.
		assertEquals(CORNER,  gb3.tileAt(new Coordinate(0,0)).getType());
		assertEquals(STRAIGHT, gb3.tileAt(new Coordinate(1,0)).getType());
		assertEquals(CORNER,  gb3.tileAt(new Coordinate(2,0)).getType());
		assertEquals(T_SHAPE, gb3.tileAt(new Coordinate(0,1)).getType());
		assertEquals(GOAL,    gb3.tileAt(new Coordinate(1,1)).getType());
		assertEquals(T_SHAPE, gb3.tileAt(new Coordinate(2,1)).getType());
		assertEquals(CORNER,  gb3.tileAt(new Coordinate(0,2)).getType());
		assertEquals(STRAIGHT, gb3.tileAt(new Coordinate(1,2)).getType());
		assertEquals(CORNER,  gb3.tileAt(new Coordinate(2,2)).getType());
		// Testing inserting from the right.
		assertEquals(CORNER,  gb4.tileAt(new Coordinate(0,0)).getType());
		assertEquals(STRAIGHT, gb4.tileAt(new Coordinate(1,0)).getType());
		assertEquals(CORNER,  gb4.tileAt(new Coordinate(2,0)).getType());
		assertEquals(T_SHAPE, gb4.tileAt(new Coordinate(0,1)).getType());
		assertEquals(GOAL,    gb4.tileAt(new Coordinate(1,1)).getType());
		assertEquals(T_SHAPE,gb4.tileAt(new Coordinate(2,1)).getType());
		assertEquals(CORNER,  gb4.tileAt(new Coordinate(0,2)).getType());
		assertEquals(STRAIGHT, gb4.tileAt(new Coordinate(1,2)).getType());
		assertEquals(CORNER,  gb4.tileAt(new Coordinate(2,2)).getType());
	}

	@Test
	void placeFixedTile() {
		gb.placeFixedTile(new FloorTile(TileType.CORNER, Rotation.LEFT), 1, 2);
		assertEquals(CORNER, gb.tileAt(new Coordinate(1, 2)).getType());
		gb.placeFixedTile(new FloorTile(STRAIGHT, Rotation.RIGHT), 2, 2);
		assertEquals(STRAIGHT, gb.tileAt(new Coordinate(2, 2)).getType());
		gb.placeFixedTile(new FloorTile(T_SHAPE, Rotation.LEFT), 1, 1);
		assertEquals(T_SHAPE, gb.tileAt(new Coordinate(1, 1)).getType());
		gb.placeFixedTile(new FloorTile(GOAL, Rotation.LEFT), 2, 1);
		assertEquals(GOAL, gb.tileAt(new Coordinate(2, 1)).getType());
	}


	@Test
	void getWidth() {
		assertEquals(3, gb.getWidth());
		Gameboard gb2 = new Gameboard(0,3, sb);
		assertEquals(0, gb2.getWidth());
		gb2 = new Gameboard(10,3, sb);
		assertEquals(10, gb2.getWidth());

	}

	@Test
	void getHeight() {
		assertEquals(3, gb.getHeight());
		Gameboard gb2 = new Gameboard(3,0, sb);
		assertEquals(0, gb2.getHeight());
		gb2 = new Gameboard(3,10, sb);
		assertEquals(10, gb2.getHeight());
	}

	@Test
	void getMoveDirections() throws Exception {
		gb.getMoveDirections(0);
		gb.getMoveDirections(1);
		gb.getMoveDirections(2);
		gb.getMoveDirections(3);

	}

	@Test
	void testGetPlayerPos() {
		Coordinate t1 = new Coordinate(1, 1);
		Coordinate t2 = new Coordinate(2, 1);
		Coordinate t3 = new Coordinate(2, 2);
		Coordinate t4 = new Coordinate(2, 0);
		assertEquals(t1, gb.getPlayerPos(0));
		assertEquals(t2, gb.getPlayerPos(1));
		assertEquals(t3, gb.getPlayerPos(2));
		assertEquals(t4, gb.getPlayerPos(3));
		t1 = new Coordinate(1, 1);
		gb.setPlayerPos(0, t1);
		assertEquals(t1, gb.getPlayerPos(0));
	}

	@Test
	void testSetPlayerPos() {
		Coordinate t1 = new Coordinate(2, 1);
		Coordinate t2 = new Coordinate(3, 1);
		Coordinate t3 = new Coordinate(2, 2);
		gb.setPlayerPos(0, t1);
		assertEquals(t1, gb.getPlayerPos(0));
		gb.setPlayerPos(0, t2);
		assertEquals(t2, gb.getPlayerPos(0));
		gb.setPlayerPos(0, t3);
		assertEquals(t3, gb.getPlayerPos(0));
	}


	@Test
	void setGoalCoor() throws Exception {
		gb.placeFixedTile(new FloorTile(GOAL, Rotation.LEFT), 2, 1);
		Coordinate goalPos = new Coordinate(2, 1);
		ArrayList<Coordinate> goalTiles = gb.checkGoalTiles();
		assertEquals(goalPos, goalTiles.get(1));
	}

	@Test
	void isPlayerOnGoal() throws Exception {

		gb.placeFixedTile(new FloorTile(GOAL, Rotation.LEFT), 2, 1);
		assertEquals(1, gb.isPlayerOnGoal());

	}

	@Test
	void setFireCoors() throws Exception {
		gb.setFireCoords(new Coordinate(0, 0));
		gb.playFloorTile(new Coordinate(-1, 0), new FloorTile(CORNER));
	}
}