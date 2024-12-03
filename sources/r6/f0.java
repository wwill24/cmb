package r6;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.a0;
import com.coffeemeetsbagel.discover_feed.list.DiscoverFeedListView;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import j5.x;
import java.util.List;

public class f0 extends p<DiscoverFeedListView> {

    /* renamed from: e  reason: collision with root package name */
    private com.coffeemeetsbagel.discover_feed.list.a f17298e;

    /* renamed from: f  reason: collision with root package name */
    private w f17299f;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17300a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.coffeemeetsbagel.discover_feed.ActionListenerEvent[] r0 = com.coffeemeetsbagel.discover_feed.ActionListenerEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17300a = r0
                com.coffeemeetsbagel.discover_feed.ActionListenerEvent r1 = com.coffeemeetsbagel.discover_feed.ActionListenerEvent.PROFILE_PICTURE_CLICKED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17300a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.discover_feed.ActionListenerEvent r1 = com.coffeemeetsbagel.discover_feed.ActionListenerEvent.LIKED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f17300a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.discover_feed.ActionListenerEvent r1 = com.coffeemeetsbagel.discover_feed.ActionListenerEvent.FLOWER_CLICKED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r6.f0.a.<clinit>():void");
        }
    }

    public f0(DiscoverFeedListView discoverFeedListView, w wVar, com.coffeemeetsbagel.discover_feed.list.a aVar) {
        super(discoverFeedListView);
        this.f17298e = aVar;
        this.f17299f = wVar;
        ((DiscoverFeedListView) g()).setAdapter(aVar);
    }

    /* access modifiers changed from: private */
    public void E(o6.a aVar) {
        int i10 = a.f17300a[aVar.a().ordinal()];
        if (i10 == 1) {
            this.f17299f.d1(aVar.d(), aVar.c(), aVar.e(), aVar.b());
        } else if (i10 == 2) {
            this.f17299f.t0(aVar.c());
        } else if (i10 == 3) {
            this.f17299f.A(aVar.c());
        }
    }

    /* access modifiers changed from: private */
    public void F(Price price) {
        ((DiscoverFeedListView) this.f7869c).j();
        this.f17299f.V(price);
        this.f17299f.c0(price);
    }

    /* access modifiers changed from: private */
    public void G(GiveTake giveTake) {
        this.f17299f.C(giveTake);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(x xVar) throws Exception {
        M();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(x xVar) throws Exception {
        L();
    }

    private void M() {
        Integer valueOf = Integer.valueOf(((DiscoverFeedListView) g()).getFirstVisibleCard());
        Integer lastVisibleCard = ((DiscoverFeedListView) g()).getLastVisibleCard();
        this.f17299f.F(valueOf.intValue());
        if (lastVisibleCard != null) {
            this.f17299f.F(lastVisibleCard.intValue());
        }
    }

    /* access modifiers changed from: private */
    public void P(Bagel bagel) {
        this.f17299f.s1(bagel);
    }

    /* access modifiers changed from: private */
    public void q(GiveTake giveTake) {
        Z();
        r();
        this.f17299f.i1(giveTake);
    }

    private CharSequence y(long j10) {
        ImageSpan imageSpan;
        String str = j10 + " ";
        String string = ((DiscoverFeedListView) this.f7869c).getContext().getString(R.string.skip_the_line_primary_cta, new Object[]{str});
        int lastIndexOf = (string.lastIndexOf(str) + str.length()) - 1;
        Drawable drawable = androidx.core.content.a.getDrawable(((DiscoverFeedListView) this.f7869c).getContext(), R.drawable.ic_single_bean);
        drawable.setBounds(0, 4, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.mutate().setTint(-1);
        if (Build.VERSION.SDK_INT >= 29) {
            imageSpan = new ImageSpan(drawable, 2);
        } else {
            imageSpan = new ImageSpan(drawable);
        }
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(imageSpan, lastIndexOf, lastIndexOf + 1, 0);
        return spannableString;
    }

    public String A() {
        return ((DiscoverFeedListView) g()).getContext().getString(R.string.paused_account_discover_like_pop_up_message);
    }

    public String B(Price price) {
        return ((DiscoverFeedListView) g()).getContext().getResources().getString(R.string.confirm_sending_discover_like, new Object[]{Integer.valueOf(price.getBeanCost(1))});
    }

    public String C() {
        return ((DiscoverFeedListView) g()).getContext().getString(R.string.you_have_unlimited_discover_likes);
    }

    public String D(Price price) {
        return ((DiscoverFeedListView) g()).getContext().getResources().getQuantityString(R.plurals.dialog_confirm_free_discover_like, price.getFreeItemCount(), new Object[]{Integer.valueOf(price.getFreeItemCount())});
    }

    public void H(int i10) {
        ((DiscoverFeedListView) g()).m(i10);
    }

    public void I() {
        ((DiscoverFeedListView) this.f7869c).g();
    }

    public void L() {
        this.f17299f.r();
    }

    public void N(a0.a aVar, long j10) {
        CharSequence charSequence;
        if (j10 == 0) {
            charSequence = ((DiscoverFeedListView) g()).getContext().getString(R.string.skip_the_line_primary_cta, new Object[]{((DiscoverFeedListView) g()).getContext().getString(R.string.free_caps)});
        } else {
            charSequence = y(j10);
        }
        ((DiscoverFeedListView) g()).E(R.string.stand_out_with_flowers, R.string.send_flowers_description, charSequence, R.string.cancel, aVar);
    }

    public void O(int i10, String str, int i11, GiveTake giveTake) {
        ((DiscoverFeedListView) g()).s(i10, str, i11, giveTake);
    }

    public void Q() {
        this.f17298e.l();
    }

    public void R(int i10) {
        ((DiscoverFeedListView) this.f7869c).w(i10);
    }

    public void S(int i10, int i11) {
        ((DiscoverFeedListView) this.f7869c).x(i10, i11);
    }

    public void T(Bagel bagel, String str) {
        ((DiscoverFeedListView) this.f7869c).y(bagel, str);
    }

    public void U(int i10) {
        ((DiscoverFeedListView) g()).z(i10);
    }

    public void V(int i10) {
        ((DiscoverFeedListView) g()).A(i10);
    }

    public void W(List<GiveTakeBase> list, boolean z10) {
        this.f17298e.P(list);
        if (z10) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (list.get(i10) instanceof GiveTake) {
                    R(i10);
                    return;
                }
            }
        }
    }

    public void X(int i10) {
        ((DiscoverFeedListView) g()).B(i10);
    }

    public void Y(Price price) {
        ((DiscoverFeedListView) this.f7869c).C(price);
        this.f17299f.c0(price);
    }

    public void Z() {
        ((DiscoverFeedListView) this.f7869c).D();
    }

    public void a0(int i10) {
        ((DiscoverFeedListView) this.f7869c).D();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((DiscoverFeedListView) g()).v().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new y(this));
        ((com.uber.autodispose.p) this.f17298e.J().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new z(this));
        ((com.uber.autodispose.p) ((DiscoverFeedListView) g()).F().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new a0(this));
        ((com.uber.autodispose.p) ((DiscoverFeedListView) g()).t().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new b0(this));
        ((com.uber.autodispose.p) ((DiscoverFeedListView) g()).u().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new c0(this));
        ((com.uber.autodispose.p) ((DiscoverFeedListView) g()).f().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new d0(this));
        ((com.uber.autodispose.p) ((DiscoverFeedListView) g()).r().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new e0(this));
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        ((DiscoverFeedListView) g()).h();
    }

    public void r() {
        ((DiscoverFeedListView) this.f7869c).i();
    }

    public void t() {
        ((DiscoverFeedListView) this.f7869c).k();
    }

    public void u() {
        ((DiscoverFeedListView) g()).l();
    }

    public String v(String str) {
        return ((DiscoverFeedListView) g()).getContext().getString(R.string.discover_like_congratulations_connected_with_female, new Object[]{str});
    }

    public String w(String str) {
        return ((DiscoverFeedListView) g()).getContext().getString(R.string.discover_like_congratulations_connected_with_male, new Object[]{str});
    }

    public String z() {
        return ((DiscoverFeedListView) g()).getContext().getString(R.string.dialog_confirm_discover_like_free_bagel);
    }
}
