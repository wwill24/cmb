package com.withpersona.sdk2.inquiry;

public final class ClientThemeSource implements ThemeSource {
    private final Integer theme;

    public ClientThemeSource(Integer num) {
        this.theme = num;
    }

    public Integer getTheme() {
        return this.theme;
    }
}
