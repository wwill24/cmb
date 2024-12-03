package ta;

import com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation;
import gk.h;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final C0507a f41935c = new C0507a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a7.a f41936a;

    /* renamed from: b  reason: collision with root package name */
    private final MyAnswersLocation f41937b;

    /* renamed from: ta.a$a  reason: collision with other inner class name */
    public static final class C0507a {
        private C0507a() {
        }

        public /* synthetic */ C0507a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41938a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation[] r0 = com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation r1 = com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation.PROFILE_READ_ONLY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation r1 = com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation.PROFILE_EDIT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f41938a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ta.a.b.<clinit>():void");
        }
    }

    public a(a7.a aVar, MyAnswersLocation myAnswersLocation) {
        j.g(aVar, "analyticsManager");
        j.g(myAnswersLocation, "location");
        this.f41936a = aVar;
        this.f41937b = myAnswersLocation;
    }

    public final void a() {
        String str;
        int i10 = b.f41938a[this.f41937b.ordinal()];
        if (i10 == 1) {
            str = "my_profile";
        } else if (i10 == 2) {
            str = "manage_profile_prompts";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.f41936a.trackEvent("Add Profile Prompt Tapped", g0.f(h.a("source", str)));
    }

    public final void b() {
        this.f41936a.d("Profile Prompt Deleted");
    }

    public final void c() {
        this.f41936a.d("Profile Prompt Edited");
    }
}
