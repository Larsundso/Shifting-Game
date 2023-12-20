public class Game {

  // values

  private Pitch pitch;
  private boolean gameOver = false;

  // functions

  public void printBoard() {
    Field[] fields = this.pitch.getFields();
    int[][] output = new int[(int) Math.sqrt(fields.length)][(int) Math.sqrt(
      fields.length
    )];

    for (Field field : fields) {
      output[field.getX()][field.getY()] = field.getValue();
    }
    for (int i = 0; i < output.length; i++) {
      for (int j = 0; j < output.length; i++) {
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

  public static void main(String[] args) {
    Game game = new Game();
    game.initBoardRandom();

    System.out.println("Welcome to switch game");
    game.printBoard();
  }
}
