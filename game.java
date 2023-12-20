public class Game {

  // values

  private Pitch pitch;
  private boolean gameOver = false;

  // functions

  public void printBoard(Pitch pitch) {
    int[][] output;
    Field[] fields = pitch.getFields();
		for (Field field : fields) {
      output[field.getX()][field.getY()] = field.getValue;
		}
    for (int i=0; i<output.length; i++){
      for (int j=0; j<output.length; i++){
        System.out.print(output[i][j]);
      }
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
