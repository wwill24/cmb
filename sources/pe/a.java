package pe;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzb;

public interface a extends IInterface {

    /* renamed from: pe.a$a  reason: collision with other inner class name */
    public static abstract class C0503a extends zzb implements a {
        public C0503a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @NonNull
        public static a c(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new c(iBinder);
        }
    }
}
