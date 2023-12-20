public class Pitch {

  private Field[] fields = new Field[9];
  private Field emptyField;

  // functions

  public void swapFields(Field field) {}

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
