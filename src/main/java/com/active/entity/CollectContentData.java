package com.active.entity;

import java.io.Serializable;
import java.util.Date;

public class CollectContentData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1600800734009562616L;

	private String id;

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

	private String remarks;

	private String delFlag;

	private String bizCategoryId;

	private String collectContentId;

	private String collectContentTitle;

	private String title;

	private String image;

	private Integer hits;

	private Integer actualHits;

	private Integer commentCount;

	private String status;

	private Date startDate;

	private Date endDate;

	private String source;

	private String content;

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

	public String getBizCategoryId() {
		return bizCategoryId;
	}

	public void setBizCategoryId(String bizCategoryId) {
		this.bizCategoryId = bizCategoryId == null ? null : bizCategoryId.trim();
	}

	public String getCollectContentId() {
		return collectContentId;
	}

	public void setCollectContentId(String collectContentId) {
		this.collectContentId = collectContentId == null ? null : collectContentId.trim();
	}

	public String getCollectContentTitle() {
		return collectContentTitle;
	}

	public void setCollectContentTitle(String collectContentTitle) {
		this.collectContentTitle = collectContentTitle == null ? null : collectContentTitle.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getActualHits() {
		return actualHits;
	}

	public void setActualHits(Integer actualHits) {
		this.actualHits = actualHits;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}