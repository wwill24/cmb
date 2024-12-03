package c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public class f extends a<androidx.activity.result.e, Uri> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7901a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResolveInfo a(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            return context.getPackageManager().resolveActivity(new Intent("com.google.android.gms.provider.action.PICK_IMAGES"), 1114112);
        }

        public final ResolveInfo b(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
        }

        public final String c(e eVar) {
            j.g(eVar, "input");
            if (eVar instanceof c) {
                return "image/*";
            }
            if (eVar instanceof d) {
                return ((d) eVar).a();
            }
            if (eVar instanceof b) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final boolean d(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            return a(context) != null;
        }

        public final boolean e(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            return b(context) != null;
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public final boolean f() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 33 && (i10 < 30 || SdkExtensions.getExtensionVersion(30) < 2)) {
                return false;
            }
            return true;
        }
    }

    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        public static final b f7902a = new b();

        private b() {
        }
    }

    public static final class c implements e {

        /* renamed from: a  reason: collision with root package name */
        public static final c f7903a = new c();

        private c() {
        }
    }

    public static final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        private final String f7904a;

        public final String a() {
            return this.f7904a;
        }
    }

    public interface e {
    }
}
