package com.withpersona.sdk2.inquiry;

public final class ServerThemeSource implements ThemeSource {
    private final Integer theme;

    public ServerThemeSource(Integer num) {
        this.theme = num;
    }

    public Integer getTheme() {
        return this.theme;
    }
}
