public class Field {

  // values

  private boolean isEmpty;
  private int x;
  private int y;
  private int value;

  /**
   * Represents a field in the game.
   */
  public Field() {}

  /**
   * Initializes the Field object with the specified coordinates and value.
   * @param x     the x-coordinate of the field
   * @param y     the y-coordinate of the field
   * @param value the value of the field
   * @return void
   */
  public void init(int x, int y, int value) {
    this.x = x;
    this.y = y;
    this.value = value;

    if (value == 0) this.isEmpty = true; else this.isEmpty = false;
  }

  // getters

  /**
   * Returns the empty status of the field.
   * @return true if the field is empty, false otherwise.
   */
  public boolean getEmpty() {
    return this.isEmpty;
  }

  /**
   * Returns the x-coordinate of the field.
   * @return the x-coordinate of the field
   */
  public int getX() {
    return this.x;
  }

  /**
   * Returns the y-coordinate of the field.
   * @return the y-coordinate of the field
   */
  public int getY() {
    return this.y;
  }

  /**
   * Returns the value of the field.
   * @return the value of the field
   */
  public int getValue() {
    return this.value;
  }

  // setters

  /**
   * Sets the value of the field.
   * @param value the new value to be set
   * @return void
   */
  public void setValue(int value) {
    this.value = value;

    if (value == 0) this.isEmpty = true; else this.isEmpty = false;
  }
}
