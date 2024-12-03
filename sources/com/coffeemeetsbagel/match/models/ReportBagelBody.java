package com.coffeemeetsbagel.match.models;

import lg.c;

public class ReportBagelBody {
    @c("block")
    private Boolean block;
    @c("block_reason")
    private String blockDetails;
    @c("block_type")
    private String blockType;

    public ReportBagelBody(Boolean bool, String str, String str2) {
        this.block = bool;
        this.blockType = str;
        this.blockDetails = str2;
    }
}
