package l9;

import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.NetworkProfile;

public class e {
    /* access modifiers changed from: package-private */
    public boolean a(int i10, t tVar, NetworkProfile networkProfile, double d10) {
        if (i10 <= 9) {
            if (!networkProfile.isFemale() || d10 > ((double) tVar.f()) / 100.0d) {
                return false;
            }
            return true;
        } else if (i10 <= 24) {
            if (networkProfile.isMale()) {
                if (d10 <= ((double) tVar.q()) / 100.0d) {
                    return true;
                }
            } else if (d10 <= ((double) tVar.i()) / 100.0d) {
                return true;
            }
            return false;
        } else if (i10 <= 49) {
            if (networkProfile.isMale()) {
                if (d10 <= ((double) tVar.w()) / 100.0d) {
                    return true;
                }
            } else if (d10 <= ((double) tVar.c()) / 100.0d) {
                return true;
            }
            return false;
        } else if (i10 <= 99) {
            if (networkProfile.isMale()) {
                if (d10 <= ((double) tVar.g()) / 100.0d) {
                    return true;
                }
            } else if (d10 <= ((double) tVar.u()) / 100.0d) {
                return true;
            }
            return false;
        } else if (i10 <= 199) {
            if (networkProfile.isMale()) {
                if (d10 <= ((double) tVar.l()) / 100.0d) {
                    return true;
                }
            } else if (d10 <= ((double) tVar.h()) / 100.0d) {
                return true;
            }
            return false;
        } else {
            if (networkProfile.isMale()) {
                if (d10 <= ((double) tVar.j()) / 100.0d) {
                    return true;
                }
            } else if (d10 <= ((double) tVar.h()) / 100.0d) {
                return true;
            }
            return false;
        }
    }

    public boolean b(int i10, t tVar, ProfileContract$Manager profileContract$Manager) {
        NetworkProfile j10 = profileContract$Manager.j();
        if (j10 == null || i10 < 5) {
            return false;
        }
        return a(i10, tVar, j10, Math.random());
    }
}
