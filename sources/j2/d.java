package j2;

import b2.f;
import com.mparticle.kits.AppsFlyerKit;
import g2.i;
import g2.o;
import g2.u;
import g2.x;
import g2.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u001a.\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a1\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lg2/o;", "workNameDao", "Lg2/z;", "workTagDao", "Lg2/j;", "systemIdInfoDao", "", "Lg2/u;", "workSpecs", "", "d", "workSpec", "name", "", "systemId", "tags", "c", "(Lg2/u;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "a", "Ljava/lang/String;", "TAG", "work-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f15551a;

    static {
        String i10 = f.i("DiagnosticsWrkr");
        j.f(i10, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f15551a = i10;
    }

    private static final String c(u uVar, String str, Integer num, String str2) {
        return 10 + uVar.f15077a + "\t " + uVar.f15079c + "\t " + num + "\t " + uVar.f15078b.name() + "\t " + str + "\t " + str2 + 9;
    }

    /* access modifiers changed from: private */
    public static final String d(o oVar, z zVar, g2.j jVar, List<u> list) {
        Integer num;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n Id \t Class Name\t " + "Job Id" + "\t State\t Unique Name\t Tags\t");
        for (u uVar : list) {
            i c10 = jVar.c(x.a(uVar));
            if (c10 != null) {
                num = Integer.valueOf(c10.f15050c);
            } else {
                num = null;
            }
            sb2.append(c(uVar, CollectionsKt___CollectionsKt.W(oVar.b(uVar.f15077a), AppsFlyerKit.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), num, CollectionsKt___CollectionsKt.W(zVar.a(uVar.f15077a), AppsFlyerKit.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
        }
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
