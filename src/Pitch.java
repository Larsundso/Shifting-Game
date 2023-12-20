import java.util.Arrays;

public class Pitch {

  private Field[] fields = new Field[9];
  private Field emptyField;

  // functions

  Pitch() {}

  public void init(Integer[] values) {
    for (int i = 0; i < this.fields.length; i += 1) {
      this.fields[i] = new Field();
      this.fields[i].init(i % 3, i / 3, values[i]);
    }
  }

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

  public void swapFields(Field field) {
    Field emptyField = this.getEmptyField();

    emptyField.setValue(field.getValue());
    field.setValue(0);
    this.emptyField = field;
  }

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

  public Field[] getFields() {
    return this.fields;
  }

  public Field getFieldByValue(int value) {
    for (Field field : this.fields) {
      if (field.getValue() == value) return field;
    }

    return null;
  }

  public Field getFieldByCoordinates(int x, int y) {
    for (Field field : this.fields) {
      if (field.getX() == x && field.getY() == y) return field;
    }

    return null;
  }

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

  public Field getEmptyField() {
    for (Field field : this.fields) {
      if (field.getEmpty()) this.emptyField = field;
    }

    return this.emptyField;
  }
}
