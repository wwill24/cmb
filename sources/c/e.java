package c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import c.a;
import c.f;
import com.google.android.gms.common.api.a;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public class e extends a<androidx.activity.result.e, List<Uri>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f7899b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f7900a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final int a() {
            if (f.f7901a.f()) {
                return MediaStore.getPickImagesMaxLimit();
            }
            return a.e.API_PRIORITY_OTHER;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? f7899b.a() : i10);
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    /* renamed from: a */
    public Intent createIntent(Context context, androidx.activity.result.e eVar) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(eVar, "input");
        f.a aVar = f.f7901a;
        boolean z10 = true;
        if (aVar.f()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(aVar.c(eVar.a()));
            if (this.f7900a > MediaStore.getPickImagesMaxLimit()) {
                z10 = false;
            }
            if (z10) {
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.f7900a);
                return intent;
            }
            throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
        } else if (aVar.e(context)) {
            ResolveInfo b10 = aVar.b(context);
            if (b10 != null) {
                ActivityInfo activityInfo = b10.activityInfo;
                Intent intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent2.setType(aVar.c(eVar.a()));
                intent2.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f7900a);
                return intent2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else if (aVar.d(context)) {
            ResolveInfo a10 = aVar.a(context);
            if (a10 != null) {
                ActivityInfo activityInfo2 = a10.activityInfo;
                Intent intent3 = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
                intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                intent3.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f7900a);
                return intent3;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else {
            Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent4.setType(aVar.c(eVar.a()));
            intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (intent4.getType() != null) {
                return intent4;
            }
            intent4.setType("*/*");
            intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return intent4;
        }
    }

    /* renamed from: b */
    public final a.C0091a<List<Uri>> getSynchronousResult(Context context, androidx.activity.result.e eVar) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(eVar, "input");
        return null;
    }

    /* renamed from: c */
    public final List<Uri> parseResult(int i10, Intent intent) {
        List<Uri> a10;
        if (!(i10 == -1)) {
            intent = null;
        }
        return (intent == null || (a10 = b.f7897a.a(intent)) == null) ? q.j() : a10;
    }

    public e(int i10) {
        this.f7900a = i10;
        if (!(i10 <= 1 ? false : true)) {
            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }
    }
}
