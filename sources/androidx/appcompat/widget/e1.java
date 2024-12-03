package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class e1 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1259c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<e1>> f1260d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1261a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f1262b;

    private e1(@NonNull Context context) {
        super(context);
        if (s1.d()) {
            s1 s1Var = new s1(this, context.getResources());
            this.f1261a = s1Var;
            Resources.Theme newTheme = s1Var.newTheme();
            this.f1262b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1261a = new g1(this, context.getResources());
        this.f1262b = null;
    }

    private static boolean a(@NonNull Context context) {
        if ((context instanceof e1) || (context.getResources() instanceof g1) || (context.getResources() instanceof s1) || !s1.d()) {
            return false;
        }
        return true;
    }

    public static Context b(@NonNull Context context) {
        e1 e1Var;
        if (!a(context)) {
            return context;
        }
        synchronized (f1259c) {
            ArrayList<WeakReference<e1>> arrayList = f1260d;
            if (arrayList == null) {
                f1260d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1260d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1260d.remove(size);
                    }
                }
                for (int size2 = f1260d.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1260d.get(size2);
                    if (weakReference2 != null) {
                        e1Var = (e1) weakReference2.get();
                    } else {
                        e1Var = null;
                    }
                    if (e1Var != null && e1Var.getBaseContext() == context) {
                        return e1Var;
                    }
                }
            }
            e1 e1Var2 = new e1(context);
            f1260d.add(new WeakReference(e1Var2));
            return e1Var2;
        }
    }

    public AssetManager getAssets() {
        return this.f1261a.getAssets();
    }

    public Resources getResources() {
        return this.f1261a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1262b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i10) {
        Resources.Theme theme = this.f1262b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
