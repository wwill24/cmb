package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.core.content.g;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.Calendar;

class t {

    /* renamed from: d  reason: collision with root package name */
    private static t f606d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f607a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f608b;

    /* renamed from: c  reason: collision with root package name */
    private final a f609c = new a();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f610a;

        /* renamed from: b  reason: collision with root package name */
        long f611b;

        a() {
        }
    }

    t(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.f607a = context;
        this.f608b = locationManager;
    }

    static t a(@NonNull Context context) {
        if (f606d == null) {
            Context applicationContext = context.getApplicationContext();
            f606d = new t(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f606d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location;
        Location location2 = null;
        if (g.b(this.f607a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = c("network");
        } else {
            location = null;
        }
        if (g.b(this.f607a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = c("gps");
        }
        if (location2 == null || location == null) {
            if (location2 != null) {
                return location2;
            }
            return location;
        } else if (location2.getTime() > location.getTime()) {
            return location2;
        } else {
            return location;
        }
    }

    private Location c(String str) {
        try {
            if (this.f608b.isProviderEnabled(str)) {
                return this.f608b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean e() {
        return this.f609c.f611b > System.currentTimeMillis();
    }

    private void f(@NonNull Location location) {
        long j10;
        long j11;
        a aVar = this.f609c;
        long currentTimeMillis = System.currentTimeMillis();
        s b10 = s.b();
        s sVar = b10;
        sVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        sVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = true;
        if (b10.f605c != 1) {
            z10 = false;
        }
        boolean z11 = z10;
        long j12 = b10.f604b;
        long j13 = b10.f603a;
        long j14 = j13;
        double latitude = location.getLatitude();
        long j15 = j12;
        b10.a(currentTimeMillis + 86400000, latitude, location.getLongitude());
        long j16 = b10.f604b;
        if (j15 == -1 || j14 == -1) {
            j10 = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j14) {
                j11 = j16 + 0;
            } else if (currentTimeMillis > j15) {
                j11 = j14 + 0;
            } else {
                j11 = j15 + 0;
            }
            j10 = j11 + DateUtils.MILLIS_IN_MINUTE;
        }
        aVar.f610a = z11;
        aVar.f611b = j10;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f609c;
        if (e()) {
            return aVar.f610a;
        }
        Location b10 = b();
        if (b10 != null) {
            f(b10);
            return aVar.f610a;
        }
        int i10 = Calendar.getInstance().get(11);
        if (i10 < 6 || i10 >= 22) {
            return true;
        }
        return false;
    }
}
