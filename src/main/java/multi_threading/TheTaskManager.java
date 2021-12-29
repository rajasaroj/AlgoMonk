package multi_threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TheTaskManager {

    //Callable<String> callable=

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String srt  = CompletableFuture.supplyAsync(() -> "hello")
                .thenApply(x -> x + " world")
                .thenApply(x -> x + " wellcome")
                .get();

        CompletableFuture<String> dbRetriver =  CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Retriving from DB";
        });
        CompletableFuture<String> ftpRetriver =  CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Retriving from FTP \n";
        });


        CompletableFuture<String> kafkaRetriver =  CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Retriving from kafka \n";
        });
        CompletableFuture<String> restRetriver =  CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Retriving from rest \n";
        });


        CompletableFuture<String> mergedDBAndFtp = dbRetriver.thenCombineAsync(ftpRetriver, (x,y) ->  "In Stage1 Merge \n"  + x.replace("Retriving", "merging") +":"+ y.replace("Retriving", "merging"));
        CompletableFuture<String> mergedKafkaAndRest = kafkaRetriver.thenCombineAsync(restRetriver, (x,y) ->  "In Stage1 Merge \n"  + x.replace("Retriving", "merging") +":"+ y.replace("Retriving", "merging"));

       String str =  mergedDBAndFtp.thenCombine(mergedKafkaAndRest, (x,y) -> "In Final Merge \n"  + x.replace("In Stage1 Merge", "Merged Data from") + " : "+ y.replace("merging from", "Merged Data from")).get();

        System.out.println(str);
    }
}
