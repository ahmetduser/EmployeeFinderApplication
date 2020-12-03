package searchemployeefromdatabase;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import searchemployeefromdatabase.interfaces.ICheckInput;

public class ComboBoxCheck implements ICheckInput {

    @Override
    public boolean isNotNull(Control obj) {
        ComboBox<String> comboBox = (ComboBox<String>) obj;
        return !comboBox.getSelectionModel().isEmpty();
    }
}
