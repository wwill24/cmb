package com.withpersona.sdk2.inquiry.selfie.network;

import java.util.List;
import kotlin.coroutines.c;
import okhttp3.w;
import retrofit2.r;
import vn.i;
import vn.k;
import vn.l;
import vn.o;
import vn.q;
import vn.s;

public interface a {
    @l
    @k({"Accept: multipart/form-data"})
    @o("/api/internal/verify/v1/inquiries/{inquiryId}/transition")
    Object a(@i("Authorization") String str, @s("inquiryId") String str2, @q List<w.c> list, c<? super r<?>> cVar);
}
