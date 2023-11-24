import java.util.HashMap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GuiServer extends Application{
	TextField port_prompt;
	Button serverChoice;
	HashMap<String, Scene> sceneMap;
	VBox buttonBox;
	HBox serverBtn;
	Scene startScene;
	BorderPane startPane;
	Server serverConnection;
	ListView<String> listItems, listItems2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("ServerGUI");

		this.port_prompt = new TextField();
		this.port_prompt.setPromptText("Enter port number here and then press Start");
		
		this.serverChoice = new Button("Start");
		this.serverChoice.setPrefSize(250, 150);
		
		this.serverChoice.setOnAction(e->{ primaryStage.setScene(sceneMap.get("server"));
											primaryStage.setTitle("Server Log");
				String port = this.port_prompt.getText();
				serverConnection = new Server(data -> {
					Platform.runLater(()->{
						listItems.getItems().add(data.toString());
					});
				}, port);
											
		});
		
        this.serverBtn = new HBox(serverChoice);
        serverBtn.setAlignment(Pos.CENTER);
        this.buttonBox = new VBox(serverBtn, port_prompt);
        startPane = new BorderPane();
        
		startPane.setPadding(new Insets(200));
		startPane.setCenter(buttonBox);
        
        startPane.setStyle("-fx-background-color: lightBlue;");

        startScene = new Scene(startPane, 900,600);
		
		listItems = new ListView<>();
		listItems2 = new ListView<>();
		
		sceneMap = new HashMap<>();
		sceneMap.put("server", createServerGui());
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
		
		primaryStage.setScene(startScene);
		primaryStage.show();
	}
	
	public Scene createServerGui() {
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(70));
		pane.setStyle("-fx-background-color: coral");
		pane.setCenter(listItems);
	
		return new Scene(pane, 500, 400);
	}
}
