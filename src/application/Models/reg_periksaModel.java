package application.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class reg_periksaModel {
	public reg_periksaModel() {
		
	}
	public StringProperty getNo_reg() {
		return no_reg;
	}
	public void setNo_reg(String no_reg) {
		this.no_reg.setValue(no_reg);;
	}
	public StringProperty getNo_rawat() {
		return no_rawat;
	}
	public void setNo_rawat(String no_rawat) {
		this.no_rawat.setValue(no_rawat);;
	}
	public StringProperty getJam_reg() {
		return jam_reg;
	}
	public void setJam_reg(String jam_reg) {
		this.jam_reg.setValue(jam_reg);;
	}
	public StringProperty getTgl_registrasi() {
		return tgl_registrasi;
	}
	public void setTgl_registrasi(String tgl_registrasi) {
		this.tgl_registrasi.setValue(tgl_registrasi);;
	}
	public StringProperty getKd_dokter() {
		return kd_dokter;
	}
	public void setKd_dokter(String kd_dokter) {
		this.kd_dokter.setValue(kd_dokter);;
	}
	public StringProperty getKd_poli() {
		return kd_poli;
	}
	public void setKd_poli(String kd_poli) {
		this.kd_poli.setValue(kd_poli);
	}
	public StringProperty getNo_rkm_medis() {
		return no_rkm_medis;
	}
	public void setNo_rkm_medis(String no_rkm_medis) {
		this.no_rkm_medis.setValue(no_rkm_medis);;
	}
	public StringProperty getNm_pasien() {
		return nm_pasien;
	}
	public void setNm_pasien(String nm_pasien) {
		this.nm_pasien.setValue(nm_pasien);;
	}
	public StringProperty getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat.setValue(alamat);;
	}
	public StringProperty getNm_poli() {
		return nm_poli;
	}
	public void setNm_poli(String nm_poli) {
		this.nm_poli.setValue(nm_poli);;
	}
	public StringProperty getNm_dokter() {
		return nm_dokter;
	}
	public void setNm_dokter(String nm_dokter) {
		this.nm_dokter.setValue(nm_dokter);;
	}
	private StringProperty no_reg= new SimpleStringProperty();
	private StringProperty no_rawat= new SimpleStringProperty();
	private StringProperty tgl_registrasi= new SimpleStringProperty();
	private StringProperty jam_reg= new SimpleStringProperty();
	private StringProperty kd_dokter= new SimpleStringProperty();
	private StringProperty no_rkm_medis= new SimpleStringProperty();
	private StringProperty nm_pasien= new SimpleStringProperty();
	private StringProperty alamat= new SimpleStringProperty();
	private StringProperty kd_poli= new SimpleStringProperty();
	private StringProperty nm_poli= new SimpleStringProperty();
	private StringProperty nm_dokter= new SimpleStringProperty();
}
