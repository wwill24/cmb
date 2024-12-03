package fc;

import b6.p;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption;
import com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelComponentView;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class j extends p<NoBagelComponentView> {

    /* renamed from: e  reason: collision with root package name */
    private final g f40791e;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f40792a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption[] r0 = com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40792a = r0
                com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption r1 = com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption.DISCOVER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40792a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption r1 = com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption.TIPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40792a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption r1 = com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption.LIKE_PASS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fc.j.a.<clinit>():void");
        }
    }

    public j(NoBagelComponentView noBagelComponentView, g gVar) {
        super(noBagelComponentView);
        this.f40791e = gVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(NoBagelClickOption noBagelClickOption) throws Exception {
        int i10 = a.f40792a[noBagelClickOption.ordinal()];
        if (i10 == 1) {
            this.f40791e.J1();
        } else if (i10 == 2) {
            this.f40791e.L1();
        } else if (i10 == 3) {
            this.f40791e.K1();
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((NoBagelComponentView) g()).C().p0(1000, TimeUnit.MILLISECONDS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new i(this));
    }

    /* access modifiers changed from: package-private */
    public void l(List<NetworkPhoto> list, String str) {
        ((NoBagelComponentView) this.f7869c).E(list);
        try {
            ((NoBagelComponentView) this.f7869c).setTitleText(String.format(t9.a.femaleDay0CompleteHeader, new Object[]{str}));
        } catch (IllegalArgumentException unused) {
            fa.a.f(getClass().getSimpleName(), "Bad LP variable: " + t9.a.femaleDay0CompleteHeader);
        }
        ((NoBagelComponentView) this.f7869c).setDescriptionText(t9.a.femaleDay0CompleteSubheader);
        ((NoBagelComponentView) this.f7869c).setButtonText(t9.a.femaleDay0CompleteButton);
        ((NoBagelComponentView) this.f7869c).setButtonClickListener(NoBagelClickOption.DISCOVER);
    }

    /* access modifiers changed from: package-private */
    public void m() {
        ((NoBagelComponentView) this.f7869c).setTitleText(t9.a.femaleDay0IncompleteHeader);
        ((NoBagelComponentView) this.f7869c).setDescriptionText(t9.a.femaleDay0IncompleteSubheader);
        ((NoBagelComponentView) this.f7869c).setButtonText(t9.a.femaleDay0IncompleteButton);
        ((NoBagelComponentView) this.f7869c).setButtonClickListener(NoBagelClickOption.LIKE_PASS);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        ((NoBagelComponentView) this.f7869c).setTitleText(t9.a.maleDay0CompleteHeader);
        ((NoBagelComponentView) this.f7869c).setDescriptionText(t9.a.maleDay0CompleteSubheader);
        ((NoBagelComponentView) this.f7869c).setButtonText(t9.a.maleDay0CompleteButton);
        ((NoBagelComponentView) this.f7869c).setButtonClickListener(NoBagelClickOption.DISCOVER);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        ((NoBagelComponentView) this.f7869c).setTitleText(t9.a.maleDay0IncompleteHeader);
        ((NoBagelComponentView) this.f7869c).setDescriptionText(t9.a.maleDay0IncompleteSubheader);
        ((NoBagelComponentView) this.f7869c).setButtonText(t9.a.maleDay0IncompleteButton);
        ((NoBagelComponentView) this.f7869c).setButtonClickListener(NoBagelClickOption.TIPS);
    }
}
