package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.n0;
import androidx.core.widget.NestedScrollView;
import d.f;
import d.j;
import java.lang.ref.WeakReference;
import net.bytebuddy.jar.asm.Opcodes;

class AlertController {
    NestedScrollView A;
    private int B = 0;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I = -1;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q = 0;
    Handler R;
    private final View.OnClickListener S = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f392a;

    /* renamed from: b  reason: collision with root package name */
    final i f393b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f394c;

    /* renamed from: d  reason: collision with root package name */
    private final int f395d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f396e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f397f;

    /* renamed from: g  reason: collision with root package name */
    ListView f398g;

    /* renamed from: h  reason: collision with root package name */
    private View f399h;

    /* renamed from: i  reason: collision with root package name */
    private int f400i;

    /* renamed from: j  reason: collision with root package name */
    private int f401j;

    /* renamed from: k  reason: collision with root package name */
    private int f402k;

    /* renamed from: l  reason: collision with root package name */
    private int f403l;

    /* renamed from: m  reason: collision with root package name */
    private int f404m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f405n = false;

    /* renamed from: o  reason: collision with root package name */
    Button f406o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f407p;

    /* renamed from: q  reason: collision with root package name */
    Message f408q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f409r;

    /* renamed from: s  reason: collision with root package name */
    Button f410s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f411t;

    /* renamed from: u  reason: collision with root package name */
    Message f412u;

    /* renamed from: v  reason: collision with root package name */
    private Drawable f413v;

    /* renamed from: w  reason: collision with root package name */
    Button f414w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f415x;

    /* renamed from: y  reason: collision with root package name */
    Message f416y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f417z;

    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        private final int f418a;

        /* renamed from: b  reason: collision with root package name */
        private final int f419b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RecycleListView);
            this.f419b = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.f418a = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z10, boolean z11) {
            int i10;
            int i11;
            if (!z11 || !z10) {
                int paddingLeft = getPaddingLeft();
                if (z10) {
                    i10 = getPaddingTop();
                } else {
                    i10 = this.f418a;
                }
                int paddingRight = getPaddingRight();
                if (z11) {
                    i11 = getPaddingBottom();
                } else {
                    i11 = this.f419b;
                }
                setPadding(paddingLeft, i10, paddingRight, i11);
            }
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f406o && (message4 = alertController.f408q) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f410s && (message3 = alertController.f412u) != null) {
                message = Message.obtain(message3);
            } else if (view != alertController.f414w || (message2 = alertController.f416y) == null) {
                message = null;
            } else {
                message = Message.obtain(message2);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f393b).sendToTarget();
        }
    }

    public static class b {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;
        public boolean P = true;

        /* renamed from: a  reason: collision with root package name */
        public final Context f421a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f422b;

        /* renamed from: c  reason: collision with root package name */
        public int f423c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f424d;

        /* renamed from: e  reason: collision with root package name */
        public int f425e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f426f;

        /* renamed from: g  reason: collision with root package name */
        public View f427g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f428h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f429i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f430j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f431k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f432l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f433m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f434n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f435o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f436p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f437q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f438r;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f439s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f440t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f441u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f442v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f443w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f444x;

        /* renamed from: y  reason: collision with root package name */
        public int f445y;

        /* renamed from: z  reason: collision with root package name */
        public View f446z;

        class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecycleListView f447a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f447a = recycleListView;
            }

            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = b.this.F;
                if (zArr != null && zArr[i10]) {
                    this.f447a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$b$b  reason: collision with other inner class name */
        class C0011b extends CursorAdapter {

            /* renamed from: a  reason: collision with root package name */
            private final int f449a;

            /* renamed from: b  reason: collision with root package name */
            private final int f450b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ RecycleListView f451c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ AlertController f452d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0011b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f451c = recycleListView;
                this.f452d = alertController;
                Cursor cursor2 = getCursor();
                this.f449a = cursor2.getColumnIndexOrThrow(b.this.L);
                this.f450b = cursor2.getColumnIndexOrThrow(b.this.M);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f449a));
                RecycleListView recycleListView = this.f451c;
                int position = cursor.getPosition();
                boolean z10 = true;
                if (cursor.getInt(this.f450b) != 1) {
                    z10 = false;
                }
                recycleListView.setItemChecked(position, z10);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return b.this.f422b.inflate(this.f452d.M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AlertController f454a;

            c(AlertController alertController) {
                this.f454a = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                b.this.f444x.onClick(this.f454a.f393b, i10);
                if (!b.this.H) {
                    this.f454a.f393b.dismiss();
                }
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecycleListView f456a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AlertController f457b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f456a = recycleListView;
                this.f457b = alertController;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                boolean[] zArr = b.this.F;
                if (zArr != null) {
                    zArr[i10] = this.f456a.isItemChecked(i10);
                }
                b.this.J.onClick(this.f457b.f393b, i10, this.f456a.isItemChecked(i10));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public b(Context context) {
            this.f421a = context;
            this.f438r = true;
            this.f422b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v23, types: [androidx.appcompat.app.AlertController$b$b] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$b$a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f422b
                int r1 = r11.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.G
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.K
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$b$a r9 = new androidx.appcompat.app.AlertController$b$a
                android.content.Context r3 = r10.f421a
                int r4 = r11.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f442v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0026:
                androidx.appcompat.app.AlertController$b$b r9 = new androidx.appcompat.app.AlertController$b$b
                android.content.Context r3 = r10.f421a
                android.database.Cursor r4 = r10.K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0035:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x003c
                int r1 = r11.N
                goto L_0x003e
            L_0x003c:
                int r1 = r11.O
            L_0x003e:
                r4 = r1
                android.database.Cursor r1 = r10.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f421a
                android.database.Cursor r5 = r10.K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.L
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x005d:
                android.widget.ListAdapter r9 = r10.f443w
                if (r9 == 0) goto L_0x0062
                goto L_0x006b
            L_0x0062:
                androidx.appcompat.app.AlertController$d r9 = new androidx.appcompat.app.AlertController$d
                android.content.Context r1 = r10.f421a
                java.lang.CharSequence[] r3 = r10.f442v
                r9.<init>(r1, r4, r2, r3)
            L_0x006b:
                androidx.appcompat.app.AlertController$b$e r1 = r10.O
                if (r1 == 0) goto L_0x0072
                r1.a(r0)
            L_0x0072:
                r11.H = r9
                int r1 = r10.I
                r11.I = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f444x
                if (r1 == 0) goto L_0x0085
                androidx.appcompat.app.AlertController$b$c r1 = new androidx.appcompat.app.AlertController$b$c
                r1.<init>(r11)
                r0.setOnItemClickListener(r1)
                goto L_0x0091
            L_0x0085:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.J
                if (r1 == 0) goto L_0x0091
                androidx.appcompat.app.AlertController$b$d r1 = new androidx.appcompat.app.AlertController$b$d
                r1.<init>(r0, r11)
                r0.setOnItemClickListener(r1)
            L_0x0091:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.N
                if (r1 == 0) goto L_0x0098
                r0.setOnItemSelectedListener(r1)
            L_0x0098:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x00a0
                r0.setChoiceMode(r8)
                goto L_0x00a8
            L_0x00a0:
                boolean r1 = r10.G
                if (r1 == 0) goto L_0x00a8
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a8:
                r11.f398g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.b.b(androidx.appcompat.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            View view = this.f427g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f426f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f424d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i10 = this.f423c;
                if (i10 != 0) {
                    alertController.m(i10);
                }
                int i11 = this.f425e;
                if (i11 != 0) {
                    alertController.m(alertController.d(i11));
                }
            }
            CharSequence charSequence2 = this.f428h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f429i;
            if (!(charSequence3 == null && this.f430j == null)) {
                alertController.k(-1, charSequence3, this.f431k, (Message) null, this.f430j);
            }
            CharSequence charSequence4 = this.f432l;
            if (!(charSequence4 == null && this.f433m == null)) {
                alertController.k(-2, charSequence4, this.f434n, (Message) null, this.f433m);
            }
            CharSequence charSequence5 = this.f435o;
            if (!(charSequence5 == null && this.f436p == null)) {
                alertController.k(-3, charSequence5, this.f437q, (Message) null, this.f436p);
            }
            if (!(this.f442v == null && this.K == null && this.f443w == null)) {
                b(alertController);
            }
            View view2 = this.f446z;
            if (view2 == null) {
                int i12 = this.f445y;
                if (i12 != 0) {
                    alertController.r(i12);
                }
            } else if (this.E) {
                alertController.t(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.s(view2);
            }
        }
    }

    private static final class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f459a;

        public c(DialogInterface dialogInterface) {
            this.f459a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f459a.get(), message.what);
            } else if (i10 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, i iVar, Window window) {
        this.f392a = context;
        this.f393b = iVar;
        this.f394c = window;
        this.R = new c(iVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, j.AlertDialog, d.a.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(j.AlertDialog_showTitle, true);
        this.f395d = obtainStyledAttributes.getDimensionPixelSize(j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        iVar.h(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i10 = this.K;
        if (i10 == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i10;
        }
        return this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i10, int i11) {
        View findViewById = this.f394c.findViewById(f.scrollIndicatorUp);
        View findViewById2 = this.f394c.findViewById(f.scrollIndicatorDown);
        n0.L0(view, i10, i11);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void u(ViewGroup viewGroup) {
        boolean z10;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f406o = button;
        button.setOnClickListener(this.S);
        boolean z11 = true;
        if (!TextUtils.isEmpty(this.f407p) || this.f409r != null) {
            this.f406o.setText(this.f407p);
            Drawable drawable = this.f409r;
            if (drawable != null) {
                int i10 = this.f395d;
                drawable.setBounds(0, 0, i10, i10);
                this.f406o.setCompoundDrawables(this.f409r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f406o.setVisibility(0);
            z10 = true;
        } else {
            this.f406o.setVisibility(8);
            z10 = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f410s = button2;
        button2.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f411t) || this.f413v != null) {
            this.f410s.setText(this.f411t);
            Drawable drawable2 = this.f413v;
            if (drawable2 != null) {
                int i11 = this.f395d;
                drawable2.setBounds(0, 0, i11, i11);
                this.f410s.setCompoundDrawables(this.f413v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f410s.setVisibility(0);
            z10 |= true;
        } else {
            this.f410s.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f414w = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f415x) || this.f417z != null) {
            this.f414w.setText(this.f415x);
            Drawable drawable3 = this.f417z;
            if (drawable3 != null) {
                int i12 = this.f395d;
                drawable3.setBounds(0, 0, i12, i12);
                this.f414w.setCompoundDrawables(this.f417z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f414w.setVisibility(0);
            z10 |= true;
        } else {
            this.f414w.setVisibility(8);
        }
        if (z(this.f392a)) {
            if (z10) {
                b(this.f406o);
            } else if (z10) {
                b(this.f410s);
            } else if (z10) {
                b(this.f414w);
            }
        }
        if (!z10) {
            z11 = false;
        }
        if (!z11) {
            viewGroup.setVisibility(8);
        }
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f394c.findViewById(f.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f397f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f398g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f398g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f399h;
        boolean z10 = false;
        if (view == null) {
            if (this.f400i != 0) {
                view = LayoutInflater.from(this.f392a).inflate(this.f400i, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z10 = true;
        }
        if (!z10 || !a(view)) {
            this.f394c.setFlags(Opcodes.ACC_DEPRECATED, Opcodes.ACC_DEPRECATED);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) this.f394c.findViewById(f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f405n) {
                frameLayout.setPadding(this.f401j, this.f402k, this.f403l, this.f404m);
            }
            if (this.f398g != null) {
                ((LinearLayoutCompat.a) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f394c.findViewById(f.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f394c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f396e)) || !this.P) {
            this.f394c.findViewById(f.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f394c.findViewById(f.alertTitle);
        this.E = textView;
        textView.setText(this.f396e);
        int i10 = this.B;
        if (i10 != 0) {
            this.D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            return;
        }
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }

    private void y() {
        boolean z10;
        boolean z11;
        boolean z12;
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f394c.findViewById(f.parentPanel);
        int i10 = f.topPanel;
        View findViewById4 = findViewById3.findViewById(i10);
        int i11 = f.contentPanel;
        View findViewById5 = findViewById3.findViewById(i11);
        int i12 = f.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(f.customPanel);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(i10);
        View findViewById8 = viewGroup.findViewById(i11);
        View findViewById9 = viewGroup.findViewById(i12);
        ViewGroup i13 = i(findViewById7, findViewById4);
        ViewGroup i14 = i(findViewById8, findViewById5);
        ViewGroup i15 = i(findViewById9, findViewById6);
        v(i14);
        u(i15);
        x(i13);
        char c10 = 0;
        if (viewGroup.getVisibility() != 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i13 == null || i13.getVisibility() == 8) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i15 == null || i15.getVisibility() == 8) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!(z12 || i14 == null || (findViewById2 = i14.findViewById(f.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z11) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f397f == null && this.f398g == null)) {
                view = i13.findViewById(f.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(i14 == null || (findViewById = i14.findViewById(f.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f398g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z11, z12);
        }
        if (!z10) {
            View view2 = this.f398g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z12) {
                    c10 = 2;
                }
                p(i14, view2, z11 | c10 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f398g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i16 = this.I;
            if (i16 > -1) {
                listView2.setItemChecked(i16, true);
                listView2.setSelection(i16);
            }
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.a.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public Button c(int i10) {
        if (i10 == -3) {
            return this.f414w;
        }
        if (i10 == -2) {
            return this.f410s;
        }
        if (i10 != -1) {
            return null;
        }
        return this.f406o;
    }

    public int d(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f392a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f398g;
    }

    public void f() {
        this.f393b.setContentView(j());
        y();
    }

    public boolean g(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public void k(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f415x = charSequence;
            this.f416y = message;
            this.f417z = drawable;
        } else if (i10 == -2) {
            this.f411t = charSequence;
            this.f412u = message;
            this.f413v = drawable;
        } else if (i10 == -1) {
            this.f407p = charSequence;
            this.f408q = message;
            this.f409r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i10) {
        this.C = null;
        this.B = i10;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i10 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void o(CharSequence charSequence) {
        this.f397f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f396e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i10) {
        this.f399h = null;
        this.f400i = i10;
        this.f405n = false;
    }

    public void s(View view) {
        this.f399h = view;
        this.f400i = 0;
        this.f405n = false;
    }

    public void t(View view, int i10, int i11, int i12, int i13) {
        this.f399h = view;
        this.f400i = 0;
        this.f405n = true;
        this.f401j = i10;
        this.f402k = i11;
        this.f403l = i12;
        this.f404m = i13;
    }
}
