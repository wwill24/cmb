package com.facebook.appevents.internal;

import android.os.AsyncTask;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u00020\u00042\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\r\"\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/internal/FileDownloadTask;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "", "uriStr", "destFile", "Ljava/io/File;", "onSuccess", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "(Ljava/lang/String;Ljava/io/File;Lcom/facebook/appevents/internal/FileDownloadTask$Callback;)V", "doInBackground", "args", "", "([Ljava/lang/String;)Ljava/lang/Boolean;", "onPostExecute", "", "isSuccess", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FileDownloadTask extends AsyncTask<String, Void, Boolean> {
    private final File destFile;
    private final Callback onSuccess;
    private final String uriStr;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "", "onComplete", "", "file", "Ljava/io/File;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void onComplete(File file);
    }

    public FileDownloadTask(String str, File file, Callback callback) {
        j.g(str, "uriStr");
        j.g(file, "destFile");
        j.g(callback, "onSuccess");
        this.uriStr = str;
        this.destFile = file;
        this.onSuccess = callback;
    }

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return doInBackground((String[]) objArr);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                onPostExecute(((Boolean) obj).booleanValue());
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
        return java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean doInBackground(java.lang.String... r5) {
        /*
            r4 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = "args"
            kotlin.jvm.internal.j.g(r5, r0)     // Catch:{ all -> 0x0048 }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x0045 }
            java.lang.String r0 = r4.uriStr     // Catch:{ Exception -> 0x0045 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0045 }
            java.net.URLConnection r0 = r5.openConnection()     // Catch:{ Exception -> 0x0045 }
            int r0 = r0.getContentLength()     // Catch:{ Exception -> 0x0045 }
            java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0045 }
            java.io.InputStream r5 = r5.openStream()     // Catch:{ Exception -> 0x0045 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0045 }
            byte[] r5 = new byte[r0]     // Catch:{ Exception -> 0x0045 }
            r2.readFully(r5)     // Catch:{ Exception -> 0x0045 }
            r2.close()     // Catch:{ Exception -> 0x0045 }
            java.io.DataOutputStream r0 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0045 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0045 }
            java.io.File r3 = r4.destFile     // Catch:{ Exception -> 0x0045 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0045 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0045 }
            r0.write(r5)     // Catch:{ Exception -> 0x0045 }
            r0.flush()     // Catch:{ Exception -> 0x0045 }
            r0.close()     // Catch:{ Exception -> 0x0045 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0045 }
            return r5
        L_0x0045:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0048 }
            return r5
        L_0x0048:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.FileDownloadTask.doInBackground(java.lang.String[]):java.lang.Boolean");
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(boolean z10) {
        if (!CrashShieldHandler.isObjectCrashing(this) && z10) {
            try {
                this.onSuccess.onComplete(this.destFile);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
