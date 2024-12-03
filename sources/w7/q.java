package w7;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.appyvet.rangebar.RangeBar;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.List;
import r7.g;

public class q extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    RangeBar f18300a;

    /* renamed from: b  reason: collision with root package name */
    RangeBar f18301b;

    /* renamed from: c  reason: collision with root package name */
    RangeBar f18302c;

    /* renamed from: d  reason: collision with root package name */
    TextView f18303d;

    /* renamed from: e  reason: collision with root package name */
    TextView f18304e;

    /* renamed from: f  reason: collision with root package name */
    TextView f18305f;

    /* renamed from: g  reason: collision with root package name */
    CmbTextView f18306g;

    /* renamed from: h  reason: collision with root package name */
    TextView f18307h;

    /* renamed from: j  reason: collision with root package name */
    CheckBox f18308j;

    /* renamed from: k  reason: collision with root package name */
    CmbTextView f18309k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final boolean f18310l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final v7.b f18311m;

    /* renamed from: n  reason: collision with root package name */
    private final List<Resource> f18312n;

    /* renamed from: p  reason: collision with root package name */
    private j f18313p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f18314q;

    /* renamed from: t  reason: collision with root package name */
    private int f18315t;

    /* renamed from: w  reason: collision with root package name */
    private int f18316w;

    /* renamed from: x  reason: collision with root package name */
    private int f18317x;

    /* renamed from: y  reason: collision with root package name */
    private int f18318y;

    class a implements RangeBar.d {
        a() {
        }

        public void a(RangeBar rangeBar, int i10, int i11, String str, String str2) {
            int i12;
            nc.d dVar = new nc.d(q.this.getResources());
            if (q.this.f18310l) {
                i12 = dVar.d(i11);
            } else {
                i12 = dVar.f(i11);
            }
            if (!q.this.f18314q) {
                q.this.f18305f.setText(dVar.a(q.this.f18310l, i12, true));
                q.this.f18311m.j(dVar.d(i11));
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            q.this.f18311m.k();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            q.this.f18311m.u();
        }
    }

    class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            q.this.f18308j.setChecked(z10);
            if (!q.this.f18314q) {
                q.this.f18311m.t(z10);
            }
        }
    }

    class e extends ClickableSpan {
        e() {
        }

        public void onClick(@NonNull View view) {
            q.this.f18311m.b();
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(q.this.getResources().getColor(R.color.dark_gray));
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            q.this.f18302c.setSeekPinByIndex(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public q(Context context, boolean z10, j jVar, v7.b bVar, List<Resource> list) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.discover_search_dls, this, false);
        addView(inflate);
        this.f18310l = z10;
        this.f18313p = jVar;
        this.f18311m = bVar;
        this.f18312n = list;
        setUpLayout(inflate);
    }

    private String getChosenDegreeStrings() {
        if (this.f18312n == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (String next : this.f18313p.d()) {
            for (Resource next2 : this.f18312n) {
                if (next2.getKey().equals(next)) {
                    arrayList.add(next2.getValue());
                }
            }
        }
        return StringUtils.join(arrayList, AppsFlyerKit.COMMA);
    }

    private AnimatorSet i(int i10, int i11, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, int i12, int i13, ValueAnimator.AnimatorUpdateListener animatorUpdateListener2) {
        ValueAnimator l10 = l(i10, i11, animatorUpdateListener);
        ValueAnimator l11 = l(i12, i13, animatorUpdateListener2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{l10, l11});
        animatorSet.setDuration(200);
        return animatorSet;
    }

    private static int j(int i10, int i11, int i12) {
        return (i10 - i12) / i11;
    }

    private static int k(int i10, int i11, int i12) {
        return (i10 * i11) + i12;
    }

    private ValueAnimator l(int i10, int i11, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i10, i11});
        ofInt.setDuration(200);
        ofInt.addUpdateListener(animatorUpdateListener);
        return ofInt;
    }

    private static androidx.core.util.d<ValueAnimator.AnimatorUpdateListener, ValueAnimator.AnimatorUpdateListener> m(RangeBar rangeBar) {
        return new androidx.core.util.d<>(new o(rangeBar), new p(rangeBar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p() {
        this.f18314q = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(RangeBar rangeBar, int i10, int i11, String str, String str2) {
        int parseInt = Integer.parseInt(str);
        int parseInt2 = Integer.parseInt(str2);
        int i12 = this.f18315t;
        if (parseInt < i12 || parseInt2 > this.f18316w) {
            parseInt = Math.max(parseInt, i12);
            parseInt2 = Math.min(parseInt2, this.f18316w);
            this.f18301b.r((float) parseInt, (float) parseInt2);
        }
        if (!this.f18314q) {
            this.f18304e.setText(g.a(getContext(), parseInt, parseInt2));
            this.f18311m.l(parseInt, parseInt2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(RangeBar rangeBar, int i10, int i11, String str, String str2) {
        int parseInt = Integer.parseInt(str);
        int parseInt2 = Integer.parseInt(str2);
        int i12 = this.f18317x;
        if (parseInt < i12 || parseInt2 > this.f18318y) {
            parseInt = Math.max(parseInt, i12);
            parseInt2 = Math.min(parseInt2, this.f18318y);
            this.f18300a.r((float) parseInt, (float) parseInt2);
        }
        if (!this.f18314q) {
            this.f18303d.setText(g.b(getContext(), this.f18310l, parseInt, parseInt2));
            this.f18311m.N(parseInt, parseInt2);
        }
    }

    private void setUpDiscoverSearchInlineText(View view) {
        this.f18309k = (CmbTextView) view.findViewById(R.id.discover_search_note);
        String string = getResources().getString(R.string.discover_search_note);
        SpannableString spannableString = new SpannableString(string);
        StyleSpan styleSpan = new StyleSpan(1);
        e eVar = new e();
        spannableString.setSpan(styleSpan, string.indexOf("Note"), string.indexOf(" Starting"), 17);
        spannableString.setSpan(eVar, string.indexOf("Suggested Preference"), string.length() - 1, 17);
        this.f18309k.setText(spannableString);
        this.f18309k.setHighlightColor(0);
        this.f18309k.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setUpLayout(View view) {
        this.f18305f = (CmbTextView) view.findViewById(R.id.customTextView_my_profile_preference_matchradius_value);
        RangeBar rangeBar = (RangeBar) view.findViewById(R.id.rangebar_distance);
        this.f18302c = rangeBar;
        rangeBar.setOnRangeBarChangeListener(new a());
        this.f18315t = getContext().getResources().getInteger(R.integer.min_age);
        this.f18316w = getContext().getResources().getInteger(R.integer.max_age);
        this.f18304e = (CmbTextView) view.findViewById(R.id.customTextView_my_profile_preference_agerange_value);
        RangeBar rangeBar2 = (RangeBar) view.findViewById(R.id.rangebar_age);
        this.f18301b = rangeBar2;
        rangeBar2.setOnRangeBarChangeListener(new l(this));
        this.f18317x = getContext().getResources().getInteger(R.integer.min_height_centimeters);
        this.f18318y = getContext().getResources().getInteger(R.integer.max_height_centimeters);
        this.f18303d = (CmbTextView) view.findViewById(R.id.textView_height_value);
        RangeBar rangeBar3 = (RangeBar) view.findViewById(R.id.rangebar_height);
        this.f18300a = rangeBar3;
        rangeBar3.setOnRangeBarChangeListener(new m(this));
        CmbTextView cmbTextView = (CmbTextView) view.findViewById(R.id.textView_ethnicity);
        this.f18306g = cmbTextView;
        cmbTextView.setOnClickListener(new b());
        TextView textView = (TextView) view.findViewById(R.id.textView_degree);
        this.f18307h = textView;
        textView.setOnClickListener(new c());
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox_last_active);
        this.f18308j = checkBox;
        checkBox.setOnCheckedChangeListener(new d());
        setUpDiscoverSearchInlineText(view);
        this.f18314q = true;
        y(false);
        this.f18314q = false;
    }

    private void t(boolean z10) {
        int i10;
        int i11;
        if (this.f18313p.b() == null || this.f18313p.c() == null) {
            i11 = j(this.f18315t, (int) this.f18301b.getTickInterval(), (int) this.f18301b.getTickStart());
            i10 = j(this.f18316w, (int) this.f18301b.getTickInterval(), (int) this.f18301b.getTickStart());
            if (!z10) {
                this.f18301b.r((float) this.f18315t, (float) this.f18316w);
            }
            this.f18304e.setText(R.string.no_preference);
        } else {
            int intValue = this.f18313p.b().intValue();
            int intValue2 = this.f18313p.c().intValue();
            i11 = j(intValue, (int) this.f18301b.getTickInterval(), (int) this.f18301b.getTickStart());
            i10 = j(intValue2, (int) this.f18301b.getTickInterval(), (int) this.f18301b.getTickStart());
            if (!z10) {
                this.f18301b.r((float) intValue, (float) intValue2);
            }
            this.f18304e.setText(g.a(getContext(), intValue, intValue2));
        }
        int i12 = i11;
        int i13 = i10;
        if (z10) {
            int leftIndex = this.f18301b.getLeftIndex();
            int rightIndex = this.f18301b.getRightIndex();
            androidx.core.util.d<ValueAnimator.AnimatorUpdateListener, ValueAnimator.AnimatorUpdateListener> m10 = m(this.f18301b);
            i(leftIndex, i12, (ValueAnimator.AnimatorUpdateListener) m10.f4735a, rightIndex, i13, (ValueAnimator.AnimatorUpdateListener) m10.f4736b).start();
        }
    }

    private void v(boolean z10) {
        int i10;
        nc.d dVar = new nc.d(getResources());
        if (this.f18313p.h() == null) {
            i10 = dVar.e();
            if (!z10) {
                this.f18302c.setSeekPinByIndex(i10);
            }
            this.f18305f.setText(R.string.no_preference);
        } else {
            int intValue = this.f18313p.h().intValue();
            int c10 = dVar.c(intValue, true);
            if (!z10) {
                this.f18302c.setSeekPinByIndex(c10);
            }
            this.f18305f.setText(dVar.a(this.f18310l, intValue, true));
            i10 = c10;
        }
        if (z10) {
            l(this.f18302c.getRightIndex(), i10, new f()).start();
        }
    }

    private void x(boolean z10) {
        int i10;
        int i11;
        if (this.f18313p.f() == null || this.f18313p.g() == null) {
            i11 = j(this.f18317x, (int) this.f18300a.getTickInterval(), (int) this.f18300a.getTickStart());
            i10 = j(this.f18318y, (int) this.f18300a.getTickInterval(), (int) this.f18300a.getTickStart());
            this.f18300a.r((float) this.f18317x, (float) this.f18318y);
            this.f18303d.setText(R.string.no_preference);
        } else {
            int intValue = this.f18313p.f().intValue();
            int intValue2 = this.f18313p.g().intValue();
            i11 = j(intValue, (int) this.f18300a.getTickInterval(), (int) this.f18300a.getTickStart());
            i10 = j(intValue2, (int) this.f18300a.getTickInterval(), (int) this.f18300a.getTickStart());
            this.f18300a.r((float) intValue, (float) intValue2);
            this.f18303d.setText(g.b(getContext(), this.f18310l, intValue, intValue2));
        }
        int i12 = i11;
        int i13 = i10;
        if (z10) {
            int leftIndex = this.f18300a.getLeftIndex();
            int rightIndex = this.f18300a.getRightIndex();
            androidx.core.util.d<ValueAnimator.AnimatorUpdateListener, ValueAnimator.AnimatorUpdateListener> m10 = m(this.f18300a);
            i(leftIndex, i12, (ValueAnimator.AnimatorUpdateListener) m10.f4735a, rightIndex, i13, (ValueAnimator.AnimatorUpdateListener) m10.f4736b).start();
        }
    }

    private void y(boolean z10) {
        v(z10);
        t(z10);
        x(z10);
        w();
        u();
        z();
    }

    private void z() {
        if (this.f18313p.i() == null) {
            this.f18308j.setChecked(false);
        } else {
            this.f18308j.setChecked(this.f18313p.i().booleanValue());
        }
    }

    public void s(j jVar, boolean z10) {
        this.f18313p = jVar;
        this.f18314q = true;
        y(z10);
        if (z10) {
            postDelayed(new n(this), 250);
        } else {
            this.f18314q = false;
        }
    }

    public void u() {
        String str;
        if (this.f18313p.d() == null) {
            str = getContext().getString(R.string.no_preference);
        } else {
            str = getChosenDegreeStrings();
        }
        this.f18307h.setText(str);
    }

    public void w() {
        if (this.f18313p.e() == null || this.f18313p.e().isEmpty()) {
            this.f18306g.setText(R.string.no_preference);
            return;
        }
        this.f18306g.setText(g.c(getContext(), this.f18313p.e()));
    }
}
