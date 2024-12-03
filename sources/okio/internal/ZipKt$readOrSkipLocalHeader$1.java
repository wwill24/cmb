package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.BufferedSource;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "headerId", "", "dataSize", "", "a", "(IJ)V"}, k = 3, mv = {1, 6, 0})
final class ZipKt$readOrSkipLocalHeader$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ Ref$ObjectRef<Long> $createdAtMillis;
    final /* synthetic */ Ref$ObjectRef<Long> $lastAccessedAtMillis;
    final /* synthetic */ Ref$ObjectRef<Long> $lastModifiedAtMillis;
    final /* synthetic */ BufferedSource $this_readOrSkipLocalHeader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZipKt$readOrSkipLocalHeader$1(BufferedSource bufferedSource, Ref$ObjectRef<Long> ref$ObjectRef, Ref$ObjectRef<Long> ref$ObjectRef2, Ref$ObjectRef<Long> ref$ObjectRef3) {
        super(2);
        this.$this_readOrSkipLocalHeader = bufferedSource;
        this.$lastModifiedAtMillis = ref$ObjectRef;
        this.$lastAccessedAtMillis = ref$ObjectRef2;
        this.$createdAtMillis = ref$ObjectRef3;
    }

    public final void a(int i10, long j10) {
        boolean z10;
        boolean z11;
        if (i10 == 21589) {
            long j11 = 1;
            if (j10 >= 1) {
                byte readByte = this.$this_readOrSkipLocalHeader.readByte() & 255;
                boolean z12 = false;
                if ((readByte & 1) == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((readByte & 2) == 2) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((readByte & 4) == 4) {
                    z12 = true;
                }
                BufferedSource bufferedSource = this.$this_readOrSkipLocalHeader;
                if (z10) {
                    j11 = 5;
                }
                if (z11) {
                    j11 += 4;
                }
                if (z12) {
                    j11 += 4;
                }
                if (j10 >= j11) {
                    if (z10) {
                        this.$lastModifiedAtMillis.element = Long.valueOf(((long) bufferedSource.D1()) * 1000);
                    }
                    if (z11) {
                        this.$lastAccessedAtMillis.element = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.D1()) * 1000);
                    }
                    if (z12) {
                        this.$createdAtMillis.element = Long.valueOf(((long) this.$this_readOrSkipLocalHeader.D1()) * 1000);
                        return;
                    }
                    return;
                }
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            throw new IOException("bad zip: extended timestamp extra too short");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.f32013a;
    }
}
