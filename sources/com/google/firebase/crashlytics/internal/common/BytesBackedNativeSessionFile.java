package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

class BytesBackedNativeSessionFile implements NativeSessionFile {
    private final byte[] bytes;
    @NonNull
    private final String dataTransportFilename;
    @NonNull
    private final String reportsEndpointFilename;

    BytesBackedNativeSessionFile(@NonNull String str, @NonNull String str2, byte[] bArr) {
        this.dataTransportFilename = str;
        this.reportsEndpointFilename = str2;
        this.bytes = bArr;
    }

    private byte[] asGzippedBytes() {
        GZIPOutputStream gZIPOutputStream;
        if (isEmpty()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(this.bytes);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th2) {
                byteArrayOutputStream.close();
                throw th2;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
        throw th;
    }

    private boolean isEmpty() {
        byte[] bArr = this.bytes;
        return bArr == null || bArr.length == 0;
    }

    public CrashlyticsReport.FilesPayload.File asFilePayload() {
        byte[] asGzippedBytes = asGzippedBytes();
        if (asGzippedBytes == null) {
            return null;
        }
        return CrashlyticsReport.FilesPayload.File.builder().setContents(asGzippedBytes).setFilename(this.dataTransportFilename).build();
    }

    @NonNull
    public String getReportsEndpointFilename() {
        return this.reportsEndpointFilename;
    }

    public InputStream getStream() {
        if (isEmpty()) {
            return null;
        }
        return new ByteArrayInputStream(this.bytes);
    }
}
