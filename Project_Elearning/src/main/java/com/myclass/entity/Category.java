package com.myclass.entity;

import javax.validation.constraints.NotBlank;

public class Category {
	private int id;

	@NotBlank(message = " Vui lòng nhập tiêu đề")
	private String title;

	@NotBlank(message = "Nhập icon")
	private String icon;

	private int orderIndex;

	public Category() {

	}

	public Category(int id, String title, String icon, int orderIndex) {

		this.id = id;
		this.title = title;
		this.icon = icon;
		this.orderIndex = orderIndex;
	}

	public Category(String title, String icon, int orderIndex) {

		this.title = title;
		this.icon = icon;
		this.orderIndex = orderIndex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", icon=" + icon + ", orderIndex=" + orderIndex + "]";
	}

}
