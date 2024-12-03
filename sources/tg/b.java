package tg;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.mlkit_common.zzaa;
import com.google.android.gms.internal.mlkit_common.zzz;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;

public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    private static final Map f24617e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public static final Map f24618f;

    /* renamed from: a  reason: collision with root package name */
    private final String f24619a;

    /* renamed from: b  reason: collision with root package name */
    private final BaseModel f24620b;

    /* renamed from: c  reason: collision with root package name */
    private final ModelType f24621c;

    /* renamed from: d  reason: collision with root package name */
    private String f24622d;

    static {
        Class<BaseModel> cls = BaseModel.class;
        f24617e = new EnumMap(cls);
        f24618f = new EnumMap(cls);
    }

    @NonNull
    public String a() {
        return this.f24622d;
    }

    @NonNull
    public String b() {
        String str = this.f24619a;
        return str != null ? str : (String) f24618f.get(this.f24620b);
    }

    @NonNull
    public ModelType c() {
        return this.f24621c;
    }

    @NonNull
    public String d() {
        String str = this.f24619a;
        return str != null ? str : "COM.GOOGLE.BASE_".concat(String.valueOf((String) f24618f.get(this.f24620b)));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!n.b(this.f24619a, bVar.f24619a) || !n.b(this.f24620b, bVar.f24620b) || !n.b(this.f24621c, bVar.f24621c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f24619a, this.f24620b, this.f24621c);
    }

    @NonNull
    public String toString() {
        zzz zzb = zzaa.zzb("RemoteModel");
        zzb.zza("modelName", this.f24619a);
        zzb.zza("baseModel", this.f24620b);
        zzb.zza("modelType", this.f24621c);
        return zzb.toString();
    }
}
