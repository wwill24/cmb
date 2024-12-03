package v4;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapInstanceConfig f18064a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f18065b;

    public b(@NonNull Context context, @NonNull CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f18065b = context;
        this.f18064a = cleverTapInstanceConfig;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                synchronized (b.class) {
                    File file = new File(this.f18065b.getFilesDir(), str);
                    if (file.exists()) {
                        if (file.delete()) {
                            p n10 = this.f18064a.n();
                            String e10 = this.f18064a.e();
                            n10.t(e10, "File Deleted:" + str);
                        } else {
                            p n11 = this.f18064a.n();
                            String e11 = this.f18064a.e();
                            n11.t(e11, "Failed to delete file" + str);
                        }
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
                p n12 = this.f18064a.n();
                String e13 = this.f18064a.e();
                n12.t(e13, "writeFileOnInternalStorage: failed" + str + " Error:" + e12.getLocalizedMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r1.<init>()     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            android.content.Context r2 = r7.f18065b     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.io.File r2 = r2.getFilesDir()     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r1.append(r2)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r1.append(r8)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0068, all -> 0x0062 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d, all -> 0x0058 }
            r1.<init>()     // Catch:{ Exception -> 0x005d, all -> 0x0058 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x005d, all -> 0x0058 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x005d, all -> 0x0058 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
        L_0x0034:
            java.lang.String r0 = r3.readLine()     // Catch:{ Exception -> 0x0050 }
            if (r0 == 0) goto L_0x003e
            r1.append(r0)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0034
        L_0x003e:
            r8.close()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0050 }
            r8.close()
            r2.close()
            r3.close()
            goto L_0x00a2
        L_0x0050:
            r0 = move-exception
            goto L_0x006d
        L_0x0052:
            r1 = move-exception
            r3 = r0
            goto L_0x005b
        L_0x0055:
            r1 = move-exception
            r3 = r0
            goto L_0x0060
        L_0x0058:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L_0x005b:
            r0 = r1
            goto L_0x00a4
        L_0x005d:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L_0x0060:
            r0 = r1
            goto L_0x006d
        L_0x0062:
            r8 = move-exception
            r2 = r0
            r3 = r2
            r0 = r8
            r8 = r3
            goto L_0x00a4
        L_0x0068:
            r8 = move-exception
            r2 = r0
            r3 = r2
            r0 = r8
            r8 = r3
        L_0x006d:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r7.f18064a     // Catch:{ all -> 0x00a3 }
            com.clevertap.android.sdk.p r1 = r1.n()     // Catch:{ all -> 0x00a3 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r7.f18064a     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = r4.e()     // Catch:{ all -> 0x00a3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a3 }
            r5.<init>()     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = "[Exception While Reading: "
            r5.append(r6)     // Catch:{ all -> 0x00a3 }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x00a3 }
            r5.append(r0)     // Catch:{ all -> 0x00a3 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00a3 }
            r1.t(r4, r0)     // Catch:{ all -> 0x00a3 }
            if (r8 == 0) goto L_0x0096
            r8.close()
        L_0x0096:
            if (r2 == 0) goto L_0x009b
            r2.close()
        L_0x009b:
            if (r3 == 0) goto L_0x00a0
            r3.close()
        L_0x00a0:
            java.lang.String r0 = ""
        L_0x00a2:
            return r0
        L_0x00a3:
            r0 = move-exception
        L_0x00a4:
            if (r8 == 0) goto L_0x00a9
            r8.close()
        L_0x00a9:
            if (r2 == 0) goto L_0x00ae
            r2.close()
        L_0x00ae:
            if (r3 == 0) goto L_0x00b3
            r3.close()
        L_0x00b3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.b.b(java.lang.String):java.lang.String");
    }

    public void c(String str, String str2, org.json.b bVar) throws IOException {
        if (bVar != null) {
            FileWriter fileWriter = null;
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    synchronized (b.class) {
                        try {
                            File file = new File(this.f18065b.getFilesDir(), str);
                            if (file.exists() || file.mkdir()) {
                                FileWriter fileWriter2 = new FileWriter(new File(file, str2), false);
                                try {
                                    fileWriter2.append(bVar.toString());
                                    fileWriter2.flush();
                                    fileWriter2.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileWriter = fileWriter2;
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                p n10 = this.f18064a.n();
                String e11 = this.f18064a.e();
                n10.t(e11, "writeFileOnInternalStorage: failed" + e10.getLocalizedMessage());
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Throwable th4) {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th4;
            }
        }
    }
}
