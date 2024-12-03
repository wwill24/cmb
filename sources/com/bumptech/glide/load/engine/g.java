package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import f4.j;
import i3.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import l3.c;
import x3.e;

public class g<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f9334a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends f<DataType, ResourceType>> f9335b;

    /* renamed from: c  reason: collision with root package name */
    private final e<ResourceType, Transcode> f9336c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.core.util.e<List<Throwable>> f9337d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9338e;

    interface a<ResourceType> {
        @NonNull
        c<ResourceType> a(@NonNull c<ResourceType> cVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends f<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, androidx.core.util.e<List<Throwable>> eVar2) {
        this.f9334a = cls;
        this.f9335b = list;
        this.f9336c = eVar;
        this.f9337d = eVar2;
        this.f9338e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private c<ResourceType> b(j3.e<DataType> eVar, int i10, int i11, @NonNull i3.e eVar2) throws GlideException {
        List list = (List) j.d(this.f9337d.acquire());
        try {
            return c(eVar, i10, i11, eVar2, list);
        } finally {
            this.f9337d.a(list);
        }
    }

    @NonNull
    private c<ResourceType> c(j3.e<DataType> eVar, int i10, int i11, @NonNull i3.e eVar2, List<Throwable> list) throws GlideException {
        int size = this.f9335b.size();
        c<ResourceType> cVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            f fVar = (f) this.f9335b.get(i12);
            try {
                if (fVar.b(eVar.a(), eVar2)) {
                    cVar = fVar.a(eVar.a(), i10, i11, eVar2);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to decode data for ");
                    sb2.append(fVar);
                }
                list.add(e10);
            }
            if (cVar != null) {
                break;
            }
        }
        if (cVar != null) {
            return cVar;
        }
        throw new GlideException(this.f9338e, (List<Throwable>) new ArrayList(list));
    }

    public c<Transcode> a(j3.e<DataType> eVar, int i10, int i11, @NonNull i3.e eVar2, a<ResourceType> aVar) throws GlideException {
        return this.f9336c.a(aVar.a(b(eVar, i10, i11, eVar2)), eVar2);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f9334a + ", decoders=" + this.f9335b + ", transcoder=" + this.f9336c + '}';
    }
}
