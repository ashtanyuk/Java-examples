/**
 * Represents a student enrolled in the school.
 * A student can be enrolled in many courses.
 */
public class Student {

  /**
   * The first and last name of this student.
   */
  private String name;

  /**
   * Creates a new Student with the given name.
   * The name should include both first and
   * last name.
   */
  public Student(String name) {
    this.name = name;
  }
/**
   * Gets the first and last name of this Student.
   * @return this Student's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Changes the name of this Student.
   * This may involve a lengthy legal process.
   * @param newName This Student's new name.  
   *                Should include both first
   *                and last name.
   */
  public void setName(String newName) {
    name = newName;
  }
}
