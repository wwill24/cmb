package g1;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.emoji2.text.n;

final class b extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f15004a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile Editable.Factory f15005b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f15006c;

    @SuppressLint({"PrivateApi"})
    private b() {
        try {
            f15006c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f15005b == null) {
            synchronized (f15004a) {
                if (f15005b == null) {
                    f15005b = new b();
                }
            }
        }
        return f15005b;
    }

    public Editable newEditable(@NonNull CharSequence charSequence) {
        Class<?> cls = f15006c;
        if (cls != null) {
            return n.c(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
