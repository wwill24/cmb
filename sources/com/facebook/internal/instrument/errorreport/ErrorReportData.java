package com.facebook.internal.instrument.errorreport;

import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0013\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001cJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportData;", "", "data", "", "compareTo", "", "save", "clear", "", "toString", "filename", "Ljava/lang/String;", "errorMessage", "", "timestamp", "Ljava/lang/Long;", "", "isValid", "()Z", "Lorg/json/b;", "getParameters", "()Lorg/json/b;", "parameters", "message", "<init>", "(Ljava/lang/String;)V", "Ljava/io/File;", "file", "(Ljava/io/File;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class ErrorReportData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PRARAM_ERROR_MESSAGE = "error_message";
    private String errorMessage;
    private String filename;
    private Long timestamp;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportData$Companion;", "", "()V", "PARAM_TIMESTAMP", "", "PRARAM_ERROR_MESSAGE", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ErrorReportData(String str) {
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.errorMessage = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ERROR_REPORT_PREFIX);
        Long l10 = this.timestamp;
        if (l10 != null) {
            stringBuffer.append(l10.longValue());
            stringBuffer.append(".json");
            String stringBuffer2 = stringBuffer.toString();
            j.f(stringBuffer2, "StringBuffer()\n            .append(InstrumentUtility.ERROR_REPORT_PREFIX)\n            .append(timestamp as Long)\n            .append(\".json\")\n            .toString()");
            this.filename = stringBuffer2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public final void clear() {
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        InstrumentUtility.deleteFile(this.filename);
    }

    public final int compareTo(ErrorReportData errorReportData) {
        j.g(errorReportData, "data");
        Long l10 = this.timestamp;
        if (l10 == null) {
            return -1;
        }
        long longValue = l10.longValue();
        Long l11 = errorReportData.timestamp;
        if (l11 == null) {
            return 1;
        }
        return j.j(l11.longValue(), longValue);
    }

    public final b getParameters() {
        b bVar = new b();
        try {
            Long l10 = this.timestamp;
            if (l10 != null) {
                bVar.put("timestamp", (Object) l10);
            }
            bVar.put("error_message", (Object) this.errorMessage);
            return bVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean isValid() {
        return (this.errorMessage == null || this.timestamp == null) ? false : true;
    }

    public final void save() {
        if (isValid()) {
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    public String toString() {
        b parameters = getParameters();
        if (parameters == null) {
            return super.toString();
        }
        String bVar = parameters.toString();
        j.f(bVar, "params.toString()");
        return bVar;
    }

    public ErrorReportData(File file) {
        j.g(file, "file");
        String name = file.getName();
        j.f(name, "file.name");
        this.filename = name;
        b readFile = InstrumentUtility.readFile(name, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0));
            this.errorMessage = readFile.optString("error_message", (String) null);
        }
    }
}
