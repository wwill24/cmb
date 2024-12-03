package androidx.datastore.preferences;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends Lambda implements Function0<File> {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ PreferenceDataStoreSingletonDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = preferenceDataStoreSingletonDelegate;
    }

    /* renamed from: a */
    public final File invoke() {
        Context context = this.$applicationContext;
        j.f(context, "applicationContext");
        return a.a(context, this.this$0.f5036a);
    }
}
