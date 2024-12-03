package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final ReferenceQueue f21390a = new ReferenceQueue();

    /* renamed from: b  reason: collision with root package name */
    private final Set f21391b = Collections.synchronizedSet(new HashSet());

    /* renamed from: com.google.mlkit.common.sdkinternal.a$a  reason: collision with other inner class name */
    public interface C0248a {
        void a();
    }

    private a() {
    }

    @NonNull
    public static a a() {
        a aVar = new a();
        aVar.b(aVar, p.f21454a);
        Thread thread = new Thread(new o(aVar.f21390a, aVar.f21391b), "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return aVar;
    }

    @NonNull
    public C0248a b(@NonNull Object obj, @NonNull Runnable runnable) {
        r rVar = new r(obj, this.f21390a, this.f21391b, runnable, (q) null);
        this.f21391b.add(rVar);
        return rVar;
    }
}
