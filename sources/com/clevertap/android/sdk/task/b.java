package com.clevertap.android.sdk.task;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import java.util.HashMap;
import java.util.concurrent.Executor;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final e f10795a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final u4.b f10796b;

    /* renamed from: c  reason: collision with root package name */
    public final u4.b f10797c;

    /* renamed from: d  reason: collision with root package name */
    protected final CleverTapInstanceConfig f10798d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, f> f10799e;

    b(CleverTapInstanceConfig cleverTapInstanceConfig) {
        u4.b bVar = new u4.b();
        this.f10796b = bVar;
        this.f10797c = bVar;
        this.f10799e = new HashMap<>();
        this.f10798d = cleverTapInstanceConfig;
    }

    public <TResult> Task<TResult> a() {
        return e(this.f10795a, this.f10797c, "ioTask");
    }

    public <TResult> Task<TResult> b() {
        return e(this.f10796b, this.f10797c, "Main");
    }

    public <TResult> Task<TResult> c() {
        return d(this.f10798d.e());
    }

    public <TResult> Task<TResult> d(String str) {
        if (str != null) {
            f fVar = this.f10799e.get(str);
            if (fVar == null) {
                fVar = new f();
                this.f10799e.put(str, fVar);
            }
            return e(fVar, this.f10797c, "PostAsyncSafely");
        }
        throw new IllegalArgumentException("Tag can't be null");
    }

    public <TResult> Task<TResult> e(Executor executor, Executor executor2, String str) {
        if (executor != null && executor2 != null) {
            return new Task<>(this.f10798d, executor, executor2, str);
        }
        throw new IllegalArgumentException("Can't create task " + str + " with null executors");
    }
}
