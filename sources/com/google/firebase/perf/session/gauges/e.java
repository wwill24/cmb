package com.google.firebase.perf.session.gauges;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

public final /* synthetic */ class e implements Provider {
    public final Object get() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
