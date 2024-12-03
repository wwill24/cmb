package androidx.activity.result;

import androidx.annotation.NonNull;
import c.a;

public interface b {
    @NonNull
    <I, O> c<I> registerForActivityResult(@NonNull a<I, O> aVar, @NonNull a<O> aVar2);
}
