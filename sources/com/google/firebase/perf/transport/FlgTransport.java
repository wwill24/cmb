package com.google.firebase.perf.transport;

import androidx.annotation.NonNull;
import cd.b;
import cd.c;
import cd.e;
import cd.f;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.PerfMetric;

final class FlgTransport {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private e<PerfMetric> flgTransport;
    private final Provider<f> flgTransportFactoryProvider;
    private final String logSourceName;

    FlgTransport(Provider<f> provider, String str) {
        this.logSourceName = str;
        this.flgTransportFactoryProvider = provider;
    }

    private boolean initializeFlgTransportClient() {
        if (this.flgTransport == null) {
            f fVar = this.flgTransportFactoryProvider.get();
            if (fVar != null) {
                this.flgTransport = fVar.a(this.logSourceName, PerfMetric.class, b.b("proto"), new a());
            } else {
                logger.warn("Flg TransportFactory is not available at the moment");
            }
        }
        if (this.flgTransport != null) {
            return true;
        }
        return false;
    }

    public void log(@NonNull PerfMetric perfMetric) {
        if (!initializeFlgTransportClient()) {
            logger.warn("Unable to dispatch event because Flg Transport is not available");
        } else {
            this.flgTransport.b(c.d(perfMetric));
        }
    }
}
