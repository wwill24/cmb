package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class n {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f39025a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final Object f39026b;

        /* synthetic */ a(Object obj, z0 z0Var) {
            p.k(obj);
            this.f39026b = obj;
        }

        @NonNull
        public a a(@NonNull String str, Object obj) {
            List list = this.f39025a;
            p.k(str);
            String valueOf = String.valueOf(obj);
            list.add(str + "=" + valueOf);
            return this;
        }

        @NonNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f39026b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f39025a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append((String) this.f39025a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static boolean a(@NonNull Bundle bundle, @NonNull Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            if (bundle == bundle2) {
                return true;
            }
            return false;
        } else if (bundle.size() != bundle2.size()) {
            return false;
        } else {
            Set<String> keySet = bundle.keySet();
            if (!keySet.containsAll(bundle2.keySet())) {
                return false;
            }
            for (String next : keySet) {
                if (!b(bundle.get(next), bundle2.get(next))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int c(@NonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @NonNull
    public static a d(@NonNull Object obj) {
        return new a(obj, (z0) null);
    }
}
