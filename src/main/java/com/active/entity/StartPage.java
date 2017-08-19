package com.active.entity;

import java.io.Serializable;
import java.util.Date;

public class StartPage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7762208274542686161L;

	private String id;

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

	private String remarks;

	private String delFlag;

	private String url;

	private Integer time;

	private String jump;

	private String image;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump == null ? null : jump.trim();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}
}