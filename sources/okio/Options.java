package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0019B!\b\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002R\"\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b8\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0014¨\u0006\u001a"}, d2 = {"Lokio/Options;", "Lkotlin/collections/b;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", "f", "", "b", "[Lokio/ByteString;", "g", "()[Lokio/ByteString;", "byteStrings", "", "c", "[I", "j", "()[I", "trie", "()I", "size", "<init>", "([Lokio/ByteString;[I)V", "d", "Companion", "okio"}, k = 1, mv = {1, 6, 0})
public final class Options extends b<ByteString> implements RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f33374d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final ByteString[] f33375b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f33376c;

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J#\u0010\u0012\u001a\u00020\u00112\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0010\"\u00020\tH\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u00020\u0002*\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lokio/Options$Companion;", "", "", "nodeOffset", "Lokio/Buffer;", "node", "", "byteStringOffset", "", "Lokio/ByteString;", "byteStrings", "fromIndex", "toIndex", "indexes", "", "a", "", "Lokio/Options;", "d", "([Lokio/ByteString;)Lokio/Options;", "c", "(Lokio/Buffer;)J", "intCount", "<init>", "()V", "okio"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(long j10, Buffer buffer, int i10, List<? extends ByteString> list, int i11, int i12, List<Integer> list2) {
            boolean z10;
            int i13;
            int i14;
            boolean z11;
            int i15;
            int i16;
            Buffer buffer2;
            boolean z12;
            Buffer buffer3 = buffer;
            int i17 = i10;
            List<? extends ByteString> list3 = list;
            int i18 = i11;
            int i19 = i12;
            List<Integer> list4 = list2;
            if (i18 < i19) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                int i20 = i18;
                while (i20 < i19) {
                    if (((ByteString) list3.get(i20)).H() >= i17) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        i20++;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = (ByteString) list.get(i11);
                ByteString byteString2 = (ByteString) list3.get(i19 - 1);
                int i21 = -1;
                if (i17 == byteString.H()) {
                    int intValue = list4.get(i18).intValue();
                    int i22 = i18 + 1;
                    i13 = i22;
                    i14 = intValue;
                    byteString = (ByteString) list3.get(i22);
                } else {
                    i13 = i18;
                    i14 = -1;
                }
                if (byteString.i(i17) != byteString2.i(i17)) {
                    int i23 = 1;
                    for (int i24 = i13 + 1; i24 < i19; i24++) {
                        if (((ByteString) list3.get(i24 - 1)).i(i17) != ((ByteString) list3.get(i24)).i(i17)) {
                            i23++;
                        }
                    }
                    long c10 = j10 + c(buffer3) + ((long) 2) + ((long) (i23 * 2));
                    buffer3.writeInt(i23);
                    buffer3.writeInt(i14);
                    for (int i25 = i13; i25 < i19; i25++) {
                        byte i26 = ((ByteString) list3.get(i25)).i(i17);
                        if (i25 == i13 || i26 != ((ByteString) list3.get(i25 - 1)).i(i17)) {
                            buffer3.writeInt(i26 & 255);
                        }
                    }
                    Buffer buffer4 = new Buffer();
                    while (i13 < i19) {
                        byte i27 = ((ByteString) list3.get(i13)).i(i17);
                        int i28 = i13 + 1;
                        int i29 = i28;
                        while (true) {
                            if (i29 >= i19) {
                                i15 = i19;
                                break;
                            } else if (i27 != ((ByteString) list3.get(i29)).i(i17)) {
                                i15 = i29;
                                break;
                            } else {
                                i29++;
                            }
                        }
                        if (i28 == i15 && i17 + 1 == ((ByteString) list3.get(i13)).H()) {
                            buffer3.writeInt(list4.get(i13).intValue());
                            i16 = i15;
                            buffer2 = buffer4;
                        } else {
                            buffer3.writeInt(((int) (c10 + c(buffer4))) * i21);
                            i16 = i15;
                            buffer2 = buffer4;
                            a(c10, buffer4, i17 + 1, list, i13, i15, list2);
                        }
                        buffer4 = buffer2;
                        i13 = i16;
                        i21 = -1;
                    }
                    buffer3.o0(buffer4);
                    return;
                }
                int min = Math.min(byteString.H(), byteString2.H());
                int i30 = i17;
                int i31 = 0;
                while (i30 < min && byteString.i(i30) == byteString2.i(i30)) {
                    i31++;
                    i30++;
                }
                long c11 = j10 + c(buffer3) + ((long) 2) + ((long) i31) + 1;
                buffer3.writeInt(-i31);
                buffer3.writeInt(i14);
                int i32 = i17 + i31;
                while (i17 < i32) {
                    buffer3.writeInt(byteString.i(i17) & 255);
                    i17++;
                }
                if (i13 + 1 == i19) {
                    if (i32 == ((ByteString) list3.get(i13)).H()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        buffer3.writeInt(list4.get(i13).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer5 = new Buffer();
                buffer3.writeInt(((int) (c(buffer5) + c11)) * -1);
                a(c11, buffer5, i32, list, i13, i12, list2);
                buffer3.o0(buffer5);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void b(Companion companion, long j10, Buffer buffer, int i10, List list, int i11, int i12, List list2, int i13, Object obj) {
            long j11;
            int i14;
            int i15;
            int i16;
            if ((i13 & 1) != 0) {
                j11 = 0;
            } else {
                j11 = j10;
            }
            if ((i13 & 4) != 0) {
                i14 = 0;
            } else {
                i14 = i10;
            }
            if ((i13 & 16) != 0) {
                i15 = 0;
            } else {
                i15 = i11;
            }
            if ((i13 & 32) != 0) {
                i16 = list.size();
            } else {
                i16 = i12;
            }
            companion.a(j11, buffer, i14, list, i15, i16, list2);
        }

        private final long c(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        public final Options d(ByteString... byteStringArr) {
            boolean z10;
            boolean z11;
            boolean z12;
            ByteString[] byteStringArr2 = byteStringArr;
            j.g(byteStringArr2, "byteStrings");
            int i10 = 0;
            if (byteStringArr2.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return new Options(new ByteString[0], new int[]{0, -1}, (DefaultConstructorMarker) null);
            }
            List w02 = l.w0(byteStringArr);
            u.v(w02);
            ArrayList arrayList = new ArrayList(byteStringArr2.length);
            for (ByteString byteString : byteStringArr2) {
                arrayList.add(-1);
            }
            Object[] array2 = arrayList.toArray(new Integer[0]);
            if (array2 != null) {
                Integer[] numArr = (Integer[]) array2;
                List p10 = q.p(Arrays.copyOf(numArr, numArr.length));
                int length = byteStringArr2.length;
                int i11 = 0;
                int i12 = 0;
                while (i11 < length) {
                    p10.set(q.i(w02, byteStringArr2[i11], 0, 0, 6, (Object) null), Integer.valueOf(i12));
                    i11++;
                    i12++;
                }
                if (((ByteString) w02.get(0)).H() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    int i13 = 0;
                    while (i13 < w02.size()) {
                        ByteString byteString2 = (ByteString) w02.get(i13);
                        int i14 = i13 + 1;
                        int i15 = i14;
                        while (i15 < w02.size()) {
                            ByteString byteString3 = (ByteString) w02.get(i15);
                            if (!byteString3.I(byteString2)) {
                                continue;
                                break;
                            }
                            if (byteString3.H() != byteString2.H()) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (!z12) {
                                throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                            } else if (((Number) p10.get(i15)).intValue() > ((Number) p10.get(i13)).intValue()) {
                                w02.remove(i15);
                                p10.remove(i15);
                            } else {
                                i15++;
                            }
                        }
                        i13 = i14;
                    }
                    Buffer buffer = new Buffer();
                    b(this, 0, buffer, 0, w02, 0, 0, p10, 53, (Object) null);
                    int[] iArr = new int[((int) c(buffer))];
                    while (!buffer.Y0()) {
                        iArr[i10] = buffer.readInt();
                        i10++;
                    }
                    Object[] copyOf = Arrays.copyOf(byteStringArr2, byteStringArr2.length);
                    j.f(copyOf, "copyOf(this, size)");
                    return new Options((ByteString[]) copyOf, iArr, (DefaultConstructorMarker) null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.f33375b = byteStringArr;
        this.f33376c = iArr;
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    public static final Options o(ByteString... byteStringArr) {
        return f33374d.d(byteStringArr);
    }

    public int b() {
        return this.f33375b.length;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return d((ByteString) obj);
    }

    public /* bridge */ boolean d(ByteString byteString) {
        return super.contains(byteString);
    }

    /* renamed from: f */
    public ByteString get(int i10) {
        return this.f33375b[i10];
    }

    public final ByteString[] g() {
        return this.f33375b;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return m((ByteString) obj);
    }

    public final int[] j() {
        return this.f33376c;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return n((ByteString) obj);
    }

    public /* bridge */ int m(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int n(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }
}
