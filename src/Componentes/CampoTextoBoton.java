package Componentes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Componente que incluye un TextField y un botón
 * @author Jose Romero
 */

public class CampoTextoBoton extends HBox implements Initializable {

    @FXML
    private TextField textField;
    @FXML
    private Button buttonClick;

    public CampoTextoBoton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CampoTextoBoton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
     
    }
    
 

/**
 * 
 * @return String  Devuelve el contenido del TextField
 */
    public String getText() {
        return textProperty().get();
    }


/**
 * 
 * @param value  String parar incluir en el TextField
 */
    public void setText(String value) {
        textProperty().set(value);
    }
    
    /**
     * 
     * @return String Devuelve el contenido del textProperty
     */

    public StringProperty textProperty() {
        return textField.textProperty();
    }
    
    /**
     * 
     * @return ObjectProperty onAction
     */

    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return onAction;
    }
/**
 * 
 * @param value  ActionEvent valor del evento
 */
    public final void setOnAction(EventHandler<ActionEvent> value) {
        onActionProperty().set(value);
    }
    

    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return CampoTextoBoton.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           buttonClick.setOnAction((ActionEvent event) -> {
            fireEvent(event);
        });

    }

}
