package pages;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HelperTimeOut {
    public static Duration timeout() {
        return Duration.of(30, ChronoUnit.SECONDS);
    }
}
