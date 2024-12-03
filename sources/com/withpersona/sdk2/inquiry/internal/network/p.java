package com.withpersona.sdk2.inquiry.internal.network;

import kotlin.coroutines.c;
import okhttp3.b0;
import retrofit2.r;
import vn.a;
import vn.f;
import vn.i;
import vn.o;
import vn.s;

public interface p {
    @f("/api/internal/verify/v1/inquiries/{inquiryId}")
    Object a(@i("Authorization") String str, @i("Persona-Device-Id") String str2, @s("inquiryId") String str3, c<? super r<CheckInquiryResponse>> cVar);

    @o("/api/internal/verify/v1/current-inquiry-session/error")
    Object b(@i("Authorization") String str, @a ErrorRequest errorRequest, c<? super r<b0>> cVar);

    @o("/api/internal/verify/v1/inquiries/{inquiryId}/transition-back")
    Object c(@i("Authorization") String str, @s("inquiryId") String str2, @a TransitionBackRequest transitionBackRequest, c<? super r<CheckInquiryResponse>> cVar);

    @o("/api/internal/verify/v1/inquiry-sessions")
    Object d(@a CreateInquirySessionRequest createInquirySessionRequest, @i("Persona-Device-Id") String str, c<? super r<CreateInquirySessionResponse>> cVar);

    @o("/api/internal/verify/v1/current-inquiry-session/cancel")
    Object e(@i("Authorization") String str, c<? super r<b0>> cVar);

    @o("/api/internal/verify/v1/inquiries")
    Object f(@a CreateInquiryRequest createInquiryRequest, c<? super r<CheckInquiryResponse>> cVar);
}
