package c;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class i extends a<Intent, ActivityResult> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7906a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    public ActivityResult parseResult(int i10, Intent intent) {
        return new ActivityResult(i10, intent);
    }

    public Intent createIntent(Context context, Intent intent) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(intent, "input");
        return intent;
    }
}
