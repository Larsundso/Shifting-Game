import java.util.Scanner;

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
      for (int j = 0; j < output[i].length; j++) {
        System.out.print(output[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void initBoardRandom() {
    System.out.println(this.pitch);
    this.pitch = new Pitch();
    this.pitch.init(3);
    System.out.println(this.pitch);
  }

  public boolean isGameOver() {
    return this.gameOver;
  }

  public boolean isValid() {
    Scanner scan = new Scanner(System.in);
    boolean valid;

    System.out.println("move number: ");
    String input = scan.next();
    int number = Integer.parseInt(input);

    scan.close();
    valid = pitch.isValidSelection(number);

    if (valid == false) {
      System.out.println("number cant be moved");
    }

    return valid;
  }

  public void input() {
    boolean valid;
    do {
      valid = isValid();
    } while (valid == false);
  }

  public void start() {
    this.initBoardRandom();

    System.out.println("Welcome to switch game");
    this.printBoard();

    this.input();
  }
}
