package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.x;
import androidx.camera.core.q;
import androidx.camera.core.r;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import o.q0;

class i1 {
    private static String a(q0 q0Var, Integer num, List<String> list) throws CameraAccessExceptionCompat {
        if (num == null || !list.contains("0") || !list.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            return null;
        }
        if (num.intValue() == 1) {
            if (((Integer) q0Var.c("0").a(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                return AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
            return null;
        } else if (num.intValue() == 0 && ((Integer) q0Var.c(AppEventsConstants.EVENT_PARAM_VALUE_YES).a(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            return "0";
        } else {
            return null;
        }
    }

    static List<String> b(@NonNull v vVar, r rVar) throws InitializationException {
        String str;
        try {
            ArrayList arrayList = new ArrayList();
            List<String> asList = Arrays.asList(vVar.c().d());
            if (rVar == null) {
                for (String add : asList) {
                    arrayList.add(add);
                }
                return arrayList;
            }
            try {
                str = a(vVar.c(), rVar.d(), asList);
            } catch (IllegalStateException unused) {
                str = null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : asList) {
                if (!str2.equals(str)) {
                    arrayList2.add(vVar.e(str2));
                }
            }
            Iterator<q> it = rVar.b(arrayList2).iterator();
            while (it.hasNext()) {
                arrayList.add(((x) it.next()).a());
            }
            return arrayList;
        } catch (CameraAccessExceptionCompat e10) {
            throw new InitializationException(k1.a(e10));
        } catch (CameraUnavailableException e11) {
            throw new InitializationException(e11);
        }
    }
}
