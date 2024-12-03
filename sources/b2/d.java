package b2;

import androidx.annotation.NonNull;
import androidx.work.b;
import java.util.List;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7737a = f.i("InputMerger");

    public static d a(@NonNull String str) {
        try {
            return (d) Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e10) {
            f e11 = f.e();
            String str2 = f7737a;
            e11.d(str2, "Trouble instantiating + " + str, e10);
            return null;
        }
    }

    @NonNull
    public abstract b b(@NonNull List<b> list);
}
