package com.facebook.internal.instrument;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.leanplum.internal.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.text.Regex;
import kotlin.text.d;
import org.jivesoftware.smack.packet.Message;
import org.json.JSONException;
import org.json.a;
import org.json.b;
import wc.e;
import wc.f;
import wc.g;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b0\u00101J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\tH\u0007J\u001c\u0010\u0018\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0019\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J$\u0010\u001f\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007J\n\u0010 \u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!H\u0007R\u0014\u0010$\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b)\u0010%R\u0014\u0010*\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b*\u0010%R\u0014\u0010+\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b+\u0010%R\u0014\u0010,\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b,\u0010%R\u0014\u0010-\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b-\u0010%R\u0014\u0010.\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b.\u0010%R\u0014\u0010/\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b/\u0010%¨\u00062"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentUtility;", "", "", "e", "", "getCause", "getStackTrace", "Ljava/lang/Thread;", "thread", "", "isSDKRelatedException", "isSDKRelatedThread", "", "Ljava/io/File;", "listAnrReportFiles", "()[Ljava/io/File;", "listExceptionAnalysisReportFiles", "listExceptionReportFiles", "filename", "deleteOnException", "Lorg/json/b;", "readFile", "content", "", "writeFile", "deleteFile", "key", "Lorg/json/a;", "reports", "Lcom/facebook/GraphRequest$Callback;", "callback", "sendReports", "getInstrumentReportDir", "Ljava/lang/StackTraceElement;", "element", "isFromFbOrMeta", "ANALYSIS_REPORT_PREFIX", "Ljava/lang/String;", "ANR_REPORT_PREFIX", "CRASH_REPORT_PREFIX", "CRASH_SHIELD_PREFIX", "THREAD_CHECK_PREFIX", "ERROR_REPORT_PREFIX", "FBSDK_PREFIX", "METASDK_PREFIX", "CODELESS_PREFIX", "SUGGESTED_EVENTS_PREFIX", "INSTRUMENT_DIR", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class InstrumentUtility {
    public static final String ANALYSIS_REPORT_PREFIX = "analysis_log_";
    public static final String ANR_REPORT_PREFIX = "anr_log_";
    private static final String CODELESS_PREFIX = "com.facebook.appevents.codeless";
    public static final String CRASH_REPORT_PREFIX = "crash_log_";
    public static final String CRASH_SHIELD_PREFIX = "shield_log_";
    public static final String ERROR_REPORT_PREFIX = "error_log_";
    private static final String FBSDK_PREFIX = "com.facebook";
    public static final InstrumentUtility INSTANCE = new InstrumentUtility();
    private static final String INSTRUMENT_DIR = "instrument";
    private static final String METASDK_PREFIX = "com.meta";
    private static final String SUGGESTED_EVENTS_PREFIX = "com.facebook.appevents.suggestedevents";
    public static final String THREAD_CHECK_PREFIX = "thread_check_log_";

    private InstrumentUtility() {
    }

    public static final boolean deleteFile(String str) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null) {
            return false;
        }
        return new File(instrumentReportDir, str).delete();
    }

    public static final String getCause(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        if (th2.getCause() == null) {
            return th2.toString();
        }
        return String.valueOf(th2.getCause());
    }

    public static final File getInstrumentReportDir() {
        File file = new File(FacebookSdk.getApplicationContext().getCacheDir(), INSTRUMENT_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static final String getStackTrace(Throwable th2) {
        Throwable th3 = null;
        if (th2 == null) {
            return null;
        }
        a aVar = new a();
        while (th2 != null && th2 != th3) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            j.f(stackTrace, "t.stackTrace");
            int i10 = 0;
            int length = stackTrace.length;
            while (i10 < length) {
                StackTraceElement stackTraceElement = stackTrace[i10];
                i10++;
                aVar.E(stackTraceElement.toString());
            }
            th3 = th2;
            th2 = th2.getCause();
        }
        return aVar.toString();
    }

    public static final boolean isFromFbOrMeta(StackTraceElement stackTraceElement) {
        j.g(stackTraceElement, "element");
        String className = stackTraceElement.getClassName();
        j.f(className, "element.className");
        if (!r.J(className, "com.facebook", false, 2, (Object) null)) {
            String className2 = stackTraceElement.getClassName();
            j.f(className2, "element.className");
            return r.J(className2, METASDK_PREFIX, false, 2, (Object) null);
        }
    }

    public static final boolean isSDKRelatedException(Throwable th2) {
        if (th2 == null) {
            return false;
        }
        Throwable th3 = null;
        while (th2 != null && th2 != th3) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            j.f(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i10 = 0;
            while (i10 < length) {
                StackTraceElement stackTraceElement = stackTrace[i10];
                i10++;
                j.f(stackTraceElement, "element");
                if (isFromFbOrMeta(stackTraceElement)) {
                    return true;
                }
            }
            th3 = th2;
            th2 = th2.getCause();
        }
        return false;
    }

    public static final boolean isSDKRelatedThread(Thread thread) {
        StackTraceElement[] stackTrace;
        if (!(thread == null || (stackTrace = thread.getStackTrace()) == null)) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                j.f(stackTraceElement, "element");
                if (isFromFbOrMeta(stackTraceElement)) {
                    String className = stackTraceElement.getClassName();
                    j.f(className, "element.className");
                    if (!r.J(className, CODELESS_PREFIX, false, 2, (Object) null)) {
                        String className2 = stackTraceElement.getClassName();
                        j.f(className2, "element.className");
                        if (!r.J(className2, SUGGESTED_EVENTS_PREFIX, false, 2, (Object) null)) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    j.f(methodName, "element.methodName");
                    if (!r.J(methodName, "onClick", false, 2, (Object) null)) {
                        String methodName2 = stackTraceElement.getMethodName();
                        j.f(methodName2, "element.methodName");
                        if (!r.J(methodName2, "onItemClick", false, 2, (Object) null)) {
                            String methodName3 = stackTraceElement.getMethodName();
                            j.f(methodName3, "element.methodName");
                            if (!r.J(methodName3, "onTouch", false, 2, (Object) null)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public static final File[] listAnrReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new g());
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    /* access modifiers changed from: private */
    /* renamed from: listAnrReportFiles$lambda-1  reason: not valid java name */
    public static final boolean m139listAnrReportFiles$lambda1(File file, String str) {
        j.f(str, "name");
        o oVar = o.f32141a;
        String format2 = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{ANR_REPORT_PREFIX}, 1));
        j.f(format2, "java.lang.String.format(format, *args)");
        return new Regex(format2).e(str);
    }

    public static final File[] listExceptionAnalysisReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new f());
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    /* access modifiers changed from: private */
    /* renamed from: listExceptionAnalysisReportFiles$lambda-2  reason: not valid java name */
    public static final boolean m140listExceptionAnalysisReportFiles$lambda2(File file, String str) {
        j.f(str, "name");
        o oVar = o.f32141a;
        String format2 = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{ANALYSIS_REPORT_PREFIX}, 1));
        j.f(format2, "java.lang.String.format(format, *args)");
        return new Regex(format2).e(str);
    }

    public static final File[] listExceptionReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new e());
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    /* access modifiers changed from: private */
    /* renamed from: listExceptionReportFiles$lambda-3  reason: not valid java name */
    public static final boolean m141listExceptionReportFiles$lambda3(File file, String str) {
        j.f(str, "name");
        o oVar = o.f32141a;
        String format2 = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{CRASH_REPORT_PREFIX, CRASH_SHIELD_PREFIX, THREAD_CHECK_PREFIX}, 3));
        j.f(format2, "java.lang.String.format(format, *args)");
        return new Regex(format2).e(str);
    }

    public static final b readFile(String str, boolean z10) {
        File instrumentReportDir = getInstrumentReportDir();
        if (!(instrumentReportDir == null || str == null)) {
            try {
                return new b(Utility.readStreamToString(new FileInputStream(new File(instrumentReportDir, str))));
            } catch (Exception unused) {
                if (z10) {
                    deleteFile(str);
                }
            }
        }
        return null;
    }

    public static final void sendReports(String str, a aVar, GraphRequest.Callback callback) {
        j.g(aVar, "reports");
        if (aVar.o() != 0) {
            b bVar = new b();
            try {
                bVar.put(str, (Object) aVar.toString());
                b dataProcessingOptions = Utility.getDataProcessingOptions();
                if (dataProcessingOptions != null) {
                    Iterator<String> keys = dataProcessingOptions.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        bVar.put(next, dataProcessingOptions.get(next));
                    }
                }
                GraphRequest.Companion companion = GraphRequest.Companion;
                o oVar = o.f32141a;
                String format2 = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                j.f(format2, "java.lang.String.format(format, *args)");
                companion.newPostRequest((AccessToken) null, format2, bVar, callback).executeAsync();
            } catch (JSONException unused) {
            }
        }
    }

    public static final void writeFile(String str, String str2) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && str != null && str2 != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
                byte[] bytes = str2.getBytes(d.f32216b);
                j.f(bytes, "(this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static final String getStackTrace(Thread thread) {
        j.g(thread, Message.Thread.ELEMENT);
        StackTraceElement[] stackTrace = thread.getStackTrace();
        a aVar = new a();
        j.f(stackTrace, Constants.Params.STACK_TRACE);
        int length = stackTrace.length;
        int i10 = 0;
        while (i10 < length) {
            StackTraceElement stackTraceElement = stackTrace[i10];
            i10++;
            aVar.E(stackTraceElement.toString());
        }
        return aVar.toString();
    }
}
