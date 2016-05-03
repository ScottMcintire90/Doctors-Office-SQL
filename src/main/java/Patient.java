import java.util.List;
import org.sql2o.*;
import java.util.Arrays;

public class Patient {
  private String name;
  private String birthdate;

  public Patient(String name, String birthdate) {
    this.name = name;
    this.birthdate = birthdate;
  }
}
