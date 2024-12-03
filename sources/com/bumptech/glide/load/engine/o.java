package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.e;
import com.bumptech.glide.load.engine.g;
import f4.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l3.c;

public class o<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f9410a;

    /* renamed from: b  reason: collision with root package name */
    private final e<List<Throwable>> f9411b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends g<Data, ResourceType, Transcode>> f9412c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9413d;

    public o(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, e<List<Throwable>> eVar) {
        this.f9410a = cls;
        this.f9411b = eVar;
        this.f9412c = (List) j.c(list);
        this.f9413d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private c<Transcode> b(j3.e<Data> eVar, @NonNull i3.e eVar2, int i10, int i11, g.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.f9412c.size();
        c<Transcode> cVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            try {
                cVar = ((g) this.f9412c.get(i12)).a(eVar, i10, i11, eVar2, aVar);
            } catch (GlideException e10) {
                list2.add(e10);
            }
            if (cVar != null) {
                break;
            }
        }
        if (cVar != null) {
            return cVar;
        }
        throw new GlideException(this.f9413d, (List<Throwable>) new ArrayList(list2));
    }

    public c<Transcode> a(j3.e<Data> eVar, @NonNull i3.e eVar2, int i10, int i11, g.a<ResourceType> aVar) throws GlideException {
        List list = (List) j.d(this.f9411b.acquire());
        try {
            return b(eVar, eVar2, i10, i11, aVar, list);
        } finally {
            this.f9411b.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f9412c.toArray()) + '}';
    }
}
