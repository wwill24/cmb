package androidx.fragment.app;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.a;
import java.util.ArrayList;
import x1.e;

class c0 {

    /* renamed from: a  reason: collision with root package name */
    static final e0 f5816a = new d0();

    /* renamed from: b  reason: collision with root package name */
    static final e0 f5817b = b();

    static void a(Fragment fragment, Fragment fragment2, boolean z10, a<String, View> aVar, boolean z11) {
        if (z10) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static e0 b() {
        try {
            return e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void c(@NonNull a<String, String> aVar, @NonNull a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.n(size))) {
                aVar.l(size);
            }
        }
    }

    static void d(ArrayList<View> arrayList, int i10) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i10);
            }
        }
    }
}
