package co.mz.osoma.editor.controlador;

import co.mz.osoma.editor.service.CustomRootObjectDeserializer;
import co.mz.osoma.editor.service.TreeItemController;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import co.mz.osoma.editor.modelo.RootObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootPaneController implements Initializable, TreeItemController {

    private MainGUIController mainGUIController;
    private RootObject rootObject;

    @FXML
    private TextField txtTitle, txtNumber, txtFileVer, txtPassScore, txtTimeLimite;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        txtTitle.textProperty().addListener((observable, oldValue, newValue) -> {
            RootObject selectedObject = getSelectedItemObject();
            selectedObject.titleProperty().set(newValue);
        });

        txtNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            RootObject selectedObject = getSelectedItemObject();
            selectedObject.numberProperty().set(newValue);
        });

        txtFileVer.textProperty().addListener((observable, oldValue, newValue) -> {
            RootObject selectedObject = getSelectedItemObject();
            selectedObject.fileVersionProperty().set(newValue);
        });


    }

    public RootObject getSelectedItemObject() {
        TreeItem<Object> selectedItem = mainGUIController.getSeletedItem();
        return (RootObject) selectedItem.getValue();
    }

    public void setMainGUIController(MainGUIController mainGUIController) {
        this.mainGUIController = mainGUIController;
    }

    public void fillForm(Object root) {
        try {
            RootObject rootObject = (RootObject) root;

            txtTitle.setText(rootObject.getTitle());
            txtNumber.setText(rootObject.getNumber());
            txtFileVer.setText(rootObject.getFileVersion());

        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    /**
     * @author uachave
     */



    public void salvar(ActionEvent actionEvent) {
    System.out.println("chega aqui");




    }
}
