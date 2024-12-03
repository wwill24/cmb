package com.leanplum;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;

public class LeanplumInflater {
    private Context context;
    private LeanplumResources res;

    private LeanplumInflater(Context context2) {
        this.context = context2;
    }

    public static LeanplumInflater from(Context context2) {
        return new LeanplumInflater(context2);
    }

    public LeanplumResources getLeanplumResources() {
        return getLeanplumResources((Resources) null);
    }

    public View inflate(int i10) {
        return inflate(i10, (ViewGroup) null, false);
    }

    public LeanplumResources getLeanplumResources(Resources resources) {
        LeanplumResources leanplumResources = this.res;
        if (leanplumResources != null) {
            return leanplumResources;
        }
        if (resources == null) {
            resources = this.context.getResources();
        }
        if (resources instanceof LeanplumResources) {
            return (LeanplumResources) resources;
        }
        LeanplumResources leanplumResources2 = new LeanplumResources(resources);
        this.res = leanplumResources2;
        return leanplumResources2;
    }

    public View inflate(int i10, ViewGroup viewGroup) {
        return inflate(i10, viewGroup, viewGroup != null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cf A[SYNTHETIC, Splitter:B:50:0x00cf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View inflate(int r12, android.view.ViewGroup r13, boolean r14) {
        /*
            r11 = this;
            java.lang.String r0 = "Failed to close input stream."
            android.content.Context r1 = r11.context     // Catch:{ all -> 0x00fb }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ all -> 0x00fb }
            com.leanplum.LeanplumResources r1 = r11.getLeanplumResources(r1)     // Catch:{ all -> 0x00fb }
            com.leanplum.Var r1 = r1.getOverrideResource(r12)     // Catch:{ all -> 0x00fb }
            if (r1 == 0) goto L_0x00f0
            java.lang.String r2 = r1.stringValue     // Catch:{ all -> 0x00fb }
            java.lang.Object r3 = r1.defaultValue()     // Catch:{ all -> 0x00fb }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x0020
            goto L_0x00f0
        L_0x0020:
            int r2 = r1.overrideResId()     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x0031
            android.content.Context r0 = r11.context     // Catch:{ all -> 0x00fb }
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)     // Catch:{ all -> 0x00fb }
            android.view.View r12 = r0.inflate(r2, r13, r14)     // Catch:{ all -> 0x00fb }
            return r12
        L_0x0031:
            r2 = 0
            r3 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00aa }
            r4.<init>()     // Catch:{ all -> 0x00aa }
            java.io.InputStream r5 = r1.stream()     // Catch:{ all -> 0x00aa }
            r6 = 8192(0x2000, float:1.14794E-41)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x00a8 }
        L_0x0040:
            int r7 = r5.read(r6)     // Catch:{ all -> 0x00a8 }
            r8 = -1
            if (r7 <= r8) goto L_0x004b
            r4.write(r6, r3, r7)     // Catch:{ all -> 0x00a8 }
            goto L_0x0040
        L_0x004b:
            java.lang.String r6 = "android.content.res.XmlBlock"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x00a8 }
            r7 = 1
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x00a8 }
            java.lang.Class<byte[]> r9 = byte[].class
            r8[r3] = r9     // Catch:{ all -> 0x00a8 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r8)     // Catch:{ all -> 0x00a8 }
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x00a8 }
            byte[] r4 = r4.toByteArray()     // Catch:{ all -> 0x00a8 }
            r7[r3] = r4     // Catch:{ all -> 0x00a8 }
            java.lang.Object r4 = r6.newInstance(r7)     // Catch:{ all -> 0x00a8 }
            java.lang.Class r6 = r4.getClass()     // Catch:{ all -> 0x0097 }
            java.lang.String r7 = "newParser"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ all -> 0x0097 }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r8)     // Catch:{ all -> 0x0097 }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ all -> 0x0097 }
            java.lang.Object r4 = r6.invoke(r4, r7)     // Catch:{ all -> 0x0097 }
            android.content.res.XmlResourceParser r4 = (android.content.res.XmlResourceParser) r4     // Catch:{ all -> 0x0097 }
            android.content.Context r2 = r11.context     // Catch:{ all -> 0x0095 }
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)     // Catch:{ all -> 0x0095 }
            android.view.View r2 = r2.inflate(r4, r13, r14)     // Catch:{ all -> 0x0095 }
            if (r4 == 0) goto L_0x008b
            r4.close()     // Catch:{ all -> 0x00a8 }
        L_0x008b:
            r5.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0094
        L_0x008f:
            java.lang.Object[] r12 = new java.lang.Object[r3]
            com.leanplum.internal.Log.e((java.lang.String) r0, (java.lang.Object[]) r12)
        L_0x0094:
            return r2
        L_0x0095:
            r2 = move-exception
            goto L_0x009b
        L_0x0097:
            r4 = move-exception
            r10 = r4
            r4 = r2
            r2 = r10
        L_0x009b:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch:{ all -> 0x00a1 }
            r6.<init>(r2)     // Catch:{ all -> 0x00a1 }
            throw r6     // Catch:{ all -> 0x00a1 }
        L_0x00a1:
            r2 = move-exception
            if (r4 == 0) goto L_0x00a7
            r4.close()     // Catch:{ all -> 0x00a8 }
        L_0x00a7:
            throw r2     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r2 = move-exception
            goto L_0x00ad
        L_0x00aa:
            r4 = move-exception
            r5 = r2
            r2 = r4
        L_0x00ad:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
            r4.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Could not inflate resource "
            r4.append(r6)     // Catch:{ all -> 0x00e3 }
            r4.append(r12)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = ":"
            r4.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = r1.stringValue()     // Catch:{ all -> 0x00e3 }
            r4.append(r1)     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00e3 }
            com.leanplum.internal.Log.e((java.lang.String) r1, (java.lang.Throwable) r2)     // Catch:{ all -> 0x00e3 }
            if (r5 == 0) goto L_0x00d8
            r5.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00d8
        L_0x00d3:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.leanplum.internal.Log.e((java.lang.String) r0, (java.lang.Object[]) r1)
        L_0x00d8:
            android.content.Context r0 = r11.context
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            android.view.View r12 = r0.inflate(r12, r13, r14)
            return r12
        L_0x00e3:
            r12 = move-exception
            if (r5 == 0) goto L_0x00ef
            r5.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00ef
        L_0x00ea:
            java.lang.Object[] r13 = new java.lang.Object[r3]
            com.leanplum.internal.Log.e((java.lang.String) r0, (java.lang.Object[]) r13)
        L_0x00ef:
            throw r12
        L_0x00f0:
            android.content.Context r0 = r11.context     // Catch:{ all -> 0x00fb }
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)     // Catch:{ all -> 0x00fb }
            android.view.View r12 = r0.inflate(r12, r13, r14)     // Catch:{ all -> 0x00fb }
            return r12
        L_0x00fb:
            r0 = move-exception
            boolean r1 = r0 instanceof android.view.InflateException
            if (r1 != 0) goto L_0x0103
            com.leanplum.internal.Log.exception(r0)
        L_0x0103:
            android.content.Context r0 = r11.context
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            android.view.View r12 = r0.inflate(r12, r13, r14)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.LeanplumInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View");
    }
}
