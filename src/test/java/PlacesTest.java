import org.junit.*;
import static org.junit.Assert.*;

public class PlacesTest {

  @Test
  public void Places_instantiatesCorrectly_true() {
    Places myPlaces = new Places("Hawaii");
    assertEquals(true, myPlaces instanceof Places);
  }
   public void Places_instanciatesWithPlace_String(){
     Places myPlaces = new Places("Hawaii");
     assertEquals("Hawaii", myPlaces.getPlace());
   }



}
