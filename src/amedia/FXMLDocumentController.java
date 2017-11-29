/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amedia;

import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

public class FXMLDocumentController implements Initializable {
   
    private MediaPlayer mediaPlayer;
    
    
    
    
    
    
    @FXML
    private MediaView mediaView; 
    
    private String filePath;
    
    @FXML
    private Slider slider;
   
    
    
     @FXML
    private Slider seekSlider;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        FileChooser fileChooser= new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file(*.mp4)","*.mp4");
        fileChooser.getExtensionFilters().add(filter);
        File file= fileChooser.showOpenDialog(null);
        filePath = file.toURI().toString();
        
        if(filePath!=null){
        Media media = new Media(filePath);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
           DoubleProperty width =mediaView.fitWidthProperty();
           
           DoubleProperty height =mediaView.fitHeightProperty();
           
           width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
           height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
            InvalidationListener ChangeListener;
           
           
           
           
           slider.setValue(mediaPlayer.getVolume()*100);
           slider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(slider.getValue()/100);
                
                
            }
        });
          /*  ChangeListener<Duration> a = new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                seekSlider.setValue(newValue.toMillis());
                
            }
        }; 
            
           // EventHandler<MouseEvent> b = new EventHandler<MouseEvent>() {
            //@Override
            //public void handle(MouseEvent event) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //}
       // };
         //   seekSlider.setOnMouseClicked(b);
        
           mediaPlayer.currentTimeProperty().addListener((InvalidationListener) a);*/
            //mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
              //  @Override
                //public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                  //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               // }
           // });

        mediaPlayer.play();  
        
        
         
        }
        
    }
    
    @FXML
    private void playvideo(ActionEvent event){
    mediaPlayer.play();
    mediaPlayer.setRate(1);
    
    }
    
    @FXML
    private void pausevideo(ActionEvent event){
    mediaPlayer.pause();  
    }
    
    @FXML
    private void stopvideo(ActionEvent event){
    mediaPlayer.stop();
    }
    
    @FXML
    private void fastvideo(ActionEvent event){
    mediaPlayer.setRate(1.5);
    }
    
    @FXML
    private void fastervideo(ActionEvent event){
    mediaPlayer.setRate(2);
    }
    
    @FXML
    private void slowvideo(ActionEvent event){
    mediaPlayer.setRate(0.75);
    }
    
    @FXML
    private void slowervideo(ActionEvent event){
    mediaPlayer.setRate(0.5);
    
    }
    
    @FXML
    private void exitvideo(ActionEvent event){
    System.exit(0);
    
    }
    
  
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private static class ChangeListenerImpl implements ChangeListener<Duration> {

        public ChangeListenerImpl() {
        }

        @Override
        public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}