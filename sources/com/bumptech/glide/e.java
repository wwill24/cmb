package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import c4.f;
import c4.i;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.h;
import java.util.List;
import java.util.Map;
import m3.b;

public class e extends ContextWrapper {

    /* renamed from: k  reason: collision with root package name */
    static final i<?, ?> f9184k = new b();

    /* renamed from: a  reason: collision with root package name */
    private final b f9185a;

    /* renamed from: b  reason: collision with root package name */
    private final Registry f9186b;

    /* renamed from: c  reason: collision with root package name */
    private final f f9187c;

    /* renamed from: d  reason: collision with root package name */
    private final c.a f9188d;

    /* renamed from: e  reason: collision with root package name */
    private final List<b4.b<Object>> f9189e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, i<?, ?>> f9190f;

    /* renamed from: g  reason: collision with root package name */
    private final h f9191g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f9192h;

    /* renamed from: i  reason: collision with root package name */
    private final int f9193i;

    /* renamed from: j  reason: collision with root package name */
    private b4.c f9194j;

    public e(@NonNull Context context, @NonNull b bVar, @NonNull Registry registry, @NonNull f fVar, @NonNull c.a aVar, @NonNull Map<Class<?>, i<?, ?>> map, @NonNull List<b4.b<Object>> list, @NonNull h hVar, boolean z10, int i10) {
        super(context.getApplicationContext());
        this.f9185a = bVar;
        this.f9186b = registry;
        this.f9187c = fVar;
        this.f9188d = aVar;
        this.f9189e = list;
        this.f9190f = map;
        this.f9191g = hVar;
        this.f9192h = z10;
        this.f9193i = i10;
    }

    @NonNull
    public <X> i<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f9187c.a(imageView, cls);
    }

    @NonNull
    public b b() {
        return this.f9185a;
    }

    public List<b4.b<Object>> c() {
        return this.f9189e;
    }

    public synchronized b4.c d() {
        if (this.f9194j == null) {
            this.f9194j = (b4.c) this.f9188d.build().Q();
        }
        return this.f9194j;
    }

    @NonNull
    public <T> i<?, T> e(@NonNull Class<T> cls) {
        i<?, T> iVar = this.f9190f.get(cls);
        if (iVar == null) {
            for (Map.Entry next : this.f9190f.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    iVar = (i) next.getValue();
                }
            }
        }
        if (iVar == null) {
            return f9184k;
        }
        return iVar;
    }

    @NonNull
    public h f() {
        return this.f9191g;
    }

    public int g() {
        return this.f9193i;
    }

    @NonNull
    public Registry h() {
        return this.f9186b;
    }

    public boolean i() {
        return this.f9192h;
    }
}
