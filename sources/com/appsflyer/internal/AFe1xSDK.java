package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFe1vSDK;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AFe1xSDK {
    public volatile boolean AFInAppEventParameterName = false;
    public volatile String AFInAppEventType;
    @NonNull
    public final AFc1ySDK AFKeystoreWrapper;
    @NonNull
    private final AFe1vSDK afDebugLog;
    private boolean afErrorLog = false;
    public volatile String valueOf;
    Map<String, Object> values;

    public AFe1xSDK(@NonNull AFc1ySDK aFc1ySDK, @NonNull AFe1vSDK aFe1vSDK) {
        this.AFKeystoreWrapper = aFc1ySDK;
        this.afDebugLog = aFe1vSDK;
    }

    private boolean AFInAppEventParameterName() {
        Map<String, Object> map = this.values;
        return map != null && !map.isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String AFInAppEventType(com.appsflyer.internal.AFb1gSDK r10) {
        /*
            r9 = this;
            java.lang.String r0 = "use cached IMEI: "
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "collectIMEI"
            r3 = 0
            boolean r1 = r1.getBoolean(r2, r3)
            java.lang.String r2 = "imeiCached"
            r4 = 0
            java.lang.String r5 = r10.valueOf((java.lang.String) r2, (java.lang.String) r4)
            if (r1 == 0) goto L_0x009a
            java.lang.String r1 = r9.valueOf
            boolean r1 = com.appsflyer.internal.AFb1nSDK.AFInAppEventParameterName(r1)
            if (r1 == 0) goto L_0x009a
            com.appsflyer.internal.AFc1ySDK r1 = r9.AFKeystoreWrapper
            android.content.Context r1 = r1.values
            if (r1 == 0) goto L_0x00a1
            boolean r6 = valueOf(r1)
            if (r6 == 0) goto L_0x00a1
            java.lang.String r6 = "phone"
            java.lang.Object r1 = r1.getSystemService(r6)     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            java.lang.Class r6 = r1.getClass()     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            java.lang.String r7 = "getDeviceId"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r8)     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            java.lang.Object r1 = r6.invoke(r1, r3)     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0049
            goto L_0x00a2
        L_0x0049:
            if (r5 == 0) goto L_0x0053
            java.lang.String r1 = r0.concat(r5)     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ InvocationTargetException -> 0x0077, Exception -> 0x0055 }
            goto L_0x0098
        L_0x0053:
            r5 = r4
            goto L_0x0098
        L_0x0055:
            r1 = move-exception
            if (r5 == 0) goto L_0x0060
            java.lang.String r0 = r0.concat(r5)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L_0x0061
        L_0x0060:
            r5 = r4
        L_0x0061:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "WARNING: Can't collect IMEI: other reason: "
            r0.<init>(r3)
            java.lang.String r3 = r1.getMessage()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
            goto L_0x0098
        L_0x0077:
            r1 = move-exception
            if (r5 == 0) goto L_0x0082
            java.lang.String r0 = r0.concat(r5)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L_0x0083
        L_0x0082:
            r5 = r4
        L_0x0083:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "WARNING: Can't collect IMEI because of missing permissions: "
            r0.<init>(r3)
            java.lang.String r3 = r1.getMessage()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
        L_0x0098:
            r1 = r5
            goto L_0x00a2
        L_0x009a:
            java.lang.String r0 = r9.valueOf
            if (r0 == 0) goto L_0x00a1
            java.lang.String r1 = r9.valueOf
            goto L_0x00a2
        L_0x00a1:
            r1 = r4
        L_0x00a2:
            boolean r0 = com.appsflyer.internal.AFb1nSDK.AFInAppEventParameterName(r1)
            if (r0 != 0) goto L_0x00ac
            r10.AFInAppEventParameterName((java.lang.String) r2, (java.lang.String) r1)
            return r1
        L_0x00ac:
            java.lang.String r10 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1xSDK.AFInAppEventType(com.appsflyer.internal.AFb1gSDK):java.lang.String");
    }

    public final boolean AFKeystoreWrapper() {
        return this.AFInAppEventParameterName;
    }

    public final boolean valueOf() {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            AFe1vSDK aFe1vSDK = this.afDebugLog;
            Context context = this.AFKeystoreWrapper.values;
            AnonymousClass5 r62 = new AFe1vSDK.AFa1zSDK() {
                public final void AFKeystoreWrapper(String str, Exception exc) {
                    AFe1xSDK.this.values = new ConcurrentHashMap();
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    AFe1xSDK.this.values.put("error", message);
                    AFLogger.afErrorLog(str, exc, true, true, false);
                }

                public final void valueOf(@NonNull String str, @NonNull String str2) {
                    AFe1xSDK.this.values = new ConcurrentHashMap();
                    AFe1xSDK.this.values.put("signedData", str);
                    AFe1xSDK.this.values.put("signature", str2);
                    AFe1xSDK.this.values.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
                }
            };
            try {
                Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                AFe1vSDK.AnonymousClass5 r92 = new InvocationHandler(r62) {
                    private /* synthetic */ AFa1zSDK AFKeystoreWrapper;

                    public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.AFe1vSDK.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1vSDK.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                method.invoke((Object) null, new Object[]{Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r92)});
            } catch (ClassNotFoundException e10) {
                r62.AFKeystoreWrapper(e10.getClass().getSimpleName(), e10);
            } catch (NoSuchMethodException e11) {
                r62.AFKeystoreWrapper(e11.getClass().getSimpleName(), e11);
            } catch (IllegalAccessException e12) {
                r62.AFKeystoreWrapper(e12.getClass().getSimpleName(), e12);
            } catch (InvocationTargetException e13) {
                r62.AFKeystoreWrapper(e13.getClass().getSimpleName(), e13);
            }
            this.afErrorLog = true;
        } catch (ClassNotFoundException unused) {
            this.afErrorLog = false;
        }
        return this.afErrorLog;
    }

    @NonNull
    public final Map<String, Object> values() {
        HashMap hashMap = new HashMap();
        if (AFInAppEventParameterName()) {
            hashMap.put("lvl", this.values);
        } else if (this.afErrorLog) {
            HashMap hashMap2 = new HashMap();
            this.values = hashMap2;
            hashMap2.put("error", "operation timed out.");
            hashMap.put("lvl", this.values);
        }
        return hashMap;
    }

    private static boolean valueOf(Context context) {
        if (!(AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false))) {
            AFb1zSDK.AFInAppEventType();
            if (!AFb1zSDK.values(context)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean AFInAppEventType() {
        return this.afErrorLog && !AFInAppEventParameterName();
    }
}
