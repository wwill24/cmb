package com.leanplum;

public enum EventsUploadInterval {
    AT_MOST_5_MINUTES(5),
    AT_MOST_10_MINUTES(10),
    AT_MOST_15_MINUTES(15);
    
    private final int minutes;

    private EventsUploadInterval(int i10) {
        this.minutes = i10;
    }

    public int getMinutes() {
        return this.minutes;
    }
}
