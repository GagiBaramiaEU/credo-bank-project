package ge.credo.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    GEO_LANGUAGE("ქართული"),
    MEGREL_LANGUAGE("მეგრული"),
    SVAN_LANGUAGE("სვანური");

    private final String language;
}
