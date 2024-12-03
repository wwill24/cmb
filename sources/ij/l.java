package ij;

import am.r;
import am.y;
import androidx.annotation.NonNull;

public interface l extends y {

    public interface a {
        void a(@NonNull l lVar, @NonNull r rVar);

        void b(@NonNull l lVar, @NonNull r rVar);
    }

    public interface b {
        @NonNull
        l a(@NonNull g gVar, @NonNull q qVar);

        @NonNull
        <N extends r> b b(@NonNull Class<N> cls, c<? super N> cVar);
    }

    public interface c<N extends r> {
        void a(@NonNull l lVar, @NonNull N n10);
    }

    void b(int i10, Object obj);

    @NonNull
    t builder();

    void d(@NonNull r rVar);

    <N extends r> void i(@NonNull N n10, int i10);

    @NonNull
    q j();

    void k(@NonNull r rVar);

    int length();

    void q(@NonNull r rVar);

    @NonNull
    g r();

    void t();

    boolean v(@NonNull r rVar);

    void z();
}
