package com.clevertap.android.sdk.inapp;

import androidx.annotation.NonNull;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;

public enum CTInAppType {
    CTInAppTypeHTML(XHTMLExtension.ELEMENT),
    CTInAppTypeCoverHTML("coverHtml"),
    CTInAppTypeInterstitialHTML("interstitialHtml"),
    CTInAppTypeHeaderHTML("headerHtml"),
    CTInAppTypeFooterHTML("footerHtml"),
    CTInAppTypeHalfInterstitialHTML("halfInterstitialHtml"),
    CTInAppTypeCover("cover"),
    CTInAppTypeInterstitial("interstitial"),
    CTInAppTypeHalfInterstitial("half-interstitial"),
    CTInAppTypeHeader("header-template"),
    CTInAppTypeFooter("footer-template"),
    CTInAppTypeAlert("alert-template"),
    CTInAppTypeCoverImageOnly("cover-image"),
    CTInAppTypeInterstitialImageOnly("interstitial-image"),
    CTInAppTypeHalfInterstitialImageOnly("half-interstitial-image");
    
    private final String inAppType;

    private CTInAppType(String str) {
        this.inAppType = str;
    }

    static CTInAppType a(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1698613420:
                if (str.equals("half-interstitial-image")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1258935355:
                if (str.equals("cover-image")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1160074422:
                if (str.equals("halfInterstitialHtml")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1141304454:
                if (str.equals("interstitial-image")) {
                    c10 = 3;
                    break;
                }
                break;
            case -728863497:
                if (str.equals("interstitialHtml")) {
                    c10 = 4;
                    break;
                }
                break;
            case -334055316:
                if (str.equals("footer-template")) {
                    c10 = 5;
                    break;
                }
                break;
            case -37253685:
                if (str.equals("alert-template")) {
                    c10 = 6;
                    break;
                }
                break;
            case 3213227:
                if (str.equals(XHTMLExtension.ELEMENT)) {
                    c10 = 7;
                    break;
                }
                break;
            case 94852023:
                if (str.equals("cover")) {
                    c10 = 8;
                    break;
                }
                break;
            case 604727084:
                if (str.equals("interstitial")) {
                    c10 = 9;
                    break;
                }
                break;
            case 894039686:
                if (str.equals("half-interstitial")) {
                    c10 = 10;
                    break;
                }
                break;
            case 1189018554:
                if (str.equals("header-template")) {
                    c10 = 11;
                    break;
                }
                break;
            case 1420225510:
                if (str.equals("footerHtml")) {
                    c10 = 12;
                    break;
                }
                break;
            case 1977176024:
                if (str.equals("headerHtml")) {
                    c10 = 13;
                    break;
                }
                break;
            case 1979390978:
                if (str.equals("coverHtml")) {
                    c10 = 14;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return CTInAppTypeHalfInterstitialImageOnly;
            case 1:
                return CTInAppTypeCoverImageOnly;
            case 2:
                return CTInAppTypeHalfInterstitialHTML;
            case 3:
                return CTInAppTypeInterstitialImageOnly;
            case 4:
                return CTInAppTypeInterstitialHTML;
            case 5:
                return CTInAppTypeFooter;
            case 6:
                return CTInAppTypeAlert;
            case 7:
                return CTInAppTypeHTML;
            case 8:
                return CTInAppTypeCover;
            case 9:
                return CTInAppTypeInterstitial;
            case 10:
                return CTInAppTypeHalfInterstitial;
            case 11:
                return CTInAppTypeHeader;
            case 12:
                return CTInAppTypeFooterHTML;
            case 13:
                return CTInAppTypeHeaderHTML;
            case 14:
                return CTInAppTypeCoverHTML;
            default:
                return null;
        }
    }

    @NonNull
    public String toString() {
        return this.inAppType;
    }
}
