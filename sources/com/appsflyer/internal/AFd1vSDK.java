package com.appsflyer.internal;

import java.util.TimerTask;

public final class AFd1vSDK extends TimerTask {
    private final Thread AFInAppEventParameterName;

    public AFd1vSDK(Thread thread) {
        this.AFInAppEventParameterName = thread;
    }

    public final void run() {
        this.AFInAppEventParameterName.interrupt();
    }
}
