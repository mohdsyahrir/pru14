package org.taiko.entity;
// Generated Apr 21, 2018 12:13:06 AM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pengundi generated by hbm2java
 */
@Entity
@Table(name = "pengundi", schema = "public")
public class Pengundi implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String noKp;
	private String nama;
	private String jantina;
	private String dm;
	private String kodLokaliti;
	private String lokaliti;
	private String kumpUmur;
	private String kumpKaum;
	private String telNo1;
	private String telNo2;
	private String alamat;
	private String alamatSt4;
	private String categoryA;
	private String categoryB;
	private String categoryC;
	private String categoryD;
	private String categoryE;
	private String categoryF;
	private String categoryG;
	private String categoryH;
	private String flagMasuk;
	private String flagKeluar;
	private String statusPengundi;
	private String statusAlamat;
	private String categoryI;

	public Pengundi() {
	}

	public Pengundi(String noKp) {
		this.noKp = noKp;
	}

	public Pengundi(String noKp, String nama, String jantina, String dm, String kodLokaliti, String lokaliti,
			String kumpUmur, String kumpKaum, String telNo1, String telNo2, String alamat, String alamatSt4,
			String categoryA, String categoryB, String categoryC, String categoryD, String categoryE, String categoryF,
			String categoryG, String categoryH, String flagMasuk, String flagKeluar, String statusPengundi,
			String statusAlamat, String categoryI) {
		this.noKp = noKp;
		this.nama = nama;
		this.jantina = jantina;
		this.dm = dm;
		this.kodLokaliti = kodLokaliti;
		this.lokaliti = lokaliti;
		this.kumpUmur = kumpUmur;
		this.kumpKaum = kumpKaum;
		this.telNo1 = telNo1;
		this.telNo2 = telNo2;
		this.alamat = alamat;
		this.alamatSt4 = alamatSt4;
		this.categoryA = categoryA;
		this.categoryB = categoryB;
		this.categoryC = categoryC;
		this.categoryD = categoryD;
		this.categoryE = categoryE;
		this.categoryF = categoryF;
		this.categoryG = categoryG;
		this.categoryH = categoryH;
		this.flagMasuk = flagMasuk;
		this.flagKeluar = flagKeluar;
		this.statusPengundi = statusPengundi;
		this.statusAlamat = statusAlamat;
		this.categoryI = categoryI;
	}

	@Id

	@Column(name = "no_kp", unique = true, nullable = false, length = 20)
	public String getNoKp() {
		return this.noKp;
	}

	public void setNoKp(String noKp) {
		this.noKp = noKp;
	}

	@Column(name = "nama")
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Column(name = "jantina", length = 1)
	public String getJantina() {
		return this.jantina;
	}

	public void setJantina(String jantina) {
		this.jantina = jantina;
	}

	@Column(name = "dm", length = 100)
	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	@Column(name = "kod_lokaliti")
	public String getKodLokaliti() {
		return this.kodLokaliti;
	}

	public void setKodLokaliti(String kodLokaliti) {
		this.kodLokaliti = kodLokaliti;
	}

	@Column(name = "lokaliti", length = 500)
	public String getLokaliti() {
		return this.lokaliti;
	}

	public void setLokaliti(String lokaliti) {
		this.lokaliti = lokaliti;
	}

	@Column(name = "kump_umur", length = 100)
	public String getKumpUmur() {
		return this.kumpUmur;
	}

	public void setKumpUmur(String kumpUmur) {
		this.kumpUmur = kumpUmur;
	}

	@Column(name = "kump_kaum", length = 100)
	public String getKumpKaum() {
		return this.kumpKaum;
	}

	public void setKumpKaum(String kumpKaum) {
		this.kumpKaum = kumpKaum;
	}

	@Column(name = "tel_no1", length = 200)
	public String getTelNo1() {
		return this.telNo1;
	}

	public void setTelNo1(String telNo1) {
		this.telNo1 = telNo1;
	}

	@Column(name = "tel_no2", length = 200)
	public String getTelNo2() {
		return this.telNo2;
	}

	public void setTelNo2(String telNo2) {
		this.telNo2 = telNo2;
	}

	@Column(name = "alamat", length = 500)
	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	@Column(name = "alamat_st4", length = 500)
	public String getAlamatSt4() {
		return this.alamatSt4;
	}

	public void setAlamatSt4(String alamatSt4) {
		this.alamatSt4 = alamatSt4;
	}

	@Column(name = "category_a", length = 1)
	public String getCategoryA() {
		return this.categoryA;
	}

	public void setCategoryA(String categoryA) {
		this.categoryA = categoryA;
	}

	@Column(name = "category_b", length = 1)
	public String getCategoryB() {
		return this.categoryB;
	}

	public void setCategoryB(String categoryB) {
		this.categoryB = categoryB;
	}

	@Column(name = "category_c", length = 1)
	public String getCategoryC() {
		return this.categoryC;
	}

	public void setCategoryC(String categoryC) {
		this.categoryC = categoryC;
	}

	@Column(name = "category_d", length = 1)
	public String getCategoryD() {
		return this.categoryD;
	}

	public void setCategoryD(String categoryD) {
		this.categoryD = categoryD;
	}

	@Column(name = "category_e", length = 1)
	public String getCategoryE() {
		return this.categoryE;
	}

	public void setCategoryE(String categoryE) {
		this.categoryE = categoryE;
	}

	@Column(name = "category_f", length = 1)
	public String getCategoryF() {
		return this.categoryF;
	}

	public void setCategoryF(String categoryF) {
		this.categoryF = categoryF;
	}

	@Column(name = "category_g", length = 1)
	public String getCategoryG() {
		return this.categoryG;
	}

	public void setCategoryG(String categoryG) {
		this.categoryG = categoryG;
	}

	@Column(name = "category_h", length = 1)
	public String getCategoryH() {
		return this.categoryH;
	}

	public void setCategoryH(String categoryH) {
		this.categoryH = categoryH;
	}

	@Column(name = "flag_masuk", length = 1)
	public String getFlagMasuk() {
		return this.flagMasuk;
	}

	public void setFlagMasuk(String flagMasuk) {
		this.flagMasuk = flagMasuk;
	}

	@Column(name = "flag_keluar", length = 1)
	public String getFlagKeluar() {
		return this.flagKeluar;
	}

	public void setFlagKeluar(String flagKeluar) {
		this.flagKeluar = flagKeluar;
	}

	@Column(name = "status_pengundi", length = 10)
	public String getStatusPengundi() {
		return this.statusPengundi;
	}

	public void setStatusPengundi(String statusPengundi) {
		this.statusPengundi = statusPengundi;
	}

	@Column(name = "status_alamat", length = 50)
	public String getStatusAlamat() {
		return this.statusAlamat;
	}

	public void setStatusAlamat(String statusAlamat) {
		this.statusAlamat = statusAlamat;
	}

	@Column(name = "category_i", length = 1)
	public String getCategoryI() {
		return this.categoryI;
	}

	public void setCategoryI(String categoryI) {
		this.categoryI = categoryI;
	}

}
