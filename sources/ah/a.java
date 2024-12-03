package ah;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.p;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final h f18844c = new h("StreamingFormatChecker", "");

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList f18845a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private long f18846b = -1;

    public void a(@NonNull zg.a aVar) {
        if (aVar.g() == -1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f18845a.add(Long.valueOf(elapsedRealtime));
            if (this.f18845a.size() > 5) {
                this.f18845a.removeFirst();
            }
            if (this.f18845a.size() == 5 && elapsedRealtime - ((Long) p.k((Long) this.f18845a.peekFirst())).longValue() < 5000) {
                long j10 = this.f18846b;
                if (j10 == -1 || elapsedRealtime - j10 >= TimeUnit.SECONDS.toMillis(5)) {
                    this.f18846b = elapsedRealtime;
                    f18844c.f("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
                }
            }
        }
    }
}
