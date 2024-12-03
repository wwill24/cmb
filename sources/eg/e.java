package eg;

import ag.f;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.proto.a;
import hg.t;
import ig.o;
import java.io.IOException;

public final class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences.Editor f23392a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23393b;

    public e(Context context, String str, String str2) {
        if (str != null) {
            this.f23393b = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.f23392a = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
            } else {
                this.f23392a = applicationContext.getSharedPreferences(str2, 0).edit();
            }
        } else {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
    }

    public void a(a aVar) throws IOException {
        if (!this.f23392a.putString(this.f23393b, o.b(aVar.toByteArray())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    public void b(t tVar) throws IOException {
        if (!this.f23392a.putString(this.f23393b, o.b(tVar.toByteArray())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
