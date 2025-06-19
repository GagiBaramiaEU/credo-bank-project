package ge.credo.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExpectedBorderColors {
    ERRORED_BORDER("230, 41, 51"),
    VALID_BORDER("0, 0, 0,");

    private final String rgbaValue;
}
