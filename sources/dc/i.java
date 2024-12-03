package dc;

import android.content.res.Resources;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.today_view.card.deactivated.DeactivatedComponentView;
import j5.x;
import java.util.concurrent.TimeUnit;

public class i extends p<DeactivatedComponentView> {

    /* renamed from: e  reason: collision with root package name */
    private final a f40601e;

    interface a {
        void y0();
    }

    public i(DeactivatedComponentView deactivatedComponentView, a aVar) {
        super(deactivatedComponentView);
        this.f40601e = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(x xVar) throws Exception {
        this.f40601e.y0();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((DeactivatedComponentView) this.f7869c).C().p0(1200, TimeUnit.MILLISECONDS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(this));
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        ((DeactivatedComponentView) this.f7869c).D();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        ((DeactivatedComponentView) this.f7869c).B();
    }

    /* access modifiers changed from: package-private */
    public void m() {
        Resources resources = ((DeactivatedComponentView) this.f7869c).getResources();
        String string = resources.getString(R.string.paused_account_title_no_rising_bagel);
        String string2 = resources.getString(R.string.paused_account_message_no_rising_bagel);
        ((DeactivatedComponentView) this.f7869c).E();
        ((DeactivatedComponentView) this.f7869c).G(string, string2);
    }

    /* access modifiers changed from: package-private */
    public void n(int i10, Integer num) {
        Resources resources = ((DeactivatedComponentView) this.f7869c).getResources();
        String string = resources.getString(i10, new Object[]{num});
        String string2 = resources.getString(R.string.paused_account_message_has_rising_bagel);
        ((DeactivatedComponentView) this.f7869c).F();
        ((DeactivatedComponentView) this.f7869c).G(string, string2);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        sb.a.i(this.f7869c, R.string.error_reactivation);
    }

    /* access modifiers changed from: package-private */
    public void p() {
        ((DeactivatedComponentView) this.f7869c).H();
    }
}
