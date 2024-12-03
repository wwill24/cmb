package a8;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.f;
import androidx.viewpager.widget.ViewPager;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.feature.comment_on_like.RisingCommentView;
import com.coffeemeetsbagel.feature.mediaitemtype.MediaItemViewPager;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import java.util.ArrayList;
import java.util.List;

public class h extends FrameLayout implements z7.c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final MediaItemViewPager f170a = ((MediaItemViewPager) findViewById(R.id.media_view_pager));
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final TextView f171b = ((TextView) findViewById(R.id.text_photo_indicator));

    /* renamed from: c  reason: collision with root package name */
    private final TextView f172c = ((TextView) findViewById(R.id.profile_bottom_text));

    /* renamed from: d  reason: collision with root package name */
    protected final ImageButton f173d = ((ImageButton) findViewById(R.id.like_button));
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final TextView f174e = ((TextView) findViewById(R.id.like_overlay));

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f175f = ((LinearLayout) findViewById(R.id.profile_name_age_location_container));

    /* renamed from: g  reason: collision with root package name */
    private final FrameLayout f176g = ((FrameLayout) findViewById(R.id.givetake_comment_on_like_overall_container));
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final TextView f177h = ((TextView) findViewById(R.id.free_tag));

    /* renamed from: j  reason: collision with root package name */
    private final ImageButton f178j = ((ImageButton) findViewById(R.id.flower_button));

    /* renamed from: k  reason: collision with root package name */
    private final CmbButton f179k = ((CmbButton) findViewById(R.id.send_flower_button));

    /* renamed from: l  reason: collision with root package name */
    private final LinearLayout f180l = ((LinearLayout) findViewById(R.id.price_text));

    /* renamed from: m  reason: collision with root package name */
    private final CmbTextView f181m = ((CmbTextView) findViewById(R.id.price_text_view));

    /* renamed from: n  reason: collision with root package name */
    private final CmbImageView f182n = ((CmbImageView) findViewById(R.id.flower_stamp));

    /* renamed from: p  reason: collision with root package name */
    private final Context f183p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public NetworkProfile f184q;

    /* renamed from: t  reason: collision with root package name */
    private final z7.b f185t;

    /* renamed from: w  reason: collision with root package name */
    private final List<z7.a> f186w = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final k0 f187x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final s9.a f188y;

    /* renamed from: z  reason: collision with root package name */
    private final a6.a f189z;

    class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f190a;

        /* renamed from: b  reason: collision with root package name */
        private float f191b;

        /* renamed from: c  reason: collision with root package name */
        public float f192c;

        a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if (action == 0) {
                this.f190a = true;
                this.f191b = x10;
                this.f192c = y10;
            } else if (action == 2) {
                this.f190a = false;
            } else if (action == 1) {
                float f10 = this.f192c;
                float f11 = this.f191b;
                double sqrt = Math.sqrt((double) (((y10 - f10) * (y10 - f10)) + ((x10 - f11) * (x10 - f11))));
                if (this.f190a || sqrt < 25.0d) {
                    h hVar = h.this;
                    hVar.L(hVar.f170a.getCurrentItem());
                }
            }
            return false;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f194a;

        b(boolean z10) {
            this.f194a = z10;
        }

        public void onGlobalLayout() {
            float y10 = h.this.findViewById(R.id.profile_detail_container).getY();
            if (h.this.f187x.getPrice(PurchaseType.DISCOVER_LIKES).getBeanCost(1) != 0 || this.f194a) {
                h.this.f177h.setVisibility(8);
            } else {
                h.this.f177h.setY(((h.this.f173d.getY() + y10) - ((float) h.this.f177h.getHeight())) - TypedValue.applyDimension(1, 4.0f, h.this.getResources().getDisplayMetrics()));
                if (!h.this.f188y.a("OnePaidLike.Enabled.Android")) {
                    h.this.f177h.setVisibility(0);
                }
            }
            h.this.f174e.setY(((y10 - ((float) h.this.f174e.getHeight())) - ((float) h.this.findViewById(R.id.profile_bottom_container).getHeight())) - TypedValue.applyDimension(1, 40.0f, h.this.getResources().getDisplayMetrics()));
            h.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class c implements ViewPager.j {
        c() {
        }

        public void S(int i10, float f10, int i11) {
        }

        public void m0(int i10) {
        }

        public void q(int i10) {
            h.this.f171b.setText(h.this.getResources().getString(R.string.photo_indicator_formatted, new Object[]{Integer.valueOf(i10 + 1), Integer.valueOf(h.this.f184q.getPhotos().size())}));
        }
    }

    public h(Context context, ProfileContract$Manager profileContract$Manager, k0 k0Var, s9.a aVar, a6.a aVar2) {
        super(context);
        this.f183p = context;
        this.f187x = k0Var;
        this.f188y = aVar;
        this.f189z = aVar2;
        View.inflate(context, R.layout.feed_card_dls, this);
        i iVar = new i(this, getContext(), profileContract$Manager);
        this.f185t = iVar;
        iVar.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(View view) {
        K();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(boolean z10, View view) {
        if (!this.f189z.a("discover_send_flowers_ftue") || z10) {
            J();
            return;
        }
        Price price = this.f187x.getPrice(PurchaseType.PAID_LIKE);
        float y10 = findViewById(R.id.profile_detail_container).getY();
        float applyDimension = TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
        this.f178j.setVisibility(8);
        this.f179k.setVisibility(0);
        this.f180l.setY(((y10 + this.f179k.getY()) - ((float) this.f180l.getHeight())) - applyDimension);
        this.f181m.setText(z((long) price.getBeanCost(1)));
        this.f180l.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        this.f178j.setVisibility(0);
        this.f180l.setVisibility(8);
        this.f179k.setVisibility(8);
        J();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        L(this.f170a.getCurrentItem());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        L(this.f170a.getCurrentItem());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G() {
        int height = this.f174e.getHeight();
        this.f174e.setPivotX(0.0f);
        this.f174e.setPivotY((float) height);
        this.f174e.setRotation(-20.0f);
        this.f174e.setVisibility(0);
        this.f182n.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        L(this.f170a.getCurrentItem());
    }

    private void I() {
        if (this.f178j.getVisibility() == 0) {
            this.f178j.setColorFilter(this.f183p.getResources().getColor(R.color.gray_light));
            this.f178j.setBackgroundResource(R.drawable.action_circular_button_disabled_background_dls);
            this.f178j.setEnabled(false);
        } else {
            this.f173d.setColorFilter(this.f183p.getResources().getColor(R.color.gray_light));
            this.f173d.setBackgroundResource(R.drawable.action_circular_button_disabled_background_dls);
            this.f173d.setEnabled(false);
        }
        this.f174e.post(new a(this));
    }

    private void J() {
        for (z7.a p10 : this.f186w) {
            p10.p();
        }
    }

    private void K() {
        for (z7.a b10 : this.f186w) {
            b10.b();
        }
    }

    /* access modifiers changed from: private */
    public void L(int i10) {
        for (z7.a d10 : this.f186w) {
            d10.d(i10);
        }
    }

    private void M() {
        TextView textView = this.f171b;
        if (textView != null) {
            textView.setText(getResources().getString(R.string.photo_indicator_formatted, new Object[]{1, Integer.valueOf(this.f184q.getPhotos().size())}));
            this.f170a.c(new c());
        }
    }

    private void Q() {
        TextView textView = this.f171b;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private CharSequence z(long j10) {
        String str;
        Drawable drawable;
        ImageSpan imageSpan;
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 == 0) {
            str = "1  ";
        } else {
            str = j10 + "  ";
        }
        int length = str.length() - 1;
        if (i10 == 0) {
            drawable = androidx.core.content.a.getDrawable(getContext(), R.drawable.flower);
        } else {
            drawable = androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_single_bean);
        }
        drawable.setBounds(1, 1, 32, 32);
        drawable.mutate().setTint(-1);
        if (Build.VERSION.SDK_INT >= 29) {
            imageSpan = new ImageSpan(drawable, 2);
        } else {
            imageSpan = new ImageSpan(drawable);
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(imageSpan, length, length + 1, 0);
        return spannableString;
    }

    public void A() {
        if (this.f179k.getVisibility() == 0) {
            this.f179k.setVisibility(8);
            this.f180l.setVisibility(8);
            this.f178j.setVisibility(0);
        }
    }

    public void N(int i10) {
        this.f174e.setText(R.string.connected_stamp);
        this.f174e.setBackgroundResource(R.drawable.stamp_connected);
        this.f174e.setCompoundDrawablesWithIntrinsicBounds(f.b(getResources(), R.drawable.discover_stamp_heart, getContext().getTheme()), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f174e.getBackground().setColorFilter(androidx.core.content.a.getColor(getContext(), R.color.accent_color), PorterDuff.Mode.SRC_ATOP);
        this.f174e.setTextColor(getResources().getColor(R.color.accent_color));
        I();
    }

    public void O() {
        this.f182n.setVisibility(0);
        this.f174e.setVisibility(8);
        this.f178j.setColorFilter(this.f183p.getResources().getColor(R.color.gray_light));
        this.f178j.setBackgroundResource(R.drawable.action_circular_button_disabled_background_dls);
        this.f178j.setEnabled(false);
    }

    public void P(int i10) {
        this.f174e.setText(R.string.bagel_action_liked);
        this.f174e.setBackgroundResource(R.drawable.stamp_liked);
        this.f174e.setCompoundDrawablesWithIntrinsicBounds(f.b(getResources(), R.drawable.discover_stamp_heart, getContext().getTheme()), (Drawable) null, (Drawable) null, (Drawable) null);
        this.f174e.getBackground().setColorFilter(androidx.core.content.a.getColor(getContext(), R.color.accent_color), PorterDuff.Mode.SRC_ATOP);
        this.f174e.setTextColor(getResources().getColor(R.color.accent_color));
        I();
    }

    public void a() {
        this.f172c.setVisibility(0);
        this.f172c.setBackground(getResources().getDrawable(R.drawable.rising_give_take_banner_dls));
        this.f172c.setText(R.string.like_indicator_undeclared);
    }

    public void b() {
        this.f172c.setVisibility(8);
        Q();
    }

    public void c(String str) {
        CmbTextView cmbTextView = (CmbTextView) findViewById(R.id.profile_info_value_education_header);
        if (cmbTextView != null && !TextUtils.isEmpty(str)) {
            cmbTextView.setVisibility(0);
            cmbTextView.setText(str);
        } else if (cmbTextView != null) {
            cmbTextView.setVisibility(8);
        }
    }

    public void d() {
        FrameLayout frameLayout = this.f176g;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void e(String str) {
        CmbTextView cmbTextView = (CmbTextView) findViewById(R.id.profile_info_value_occupation_employer);
        if (cmbTextView != null && !str.isEmpty()) {
            cmbTextView.setVisibility(0);
            cmbTextView.setText(str);
        } else if (cmbTextView != null) {
            cmbTextView.setVisibility(8);
        }
    }

    public void f(String str) {
        FrameLayout frameLayout = this.f176g;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            RisingCommentView risingCommentView = (RisingCommentView) LayoutInflater.from(this.f183p).inflate(R.layout.rising_like_comment, this.f176g, false);
            risingCommentView.B(this.f183p.getString(R.string.sent_a_message), str);
            risingCommentView.C(true);
            this.f176g.addView(risingCommentView);
            this.f176g.setOnClickListener(new g(this));
        }
    }

    public void g() {
        this.f172c.setVisibility(0);
        this.f172c.setBackgroundColor(getResources().getColor(R.color.blue_cmb_text));
        this.f172c.setText(R.string.he_has_not_seen_you);
    }

    public void h(String str) {
        CmbTextView cmbTextView = (CmbTextView) findViewById(R.id.profile_info_value_age_location);
        if (cmbTextView != null && !str.isEmpty()) {
            cmbTextView.setText(str);
        }
    }

    public void setPhotoPosition(int i10) {
        this.f170a.N(i10, false);
    }

    public void x(z7.a aVar) {
        if (!this.f186w.contains(aVar)) {
            this.f186w.add(aVar);
        }
    }

    public void y(NetworkProfile networkProfile, boolean z10, int i10, int i11, int i12, String str, boolean z11, String str2, RisingGiveTake risingGiveTake) {
        boolean z12 = z10;
        int i13 = i11;
        this.f184q = networkProfile;
        this.f170a.setMediaItems(new ArrayList(networkProfile.getPhotos()));
        M();
        if (this.f188y.a("OnePaidLike.Enabled.Android")) {
            if (z12) {
                this.f178j.setImageResource(R.drawable.like);
            } else {
                this.f178j.setImageResource(R.drawable.flower);
            }
            this.f178j.setVisibility(0);
            this.f178j.setEnabled(true);
            this.f178j.setColorFilter(getResources().getColor(R.color.main_color));
            this.f177h.setVisibility(8);
            A();
            this.f173d.setVisibility(8);
        } else {
            this.f178j.setVisibility(8);
            this.f173d.setVisibility(0);
            this.f173d.setEnabled(true);
            if (z12) {
                this.f173d.setImageResource(R.drawable.comment_overall);
            } else {
                this.f173d.setImageResource(R.drawable.like);
            }
            this.f173d.setColorFilter(getResources().getColor(R.color.accent_color));
            this.f173d.setBackgroundResource(R.drawable.connect_circular_button_enabled_background_dls);
        }
        if (!z11) {
            this.f174e.setVisibility(8);
            this.f182n.setVisibility(8);
        } else if (z12) {
            N(i11);
        } else if (this.f188y.a("OnePaidLike.Enabled.Android")) {
            O();
        } else {
            P(i11);
        }
        this.f173d.setOnClickListener(new b(this));
        this.f178j.setOnClickListener(new c(this, z10));
        this.f179k.setOnClickListener(new d(this));
        this.f170a.setOnClickListener(new e(this));
        this.f175f.setOnClickListener(new f(this));
        this.f170a.setOnTouchListener(new a());
        this.f185t.C(networkProfile, z10, i10, i11, i12, str, str2, risingGiveTake);
        requestLayout();
        getViewTreeObserver().addOnGlobalLayoutListener(new b(z10));
    }
}
