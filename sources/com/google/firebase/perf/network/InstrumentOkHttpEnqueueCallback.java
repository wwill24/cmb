package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.a0;
import okhttp3.e;
import okhttp3.f;
import okhttp3.t;
import okhttp3.y;

public class InstrumentOkHttpEnqueueCallback implements f {
    private final f callback;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private final long startTimeMicros;
    private final Timer timer;

    public InstrumentOkHttpEnqueueCallback(f fVar, TransportManager transportManager, Timer timer2, long j10) {
        this.callback = fVar;
        this.networkMetricBuilder = NetworkRequestMetricBuilder.builder(transportManager);
        this.startTimeMicros = j10;
        this.timer = timer2;
    }

    public void onFailure(e eVar, IOException iOException) {
        y g10 = eVar.g();
        if (g10 != null) {
            t j10 = g10.j();
            if (j10 != null) {
                this.networkMetricBuilder.setUrl(j10.u().toString());
            }
            if (g10.g() != null) {
                this.networkMetricBuilder.setHttpMethod(g10.g());
            }
        }
        this.networkMetricBuilder.setRequestStartTimeMicros(this.startTimeMicros);
        this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
        NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
        this.callback.onFailure(eVar, iOException);
    }

    public void onResponse(e eVar, a0 a0Var) throws IOException {
        a0 a0Var2 = a0Var;
        FirebasePerfOkHttpClient.sendNetworkMetric(a0Var2, this.networkMetricBuilder, this.startTimeMicros, this.timer.getDurationMicros());
        this.callback.onResponse(eVar, a0Var);
    }
}
