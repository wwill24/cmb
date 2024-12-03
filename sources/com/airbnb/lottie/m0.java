package com.airbnb.lottie;

import androidx.core.util.d;
import c3.h;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class m0 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8610a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f8611b = new androidx.collection.b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, h> f8612c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<d<String, Float>> f8613d = new a();

    class a implements Comparator<d<String, Float>> {
        a() {
        }

        /* renamed from: a */
        public int compare(d<String, Float> dVar, d<String, Float> dVar2) {
            float floatValue = ((Float) dVar.f4736b).floatValue();
            float floatValue2 = ((Float) dVar2.f4736b).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    }

    public interface b {
        void a(float f10);
    }

    public void a(String str, float f10) {
        if (this.f8610a) {
            h hVar = this.f8612c.get(str);
            if (hVar == null) {
                hVar = new h();
                this.f8612c.put(str, hVar);
            }
            hVar.a(f10);
            if (str.equals("__container")) {
                for (b a10 : this.f8611b) {
                    a10.a(f10);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z10) {
        this.f8610a = z10;
    }
}
