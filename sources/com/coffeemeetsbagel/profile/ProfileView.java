package com.coffeemeetsbagel.profile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.v0;
import androidx.core.widget.NestedScrollView;
import androidx.vectordrawable.graphics.drawable.f;
import androidx.viewpager.widget.ViewPager;
import c5.g;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activity_reports.views.DottedCircleView;
import com.coffeemeetsbagel.activity_reports.views.MessageView;
import com.coffeemeetsbagel.activity_reports.views.OnOffView;
import com.coffeemeetsbagel.activity_reports.views.PieView;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.feature.comment_on_like.RisingCommentView;
import com.coffeemeetsbagel.feature.mediaitemtype.MediaItemViewPager;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.enums.Icon;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.interfaces.MediaItemContract;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import java.util.Comparator;
import java.util.List;
import lc.c;
import qj.q;
import y6.n;

public class ProfileView extends LinearLayout {
    private View B;
    private TextView C;
    private ImageView D;
    private MediaItemViewPager E;
    private RelativeLayout F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private ImageView J;
    private final PublishSubject<x> K = PublishSubject.C0();
    private final PublishSubject<String> L = PublishSubject.C0();
    private final PublishSubject<String> M = PublishSubject.C0();
    private final PublishSubject<QuestionGroupType> N = PublishSubject.C0();

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f36033a;

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f36034b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout f36035c;

    /* renamed from: d  reason: collision with root package name */
    private View f36036d;

    /* renamed from: e  reason: collision with root package name */
    private View f36037e;

    /* renamed from: f  reason: collision with root package name */
    private View f36038f;

    /* renamed from: g  reason: collision with root package name */
    private View f36039g;

    /* renamed from: h  reason: collision with root package name */
    private g f36040h;

    /* renamed from: j  reason: collision with root package name */
    private final io.reactivex.subjects.a<x> f36041j = io.reactivex.subjects.a.C0();

    /* renamed from: k  reason: collision with root package name */
    private final io.reactivex.subjects.a<x> f36042k = io.reactivex.subjects.a.C0();

    /* renamed from: l  reason: collision with root package name */
    private final io.reactivex.subjects.a<x> f36043l = io.reactivex.subjects.a.C0();

    /* renamed from: m  reason: collision with root package name */
    private final io.reactivex.subjects.a<x> f36044m = io.reactivex.subjects.a.C0();

    /* renamed from: n  reason: collision with root package name */
    private final io.reactivex.subjects.a<Boolean> f36045n = io.reactivex.subjects.a.C0();

    /* renamed from: p  reason: collision with root package name */
    private final io.reactivex.subjects.a<ActivityReportViewedState> f36046p = io.reactivex.subjects.a.C0();

    /* renamed from: q  reason: collision with root package name */
    private final io.reactivex.subjects.a<Bagel.STAMP> f36047q = io.reactivex.subjects.a.C0();
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final io.reactivex.subjects.a<Integer> f36048t = io.reactivex.subjects.a.C0();

    /* renamed from: w  reason: collision with root package name */
    private TextView f36049w;

    /* renamed from: x  reason: collision with root package name */
    private ViewGroup f36050x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f36051y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f36052z;

    class a implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CmbTextView f36053a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f36054b;

        a(CmbTextView cmbTextView, List list) {
            this.f36053a = cmbTextView;
            this.f36054b = list;
        }

        public void S(int i10, float f10, int i11) {
        }

        public void m0(int i10) {
        }

        public void q(int i10) {
            this.f36053a.setText(ProfileView.this.s(this.f36054b, i10));
        }
    }

    class b implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f36056a = false;

        /* renamed from: b  reason: collision with root package name */
        private float f36057b;

        /* renamed from: c  reason: collision with root package name */
        private float f36058c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MediaItemViewPager f36059d;

        b(MediaItemViewPager mediaItemViewPager) {
            this.f36059d = mediaItemViewPager;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if (action == 0) {
                this.f36056a = true;
                this.f36057b = x10;
                this.f36058c = y10;
            } else if (action == 2) {
                this.f36056a = false;
            } else if (action == 1) {
                float f10 = this.f36058c;
                float f11 = this.f36057b;
                double sqrt = Math.sqrt((double) (((y10 - f10) * (y10 - f10)) + ((x10 - f11) * (x10 - f11))));
                if (this.f36056a || sqrt < 25.0d) {
                    ProfileView.this.f36048t.d(Integer.valueOf(this.f36059d.getCurrentPage()));
                }
            }
            return false;
        }
    }

    public ProfileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        this.B.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(QuestionGroupType questionGroupType, View view) {
        this.N.d(questionGroupType);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        this.f36042k.d(x.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(Bagel.STAMP stamp) {
        int height = this.f36049w.getHeight();
        this.f36049w.setPivotX(0.0f);
        this.f36049w.setPivotY((float) height);
        this.f36049w.setRotation(-20.0f);
        this.f36049w.setVisibility(0);
        this.f36047q.d(stamp);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(ViewGroup viewGroup, Rect rect, int i10, NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        if (viewGroup.getLocalVisibleRect(rect)) {
            this.f36046p.d(ActivityReportViewedState.VIEWED);
            if (i12 <= i14) {
                return;
            }
            if (i10 < i12) {
                this.f36045n.d(Boolean.TRUE);
            } else {
                this.f36045n.d(Boolean.FALSE);
            }
        } else {
            this.f36046p.d(ActivityReportViewedState.HIDDEN);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M() {
        int height = this.f36049w.getHeight();
        this.f36049w.setPivotX(0.0f);
        this.f36049w.setPivotY((float) height);
        this.f36049w.setRotation(-20.0f);
        this.f36049w.setVisibility(0);
        A0("0");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean N(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.report) {
            this.f36043l.d(x.a());
            return true;
        } else if (menuItem.getItemId() != R.id.hide) {
            return false;
        } else {
            this.f36044m.d(x.a());
            return true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        this.f36041j.d(x.a());
    }

    private void S(ChipGroup chipGroup, List<m> list, QuestionGroupType questionGroupType) {
        list.sort(Comparator.comparing(new e0()));
        chipGroup.removeAllViews();
        LayoutInflater from = LayoutInflater.from(getContext());
        for (m next : list) {
            Chip chip = (Chip) from.inflate(R.layout.single_chip_layout, chipGroup, false);
            if (next.b()) {
                chip.setChipStrokeWidth(getResources().getDimension(R.dimen.stroke_width));
                chip.setChipStrokeColor(getResources().getColorStateList(R.color.main_color, (Resources.Theme) null));
            } else {
                chip.setChipStrokeWidth(0.0f);
            }
            chip.setText(next.a());
            chip.setOnClickListener(new f0(this, questionGroupType));
            chipGroup.addView(chip);
        }
    }

    private void T() {
        ((TextView) findViewById(R.id.help)).setOnClickListener(new d0(this));
    }

    private void U(List<MediaItemContract.MediaItem> list, MediaItemViewPager mediaItemViewPager, CmbTextView cmbTextView) {
        cmbTextView.setText(s(list, mediaItemViewPager.getCurrentPage()));
        mediaItemViewPager.c(new a(cmbTextView, list));
        mediaItemViewPager.setOnTouchListener(new b(mediaItemViewPager));
    }

    private void V(Bagel.STAMP stamp) {
        this.f36049w.post(new c0(this, stamp));
    }

    /* access modifiers changed from: private */
    public String s(List<MediaItemContract.MediaItem> list, int i10) {
        return getResources().getString(R.string.photo_indicator_formatted, new Object[]{Integer.valueOf(i10 + 1), Integer.valueOf(list.size())});
    }

    public void A() {
        findViewById(R.id.profile_photo_bottom_container).setVisibility(8);
    }

    public void A0(String str) {
        if (str.equals("0")) {
            this.J.setVisibility(0);
            this.f36051y.setVisibility(8);
            this.f36052z.setVisibility(8);
        } else {
            this.J.setVisibility(8);
            this.f36051y.setVisibility(0);
            this.f36052z.setVisibility(0);
            this.f36051y.setText(str);
            this.f36051y.setBackgroundColor(getResources().getColor(R.color.main_color));
            this.f36052z.setTextColor(getResources().getColor(R.color.main_color));
        }
        float left = (float) this.f36049w.getLeft();
        float bottom = (float) this.f36049w.getBottom();
        double right = (double) (((float) this.f36049w.getRight()) - left);
        double top = (double) (((float) this.f36049w.getTop()) - bottom);
        double cos = (((double) left) + (Math.cos(-0.3490658503988659d) * right)) - (Math.sin(-0.3490658503988659d) * top);
        double sin = ((double) bottom) + (right * Math.sin(-0.3490658503988659d)) + (top * Math.cos(-0.3490658503988659d));
        this.f36050x.setX(((float) cos) - ((float) (this.f36050x.getWidth() / 2)));
        this.f36050x.setY(((float) sin) - ((float) (this.f36050x.getHeight() / 2)));
        this.f36050x.setVisibility(0);
    }

    public void B() {
        ((CmbTextView) findViewById(R.id.text_photo_indicator)).setVisibility(8);
    }

    public q<x> B0() {
        return this.f36041j.P();
    }

    public void C() {
        this.f36033a.setVisibility(8);
        this.f36034b.setVisibility(8);
    }

    public void D() {
        findViewById(R.id.get_premium_button).setVisibility(8);
    }

    public void E() {
        this.f36038f.setVisibility(8);
    }

    public boolean F() {
        return this.f36035c.getVisibility() == 0;
    }

    public q<String> G() {
        return this.M.P();
    }

    public q<x> P() {
        return this.f36043l.P();
    }

    public q<x> Q() {
        return this.f36033a.s();
    }

    public q<String> R() {
        return this.L.P();
    }

    public void W() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_report);
        viewGroup.setVisibility(0);
        T();
        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.scroll_container);
        Rect rect = new Rect();
        nestedScrollView.getHitRect(rect);
        nestedScrollView.setOnScrollChangeListener(new a0(this, viewGroup, rect, (int) (((double) viewGroup.getTop()) * 0.7d)));
    }

    public void X(float f10, boolean z10, String str) {
        DottedCircleView dottedCircleView = (DottedCircleView) findViewById(R.id.dotted_circle_view);
        TextView textView = (TextView) findViewById(R.id.usually_replies_within_text);
        int i10 = 1;
        dottedCircleView.setIsColorOn(true);
        int c10 = n.c(f10);
        if (c10 != 0) {
            if (c10 > dottedCircleView.getMaxNumDots()) {
                i10 = dottedCircleView.getMaxNumDots();
            } else {
                i10 = c10;
            }
        }
        dottedCircleView.g(i10, z10);
        textView.setText(str);
    }

    public void Y(float f10, boolean z10, String str) {
        PieView pieView = (PieView) findViewById(R.id.pie_view);
        pieView.c(f10, z10);
        pieView.setIsColorOn(true);
        ((TextView) findViewById(R.id.chats_with_bagels_text)).setText(str);
    }

    public void Z(boolean z10, String str) {
        MessageView messageView = (MessageView) findViewById(R.id.message_view);
        messageView.d(3, z10);
        messageView.setIsColorOn(true);
        ((TextView) findViewById(R.id.sends_first_message_text)).setText(str);
    }

    public void a0(boolean z10, boolean z11, String str) {
        OnOffView onOffView = (OnOffView) findViewById(R.id.on_off_view);
        TextView textView = (TextView) findViewById(R.id.active_within_72_hr_text);
        if (z10) {
            onOffView.j(true, z11);
            onOffView.setIsColorOn(true);
        } else {
            onOffView.j(false, z11);
            onOffView.setIsColorOn(false);
        }
        textView.setText(str);
    }

    public void b0() {
        PieView pieView = (PieView) findViewById(R.id.pie_view);
        pieView.c(0.75f, false);
        pieView.setIsColorOn(false);
        ((TextView) findViewById(R.id.chats_with_bagels_text)).setText(R.string.locked);
    }

    public void c0() {
        MessageView messageView = (MessageView) findViewById(R.id.message_view);
        messageView.d(3, false);
        messageView.setIsColorOn(false);
        ((TextView) findViewById(R.id.sends_first_message_text)).setText(R.string.locked);
    }

    public void d0() {
        OnOffView onOffView = (OnOffView) findViewById(R.id.on_off_view);
        onOffView.setIsColorOn(false);
        onOffView.j(true, false);
        ((TextView) findViewById(R.id.active_within_72_hr_text)).setText(R.string.locked);
    }

    public void e0() {
        DottedCircleView dottedCircleView = (DottedCircleView) findViewById(R.id.dotted_circle_view);
        dottedCircleView.g(4, false);
        dottedCircleView.setIsColorOn(false);
        ((TextView) findViewById(R.id.usually_replies_within_text)).setText(R.string.locked);
    }

    public void f0() {
        DottedCircleView dottedCircleView = (DottedCircleView) findViewById(R.id.dotted_circle_view);
        dottedCircleView.g(4, false);
        dottedCircleView.setIsColorOn(true);
        ((TextView) findViewById(R.id.usually_replies_within_text)).setText(R.string.no_data_yet);
    }

    public void g0() {
        PieView pieView = (PieView) findViewById(R.id.pie_view);
        pieView.c(0.75f, false);
        pieView.setIsColorOn(true);
        ((TextView) findViewById(R.id.chats_with_bagels_text)).setText(R.string.no_data_yet);
    }

    public int getPhotoPosition() {
        return this.E.getCurrentPage();
    }

    public void h0() {
        MessageView messageView = (MessageView) findViewById(R.id.message_view);
        messageView.d(3, false);
        messageView.setIsColorOn(true);
        ((TextView) findViewById(R.id.sends_first_message_text)).setText(R.string.no_data_yet);
    }

    public void i0() {
        OnOffView onOffView = (OnOffView) findViewById(R.id.on_off_view);
        onOffView.setIsColorOn(true);
        onOffView.j(true, false);
        ((TextView) findViewById(R.id.active_within_72_hr_text)).setText(R.string.no_data_yet);
    }

    public void j0(String str, String str2) {
        RisingCommentView risingCommentView = (RisingCommentView) LayoutInflater.from(getContext()).inflate(R.layout.rising_like_comment, this.f36035c, false);
        this.f36035c.setVisibility(0);
        risingCommentView.B(str, str2);
        this.f36035c.addView(risingCommentView);
    }

    public q<Bagel.STAMP> k() {
        return this.f36047q.P();
    }

    public void k0() {
        this.f36049w.setText(R.string.bagel_action_connected_male);
        this.f36049w.setBackgroundResource(R.drawable.stamp_connected);
        this.f36049w.getBackground().setColorFilter(androidx.core.content.a.getColor(getContext(), R.color.accent_color), PorterDuff.Mode.SRC_ATOP);
        this.f36049w.setTextColor(getResources().getColor(R.color.accent_color));
        V(Bagel.STAMP.CONNECTED);
    }

    public q<x> l() {
        return this.f36042k.P();
    }

    public void l0(String str, String str2, String str3) {
        this.F.setVisibility(0);
        this.H.setText(str2);
        if (TextUtils.isEmpty(str3)) {
            this.I.setVisibility(8);
        } else {
            this.I.setVisibility(0);
            this.I.setText(str3);
        }
        if (str != null) {
            this.G.setImageResource(getContext().getResources().getIdentifier(str, "drawable", getContext().getPackageName()));
            return;
        }
        this.G.setVisibility(8);
    }

    public q<Boolean> m() {
        return this.f36045n.P();
    }

    public void m0(List<m> list) {
        S((ChipGroup) this.f36039g.findViewById(R.id.profile_chips), list, QuestionGroupType.DATING_STYLE);
        ((TextView) this.f36039g.findViewById(R.id.title)).setText(R.string.label_dating_style);
        this.f36039g.setVisibility(0);
    }

    public q<ActivityReportViewedState> n() {
        return this.f36046p.P();
    }

    public void n0() {
        this.f36049w.setText(R.string.bagel_action_liked);
        this.f36049w.setBackgroundResource(R.drawable.stamp_liked);
        this.f36049w.getBackground().setColorFilter(androidx.core.content.a.getColor(getContext(), R.color.main_color), PorterDuff.Mode.SRC_ATOP);
        this.f36049w.setTextColor(getResources().getColor(R.color.main_color));
        this.f36049w.post(new z(this));
    }

    public q<QuestionGroupType> o() {
        return this.N.P();
    }

    public void o0(List<m> list) {
        S((ChipGroup) this.f36036d.findViewById(R.id.profile_chips), list, QuestionGroupType.INTERESTS);
        this.f36036d.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f36033a = (CmbTextView) findViewById(R.id.flag_button);
        this.f36034b = (CmbTextView) findViewById(R.id.report_icon_title);
        this.f36035c = (FrameLayout) findViewById(R.id.bagel_comment_on_like_overall_container);
        View findViewById = findViewById(R.id.receivedFlowersOverlay);
        this.B = findViewById;
        findViewById.setOnClickListener(new x(this));
        this.C = (TextView) findViewById(R.id.receivedWoosText);
        this.D = (ImageView) findViewById(R.id.receivedWoosImage);
        this.f36049w = (TextView) findViewById(R.id.actionStamp);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.wooStampContainer);
        this.f36050x = viewGroup;
        this.f36052z = (TextView) viewGroup.findViewById(R.id.wooStampIcon);
        this.f36051y = (TextView) this.f36050x.findViewById(R.id.wooStampCounter);
        this.E = (MediaItemViewPager) findViewById(R.id.photoViewPager);
        this.F = (RelativeLayout) findViewById(R.id.contextual_match);
        this.G = (ImageView) findViewById(R.id.contextual_match_icon);
        this.H = (TextView) findViewById(R.id.contextual_match_title);
        this.I = (TextView) findViewById(R.id.contextual_match_text);
        this.J = (ImageView) findViewById(R.id.flowerStampIcon);
        c.o(this.f36052z, Icon.FLOWER);
        this.f36036d = findViewById(R.id.profile_interest_container);
        this.f36037e = findViewById(R.id.profile_personality_container);
        this.f36038f = findViewById(R.id.profile_values_container);
        this.f36039g = findViewById(R.id.profile_dating_style_container);
    }

    public q<x> p() {
        return this.f36044m.P();
    }

    public void p0(boolean z10, boolean z11) {
        this.f36049w.setText(R.string.bagel_action_liked);
        this.f36049w.setBackgroundResource(R.drawable.stamp_liked);
        if (!z11) {
            this.f36049w.setCompoundDrawablesWithIntrinsicBounds(f.b(getResources(), R.drawable.discover_stamp_heart, getContext().getTheme()), (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (Bakery.w().G().j().hasPrioritizedLikes()) {
            this.f36049w.setCompoundDrawablesWithIntrinsicBounds(f.b(getResources(), R.drawable.pl_stamp_heart, getContext().getTheme()), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (!z11) {
            this.f36049w.getBackground().setColorFilter(androidx.core.content.a.getColor(getContext(), R.color.accent_color), PorterDuff.Mode.SRC_ATOP);
            this.f36049w.setTextColor(getResources().getColor(R.color.accent_color));
        } else {
            this.f36049w.getBackground().setColorFilter(androidx.core.content.a.getColor(getContext(), R.color.main_color), PorterDuff.Mode.SRC_ATOP);
            this.f36049w.setTextColor(getResources().getColor(R.color.main_color));
            if (z10) {
                this.f36049w.setCompoundDrawablesWithIntrinsicBounds(f.b(getResources(), R.drawable.pl_stamp_heart, getContext().getTheme()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        V(Bagel.STAMP.LIKED);
    }

    public q<x> q() {
        return this.K.P();
    }

    public void q0() {
        this.f36049w.setText(R.string.bagel_action_passed);
        this.f36049w.setBackgroundResource(R.drawable.stamp_passed);
        this.f36049w.getBackground().setColorFilter(androidx.core.content.a.getColor(getContext(), R.color.white), PorterDuff.Mode.SRC_ATOP);
        this.f36049w.setTextColor(getResources().getColor(R.color.white));
        V(Bagel.STAMP.PASSED);
    }

    public q<Integer> r() {
        return this.f36048t.P();
    }

    public void r0(List<m> list) {
        S((ChipGroup) this.f36037e.findViewById(R.id.profile_chips), list, QuestionGroupType.PERSONALITY);
        ((TextView) this.f36037e.findViewById(R.id.title)).setText(R.string.label_personality);
        this.f36037e.setVisibility(0);
    }

    public void s0(String str) {
        ((TextView) findViewById(R.id.profile_photo_bottom_text)).setText(str);
        findViewById(R.id.profile_photo_bottom_container).setVisibility(0);
    }

    public void setAgeAndLocation(String str) {
        CmbTextView cmbTextView = (CmbTextView) findViewById(R.id.profile_info_value_age_location);
        cmbTextView.setVisibility(0);
        cmbTextView.setText(str);
    }

    public void setEducationHeader(String str) {
        CmbTextView cmbTextView = (CmbTextView) findViewById(R.id.profile_info_value_education_header);
        cmbTextView.setVisibility(0);
        cmbTextView.setText(str);
    }

    public void setEmployerHeader(String str) {
        TextView textView = (TextView) findViewById(R.id.profile_info_value_occupation_employer);
        textView.setVisibility(0);
        textView.setText(str);
    }

    public void setMediaItems(List<MediaItemContract.MediaItem> list) {
        if (list != null) {
            CmbTextView cmbTextView = (CmbTextView) findViewById(R.id.text_photo_indicator);
            this.E.setMediaItems(list);
            U(list, this.E, cmbTextView);
            if (list.size() <= 1) {
                cmbTextView.setVisibility(8);
            } else {
                cmbTextView.setVisibility(0);
            }
        }
    }

    public void setPhotoPagerToPosition(int i10) {
        this.E.N(i10, false);
    }

    public void t() {
        ((CmbTextView) findViewById(R.id.profile_info_value_age_location)).setVisibility(8);
    }

    public void t0() {
        if (this.f36040h == null) {
            this.f36040h = new g(getContext());
        }
        this.f36040h.show();
        if (this.f36040h.getWindow() != null) {
            this.f36040h.getWindow().setLayout(-1, -2);
        }
    }

    public void u() {
        this.F.setVisibility(8);
    }

    public void u0() {
        this.f36033a.setVisibility(0);
        this.f36034b.setVisibility(0);
    }

    public void v() {
        this.f36039g.setVisibility(8);
    }

    public void v0(boolean z10) {
        v0 v0Var = new v0(getContext(), this.f36033a);
        if (z10) {
            v0Var.b(R.menu.hide_report_post_connnection);
        } else {
            v0Var.b(R.menu.hide_report_pre_connection);
        }
        v0Var.c(new y(this));
        v0Var.d();
    }

    public void w() {
        ((CmbTextView) findViewById(R.id.profile_info_value_education_header)).setVisibility(8);
    }

    public void w0() {
        TextView textView = (TextView) findViewById(R.id.get_premium_button);
        textView.setVisibility(0);
        textView.setOnClickListener(new b0(this));
    }

    public void x() {
        ((TextView) findViewById(R.id.profile_info_value_occupation_employer)).setVisibility(8);
    }

    public void x0() {
        findViewById(R.id.get_premium_button).setVisibility(0);
    }

    public void y() {
        this.f36036d.setVisibility(8);
    }

    public void y0(List<m> list) {
        S((ChipGroup) this.f36038f.findViewById(R.id.profile_chips), list, QuestionGroupType.VALUES);
        ((TextView) this.f36038f.findViewById(R.id.title)).setText(R.string.label_values);
        this.f36038f.setVisibility(0);
    }

    public void z() {
        this.f36037e.setVisibility(8);
    }

    public void z0(String str, int i10) {
        this.D.setImageResource(i10);
        this.C.setText(str);
        this.B.setVisibility(0);
    }
}
