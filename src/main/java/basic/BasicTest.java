package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    try {
      if (n < 0) {
        return Option.none();
      }
      if (n == 0) {
        return Option.of(1);
      }
      Integer power = 1;
      for (int k = 0; k < n; k++) {
        power *= i;
        if (power < 0) {
          return Option.none();
        }
      }
      return Option.of(power);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return Option.none();
    }
  }
}
