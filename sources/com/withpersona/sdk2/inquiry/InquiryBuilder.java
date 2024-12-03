package com.withpersona.sdk2.inquiry;

import kotlin.jvm.internal.j;

public final class InquiryBuilder {
    private final String inquiryId;
    private String sessionToken;
    private Integer theme;
    private Boolean useServerStyles;

    public InquiryBuilder(String str) {
        j.g(str, "inquiryId");
        this.inquiryId = str;
    }

    public final Inquiry build() {
        return new Inquiry((String) null, (String) null, this.inquiryId, this.sessionToken, (String) null, (String) null, (Fields) null, this.theme, (Environment) null, (Boolean) null, (Boolean) null, (Boolean) null, this.useServerStyles, (StaticInquiryTemplate) null);
    }

    public final InquiryBuilder sessionToken(String str) {
        this.sessionToken = str;
        return this;
    }

    public final InquiryBuilder theme(int i10) {
        this.theme = Integer.valueOf(i10);
        this.useServerStyles = Boolean.FALSE;
        return this;
    }

    public final InquiryBuilder theme(ThemeSource themeSource) {
        j.g(themeSource, "themeSource");
        this.theme = themeSource.getTheme();
        this.useServerStyles = Boolean.valueOf(themeSource instanceof ServerThemeSource);
        return this;
    }
}
