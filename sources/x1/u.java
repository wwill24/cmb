package x1;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f18492a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f18493b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<n> f18494c = new ArrayList<>();

    @Deprecated
    public u() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (this.f18493b != uVar.f18493b || !this.f18492a.equals(uVar.f18492a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f18493b.hashCode() * 31) + this.f18492a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f18493b + "\n") + "    values:";
        for (String next : this.f18492a.keySet()) {
            str = str + "    " + next + ": " + this.f18492a.get(next) + "\n";
        }
        return str;
    }

    public u(@NonNull View view) {
        this.f18493b = view;
    }
}
