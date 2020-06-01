package buiseness;


public class UtilityClass {
    static int staticMethod(long value) {
        throw new RuntimeException(
                "I don't want to be executed. I will anyway be mocked out.");
    }
}