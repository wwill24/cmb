package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.t1;
import androidx.core.content.res.h;
import androidx.core.view.e2;
import androidx.core.view.f;
import androidx.core.view.f2;
import androidx.core.view.g2;
import androidx.core.view.h0;
import androidx.core.view.k2;
import androidx.core.view.n0;
import androidx.lifecycle.Lifecycle;
import com.google.firebase.database.core.ValidationPath;
import com.mparticle.kits.MPSideloadedKit;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import net.bytebuddy.jar.asm.Opcodes;

class AppCompatDelegateImpl extends f implements g.a, LayoutInflater.Factory2 {

    /* renamed from: q0  reason: collision with root package name */
    private static final androidx.collection.g<String, Integer> f460q0 = new androidx.collection.g<>();

    /* renamed from: r0  reason: collision with root package name */
    private static final boolean f461r0 = false;

    /* renamed from: s0  reason: collision with root package name */
    private static final int[] f462s0 = {16842836};

    /* renamed from: t0  reason: collision with root package name */
    private static final boolean f463t0 = (!"robolectric".equals(Build.FINGERPRINT));

    /* renamed from: u0  reason: collision with root package name */
    private static final boolean f464u0 = true;
    androidx.appcompat.view.b B;
    ActionBarContextView C;
    PopupWindow D;
    Runnable E;
    e2 F;
    private boolean G;
    private boolean H;
    ViewGroup I;
    private TextView J;
    private View K;
    private boolean L;
    private boolean M;
    boolean N;
    boolean O;
    boolean P;
    boolean Q;
    boolean R;
    private boolean S;
    private PanelFeatureState[] T;
    private PanelFeatureState U;
    private boolean V;
    private boolean W;
    private boolean X;
    boolean Y;
    private Configuration Z;

    /* renamed from: a0  reason: collision with root package name */
    private int f465a0;

    /* renamed from: b0  reason: collision with root package name */
    private int f466b0;

    /* renamed from: c0  reason: collision with root package name */
    private int f467c0;

    /* renamed from: d0  reason: collision with root package name */
    private boolean f468d0;

    /* renamed from: e0  reason: collision with root package name */
    private p f469e0;

    /* renamed from: f0  reason: collision with root package name */
    private p f470f0;

    /* renamed from: g0  reason: collision with root package name */
    boolean f471g0;

    /* renamed from: h0  reason: collision with root package name */
    int f472h0;

    /* renamed from: i0  reason: collision with root package name */
    private final Runnable f473i0;

    /* renamed from: j0  reason: collision with root package name */
    private boolean f474j0;

    /* renamed from: k  reason: collision with root package name */
    final Object f475k;

    /* renamed from: k0  reason: collision with root package name */
    private Rect f476k0;

    /* renamed from: l  reason: collision with root package name */
    final Context f477l;

    /* renamed from: l0  reason: collision with root package name */
    private Rect f478l0;

    /* renamed from: m  reason: collision with root package name */
    Window f479m;

    /* renamed from: m0  reason: collision with root package name */
    private k f480m0;

    /* renamed from: n  reason: collision with root package name */
    private n f481n;

    /* renamed from: n0  reason: collision with root package name */
    private o f482n0;

    /* renamed from: o0  reason: collision with root package name */
    private OnBackInvokedDispatcher f483o0;

    /* renamed from: p  reason: collision with root package name */
    final d f484p;

    /* renamed from: p0  reason: collision with root package name */
    private OnBackInvokedCallback f485p0;

    /* renamed from: q  reason: collision with root package name */
    a f486q;

    /* renamed from: t  reason: collision with root package name */
    MenuInflater f487t;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f488w;

    /* renamed from: x  reason: collision with root package name */
    private i0 f489x;

    /* renamed from: y  reason: collision with root package name */
    private g f490y;

    /* renamed from: z  reason: collision with root package name */
    private t f491z;

    protected static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f492a;

        /* renamed from: b  reason: collision with root package name */
        int f493b;

        /* renamed from: c  reason: collision with root package name */
        int f494c;

        /* renamed from: d  reason: collision with root package name */
        int f495d;

        /* renamed from: e  reason: collision with root package name */
        int f496e;

        /* renamed from: f  reason: collision with root package name */
        int f497f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f498g;

        /* renamed from: h  reason: collision with root package name */
        View f499h;

        /* renamed from: i  reason: collision with root package name */
        View f500i;

        /* renamed from: j  reason: collision with root package name */
        androidx.appcompat.view.menu.g f501j;

        /* renamed from: k  reason: collision with root package name */
        androidx.appcompat.view.menu.e f502k;

        /* renamed from: l  reason: collision with root package name */
        Context f503l;

        /* renamed from: m  reason: collision with root package name */
        boolean f504m;

        /* renamed from: n  reason: collision with root package name */
        boolean f505n;

        /* renamed from: o  reason: collision with root package name */
        boolean f506o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f507p;

        /* renamed from: q  reason: collision with root package name */
        boolean f508q = false;

        /* renamed from: r  reason: collision with root package name */
        boolean f509r;

        /* renamed from: s  reason: collision with root package name */
        Bundle f510s;

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            int f511a;

            /* renamed from: b  reason: collision with root package name */
            boolean f512b;

            /* renamed from: c  reason: collision with root package name */
            Bundle f513c;

            class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, (ClassLoader) null);
                }

                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                /* renamed from: c */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f511a = parcel.readInt();
                boolean z10 = true;
                if (parcel.readInt() != 1) {
                    z10 = false;
                }
                savedState.f512b = z10;
                if (z10) {
                    savedState.f513c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f511a);
                parcel.writeInt(this.f512b ? 1 : 0);
                if (this.f512b) {
                    parcel.writeBundle(this.f513c);
                }
            }
        }

        PanelFeatureState(int i10) {
            this.f492a = i10;
        }

        /* access modifiers changed from: package-private */
        public androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.f501j == null) {
                return null;
            }
            if (this.f502k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.f503l, d.g.abc_list_menu_item_layout);
                this.f502k = eVar;
                eVar.e(aVar);
                this.f501j.b(this.f502k);
            }
            return this.f502k.b(this.f498g);
        }

        public boolean b() {
            if (this.f499h == null) {
                return false;
            }
            if (this.f500i != null) {
                return true;
            }
            if (this.f502k.a().getCount() > 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f501j;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.O(this.f502k);
                }
                this.f501j = gVar;
                if (gVar != null && (eVar = this.f502k) != null) {
                    gVar.b(eVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(d.a.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                newTheme.applyStyle(i10, true);
            }
            newTheme.resolveAttribute(d.a.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            } else {
                newTheme.applyStyle(d.i.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f503l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(d.j.AppCompatTheme);
            this.f493b = obtainStyledAttributes.getResourceId(d.j.AppCompatTheme_panelBackground, 0);
            this.f497f = obtainStyledAttributes.getResourceId(d.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f472h0 & 1) != 0) {
                appCompatDelegateImpl.h0(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f472h0 & Opcodes.ACC_SYNTHETIC) != 0) {
                appCompatDelegateImpl2.h0(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.f471g0 = false;
            appCompatDelegateImpl3.f472h0 = 0;
        }
    }

    class b implements h0 {
        b() {
        }

        public k2 a(View view, k2 k2Var) {
            int k10 = k2Var.k();
            int e12 = AppCompatDelegateImpl.this.e1(k2Var, (Rect) null);
            if (k10 != e12) {
                k2Var = k2Var.o(k2Var.i(), e12, k2Var.j(), k2Var.h());
            }
            return n0.e0(view, k2Var);
        }
    }

    class c implements ContentFrameLayout.a {
        c() {
        }

        public void a() {
        }

        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.f0();
        }
    }

    class d implements Runnable {

        class a extends g2 {
            a() {
            }

            public void b(View view) {
                AppCompatDelegateImpl.this.C.setAlpha(1.0f);
                AppCompatDelegateImpl.this.F.h((f2) null);
                AppCompatDelegateImpl.this.F = null;
            }

            public void c(View view) {
                AppCompatDelegateImpl.this.C.setVisibility(0);
            }
        }

        d() {
        }

        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.D.showAtLocation(appCompatDelegateImpl.C, 55, 0, 0);
            AppCompatDelegateImpl.this.i0();
            if (AppCompatDelegateImpl.this.T0()) {
                AppCompatDelegateImpl.this.C.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.F = n0.e(appCompatDelegateImpl2.C).b(1.0f);
                AppCompatDelegateImpl.this.F.h(new a());
                return;
            }
            AppCompatDelegateImpl.this.C.setAlpha(1.0f);
            AppCompatDelegateImpl.this.C.setVisibility(0);
        }
    }

    class e extends g2 {
        e() {
        }

        public void b(View view) {
            AppCompatDelegateImpl.this.C.setAlpha(1.0f);
            AppCompatDelegateImpl.this.F.h((f2) null);
            AppCompatDelegateImpl.this.F = null;
        }

        public void c(View view) {
            AppCompatDelegateImpl.this.C.setVisibility(0);
            if (AppCompatDelegateImpl.this.C.getParent() instanceof View) {
                n0.p0((View) AppCompatDelegateImpl.this.C.getParent());
            }
        }
    }

    interface f {
        boolean a(int i10);

        View onCreatePanelView(int i10);
    }

    private final class g implements m.a {
        g() {
        }

        public void c(@NonNull androidx.appcompat.view.menu.g gVar, boolean z10) {
            AppCompatDelegateImpl.this.Y(gVar);
        }

        public boolean d(@NonNull androidx.appcompat.view.menu.g gVar) {
            Window.Callback u02 = AppCompatDelegateImpl.this.u0();
            if (u02 == null) {
                return true;
            }
            u02.onMenuOpened(108, gVar);
            return true;
        }
    }

    class h implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f521a;

        class a extends g2 {
            a() {
            }

            public void b(View view) {
                AppCompatDelegateImpl.this.C.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.D;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.C.getParent() instanceof View) {
                    n0.p0((View) AppCompatDelegateImpl.this.C.getParent());
                }
                AppCompatDelegateImpl.this.C.k();
                AppCompatDelegateImpl.this.F.h((f2) null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.F = null;
                n0.p0(appCompatDelegateImpl2.I);
            }
        }

        public h(b.a aVar) {
            this.f521a = aVar;
        }

        public void a(androidx.appcompat.view.b bVar) {
            this.f521a.a(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.D != null) {
                appCompatDelegateImpl.f479m.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.E);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.C != null) {
                appCompatDelegateImpl2.i0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.F = n0.e(appCompatDelegateImpl3.C).b(0.0f);
                AppCompatDelegateImpl.this.F.h(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            d dVar = appCompatDelegateImpl4.f484p;
            if (dVar != null) {
                dVar.H(appCompatDelegateImpl4.B);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.B = null;
            n0.p0(appCompatDelegateImpl5.I);
            AppCompatDelegateImpl.this.c1();
        }

        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f521a.b(bVar, menu);
        }

        public boolean c(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f521a.c(bVar, menuItem);
        }

        public boolean d(androidx.appcompat.view.b bVar, Menu menu) {
            n0.p0(AppCompatDelegateImpl.this.I);
            return this.f521a.d(bVar, menu);
        }
    }

    static class i {
        static Context a(@NonNull Context context, @NonNull Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i10 = configuration.densityDpi;
            int i11 = configuration2.densityDpi;
            if (i10 != i11) {
                configuration3.densityDpi = i11;
            }
        }

        static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    static class j {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class k {
        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }

        static androidx.core.os.j b(Configuration configuration) {
            return androidx.core.os.j.b(configuration.getLocales().toLanguageTags());
        }

        public static void c(androidx.core.os.j jVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(jVar.g()));
        }

        static void d(Configuration configuration, androidx.core.os.j jVar) {
            configuration.setLocales(LocaleList.forLanguageTags(jVar.g()));
        }
    }

    static class l {
        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            int i10 = configuration.colorMode & 3;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 3)) {
                configuration3.colorMode |= i11 & 3;
            }
            int i12 = configuration.colorMode & 12;
            int i13 = configuration2.colorMode;
            if (i12 != (i13 & 12)) {
                configuration3.colorMode |= i13 & 12;
            }
        }
    }

    static class m {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            g gVar = new g(appCompatDelegateImpl);
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(MPSideloadedKit.MIN_SIDELOADED_KIT, gVar);
            return gVar;
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    class n extends androidx.appcompat.view.i {

        /* renamed from: b  reason: collision with root package name */
        private f f524b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f525c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f526d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f527e;

        n(Window.Callback callback) {
            super(callback);
        }

        /* JADX INFO: finally extract failed */
        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f526d = true;
                boolean dispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                this.f526d = false;
                return dispatchKeyEvent;
            } catch (Throwable th2) {
                this.f526d = false;
                throw th2;
            }
        }

        /* JADX INFO: finally extract failed */
        public void c(Window.Callback callback) {
            try {
                this.f525c = true;
                callback.onContentChanged();
                this.f525c = false;
            } catch (Throwable th2) {
                this.f525c = false;
                throw th2;
            }
        }

        /* JADX INFO: finally extract failed */
        public void d(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f527e = true;
                callback.onPanelClosed(i10, menu);
                this.f527e = false;
            } catch (Throwable th2) {
                this.f527e = false;
                throw th2;
            }
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f526d) {
                return a().dispatchKeyEvent(keyEvent);
            }
            if (AppCompatDelegateImpl.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.F0(keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(f fVar) {
            this.f524b = fVar;
        }

        /* access modifiers changed from: package-private */
        public final ActionMode f(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f477l, callback);
            androidx.appcompat.view.b W0 = AppCompatDelegateImpl.this.W0(aVar);
            if (W0 != null) {
                return aVar.e(W0);
            }
            return null;
        }

        public void onContentChanged() {
            if (this.f525c) {
                a().onContentChanged();
            }
        }

        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        public View onCreatePanelView(int i10) {
            View onCreatePanelView;
            f fVar = this.f524b;
            if (fVar == null || (onCreatePanelView = fVar.onCreatePanelView(i10)) == null) {
                return super.onCreatePanelView(i10);
            }
            return onCreatePanelView;
        }

        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImpl.this.I0(i10);
            return true;
        }

        public void onPanelClosed(int i10, Menu menu) {
            if (this.f527e) {
                a().onPanelClosed(i10, menu);
                return;
            }
            super.onPanelClosed(i10, menu);
            AppCompatDelegateImpl.this.J0(i10);
        }

        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar;
            if (menu instanceof androidx.appcompat.view.menu.g) {
                gVar = (androidx.appcompat.view.menu.g) menu;
            } else {
                gVar = null;
            }
            if (i10 == 0 && gVar == null) {
                return false;
            }
            boolean z10 = true;
            if (gVar != null) {
                gVar.a0(true);
            }
            f fVar = this.f524b;
            if (fVar == null || !fVar.a(i10)) {
                z10 = false;
            }
            if (!z10) {
                z10 = super.onPreparePanel(i10, view, menu);
            }
            if (gVar != null) {
                gVar.a0(false);
            }
            return z10;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            androidx.appcompat.view.menu.g gVar;
            PanelFeatureState s02 = AppCompatDelegateImpl.this.s0(0, true);
            if (s02 == null || (gVar = s02.f501j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i10);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            if (!AppCompatDelegateImpl.this.A0() || i10 != 0) {
                return super.onWindowStartingActionMode(callback, i10);
            }
            return f(callback);
        }
    }

    private class o extends p {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f529c;

        o(@NonNull Context context) {
            super();
            this.f529c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            return j.a(this.f529c) ? 2 : 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.S();
        }
    }

    abstract class p {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f531a;

        class a extends BroadcastReceiver {
            a() {
            }

            public void onReceive(Context context, Intent intent) {
                p.this.d();
            }
        }

        p() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f531a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f477l.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f531a = null;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract IntentFilter b();

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public void e() {
            a();
            IntentFilter b10 = b();
            if (b10 != null && b10.countActions() != 0) {
                if (this.f531a == null) {
                    this.f531a = new a();
                }
                AppCompatDelegateImpl.this.f477l.registerReceiver(this.f531a, b10);
            }
        }
    }

    private class q extends p {

        /* renamed from: c  reason: collision with root package name */
        private final t f534c;

        q(@NonNull t tVar) {
            super();
            this.f534c = tVar;
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            return this.f534c.d() ? 2 : 1;
        }

        public void d() {
            AppCompatDelegateImpl.this.S();
        }
    }

    private static class r {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    private class s extends ContentFrameLayout {
        public s(Context context) {
            super(context);
        }

        private boolean b(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (AppCompatDelegateImpl.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.a0(0);
            return true;
        }

        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(e.a.b(getContext(), i10));
        }
    }

    private final class t implements m.a {
        t() {
        }

        public void c(@NonNull androidx.appcompat.view.menu.g gVar, boolean z10) {
            boolean z11;
            androidx.appcompat.view.menu.g D = gVar.D();
            if (D != gVar) {
                z11 = true;
            } else {
                z11 = false;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                gVar = D;
            }
            PanelFeatureState l02 = appCompatDelegateImpl.l0(gVar);
            if (l02 == null) {
                return;
            }
            if (z11) {
                AppCompatDelegateImpl.this.X(l02.f492a, l02, D);
                AppCompatDelegateImpl.this.b0(l02, true);
                return;
            }
            AppCompatDelegateImpl.this.b0(l02, z10);
        }

        public boolean d(@NonNull androidx.appcompat.view.menu.g gVar) {
            Window.Callback u02;
            if (gVar != gVar.D()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.N || (u02 = appCompatDelegateImpl.u0()) == null || AppCompatDelegateImpl.this.Y) {
                return true;
            }
            u02.onMenuOpened(108, gVar);
            return true;
        }
    }

    AppCompatDelegateImpl(Activity activity, d dVar) {
        this(activity, (Window) null, dVar, activity);
    }

    private boolean E0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState s02 = s0(i10, true);
        if (!s02.f506o) {
            return O0(s02, keyEvent);
        }
        return false;
    }

    private boolean H0(int i10, KeyEvent keyEvent) {
        AudioManager audioManager;
        boolean z10;
        i0 i0Var;
        if (this.B != null) {
            return false;
        }
        boolean z11 = true;
        PanelFeatureState s02 = s0(i10, true);
        if (i10 != 0 || (i0Var = this.f489x) == null || !i0Var.a() || ViewConfiguration.get(this.f477l).hasPermanentMenuKey()) {
            boolean z12 = s02.f506o;
            if (z12 || s02.f505n) {
                b0(s02, true);
                z11 = z12;
                if (z11 && (audioManager = (AudioManager) this.f477l.getApplicationContext().getSystemService("audio")) != null) {
                    audioManager.playSoundEffect(0);
                }
                return z11;
            } else if (s02.f504m) {
                if (s02.f509r) {
                    s02.f504m = false;
                    z10 = O0(s02, keyEvent);
                } else {
                    z10 = true;
                }
                if (z10) {
                    L0(s02, keyEvent);
                    audioManager.playSoundEffect(0);
                    return z11;
                }
            }
        } else {
            if (this.f489x.e()) {
                z11 = this.f489x.b();
            } else if (!this.Y && O0(s02, keyEvent)) {
                z11 = this.f489x.c();
            }
            audioManager.playSoundEffect(0);
            return z11;
        }
        z11 = false;
        audioManager.playSoundEffect(0);
        return z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void L0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r14, android.view.KeyEvent r15) {
        /*
            r13 = this;
            boolean r0 = r14.f506o
            if (r0 != 0) goto L_0x00f8
            boolean r0 = r13.Y
            if (r0 == 0) goto L_0x000a
            goto L_0x00f8
        L_0x000a:
            int r0 = r14.f492a
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0027
            android.content.Context r0 = r13.f477l
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            r3 = 4
            if (r0 != r3) goto L_0x0023
            r0 = r2
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            return
        L_0x0027:
            android.view.Window$Callback r0 = r13.u0()
            if (r0 == 0) goto L_0x003b
            int r3 = r14.f492a
            androidx.appcompat.view.menu.g r4 = r14.f501j
            boolean r0 = r0.onMenuOpened(r3, r4)
            if (r0 != 0) goto L_0x003b
            r13.b0(r14, r2)
            return
        L_0x003b:
            android.content.Context r0 = r13.f477l
            java.lang.String r3 = "window"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            if (r0 != 0) goto L_0x0048
            return
        L_0x0048:
            boolean r15 = r13.O0(r14, r15)
            if (r15 != 0) goto L_0x004f
            return
        L_0x004f:
            android.view.ViewGroup r15 = r14.f498g
            r3 = -1
            r4 = -2
            if (r15 == 0) goto L_0x006a
            boolean r5 = r14.f508q
            if (r5 == 0) goto L_0x005a
            goto L_0x006a
        L_0x005a:
            android.view.View r15 = r14.f500i
            if (r15 == 0) goto L_0x00cc
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            if (r15 == 0) goto L_0x00cc
            int r15 = r15.width
            if (r15 != r3) goto L_0x00cc
            r6 = r3
            goto L_0x00cd
        L_0x006a:
            if (r15 != 0) goto L_0x0077
            boolean r15 = r13.x0(r14)
            if (r15 == 0) goto L_0x0076
            android.view.ViewGroup r15 = r14.f498g
            if (r15 != 0) goto L_0x0086
        L_0x0076:
            return
        L_0x0077:
            boolean r3 = r14.f508q
            if (r3 == 0) goto L_0x0086
            int r15 = r15.getChildCount()
            if (r15 <= 0) goto L_0x0086
            android.view.ViewGroup r15 = r14.f498g
            r15.removeAllViews()
        L_0x0086:
            boolean r15 = r13.w0(r14)
            if (r15 == 0) goto L_0x00f6
            boolean r15 = r14.b()
            if (r15 != 0) goto L_0x0093
            goto L_0x00f6
        L_0x0093:
            android.view.View r15 = r14.f499h
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            if (r15 != 0) goto L_0x00a0
            android.view.ViewGroup$LayoutParams r15 = new android.view.ViewGroup$LayoutParams
            r15.<init>(r4, r4)
        L_0x00a0:
            int r3 = r14.f493b
            android.view.ViewGroup r5 = r14.f498g
            r5.setBackgroundResource(r3)
            android.view.View r3 = r14.f499h
            android.view.ViewParent r3 = r3.getParent()
            boolean r5 = r3 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x00b8
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            android.view.View r5 = r14.f499h
            r3.removeView(r5)
        L_0x00b8:
            android.view.ViewGroup r3 = r14.f498g
            android.view.View r5 = r14.f499h
            r3.addView(r5, r15)
            android.view.View r15 = r14.f499h
            boolean r15 = r15.hasFocus()
            if (r15 != 0) goto L_0x00cc
            android.view.View r15 = r14.f499h
            r15.requestFocus()
        L_0x00cc:
            r6 = r4
        L_0x00cd:
            r14.f505n = r1
            android.view.WindowManager$LayoutParams r15 = new android.view.WindowManager$LayoutParams
            r7 = -2
            int r8 = r14.f495d
            int r9 = r14.f496e
            r10 = 1002(0x3ea, float:1.404E-42)
            r11 = 8519680(0x820000, float:1.1938615E-38)
            r12 = -3
            r5 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            int r1 = r14.f494c
            r15.gravity = r1
            int r1 = r14.f497f
            r15.windowAnimations = r1
            android.view.ViewGroup r1 = r14.f498g
            r0.addView(r1, r15)
            r14.f506o = r2
            int r14 = r14.f492a
            if (r14 != 0) goto L_0x00f5
            r13.c1()
        L_0x00f5:
            return
        L_0x00f6:
            r14.f508q = r2
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.L0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean N0(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.g gVar;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f504m || O0(panelFeatureState, keyEvent)) && (gVar = panelFeatureState.f501j) != null) {
            z10 = gVar.performShortcut(i10, keyEvent, i11);
        }
        if (z10 && (i11 & 1) == 0 && this.f489x == null) {
            b0(panelFeatureState, true);
        }
        return z10;
    }

    private boolean O0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z10;
        int i10;
        boolean z11;
        i0 i0Var;
        i0 i0Var2;
        i0 i0Var3;
        if (this.Y) {
            return false;
        }
        if (panelFeatureState.f504m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.U;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            b0(panelFeatureState2, false);
        }
        Window.Callback u02 = u0();
        if (u02 != null) {
            panelFeatureState.f500i = u02.onCreatePanelView(panelFeatureState.f492a);
        }
        int i11 = panelFeatureState.f492a;
        if (i11 == 0 || i11 == 108) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && (i0Var3 = this.f489x) != null) {
            i0Var3.f();
        }
        if (panelFeatureState.f500i == null && (!z10 || !(M0() instanceof r))) {
            androidx.appcompat.view.menu.g gVar = panelFeatureState.f501j;
            if (gVar == null || panelFeatureState.f509r) {
                if (gVar == null && (!y0(panelFeatureState) || panelFeatureState.f501j == null)) {
                    return false;
                }
                if (z10 && this.f489x != null) {
                    if (this.f490y == null) {
                        this.f490y = new g();
                    }
                    this.f489x.d(panelFeatureState.f501j, this.f490y);
                }
                panelFeatureState.f501j.d0();
                if (!u02.onCreatePanelMenu(panelFeatureState.f492a, panelFeatureState.f501j)) {
                    panelFeatureState.c((androidx.appcompat.view.menu.g) null);
                    if (z10 && (i0Var2 = this.f489x) != null) {
                        i0Var2.d((Menu) null, this.f490y);
                    }
                    return false;
                }
                panelFeatureState.f509r = false;
            }
            panelFeatureState.f501j.d0();
            Bundle bundle = panelFeatureState.f510s;
            if (bundle != null) {
                panelFeatureState.f501j.P(bundle);
                panelFeatureState.f510s = null;
            }
            if (!u02.onPreparePanel(0, panelFeatureState.f500i, panelFeatureState.f501j)) {
                if (z10 && (i0Var = this.f489x) != null) {
                    i0Var.d((Menu) null, this.f490y);
                }
                panelFeatureState.f501j.c0();
                return false;
            }
            if (keyEvent != null) {
                i10 = keyEvent.getDeviceId();
            } else {
                i10 = -1;
            }
            if (KeyCharacterMap.load(i10).getKeyboardType() != 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            panelFeatureState.f507p = z11;
            panelFeatureState.f501j.setQwertyMode(z11);
            panelFeatureState.f501j.c0();
        }
        panelFeatureState.f504m = true;
        panelFeatureState.f505n = false;
        this.U = panelFeatureState;
        return true;
    }

    private void P0(boolean z10) {
        i0 i0Var = this.f489x;
        if (i0Var == null || !i0Var.a() || (ViewConfiguration.get(this.f477l).hasPermanentMenuKey() && !this.f489x.g())) {
            PanelFeatureState s02 = s0(0, true);
            s02.f508q = true;
            b0(s02, false);
            L0(s02, (KeyEvent) null);
            return;
        }
        Window.Callback u02 = u0();
        if (this.f489x.e() && z10) {
            this.f489x.b();
            if (!this.Y) {
                u02.onPanelClosed(108, s0(0, true).f501j);
            }
        } else if (u02 != null && !this.Y) {
            if (this.f471g0 && (this.f472h0 & 1) != 0) {
                this.f479m.getDecorView().removeCallbacks(this.f473i0);
                this.f473i0.run();
            }
            PanelFeatureState s03 = s0(0, true);
            androidx.appcompat.view.menu.g gVar = s03.f501j;
            if (gVar != null && !s03.f509r && u02.onPreparePanel(0, s03.f500i, gVar)) {
                u02.onMenuOpened(108, s03.f501j);
                this.f489x.c();
            }
        }
    }

    private boolean Q(boolean z10) {
        return R(z10, true);
    }

    private int Q0(int i10) {
        if (i10 == 8) {
            return 108;
        }
        if (i10 == 9) {
            return 109;
        }
        return i10;
    }

    private boolean R(boolean z10, boolean z11) {
        if (this.Y) {
            return false;
        }
        int W2 = W();
        int B0 = B0(this.f477l, W2);
        androidx.core.os.j jVar = null;
        if (Build.VERSION.SDK_INT < 33) {
            jVar = V(this.f477l);
        }
        if (!z11 && jVar != null) {
            jVar = r0(this.f477l.getResources().getConfiguration());
        }
        boolean b12 = b1(B0, jVar, z10);
        if (W2 == 0) {
            q0(this.f477l).e();
        } else {
            p pVar = this.f469e0;
            if (pVar != null) {
                pVar.a();
            }
        }
        if (W2 == 3) {
            p0(this.f477l).e();
        } else {
            p pVar2 = this.f470f0;
            if (pVar2 != null) {
                pVar2.a();
            }
        }
        return b12;
    }

    private void T() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.I.findViewById(16908290);
        View decorView = this.f479m.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f477l.obtainStyledAttributes(d.j.AppCompatTheme);
        obtainStyledAttributes.getValue(d.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(d.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i10 = d.j.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = d.j.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = d.j.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = d.j.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void U(@NonNull Window window) {
        if (this.f479m == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof n)) {
                n nVar = new n(callback);
                this.f481n = nVar;
                window.setCallback(nVar);
                h1 u10 = h1.u(this.f477l, (AttributeSet) null, f462s0);
                Drawable h10 = u10.h(0);
                if (h10 != null) {
                    window.setBackgroundDrawable(h10);
                }
                u10.w();
                this.f479m = window;
                if (Build.VERSION.SDK_INT >= 33 && this.f483o0 == null) {
                    L((OnBackInvokedDispatcher) null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private boolean U0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f479m.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || n0.V((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int W() {
        int i10 = this.f465a0;
        return i10 != -100 ? i10 : f.m();
    }

    private void Y0() {
        if (this.H) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void Z() {
        p pVar = this.f469e0;
        if (pVar != null) {
            pVar.a();
        }
        p pVar2 = this.f470f0;
        if (pVar2 != null) {
            pVar2.a();
        }
    }

    private c Z0() {
        Context context = this.f477l;
        while (context != null) {
            if (!(context instanceof c)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (c) context;
            }
        }
        return null;
    }

    private void a1(Configuration configuration) {
        Activity activity = (Activity) this.f475k;
        if (activity instanceof androidx.lifecycle.l) {
            if (((androidx.lifecycle.l) activity).getLifecycle().b().b(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else if (this.X && !this.Y) {
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b1(int r9, androidx.core.os.j r10, boolean r11) {
        /*
            r8 = this;
            android.content.Context r1 = r8.f477l
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.c0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.f477l
            int r1 = r8.o0(r1)
            android.content.res.Configuration r2 = r8.Z
            if (r2 != 0) goto L_0x001f
            android.content.Context r2 = r8.f477l
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L_0x001f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.j r2 = r8.r0(r2)
            r5 = 0
            if (r10 != 0) goto L_0x0030
            r0 = r5
            goto L_0x0034
        L_0x0030:
            androidx.core.os.j r0 = r8.r0(r0)
        L_0x0034:
            r6 = 0
            if (r3 == r4) goto L_0x003a
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x003b
        L_0x003a:
            r3 = r6
        L_0x003b:
            if (r0 == 0) goto L_0x0047
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0047
            r2 = r3 | 4
            r3 = r2 | 8192(0x2000, float:1.14794E-41)
        L_0x0047:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L_0x0071
            if (r11 == 0) goto L_0x0071
            boolean r11 = r8.W
            if (r11 == 0) goto L_0x0071
            boolean r11 = f463t0
            if (r11 != 0) goto L_0x005a
            boolean r11 = r8.X
            if (r11 == 0) goto L_0x0071
        L_0x005a:
            java.lang.Object r11 = r8.f475k
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0071
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L_0x0071
            java.lang.Object r11 = r8.f475k
            android.app.Activity r11 = (android.app.Activity) r11
            androidx.core.app.b.f(r11)
            r11 = r7
            goto L_0x0072
        L_0x0071:
            r11 = r6
        L_0x0072:
            if (r11 != 0) goto L_0x007f
            if (r3 == 0) goto L_0x007f
            r11 = r3 & r1
            if (r11 != r3) goto L_0x007b
            r6 = r7
        L_0x007b:
            r8.d1(r4, r0, r6, r5)
            goto L_0x0080
        L_0x007f:
            r7 = r11
        L_0x0080:
            if (r7 == 0) goto L_0x009c
            java.lang.Object r11 = r8.f475k
            boolean r1 = r11 instanceof androidx.appcompat.app.c
            if (r1 == 0) goto L_0x009c
            r1 = r3 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0091
            androidx.appcompat.app.c r11 = (androidx.appcompat.app.c) r11
            r11.t0(r9)
        L_0x0091:
            r9 = r3 & 4
            if (r9 == 0) goto L_0x009c
            java.lang.Object r9 = r8.f475k
            androidx.appcompat.app.c r9 = (androidx.appcompat.app.c) r9
            r9.s0(r10)
        L_0x009c:
            if (r7 == 0) goto L_0x00b1
            if (r0 == 0) goto L_0x00b1
            android.content.Context r9 = r8.f477l
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            androidx.core.os.j r9 = r8.r0(r9)
            r8.S0(r9)
        L_0x00b1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b1(int, androidx.core.os.j, boolean):boolean");
    }

    @NonNull
    private Configuration c0(@NonNull Context context, int i10, androidx.core.os.j jVar, Configuration configuration, boolean z10) {
        int i11;
        if (i10 == 1) {
            i11 = 16;
        } else if (i10 == 2) {
            i11 = 32;
        } else if (z10) {
            i11 = 0;
        } else {
            i11 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & -49);
        if (jVar != null) {
            R0(configuration2, jVar);
        }
        return configuration2;
    }

    private ViewGroup d0() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f477l.obtainStyledAttributes(d.j.AppCompatTheme);
        int i10 = d.j.AppCompatTheme_windowActionBar;
        if (obtainStyledAttributes.hasValue(i10)) {
            if (obtainStyledAttributes.getBoolean(d.j.AppCompatTheme_windowNoTitle, false)) {
                G(1);
            } else if (obtainStyledAttributes.getBoolean(i10, false)) {
                G(108);
            }
            if (obtainStyledAttributes.getBoolean(d.j.AppCompatTheme_windowActionBarOverlay, false)) {
                G(109);
            }
            if (obtainStyledAttributes.getBoolean(d.j.AppCompatTheme_windowActionModeOverlay, false)) {
                G(10);
            }
            this.Q = obtainStyledAttributes.getBoolean(d.j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            k0();
            this.f479m.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f477l);
            if (this.R) {
                viewGroup = this.P ? (ViewGroup) from.inflate(d.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(d.g.abc_screen_simple, (ViewGroup) null);
            } else if (this.Q) {
                viewGroup = (ViewGroup) from.inflate(d.g.abc_dialog_title_material, (ViewGroup) null);
                this.O = false;
                this.N = false;
            } else if (this.N) {
                TypedValue typedValue = new TypedValue();
                this.f477l.getTheme().resolveAttribute(d.a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.d(this.f477l, typedValue.resourceId);
                } else {
                    context = this.f477l;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.g.abc_screen_toolbar, (ViewGroup) null);
                i0 i0Var = (i0) viewGroup.findViewById(d.f.decor_content_parent);
                this.f489x = i0Var;
                i0Var.setWindowCallback(u0());
                if (this.O) {
                    this.f489x.h(109);
                }
                if (this.L) {
                    this.f489x.h(2);
                }
                if (this.M) {
                    this.f489x.h(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                n0.H0(viewGroup, new b());
                if (this.f489x == null) {
                    this.J = (TextView) viewGroup.findViewById(d.f.title);
                }
                t1.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(d.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f479m.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f479m.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new c());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.N + ", windowActionBarOverlay: " + this.O + ", android:windowIsFloating: " + this.Q + ", windowActionModeOverlay: " + this.P + ", windowNoTitle: " + this.R + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void d1(int i10, androidx.core.os.j jVar, boolean z10, Configuration configuration) {
        Resources resources = this.f477l.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & -49);
        if (jVar != null) {
            R0(configuration2, jVar);
        }
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            q.a(resources);
        }
        int i11 = this.f466b0;
        if (i11 != 0) {
            this.f477l.setTheme(i11);
            this.f477l.getTheme().applyStyle(this.f466b0, true);
        }
        if (z10 && (this.f475k instanceof Activity)) {
            a1(configuration2);
        }
    }

    private void f1(View view) {
        boolean z10;
        int i10;
        if ((n0.O(view) & 8192) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = androidx.core.content.a.getColor(this.f477l, d.c.abc_decor_view_status_guard_light);
        } else {
            i10 = androidx.core.content.a.getColor(this.f477l, d.c.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(i10);
    }

    private void j0() {
        if (!this.H) {
            this.I = d0();
            CharSequence t02 = t0();
            if (!TextUtils.isEmpty(t02)) {
                i0 i0Var = this.f489x;
                if (i0Var != null) {
                    i0Var.setWindowTitle(t02);
                } else if (M0() != null) {
                    M0().B(t02);
                } else {
                    TextView textView = this.J;
                    if (textView != null) {
                        textView.setText(t02);
                    }
                }
            }
            T();
            K0(this.I);
            this.H = true;
            PanelFeatureState s02 = s0(0, false);
            if (this.Y) {
                return;
            }
            if (s02 == null || s02.f501j == null) {
                z0(108);
            }
        }
    }

    private void k0() {
        if (this.f479m == null) {
            Object obj = this.f475k;
            if (obj instanceof Activity) {
                U(((Activity) obj).getWindow());
            }
        }
        if (this.f479m == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @NonNull
    private static Configuration m0(@NonNull Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            int i14 = Build.VERSION.SDK_INT;
            k.a(configuration, configuration2, configuration3);
            int i15 = configuration.touchscreen;
            int i16 = configuration2.touchscreen;
            if (i15 != i16) {
                configuration3.touchscreen = i16;
            }
            int i17 = configuration.keyboard;
            int i18 = configuration2.keyboard;
            if (i17 != i18) {
                configuration3.keyboard = i18;
            }
            int i19 = configuration.keyboardHidden;
            int i20 = configuration2.keyboardHidden;
            if (i19 != i20) {
                configuration3.keyboardHidden = i20;
            }
            int i21 = configuration.navigation;
            int i22 = configuration2.navigation;
            if (i21 != i22) {
                configuration3.navigation = i22;
            }
            int i23 = configuration.navigationHidden;
            int i24 = configuration2.navigationHidden;
            if (i23 != i24) {
                configuration3.navigationHidden = i24;
            }
            int i25 = configuration.orientation;
            int i26 = configuration2.orientation;
            if (i25 != i26) {
                configuration3.orientation = i26;
            }
            int i27 = configuration.screenLayout & 15;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 15)) {
                configuration3.screenLayout |= i28 & 15;
            }
            int i29 = configuration.screenLayout & 192;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 192)) {
                configuration3.screenLayout |= i30 & 192;
            }
            int i31 = configuration.screenLayout & 48;
            int i32 = configuration2.screenLayout;
            if (i31 != (i32 & 48)) {
                configuration3.screenLayout |= i32 & 48;
            }
            int i33 = configuration.screenLayout & ValidationPath.MAX_PATH_LENGTH_BYTES;
            int i34 = configuration2.screenLayout;
            if (i33 != (i34 & ValidationPath.MAX_PATH_LENGTH_BYTES)) {
                configuration3.screenLayout |= i34 & ValidationPath.MAX_PATH_LENGTH_BYTES;
            }
            if (i14 >= 26) {
                l.a(configuration, configuration2, configuration3);
            }
            int i35 = configuration.uiMode & 15;
            int i36 = configuration2.uiMode;
            if (i35 != (i36 & 15)) {
                configuration3.uiMode |= i36 & 15;
            }
            int i37 = configuration.uiMode & 48;
            int i38 = configuration2.uiMode;
            if (i37 != (i38 & 48)) {
                configuration3.uiMode |= i38 & 48;
            }
            int i39 = configuration.screenWidthDp;
            int i40 = configuration2.screenWidthDp;
            if (i39 != i40) {
                configuration3.screenWidthDp = i40;
            }
            int i41 = configuration.screenHeightDp;
            int i42 = configuration2.screenHeightDp;
            if (i41 != i42) {
                configuration3.screenHeightDp = i42;
            }
            int i43 = configuration.smallestScreenWidthDp;
            int i44 = configuration2.smallestScreenWidthDp;
            if (i43 != i44) {
                configuration3.smallestScreenWidthDp = i44;
            }
            i.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private int o0(Context context) {
        int i10;
        if (!this.f468d0 && (this.f475k instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i10 = 269221888;
                } else {
                    i10 = 786432;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f475k.getClass()), i10);
                if (activityInfo != null) {
                    this.f467c0 = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.f467c0 = 0;
            }
        }
        this.f468d0 = true;
        return this.f467c0;
    }

    private p p0(@NonNull Context context) {
        if (this.f470f0 == null) {
            this.f470f0 = new o(context);
        }
        return this.f470f0;
    }

    private p q0(@NonNull Context context) {
        if (this.f469e0 == null) {
            this.f469e0 = new q(t.a(context));
        }
        return this.f469e0;
    }

    private void v0() {
        j0();
        if (this.N && this.f486q == null) {
            Object obj = this.f475k;
            if (obj instanceof Activity) {
                this.f486q = new u((Activity) this.f475k, this.O);
            } else if (obj instanceof Dialog) {
                this.f486q = new u((Dialog) this.f475k);
            }
            a aVar = this.f486q;
            if (aVar != null) {
                aVar.t(this.f474j0);
            }
        }
    }

    private boolean w0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f500i;
        if (view != null) {
            panelFeatureState.f499h = view;
            return true;
        } else if (panelFeatureState.f501j == null) {
            return false;
        } else {
            if (this.f491z == null) {
                this.f491z = new t();
            }
            View view2 = (View) panelFeatureState.a(this.f491z);
            panelFeatureState.f499h = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    private boolean x0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(n0());
        panelFeatureState.f498g = new s(panelFeatureState.f503l);
        panelFeatureState.f494c = 81;
        return true;
    }

    private boolean y0(PanelFeatureState panelFeatureState) {
        Context context = this.f477l;
        int i10 = panelFeatureState.f492a;
        if ((i10 == 0 || i10 == 108) && this.f489x != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(d.a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(d.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(d.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.R(this);
        panelFeatureState.c(gVar);
        return true;
    }

    private void z0(int i10) {
        this.f472h0 = (1 << i10) | this.f472h0;
        if (!this.f471g0) {
            n0.k0(this.f479m.getDecorView(), this.f473i0);
            this.f471g0 = true;
        }
    }

    public void A() {
        a r10 = r();
        if (r10 != null) {
            r10.z(true);
        }
    }

    public boolean A0() {
        return this.G;
    }

    public void B(Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public int B0(@NonNull Context context, int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                if (!(i10 == 1 || i10 == 2)) {
                    if (i10 == 3) {
                        return p0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                return q0(context).c();
            }
        }
        return i10;
    }

    public void C() {
        R(true, false);
    }

    /* access modifiers changed from: package-private */
    public boolean C0() {
        boolean z10 = this.V;
        this.V = false;
        PanelFeatureState s02 = s0(0, false);
        if (s02 == null || !s02.f506o) {
            androidx.appcompat.view.b bVar = this.B;
            if (bVar != null) {
                bVar.c();
                return true;
            }
            a r10 = r();
            if (r10 == null || !r10.h()) {
                return false;
            }
            return true;
        }
        if (!z10) {
            b0(s02, true);
        }
        return true;
    }

    public void D() {
        a r10 = r();
        if (r10 != null) {
            r10.z(false);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean D0(int i10, KeyEvent keyEvent) {
        boolean z10 = true;
        if (i10 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z10 = false;
            }
            this.V = z10;
        } else if (i10 == 82) {
            E0(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean F0(int i10, KeyEvent keyEvent) {
        a r10 = r();
        if (r10 != null && r10.p(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.U;
        if (panelFeatureState == null || !N0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.U == null) {
                PanelFeatureState s02 = s0(0, true);
                O0(s02, keyEvent);
                boolean N0 = N0(s02, keyEvent.getKeyCode(), keyEvent, 1);
                s02.f504m = false;
                if (N0) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.U;
        if (panelFeatureState2 != null) {
            panelFeatureState2.f505n = true;
        }
        return true;
    }

    public boolean G(int i10) {
        int Q0 = Q0(i10);
        if (this.R && Q0 == 108) {
            return false;
        }
        if (this.N && Q0 == 1) {
            this.N = false;
        }
        if (Q0 == 1) {
            Y0();
            this.R = true;
            return true;
        } else if (Q0 == 2) {
            Y0();
            this.L = true;
            return true;
        } else if (Q0 == 5) {
            Y0();
            this.M = true;
            return true;
        } else if (Q0 == 10) {
            Y0();
            this.P = true;
            return true;
        } else if (Q0 == 108) {
            Y0();
            this.N = true;
            return true;
        } else if (Q0 != 109) {
            return this.f479m.requestFeature(Q0);
        } else {
            Y0();
            this.O = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean G0(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            if (i10 == 82) {
                H0(0, keyEvent);
                return true;
            }
        } else if (C0()) {
            return true;
        }
        return false;
    }

    public void I(int i10) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f477l).inflate(i10, viewGroup);
        this.f481n.c(this.f479m.getCallback());
    }

    /* access modifiers changed from: package-private */
    public void I0(int i10) {
        a r10;
        if (i10 == 108 && (r10 = r()) != null) {
            r10.i(true);
        }
    }

    public void J(View view) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f481n.c(this.f479m.getCallback());
    }

    /* access modifiers changed from: package-private */
    public void J0(int i10) {
        if (i10 == 108) {
            a r10 = r();
            if (r10 != null) {
                r10.i(false);
            }
        } else if (i10 == 0) {
            PanelFeatureState s02 = s0(i10, true);
            if (s02.f506o) {
                b0(s02, false);
            }
        }
    }

    public void K(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f481n.c(this.f479m.getCallback());
    }

    /* access modifiers changed from: package-private */
    public void K0(ViewGroup viewGroup) {
    }

    public void L(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.L(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f483o0;
        if (!(onBackInvokedDispatcher2 == null || (onBackInvokedCallback = this.f485p0) == null)) {
            m.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f485p0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f475k;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f483o0 = m.a((Activity) this.f475k);
                c1();
            }
        }
        this.f483o0 = onBackInvokedDispatcher;
        c1();
    }

    public void M(Toolbar toolbar) {
        if (this.f475k instanceof Activity) {
            a r10 = r();
            if (!(r10 instanceof u)) {
                this.f487t = null;
                if (r10 != null) {
                    r10.o();
                }
                this.f486q = null;
                if (toolbar != null) {
                    r rVar = new r(toolbar, t0(), this.f481n);
                    this.f486q = rVar;
                    this.f481n.e(rVar.f589c);
                    toolbar.setBackInvokedCallbackEnabled(true);
                } else {
                    this.f481n.e((f) null);
                }
                t();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final a M0() {
        return this.f486q;
    }

    public void N(int i10) {
        this.f466b0 = i10;
    }

    public final void O(CharSequence charSequence) {
        this.f488w = charSequence;
        i0 i0Var = this.f489x;
        if (i0Var != null) {
            i0Var.setWindowTitle(charSequence);
        } else if (M0() != null) {
            M0().B(charSequence);
        } else {
            TextView textView = this.J;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void R0(Configuration configuration, @NonNull androidx.core.os.j jVar) {
        k.d(configuration, jVar);
    }

    public boolean S() {
        return Q(true);
    }

    /* access modifiers changed from: package-private */
    public void S0(androidx.core.os.j jVar) {
        k.c(jVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.I;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean T0() {
        /*
            r1 = this;
            boolean r0 = r1.H
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.I
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.view.n0.W(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.T0():boolean");
    }

    /* access modifiers changed from: package-private */
    public androidx.core.os.j V(@NonNull Context context) {
        androidx.core.os.j q10;
        if (Build.VERSION.SDK_INT >= 33 || (q10 = f.q()) == null) {
            return null;
        }
        androidx.core.os.j r02 = r0(context.getApplicationContext().getResources().getConfiguration());
        androidx.core.os.j b10 = p.b(q10, r02);
        if (b10.e()) {
            return r02;
        }
        return b10;
    }

    /* access modifiers changed from: package-private */
    public boolean V0() {
        if (this.f483o0 == null) {
            return false;
        }
        PanelFeatureState s02 = s0(0, false);
        if ((s02 == null || !s02.f506o) && this.B == null) {
            return false;
        }
        return true;
    }

    public androidx.appcompat.view.b W0(@NonNull b.a aVar) {
        d dVar;
        if (aVar != null) {
            androidx.appcompat.view.b bVar = this.B;
            if (bVar != null) {
                bVar.c();
            }
            h hVar = new h(aVar);
            a r10 = r();
            if (r10 != null) {
                androidx.appcompat.view.b C2 = r10.C(hVar);
                this.B = C2;
                if (!(C2 == null || (dVar = this.f484p) == null)) {
                    dVar.F(C2);
                }
            }
            if (this.B == null) {
                this.B = X0(hVar);
            }
            c1();
            return this.B;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* access modifiers changed from: package-private */
    public void X(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.T;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f501j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f506o) && !this.Y) {
            this.f481n.d(this.f479m.getCallback(), i10, menu);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.b X0(@androidx.annotation.NonNull androidx.appcompat.view.b.a r8) {
        /*
            r7 = this;
            r7.i0()
            androidx.appcompat.view.b r0 = r7.B
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.h
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$h r0 = new androidx.appcompat.app.AppCompatDelegateImpl$h
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.d r0 = r7.f484p
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.Y
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.view.b r0 = r0.O(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.B = r0
            goto L_0x015b
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.C
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.Q
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f477l
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = d.a.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f477l
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.view.d r4 = new androidx.appcompat.view.d
            android.content.Context r6 = r7.f477l
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f477l
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.C = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = d.a.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.D = r5
            r6 = 2
            androidx.core.widget.k.b(r5, r6)
            android.widget.PopupWindow r5 = r7.D
            androidx.appcompat.widget.ActionBarContextView r6 = r7.C
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.D
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = d.a.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.C
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.D
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$d r0 = new androidx.appcompat.app.AppCompatDelegateImpl$d
            r0.<init>()
            r7.E = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.I
            int r4 = d.f.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.n0()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.C = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.C
            if (r0 == 0) goto L_0x015b
            r7.i0()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.C
            r0.k()
            androidx.appcompat.view.e r0 = new androidx.appcompat.view.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.C
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.C
            android.widget.PopupWindow r6 = r7.D
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = r2
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.e()
            boolean r8 = r8.b(r0, r3)
            if (r8 == 0) goto L_0x0159
            r0.k()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.C
            r8.h(r0)
            r7.B = r0
            boolean r8 = r7.T0()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.C
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.C
            androidx.core.view.e2 r8 = androidx.core.view.n0.e(r8)
            androidx.core.view.e2 r8 = r8.b(r0)
            r7.F = r8
            androidx.appcompat.app.AppCompatDelegateImpl$e r0 = new androidx.appcompat.app.AppCompatDelegateImpl$e
            r0.<init>()
            r8.h(r0)
            goto L_0x0149
        L_0x012a:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.C
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.C
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.C
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0149
            androidx.appcompat.widget.ActionBarContextView r8 = r7.C
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.view.n0.p0(r8)
        L_0x0149:
            android.widget.PopupWindow r8 = r7.D
            if (r8 == 0) goto L_0x015b
            android.view.Window r8 = r7.f479m
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.E
            r8.post(r0)
            goto L_0x015b
        L_0x0159:
            r7.B = r1
        L_0x015b:
            androidx.appcompat.view.b r8 = r7.B
            if (r8 == 0) goto L_0x0166
            androidx.appcompat.app.d r0 = r7.f484p
            if (r0 == 0) goto L_0x0166
            r0.F(r8)
        L_0x0166:
            r7.c1()
            androidx.appcompat.view.b r8 = r7.B
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.X0(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    /* access modifiers changed from: package-private */
    public void Y(@NonNull androidx.appcompat.view.menu.g gVar) {
        if (!this.S) {
            this.S = true;
            this.f489x.l();
            Window.Callback u02 = u0();
            if (u02 != null && !this.Y) {
                u02.onPanelClosed(108, gVar);
            }
            this.S = false;
        }
    }

    public boolean a(@NonNull androidx.appcompat.view.menu.g gVar, @NonNull MenuItem menuItem) {
        PanelFeatureState l02;
        Window.Callback u02 = u0();
        if (u02 == null || this.Y || (l02 = l0(gVar.D())) == null) {
            return false;
        }
        return u02.onMenuItemSelected(l02.f492a, menuItem);
    }

    /* access modifiers changed from: package-private */
    public void a0(int i10) {
        b0(s0(i10, true), true);
    }

    public void b(@NonNull androidx.appcompat.view.menu.g gVar) {
        P0(true);
    }

    /* access modifiers changed from: package-private */
    public void b0(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        i0 i0Var;
        if (!z10 || panelFeatureState.f492a != 0 || (i0Var = this.f489x) == null || !i0Var.e()) {
            WindowManager windowManager = (WindowManager) this.f477l.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f506o || (viewGroup = panelFeatureState.f498g) == null)) {
                windowManager.removeView(viewGroup);
                if (z10) {
                    X(panelFeatureState.f492a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f504m = false;
            panelFeatureState.f505n = false;
            panelFeatureState.f506o = false;
            panelFeatureState.f499h = null;
            panelFeatureState.f508q = true;
            if (this.U == panelFeatureState) {
                this.U = null;
            }
            if (panelFeatureState.f492a == 0) {
                c1();
                return;
            }
            return;
        }
        Y(panelFeatureState.f501j);
    }

    /* access modifiers changed from: package-private */
    public void c1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean V0 = V0();
            if (V0 && this.f485p0 == null) {
                this.f485p0 = m.b(this.f483o0, this);
            } else if (!V0 && (onBackInvokedCallback = this.f485p0) != null) {
                m.c(this.f483o0, onBackInvokedCallback);
            }
        }
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ((ViewGroup) this.I.findViewById(16908290)).addView(view, layoutParams);
        this.f481n.c(this.f479m.getCallback());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0076, code lost:
        if (((org.xmlpull.v1.XmlPullParser) r15).getDepth() > 1) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View e0(android.view.View r12, java.lang.String r13, @androidx.annotation.NonNull android.content.Context r14, @androidx.annotation.NonNull android.util.AttributeSet r15) {
        /*
            r11 = this;
            androidx.appcompat.app.k r0 = r11.f480m0
            r1 = 0
            if (r0 != 0) goto L_0x0051
            android.content.Context r0 = r11.f477l
            int[] r2 = d.j.AppCompatTheme
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r2)
            int r2 = d.j.AppCompatTheme_viewInflaterClass
            java.lang.String r0 = r0.getString(r2)
            if (r0 != 0) goto L_0x001d
            androidx.appcompat.app.k r0 = new androidx.appcompat.app.k
            r0.<init>()
            r11.f480m0 = r0
            goto L_0x0051
        L_0x001d:
            android.content.Context r2 = r11.f477l     // Catch:{ all -> 0x0038 }
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x0038 }
            java.lang.Class r2 = r2.loadClass(r0)     // Catch:{ all -> 0x0038 }
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x0038 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ all -> 0x0038 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0038 }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ all -> 0x0038 }
            androidx.appcompat.app.k r2 = (androidx.appcompat.app.k) r2     // Catch:{ all -> 0x0038 }
            r11.f480m0 = r2     // Catch:{ all -> 0x0038 }
            goto L_0x0051
        L_0x0038:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to instantiate custom view inflater "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ". Falling back to default."
            r2.append(r0)
            androidx.appcompat.app.k r0 = new androidx.appcompat.app.k
            r0.<init>()
            r11.f480m0 = r0
        L_0x0051:
            boolean r8 = f461r0
            r0 = 1
            if (r8 == 0) goto L_0x0081
            androidx.appcompat.app.o r2 = r11.f482n0
            if (r2 != 0) goto L_0x0061
            androidx.appcompat.app.o r2 = new androidx.appcompat.app.o
            r2.<init>()
            r11.f482n0 = r2
        L_0x0061:
            androidx.appcompat.app.o r2 = r11.f482n0
            boolean r2 = r2.a(r15)
            if (r2 == 0) goto L_0x006b
            r7 = r0
            goto L_0x0082
        L_0x006b:
            boolean r2 = r15 instanceof org.xmlpull.v1.XmlPullParser
            if (r2 == 0) goto L_0x0079
            r2 = r15
            org.xmlpull.v1.XmlPullParser r2 = (org.xmlpull.v1.XmlPullParser) r2
            int r2 = r2.getDepth()
            if (r2 <= r0) goto L_0x0081
            goto L_0x0080
        L_0x0079:
            r0 = r12
            android.view.ViewParent r0 = (android.view.ViewParent) r0
            boolean r0 = r11.U0(r0)
        L_0x0080:
            r1 = r0
        L_0x0081:
            r7 = r1
        L_0x0082:
            androidx.appcompat.app.k r2 = r11.f480m0
            r9 = 1
            boolean r10 = androidx.appcompat.widget.s1.d()
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            android.view.View r12 = r2.r(r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e0(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* access modifiers changed from: package-private */
    public final int e1(k2 k2Var, Rect rect) {
        int i10;
        boolean z10;
        int i11;
        int i12;
        boolean z11;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i13;
        int i14 = 0;
        if (k2Var != null) {
            i10 = k2Var.k();
        } else if (rect != null) {
            i10 = rect.top;
        } else {
            i10 = 0;
        }
        ActionBarContextView actionBarContextView = this.C;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.C.getLayoutParams();
            boolean z12 = true;
            if (this.C.isShown()) {
                if (this.f476k0 == null) {
                    this.f476k0 = new Rect();
                    this.f478l0 = new Rect();
                }
                Rect rect2 = this.f476k0;
                Rect rect3 = this.f478l0;
                if (k2Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(k2Var.i(), k2Var.k(), k2Var.j(), k2Var.h());
                }
                t1.a(this.I, rect2, rect3);
                int i15 = rect2.top;
                int i16 = rect2.left;
                int i17 = rect2.right;
                k2 I2 = n0.I(this.I);
                if (I2 == null) {
                    i11 = 0;
                } else {
                    i11 = I2.i();
                }
                if (I2 == null) {
                    i12 = 0;
                } else {
                    i12 = I2.j();
                }
                if (marginLayoutParams2.topMargin == i15 && marginLayoutParams2.leftMargin == i16 && marginLayoutParams2.rightMargin == i17) {
                    z11 = false;
                } else {
                    marginLayoutParams2.topMargin = i15;
                    marginLayoutParams2.leftMargin = i16;
                    marginLayoutParams2.rightMargin = i17;
                    z11 = true;
                }
                if (i15 <= 0 || this.K != null) {
                    View view = this.K;
                    if (!(view == null || ((marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()).height == (i13 = marginLayoutParams2.topMargin) && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12))) {
                        marginLayoutParams.height = i13;
                        marginLayoutParams.leftMargin = i11;
                        marginLayoutParams.rightMargin = i12;
                        this.K.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    View view2 = new View(this.f477l);
                    this.K = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams2.topMargin, 51);
                    layoutParams.leftMargin = i11;
                    layoutParams.rightMargin = i12;
                    this.I.addView(this.K, -1, layoutParams);
                }
                View view3 = this.K;
                if (view3 == null) {
                    z12 = false;
                }
                if (z12 && view3.getVisibility() != 0) {
                    f1(this.K);
                }
                if (!this.P && z12) {
                    i10 = 0;
                }
                z10 = z12;
                z12 = z11;
            } else if (marginLayoutParams2.topMargin != 0) {
                marginLayoutParams2.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z12 = false;
            }
            if (z12) {
                this.C.setLayoutParams(marginLayoutParams2);
            }
        }
        View view4 = this.K;
        if (view4 != null) {
            if (!z10) {
                i14 = 8;
            }
            view4.setVisibility(i14);
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void f0() {
        androidx.appcompat.view.menu.g gVar;
        i0 i0Var = this.f489x;
        if (i0Var != null) {
            i0Var.l();
        }
        if (this.D != null) {
            this.f479m.getDecorView().removeCallbacks(this.E);
            if (this.D.isShowing()) {
                try {
                    this.D.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.D = null;
        }
        i0();
        PanelFeatureState s02 = s0(0, false);
        if (s02 != null && (gVar = s02.f501j) != null) {
            gVar.close();
        }
    }

    @NonNull
    public Context g(@NonNull Context context) {
        boolean z10 = true;
        this.W = true;
        int B0 = B0(context, W());
        if (f.u(context)) {
            f.P(context);
        }
        androidx.core.os.j V2 = V(context);
        if (f464u0 && (context instanceof ContextThemeWrapper)) {
            try {
                r.a((ContextThemeWrapper) context, c0(context, B0, V2, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(c0(context, B0, V2, (Configuration) null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f463t0) {
            return super.g(context);
        }
        Configuration configuration = null;
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = i.a(context, configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = m0(configuration3, configuration4);
        }
        Configuration c02 = c0(context, B0, V2, configuration, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, d.i.Theme_AppCompat_Empty);
        dVar.a(c02);
        boolean z11 = false;
        try {
            if (context.getTheme() == null) {
                z10 = false;
            }
            z11 = z10;
        } catch (NullPointerException unused3) {
        }
        if (z11) {
            h.g.a(dVar.getTheme());
        }
        return super.g(dVar);
    }

    /* access modifiers changed from: package-private */
    public boolean g0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f475k;
        boolean z10 = true;
        if (((obj instanceof f.a) || (obj instanceof i)) && (decorView = this.f479m.getDecorView()) != null && androidx.core.view.f.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f481n.b(this.f479m.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z10 = false;
        }
        if (z10) {
            return D0(keyCode, keyEvent);
        }
        return G0(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public void h0(int i10) {
        PanelFeatureState s02;
        PanelFeatureState s03 = s0(i10, true);
        if (s03.f501j != null) {
            Bundle bundle = new Bundle();
            s03.f501j.Q(bundle);
            if (bundle.size() > 0) {
                s03.f510s = bundle;
            }
            s03.f501j.d0();
            s03.f501j.clear();
        }
        s03.f509r = true;
        s03.f508q = true;
        if ((i10 == 108 || i10 == 0) && this.f489x != null && (s02 = s0(0, false)) != null) {
            s02.f504m = false;
            O0(s02, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void i0() {
        e2 e2Var = this.F;
        if (e2Var != null) {
            e2Var.c();
        }
    }

    public <T extends View> T j(int i10) {
        j0();
        return this.f479m.findViewById(i10);
    }

    public Context l() {
        return this.f477l;
    }

    /* access modifiers changed from: package-private */
    public PanelFeatureState l0(Menu menu) {
        int i10;
        PanelFeatureState[] panelFeatureStateArr = this.T;
        if (panelFeatureStateArr != null) {
            i10 = panelFeatureStateArr.length;
        } else {
            i10 = 0;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
            if (panelFeatureState != null && panelFeatureState.f501j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public int n() {
        return this.f465a0;
    }

    /* access modifiers changed from: package-private */
    public final Context n0() {
        Context context;
        a r10 = r();
        if (r10 != null) {
            context = r10.k();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f477l;
        }
        return context;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return e0(view, str, context, attributeSet);
    }

    public MenuInflater p() {
        Context context;
        if (this.f487t == null) {
            v0();
            a aVar = this.f486q;
            if (aVar != null) {
                context = aVar.k();
            } else {
                context = this.f477l;
            }
            this.f487t = new androidx.appcompat.view.g(context);
        }
        return this.f487t;
    }

    public a r() {
        v0();
        return this.f486q;
    }

    /* access modifiers changed from: package-private */
    public androidx.core.os.j r0(Configuration configuration) {
        return k.b(configuration);
    }

    public void s() {
        LayoutInflater from = LayoutInflater.from(this.f477l);
        if (from.getFactory() == null) {
            androidx.core.view.g.a(from, this);
        } else {
            boolean z10 = from.getFactory2() instanceof AppCompatDelegateImpl;
        }
    }

    /* access modifiers changed from: protected */
    public PanelFeatureState s0(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.T;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i10 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.T = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    public void t() {
        if (M0() != null && !r().m()) {
            z0(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final CharSequence t0() {
        Object obj = this.f475k;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f488w;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback u0() {
        return this.f479m.getCallback();
    }

    public void w(Configuration configuration) {
        a r10;
        if (this.N && this.H && (r10 = r()) != null) {
            r10.n(configuration);
        }
        androidx.appcompat.widget.h.b().g(this.f477l);
        this.Z = new Configuration(this.f477l.getResources().getConfiguration());
        R(false, false);
    }

    public void x(Bundle bundle) {
        this.W = true;
        Q(false);
        k0();
        Object obj = this.f475k;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.n.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a M0 = M0();
                if (M0 == null) {
                    this.f474j0 = true;
                } else {
                    M0.t(true);
                }
            }
            f.d(this);
        }
        this.Z = new Configuration(this.f477l.getResources().getConfiguration());
        this.X = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f475k
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            androidx.appcompat.app.f.E(r3)
        L_0x0009:
            boolean r0 = r3.f471g0
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f479m
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f473i0
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 1
            r3.Y = r0
            int r0 = r3.f465a0
            r1 = -100
            if (r0 == r1) goto L_0x0045
            java.lang.Object r0 = r3.f475k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0045
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0045
            androidx.collection.g<java.lang.String, java.lang.Integer> r0 = f460q0
            java.lang.Object r1 = r3.f475k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f465a0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0054
        L_0x0045:
            androidx.collection.g<java.lang.String, java.lang.Integer> r0 = f460q0
            java.lang.Object r1 = r3.f475k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0054:
            androidx.appcompat.app.a r0 = r3.f486q
            if (r0 == 0) goto L_0x005b
            r0.o()
        L_0x005b:
            r3.Z()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.y():void");
    }

    public void z(Bundle bundle) {
        j0();
    }

    AppCompatDelegateImpl(Dialog dialog, d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r3 = f460q0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatDelegateImpl(android.content.Context r3, android.view.Window r4, androidx.appcompat.app.d r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.F = r0
            r0 = 1
            r2.G = r0
            r0 = -100
            r2.f465a0 = r0
            androidx.appcompat.app.AppCompatDelegateImpl$a r1 = new androidx.appcompat.app.AppCompatDelegateImpl$a
            r1.<init>()
            r2.f473i0 = r1
            r2.f477l = r3
            r2.f484p = r5
            r2.f475k = r6
            int r3 = r2.f465a0
            if (r3 != r0) goto L_0x0032
            boolean r3 = r6 instanceof android.app.Dialog
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.c r3 = r2.Z0()
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.f r3 = r3.k0()
            int r3 = r3.n()
            r2.f465a0 = r3
        L_0x0032:
            int r3 = r2.f465a0
            if (r3 != r0) goto L_0x0059
            androidx.collection.g<java.lang.String, java.lang.Integer> r3 = f460q0
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r3.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0059
            int r5 = r5.intValue()
            r2.f465a0 = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r3.remove(r5)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r2.U(r4)
        L_0x005e:
            androidx.appcompat.widget.h.h()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.<init>(android.content.Context, android.view.Window, androidx.appcompat.app.d, java.lang.Object):void");
    }
}
