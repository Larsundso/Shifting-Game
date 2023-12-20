import java.util.Scanner;

public class Game {

  // values

  private Scanner scanner;
  private Pitch pitch;
  private boolean gameOver = false;
  private int moves = 0;

  // functions

  public void printBoard() {
    int s = 0;
    Field[] fields = this.pitch.getFields();
    int[][] output = new int[3][3];

    for (Field field : fields) {
      output[field.getX()][field.getY()] = field.getValue();
    }

    while (s < (output.length * 2 + 3)) {
      System.out.print("-");
      s++;
    }
    System.out.println();

    for (int i = 0; i < output.length; i++) {
      System.out.print("| ");
      for (int j = 0; j < output[i].length; j++) {
        System.out.print(output[i][j] + " ");
      }
      System.out.print("|");
      System.out.println();
    }

    s = 0;
    while (s < (output.length * 2 + 3)) {
      System.out.print("-");
      s++;
    }
    System.out.println();
  }

  public void initBoardRandom() {
    this.pitch = new Pitch();
    this.pitch.init();
  }

  public boolean isGameOver() {
    return this.gameOver;
  }

  public void tryAgain() {
    System.out.println("Great, you did it");
    System.out.println("You needed " + this.moves + " moves");
    System.out.println("Want to try again? (Y/N)");
    String again = this.scanner.next().toLowerCase().trim();

    if (again.equals("y")) {
      Game game = new Game();
      game.start(this.scanner);
      return;
    }

    System.out.println("Good bye");
    System.exit(0);
  }

  public void input() {
    System.out.println("move number: ");
    this.moves += 1;
    int number = this.scanner.nextInt();
    boolean valid = this.pitch.isValidSelection(number);

    if (!valid) {
      System.out.println("number cant be moved");
      this.input();
      return;
    }

    this.pitch.swapFields(this.pitch.getFieldByValue(number));
    if (
      this.pitch.getFieldByCoordinates(0, 0).getValue() == 1 &&
      this.pitch.getFieldByCoordinates(0, 1).getValue() == 2 &&
      this.pitch.getFieldByCoordinates(0, 2).getValue() == 3 &&
      this.pitch.getFieldByCoordinates(1, 0).getValue() == 4 &&
      this.pitch.getFieldByCoordinates(1, 1).getValue() == 5 &&
      this.pitch.getFieldByCoordinates(1, 2).getValue() == 6 &&
      this.pitch.getFieldByCoordinates(2, 0).getValue() == 7 &&
      this.pitch.getFieldByCoordinates(2, 1).getValue() == 8 &&
      this.pitch.getFieldByCoordinates(2, 2).getValue() == 0
    ) {
      this.gameOver = true;
      this.tryAgain();
      return;
    }
  }

  public void start(Scanner scanner) {
    this.scanner = scanner;

    this.initBoardRandom();

    System.out.println("Welcome to 'Switch Game'");
    System.out.println();

    while (this.isGameOver() == false) {
      this.printBoard();
      this.input();
    }
  }
}
