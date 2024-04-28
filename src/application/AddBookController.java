package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddBookController implements Initializable {
@FXML
private TextField tfLastName;
@FXML
private TextField tfFirstName;
@FXML
private TextField tfEmail;
@FXML
private Button addBtn;
@FXML
private Button exportBtn;
@FXML
private Button importBtn;
@FXML
private Button removeBtn;
@FXML
private Button quitBtn;
@FXML
private TableView<Personne> table;
@FXML
private TableColumn<Personne, String> emailCol;
@FXML
private TableColumn<Personne, String> firstNameCol;
@FXML
private TableColumn<Personne, String> lastNameCol;

private DataClass data;


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	data = new DataClass();

	emailCol.setCellValueFactory(new PropertyValueFactory<>("Adresse email"));
    firstNameCol.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
    lastNameCol.setCellValueFactory(new PropertyValueFactory<>("Nom"));
    if(table != null) {
    	table.getColumns().addAll(emailCol, firstNameCol, lastNameCol);
    }
    

    ObservableList<Personne> observableList = FXCollections.observableList(data.getImportList());
    table.setItems(observableList);
}

@FXML
    private void handleAddButtonAction(ActionEvent event) {
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String email = tfEmail.getText();

        Personne newPerson = new Personne(firstName, lastName, email);
        table.getItems().add(newPerson);

        tfFirstName.clear();
        tfLastName.clear();
        tfEmail.clear();
    }

@FXML
private void handleExportButtonAction(ActionEvent event) {
	ObservableList<Personne> selectedPersons = table.getSelectionModel().getSelectedItems();

	data.getExportList().addAll(selectedPersons);

	table.getItems().removeAll(selectedPersons);
 }

   @FXML
private void handleImportButtonAction(ActionEvent event) {
      ObservableList<Personne> selectedPersons = table.getSelectionModel().getSelectedItems();

       data.getImportList().addAll(selectedPersons);

       table.getItems().removeAll(selectedPersons);
}

@FXML
private void handleRemoveButtonAction(ActionEvent event) {
	ObservableList<Personne> selectedPersons = table.getSelectionModel().getSelectedItems();

    table.getItems().removeAll(selectedPersons);
}

 @FXML
private void handleQuitButtonAction(ActionEvent event) {
	 Platform.exit();
   }

}

