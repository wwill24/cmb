package j3;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface d<T> {

    public interface a<T> {
        void c(@NonNull Exception exc);

        void f(T t10);
    }

    @NonNull
    Class<T> a();

    void b();

    void cancel();

    void d(@NonNull Priority priority, @NonNull a<? super T> aVar);

    @NonNull
    DataSource e();
}
