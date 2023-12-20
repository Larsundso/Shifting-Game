import java.util.Scanner;

public class Game {

  // values

  private Pitch pitch;
  private boolean gameOver = false;

  // functions

  public void printBoard() {
    int s = 0;
    Field[] fields = this.pitch.getFields();
    int[][] output = new int[(int) Math.sqrt(fields.length)][(int) Math.sqrt(
      fields.length
    )];

    for (Field field : fields) {
      output[field.getX()][field.getY()] = field.getValue();
    }

    while(s < (output.length*2+3)){
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
    while(s < (output.length*2+3)){
      System.out.print("-");
      s++;
    }
    System.out.println();
  }

  public void initBoardRandom() {
    this.pitch = new Pitch();
    this.pitch.init(3);
  }

  public boolean isGameOver() {
    return this.gameOver;
  }

  public void tryAgain(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Want to try again? (Y/N)");
    String again = scan.next();
    scan.close();
    if( again == "Y" || again == "y"){

    }
    else{
      System.out.println("Good bye");
    }
  }

  public boolean isValid() {
    Scanner scan = new Scanner(System.in);
    boolean valid;

    System.out.println("move number: ");
    int number = scan.nextInt();

    scan.close();
    valid = this.pitch.isValidSelection(number);

    if (valid == false) {
      System.out.println("number cant be moved");
    }

    return valid;
  }

  public void input() {
    boolean valid;
    do {
      valid = this.isValid();
    } while (valid == false);
  }

  public void main(String[] args) {
    Game game = new Game();
    game.initBoardRandom();
    int counter = 0;

    System.out.println("Welcome to 'Switch Game'");
    System.out.println();

    while(this.isGameOver()==false){
      game.printBoard();
      this.input();
      counter++;
    }

    System.out.println("Great, you did it");
    System.out.println("You needed " + counter + " moves");
 
  }
}
