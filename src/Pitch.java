import java.util.Arrays;

public class Pitch {

  private Field[] fields = new Field[9];
  private Field emptyField;

  // functions

  /**
   * Represents a pitch in the game.
   */
  Pitch() {}

  /**
   * Initializes the fields of the pitch with the given values.
   * @param values an array of integers representing the values for each field
   * @return void
   */
  public void init(Integer[] values) {
    for (int i = 0; i < this.fields.length; i += 1) {
      this.fields[i] = new Field();
      this.fields[i].init(i % 3, i / 3, values[i]);
    }
  }

  /**
   * Checks if the given selection is valid.
   * @param selection the selected value to be checked
   * @return true if the selection is valid, false otherwise
   */
  public boolean isValidSelection(int selection) {
    if (selection < 1 || selection > 9) return false;

    Field selectedField = null;
    for (Field field : this.fields) {
      if (field.getValue() == selection) {
        selectedField = field;
      }
    }

    if (selectedField == null) return false;

    Field[] adjacentFields = this.getAdjacentFields(this.getEmptyField());

    for (Field adjacentField : adjacentFields) {
      if (adjacentField == null) continue;
      if (adjacentField.getValue() == selectedField.getValue()) return true;
    }

    return false;
  }

  /**
   * Swaps the value of the specified field with the value of the empty field.
   * @param field The field to swap with the empty field.
   * @return void
   */
  public void swapFields(Field field) {
    Field emptyField = this.getEmptyField();

    emptyField.setValue(field.getValue());
    field.setValue(0);
    this.emptyField = field;
  }

  /**
   * Checks if two fields are adjacent to each other.
   * Two fields are considered adjacent if they are next to each other horizontally or vertically.
   * @param field1 the first field
   * @param field2 the second field
   * @return true if the fields are adjacent, false otherwise
   */
  public boolean isAdjacentFields(Field field1, Field field2) {
    if (field1.getValue() == field2.getValue()) return false;

    int xDifference = Math.abs(field1.getX() - field2.getX());
    int yDifference = Math.abs(field1.getY() - field2.getY());

    if (
      (xDifference == 1 && yDifference == 0) ||
      (xDifference == 0 && yDifference == 1)
    ) {
      return true;
    }

    return false;
  }

  // getters

  /**
   * Returns an array of Field objects representing the fields in the pitch.
   * @return an array of Field objects
   */
  public Field[] getFields() {
    return this.fields;
  }

  /**
   * Returns the Field object with the specified value.
   * @param value the value of the Field to find
   * @return the Field object with the specified value, or null if not found
   */
  public Field getFieldByValue(int value) {
    for (Field field : this.fields) {
      if (field.getValue() == value) return field;
    }

    return null;
  }

  /**
   * Retrieves the field object based on the given coordinates.
   * @param x The x-coordinate of the field.
   * @param y The y-coordinate of the field.
   * @return The field object at the specified coordinates, or null if no field is found.
   */
  public Field getFieldByCoordinates(int x, int y) {
    for (Field field : this.fields) {
      if (field.getX() == x && field.getY() == y) return field;
    }

    return null;
  }

  /**
   * Returns an array of adjacent fields to the given field.
   * @param field The field for which to find adjacent fields.
   * @return An array of adjacent fields.
   */
  public Field[] getAdjacentFields(Field field) {
    Field[] adjacentFields = new Field[4];
    int index = 0;

    for (Field potentialField : this.fields) {
      if (isAdjacentFields(field, potentialField)) {
        adjacentFields[index] = potentialField;
        index++;
      }
    }

    return Arrays.copyOf(adjacentFields, index);
  }

  /**
   * Returns the empty field in the pitch.
   * @return the empty field in the pitch
   */
  public Field getEmptyField() {
    for (Field field : this.fields) {
      if (field.getEmpty()) this.emptyField = field;
    }

    return this.emptyField;
  }
}
