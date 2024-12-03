package okio.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.Buffer;
import okio.Options;
import okio.Segment;
import okio._JvmPlatformKt;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a0\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u0000\" \u0010\u0018\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0019"}, d2 = {"Lokio/Segment;", "segment", "", "segmentPos", "", "bytes", "bytesOffset", "bytesLimit", "", "b", "Lokio/Buffer;", "", "newline", "", "c", "Lokio/Options;", "options", "selectTruncated", "d", "a", "[B", "()[B", "getHEX_DIGIT_BYTES$annotations", "()V", "HEX_DIGIT_BYTES", "okio"}, k = 2, mv = {1, 6, 0})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f33464a = _JvmPlatformKt.a("0123456789abcdef");

    public static final byte[] a() {
        return f33464a;
    }

    public static final boolean b(Segment segment, int i10, byte[] bArr, int i11, int i12) {
        j.g(segment, "segment");
        j.g(bArr, "bytes");
        int i13 = segment.f33410c;
        byte[] bArr2 = segment.f33408a;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.f33413f;
                j.d(segment);
                byte[] bArr3 = segment.f33408a;
                int i14 = segment.f33409b;
                bArr2 = bArr3;
                i10 = i14;
                i13 = segment.f33410c;
            }
            if (bArr2[i10] != bArr[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static final String c(Buffer buffer, long j10) {
        j.g(buffer, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (buffer.l(j11) == ((byte) 13)) {
                String L0 = buffer.L0(j11);
                buffer.skip(2);
                return L0;
            }
        }
        String L02 = buffer.L0(j10);
        buffer.skip(1);
        return L02;
    }

    public static final int d(Buffer buffer, Options options, boolean z10) {
        int i10;
        int i11;
        boolean z11;
        int i12;
        Segment segment;
        int i13;
        Buffer buffer2 = buffer;
        j.g(buffer2, "<this>");
        j.g(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        Segment segment2 = buffer2.f33298a;
        if (segment2 != null) {
            byte[] bArr = segment2.f33408a;
            int i14 = segment2.f33409b;
            int i15 = segment2.f33410c;
            int[] j10 = options.j();
            Segment segment3 = segment2;
            int i16 = -1;
            int i17 = 0;
            loop0:
            while (true) {
                int i18 = i17 + 1;
                int i19 = j10[i17];
                int i20 = i18 + 1;
                int i21 = j10[i18];
                if (i21 != -1) {
                    i16 = i21;
                }
                if (segment3 == null) {
                    break;
                }
                if (i19 < 0) {
                    int i22 = i20 + (i19 * -1);
                    while (true) {
                        int i23 = i14 + 1;
                        int i24 = i20 + 1;
                        if ((bArr[i14] & 255) != j10[i20]) {
                            return i16;
                        }
                        if (i24 == i22) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (i23 == i15) {
                            j.d(segment3);
                            Segment segment4 = segment3.f33413f;
                            j.d(segment4);
                            i13 = segment4.f33409b;
                            byte[] bArr2 = segment4.f33408a;
                            i12 = segment4.f33410c;
                            if (segment4 == segment2) {
                                if (!z11) {
                                    break loop0;
                                }
                                bArr = bArr2;
                                segment = null;
                            } else {
                                byte[] bArr3 = bArr2;
                                segment = segment4;
                                bArr = bArr3;
                            }
                        } else {
                            Segment segment5 = segment3;
                            i12 = i15;
                            i13 = i23;
                            segment = segment5;
                        }
                        if (z11) {
                            i11 = j10[i24];
                            i10 = i13;
                            i15 = i12;
                            segment3 = segment;
                            break;
                        }
                        i14 = i13;
                        i15 = i12;
                        i20 = i24;
                        segment3 = segment;
                    }
                } else {
                    i10 = i14 + 1;
                    byte b10 = bArr[i14] & 255;
                    int i25 = i20 + i19;
                    while (i20 != i25) {
                        if (b10 == j10[i20]) {
                            i11 = j10[i20 + i19];
                            if (i10 == i15) {
                                segment3 = segment3.f33413f;
                                j.d(segment3);
                                i10 = segment3.f33409b;
                                bArr = segment3.f33408a;
                                i15 = segment3.f33410c;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            }
                        } else {
                            i20++;
                        }
                    }
                    return i16;
                }
                if (i11 >= 0) {
                    return i11;
                }
                i17 = -i11;
                i14 = i10;
            }
            if (z10) {
                return -2;
            }
            return i16;
        } else if (z10) {
            return -2;
        } else {
            return -1;
        }
    }

    public static /* synthetic */ int e(Buffer buffer, Options options, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return d(buffer, options, z10);
    }
}
