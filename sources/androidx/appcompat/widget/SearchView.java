package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import net.bytebuddy.jar.asm.Opcodes;

public class SearchView extends LinearLayoutCompat implements androidx.appcompat.view.c {

    /* renamed from: x0  reason: collision with root package name */
    static final o f1068x0 = (Build.VERSION.SDK_INT < 29 ? new o() : null);
    final ImageView B;
    final ImageView C;
    final ImageView D;
    private final View E;
    private p F;
    private Rect G;
    private Rect H;
    private int[] I;
    private int[] J;
    private final ImageView K;
    private final Drawable L;
    private final int M;
    private final int N;
    private final Intent O;
    private final Intent P;
    private final CharSequence Q;
    private m R;
    private l S;
    View.OnFocusChangeListener T;
    private n U;
    private View.OnClickListener V;
    private boolean W;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f1069a0;

    /* renamed from: b0  reason: collision with root package name */
    x0.a f1070b0;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f1071c0;

    /* renamed from: d0  reason: collision with root package name */
    private CharSequence f1072d0;

    /* renamed from: e0  reason: collision with root package name */
    private boolean f1073e0;

    /* renamed from: f0  reason: collision with root package name */
    private boolean f1074f0;

    /* renamed from: g0  reason: collision with root package name */
    private int f1075g0;

    /* renamed from: h0  reason: collision with root package name */
    private boolean f1076h0;

    /* renamed from: i0  reason: collision with root package name */
    private CharSequence f1077i0;

    /* renamed from: j0  reason: collision with root package name */
    private CharSequence f1078j0;

    /* renamed from: k0  reason: collision with root package name */
    private boolean f1079k0;

    /* renamed from: l0  reason: collision with root package name */
    private int f1080l0;

    /* renamed from: m0  reason: collision with root package name */
    SearchableInfo f1081m0;

    /* renamed from: n0  reason: collision with root package name */
    private Bundle f1082n0;

    /* renamed from: o0  reason: collision with root package name */
    private final Runnable f1083o0;

    /* renamed from: p0  reason: collision with root package name */
    private Runnable f1084p0;

    /* renamed from: q0  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1085q0;

    /* renamed from: r0  reason: collision with root package name */
    private final View.OnClickListener f1086r0;

    /* renamed from: s0  reason: collision with root package name */
    View.OnKeyListener f1087s0;

    /* renamed from: t  reason: collision with root package name */
    final SearchAutoComplete f1088t;

    /* renamed from: t0  reason: collision with root package name */
    private final TextView.OnEditorActionListener f1089t0;

    /* renamed from: u0  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f1090u0;

    /* renamed from: v0  reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f1091v0;

    /* renamed from: w  reason: collision with root package name */
    private final View f1092w;

    /* renamed from: w0  reason: collision with root package name */
    private TextWatcher f1093w0;

    /* renamed from: x  reason: collision with root package name */
    private final View f1094x;

    /* renamed from: y  reason: collision with root package name */
    private final View f1095y;

    /* renamed from: z  reason: collision with root package name */
    final ImageView f1096z;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f1097c;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1097c + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f1097c));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1097c = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }
    }

    public static class SearchAutoComplete extends c {

        /* renamed from: e  reason: collision with root package name */
        private int f1098e;

        /* renamed from: f  reason: collision with root package name */
        private SearchView f1099f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1100g;

        /* renamed from: h  reason: collision with root package name */
        final Runnable f1101h;

        class a implements Runnable {
            a() {
            }

            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, d.a.autoCompleteTextViewStyle);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 >= 600) {
                return 192;
            }
            if (i10 < 640 || i11 < 480) {
                return 160;
            }
            return 192;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (Build.VERSION.SDK_INT >= 29) {
                k.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f1068x0.c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f1100g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1100g = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f1098e <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1100g) {
                removeCallbacks(this.f1101h);
                post(this.f1101h);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f1099f.X();
        }

        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1099f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f1099f.hasFocus() && getVisibility() == 0) {
                this.f1100g = true;
                if (SearchView.K(getContext())) {
                    b();
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f1100g = false;
                removeCallbacks(this.f1101h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1100g = false;
                removeCallbacks(this.f1101h);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1100g = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.f1099f = searchView;
        }

        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f1098e = i10;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f1101h = new a();
            this.f1098e = getThreshold();
        }
    }

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView.this.W(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            SearchView.this.d0();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            x0.a aVar = SearchView.this.f1070b0;
            if (aVar instanceof b1) {
                aVar.a((Cursor) null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.T;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView.this.z();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f1096z) {
                searchView.T();
            } else if (view == searchView.C) {
                searchView.P();
            } else if (view == searchView.B) {
                searchView.U();
            } else if (view == searchView.D) {
                searchView.Y();
            } else if (view == searchView.f1088t) {
                searchView.F();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f1081m0 == null) {
                return false;
            }
            if (searchView.f1088t.isPopupShowing() && SearchView.this.f1088t.getListSelection() != -1) {
                return SearchView.this.V(view, i10, keyEvent);
            }
            if (SearchView.this.f1088t.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.N(0, (String) null, searchView2.f1088t.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.U();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.Q(i10, 0, (String) null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            SearchView.this.R(i10);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    static class k {
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i10) {
            searchAutoComplete.setInputMethodMode(i10);
        }
    }

    public interface l {
        boolean onClose();
    }

    public interface m {
        boolean a(String str);

        boolean b(String str);
    }

    public interface n {
        boolean a(int i10);

        boolean b(int i10);
    }

    private static class o {

        /* renamed from: a  reason: collision with root package name */
        private Method f1113a = null;

        /* renamed from: b  reason: collision with root package name */
        private Method f1114b = null;

        /* renamed from: c  reason: collision with root package name */
        private Method f1115c = null;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        o() {
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1113a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1114b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1115c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        /* access modifiers changed from: package-private */
        public void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1114b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1113a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f1115c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }
    }

    private static class p extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f1116a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f1117b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f1118c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final Rect f1119d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        private final int f1120e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1121f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1120e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f1116a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f1117b.set(rect);
            this.f1119d.set(rect);
            Rect rect3 = this.f1119d;
            int i10 = this.f1120e;
            rect3.inset(-i10, -i10);
            this.f1118c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r9) {
            /*
                r8 = this;
                float r0 = r9.getX()
                int r0 = (int) r0
                float r1 = r9.getY()
                int r1 = (int) r1
                int r2 = r9.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0033
                if (r2 == r4) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003f
            L_0x001b:
                boolean r2 = r8.f1121f
                r8.f1121f = r5
                goto L_0x002f
            L_0x0020:
                boolean r2 = r8.f1121f
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r8.f1119d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r4 = r2
                r2 = r5
                goto L_0x0041
            L_0x002f:
                r7 = r4
                r4 = r2
                r2 = r7
                goto L_0x0041
            L_0x0033:
                android.graphics.Rect r2 = r8.f1117b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003f
                r8.f1121f = r4
                r2 = r4
                goto L_0x0041
            L_0x003f:
                r2 = r4
                r4 = r5
            L_0x0041:
                if (r4 == 0) goto L_0x0074
                if (r2 == 0) goto L_0x0061
                android.graphics.Rect r2 = r8.f1118c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x0061
                android.view.View r0 = r8.f1116a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r8.f1116a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r9.setLocation(r0, r1)
                goto L_0x006e
            L_0x0061:
                android.graphics.Rect r2 = r8.f1118c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r9.setLocation(r0, r1)
            L_0x006e:
                android.view.View r0 = r8.f1116a
                boolean r5 = r0.dispatchTouchEvent(r9)
            L_0x0074:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.p.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private Intent A(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1078j0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1082n0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1081m0.getSearchActivity());
        return intent;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:19|20|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r10 = r10.getPosition();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        r10 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        r11 = new java.lang.StringBuilder();
        r11.append("Search suggestions cursor at row ");
        r11.append(r10);
        r11.append(" returned exception.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0061 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Intent B(android.database.Cursor r10, int r11, java.lang.String r12) {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r1 = "suggest_intent_action"
            java.lang.String r1 = androidx.appcompat.widget.b1.n(r10, r1)     // Catch:{ RuntimeException -> 0x0061 }
            if (r1 != 0) goto L_0x000f
            android.app.SearchableInfo r1 = r9.f1081m0     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = r1.getSuggestIntentAction()     // Catch:{ RuntimeException -> 0x0061 }
        L_0x000f:
            if (r1 != 0) goto L_0x0013
            java.lang.String r1 = "android.intent.action.SEARCH"
        L_0x0013:
            r3 = r1
            java.lang.String r1 = "suggest_intent_data"
            java.lang.String r1 = androidx.appcompat.widget.b1.n(r10, r1)     // Catch:{ RuntimeException -> 0x0061 }
            if (r1 != 0) goto L_0x0022
            android.app.SearchableInfo r1 = r9.f1081m0     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = r1.getSuggestIntentData()     // Catch:{ RuntimeException -> 0x0061 }
        L_0x0022:
            if (r1 == 0) goto L_0x0044
            java.lang.String r2 = "suggest_intent_data_id"
            java.lang.String r2 = androidx.appcompat.widget.b1.n(r10, r2)     // Catch:{ RuntimeException -> 0x0061 }
            if (r2 == 0) goto L_0x0044
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0061 }
            r4.<init>()     // Catch:{ RuntimeException -> 0x0061 }
            r4.append(r1)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = "/"
            r4.append(r1)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = android.net.Uri.encode(r2)     // Catch:{ RuntimeException -> 0x0061 }
            r4.append(r1)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = r4.toString()     // Catch:{ RuntimeException -> 0x0061 }
        L_0x0044:
            if (r1 != 0) goto L_0x0048
            r4 = r0
            goto L_0x004d
        L_0x0048:
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ RuntimeException -> 0x0061 }
            r4 = r1
        L_0x004d:
            java.lang.String r1 = "suggest_intent_query"
            java.lang.String r6 = androidx.appcompat.widget.b1.n(r10, r1)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = "suggest_intent_extra_data"
            java.lang.String r5 = androidx.appcompat.widget.b1.n(r10, r1)     // Catch:{ RuntimeException -> 0x0061 }
            r2 = r9
            r7 = r11
            r8 = r12
            android.content.Intent r10 = r2.A(r3, r4, r5, r6, r7, r8)     // Catch:{ RuntimeException -> 0x0061 }
            return r10
        L_0x0061:
            int r10 = r10.getPosition()     // Catch:{ RuntimeException -> 0x0066 }
            goto L_0x0067
        L_0x0066:
            r10 = -1
        L_0x0067:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Search suggestions cursor at row "
            r11.append(r12)
            r11.append(r10)
            java.lang.String r10 = " returned exception."
            r11.append(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.B(android.database.Cursor, int, java.lang.String):android.content.Intent");
    }

    private Intent C(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1082n0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i10 = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i10 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i10);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent D(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", str);
        return intent2;
    }

    private void E() {
        this.f1088t.dismissDropDown();
    }

    private void G(View view, Rect rect) {
        view.getLocationInWindow(this.I);
        getLocationInWindow(this.J);
        int[] iArr = this.I;
        int i10 = iArr[1];
        int[] iArr2 = this.J;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    private CharSequence H(CharSequence charSequence) {
        if (!this.W || this.L == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1088t.getTextSize()) * 1.25d);
        this.L.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.L), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean I() {
        SearchableInfo searchableInfo = this.f1081m0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1081m0.getVoiceSearchLaunchWebSearch()) {
            intent = this.O;
        } else if (this.f1081m0.getVoiceSearchLaunchRecognizer()) {
            intent = this.P;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    static boolean K(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean L() {
        return (this.f1071c0 || this.f1076h0) && !J();
    }

    private void M(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed launch activity: ");
                sb2.append(intent);
            }
        }
    }

    private boolean O(int i10, int i11, String str) {
        Cursor c10 = this.f1070b0.c();
        if (c10 == null || !c10.moveToPosition(i10)) {
            return false;
        }
        M(B(c10, i11, str));
        return true;
    }

    private void Z() {
        post(this.f1083o0);
    }

    private void a0(int i10) {
        Editable text = this.f1088t.getText();
        Cursor c10 = this.f1070b0.c();
        if (c10 != null) {
            if (c10.moveToPosition(i10)) {
                CharSequence convertToString = this.f1070b0.convertToString(c10);
                if (convertToString != null) {
                    setQuery(convertToString);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    private void c0() {
        int[] iArr;
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f1088t.getText());
        int i10 = 0;
        if (!z11 && (!this.W || this.f1079k0)) {
            z10 = false;
        }
        ImageView imageView = this.C;
        if (!z10) {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        Drawable drawable = this.C.getDrawable();
        if (drawable != null) {
            if (z11) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    private void e0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1088t;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(H(queryHint));
    }

    private void f0() {
        this.f1088t.setThreshold(this.f1081m0.getSuggestThreshold());
        this.f1088t.setImeOptions(this.f1081m0.getImeOptions());
        int inputType = this.f1081m0.getInputType();
        int i10 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1081m0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | Opcodes.ASM8;
            }
        }
        this.f1088t.setInputType(inputType);
        x0.a aVar = this.f1070b0;
        if (aVar != null) {
            aVar.a((Cursor) null);
        }
        if (this.f1081m0.getSuggestAuthority() != null) {
            b1 b1Var = new b1(getContext(), this, this.f1081m0, this.f1085q0);
            this.f1070b0 = b1Var;
            this.f1088t.setAdapter(b1Var);
            b1 b1Var2 = (b1) this.f1070b0;
            if (this.f1073e0) {
                i10 = 2;
            }
            b1Var2.w(i10);
        }
    }

    private void g0() {
        int i10;
        if (!L() || !(this.B.getVisibility() == 0 || this.D.getVisibility() == 0)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        this.f1095y.setVisibility(i10);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(d.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(d.d.abc_search_view_preferred_width);
    }

    private void h0(boolean z10) {
        int i10;
        if (!this.f1071c0 || !L() || !hasFocus() || (!z10 && this.f1076h0)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        this.B.setVisibility(i10);
    }

    private void i0(boolean z10) {
        int i10;
        int i11;
        this.f1069a0 = z10;
        int i12 = 0;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        boolean z11 = !TextUtils.isEmpty(this.f1088t.getText());
        this.f1096z.setVisibility(i10);
        h0(z11);
        View view = this.f1092w;
        if (z10) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        view.setVisibility(i11);
        if (this.K.getDrawable() == null || this.W) {
            i12 = 8;
        }
        this.K.setVisibility(i12);
        c0();
        j0(!z11);
        g0();
    }

    private void j0(boolean z10) {
        int i10 = 8;
        if (this.f1076h0 && !J() && z10) {
            this.B.setVisibility(8);
            i10 = 0;
        }
        this.D.setVisibility(i10);
    }

    private void setQuery(CharSequence charSequence) {
        int i10;
        this.f1088t.setText(charSequence);
        SearchAutoComplete searchAutoComplete = this.f1088t;
        if (TextUtils.isEmpty(charSequence)) {
            i10 = 0;
        } else {
            i10 = charSequence.length();
        }
        searchAutoComplete.setSelection(i10);
    }

    /* access modifiers changed from: package-private */
    public void F() {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.f1088t);
            return;
        }
        o oVar = f1068x0;
        oVar.b(this.f1088t);
        oVar.a(this.f1088t);
    }

    public boolean J() {
        return this.f1069a0;
    }

    /* access modifiers changed from: package-private */
    public void N(int i10, String str, String str2) {
        getContext().startActivity(A("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i10, str));
    }

    /* access modifiers changed from: package-private */
    public void P() {
        if (!TextUtils.isEmpty(this.f1088t.getText())) {
            this.f1088t.setText("");
            this.f1088t.requestFocus();
            this.f1088t.setImeVisibility(true);
        } else if (this.W) {
            l lVar = this.S;
            if (lVar == null || !lVar.onClose()) {
                clearFocus();
                i0(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Q(int i10, int i11, String str) {
        n nVar = this.U;
        if (nVar != null && nVar.b(i10)) {
            return false;
        }
        O(i10, 0, (String) null);
        this.f1088t.setImeVisibility(false);
        E();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean R(int i10) {
        n nVar = this.U;
        if (nVar != null && nVar.a(i10)) {
            return false;
        }
        a0(i10);
        return true;
    }

    /* access modifiers changed from: protected */
    public void S(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void T() {
        i0(false);
        this.f1088t.requestFocus();
        this.f1088t.setImeVisibility(true);
        View.OnClickListener onClickListener = this.V;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void U() {
        Editable text = this.f1088t.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            m mVar = this.R;
            if (mVar == null || !mVar.b(text.toString())) {
                if (this.f1081m0 != null) {
                    N(0, (String) null, text.toString());
                }
                this.f1088t.setImeVisibility(false);
                E();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean V(View view, int i10, KeyEvent keyEvent) {
        int i11;
        if (this.f1081m0 != null && this.f1070b0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                return Q(this.f1088t.getListSelection(), 0, (String) null);
            }
            if (i10 == 21 || i10 == 22) {
                if (i10 == 21) {
                    i11 = 0;
                } else {
                    i11 = this.f1088t.length();
                }
                this.f1088t.setSelection(i11);
                this.f1088t.setListSelection(0);
                this.f1088t.clearListSelection();
                this.f1088t.b();
                return true;
            } else if (i10 == 19) {
                this.f1088t.getListSelection();
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void W(CharSequence charSequence) {
        Editable text = this.f1088t.getText();
        this.f1078j0 = text;
        boolean z10 = !TextUtils.isEmpty(text);
        h0(z10);
        j0(!z10);
        c0();
        g0();
        if (this.R != null && !TextUtils.equals(charSequence, this.f1077i0)) {
            this.R.a(charSequence.toString());
        }
        this.f1077i0 = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public void X() {
        i0(J());
        Z();
        if (this.f1088t.hasFocus()) {
            F();
        }
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        SearchableInfo searchableInfo = this.f1081m0;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(D(this.O, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(C(this.P, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
            }
        }
    }

    public void b0(CharSequence charSequence, boolean z10) {
        this.f1088t.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1088t;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1078j0 = charSequence;
        }
        if (z10 && !TextUtils.isEmpty(charSequence)) {
            U();
        }
    }

    public void clearFocus() {
        this.f1074f0 = true;
        super.clearFocus();
        this.f1088t.clearFocus();
        this.f1088t.setImeVisibility(false);
        this.f1074f0 = false;
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        int[] iArr;
        if (this.f1088t.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f1094x.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1095y.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f1088t.getImeOptions();
    }

    public int getInputType() {
        return this.f1088t.getInputType();
    }

    public int getMaxWidth() {
        return this.f1075g0;
    }

    public CharSequence getQuery() {
        return this.f1088t.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f1072d0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1081m0;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.Q;
        }
        return getContext().getText(this.f1081m0.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.N;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.M;
    }

    public x0.a getSuggestionsAdapter() {
        return this.f1070b0;
    }

    public void onActionViewCollapsed() {
        b0("", false);
        clearFocus();
        i0(true);
        this.f1088t.setImeOptions(this.f1080l0);
        this.f1079k0 = false;
    }

    public void onActionViewExpanded() {
        if (!this.f1079k0) {
            this.f1079k0 = true;
            int imeOptions = this.f1088t.getImeOptions();
            this.f1080l0 = imeOptions;
            this.f1088t.setImeOptions(imeOptions | 33554432);
            this.f1088t.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1083o0);
        post(this.f1084p0);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            G(this.f1088t, this.G);
            Rect rect = this.H;
            Rect rect2 = this.G;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            p pVar = this.F;
            if (pVar == null) {
                p pVar2 = new p(this.H, this.G, this.f1088t);
                this.F = pVar2;
                setTouchDelegate(pVar2);
                return;
            }
            pVar.a(this.H, this.G);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        if (J()) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i13 = this.f1075g0;
            size = i13 > 0 ? Math.min(i13, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f1075g0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i12 = this.f1075g0) > 0) {
            size = Math.min(i12, size);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        i0(savedState.f1097c);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1097c = J();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        Z();
    }

    public boolean requestFocus(int i10, Rect rect) {
        if (this.f1074f0 || !isFocusable()) {
            return false;
        }
        if (J()) {
            return super.requestFocus(i10, rect);
        }
        boolean requestFocus = this.f1088t.requestFocus(i10, rect);
        if (requestFocus) {
            i0(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1082n0 = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            P();
        } else {
            T();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.W != z10) {
            this.W = z10;
            i0(z10);
            e0();
        }
    }

    public void setImeOptions(int i10) {
        this.f1088t.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f1088t.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.f1075g0 = i10;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
        this.S = lVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.T = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.R = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.V = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
        this.U = nVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1072d0 = charSequence;
        e0();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        int i10;
        this.f1073e0 = z10;
        x0.a aVar = this.f1070b0;
        if (aVar instanceof b1) {
            b1 b1Var = (b1) aVar;
            if (z10) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            b1Var.w(i10);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1081m0 = searchableInfo;
        if (searchableInfo != null) {
            f0();
            e0();
        }
        boolean I2 = I();
        this.f1076h0 = I2;
        if (I2) {
            this.f1088t.setPrivateImeOptions("nm");
        }
        i0(J());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.f1071c0 = z10;
        i0(J());
    }

    public void setSuggestionsAdapter(x0.a aVar) {
        this.f1070b0 = aVar;
        this.f1088t.setAdapter(aVar);
    }

    /* access modifiers changed from: package-private */
    public void z() {
        int i10;
        int i11;
        if (this.E.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1094x.getPaddingLeft();
            Rect rect = new Rect();
            boolean b10 = t1.b(this);
            if (this.W) {
                i10 = resources.getDimensionPixelSize(d.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(d.d.abc_dropdownitem_text_padding_left);
            } else {
                i10 = 0;
            }
            this.f1088t.getDropDownBackground().getPadding(rect);
            if (b10) {
                i11 = -rect.left;
            } else {
                i11 = paddingLeft - (rect.left + i10);
            }
            this.f1088t.setDropDownHorizontalOffset(i11);
            this.f1088t.setDropDownWidth((((this.E.getWidth() + rect.left) + rect.right) + i10) - paddingLeft);
        }
    }

    public SearchView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.G = new Rect();
        this.H = new Rect();
        this.I = new int[2];
        this.J = new int[2];
        this.f1083o0 = new b();
        this.f1084p0 = new c();
        this.f1085q0 = new WeakHashMap<>();
        f fVar = new f();
        this.f1086r0 = fVar;
        this.f1087s0 = new g();
        h hVar = new h();
        this.f1089t0 = hVar;
        i iVar = new i();
        this.f1090u0 = iVar;
        j jVar = new j();
        this.f1091v0 = jVar;
        this.f1093w0 = new a();
        int[] iArr = d.j.SearchView;
        AttributeSet attributeSet2 = attributeSet;
        int i11 = i10;
        h1 v10 = h1.v(context, attributeSet2, iArr, i11, 0);
        n0.q0(this, context, iArr, attributeSet2, v10.r(), i11, 0);
        LayoutInflater.from(context).inflate(v10.n(d.j.SearchView_layout, d.g.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(d.f.search_src_text);
        this.f1088t = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1092w = findViewById(d.f.search_edit_frame);
        View findViewById = findViewById(d.f.search_plate);
        this.f1094x = findViewById;
        View findViewById2 = findViewById(d.f.submit_area);
        this.f1095y = findViewById2;
        ImageView imageView = (ImageView) findViewById(d.f.search_button);
        this.f1096z = imageView;
        ImageView imageView2 = (ImageView) findViewById(d.f.search_go_btn);
        this.B = imageView2;
        ImageView imageView3 = (ImageView) findViewById(d.f.search_close_btn);
        this.C = imageView3;
        ImageView imageView4 = (ImageView) findViewById(d.f.search_voice_btn);
        this.D = imageView4;
        ImageView imageView5 = (ImageView) findViewById(d.f.search_mag_icon);
        this.K = imageView5;
        n0.w0(findViewById, v10.g(d.j.SearchView_queryBackground));
        n0.w0(findViewById2, v10.g(d.j.SearchView_submitBackground));
        int i12 = d.j.SearchView_searchIcon;
        imageView.setImageDrawable(v10.g(i12));
        imageView2.setImageDrawable(v10.g(d.j.SearchView_goIcon));
        imageView3.setImageDrawable(v10.g(d.j.SearchView_closeIcon));
        imageView4.setImageDrawable(v10.g(d.j.SearchView_voiceIcon));
        imageView5.setImageDrawable(v10.g(i12));
        this.L = v10.g(d.j.SearchView_searchHintIcon);
        n1.a(imageView, getResources().getString(d.h.abc_searchview_description_search));
        this.M = v10.n(d.j.SearchView_suggestionRowLayout, d.g.abc_search_dropdown_item_icons_2line);
        this.N = v10.n(d.j.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f1093w0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f1087s0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(v10.a(d.j.SearchView_iconifiedByDefault, true));
        int f10 = v10.f(d.j.SearchView_android_maxWidth, -1);
        if (f10 != -1) {
            setMaxWidth(f10);
        }
        this.Q = v10.p(d.j.SearchView_defaultQueryHint);
        this.f1072d0 = v10.p(d.j.SearchView_queryHint);
        int k10 = v10.k(d.j.SearchView_android_imeOptions, -1);
        if (k10 != -1) {
            setImeOptions(k10);
        }
        int k11 = v10.k(d.j.SearchView_android_inputType, -1);
        if (k11 != -1) {
            setInputType(k11);
        }
        setFocusable(v10.a(d.j.SearchView_android_focusable, true));
        v10.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.O = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.P = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.E = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        i0(this.W);
        e0();
    }
}
