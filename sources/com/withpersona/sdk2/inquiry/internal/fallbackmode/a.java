package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.withpersona.sdk2.inquiry.internal.InquiryField;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.c;
import okhttp3.z;
import retrofit2.r;

public interface a {
    Object a(String str, z zVar, c<? super r<?>> cVar);

    Object b(String str, String str2, Map<String, ? extends InquiryField> map, c<? super Result<m>> cVar);
}
