package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlinx.coroutines.internal.f0;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\" \u0010\u0007\u001a\u00020\u00008\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\" \u0010\u000b\u001a\u00020\u00008\u0000X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0002\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\t\u0010\u0004\"\u001a\u0010\u000e\u001a\u00020\u00008\u0002X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0002\u0012\u0004\b\r\u0010\u0006\"\u001a\u0010\u0010\u001a\u00020\u00008\u0002X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0002\u0012\u0004\b\u000f\u0010\u0006\"\u001a\u0010\u0014\u001a\u00020\u00118\u0002X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u0012\u0004\b\u0013\u0010\u0006¨\u0006\u0015"}, d2 = {"", "a", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "getNOT_SELECTED$annotations", "()V", "NOT_SELECTED", "b", "d", "getALREADY_SELECTED$annotations", "ALREADY_SELECTED", "c", "getUNDECIDED$annotations", "UNDECIDED", "getRESUMED$annotations", "RESUMED", "Lkotlinx/coroutines/selects/f;", "Lkotlinx/coroutines/selects/f;", "getSelectOpSequenceNumber$annotations", "selectOpSequenceNumber", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f32684a = new f0("NOT_SELECTED");

    /* renamed from: b  reason: collision with root package name */
    private static final Object f32685b = new f0("ALREADY_SELECTED");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Object f32686c = new f0("UNDECIDED");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Object f32687d = new f0("RESUMED");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final f f32688e = new f();

    public static final Object d() {
        return f32685b;
    }

    public static final Object e() {
        return f32684a;
    }
}
