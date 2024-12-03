package net.bytebuddy.description.enumeration;

import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface EnumerationDescription extends NamedElement {

    public static abstract class AbstractBase implements EnumerationDescription {
        private transient /* synthetic */ int hashCode;

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EnumerationDescription)) {
                return false;
            }
            EnumerationDescription enumerationDescription = (EnumerationDescription) obj;
            if (!getEnumerationType().equals(enumerationDescription.getEnumerationType()) || !getValue().equals(enumerationDescription.getValue())) {
                return false;
            }
            return true;
        }

        public String getActualName() {
            return getValue();
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode2 = this.hashCode != 0 ? 0 : getValue().hashCode() + (getEnumerationType().hashCode() * 31);
            if (hashCode2 == 0) {
                return this.hashCode;
            }
            this.hashCode = hashCode2;
            return hashCode2;
        }

        public String toString() {
            return getValue();
        }
    }

    public static class ForLoadedEnumeration extends AbstractBase {
        private final Enum<?> value;

        public ForLoadedEnumeration(Enum<?> enumR) {
            this.value = enumR;
        }

        public static List<EnumerationDescription> asList(Enum<?>[] enumArr) {
            ArrayList arrayList = new ArrayList(enumArr.length);
            for (Enum<?> forLoadedEnumeration : enumArr) {
                arrayList.add(new ForLoadedEnumeration(forLoadedEnumeration));
            }
            return arrayList;
        }

        public TypeDescription getEnumerationType() {
            return TypeDescription.ForLoadedType.of(this.value.getDeclaringClass());
        }

        public String getValue() {
            return this.value.name();
        }

        public <T extends Enum<T>> T load(Class<T> cls) {
            if (this.value.getDeclaringClass() == cls) {
                return this.value;
            }
            return Enum.valueOf(cls, this.value.name());
        }
    }

    public static class Latent extends AbstractBase {
        private final TypeDescription enumerationType;
        private final String value;

        public Latent(TypeDescription typeDescription, String str) {
            this.enumerationType = typeDescription;
            this.value = str;
        }

        public TypeDescription getEnumerationType() {
            return this.enumerationType;
        }

        public String getValue() {
            return this.value;
        }

        public <T extends Enum<T>> T load(Class<T> cls) {
            if (this.enumerationType.represents(cls)) {
                return Enum.valueOf(cls, this.value);
            }
            throw new IllegalArgumentException(cls + " does not represent " + this.enumerationType);
        }
    }

    TypeDescription getEnumerationType();

    String getValue();

    <T extends Enum<T>> T load(Class<T> cls);
}
