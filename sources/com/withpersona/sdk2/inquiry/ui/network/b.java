package com.withpersona.sdk2.inquiry.ui.network;

import kotlin.coroutines.c;
import retrofit2.r;
import vn.a;
import vn.f;
import vn.i;
import vn.o;
import vn.s;

public interface b {
    @f("/api/internal/verify/v1/address/{addressId}")
    Object a(@i("Authorization") String str, @s("addressId") String str2, c<? super r<AddressDetailsResponse>> cVar);

    @o("/api/internal/verify/v1/inquiries/{inquiryId}/transition")
    Object b(@i("Authorization") String str, @s("inquiryId") String str2, @a TransitionInquiryRequest transitionInquiryRequest, c<? super r<Object>> cVar);

    @o("/api/internal/verify/v1/address/autocomplete")
    Object c(@i("Authorization") String str, @a AddressAutocompleteRequest addressAutocompleteRequest, c<? super r<AddressAutocompleteResponse>> cVar);
}
