public class Field {

  // values

  private boolean isEmpty;
  private int x;
  private int y;
  private int value;

  public Field() {}

  public void init(int x, int y, int value) {
    this.x = x;
    this.y = y;
    this.value = value;

    if (value == 0) this.isEmpty = true; else this.isEmpty = false;
  }

  // getters

  public boolean getEmpty() {
    return this.isEmpty;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getValue() {
    return this.value;
  }

  // setters

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setValue(int value) {
    this.value = value;

    if (value == 0) this.isEmpty = true; else this.isEmpty = false;
  }
}
