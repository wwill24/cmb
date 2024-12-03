package com.facebook.internal.instrument;

import android.os.Build;
import com.facebook.internal.Utility;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 02\u00020\u0001:\u0003102B\u0011\b\u0012\u0012\u0006\u0010#\u001a\u00020\u000f¢\u0006\u0004\b$\u0010%B\u001b\b\u0012\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010(\u001a\u00020\f¢\u0006\u0004\b$\u0010)B\u001d\b\u0012\u0012\b\u0010*\u001a\u0004\u0018\u00010\b\u0012\b\u0010+\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b$\u0010,B\u0011\b\u0012\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b$\u0010/J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010!\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u00063"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData;", "", "data", "", "compareTo", "", "save", "clear", "", "toString", "filename", "Ljava/lang/String;", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "type", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "Lorg/json/a;", "featureNames", "Lorg/json/a;", "appVersion", "cause", "stackTrace", "", "timestamp", "Ljava/lang/Long;", "Lorg/json/b;", "getParameters", "()Lorg/json/b;", "parameters", "getAnalysisReportParameters", "analysisReportParameters", "getExceptionReportParameters", "exceptionReportParameters", "", "isValid", "()Z", "features", "<init>", "(Lorg/json/a;)V", "", "e", "t", "(Ljava/lang/Throwable;Lcom/facebook/internal/instrument/InstrumentData$Type;)V", "anrCause", "st", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/io/File;", "file", "(Ljava/io/File;)V", "Companion", "Builder", "Type", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class InstrumentData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAM_APP_VERSION = "app_version";
    private static final String PARAM_CALLSTACK = "callstack";
    private static final String PARAM_DEVICE_MODEL = "device_model";
    private static final String PARAM_DEVICE_OS = "device_os_version";
    private static final String PARAM_FEATURE_NAMES = "feature_names";
    private static final String PARAM_REASON = "reason";
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PARAM_TYPE = "type";
    private static final String UNKNOWN = "Unknown";
    private String appVersion;
    private String cause;
    private a featureNames;
    private String filename;
    private String stackTrace;
    private Long timestamp;
    private Type type;

    @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Builder;", "", "Ljava/io/File;", "file", "Lcom/facebook/internal/instrument/InstrumentData;", "load", "", "e", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "t", "build", "Lorg/json/a;", "features", "", "anrCause", "st", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Builder {
        public static final Builder INSTANCE = new Builder();

        private Builder() {
        }

        public static final InstrumentData build(Throwable th2, Type type) {
            j.g(type, "t");
            return new InstrumentData(th2, type, (DefaultConstructorMarker) null);
        }

        public static final InstrumentData load(File file) {
            j.g(file, "file");
            return new InstrumentData(file, (DefaultConstructorMarker) null);
        }

        public static final InstrumentData build(a aVar) {
            j.g(aVar, "features");
            return new InstrumentData(aVar, (DefaultConstructorMarker) null);
        }

        public static final InstrumentData build(String str, String str2) {
            return new InstrumentData(str, str2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Companion;", "", "()V", "PARAM_APP_VERSION", "", "PARAM_CALLSTACK", "PARAM_DEVICE_MODEL", "PARAM_DEVICE_OS", "PARAM_FEATURE_NAMES", "PARAM_REASON", "PARAM_TIMESTAMP", "PARAM_TYPE", "UNKNOWN", "getType", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "filename", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Type getType(String str) {
            if (r.J(str, InstrumentUtility.CRASH_REPORT_PREFIX, false, 2, (Object) null)) {
                return Type.CrashReport;
            }
            if (r.J(str, InstrumentUtility.CRASH_SHIELD_PREFIX, false, 2, (Object) null)) {
                return Type.CrashShield;
            }
            if (r.J(str, InstrumentUtility.THREAD_CHECK_PREFIX, false, 2, (Object) null)) {
                return Type.ThreadCheck;
            }
            if (r.J(str, InstrumentUtility.ANALYSIS_REPORT_PREFIX, false, 2, (Object) null)) {
                return Type.Analysis;
            }
            if (r.J(str, InstrumentUtility.ANR_REPORT_PREFIX, false, 2, (Object) null)) {
                return Type.AnrReport;
            }
            return Type.Unknown;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Type;", "", "(Ljava/lang/String;I)V", "logPrefix", "", "getLogPrefix", "()Ljava/lang/String;", "toString", "Unknown", "Analysis", "AnrReport", "CrashReport", "CrashShield", "ThreadCheck", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Type {
        Unknown,
        Analysis,
        AnrReport,
        CrashReport,
        CrashShield,
        ThreadCheck;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Type.values().length];
                iArr[Type.Analysis.ordinal()] = 1;
                iArr[Type.AnrReport.ordinal()] = 2;
                iArr[Type.CrashReport.ordinal()] = 3;
                iArr[Type.CrashShield.ordinal()] = 4;
                iArr[Type.ThreadCheck.ordinal()] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final String getLogPrefix() {
            int i10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "Unknown" : InstrumentUtility.THREAD_CHECK_PREFIX : InstrumentUtility.CRASH_SHIELD_PREFIX : InstrumentUtility.CRASH_REPORT_PREFIX : InstrumentUtility.ANR_REPORT_PREFIX : InstrumentUtility.ANALYSIS_REPORT_PREFIX;
        }

        public String toString() {
            int i10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "Unknown" : "ThreadCheck" : "CrashShield" : "CrashReport" : "AnrReport" : "Analysis";
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            iArr[Type.Analysis.ordinal()] = 1;
            iArr[Type.AnrReport.ordinal()] = 2;
            iArr[Type.CrashReport.ordinal()] = 3;
            iArr[Type.CrashShield.ordinal()] = 4;
            iArr[Type.ThreadCheck.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ InstrumentData(File file, DefaultConstructorMarker defaultConstructorMarker) {
        this(file);
    }

    public /* synthetic */ InstrumentData(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public /* synthetic */ InstrumentData(Throwable th2, Type type2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th2, type2);
    }

    private InstrumentData(a aVar) {
        this.type = Type.Analysis;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.featureNames = aVar;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ANALYSIS_REPORT_PREFIX);
        stringBuffer.append(String.valueOf(this.timestamp));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        j.f(stringBuffer2, "StringBuffer()\n            .append(InstrumentUtility.ANALYSIS_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.filename = stringBuffer2;
    }

    public /* synthetic */ InstrumentData(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    private final b getAnalysisReportParameters() {
        b bVar = new b();
        try {
            a aVar = this.featureNames;
            if (aVar != null) {
                bVar.put(PARAM_FEATURE_NAMES, (Object) aVar);
            }
            Long l10 = this.timestamp;
            if (l10 != null) {
                bVar.put("timestamp", (Object) l10);
            }
            return bVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final b getExceptionReportParameters() {
        b bVar = new b();
        try {
            bVar.put(PARAM_DEVICE_OS, (Object) Build.VERSION.RELEASE);
            bVar.put(PARAM_DEVICE_MODEL, (Object) Build.MODEL);
            String str = this.appVersion;
            if (str != null) {
                bVar.put(PARAM_APP_VERSION, (Object) str);
            }
            Long l10 = this.timestamp;
            if (l10 != null) {
                bVar.put("timestamp", (Object) l10);
            }
            String str2 = this.cause;
            if (str2 != null) {
                bVar.put("reason", (Object) str2);
            }
            String str3 = this.stackTrace;
            if (str3 != null) {
                bVar.put(PARAM_CALLSTACK, (Object) str3);
            }
            Type type2 = this.type;
            if (type2 != null) {
                bVar.put("type", (Object) type2);
            }
            return bVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    private final b getParameters() {
        int i10;
        Type type2 = this.type;
        if (type2 == null) {
            i10 = -1;
        } else {
            i10 = WhenMappings.$EnumSwitchMapping$0[type2.ordinal()];
        }
        if (i10 == 1) {
            return getAnalysisReportParameters();
        }
        if (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) {
            return getExceptionReportParameters();
        }
        return null;
    }

    public final void clear() {
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        InstrumentUtility.deleteFile(this.filename);
    }

    public final int compareTo(InstrumentData instrumentData) {
        j.g(instrumentData, "data");
        Long l10 = this.timestamp;
        if (l10 == null) {
            return -1;
        }
        long longValue = l10.longValue();
        Long l11 = instrumentData.timestamp;
        if (l11 == null) {
            return 1;
        }
        return j.j(l11.longValue(), longValue);
    }

    public final boolean isValid() {
        int i10;
        Type type2 = this.type;
        if (type2 == null) {
            i10 = -1;
        } else {
            i10 = WhenMappings.$EnumSwitchMapping$0[type2.ordinal()];
        }
        if (i10 != 1) {
            if (i10 != 2) {
                if (!(i10 == 3 || i10 == 4 || i10 == 5) || this.stackTrace == null || this.timestamp == null) {
                    return false;
                }
            } else if (this.stackTrace == null || this.cause == null || this.timestamp == null) {
                return false;
            }
        } else if (this.featureNames == null || this.timestamp == null) {
            return false;
        }
        return true;
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
            String bVar = new b().toString();
            j.f(bVar, "JSONObject().toString()");
            return bVar;
        }
        String bVar2 = parameters.toString();
        j.f(bVar2, "params.toString()");
        return bVar2;
    }

    private InstrumentData(Throwable th2, Type type2) {
        this.type = type2;
        this.appVersion = Utility.getAppVersion();
        this.cause = InstrumentUtility.getCause(th2);
        this.stackTrace = InstrumentUtility.getStackTrace(th2);
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(type2.getLogPrefix());
        stringBuffer.append(String.valueOf(this.timestamp));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        j.f(stringBuffer2, "StringBuffer().append(t.logPrefix).append(timestamp.toString()).append(\".json\").toString()");
        this.filename = stringBuffer2;
    }

    private InstrumentData(String str, String str2) {
        this.type = Type.AnrReport;
        this.appVersion = Utility.getAppVersion();
        this.cause = str;
        this.stackTrace = str2;
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ANR_REPORT_PREFIX);
        stringBuffer.append(String.valueOf(this.timestamp));
        stringBuffer.append(".json");
        String stringBuffer2 = stringBuffer.toString();
        j.f(stringBuffer2, "StringBuffer()\n            .append(InstrumentUtility.ANR_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        this.filename = stringBuffer2;
    }

    private InstrumentData(File file) {
        String name = file.getName();
        j.f(name, "file.name");
        this.filename = name;
        this.type = Companion.getType(name);
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        b readFile = InstrumentUtility.readFile(this.filename, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0));
            this.appVersion = readFile.optString(PARAM_APP_VERSION, (String) null);
            this.cause = readFile.optString("reason", (String) null);
            this.stackTrace = readFile.optString(PARAM_CALLSTACK, (String) null);
            this.featureNames = readFile.optJSONArray(PARAM_FEATURE_NAMES);
        }
    }
}
