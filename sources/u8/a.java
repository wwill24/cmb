package u8;

import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.transport.SuccessStatus;
import jc.b;
import x8.e;

public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final ProfileContract$Manager f18018a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a7.a f18019b;

    /* renamed from: u8.a$a  reason: collision with other inner class name */
    class C0212a implements b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18020a;

        C0212a(String str) {
            this.f18020a = str;
        }

        public void b(CmbErrorCode cmbErrorCode) {
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            a.this.f18019b.c("Orientation", this.f18020a);
        }
    }

    public a(ProfileContract$Manager profileContract$Manager, a7.a aVar) {
        this.f18018a = profileContract$Manager;
        this.f18019b = aVar;
    }

    public void U(String str, String str2) {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateCriteriaGender(str);
        this.f18018a.p(new C0212a(str2), modelProfileUpdateDelta, true);
    }

    public void start() {
    }

    public void stop() {
    }
}
