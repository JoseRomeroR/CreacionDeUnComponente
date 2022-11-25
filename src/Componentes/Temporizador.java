package Componentes;

import javafx.animation.KeyFrame;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class Temporizador extends Application {

    private final int starTime = 10;
    private int seconds = starTime;
    private Label label;

    public void start(Stage stage) throws Exception {

        Group root = new Group();
        label = new Label();
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font(20));
        HBox layout = new HBox(5);
        layout.getChildren().addAll(label);
        root.getChildren().add(layout);
        
        doTime();

        
        stage.setScene( new Scene( root,400,100, Color.BLACK));
        stage.setTitle("Contador");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void doTime() {
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        
        if (time!=null) {
            time.stop();
            
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seconds--;
                label.setText("Contador: "+ String.valueOf(seconds) );
                if (seconds<= 0) {
                    time.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Contador reseteado");
                    alert.show();
                }

            }

        });
        time.getKeyFrames().add(frame);
        time.playFromStart();

    }

//    public Temporizador() {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TemporizadorFXML.fxml"));
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
//
//        try {
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
//    }
//
//    @FXML
//    private void doTime() {
//        
//        //TimeLine time = new 
//
//    }
}
