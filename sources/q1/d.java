package q1;

import com.mparticle.kits.AppsFlyerKit;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.description.type.TypeDescription;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\"\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078\u0006X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\t\u0012\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Ljava/lang/StringBuilder;", "b", "builder", "", "count", "", "a", "", "", "[Ljava/lang/String;", "getEMPTY_STRING_ARRAY$annotations", "()V", "EMPTY_STRING_ARRAY", "room-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f17094a = new String[0];

    public static final void a(StringBuilder sb2, int i10) {
        j.g(sb2, "builder");
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            if (i11 < i10 - 1) {
                sb2.append(AppsFlyerKit.COMMA);
            }
        }
    }

    public static final StringBuilder b() {
        return new StringBuilder();
    }
}
