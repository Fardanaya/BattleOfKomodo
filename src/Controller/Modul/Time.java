package src.Controller.Modul;

import java.util.concurrent.TimeUnit;

public class Time {

    Thread time = new Thread();
    long startTime;

    public Time() {
        time.start();
        startTime = System.currentTimeMillis();
    }

    public String battleTime() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        String formattedTime = formatElapsedTime(elapsedTime);
        return formattedTime;
    }

    public long time() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime;
    }

    private String formatElapsedTime(long elapsedTime) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
