package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import d.i;

public class d extends ContextWrapper {

    /* renamed from: f  reason: collision with root package name */
    private static Configuration f649f;

    /* renamed from: a  reason: collision with root package name */
    private int f650a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f651b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f652c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f653d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f654e;

    static class a {
        static Context a(d dVar, Configuration configuration) {
            return dVar.createConfigurationContext(configuration);
        }
    }

    public d() {
        super((Context) null);
    }

    private Resources b() {
        if (this.f654e == null) {
            Configuration configuration = this.f653d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.f654e = super.getResources();
            } else {
                this.f654e = a.a(this, this.f653d).getResources();
            }
        }
        return this.f654e;
    }

    private void d() {
        boolean z10;
        if (this.f651b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f651b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f651b.setTo(theme);
            }
        }
        f(this.f651b, this.f650a, z10);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f649f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f649f = configuration2;
        }
        return configuration.equals(f649f);
    }

    public void a(Configuration configuration) {
        if (this.f654e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f653d == null) {
            this.f653d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f650a;
    }

    /* access modifiers changed from: protected */
    public void f(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f652c == null) {
            this.f652c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f652c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f651b;
        if (theme != null) {
            return theme;
        }
        if (this.f650a == 0) {
            this.f650a = i.Theme_AppCompat_Light;
        }
        d();
        return this.f651b;
    }

    public void setTheme(int i10) {
        if (this.f650a != i10) {
            this.f650a = i10;
            d();
        }
    }

    public d(Context context, int i10) {
        super(context);
        this.f650a = i10;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f651b = theme;
    }
}
