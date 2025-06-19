package ge.credo.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AutomationErrorMessages {
    ERROR_NOTIFICATION_NOT_DISPLAYED("Error notification is not displayed!"),
    ASSERT_EQUALS_FAIL("Expected and actual values do not match!"),
    CONTINUE_BUTTON_SHOULD_BE_DISABLED("Continue button should be disabled!"),
    CONTINUE_BUTTON_SHOULD_BE_DISABLED_AFTER_BIRTHDATE("Continue button should be disabled after birthdate!"),
    CONTINUE_BUTTON_SHOULD_BE_ENABLED("Continue button should be enabled!"),
    BORDER_ERROR("Personal number input should have error border color!"),
    BORDER_VALID("Personal number input should have valid border color!");

    private final String message;
}
