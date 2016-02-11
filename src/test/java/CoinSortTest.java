import org.junit.*;
import static org.junit.Assert.*;

public class CoinSortTest {

  @Test
  public void coinSort_Enter25_Return1() {
    CoinSort coinSort = new CoinSort();
    assertEquals("1 quarters", coinSort.checkChange(25));
  }

  @Test
  public void coinSort_Enter10_Return1() {
    CoinSort coinSort = new CoinSort();
    assertEquals(" 1 dimes", coinSort.checkChange(10));
  }

  @Test
  public void coinSort_Enter5_Return1() {
    CoinSort coinSort = new CoinSort();
    assertEquals(" 1 nickels", coinSort.checkChange(5));
  }

  @Test
  public void coinSort_Enter1_Return1() {
    CoinSort coinSort = new CoinSort();
    assertEquals(" 1 pennies", coinSort.checkChange(1));
  }

  @Test
  public void coinSort_Enter41_ReturnCorrect() {
    CoinSort coinSort = new CoinSort();
    assertEquals("1 quarters 1 dimes 1 nickels 1 pennies", coinSort.checkChange(41));
  }
}
