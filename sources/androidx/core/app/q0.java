package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public final class q0 implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f4521a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f4522b;

    static class a {
        static PendingIntent a(Context context, int i10, Intent[] intentArr, int i11, Bundle bundle) {
            return PendingIntent.getActivities(context, i10, intentArr, i11, bundle);
        }
    }

    public interface b {
        Intent p();
    }

    private q0(Context context) {
        this.f4522b = context;
    }

    @NonNull
    public static q0 j(@NonNull Context context) {
        return new q0(context);
    }

    @NonNull
    public q0 b(@NonNull Intent intent) {
        this.f4521a.add(intent);
        return this;
    }

    @NonNull
    public q0 d(@NonNull Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f4522b.getPackageManager());
        }
        if (component != null) {
            g(component);
        }
        b(intent);
        return this;
    }

    @NonNull
    public q0 f(@NonNull Activity activity) {
        Intent intent;
        if (activity instanceof b) {
            intent = ((b) activity).p();
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = n.a(activity);
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.f4522b.getPackageManager());
            }
            g(component);
            b(intent);
        }
        return this;
    }

    @NonNull
    public q0 g(@NonNull ComponentName componentName) {
        int size = this.f4521a.size();
        try {
            Intent b10 = n.b(this.f4522b, componentName);
            while (b10 != null) {
                this.f4521a.add(size, b10);
                b10 = n.b(this.f4522b, b10.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @NonNull
    public q0 i(@NonNull Class<?> cls) {
        return g(new ComponentName(this.f4522b, cls));
    }

    @NonNull
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f4521a.iterator();
    }

    public PendingIntent m(int i10, int i11) {
        return n(i10, i11, (Bundle) null);
    }

    public PendingIntent n(int i10, int i11, Bundle bundle) {
        if (!this.f4521a.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f4521a.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return a.a(this.f4522b, i10, intentArr, i11, bundle);
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public void o() {
        p((Bundle) null);
    }

    public void p(Bundle bundle) {
        if (!this.f4521a.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f4521a.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!androidx.core.content.a.startActivities(this.f4522b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f4522b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
