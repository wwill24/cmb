package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.OutputStream;

public final class InstrHttpOutputStream extends OutputStream {
    long bytesWritten = -1;
    NetworkRequestMetricBuilder networkMetricBuilder;
    private final OutputStream outputStream;
    private final Timer timer;

    public InstrHttpOutputStream(OutputStream outputStream2, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer2) {
        this.outputStream = outputStream2;
        this.networkMetricBuilder = networkRequestMetricBuilder;
        this.timer = timer2;
    }

    public void close() throws IOException {
        long j10 = this.bytesWritten;
        if (j10 != -1) {
            this.networkMetricBuilder.setRequestPayloadBytes(j10);
        }
        this.networkMetricBuilder.setTimeToRequestCompletedMicros(this.timer.getDurationMicros());
        try {
            this.outputStream.close();
        } catch (IOException e10) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e10;
        }
    }

    public void flush() throws IOException {
        try {
            this.outputStream.flush();
        } catch (IOException e10) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e10;
        }
    }

    public void write(int i10) throws IOException {
        try {
            this.outputStream.write(i10);
            long j10 = this.bytesWritten + 1;
            this.bytesWritten = j10;
            this.networkMetricBuilder.setRequestPayloadBytes(j10);
        } catch (IOException e10) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e10;
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.outputStream.write(bArr);
            long length = this.bytesWritten + ((long) bArr.length);
            this.bytesWritten = length;
            this.networkMetricBuilder.setRequestPayloadBytes(length);
        } catch (IOException e10) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e10;
        }
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        try {
            this.outputStream.write(bArr, i10, i11);
            long j10 = this.bytesWritten + ((long) i11);
            this.bytesWritten = j10;
            this.networkMetricBuilder.setRequestPayloadBytes(j10);
        } catch (IOException e10) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e10;
        }
    }
}
