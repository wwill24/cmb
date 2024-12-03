package androidx.datastore.preferences.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class PreferenceDataStoreFactory$create$delegate$1 extends Lambda implements Function0<File> {
    final /* synthetic */ Function0<File> $produceFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStoreFactory$create$delegate$1(Function0<? extends File> function0) {
        super(0);
        this.$produceFile = function0;
    }

    /* renamed from: a */
    public final File invoke() {
        File invoke = this.$produceFile.invoke();
        String l10 = j.l(invoke);
        d dVar = d.f5060a;
        if (j.b(l10, dVar.e())) {
            return invoke;
        }
        throw new IllegalStateException(("File extension for file: " + invoke + " does not match required extension for Preferences file: " + dVar.e()).toString());
    }
}
