package siftscience.android;

class Time {
    static long currentTime;

    Time() {
    }

    static long now() {
        long j10 = currentTime;
        return j10 != 0 ? j10 : System.currentTimeMillis();
    }
}
