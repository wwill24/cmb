package a4;

import androidx.collection.a;
import androidx.core.util.e;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.o;
import f4.i;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final o<?, ?, ?> f137c = new o(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new x3.g(), (e<List<Throwable>>) null)), (e<List<Throwable>>) null);

    /* renamed from: a  reason: collision with root package name */
    private final a<i, o<?, ?, ?>> f138a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<i> f139b = new AtomicReference<>();

    private i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        i andSet = this.f139b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> o<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        o<Data, TResource, Transcode> oVar;
        i b10 = b(cls, cls2, cls3);
        synchronized (this.f138a) {
            oVar = this.f138a.get(b10);
        }
        this.f139b.set(b10);
        return oVar;
    }

    public boolean c(o<?, ?, ?> oVar) {
        return f137c.equals(oVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, o<?, ?, ?> oVar) {
        synchronized (this.f138a) {
            a<i, o<?, ?, ?>> aVar = this.f138a;
            i iVar = new i(cls, cls2, cls3);
            if (oVar == null) {
                oVar = f137c;
            }
            aVar.put(iVar, oVar);
        }
    }
}
