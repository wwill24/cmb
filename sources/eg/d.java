package eg;

import ag.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.proto.a;
import hg.t;
import ig.o;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f23390a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23391b;

    public d(Context context, String str, String str2) throws IOException {
        if (str != null) {
            this.f23391b = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.f23390a = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            } else {
                this.f23390a = applicationContext.getSharedPreferences(str2, 0);
            }
        } else {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
    }

    private byte[] b() throws IOException {
        try {
            String string = this.f23390a.getString(this.f23391b, (String) null);
            if (string != null) {
                return o.a(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", new Object[]{this.f23391b}));
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", new Object[]{this.f23391b}));
        }
    }

    public t a() throws IOException {
        return t.H(b(), com.google.crypto.tink.shaded.protobuf.o.b());
    }

    public a read() throws IOException {
        return a.M(b(), com.google.crypto.tink.shaded.protobuf.o.b());
    }
}
