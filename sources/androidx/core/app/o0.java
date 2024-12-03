package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

public final class o0 {

    static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(o0 o0Var) {
            throw null;
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static RemoteInput a(o0 o0Var) {
        return a.b(o0Var);
    }

    static RemoteInput[] b(o0[] o0VarArr) {
        if (o0VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[o0VarArr.length];
        for (int i10 = 0; i10 < o0VarArr.length; i10++) {
            o0 o0Var = o0VarArr[i10];
            remoteInputArr[i10] = a((o0) null);
        }
        return remoteInputArr;
    }
}
