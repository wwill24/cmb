package el;

import com.mparticle.kits.MPSideloadedKit;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lel/a;", "task", "Lel/d;", "queue", "", "message", "", "c", "", "ns", "b", "okhttp"}, k = 2, mv = {1, 6, 0})
public final class b {
    public static final String b(long j10) {
        String str;
        if (j10 <= -999500000) {
            str = ((j10 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j10 <= -999500) {
            str = ((j10 - ((long) 500000)) / ((long) MPSideloadedKit.MIN_SIDELOADED_KIT)) + " ms";
        } else if (j10 <= 0) {
            str = ((j10 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j10 < 999500) {
            str = ((j10 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j10 < 999500000) {
            str = ((j10 + ((long) 500000)) / ((long) MPSideloadedKit.MIN_SIDELOADED_KIT)) + " ms";
        } else {
            str = ((j10 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        o oVar = o.f32141a;
        String format2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        j.f(format2, "format(format, *args)");
        return format2;
    }

    /* access modifiers changed from: private */
    public static final void c(a aVar, d dVar, String str) {
        Logger a10 = e.f29629h.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dVar.f());
        sb2.append(' ');
        o oVar = o.f32141a;
        String format2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        j.f(format2, "format(format, *args)");
        sb2.append(format2);
        sb2.append(": ");
        sb2.append(aVar.b());
        a10.fine(sb2.toString());
    }
}
