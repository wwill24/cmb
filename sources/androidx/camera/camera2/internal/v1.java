package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.Size;
import android.view.Display;
import androidx.annotation.NonNull;
import r.j;

public class v1 {

    /* renamed from: d  reason: collision with root package name */
    private static final Size f2001d = new Size(1920, 1080);

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2002e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static volatile v1 f2003f;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DisplayManager f2004a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Size f2005b = null;

    /* renamed from: c  reason: collision with root package name */
    private final j f2006c = new j();

    private v1(@NonNull Context context) {
        this.f2004a = (DisplayManager) context.getSystemService("display");
    }

    private Size a() {
        Size size;
        Point point = new Point();
        c().getRealSize(point);
        if (point.x > point.y) {
            size = new Size(point.x, point.y);
        } else {
            size = new Size(point.y, point.x);
        }
        int width = size.getWidth() * size.getHeight();
        Size size2 = f2001d;
        if (width > size2.getWidth() * size2.getHeight()) {
            size = size2;
        }
        return this.f2006c.a(size);
    }

    @NonNull
    public static v1 b(@NonNull Context context) {
        if (f2003f == null) {
            synchronized (f2002e) {
                if (f2003f == null) {
                    f2003f = new v1(context);
                }
            }
        }
        return f2003f;
    }

    @NonNull
    public Display c() {
        Display[] displays = this.f2004a.getDisplays();
        if (displays.length == 1) {
            return displays[0];
        }
        Display display = null;
        int i10 = -1;
        for (Display display2 : displays) {
            if (display2.getState() != 1) {
                Point point = new Point();
                display2.getRealSize(point);
                int i11 = point.x;
                int i12 = point.y;
                if (i11 * i12 > i10) {
                    display = display2;
                    i10 = i11 * i12;
                }
            }
        }
        if (display != null) {
            return display;
        }
        throw new IllegalArgumentException("No display can be found from the input display manager!");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Size d() {
        if (this.f2005b != null) {
            return this.f2005b;
        }
        this.f2005b = a();
        return this.f2005b;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f2005b = a();
    }
}
