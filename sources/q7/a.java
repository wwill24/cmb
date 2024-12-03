package q7;

import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.transport.SuccessStatus;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jc.b;

public class a implements a6.a {

    /* renamed from: a  reason: collision with root package name */
    private final ProfileContract$Manager f17188a;

    /* renamed from: b  reason: collision with root package name */
    private String f17189b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f17190c = new HashSet();

    /* renamed from: q7.a$a  reason: collision with other inner class name */
    class C0195a implements b<Void> {
        C0195a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            fa.a.f("CMB:Coachmarks", "Failed to update coachmarks: " + cmbErrorCode.getErrorMessage());
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
        }
    }

    public a(ProfileContract$Manager profileContract$Manager) {
        this.f17188a = profileContract$Manager;
    }

    public boolean a(String str) {
        NetworkProfile j10 = this.f17188a.j();
        if (j10 == null) {
            return true;
        }
        String str2 = this.f17189b;
        if (str2 != null && !str2.equals(j10.getId())) {
            this.f17190c.clear();
        }
        if (this.f17190c.contains(str)) {
            return true;
        }
        List<String> viewedCoachmarks = j10.getViewedCoachmarks();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("viewedCoachmarks: ");
        sb2.append(viewedCoachmarks);
        if (viewedCoachmarks == null || !viewedCoachmarks.contains(str)) {
            return false;
        }
        return true;
    }

    public void b(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("coachMark=");
        sb2.append(str);
        NetworkProfile j10 = this.f17188a.j();
        if (j10 != null) {
            List viewedCoachmarks = j10.getViewedCoachmarks();
            if (viewedCoachmarks == null) {
                viewedCoachmarks = new ArrayList();
            }
            if (!viewedCoachmarks.contains(str)) {
                viewedCoachmarks.add(str);
            }
            String str2 = this.f17189b;
            if (str2 != null && !str2.equals(j10.getId())) {
                this.f17190c.clear();
            }
            this.f17190c.add(str);
            this.f17189b = j10.getId();
            j10.setViewedCoachmarks(viewedCoachmarks);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("updating coachmarks: ");
            sb3.append(viewedCoachmarks);
            ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
            modelProfileUpdateDelta.updateViewedCoachMarks(viewedCoachmarks);
            this.f17188a.p(new C0195a(), modelProfileUpdateDelta, true);
        }
    }
}
