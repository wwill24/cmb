package be;

import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;

public class b implements j {

    /* renamed from: a  reason: collision with root package name */
    private Status f34038a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInAccount f34039b;

    public GoogleSignInAccount a() {
        return this.f34039b;
    }

    @NonNull
    public Status getStatus() {
        return this.f34038a;
    }
}
