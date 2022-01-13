package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    CompletableFuture<Option<Ceo>> completableFuture = new CompletableFuture<>();
    Executors.newCachedThreadPool().submit(() -> {
      Thread.sleep(500L);
      completableFuture.complete(ceos.toStream().find(ceo -> ceo.id.equals(ceo_id)));
      return null;
    });
    return completableFuture;
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    CompletableFuture<Option<Enterprise>> completableFuture = new CompletableFuture<>();
    Executors.newCachedThreadPool().submit(() -> {
      Thread.sleep(500L);
      completableFuture.complete(enterprises.toStream().find(enterprise -> enterprise.ceo_id.equals(ceo_id)));
      return null;
    });
    return completableFuture;
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> completableFuture = new CompletableFuture<>();
    Executors.newCachedThreadPool().submit(() -> {
      Thread.sleep(500L);
      completableFuture.complete(new Tuple2<>(getCeoById(ceo_id).get(), getEnterpriseByCeoId(ceo_id).get()));
      return null;
    });
    return completableFuture;
  }

}
