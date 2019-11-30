package dad.javafx.inicioSesionMVC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioSesionApp extends Application{

	private InicioSesionView view;

	public void start(Stage primaryStage) throws Exception {
		
		
		view= new InicioSesionView();
		
		Scene scene = new Scene(view.getRootView(), 350, 200);

		primaryStage.setTitle("Inicio sesion MVC");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
}


