package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.p;
import androidx.core.graphics.drawable.IconCompat;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;

class h0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4431a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f4432b = new Object();

    static Bundle a(p.a aVar) {
        int i10;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat d10 = aVar.d();
        if (d10 != null) {
            i10 = d10.j();
        } else {
            i10 = 0;
        }
        bundle2.putInt(SoftwareInfoForm.ICON, i10);
        bundle2.putCharSequence("title", aVar.h());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.c() != null) {
            bundle = new Bundle(aVar.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle2.putBoolean("showsUserInterface", aVar.g());
        bundle2.putInt("semanticAction", aVar.f());
        return bundle2;
    }

    private static Bundle b(o0 o0Var) {
        new Bundle();
        throw null;
    }

    private static Bundle[] c(o0[] o0VarArr) {
        if (o0VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[o0VarArr.length];
        for (int i10 = 0; i10 < o0VarArr.length; i10++) {
            o0 o0Var = o0VarArr[i10];
            bundleArr[i10] = b((o0) null);
        }
        return bundleArr;
    }
}
