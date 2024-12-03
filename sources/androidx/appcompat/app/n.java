package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.f;
import com.leanplum.internal.Constants;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

class n {

    static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Object f574a = new Object();

        /* renamed from: b  reason: collision with root package name */
        final Queue<Runnable> f575b = new ArrayDeque();

        /* renamed from: c  reason: collision with root package name */
        final Executor f576c;

        /* renamed from: d  reason: collision with root package name */
        Runnable f577d;

        a(Executor executor) {
            this.f576c = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                c();
            }
        }

        /* access modifiers changed from: protected */
        public void c() {
            synchronized (this.f574a) {
                Runnable poll = this.f575b.poll();
                this.f577d = poll;
                if (poll != null) {
                    this.f576c.execute(poll);
                }
            }
        }

        public void execute(Runnable runnable) {
            synchronized (this.f574a) {
                this.f575b.add(new m(this, runnable));
                if (this.f577d == null) {
                    c();
                }
            }
        }
    }

    static class b implements Executor {
        b() {
        }

        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("Storing App Locales : Failed to persist app-locales: ");
        r0.append(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
        if (r5 != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x004c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            java.lang.String r0 = "locales"
            java.lang.String r1 = ""
            boolean r1 = r6.equals(r1)
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            if (r1 == 0) goto L_0x0010
            r5.deleteFile(r2)
            return
        L_0x0010:
            r1 = 0
            java.io.FileOutputStream r5 = r5.openFileOutput(r2, r1)     // Catch:{ FileNotFoundException -> 0x0063 }
            org.xmlpull.v1.XmlSerializer r1 = android.util.Xml.newSerializer()
            r2 = 0
            r1.setOutput(r5, r2)     // Catch:{ Exception -> 0x004c }
            java.lang.String r3 = "UTF-8"
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x004c }
            r1.startDocument(r3, r4)     // Catch:{ Exception -> 0x004c }
            r1.startTag(r2, r0)     // Catch:{ Exception -> 0x004c }
            java.lang.String r3 = "application_locales"
            r1.attribute(r2, r3, r6)     // Catch:{ Exception -> 0x004c }
            r1.endTag(r2, r0)     // Catch:{ Exception -> 0x004c }
            r1.endDocument()     // Catch:{ Exception -> 0x004c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004c }
            r0.<init>()     // Catch:{ Exception -> 0x004c }
            java.lang.String r1 = "Storing App Locales : app-locales: "
            r0.append(r1)     // Catch:{ Exception -> 0x004c }
            r0.append(r6)     // Catch:{ Exception -> 0x004c }
            java.lang.String r1 = " persisted successfully."
            r0.append(r1)     // Catch:{ Exception -> 0x004c }
            if (r5 == 0) goto L_0x005c
        L_0x0046:
            r5.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x005c
        L_0x004a:
            r6 = move-exception
            goto L_0x005d
        L_0x004c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r0.<init>()     // Catch:{ all -> 0x004a }
            java.lang.String r1 = "Storing App Locales : Failed to persist app-locales: "
            r0.append(r1)     // Catch:{ all -> 0x004a }
            r0.append(r6)     // Catch:{ all -> 0x004a }
            if (r5 == 0) goto L_0x005c
            goto L_0x0046
        L_0x005c:
            return
        L_0x005d:
            if (r5 == 0) goto L_0x0062
            r5.close()     // Catch:{ IOException -> 0x0062 }
        L_0x0062:
            throw r6
        L_0x0063:
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r1] = r2
            java.lang.String r6 = "Storing App Locales : FileNotFoundException: Cannot open file %s for writing "
            java.lang.String.format(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.n.a(android.content.Context, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r2 != null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        if (r2 == null) goto L_0x004e;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String b(@androidx.annotation.NonNull android.content.Context r8) {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r1 = ""
            java.io.FileInputStream r2 = r8.openFileInput(r0)     // Catch:{ FileNotFoundException -> 0x0065 }
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch:{ IOException | XmlPullParserException -> 0x004b, all -> 0x0044 }
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch:{ IOException | XmlPullParserException -> 0x004b, all -> 0x0044 }
            int r4 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x004b, all -> 0x0044 }
        L_0x0015:
            int r5 = r3.next()     // Catch:{ IOException | XmlPullParserException -> 0x004b, all -> 0x0044 }
            r6 = 1
            if (r5 == r6) goto L_0x003e
            r6 = 3
            if (r5 != r6) goto L_0x0025
            int r7 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x004b, all -> 0x0044 }
            if (r7 <= r4) goto L_0x003e
        L_0x0025:
            if (r5 == r6) goto L_0x0015
            r6 = 4
            if (r5 != r6) goto L_0x002b
            goto L_0x0015
        L_0x002b:
            java.lang.String r5 = r3.getName()     // Catch:{ IOException | XmlPullParserException -> 0x004b, all -> 0x0044 }
            java.lang.String r6 = "locales"
            boolean r5 = r5.equals(r6)     // Catch:{ IOException | XmlPullParserException -> 0x004b, all -> 0x0044 }
            if (r5 == 0) goto L_0x0015
            r4 = 0
            java.lang.String r5 = "application_locales"
            java.lang.String r1 = r3.getAttributeValue(r4, r5)     // Catch:{ IOException | XmlPullParserException -> 0x004b, all -> 0x0044 }
        L_0x003e:
            if (r2 == 0) goto L_0x004e
        L_0x0040:
            r2.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x004e
        L_0x0044:
            r8 = move-exception
            if (r2 == 0) goto L_0x004a
            r2.close()     // Catch:{ IOException -> 0x004a }
        L_0x004a:
            throw r8
        L_0x004b:
            if (r2 == 0) goto L_0x004e
            goto L_0x0040
        L_0x004e:
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0062
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: "
            r8.append(r0)
            r8.append(r1)
            goto L_0x0065
        L_0x0062:
            r8.deleteFile(r0)
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.n.b(android.content.Context):java.lang.String");
    }

    static void c(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (f.k().e()) {
                    String b10 = b(context);
                    Object systemService = context.getSystemService(Constants.Keys.LOCALE);
                    if (systemService != null) {
                        f.b.b(systemService, f.a.a(b10));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }
}
