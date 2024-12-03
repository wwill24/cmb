package org.jivesoftware.smackx.geoloc.packet;

import com.leanplum.internal.Constants;
import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;

public final class GeoLocation implements Serializable, ExtensionElement, FormFieldChildElement {
    public static final String ELEMENT = "geoloc";
    public static final GeoLocation EMPTY_GEO_LOCATION = builder().build();
    public static final String NAMESPACE = "http://jabber.org/protocol/geoloc";
    public static final QName QNAME = new QName("http://jabber.org/protocol/geoloc", ELEMENT);
    private static final long serialVersionUID = 1;
    private final Double accuracy;
    private final Double alt;
    private final Double altAccuracy;
    private final String area;
    private final Double bearing;
    private final String building;
    private final String country;
    private final String countryCode;
    private final String datum;
    private final String description;
    private final Double error;
    private final String floor;
    private final HashCode.Cache hashCodeCache;
    private final Double lat;
    private final String locality;
    private final Double lon;
    private final String postalcode;
    private final String region;
    private final String room;
    private final Double speed;
    private final String street;
    private final String text;
    private final Date timestamp;
    private final String tzo;
    private final URI uri;

    public static class Builder {
        /* access modifiers changed from: private */
        public Double accuracy;
        /* access modifiers changed from: private */
        public Double alt;
        /* access modifiers changed from: private */
        public Double altAccuracy;
        /* access modifiers changed from: private */
        public String area;
        /* access modifiers changed from: private */
        public Double bearing;
        /* access modifiers changed from: private */
        public String building;
        /* access modifiers changed from: private */
        public String country;
        /* access modifiers changed from: private */
        public String countryCode;
        /* access modifiers changed from: private */
        public String datum = "WGS84";
        /* access modifiers changed from: private */
        public String description;
        /* access modifiers changed from: private */
        public Double error;
        /* access modifiers changed from: private */
        public String floor;
        /* access modifiers changed from: private */
        public Double lat;
        /* access modifiers changed from: private */
        public String locality;
        /* access modifiers changed from: private */
        public Double lon;
        /* access modifiers changed from: private */
        public String postalcode;
        /* access modifiers changed from: private */
        public String region;
        /* access modifiers changed from: private */
        public String room;
        /* access modifiers changed from: private */
        public Double speed;
        /* access modifiers changed from: private */
        public String street;
        /* access modifiers changed from: private */
        public String text;
        /* access modifiers changed from: private */
        public Date timestamp;
        /* access modifiers changed from: private */
        public String tzo;
        /* access modifiers changed from: private */
        public URI uri;

        public GeoLocation build() {
            return new GeoLocation(this);
        }

        public Builder setAccuracy(Double d10) {
            this.accuracy = d10;
            return this;
        }

        public Builder setAlt(Double d10) {
            this.alt = d10;
            return this;
        }

        public Builder setAltAccuracy(Double d10) {
            this.altAccuracy = d10;
            return this;
        }

        public Builder setArea(String str) {
            this.area = str;
            return this;
        }

        public Builder setBearing(Double d10) {
            this.bearing = d10;
            return this;
        }

        public Builder setBuilding(String str) {
            this.building = str;
            return this;
        }

        public Builder setCountry(String str) {
            this.country = str;
            return this;
        }

        public Builder setCountryCode(String str) {
            this.countryCode = str;
            return this;
        }

        public Builder setDatum(String str) {
            this.datum = str;
            return this;
        }

        public Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Deprecated
        public Builder setError(Double d10) {
            this.error = d10;
            return this;
        }

        public Builder setFloor(String str) {
            this.floor = str;
            return this;
        }

        public Builder setLat(Double d10) {
            this.lat = d10;
            return this;
        }

        public Builder setLocality(String str) {
            this.locality = str;
            return this;
        }

        public Builder setLon(Double d10) {
            this.lon = d10;
            return this;
        }

        public Builder setPostalcode(String str) {
            this.postalcode = str;
            return this;
        }

        public Builder setRegion(String str) {
            this.region = str;
            return this;
        }

        public Builder setRoom(String str) {
            this.room = str;
            return this;
        }

        public Builder setSpeed(Double d10) {
            this.speed = d10;
            return this;
        }

        public Builder setStreet(String str) {
            this.street = str;
            return this;
        }

        public Builder setText(String str) {
            this.text = str;
            return this;
        }

        public Builder setTimestamp(Date date) {
            this.timestamp = date;
            return this;
        }

        public Builder setTzo(String str) {
            this.tzo = str;
            return this;
        }

        public Builder setUri(URI uri2) {
            this.uri = uri2;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static GeoLocation from(Message message) {
        return (GeoLocation) message.getExtension(GeoLocation.class);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equals$1(EqualsUtil.Builder builder, GeoLocation geoLocation) {
        builder.append(this.accuracy, geoLocation.accuracy).append(this.altAccuracy, geoLocation.altAccuracy).append(this.area, geoLocation.area).append(this.bearing, geoLocation.bearing).append(this.building, geoLocation.building).append(this.country, geoLocation.country).append(this.countryCode, geoLocation.countryCode).append(this.datum, geoLocation.datum).append(this.description, geoLocation.description).append(this.error, geoLocation.error).append(this.floor, geoLocation.floor).append(this.lat, geoLocation.lat).append(this.locality, geoLocation.locality).append(this.lon, geoLocation.lon).append(this.postalcode, geoLocation.postalcode).append(this.region, geoLocation.region).append(this.room, geoLocation.room).append(this.speed, geoLocation.speed).append(this.street, geoLocation.street).append(this.text, geoLocation.text).append(this.timestamp, geoLocation.timestamp).append(this.tzo, geoLocation.tzo).append(this.uri, geoLocation.uri);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$hashCode$0(HashCode.Builder builder) {
        builder.append((Object) this.accuracy).append((Object) this.alt).append((Object) this.altAccuracy).append((Object) this.area).append((Object) this.bearing).append((Object) this.building).append((Object) this.country).append((Object) this.countryCode).append((Object) this.datum).append((Object) this.description).append((Object) this.error).append((Object) this.floor).append((Object) this.lat).append((Object) this.locality).append((Object) this.lon).append((Object) this.postalcode).append((Object) this.region).append((Object) this.room).append((Object) this.speed).append((Object) this.street).append((Object) this.text).append((Object) this.timestamp).append((Object) this.tzo).append((Object) this.uri);
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new a(this));
    }

    public Double getAccuracy() {
        return this.accuracy;
    }

    public Double getAlt() {
        return this.alt;
    }

    public Double getAltAccuracy() {
        return this.altAccuracy;
    }

    public String getArea() {
        return this.area;
    }

    public Double getBearing() {
        return this.bearing;
    }

    public String getBuilding() {
        return this.building;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDatum() {
        return this.datum;
    }

    public String getDescription() {
        return this.description;
    }

    public String getElementName() {
        return ELEMENT;
    }

    @Deprecated
    public Double getError() {
        return this.error;
    }

    public String getFloor() {
        return this.floor;
    }

    public Double getLat() {
        return this.lat;
    }

    public String getLocality() {
        return this.locality;
    }

    public Double getLon() {
        return this.lon;
    }

    public String getNamespace() {
        return "http://jabber.org/protocol/geoloc";
    }

    public String getPostalcode() {
        return this.postalcode;
    }

    public QName getQName() {
        return QNAME;
    }

    public String getRegion() {
        return this.region;
    }

    public String getRoom() {
        return this.room;
    }

    public Double getSpeed() {
        return this.speed;
    }

    public String getStreet() {
        return this.street;
    }

    public String getText() {
        return this.text;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getTzo() {
        return this.tzo;
    }

    public URI getUri() {
        return this.uri;
    }

    public int hashCode() {
        return this.hashCodeCache.getHashCode(new b(this));
    }

    public boolean isExclusiveElement() {
        return true;
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("accuracy", (Object) this.accuracy);
        xmlStringBuilder.optElement("alt", (Object) this.alt);
        xmlStringBuilder.optElement("altaccuracy", (Object) this.altAccuracy);
        xmlStringBuilder.optElement("area", this.area);
        xmlStringBuilder.optElement("bearing", (Object) this.bearing);
        xmlStringBuilder.optElement("building", this.building);
        xmlStringBuilder.optElement("country", this.country);
        xmlStringBuilder.optElement("countrycode", this.countryCode);
        xmlStringBuilder.optElement("datum", this.datum);
        xmlStringBuilder.optElement("description", this.description);
        xmlStringBuilder.optElement("error", (Object) this.error);
        xmlStringBuilder.optElement("floor", this.floor);
        xmlStringBuilder.optElement("lat", (Object) this.lat);
        xmlStringBuilder.optElement("locality", this.locality);
        xmlStringBuilder.optElement("lon", (Object) this.lon);
        xmlStringBuilder.optElement("postalcode", this.postalcode);
        xmlStringBuilder.optElement(Constants.Keys.REGION, this.region);
        xmlStringBuilder.optElement("room", this.room);
        xmlStringBuilder.optElement("speed", (Object) this.speed);
        xmlStringBuilder.optElement("street", this.street);
        xmlStringBuilder.optElement("text", this.text);
        xmlStringBuilder.optElement("timestamp", this.timestamp);
        xmlStringBuilder.optElement("tzo", this.tzo);
        xmlStringBuilder.optElement("uri", (Object) this.uri);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }

    private GeoLocation(Builder builder) {
        this.hashCodeCache = new HashCode.Cache();
        this.accuracy = builder.accuracy;
        this.alt = builder.alt;
        this.altAccuracy = builder.altAccuracy;
        this.area = builder.area;
        this.bearing = builder.bearing;
        this.building = builder.building;
        this.country = builder.country;
        this.countryCode = builder.countryCode;
        this.datum = builder.datum;
        this.description = builder.description;
        this.error = builder.error;
        this.floor = builder.floor;
        this.lat = builder.lat;
        this.locality = builder.locality;
        this.lon = builder.lon;
        this.postalcode = builder.postalcode;
        this.region = builder.region;
        this.room = builder.room;
        this.speed = builder.speed;
        this.street = builder.street;
        this.text = builder.text;
        this.timestamp = builder.timestamp;
        this.tzo = builder.tzo;
        this.uri = builder.uri;
    }

    public static GeoLocation from(FormField formField) {
        return (GeoLocation) formField.getFormFieldChildElement(QNAME);
    }
}
