package ce;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.internal.p002authapi.zbbb;

public final class g extends f {

    /* renamed from: a  reason: collision with root package name */
    private final GoogleSignInOptions f34060a;

    public g(Context context, Looper looper, e eVar, GoogleSignInOptions googleSignInOptions, d.b bVar, d.c cVar) {
        super(context, looper, 91, eVar, bVar, cVar);
        GoogleSignInOptions.a aVar;
        if (googleSignInOptions != null) {
            aVar = new GoogleSignInOptions.a(googleSignInOptions);
        } else {
            aVar = new GoogleSignInOptions.a();
        }
        aVar.e(zbbb.zba());
        if (!eVar.d().isEmpty()) {
            for (Scope d10 : eVar.d()) {
                aVar.d(d10, new Scope[0]);
            }
        }
        this.f34060a = aVar.a();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface instanceof s) {
            return (s) queryLocalInterface;
        }
        return new s(iBinder);
    }

    public final GoogleSignInOptions e() {
        return this.f34060a;
    }

    public final int getMinApkVersion() {
        return com.google.android.gms.common.e.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public final Intent getSignInIntent() {
        return m.a(getContext(), this.f34060a);
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    public final boolean providesSignIn() {
        return true;
    }
}
