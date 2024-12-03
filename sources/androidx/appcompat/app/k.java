package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.view.d;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.e1;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.r;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.u;
import androidx.collection.g;
import androidx.core.view.n0;
import d.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class k {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f560b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f561c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f562d = {16844160};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f563e = {16844156};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f564f = {16844148};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f565g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h  reason: collision with root package name */
    private static final g<String, Constructor<? extends View>> f566h = new g<>();

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f567a = new Object[2];

    private static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final View f568a;

        /* renamed from: b  reason: collision with root package name */
        private final String f569b;

        /* renamed from: c  reason: collision with root package name */
        private Method f570c;

        /* renamed from: d  reason: collision with root package name */
        private Context f571d;

        public a(@NonNull View view, @NonNull String str) {
            this.f568a = view;
            this.f569b = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f569b, new Class[]{View.class})) != null) {
                        this.f570c = method;
                        this.f571d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    context = null;
                }
            }
            int id2 = this.f568a.getId();
            if (id2 == -1) {
                str = "";
            } else {
                str = " with id '" + this.f568a.getContext().getResources().getResourceEntryName(id2) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f569b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f568a.getClass() + str);
        }

        public void onClick(@NonNull View view) {
            if (this.f570c == null) {
                a(this.f568a.getContext());
            }
            try {
                this.f570c.invoke(this.f571d, new Object[]{view});
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
            } catch (InvocationTargetException e11) {
                throw new IllegalStateException("Could not execute method for android:onClick", e11);
            }
        }
    }

    private void a(@NonNull Context context, @NonNull View view, @NonNull AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT <= 28) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f562d);
            if (obtainStyledAttributes.hasValue(0)) {
                n0.t0(view, obtainStyledAttributes.getBoolean(0, false));
            }
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f563e);
            if (obtainStyledAttributes2.hasValue(0)) {
                n0.v0(view, obtainStyledAttributes2.getString(0));
            }
            obtainStyledAttributes2.recycle();
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f564f);
            if (obtainStyledAttributes3.hasValue(0)) {
                n0.K0(view, obtainStyledAttributes3.getBoolean(0, false));
            }
            obtainStyledAttributes3.recycle();
        }
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && n0.R(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f561c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View s(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        g<String, Constructor<? extends View>> gVar = f566h;
        Constructor<? extends U> constructor = gVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f560b);
            gVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f567a);
    }

    private View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            Object[] objArr = this.f567a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                int i10 = 0;
                while (true) {
                    String[] strArr = f565g;
                    if (i10 < strArr.length) {
                        View s10 = s(context, str, strArr[i10]);
                        if (s10 != null) {
                            return s10;
                        }
                        i10++;
                    } else {
                        Object[] objArr2 = this.f567a;
                        objArr2[0] = null;
                        objArr2[1] = null;
                        return null;
                    }
                }
            } else {
                View s11 = s(context, str, (String) null);
                Object[] objArr3 = this.f567a;
                objArr3[0] = null;
                objArr3[1] = null;
                return s11;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr4 = this.f567a;
            objArr4[0] = null;
            objArr4[1] = null;
        }
    }

    private static Context u(Context context, AttributeSet attributeSet, boolean z10, boolean z11) {
        int i10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.View, 0, 0);
        if (z10) {
            i10 = obtainStyledAttributes.getResourceId(j.View_android_theme, 0);
        } else {
            i10 = 0;
        }
        if (z11 && i10 == 0) {
            i10 = obtainStyledAttributes.getResourceId(j.View_theme, 0);
        }
        obtainStyledAttributes.recycle();
        if (i10 == 0) {
            return context;
        }
        if (!(context instanceof d) || ((d) context).c() != i10) {
            return new d(context, i10);
        }
        return context;
    }

    private void v(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public c c(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatButton d(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public e f(Context context, AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public i g(Context context, AttributeSet attributeSet) {
        return new i(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public m h(Context context, AttributeSet attributeSet) {
        return new m(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatImageView i(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public o j(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public r k(Context context, AttributeSet attributeSet) {
        return new r(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public s l(Context context, AttributeSet attributeSet) {
        return new s(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public u m(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatSpinner n(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public d0 o(Context context, AttributeSet attributeSet) {
        return new d0(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public h0 p(Context context, AttributeSet attributeSet) {
        return new h0(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View r(View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z10, boolean z11, boolean z12, boolean z13) {
        Context context2;
        View view2;
        if (!z10 || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        if (z11 || z12) {
            context2 = u(context2, attributeSet, z11, z12);
        }
        if (z13) {
            context2 = e1.b(context2);
        }
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c10 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c10 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c10 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c10 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c10 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c10 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c10 = 8;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c10 = 9;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c10 = 10;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c10 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c10 = 12;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c10 = 13;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                view2 = l(context2, attributeSet);
                v(view2, str);
                break;
            case 1:
                view2 = f(context2, attributeSet);
                v(view2, str);
                break;
            case 2:
                view2 = j(context2, attributeSet);
                v(view2, str);
                break;
            case 3:
                view2 = o(context2, attributeSet);
                v(view2, str);
                break;
            case 4:
                view2 = h(context2, attributeSet);
                v(view2, str);
                break;
            case 5:
                view2 = m(context2, attributeSet);
                v(view2, str);
                break;
            case 6:
                view2 = n(context2, attributeSet);
                v(view2, str);
                break;
            case 7:
                view2 = k(context2, attributeSet);
                v(view2, str);
                break;
            case 8:
                view2 = p(context2, attributeSet);
                v(view2, str);
                break;
            case 9:
                view2 = i(context2, attributeSet);
                v(view2, str);
                break;
            case 10:
                view2 = c(context2, attributeSet);
                v(view2, str);
                break;
            case 11:
                view2 = e(context2, attributeSet);
                v(view2, str);
                break;
            case 12:
                view2 = g(context2, attributeSet);
                v(view2, str);
                break;
            case 13:
                view2 = d(context2, attributeSet);
                v(view2, str);
                break;
            default:
                view2 = q(context2, str, attributeSet);
                break;
        }
        if (view2 == null && context != context2) {
            view2 = t(context2, str, attributeSet);
        }
        if (view2 != null) {
            b(view2, attributeSet);
            a(context2, view2, attributeSet);
        }
        return view2;
    }
}
