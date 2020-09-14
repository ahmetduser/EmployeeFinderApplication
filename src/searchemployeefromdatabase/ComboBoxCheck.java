package searchemployeefromdatabase;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;

public class ComboBoxCheck implements ICheckInput{

    @Override
    public boolean isNotNull(Control obj) {
        ComboBox<String> comboBox = (ComboBox<String>) obj;
        return !comboBox.getSelectionModel().isEmpty();
    }
}
