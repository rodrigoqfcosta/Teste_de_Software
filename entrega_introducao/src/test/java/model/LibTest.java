
package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import model.App;

public class LibTest{

  @Test
  public void somaTest(){
    App app = new App();
    assertEquals(8, app.somar(6, 2));
  }

}

