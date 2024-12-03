package com.facebook.internal.instrument.errorreport;

import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.text.Regex;
import org.json.JSONException;
import zc.a;
import zc.b;
import zc.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportHandler;", "", "()V", "MAX_ERROR_REPORT_NUM", "", "enable", "", "listErrorReportFiles", "", "Ljava/io/File;", "()[Ljava/io/File;", "save", "msg", "", "sendErrorReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorReportHandler {
    public static final ErrorReportHandler INSTANCE = new ErrorReportHandler();
    private static final int MAX_ERROR_REPORT_NUM = 1000;

    private ErrorReportHandler() {
    }

    public static final void enable() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    public static final File[] listErrorReportFiles() {
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new c());
        j.f(listFiles, "reportDir.listFiles { dir, name ->\n      name.matches(Regex(String.format(\"^%s[0-9]+.json$\", InstrumentUtility.ERROR_REPORT_PREFIX)))\n    }");
        return listFiles;
    }

    /* access modifiers changed from: private */
    /* renamed from: listErrorReportFiles$lambda-3  reason: not valid java name */
    public static final boolean m147listErrorReportFiles$lambda3(File file, String str) {
        j.f(str, "name");
        o oVar = o.f32141a;
        String format2 = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{InstrumentUtility.ERROR_REPORT_PREFIX}, 1));
        j.f(format2, "java.lang.String.format(format, *args)");
        return new Regex(format2).e(str);
    }

    public static final void save(String str) {
        try {
            new ErrorReportData(str).save();
        } catch (Exception unused) {
        }
    }

    public static final void sendErrorReports() {
        if (!Utility.isDataProcessingRestricted()) {
            File[] listErrorReportFiles = listErrorReportFiles();
            ArrayList arrayList = new ArrayList();
            int length = listErrorReportFiles.length;
            int i10 = 0;
            int i11 = 0;
            while (i11 < length) {
                File file = listErrorReportFiles[i11];
                i11++;
                ErrorReportData errorReportData = new ErrorReportData(file);
                if (errorReportData.isValid()) {
                    arrayList.add(errorReportData);
                }
            }
            u.w(arrayList, new a());
            org.json.a aVar = new org.json.a();
            while (i10 < arrayList.size() && i10 < 1000) {
                aVar.E(arrayList.get(i10));
                i10++;
            }
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            InstrumentUtility.sendReports("error_reports", aVar, new b(arrayList));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendErrorReports$lambda-0  reason: not valid java name */
    public static final int m148sendErrorReports$lambda0(ErrorReportData errorReportData, ErrorReportData errorReportData2) {
        j.f(errorReportData2, "o2");
        return errorReportData.compareTo(errorReportData2);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendErrorReports$lambda-2  reason: not valid java name */
    public static final void m149sendErrorReports$lambda2(ArrayList arrayList, GraphResponse graphResponse) {
        Boolean bool;
        j.g(arrayList, "$validReports");
        j.g(graphResponse, "response");
        try {
            if (graphResponse.getError() == null) {
                org.json.b jsonObject = graphResponse.getJsonObject();
                if (jsonObject == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(jsonObject.getBoolean("success"));
                }
                if (j.b(bool, Boolean.TRUE)) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((ErrorReportData) it.next()).clear();
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }
}
