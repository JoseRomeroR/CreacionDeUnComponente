package Componentes;

import javafx.scene.control.*;


/**
 * Textfield que controla los datos introducidos
 * @author Kyle7
 */
public class CampoTextoNumerico extends TextField {

    
    /**
     * 
     * @param start Parametro de comienzo
     * @param end Parametro de final
     * @param text Parametro de texto
     */
    @Override
    public void replaceText(int start, int end, String text) {
        if (!text.matches("[a-z, A-Z]")) {
            super.replaceText(start, end, text);
        }
        //label.setText("Enter a numeric value");
    }

    /**
     * 
     * @param text texto para controlar 
     */
    @Override
    public void replaceSelection(String text) {
        if (!text.matches("[a-z, A-Z]")) {
            super.replaceSelection(text);
        }
    }
};
