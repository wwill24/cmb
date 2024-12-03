package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import me.h;
import pe.b;
import qe.c;
import qe.d;

public final class DynamiteModule {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f39208b = new d();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f39209c = new e();
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f39210d = new f();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f39211e = new g();
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public static final a f39212f = new h();
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public static final a f39213g = new i();

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f39214h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f39215i = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f39216j = false;

    /* renamed from: k  reason: collision with root package name */
    private static int f39217k = -1;

    /* renamed from: l  reason: collision with root package name */
    private static Boolean f39218l;

    /* renamed from: m  reason: collision with root package name */
    private static final ThreadLocal f39219m = new ThreadLocal();

    /* renamed from: n  reason: collision with root package name */
    private static final ThreadLocal f39220n = new b();

    /* renamed from: o  reason: collision with root package name */
    private static final a.C0484a f39221o = new c();
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public static final a f39222p = new j();

    /* renamed from: q  reason: collision with root package name */
    private static m f39223q;

    /* renamed from: r  reason: collision with root package name */
    private static n f39224r;

    /* renamed from: a  reason: collision with root package name */
    private final Context f39225a;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, d dVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th2, d dVar) {
            super(str, th2);
        }
    }

    public interface a {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a  reason: collision with other inner class name */
        public interface C0484a {
            int a(@NonNull Context context, @NonNull String str, boolean z10) throws LoadingException;

            int b(@NonNull Context context, @NonNull String str);
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f39226a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f39227b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f39228c = 0;
        }

        @NonNull
        b a(@NonNull Context context, @NonNull String str, @NonNull C0484a aVar) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        p.k(context);
        this.f39225a = context;
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (n.b(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            return 0;
        } catch (Exception e10) {
            "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage()));
            return 0;
        }
    }

    public static int b(@NonNull Context context, @NonNull String str) {
        return e(context, str, false);
    }

    @NonNull
    public static DynamiteModule d(@NonNull Context context, @NonNull a aVar, @NonNull String str) throws LoadingException {
        int i10;
        Boolean bool;
        DynamiteModule dynamiteModule;
        pe.a aVar2;
        n nVar;
        boolean z10;
        Boolean valueOf;
        pe.a aVar3;
        Context context2 = context;
        a aVar4 = aVar;
        String str2 = str;
        Class<DynamiteModule> cls = DynamiteModule.class;
        ThreadLocal threadLocal = f39219m;
        k kVar = (k) threadLocal.get();
        k kVar2 = new k((c) null);
        threadLocal.set(kVar2);
        ThreadLocal threadLocal2 = f39220n;
        long longValue = ((Long) threadLocal2.get()).longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            a.b a10 = aVar4.a(context2, str2, f39221o);
            int i11 = a10.f39226a;
            int i12 = a10.f39227b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Considering local module ");
            sb2.append(str2);
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append(i11);
            sb2.append(" and remote module ");
            sb2.append(str2);
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append(i12);
            int i13 = a10.f39228c;
            if (i13 != 0) {
                if (i13 == -1) {
                    if (a10.f39226a != 0) {
                        i13 = -1;
                    }
                }
                if (!(i13 == 1 && a10.f39227b == 0)) {
                    if (i13 == -1) {
                        DynamiteModule g10 = g(context2, str2);
                        if (longValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(longValue));
                        }
                        Cursor cursor = kVar2.f39229a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(kVar);
                        return g10;
                    } else if (i13 == 1) {
                        try {
                            int i14 = a10.f39227b;
                            try {
                                synchronized (cls) {
                                    if (j(context)) {
                                        bool = f39214h;
                                    } else {
                                        throw new LoadingException("Remote loading disabled", (d) null);
                                    }
                                }
                                if (bool != null) {
                                    if (bool.booleanValue()) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Selected remote version of ");
                                        sb3.append(str2);
                                        sb3.append(", version >= ");
                                        sb3.append(i14);
                                        synchronized (cls) {
                                            nVar = f39224r;
                                        }
                                        if (nVar != null) {
                                            k kVar3 = (k) threadLocal.get();
                                            if (kVar3 == null || kVar3.f39229a == null) {
                                                throw new LoadingException("No result cursor", (d) null);
                                            }
                                            Context applicationContext = context.getApplicationContext();
                                            Cursor cursor2 = kVar3.f39229a;
                                            b.g(null);
                                            synchronized (cls) {
                                                if (f39217k >= 2) {
                                                    z10 = true;
                                                } else {
                                                    z10 = false;
                                                }
                                                valueOf = Boolean.valueOf(z10);
                                            }
                                            if (valueOf.booleanValue()) {
                                                aVar3 = nVar.f(b.g(applicationContext), str2, i14, b.g(cursor2));
                                            } else {
                                                aVar3 = nVar.c(b.g(applicationContext), str2, i14, b.g(cursor2));
                                            }
                                            Context context3 = (Context) b.f(aVar3);
                                            if (context3 != null) {
                                                dynamiteModule = new DynamiteModule(context3);
                                            } else {
                                                throw new LoadingException("Failed to get module context", (d) null);
                                            }
                                        } else {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", (d) null);
                                        }
                                    } else {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("Selected remote version of ");
                                        sb4.append(str2);
                                        sb4.append(", version >= ");
                                        sb4.append(i14);
                                        m k10 = k(context);
                                        if (k10 != null) {
                                            int c10 = k10.c();
                                            if (c10 >= 3) {
                                                k kVar4 = (k) threadLocal.get();
                                                if (kVar4 != null) {
                                                    aVar2 = k10.v0(b.g(context), str2, i14, b.g(kVar4.f39229a));
                                                } else {
                                                    throw new LoadingException("No cached result cursor holder", (d) null);
                                                }
                                            } else if (c10 == 2) {
                                                aVar2 = k10.w0(b.g(context), str2, i14);
                                            } else {
                                                aVar2 = k10.W(b.g(context), str2, i14);
                                            }
                                            Object f10 = b.f(aVar2);
                                            if (f10 != null) {
                                                dynamiteModule = new DynamiteModule((Context) f10);
                                            } else {
                                                throw new LoadingException("Failed to load remote module.", (d) null);
                                            }
                                        } else {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", (d) null);
                                        }
                                    }
                                    if (longValue == 0) {
                                        threadLocal2.remove();
                                    } else {
                                        threadLocal2.set(Long.valueOf(longValue));
                                    }
                                    Cursor cursor3 = kVar2.f39229a;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    threadLocal.set(kVar);
                                    return dynamiteModule;
                                }
                                throw new LoadingException("Failed to determine which loading route to use.", (d) null);
                            } catch (RemoteException e10) {
                                throw new LoadingException("Failed to load remote module.", e10, (d) null);
                            } catch (LoadingException e11) {
                                throw e11;
                            } catch (Throwable th2) {
                                h.a(context2, th2);
                                throw new LoadingException("Failed to load remote module.", th2, (d) null);
                            }
                        } catch (LoadingException e12) {
                            String message = e12.getMessage();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Failed to load remote module: ");
                            sb5.append(message);
                            int i15 = a10.f39226a;
                            if (i15 != 0) {
                                if (aVar.a(context2, str2, new l(i15, 0)).f39228c == -1) {
                                    DynamiteModule g11 = g(context2, str2);
                                    if (i10 != 0) {
                                        f39220n.set(Long.valueOf(longValue));
                                    }
                                    return g11;
                                }
                            }
                            throw new LoadingException("Remote load failed. No local fallback found.", e12, (d) null);
                        }
                    } else {
                        throw new LoadingException("VersionPolicy returned invalid code:" + i13, (d) null);
                    }
                }
            }
            throw new LoadingException("No acceptable module " + str2 + " found. Local version is " + a10.f39226a + " and remote version is " + a10.f39227b + ".", (d) null);
        } finally {
            if (longValue == 0) {
                f39220n.remove();
            } else {
                f39220n.set(Long.valueOf(longValue));
            }
            Cursor cursor4 = kVar2.f39229a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f39219m.set(kVar);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:50:0x009a=Splitter:B:50:0x009a, B:17:0x003b=Splitter:B:17:0x003b} */
    public static int e(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.NonNull java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x0192 }
            java.lang.Boolean r1 = f39214h     // Catch:{ all -> 0x018f }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00cf
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b2 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            h(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x003f:
            boolean r5 = j(r10)     // Catch:{ all -> 0x00b2 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            return r3
        L_0x0048:
            boolean r5 = f39216j     // Catch:{ all -> 0x00b2 }
            if (r5 != 0) goto L_0x00a7
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b2 }
            boolean r6 = r5.equals(r2)     // Catch:{ all -> 0x00b2 }
            if (r6 == 0) goto L_0x0055
            goto L_0x00a7
        L_0x0055:
            r6 = 1
            int r6 = f(r10, r11, r12, r6)     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r7 = f39215i     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x009a
            boolean r7 = r7.isEmpty()     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x0065
            goto L_0x009a
        L_0x0065:
            java.lang.ClassLoader r7 = qe.b.a()     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x006c
            goto L_0x008f
        L_0x006c:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x009d }
            r8 = 29
            if (r7 < r8) goto L_0x0081
            dalvik.system.DelegateLastClassLoader r7 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r8 = f39215i     // Catch:{ LoadingException -> 0x009d }
            com.google.android.gms.common.internal.p.k(r8)     // Catch:{ LoadingException -> 0x009d }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009d }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x009d }
            goto L_0x008f
        L_0x0081:
            com.google.android.gms.dynamite.a r7 = new com.google.android.gms.dynamite.a     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r8 = f39215i     // Catch:{ LoadingException -> 0x009d }
            com.google.android.gms.common.internal.p.k(r8)     // Catch:{ LoadingException -> 0x009d }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009d }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x009d }
        L_0x008f:
            h(r7)     // Catch:{ LoadingException -> 0x009d }
            r1.set(r2, r7)     // Catch:{ LoadingException -> 0x009d }
            f39214h = r5     // Catch:{ LoadingException -> 0x009d }
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            return r6
        L_0x009a:
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            return r6
        L_0x009d:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x00a7:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
        L_0x00b0:
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            goto L_0x00cd
        L_0x00b2:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
        L_0x00b5:
            r1 = move-exception
            goto L_0x00ba
        L_0x00b7:
            r1 = move-exception
            goto L_0x00ba
        L_0x00b9:
            r1 = move-exception
        L_0x00ba:
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
            r4.<init>()     // Catch:{ all -> 0x018f }
            java.lang.String r5 = "Failed to load module via V2: "
            r4.append(r5)     // Catch:{ all -> 0x018f }
            r4.append(r1)     // Catch:{ all -> 0x018f }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x018f }
        L_0x00cd:
            f39214h = r1     // Catch:{ all -> 0x018f }
        L_0x00cf:
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x0192 }
            if (r0 == 0) goto L_0x00ee
            int r10 = f(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00db }
            return r10
        L_0x00db:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x0192 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0192 }
            r12.<init>()     // Catch:{ all -> 0x0192 }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r12.append(r0)     // Catch:{ all -> 0x0192 }
            r12.append(r11)     // Catch:{ all -> 0x0192 }
            return r3
        L_0x00ee:
            com.google.android.gms.dynamite.m r4 = k(r10)     // Catch:{ all -> 0x0192 }
            if (r4 != 0) goto L_0x00f6
            goto L_0x0186
        L_0x00f6:
            int r0 = r4.c()     // Catch:{ RemoteException -> 0x016e }
            r1 = 3
            if (r0 < r1) goto L_0x0157
            java.lang.ThreadLocal r0 = f39219m     // Catch:{ RemoteException -> 0x016e }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x016e }
            com.google.android.gms.dynamite.k r0 = (com.google.android.gms.dynamite.k) r0     // Catch:{ RemoteException -> 0x016e }
            if (r0 == 0) goto L_0x0111
            android.database.Cursor r0 = r0.f39229a     // Catch:{ RemoteException -> 0x016e }
            if (r0 == 0) goto L_0x0111
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x016e }
            goto L_0x0186
        L_0x0111:
            pe.a r5 = pe.b.g(r10)     // Catch:{ RemoteException -> 0x016e }
            java.lang.ThreadLocal r0 = f39220n     // Catch:{ RemoteException -> 0x016e }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x016e }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x016e }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x016e }
            r6 = r11
            r7 = r12
            pe.a r11 = r4.x0(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x016e }
            java.lang.Object r11 = pe.b.f(r11)     // Catch:{ RemoteException -> 0x016e }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x016e }
            if (r11 == 0) goto L_0x0151
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x014e, all -> 0x014b }
            if (r12 != 0) goto L_0x0136
            goto L_0x0151
        L_0x0136:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x014e, all -> 0x014b }
            if (r12 <= 0) goto L_0x0143
            boolean r0 = i(r11)     // Catch:{ RemoteException -> 0x014e, all -> 0x014b }
            if (r0 == 0) goto L_0x0143
            goto L_0x0144
        L_0x0143:
            r2 = r11
        L_0x0144:
            if (r2 == 0) goto L_0x0149
            r2.close()     // Catch:{ all -> 0x0192 }
        L_0x0149:
            r3 = r12
            goto L_0x0186
        L_0x014b:
            r12 = move-exception
            r2 = r11
            goto L_0x0189
        L_0x014e:
            r12 = move-exception
            r2 = r11
            goto L_0x0170
        L_0x0151:
            if (r11 == 0) goto L_0x0186
            r11.close()     // Catch:{ all -> 0x0192 }
            goto L_0x0186
        L_0x0157:
            r1 = 2
            if (r0 != r1) goto L_0x0163
            pe.a r0 = pe.b.g(r10)     // Catch:{ RemoteException -> 0x016e }
            int r3 = r4.g(r0, r11, r12)     // Catch:{ RemoteException -> 0x016e }
            goto L_0x0186
        L_0x0163:
            pe.a r0 = pe.b.g(r10)     // Catch:{ RemoteException -> 0x016e }
            int r3 = r4.f(r0, r11, r12)     // Catch:{ RemoteException -> 0x016e }
            goto L_0x0186
        L_0x016c:
            r12 = r11
            goto L_0x0189
        L_0x016e:
            r11 = move-exception
            r12 = r11
        L_0x0170:
            java.lang.String r11 = r12.getMessage()     // Catch:{ all -> 0x0187 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0187 }
            r12.<init>()     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r12.append(r0)     // Catch:{ all -> 0x0187 }
            r12.append(r11)     // Catch:{ all -> 0x0187 }
            if (r2 == 0) goto L_0x0186
            r2.close()     // Catch:{ all -> 0x0192 }
        L_0x0186:
            return r3
        L_0x0187:
            r11 = move-exception
            goto L_0x016c
        L_0x0189:
            if (r2 == 0) goto L_0x018e
            r2.close()     // Catch:{ all -> 0x0192 }
        L_0x018e:
            throw r12     // Catch:{ all -> 0x0192 }
        L_0x018f:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            throw r11     // Catch:{ all -> 0x0192 }
        L_0x0192:
            r11 = move-exception
            me.h.a(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5 A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b6 A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int f(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = f39220n     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            r12.<init>()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            if (r10 == 0) goto L_0x00a3
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009b }
            if (r11 == 0) goto L_0x00a3
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009b }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009b }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            f39215i = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            f39217k = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = r11
        L_0x007f:
            f39216j = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = i(r10)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x008e:
            if (r13 == 0) goto L_0x009d
            if (r11 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r11 = move-exception
            goto L_0x00b1
        L_0x009d:
            if (r10 == 0) goto L_0x00a2
            r10.close()
        L_0x00a2:
            return r12
        L_0x00a3:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x00ab:
            r10 = move-exception
            r11 = r10
            goto L_0x00c0
        L_0x00ae:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00b1:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00be }
            if (r12 == 0) goto L_0x00b6
            throw r11     // Catch:{ all -> 0x00be }
        L_0x00b6:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00be }
            java.lang.String r13 = "V2 version check failed"
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x00be }
            throw r12     // Catch:{ all -> 0x00be }
        L_0x00be:
            r11 = move-exception
            r0 = r10
        L_0x00c0:
            if (r0 == 0) goto L_0x00c5
            r0.close()
        L_0x00c5:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.f(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule g(Context context, String str) {
        "Selected local version of ".concat(String.valueOf(str));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static void h(ClassLoader classLoader) throws LoadingException {
        n nVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                nVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof n) {
                    nVar = (n) queryLocalInterface;
                } else {
                    nVar = new n(iBinder);
                }
            }
            f39224r = nVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            throw new LoadingException("Failed to instantiate dynamite loader", e10, (d) null);
        }
    }

    private static boolean i(Cursor cursor) {
        k kVar = (k) f39219m.get();
        if (kVar == null || kVar.f39229a != null) {
            return false;
        }
        kVar.f39229a = cursor;
        return true;
    }

    private static boolean j(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals((Object) null) || bool.equals(f39218l)) {
            return true;
        }
        boolean z10 = false;
        if (f39218l == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (com.google.android.gms.common.d.h().j(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z10 = true;
            }
            Boolean valueOf = Boolean.valueOf(z10);
            f39218l = valueOf;
            z10 = valueOf.booleanValue();
            if (z10 && resolveContentProvider != null && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                f39216j = true;
            }
        }
        return z10;
    }

    private static m k(Context context) {
        m mVar;
        synchronized (DynamiteModule.class) {
            m mVar2 = f39223q;
            if (mVar2 != null) {
                return mVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    mVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof m) {
                        mVar = (m) queryLocalInterface;
                    } else {
                        mVar = new m(iBinder);
                    }
                }
                if (mVar != null) {
                    f39223q = mVar;
                    return mVar;
                }
            } catch (Exception e10) {
                String message = e10.getMessage();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb2.append(message);
            }
        }
        return null;
    }

    @NonNull
    public IBinder c(@NonNull String str) throws LoadingException {
        try {
            return (IBinder) this.f39225a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e10, (d) null);
        }
    }
}
