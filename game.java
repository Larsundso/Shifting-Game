public class Game {

  // values

  private Pitch pitch;
  private boolean gameOver = false;

  // functions

  public void printBoard(Pitch pitch) {



		for (int i = 0; i < 9; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < pitch.getFields().length; j++) {

			}
			System.out.println(); // Zeilenwechsel
		}
  }

  public void initBoardRandom() {
    this.pitch = new Pitch();
  }

  public boolean isGameOver() {
    return this.gameOver;
  }

  public void Game(String[] args) {
    // Game game = new Game();
    // Pitch pitch = game.initBoardRandom();
    System.out.println("Welcome to switch game")
    // while (!game.isGameOver()) {
       game.printBoard(pitch);
    // }
  }
}
