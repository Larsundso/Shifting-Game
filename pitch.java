import java.util.Arrays;

public class Pitch {

  private Field[] fields = new Field[9];
  private Field emptyField;

  // functions

  public Pitch() {
    for (int i = 0; i < this.fields.length; i += 1) {
      this.fields[i] = new Field();
    }
  }

  public boolean isValidSelection(int selection) {
    if (selection < 1 || selection > 9) return false;

    for (Field field : this.fields) {
      if (
        field.getValue() == selection &&
        Arrays.stream(this.getAdjacentFields(field)).anyMatch(f -> f.getEmpty())
      ) return true;
    }

    return true;
  }

  public void swapFields(Field field) {
    Field emptyField = this.getEmptyField();

    emptyField.setValue(field.getValue());
    field.setValue(0);
    this.emptyField = field;
  }

  public boolean isAdjacentFields(Field field1, Field field2) {
    if (
      (
        field1.getX() == field2.getX() - 1 || field1.getX() == field2.getX() + 1
      ) &&
      (field1.getY() == field2.getY() - 1 || field1.getY() == field2.getY() + 1)
    ) {
      return true;
    }

    return false;
  }

  // getters

  public Field[] getFields() {
    return this.fields;
  }

  public Field[] getAdjacentFields(Field field) {
    Field[] adjacentFields = new Field[4];

    for (int i = 0; i < adjacentFields.length; i += 1) {
      if (this.isAdjacentFields(field, this.fields[i])) {
        adjacentFields[i] = this.fields[i];
      }
    }

    return adjacentFields;
  }

  public Field getEmptyField() {
    for (Field field : this.fields) {
      if (field.getEmpty()) this.emptyField = field;
    }

    return this.emptyField;
  }
}
