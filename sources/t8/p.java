package t8;

import com.coffeemeetsbagel.models.body.ReorderPhotosBody;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.models.responses.ResponsePhoto;
import okhttp3.z;
import qj.w;
import retrofit2.r;
import vn.a;
import vn.b;
import vn.o;
import vn.s;

public interface p {
    @b("/photo/{id}")
    w<r<ResponseGeneric>> a(@s("id") String str);

    @o("/photo")
    w<r<ResponsePhoto>> b(@a z zVar);

    @vn.p("/photos")
    w<r<ResponseGeneric>> c(@a ReorderPhotosBody[] reorderPhotosBodyArr);
}
