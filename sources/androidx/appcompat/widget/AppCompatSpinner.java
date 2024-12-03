package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.p;
import androidx.core.view.n0;

public class AppCompatSpinner extends Spinner {
    @SuppressLint({"ResourceType"})

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f1016j = {16843505};

    /* renamed from: a  reason: collision with root package name */
    private final d f1017a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1018b;

    /* renamed from: c  reason: collision with root package name */
    private o0 f1019c;

    /* renamed from: d  reason: collision with root package name */
    private SpinnerAdapter f1020d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1021e;

    /* renamed from: f  reason: collision with root package name */
    private i f1022f;

    /* renamed from: g  reason: collision with root package name */
    int f1023g;

    /* renamed from: h  reason: collision with root package name */
    final Rect f1024h;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f1025a;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f1025a ? (byte) 1 : 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1025a = parcel.readByte() != 0;
        }
    }

    class a extends o0 {

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ h f1026k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(View view, h hVar) {
            super(view);
            this.f1026k = hVar;
        }

        public p b() {
            return this.f1026k;
        }

        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().b()) {
                return true;
            }
            AppCompatSpinner.this.b();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().b()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                c.a(viewTreeObserver, this);
            }
        }
    }

    private static final class c {
        static void a(@NonNull ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    private static final class d {
        static int a(@NonNull View view) {
            return view.getTextAlignment();
        }

        static int b(@NonNull View view) {
            return view.getTextDirection();
        }

        static void c(@NonNull View view, int i10) {
            view.setTextAlignment(i10);
        }

        static void d(@NonNull View view, int i10) {
            view.setTextDirection(i10);
        }
    }

    private static final class e {
        static void a(@NonNull ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (!androidx.core.util.c.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    class f implements i, DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.app.b f1029a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f1030b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f1031c;

        f() {
        }

        public boolean b() {
            androidx.appcompat.app.b bVar = this.f1029a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        public void c(Drawable drawable) {
        }

        public int d() {
            return 0;
        }

        public void dismiss() {
            androidx.appcompat.app.b bVar = this.f1029a;
            if (bVar != null) {
                bVar.dismiss();
                this.f1029a = null;
            }
        }

        public void f(int i10) {
        }

        public CharSequence g() {
            return this.f1031c;
        }

        public Drawable h() {
            return null;
        }

        public void i(CharSequence charSequence) {
            this.f1031c = charSequence;
        }

        public void j(int i10) {
        }

        public void k(int i10) {
        }

        public void l(int i10, int i11) {
            if (this.f1030b != null) {
                b.a aVar = new b.a(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f1031c;
                if (charSequence != null) {
                    aVar.k(charSequence);
                }
                androidx.appcompat.app.b a10 = aVar.j(this.f1030b, AppCompatSpinner.this.getSelectedItemPosition(), this).a();
                this.f1029a = a10;
                ListView j10 = a10.j();
                d.d(j10, i10);
                d.c(j10, i11);
                this.f1029a.show();
            }
        }

        public int m() {
            return 0;
        }

        public void n(ListAdapter listAdapter) {
            this.f1030b = listAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner.this.setSelection(i10);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i10, this.f1030b.getItemId(i10));
            }
            dismiss();
        }
    }

    private static class g implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f1033a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f1034b;

        public g(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1033a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1034b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                e.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            } else if (spinnerAdapter instanceof d1) {
                d1 d1Var = (d1) spinnerAdapter;
                if (d1Var.getDropDownViewTheme() == null) {
                    d1Var.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1034b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1033a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1033a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1033a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1033a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i10);
        }

        public int getItemViewType(int i10) {
            return 0;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1033a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f1034b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1033a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1033a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class h extends p0 implements i {
        private CharSequence P;
        ListAdapter Q;
        private final Rect R = new Rect();
        private int S;

        class a implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AppCompatSpinner f1035a;

            a(AppCompatSpinner appCompatSpinner) {
                this.f1035a = appCompatSpinner;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                AppCompatSpinner.this.setSelection(i10);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    h hVar = h.this;
                    AppCompatSpinner.this.performItemClick(view, i10, hVar.Q.getItemId(i10));
                }
                h.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            public void onGlobalLayout() {
                h hVar = h.this;
                if (!hVar.V(AppCompatSpinner.this)) {
                    h.this.dismiss();
                    return;
                }
                h.this.T();
                h.super.a();
            }
        }

        class c implements PopupWindow.OnDismissListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1038a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1038a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1038a);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            D(AppCompatSpinner.this);
            J(true);
            P(0);
            L(new a(AppCompatSpinner.this));
        }

        /* access modifiers changed from: package-private */
        public void T() {
            int i10;
            int i11;
            Drawable h10 = h();
            int i12 = 0;
            if (h10 != null) {
                h10.getPadding(AppCompatSpinner.this.f1024h);
                if (t1.b(AppCompatSpinner.this)) {
                    i11 = AppCompatSpinner.this.f1024h.right;
                } else {
                    i11 = -AppCompatSpinner.this.f1024h.left;
                }
                i12 = i11;
            } else {
                Rect rect = AppCompatSpinner.this.f1024h;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i13 = appCompatSpinner.f1023g;
            if (i13 == -2) {
                int a10 = appCompatSpinner.a((SpinnerAdapter) this.Q, h());
                int i14 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f1024h;
                int i15 = (i14 - rect2.left) - rect2.right;
                if (a10 > i15) {
                    a10 = i15;
                }
                F(Math.max(a10, (width - paddingLeft) - paddingRight));
            } else if (i13 == -1) {
                F((width - paddingLeft) - paddingRight);
            } else {
                F(i13);
            }
            if (t1.b(AppCompatSpinner.this)) {
                i10 = i12 + (((width - paddingRight) - z()) - U());
            } else {
                i10 = i12 + paddingLeft + U();
            }
            f(i10);
        }

        public int U() {
            return this.S;
        }

        /* access modifiers changed from: package-private */
        public boolean V(View view) {
            return n0.V(view) && view.getGlobalVisibleRect(this.R);
        }

        public CharSequence g() {
            return this.P;
        }

        public void i(CharSequence charSequence) {
            this.P = charSequence;
        }

        public void k(int i10) {
            this.S = i10;
        }

        public void l(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean b10 = b();
            T();
            I(2);
            super.a();
            ListView p10 = p();
            p10.setChoiceMode(1);
            d.d(p10, i10);
            d.c(p10, i11);
            Q(AppCompatSpinner.this.getSelectedItemPosition());
            if (!b10 && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                K(new c(bVar));
            }
        }

        public void n(ListAdapter listAdapter) {
            super.n(listAdapter);
            this.Q = listAdapter;
        }
    }

    interface i {
        boolean b();

        void c(Drawable drawable);

        int d();

        void dismiss();

        void f(int i10);

        CharSequence g();

        Drawable h();

        void i(CharSequence charSequence);

        void j(int i10);

        void k(int i10);

        void l(int i10, int i11);

        int m();

        void n(ListAdapter listAdapter);
    }

    public AppCompatSpinner(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.spinnerStyle);
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i11;
        }
        drawable.getPadding(this.f1024h);
        Rect rect = this.f1024h;
        return i11 + rect.left + rect.right;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f1022f.l(d.b(this), d.a(this));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1017a;
        if (dVar != null) {
            dVar.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        i iVar = this.f1022f;
        if (iVar != null) {
            return iVar.d();
        }
        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        i iVar = this.f1022f;
        if (iVar != null) {
            return iVar.m();
        }
        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if (this.f1022f != null) {
            return this.f1023g;
        }
        return super.getDropDownWidth();
    }

    /* access modifiers changed from: package-private */
    public final i getInternalPopup() {
        return this.f1022f;
    }

    public Drawable getPopupBackground() {
        i iVar = this.f1022f;
        if (iVar != null) {
            return iVar.h();
        }
        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.f1018b;
    }

    public CharSequence getPrompt() {
        i iVar = this.f1022f;
        return iVar != null ? iVar.g() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1017a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1017a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.f1022f;
        if (iVar != null && iVar.b()) {
            this.f1022f.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f1022f != null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1025a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    public Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        i iVar = this.f1022f;
        if (iVar == null || !iVar.b()) {
            z10 = false;
        } else {
            z10 = true;
        }
        savedState.f1025a = z10;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        o0 o0Var = this.f1019c;
        if (o0Var == null || !o0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        i iVar = this.f1022f;
        if (iVar == null) {
            return super.performClick();
        }
        if (iVar.b()) {
            return true;
        }
        b();
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1017a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1017a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setDropDownHorizontalOffset(int i10) {
        i iVar = this.f1022f;
        if (iVar != null) {
            iVar.k(i10);
            this.f1022f.f(i10);
            return;
        }
        super.setDropDownHorizontalOffset(i10);
    }

    public void setDropDownVerticalOffset(int i10) {
        i iVar = this.f1022f;
        if (iVar != null) {
            iVar.j(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    public void setDropDownWidth(int i10) {
        if (this.f1022f != null) {
            this.f1023g = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        i iVar = this.f1022f;
        if (iVar != null) {
            iVar.c(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(e.a.b(getPopupContext(), i10));
    }

    public void setPrompt(CharSequence charSequence) {
        i iVar = this.f1022f;
        if (iVar != null) {
            iVar.i(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1017a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1017a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public AppCompatSpinner(@NonNull Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1021e) {
            this.f1020d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1022f != null) {
            Context context = this.f1018b;
            if (context == null) {
                context = getContext();
            }
            this.f1022f.n(new g(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r10 != null) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context r6, android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) {
        /*
            r5 = this;
            r5.<init>(r6, r7, r8)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.f1024h = r0
            android.content.Context r0 = r5.getContext()
            androidx.appcompat.widget.c1.a(r5, r0)
            int[] r0 = d.j.Spinner
            r1 = 0
            androidx.appcompat.widget.h1 r0 = androidx.appcompat.widget.h1.v(r6, r7, r0, r8, r1)
            androidx.appcompat.widget.d r2 = new androidx.appcompat.widget.d
            r2.<init>(r5)
            r5.f1017a = r2
            if (r10 == 0) goto L_0x0029
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>((android.content.Context) r6, (android.content.res.Resources.Theme) r10)
            r5.f1018b = r2
            goto L_0x003b
        L_0x0029:
            int r10 = d.j.Spinner_popupTheme
            int r10 = r0.n(r10, r1)
            if (r10 == 0) goto L_0x0039
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>((android.content.Context) r6, (int) r10)
            r5.f1018b = r2
            goto L_0x003b
        L_0x0039:
            r5.f1018b = r6
        L_0x003b:
            r10 = -1
            r2 = 0
            if (r9 != r10) goto L_0x0061
            int[] r10 = f1016j     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            android.content.res.TypedArray r10 = r6.obtainStyledAttributes(r7, r10, r8, r1)     // Catch:{ Exception -> 0x005d, all -> 0x0056 }
            boolean r3 = r10.hasValue(r1)     // Catch:{ Exception -> 0x005e, all -> 0x0053 }
            if (r3 == 0) goto L_0x004f
            int r9 = r10.getInt(r1, r1)     // Catch:{ Exception -> 0x005e, all -> 0x0053 }
        L_0x004f:
            r10.recycle()
            goto L_0x0061
        L_0x0053:
            r6 = move-exception
            r2 = r10
            goto L_0x0057
        L_0x0056:
            r6 = move-exception
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.recycle()
        L_0x005c:
            throw r6
        L_0x005d:
            r10 = r2
        L_0x005e:
            if (r10 == 0) goto L_0x0061
            goto L_0x004f
        L_0x0061:
            r10 = 1
            if (r9 == 0) goto L_0x009e
            if (r9 == r10) goto L_0x0067
            goto L_0x00ae
        L_0x0067:
            androidx.appcompat.widget.AppCompatSpinner$h r9 = new androidx.appcompat.widget.AppCompatSpinner$h
            android.content.Context r3 = r5.f1018b
            r9.<init>(r3, r7, r8)
            android.content.Context r3 = r5.f1018b
            int[] r4 = d.j.Spinner
            androidx.appcompat.widget.h1 r1 = androidx.appcompat.widget.h1.v(r3, r7, r4, r8, r1)
            int r3 = d.j.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.m(r3, r4)
            r5.f1023g = r3
            int r3 = d.j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.g(r3)
            r9.c(r3)
            int r3 = d.j.Spinner_android_prompt
            java.lang.String r3 = r0.o(r3)
            r9.i(r3)
            r1.w()
            r5.f1022f = r9
            androidx.appcompat.widget.AppCompatSpinner$a r1 = new androidx.appcompat.widget.AppCompatSpinner$a
            r1.<init>(r5, r9)
            r5.f1019c = r1
            goto L_0x00ae
        L_0x009e:
            androidx.appcompat.widget.AppCompatSpinner$f r9 = new androidx.appcompat.widget.AppCompatSpinner$f
            r9.<init>()
            r5.f1022f = r9
            int r1 = d.j.Spinner_android_prompt
            java.lang.String r1 = r0.o(r1)
            r9.i(r1)
        L_0x00ae:
            int r9 = d.j.Spinner_android_entries
            java.lang.CharSequence[] r9 = r0.q(r9)
            if (r9 == 0) goto L_0x00c6
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r6, r3, r9)
            int r6 = d.g.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r6)
            r5.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00c6:
            r0.w()
            r5.f1021e = r10
            android.widget.SpinnerAdapter r6 = r5.f1020d
            if (r6 == 0) goto L_0x00d4
            r5.setAdapter((android.widget.SpinnerAdapter) r6)
            r5.f1020d = r2
        L_0x00d4:
            androidx.appcompat.widget.d r6 = r5.f1017a
            r6.e(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
