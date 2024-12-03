package p6;

import b6.p;
import com.coffeemeetsbagel.discover_feed.empty.DiscoverFeedEmptyView;
import com.coffeemeetsbagel.discover_feed.empty.EmptyScreenAction;

public class k extends p<DiscoverFeedEmptyView> {

    /* renamed from: e  reason: collision with root package name */
    private h f17044e;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17045a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.coffeemeetsbagel.discover_feed.empty.EmptyScreenAction[] r0 = com.coffeemeetsbagel.discover_feed.empty.EmptyScreenAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17045a = r0
                com.coffeemeetsbagel.discover_feed.empty.EmptyScreenAction r1 = com.coffeemeetsbagel.discover_feed.empty.EmptyScreenAction.MODIFY_FILTERS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17045a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.discover_feed.empty.EmptyScreenAction r1 = com.coffeemeetsbagel.discover_feed.empty.EmptyScreenAction.RESET_FILTERS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p6.k.a.<clinit>():void");
        }
    }

    public k(DiscoverFeedEmptyView discoverFeedEmptyView, h hVar) {
        super(discoverFeedEmptyView);
        this.f17044e = hVar;
    }

    /* access modifiers changed from: private */
    public void k(EmptyScreenAction emptyScreenAction) {
        int i10 = a.f17045a[emptyScreenAction.ordinal()];
        if (i10 == 1) {
            this.f17044e.Z0();
        } else if (i10 == 2) {
            this.f17044e.b0();
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((DiscoverFeedEmptyView) g()).D().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new j(this));
    }

    public void l(boolean z10) {
        ((DiscoverFeedEmptyView) this.f7869c).I(z10);
    }
}
