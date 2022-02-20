package com.Matthew.inventoryapp;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class SQLiteDatabase2 extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "ItemsData.DB";
    private static final String TABLE_NAME = "ItemsTable";

    private static final String COLUMN_0_ID = "id";
    private static final String COLUMN_1_USER_EMAIL = "email";
    //Artifact Enhancement
    private static final String COLUMN_2_ITEM_NAME = "Item name";
    private static final String COLUMN_3_DESCRIPTION = "description";
    private static final String COLUMN_4_QUANTITY = "quantity";
	private static final String COLUMN_5_UNIT = "unit";

	private static final String CREATE_ITEMS_TABLE = "CREATE TABLE IF NOT EXISTS " +
		TABLE_NAME + " (" +
		COLUMN_0_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
		COLUMN_1_USER_EMAIL + " VARCHAR, " +
            //Artifact enhancement
            COLUMN_2_ITEM_NAME + " , " +
            COLUMN_3_DESCRIPTION + " VARCHAR, " +
            COLUMN_4_QUANTITY + " VARCHAR, " +
            COLUMN_5_UNIT + " VARCHAR" + ");";

	public SQLiteDatabase2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

	/**
     * Database CRUD (Create, Read, Update, Delete) Operations
     */

	// Add item to database
	public void createItem(Item item) {
		SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_1_USER_EMAIL, item.getUserEmail());
        //Artifact enhancement
        values.put(COLUMN_2_ITEM_NAME, item.getItemName());
		values.put(COLUMN_3_DESCRIPTION, item.getDesc());
        values.put(COLUMN_4_QUANTITY, item.getQty());
		values.put(COLUMN_5_UNIT, item.getUnit());

        db.insert(TABLE_NAME, null, values);
        db.close();
	}

	// Read item from Database
	public Item readItem(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
        //Artifact enhancement
        Cursor cursor = db.query(TABLE_NAME,
			new String[] { COLUMN_0_ID, COLUMN_1_USER_EMAIL, COLUMN_2_ITEM_NAME, COLUMN_3_DESCRIPTION, COLUMN_4_QUANTITY, COLUMN_5_UNIT}, COLUMN_0_ID + " = ?",
            new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
			cursor.moveToFirst();

		Item item = new Item(Integer.parseInt(Objects.requireNonNull(cursor).getString(0)),
			cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));

        cursor.close();

        return item;
	}

	// Update item in database
    public int updateItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
		values.put(COLUMN_1_USER_EMAIL, item.getUserEmail());
		// Artifact enhancement
        values.put(COLUMN_2_ITEM_NAME, item.getItemName());
        values.put(COLUMN_3_DESCRIPTION, item.getDesc());
        values.put(COLUMN_4_QUANTITY, item.getQty());
		values.put(COLUMN_5_UNIT, item.getUnit());

        return db.update(TABLE_NAME, values, COLUMN_0_ID + " = ?", new String[] { String.valueOf(item.getId()) });
    }

	// Delete item from database
    public void deleteItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, COLUMN_0_ID + " = ?", new String[] { String.valueOf(item.getId()) });
        db.close();
    }

	/**
	 * Global Database Operations
	 */

	// Getting All Items
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(0)));
				item.setUserEmail(cursor.getString(1));
				//Artifact enhancement
				item.setItemName(cursor.getString(2));
                item.setDesc(cursor.getString(3));
                item.setQty(cursor.getString(4));
				item.setUnit(cursor.getString(5));

                itemList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return itemList;
    }

	// Deleting all items
    public void deleteAllItems() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();
    }

    // Getting Items Count
    public int getItemsCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int itemsTotal = cursor.getCount();
        cursor.close();

        return itemsTotal;
    }
}
