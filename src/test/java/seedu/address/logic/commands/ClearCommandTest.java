package seedu.address.logic.commands;

import static seedu.address.logic.commands.ClearCommand.COMMAND_CONFIRMATION;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalGameEntries.getTypicalGameBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.GameBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyGameBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(COMMAND_CONFIRMATION), model,
            ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyGameBook_success() {
        Model model = new ModelManager(getTypicalGameBook(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalGameBook(), new UserPrefs());
        expectedModel.setGameBook(new GameBook());

        assertCommandSuccess(new ClearCommand(COMMAND_CONFIRMATION),
            model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
