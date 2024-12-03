package net.bytebuddy.implementation.auxiliary;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.SyntheticState;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface AuxiliaryType {
    @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"MS_MUTABLE_ARRAY", "MS_OOI_PKGPROTECT"})
    public static final ModifierContributor.ForType[] DEFAULT_TYPE_MODIFIER = {SyntheticState.SYNTHETIC};

    public interface NamingStrategy {

        public static class Enumerating implements NamingStrategy {
            private final String suffix;

            public Enumerating(String str) {
                this.suffix = str;
            }

            public String name(TypeDescription typeDescription, AuxiliaryType auxiliaryType) {
                return typeDescription.getName() + "$" + this.suffix + "$" + RandomString.hashOf((Object) auxiliaryType);
            }
        }

        public static class Suffixing implements NamingStrategy {
            private final String suffix;

            public Suffixing(String str) {
                this.suffix = str;
            }

            public String name(TypeDescription typeDescription, AuxiliaryType auxiliaryType) {
                return typeDescription.getName() + "$" + this.suffix + "$" + auxiliaryType.getSuffix();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class SuffixingRandom implements NamingStrategy {
            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
            private final RandomString randomString = new RandomString();
            private final String suffix;

            public SuffixingRandom(String str) {
                this.suffix = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.suffix.equals(((SuffixingRandom) obj).suffix);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.suffix.hashCode();
            }

            public String name(TypeDescription typeDescription, AuxiliaryType auxiliaryType) {
                return typeDescription.getName() + "$" + this.suffix + "$" + this.randomString.nextString();
            }
        }

        String name(TypeDescription typeDescription, AuxiliaryType auxiliaryType);
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface SignatureRelevant {
    }

    String getSuffix();

    DynamicType make(String str, ClassFileVersion classFileVersion, MethodAccessorFactory methodAccessorFactory);
}
