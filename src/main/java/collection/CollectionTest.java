package collection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    return input.stream().map(x -> Math.pow((x * 2) + 3, 5)).collect(Collectors.toList());
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    return input.stream().map(item -> doubleText(capitalize(item))).collect(Collectors.toList());
  }

  public static String capitalize(String text) {
    if (text != null) {
      if (!text.isEmpty()) {
        return text.substring(0, 1).toUpperCase().concat(text.substring(1));
      }
      return "";
    }
    return null;
  }

  public static String doubleText(String text) {
    if (text != null) {
      return text.concat(text);
    }
    return null;
  }
}
