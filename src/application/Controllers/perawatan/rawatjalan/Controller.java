package application.Controllers.perawatan.rawatjalan;

import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONArray;

import application.Helpers.Http;
import application.Models.reg_periksaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

public class Controller implements Initializable {
	@FXML
    private TableColumn<reg_periksaModel, String> noRawat;
	@FXML
    private TableColumn<reg_periksaModel, String> noRM;
    @FXML
    private TableColumn<reg_periksaModel, String> noReg;
    @FXML
    private TableColumn<reg_periksaModel, String> namaPasien;
    @FXML
    private TableColumn<reg_periksaModel, String> alamatPasien;
    @FXML
    private TableColumn<reg_periksaModel, String> namaPoli;
    @FXML
    private TableColumn<reg_periksaModel, String> namaDokter;
    @FXML
    private TableView<reg_periksaModel> rajalTable;

    private ObservableList<reg_periksaModel> listData = FXCollections.observableArrayList();
    private ContextMenu cm = new ContextMenu();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        getData();
        setTableData();
	}
    private void setTableData(){
        noRawat.setCellValueFactory((TableColumn.CellDataFeatures<reg_periksaModel, String> cellData)-> cellData.getValue().getNo_rawat());
        noRM.setCellValueFactory((TableColumn.CellDataFeatures<reg_periksaModel, String> cellData)-> cellData.getValue().getNo_rkm_medis());
        noReg.setCellValueFactory((TableColumn.CellDataFeatures<reg_periksaModel, String> cellData)-> cellData.getValue().getNo_reg());
        namaPasien.setCellValueFactory((TableColumn.CellDataFeatures<reg_periksaModel, String> cellData)-> cellData.getValue().getNm_pasien());
        alamatPasien.setCellValueFactory((TableColumn.CellDataFeatures<reg_periksaModel, String> cellData)-> cellData.getValue().getAlamat());
        namaPoli.setCellValueFactory((TableColumn.CellDataFeatures<reg_periksaModel, String> cellData)-> cellData.getValue().getNm_poli());
        namaDokter.setCellValueFactory((TableColumn.CellDataFeatures<reg_periksaModel, String> cellData)-> cellData.getValue().getNm_dokter());
    }
    private void getData(){
        String json = Http.getDataJSON("/perawatan/rawatjalan");
        JSONArray data= new JSONArray(json);
        for(int i=0; i<data.length(); i++) {
            reg_periksaModel m = new reg_periksaModel();
            m.setNo_reg(data.getJSONObject(i).getString("no_reg"));
            m.setTgl_registrasi(data.getJSONObject(i).getString("tgl_registrasi"));
            m.setJam_reg(data.getJSONObject(i).getString("jam_reg"));
            m.setKd_dokter(data.getJSONObject(i).getString("kd_dokter"));
            m.setNo_rkm_medis(data.getJSONObject(i).getString("no_rkm_medis"));
            m.setKd_poli(data.getJSONObject(i).getString("kd_poli"));
            m.setNo_rawat(data.getJSONObject(i).getString("no_rawat"));
            m.setNm_pasien(data.getJSONObject(i).getString("nm_pasien"));
            m.setAlamat(data.getJSONObject(i).getString("alamat"));
            m.setNm_poli(data.getJSONObject(i).getString("nm_poli"));
            m.setNm_dokter(data.getJSONObject(i).getString("nm_dokter"));
            listData.add(m);
        }
        rajalTable.setItems(listData);
    }
    @FXML
    void pasienContexMenu(ContextMenuEvent event) {
    	if(cm.isShowing()) {
    		cm.hide();
    		cm.getItems().clear();
    	}
//    	System.out.println(rajalTable.getSelectionModel().getSelectedItem().getNo_rawat());
    	MenuItem mi1 = new MenuItem("Tindakan");
    	cm.getItems().add(mi1);
    	MenuItem mi2 = new MenuItem("Billing");
    	cm.getItems().add(mi2);
    	cm.show(rajalTable, event.getScreenX(), event.getScreenY());
    	
   
    	mi1.setOnAction((ActionEvent e) -> {
    	    System.out.println("Menu item 1");
    	    Object item = rajalTable.getSelectionModel().getSelectedItem();
    	    System.out.println("Selected item: " + item);
    	});
    	
    }
    @FXML
    void pasienClick(MouseEvent event) {
    	if(cm.isShowing()) {
    		cm.hide();
    		cm.getItems().clear();
    	}
    }
}
