import java.util.Scanner;

// This is required, as Java cannot start without a Main class
class Main {

  /**
   * The main method is the entry point of the program.
   * It calls the start method of the Game class, which initializes the game and the scanner.
   * The scanner is used to read user input.
   *
   * @param args The command-line arguments passed to the program.
   * @return void
   */
  public static void main(String[] args) {
    // This calls our Game class, which is the entry point of our game and initializes the scanner
    // We will not close this scanner, as closing it would also close System.in, which we need
    new Game().start(new Scanner(System.in));
  }
}
