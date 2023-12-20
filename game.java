public class Game {

  // values

  private Pitch pitch;
  private boolean gameOver = false;

  // functions

  public void printBoard(Pitch pitch) {}

  public void initBoardRandom() {
    this.pitch = new Pitch();
  }

  public boolean isGameOver() {
    return this.gameOver;
  }

  public void Game(String[] args) {
    // Game game = new Game();
    // Pitch pitch = game.initBoardRandom();

    // while (!game.isGameOver()) {
    //   game.printBoard(pitch);
    // }
  }
}
