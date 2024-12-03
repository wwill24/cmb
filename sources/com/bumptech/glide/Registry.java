package com.bumptech.glide;

import a4.a;
import a4.b;
import a4.c;
import a4.d;
import a4.e;
import a4.f;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.g;
import j3.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p3.n;
import p3.o;
import p3.p;

public class Registry {

    /* renamed from: a  reason: collision with root package name */
    private final p f9142a;

    /* renamed from: b  reason: collision with root package name */
    private final a f9143b;

    /* renamed from: c  reason: collision with root package name */
    private final e f9144c;

    /* renamed from: d  reason: collision with root package name */
    private final f f9145d;

    /* renamed from: e  reason: collision with root package name */
    private final j3.f f9146e;

    /* renamed from: f  reason: collision with root package name */
    private final x3.f f9147f;

    /* renamed from: g  reason: collision with root package name */
    private final b f9148g;

    /* renamed from: h  reason: collision with root package name */
    private final d f9149h = new d();

    /* renamed from: i  reason: collision with root package name */
    private final c f9150i = new c();

    /* renamed from: j  reason: collision with root package name */
    private final androidx.core.util.e<List<Throwable>> f9151j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m10, @NonNull List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m10);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        androidx.core.util.e<List<Throwable>> e10 = g4.a.e();
        this.f9151j = e10;
        this.f9142a = new p(e10);
        this.f9143b = new a();
        this.f9144c = new e();
        this.f9145d = new f();
        this.f9146e = new j3.f();
        this.f9147f = new x3.f();
        this.f9148g = new b();
        s(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    @NonNull
    private <Data, TResource, Transcode> List<g<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.f9144c.d(cls, cls2)) {
            for (Class next2 : this.f9147f.b(next, cls3)) {
                arrayList.add(new g(cls, next, next2, this.f9144c.b(cls, next), this.f9147f.a(next, next2), this.f9151j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull i3.a<Data> aVar) {
        this.f9143b.a(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull i3.g<TResource> gVar) {
        this.f9145d.a(cls, gVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull i3.f<Data, TResource> fVar) {
        e("legacy_append", cls, cls2, fVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f9142a.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull i3.f<Data, TResource> fVar) {
        this.f9144c.a(str, fVar, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b10 = this.f9148g.b();
        if (!b10.isEmpty()) {
            return b10;
        }
        throw new NoImageHeaderParserException();
    }

    public <Data, TResource, Transcode> com.bumptech.glide.load.engine.o<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        com.bumptech.glide.load.engine.o<Data, TResource, Transcode> a10 = this.f9150i.a(cls, cls2, cls3);
        if (this.f9150i.c(a10)) {
            return null;
        }
        if (a10 == null) {
            List<g<Data, TResource, Transcode>> f10 = f(cls, cls2, cls3);
            if (f10.isEmpty()) {
                a10 = null;
            } else {
                a10 = new com.bumptech.glide.load.engine.o<>(cls, cls2, cls3, f10, this.f9151j);
            }
            this.f9150i.d(cls, cls2, cls3, a10);
        }
        return a10;
    }

    @NonNull
    public <Model> List<n<Model, ?>> i(@NonNull Model model) {
        return this.f9142a.d(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> a10 = this.f9149h.a(cls, cls2, cls3);
        if (a10 == null) {
            a10 = new ArrayList<>();
            for (Class<?> d10 : this.f9142a.c(cls)) {
                for (Class next : this.f9144c.d(d10, cls2)) {
                    if (!this.f9147f.b(next, cls3).isEmpty() && !a10.contains(next)) {
                        a10.add(next);
                    }
                }
            }
            this.f9149h.b(cls, cls2, cls3, Collections.unmodifiableList(a10));
        }
        return a10;
    }

    @NonNull
    public <X> i3.g<X> k(@NonNull l3.c<X> cVar) throws NoResultEncoderAvailableException {
        i3.g<X> b10 = this.f9145d.b(cVar.b());
        if (b10 != null) {
            return b10;
        }
        throw new NoResultEncoderAvailableException(cVar.b());
    }

    @NonNull
    public <X> j3.e<X> l(@NonNull X x10) {
        return this.f9146e.a(x10);
    }

    @NonNull
    public <X> i3.a<X> m(@NonNull X x10) throws NoSourceEncoderAvailableException {
        i3.a<X> b10 = this.f9143b.b(x10.getClass());
        if (b10 != null) {
            return b10;
        }
        throw new NoSourceEncoderAvailableException(x10.getClass());
    }

    public boolean n(@NonNull l3.c<?> cVar) {
        return this.f9145d.b(cVar.b()) != null;
    }

    @NonNull
    public Registry o(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f9148g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry p(@NonNull e.a<?> aVar) {
        this.f9146e.b(aVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry q(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull x3.e<TResource, Transcode> eVar) {
        this.f9147f.c(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry r(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f9142a.f(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public final Registry s(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f9144c.e(arrayList);
        return this;
    }
}
