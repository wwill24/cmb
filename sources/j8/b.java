package j8;

import com.coffeemeetsbagel.feature.chat.features.photoupload.api.endpoints.ChatPhotoUploadResponse;
import okhttp3.w;
import okhttp3.z;
import vn.l;
import vn.o;
import vn.q;

public interface b {
    @l
    @o("/chat_upload")
    retrofit2.b<ChatPhotoUploadResponse> a(@q w.c cVar, @q("data") z zVar);
}
