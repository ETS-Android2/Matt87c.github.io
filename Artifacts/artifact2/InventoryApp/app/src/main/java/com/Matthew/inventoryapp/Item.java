package com.Matthew.inventoryapp;



public class Item {

    int id;
	String user_email;
	//Artifact enhancement for item name
	String itemName;
    String desc;
    String qty;
	String unit;

    public Item() {
        super();
    }

    //Artifact enhancement for item name
    public Item(int i, String string, String name, String email, String description, String quantity) {
        super();
        this.id = i;
        this.itemName = name;
		this.user_email = email;
        this.desc = description;
        this.qty = quantity;
		this.unit = unit;
    }

    // constructor
    //Artifact enhancement for item name
    public Item(String email, String name, String description, String quantity, String unit) {
		this.user_email = email;
		this.itemName = name;
        this.desc = description;
        this.qty = quantity;
		this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getUserEmail() {
        return user_email;
    }

    public void setUserEmail(String user_email) {
        this.user_email = user_email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

	public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    //Artifact enhancement for item name
    public String getItemName() { return itemName; }

    public String setItemName(String name) { return itemName = itemName;
    }
}
