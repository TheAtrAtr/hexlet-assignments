package exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String a, String b, String c) throws NoSuchFileException {
        Path pathA = Path.of(a).toAbsolutePath();
        Path pathB = Path.of(b).toAbsolutePath();
        Path pathC = Path.of(c).toAbsolutePath();
//        if (!(Files.exists(pathA) || Files.exists(pathB))) {
//            throw new NoSuchFileException("no file");
//        }
        CompletableFuture<String> fileA = CompletableFuture.supplyAsync(() -> {

            try {
                return Files.readString(pathA);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally((ex)->{
            System.out.println("NoSuchFileException " +ex.getMessage());
        return null;
        });

        CompletableFuture<String> fileB = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(pathB);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally((ex)->{
            System.out.println("NoSuchFileException " +ex.getMessage());
            return null;
        });
        CompletableFuture<String> fileRes = fileA.thenCombine(fileB, (stringA, stringB) -> {
            String stringC = stringA + stringB;
            try {
                Files.writeString(pathC, stringC);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return stringC;
        });

        return fileRes;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles("H:\\hexlet-assignments\\java-advanced-ru\\asynchrony\\src\\main\\resources\\file1.txt", "H:\\hexlet-assignments\\java-advanced-ru\\asynchrony\\src\\main\\resources\\file2.txt", "H:\\hexlet-assignments\\java-advanced-ru\\asynchrony\\src\\main\\resources\\file3.txt");


        System.out.println(result.get());

        // END
    }
}

