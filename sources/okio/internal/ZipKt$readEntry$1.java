package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import okio.BufferedSource;
import org.jivesoftware.smack.datatypes.UInt32;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "headerId", "", "dataSize", "", "a", "(IJ)V"}, k = 3, mv = {1, 6, 0})
final class ZipKt$readEntry$1 extends Lambda implements Function2<Integer, Long, Unit> {
    final /* synthetic */ Ref$LongRef $compressedSize;
    final /* synthetic */ Ref$BooleanRef $hasZip64Extra;
    final /* synthetic */ Ref$LongRef $offset;
    final /* synthetic */ long $requiredZip64ExtraSize;
    final /* synthetic */ Ref$LongRef $size;
    final /* synthetic */ BufferedSource $this_readEntry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZipKt$readEntry$1(Ref$BooleanRef ref$BooleanRef, long j10, Ref$LongRef ref$LongRef, BufferedSource bufferedSource, Ref$LongRef ref$LongRef2, Ref$LongRef ref$LongRef3) {
        super(2);
        this.$hasZip64Extra = ref$BooleanRef;
        this.$requiredZip64ExtraSize = j10;
        this.$size = ref$LongRef;
        this.$this_readEntry = bufferedSource;
        this.$compressedSize = ref$LongRef2;
        this.$offset = ref$LongRef3;
    }

    public final void a(int i10, long j10) {
        long j11;
        if (i10 == 1) {
            Ref$BooleanRef ref$BooleanRef = this.$hasZip64Extra;
            if (!ref$BooleanRef.element) {
                ref$BooleanRef.element = true;
                if (j10 >= this.$requiredZip64ExtraSize) {
                    Ref$LongRef ref$LongRef = this.$size;
                    long j12 = ref$LongRef.element;
                    if (j12 == UInt32.MAX_VALUE_LONG) {
                        j12 = this.$this_readEntry.D0();
                    }
                    ref$LongRef.element = j12;
                    Ref$LongRef ref$LongRef2 = this.$compressedSize;
                    long j13 = 0;
                    if (ref$LongRef2.element == UInt32.MAX_VALUE_LONG) {
                        j11 = this.$this_readEntry.D0();
                    } else {
                        j11 = 0;
                    }
                    ref$LongRef2.element = j11;
                    Ref$LongRef ref$LongRef3 = this.$offset;
                    if (ref$LongRef3.element == UInt32.MAX_VALUE_LONG) {
                        j13 = this.$this_readEntry.D0();
                    }
                    ref$LongRef3.element = j13;
                    return;
                }
                throw new IOException("bad zip: zip64 extra too short");
            }
            throw new IOException("bad zip: zip64 extra repeated");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a(((Number) obj).intValue(), ((Number) obj2).longValue());
        return Unit.f32013a;
    }
}
