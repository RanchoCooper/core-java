package volume2.advanced.features.ch01.optional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author rancho
 * @date 2019-09-02
 */
public class OptionalTest {

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get("/etc/hosts")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL"));

        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("google"))
                .findFirst();
        System.out.println(optionalValue.orElse("Not found") + " contains google");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);

        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result: " + result);

        try {
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        optionalValue = wordList.stream()
                .filter(s -> s.contains("email"))
                .findFirst();
        optionalValue.ifPresent(s -> System.out.println(s + " contains email"));

        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

    }
}
