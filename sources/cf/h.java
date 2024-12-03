package cf;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import androidx.collection.g;
import java.util.ArrayList;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final g<String, i> f18990a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    private final g<String, PropertyValuesHolder[]> f18991b = new g<>();

    private static void a(@NonNull h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.h(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.i(objectAnimator.getPropertyName(), i.b(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    public static h b(@NonNull Context context, @NonNull TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static h c(@NonNull Context context, int i10) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i10);
            if (loadAnimator instanceof AnimatorSet) {
                return d(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return d(arrayList);
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't load animation resource ID #0x");
            sb2.append(Integer.toHexString(i10));
            return null;
        }
    }

    @NonNull
    private static h d(@NonNull List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(hVar, list.get(i10));
        }
        return hVar;
    }

    public i e(String str) {
        if (g(str)) {
            return this.f18990a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f18990a.equals(((h) obj).f18990a);
    }

    public long f() {
        int size = this.f18990a.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i n10 = this.f18990a.n(i10);
            j10 = Math.max(j10, n10.c() + n10.d());
        }
        return j10;
    }

    public boolean g(String str) {
        return this.f18990a.get(str) != null;
    }

    public void h(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f18991b.put(str, propertyValuesHolderArr);
    }

    public int hashCode() {
        return this.f18990a.hashCode();
    }

    public void i(String str, i iVar) {
        this.f18990a.put(str, iVar);
    }

    @NonNull
    public String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f18990a + "}\n";
    }
}
