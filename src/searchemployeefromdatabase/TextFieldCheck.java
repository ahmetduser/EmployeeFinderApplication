package searchemployeefromdatabase;

import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class TextFieldCheck implements ICheckInput{

    @Override
    public boolean isNotNull(Control obj) {
        TextField textField = (TextField) obj;
        return !textField.getText().isEmpty();
    }
}
