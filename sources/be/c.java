package be;

import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f34040a = new c();

    private /* synthetic */ c() {
    }

    public final int compare(Object obj, Object obj2) {
        Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
        return ((Scope) obj).S().compareTo(((Scope) obj2).S());
    }
}
