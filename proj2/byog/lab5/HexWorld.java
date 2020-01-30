package byog.lab5;
import byog.SaveDemo.World;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.awt.*;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 48;
    private static final int HEIGHT = 48;
    private static final Random RANDOM = new Random();

    /** Calculates 2 middle rows' length. */
    private static int calMidLength(int n) {
        return 1 + 3 * (n - 1);
    }

    private static class Position {
        private int x;
        private int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int getX() {
            return x;
        }

        private int getY() {
            return y;
        }
    }

    /** Picks a RANDOM tile
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.MOUNTAIN;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.GRASS;
            case 3: return Tileset.TREE;
            default: return Tileset.SAND;
        }
    }

    public static void addHexagon(TETile[][] world, Position p, int sideLength, TETile tile) {
        int midLength = calMidLength(sideLength);

        for (int y = p.getY() + sideLength,length = midLength, space = 0; length >= sideLength; length -= 2, space += 1, y += 1) {
            for (int x = p.getX() + space; x < p.getX() + space + length; x += 1) {
                world[x][y] = tile;
            }
        }

        for (int y = p.getY(),length = sideLength, space = sideLength - 1; length <= midLength; length += 2, space -= 1, y += 1) {
            for (int x = p.getX() + space; x < p.getX() + space + length; x += 1) {
                world[x][y] = tile;
            }
        }
    }

    public static Position topRightNeighbor(Position p, int sideLength) {
        int midLength = calMidLength(sideLength);
        int y = p.getY() + sideLength;
        int x = p.getX() + (midLength - sideLength) / 2 + sideLength;
        return new Position(x, y);
    }

    public static Position bottomRightNeighbor(Position p, int sideLength) {
        int midLength = calMidLength(sideLength);
        int y = p.getY() - sideLength;
        int x = p.getX() + (midLength - sideLength) / 2 + sideLength;
        return new Position(x, y);
    }

    public static void drawRandomVerticalHexagon(TETile[][] world, Position p, int number, int sideLength) {
        for (int i = 0; i < number; i++) {
            Position p2 = new Position(p.getX(), p.getY() - 2 * i * sideLength);
            addHexagon(world, p2, 3, randomTile());
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        Position p = new Position(0, 30);
        for (int n = 3; n < 6; n += 1) {
            drawRandomVerticalHexagon(world, p, n, 3);
            if (n < 5) {
                p = topRightNeighbor(p, 3);
            }
        }
        for (int n = 4; n > 2; n -= 1) {
            p = bottomRightNeighbor(p, 3);
            drawRandomVerticalHexagon(world, p, n, 3);
        }

        // draws the world to the screen
        ter.renderFrame(world);
    }
}
