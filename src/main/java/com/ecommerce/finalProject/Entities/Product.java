package com.ecommerce.finalProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	private String imgurl;
	private String pname;
	private String prating;
	private String preview;
	private String pmaterial;
	private String pweight;
	private String pfinish;
	private String pdesc;
	private String pgender;
	private String pstyle;
	private String pinfo;
	private String pprice;
	private String ptotal;

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrating() {
		return prating;
	}

	public void setPrating(String prating) {
		this.prating = prating;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getPmaterial() {
		return pmaterial;
	}

	public void setPmaterial(String pmaterial) {
		this.pmaterial = pmaterial;
	}

	public String getPweight() {
		return pweight;
	}

	public void setPweight(String pweight) {
		this.pweight = pweight;
	}

	public String getPfinish() {
		return pfinish;
	}

	public void setPfinish(String pfinish) {
		this.pfinish = pfinish;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPgender() {
		return pgender;
	}

	public void setPgender(String pgender) {
		this.pgender = pgender;
	}

	public String getPstyle() {
		return pstyle;
	}

	public void setPstyle(String pstyle) {
		this.pstyle = pstyle;
	}

	public String getPinfo() {
		return pinfo;
	}

	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	public String getPprice() {
		return pprice;
	}

	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

	public String getPtotal() {
		return ptotal;
	}

	public void setPtotal(String ptotal) {
		this.ptotal = ptotal;
	}

}
