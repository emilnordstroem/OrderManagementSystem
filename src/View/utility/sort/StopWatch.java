package View.utility.sort;

import java.time.Instant;

public class StopWatch {
    private static Instant startTime;
    private static Instant endTime;

    public static void start() {
        startTime = Instant.now();
    }

    public static void stop() {
        endTime = Instant.now();
    }

    public static int durationMilliSeconds() {
        return (int) (endTime.toEpochMilli() - startTime.toEpochMilli());
    }
}
