import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class ImprovedHello extends Application {
       public static void main(String[] args) {
               Application.launch(args);
}
       @Override
       public void start(Stage stage) {
               Label nameLbl = new Label("Enter your name:");
               TextField nameFld = new TextField();
               TextField styleFld = new TextField();
               styleFld.setText("-fx-text-fill: blue;");

               Label msg = new Label();
               
               // Create buttons
               Button sayHelloBtn = new Button("Say Hello");
               Button exitBtn = new Button("Exit");
               // Add the event handler for the Say Hello button
               sayHelloBtn.setOnAction(e -> {
                  String name = nameFld.getText();
                  if (name.trim().length() > 0) {
                    msg.setText("Hello " + name);
                  } else {
                    msg.setText("Hello there");
                  }
                  msg.setStyle(styleFld.getText());
               });
        // Add the event handler for the Exit button
       exitBtn.setOnAction(e -> Platform.exit());
       // Create the root node
       VBox root = new VBox();
       // Set the vertical spacing between children to 5px
       root.setSpacing(5);
       // Add children to the root node

       HBox buttons = new HBox();
       buttons.getChildren().addAll(sayHelloBtn, exitBtn);
       root.getChildren().addAll(nameLbl, nameFld,styleFld, msg, buttons);
       Scene scene = new Scene(root, 550, 250);
       stage.setScene(scene);
       stage.setTitle("Improved Hello JavaFX Application");
       stage.show();
   }
}