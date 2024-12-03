package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.d;
import androidx.savedstate.a;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import gk.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.i;

public final class a0 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f5992f = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Class<? extends Object>[] f5993g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f5994a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, a.c> f5995b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, b<?>> f5996c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, i<Object>> f5997d;

    /* renamed from: e  reason: collision with root package name */
    private final a.c f5998e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a0 a(Bundle bundle, Bundle bundle2) {
            boolean z10;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(UserMetadata.KEYDATA_FILENAME);
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int size = parcelableArrayList.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        Object obj = parcelableArrayList.get(i10);
                        j.e(obj, "null cannot be cast to non-null type kotlin.String");
                        linkedHashMap.put((String) obj, parcelableArrayList2.get(i10));
                    }
                    return new a0(linkedHashMap);
                }
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            } else if (bundle2 == null) {
                return new a0();
            } else {
                HashMap hashMap = new HashMap();
                for (String next : bundle2.keySet()) {
                    j.f(next, SDKConstants.PARAM_KEY);
                    hashMap.put(next, bundle2.get(next));
                }
                return new a0(hashMap);
            }
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : a0.f5993g) {
                j.d(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class b<T> extends t<T> {

        /* renamed from: l  reason: collision with root package name */
        private String f5999l;

        /* renamed from: m  reason: collision with root package name */
        private a0 f6000m;

        public void o(T t10) {
            a0 a0Var = this.f6000m;
            if (a0Var != null) {
                a0Var.f5994a.put(this.f5999l, t10);
                i iVar = (i) a0Var.f5997d.get(this.f5999l);
                if (iVar != null) {
                    iVar.setValue(t10);
                }
            }
            super.o(t10);
        }

        public final void p() {
            this.f6000m = null;
        }
    }

    public a0(Map<String, ? extends Object> map) {
        j.g(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f5994a = linkedHashMap;
        this.f5995b = new LinkedHashMap();
        this.f5996c = new LinkedHashMap();
        this.f5997d = new LinkedHashMap();
        this.f5998e = new z(this);
        linkedHashMap.putAll(map);
    }

    /* access modifiers changed from: private */
    public static final Bundle h(a0 a0Var) {
        j.g(a0Var, "this$0");
        for (Map.Entry entry : h0.u(a0Var.f5995b).entrySet()) {
            a0Var.i((String) entry.getKey(), ((a.c) entry.getValue()).a());
        }
        Set<String> keySet = a0Var.f5994a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String next : keySet) {
            arrayList.add(next);
            arrayList2.add(a0Var.f5994a.get(next));
        }
        return d.a(h.a(UserMetadata.KEYDATA_FILENAME, arrayList), h.a("values", arrayList2));
    }

    public final <T> T e(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        try {
            return this.f5994a.get(str);
        } catch (ClassCastException unused) {
            f(str);
            return null;
        }
    }

    public final <T> T f(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        T remove = this.f5994a.remove(str);
        b remove2 = this.f5996c.remove(str);
        if (remove2 != null) {
            remove2.p();
        }
        this.f5997d.remove(str);
        return remove;
    }

    public final a.c g() {
        return this.f5998e;
    }

    public final <T> void i(String str, T t10) {
        t tVar;
        j.g(str, SDKConstants.PARAM_KEY);
        if (f5992f.b(t10)) {
            b<?> bVar = this.f5996c.get(str);
            if (bVar instanceof t) {
                tVar = bVar;
            } else {
                tVar = null;
            }
            if (tVar != null) {
                tVar.o(t10);
            } else {
                this.f5994a.put(str, t10);
            }
            i iVar = this.f5997d.get(str);
            if (iVar != null) {
                iVar.setValue(t10);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't put value with type ");
        j.d(t10);
        sb2.append(t10.getClass());
        sb2.append(" into saved state");
        throw new IllegalArgumentException(sb2.toString());
    }

    public a0() {
        this.f5994a = new LinkedHashMap();
        this.f5995b = new LinkedHashMap();
        this.f5996c = new LinkedHashMap();
        this.f5997d = new LinkedHashMap();
        this.f5998e = new z(this);
    }
}
