package l9;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.entities.GenderType;

public class d extends Dialog implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16242a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f16243b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16244c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f16245d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f16246e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f16247f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f16248g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f16249h;

    /* renamed from: j  reason: collision with root package name */
    private ImageView f16250j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ImageView f16251k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f16252l;

    /* renamed from: m  reason: collision with root package name */
    private CmbTextView f16253m;

    /* renamed from: n  reason: collision with root package name */
    private FrameLayout f16254n;

    /* renamed from: p  reason: collision with root package name */
    private FrameLayout f16255p;

    /* renamed from: q  reason: collision with root package name */
    private final a f16256q;

    /* renamed from: t  reason: collision with root package name */
    private int f16257t;

    /* renamed from: w  reason: collision with root package name */
    private GenderType f16258w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f16259x = true;

    /* renamed from: y  reason: collision with root package name */
    private final Boolean f16260y;

    class a implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f16261a;

        a(a aVar) {
            this.f16261a = aVar;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f16261a.a(d.this.f16259x);
            d.this.f16243b.stop();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            d.this.f16243b.a();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            d.this.dismiss();
        }
    }

    /* renamed from: l9.d$d  reason: collision with other inner class name */
    class C0170d implements View.OnClickListener {
        C0170d() {
        }

        public void onClick(View view) {
            d.this.f16243b.d(d.this.f16249h);
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            d.this.f16243b.c();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            d.this.f16243b.e();
        }
    }

    class g implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f16268a;

        g(int i10) {
            this.f16268a = i10;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            d.this.f16251k.setImageResource(d.this.i(this.f16268a));
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, int i10, GenderType genderType, a aVar, Boolean bool, int i11) {
        super(context);
        a aVar2 = aVar;
        Context context2 = context;
        this.f16242a = context2;
        int i12 = i10;
        this.f16257t = i12;
        GenderType genderType2 = genderType;
        this.f16258w = genderType2;
        this.f16256q = aVar2;
        this.f16260y = bool;
        setOnDismissListener(new a(aVar2));
        j();
        f fVar = new f(this, i12, genderType2, context2, Bakery.w().C(), aVar2, Bakery.w().z(), Bakery.w().H(), i11);
        this.f16243b = fVar;
        fVar.start();
    }

    /* access modifiers changed from: private */
    public int i(int i10) {
        String str;
        int min = Math.min(i10, 12);
        if (min < 10) {
            str = "0" + min;
        } else {
            str = String.valueOf(min);
        }
        return this.f16242a.getResources().getIdentifier("woo_flower_dls" + str, "drawable", this.f16242a.getPackageName());
    }

    private void j() {
        getWindow().requestFeature(1);
        setContentView(R.layout.skip_the_line_dialog_dls);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        getWindow().setAttributes(layoutParams);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f16244c = (TextView) findViewById(R.id.title);
        this.f16245d = (TextView) findViewById(R.id.content);
        this.f16248g = (LinearLayout) findViewById(R.id.buy_button);
        this.f16246e = (TextView) findViewById(R.id.cost);
        this.f16247f = (TextView) findViewById(R.id.dismiss_button);
        this.f16250j = (ImageView) findViewById(R.id.bean_icon);
        this.f16251k = (ImageView) findViewById(R.id.flowers);
        this.f16252l = (ImageView) findViewById(R.id.flowers_next);
        this.f16254n = (FrameLayout) findViewById(R.id.add_flower);
        this.f16255p = (FrameLayout) findViewById(R.id.subtract_flower);
        this.f16253m = (CmbTextView) findViewById(R.id.subscription_cta);
        if (!this.f16260y.booleanValue()) {
            this.f16253m.setVisibility(0);
            this.f16253m.setOnClickListener(new b());
        } else {
            this.f16253m.setVisibility(8);
        }
        this.f16247f.setOnClickListener(new c());
        this.f16248g.setOnClickListener(new C0170d());
        this.f16254n.setOnClickListener(new e());
        this.f16255p.setOnClickListener(new f());
    }

    public void a(int i10) {
        if (i10 > 0 && i10 <= 12) {
            this.f16252l.setAlpha(0.0f);
            this.f16252l.setImageResource(i(i10));
            this.f16252l.animate().alpha(1.0f).setDuration(200).setListener(new g(i10));
        }
    }

    public void b(int i10) {
        this.f16249h = i10;
        if (i10 == 0) {
            this.f16246e.setText(this.f16242a.getResources().getString(R.string.free_caps));
            this.f16250j.setVisibility(8);
            return;
        }
        this.f16246e.setText(Integer.toString(i10));
        this.f16250j.setVisibility(0);
    }

    public void c(String str) {
        this.f16245d.setText(str);
    }

    public void k(Boolean bool) {
        if (bool.booleanValue()) {
            this.f16243b.b();
        }
        this.f16259x = false;
        dismiss();
    }
}
