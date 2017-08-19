package com.active.entity;

import java.io.Serializable;
import java.util.Date;

public class ImageManage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1347189999296593917L;

	private String id;

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

	private String remarks;

	private String delFlag;

	private String type;

	private String image1;

	private String width1;

	private String height1;

	private String image2;

	private String width2;

	private String height2;

	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag == null ? null : delFlag.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1 == null ? null : image1.trim();
	}

	public String getWidth1() {
		return width1;
	}

	public void setWidth1(String width1) {
		this.width1 = width1 == null ? null : width1.trim();
	}

	public String getHeight1() {
		return height1;
	}

	public void setHeight1(String height1) {
		this.height1 = height1 == null ? null : height1.trim();
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2 == null ? null : image2.trim();
	}

	public String getWidth2() {
		return width2;
	}

	public void setWidth2(String width2) {
		this.width2 = width2 == null ? null : width2.trim();
	}

	public String getHeight2() {
		return height2;
	}

	public void setHeight2(String height2) {
		this.height2 = height2 == null ? null : height2.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}
}