package Componentes;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * Texfield temporizador 
 * @author Kyle7
 */
public class Temporizador extends HBox {

    //private final int starTime = 10;
    private int seconds;
    private Label timeLabel;
    private Label nameLabel;
    private Label typeLabel;

    /**
     * 
     * @param seconds  segundos para el temporizador inicial
     */
    public Temporizador(int seconds) {
        nameLabel = new Label();
        nameLabel.setText("Contador");
        timeLabel = new Label();
        typeLabel = new Label();
        typeLabel.setText(" segundos");

       
        setTime(seconds);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TemporizadorFXML.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        timeLabel.setTextFill(Color.BLACK);
        timeLabel.setFont(Font.font(20));
        //HBox layout = new HBox(5);
        this.getChildren().addAll(nameLabel);
        this.getChildren().addAll(timeLabel);
        this.getChildren().addAll(typeLabel);
        // root.getChildren().add(layout);
        //doTime();
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    
    /**
     * metodo para empezar la cuenta atras
     */
    
    // ( si no queremos esto descomentamos en el constructor doTime y lo volvemos privado este metodo para mas security)
    public void doTime() {
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);

        if (time != null) {
            time.stop();
        }
        
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seconds--;
                timeLabel.setText(String.valueOf(seconds));
                if (seconds <= 0) {
                    time.stop();    
                    
                }

            }

        });
        time.getKeyFrames().add(frame);
        time.playFromStart();

    }

    /**
     * 
     * @return int devuelve los segundos
     */
    public int getTime(){
        return this.seconds;
    }
    
    /**
     * 
     * @param seconds establece los segundos del contador
     */
    public void setTime(int seconds) {
        this.seconds = seconds;
    }
    
    /**
     * Alerta de tiempo finalizado
     */
    public void alertTime(){
          if (this.seconds== 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Contador reseteado");
            alert.show();

        }
    }
}
