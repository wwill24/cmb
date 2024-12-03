package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f4395a = (IconCompat) aVar.v(remoteActionCompat.f4395a, 1);
        remoteActionCompat.f4396b = aVar.l(remoteActionCompat.f4396b, 2);
        remoteActionCompat.f4397c = aVar.l(remoteActionCompat.f4397c, 3);
        remoteActionCompat.f4398d = (PendingIntent) aVar.r(remoteActionCompat.f4398d, 4);
        remoteActionCompat.f4399e = aVar.h(remoteActionCompat.f4399e, 5);
        remoteActionCompat.f4400f = aVar.h(remoteActionCompat.f4400f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f4395a, 1);
        aVar.D(remoteActionCompat.f4396b, 2);
        aVar.D(remoteActionCompat.f4397c, 3);
        aVar.H(remoteActionCompat.f4398d, 4);
        aVar.z(remoteActionCompat.f4399e, 5);
        aVar.z(remoteActionCompat.f4400f, 6);
    }
}
