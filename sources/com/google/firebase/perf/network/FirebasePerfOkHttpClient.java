package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.e;
import okhttp3.f;
import okhttp3.t;
import okhttp3.v;
import okhttp3.y;

public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    @Keep
    public static void enqueue(e eVar, f fVar) {
        Timer timer = new Timer();
        f fVar2 = fVar;
        eVar.P(new InstrumentOkHttpEnqueueCallback(fVar2, TransportManager.getInstance(), timer, timer.getMicros()));
    }

    @Keep
    public static a0 execute(e eVar) throws IOException {
        NetworkRequestMetricBuilder builder = NetworkRequestMetricBuilder.builder(TransportManager.getInstance());
        Timer timer = new Timer();
        long micros = timer.getMicros();
        try {
            a0 f10 = eVar.f();
            sendNetworkMetric(f10, builder, micros, timer.getDurationMicros());
            return f10;
        } catch (IOException e10) {
            y g10 = eVar.g();
            if (g10 != null) {
                t j10 = g10.j();
                if (j10 != null) {
                    builder.setUrl(j10.u().toString());
                }
                if (g10.g() != null) {
                    builder.setHttpMethod(g10.g());
                }
            }
            builder.setRequestStartTimeMicros(micros);
            builder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(builder);
            throw e10;
        }
    }

    static void sendNetworkMetric(a0 a0Var, NetworkRequestMetricBuilder networkRequestMetricBuilder, long j10, long j11) throws IOException {
        y F = a0Var.F();
        if (F != null) {
            networkRequestMetricBuilder.setUrl(F.j().u().toString());
            networkRequestMetricBuilder.setHttpMethod(F.g());
            if (F.a() != null) {
                long a10 = F.a().a();
                if (a10 != -1) {
                    networkRequestMetricBuilder.setRequestPayloadBytes(a10);
                }
            }
            b0 a11 = a0Var.a();
            if (a11 != null) {
                long contentLength = a11.contentLength();
                if (contentLength != -1) {
                    networkRequestMetricBuilder.setResponsePayloadBytes(contentLength);
                }
                v contentType = a11.contentType();
                if (contentType != null) {
                    networkRequestMetricBuilder.setResponseContentType(contentType.toString());
                }
            }
            networkRequestMetricBuilder.setHttpResponseCode(a0Var.f());
            networkRequestMetricBuilder.setRequestStartTimeMicros(j10);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(j11);
            networkRequestMetricBuilder.build();
        }
    }
}
