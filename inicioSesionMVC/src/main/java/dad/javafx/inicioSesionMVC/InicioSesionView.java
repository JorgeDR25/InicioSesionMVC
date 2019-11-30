package dad.javafx.inicioSesionMVC;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InicioSesionView extends Application {

	Scanner entrada = new Scanner(System.in);

	private Label usuarioLabel, contrasenaLabel;
	private TextField nombreText;
	private PasswordField contrasenaText;
	private Button accederButton, cancelarButton;
	private String nombre1="Jose";
	private String nombre2="Manuel";
	private String password1 = "Holasoyjose";
	private String password2 = "Manuel1234";
	private String cifrado1 = DigestUtils.md5Hex(password1).toUpperCase();
	private String cifrado2 = DigestUtils.md5Hex(password2).toUpperCase();

	private VBox root;

	public void start(Stage primaryStage) throws Exception {

		// Label

		usuarioLabel = new Label("Usuario:");
		contrasenaLabel = new Label("Contraseña:");

		// Text

		nombreText = new TextField();
		nombreText.setPromptText("Usuario");
		nombreText.setMaxWidth(150);
		nombreText.setAlignment(Pos.CENTER);

		contrasenaText = new PasswordField();
		contrasenaText.setPromptText("Contraseña");
		contrasenaText.setMaxWidth(150);
		contrasenaText.setAlignment(Pos.CENTER);

		// Button

		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);
		accederButton.setOnAction(e -> onAccederButtonAction(e));

		cancelarButton = new Button("Cancelar");
		cancelarButton.setDefaultButton(true);
		cancelarButton.setOnAction(e -> onCancelarButtonAction(e));

		HBox usuario = new HBox(usuarioLabel, nombreText);
		usuario.setSpacing(40);
		usuario.setAlignment(Pos.TOP_LEFT);

		HBox contrasena = new HBox(contrasenaLabel, contrasenaText);
		contrasena.setSpacing(20);
		contrasena.setAlignment(Pos.TOP_LEFT);

		HBox botones = new HBox(accederButton, cancelarButton);
		botones.setSpacing(5);
		botones.setAlignment(Pos.CENTER);

		VBox registro = new VBox(usuario, contrasena, botones);
		registro.setSpacing(20);
		registro.setAlignment(Pos.TOP_LEFT);

		root = new VBox(registro);
		root.setSpacing(20);
		root.setPadding(new Insets(20, 20, 20, 20));
		root.setAlignment(Pos.TOP_LEFT);
		
		Scene scene = new Scene(root, 350, 200);
		
		primaryStage.setTitle("Ahorcado");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onAccederButtonAction(ActionEvent e) {

		String nombre = nombreText.getText();
		String contrasena = contrasenaText.getText();
		String contrasenaCifrado = DigestUtils.md5Hex(contrasena).toUpperCase();
		
		if(nombre.equals(nombre1) || nombre.equals(nombre2)){
			if(contrasena.equals(password1) || contrasena.equals(password2)){

				Alert confirmacion = new Alert(AlertType.CONFIRMATION);
				confirmacion.setTitle("Iniciar sesión");
				confirmacion.setHeaderText("Acceso permitido");
				confirmacion.setContentText("Las credenciales de acceso son válidas");
				confirmacion.showAndWait();
			}else {
				
				Alert error = new Alert(AlertType.ERROR);
				error.setTitle("Iniciar sesión");
				error.setHeaderText("Acceso denegado");
				error.setContentText("El usuario y/o la contraseña no son válidos");
				error.showAndWait();
				contrasenaText.clear();
			}
		}else {
			
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Iniciar sesión");
			error.setHeaderText("Acceso denegado");
			error.setContentText("El usuario y/o la contraseña no son válidos");
			error.showAndWait();
			contrasenaText.clear();
		}
	}

	private void onCancelarButtonAction(ActionEvent e) {

		System.exit(0);
	}

	public VBox getRootView() {
		return root;
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
