package com.Matthew.inventoryapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {

	Activity activity;
    Button LoginButton, RegisterButton, ForgotPassButton;
    EditText Email, Password;
    String NameHolder, PhoneNumberHolder, EmailHolder, PasswordHolder;
    Boolean EmptyHolder;
	PopupWindow popwindow;
    android.database.sqlite.SQLiteDatabase db;
    SQLiteDatabase1 handler;
    String TempPassword = "NOT_FOUND" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;

        LoginButton = findViewById(R.id.signinButton);
        RegisterButton = findViewById(R.id.registerButton);
        ForgotPassButton = findViewById(R.id.forgotPasswordButton);
        Email = findViewById(R.id.editTextEmailAddress);
        Password = findViewById(R.id.editTextPassword);
        handler = new SQLiteDatabase1(this);

        // Adding click listener to sign in forgotPasswordButton
        LoginButton.setOnClickListener(view -> {
            // Call Login function
            LoginFunction();
        });

        // Adding click listener to register forgotPasswordButton.
        RegisterButton.setOnClickListener(view -> {
            // Opening new RegisterActivity using intent on forgotPasswordButton click.
            Intent intent = new Intent(Login.this, Registration.class);
            startActivity(intent);
        });

		// Adding click listener to register forgotPasswordButton.
		ForgotPassButton.setOnClickListener(view -> {
			EmailHolder = Email.getText().toString().trim();

			if (!EmailHolder.isEmpty()) {
				forgotPassPopup();
			} else {
				Toast.makeText(Login.this, "User Email is Empty", Toast.LENGTH_LONG).show();
			}
		});
    }

    // Login function
    public void LoginFunction() {
		String message = CheckEditTextNotEmpty();

        if(!EmptyHolder) {
            // Opening SQLite database write permission
            db = handler.getWritableDatabase();

            // Adding search email query to cursor
            Cursor cursor = db.query(SQLiteDatabase1.TABLE_NAME, null, " " + SQLiteDatabase1.COLUMN_3_EMAIL + "=?", new String[]{EmailHolder}, null, null, null);

            while (cursor.moveToNext()) {
                if (cursor.isFirst()) {
                    cursor.moveToFirst();

                    // Storing Password and Name associated with entered email
                    TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteDatabase1.COLUMN_4_PASSWORD));
                    NameHolder = cursor.getString(cursor.getColumnIndex(SQLiteDatabase1.COLUMN_1_NAME));
                    PhoneNumberHolder = cursor.getString(cursor.getColumnIndex(SQLiteDatabase1.COLUMN_2_PHONE_NUMBER));

                    // Closing cursor.
                    cursor.close();
                }
            }
			handler.close();

            // Calling method to check final result
            CheckFinalResult();
        } else {
            //If any of login EditText empty then this block will be executed.
            Toast.makeText(Login.this, message, Toast.LENGTH_LONG).show();
        }
    }

    // Checking editText fields are not empty.
	public String CheckEditTextNotEmpty() {
		// Getting value from fields and storing into string variable
		String message = "";
		EmailHolder = Email.getText().toString().trim();
		PasswordHolder = Password.getText().toString().trim();

		if (EmailHolder.isEmpty()){
			Email.requestFocus();
			EmptyHolder = true;
			message = "User Email is Empty";
		} else if (PasswordHolder.isEmpty()){
			Password.requestFocus();
			EmptyHolder = true;
			message = "User Password is Empty";
		} else {
			EmptyHolder = false;
		}
		return message;
	}

    // Checking entered password from SQLite database email associated password
    public void CheckFinalResult(){
        if(TempPassword.equalsIgnoreCase(PasswordHolder)) {
            Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();

            // Sending Name to ItemsListActivity using intent
            Bundle bundle = new Bundle();
            bundle.putString("user_name", NameHolder);
            bundle.putString("user_email", EmailHolder);
            bundle.putString("user_phone", PhoneNumberHolder);

            // Going to ItemsListActivity after login success message
            Intent intent = new Intent(Login.this, List.class);
            intent.putExtras(bundle);
            startActivity(intent);

            // Empty editText  after login successful and close database
            EmptyEditTextAfterDataInsert();
        } else {
            // Display error message if credentials are not correct
            Toast.makeText(Login.this,"Incorrect Email or Password\nor User Not Registered",Toast.LENGTH_LONG).show();
        }
        TempPassword = "NOT_FOUND" ;
    }

    // Empty edittext after login successful
    public void EmptyEditTextAfterDataInsert() {
        Email.getText().clear();
        Password.getText().clear();
    }

	public void forgotPassPopup() {
		LayoutInflater inflater = activity.getLayoutInflater();
		View layout = inflater.inflate(R.layout.forgot_pass_popup, activity.findViewById(R.id.popup_element));

		popwindow = new PopupWindow(layout, 800, 800, true);
		popwindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

		EditText phone = layout.findViewById(R.id.editTextItemDescriptionPopup);
		TextView password = layout.findViewById(R.id.textViewPassword);

		// Opening SQLite database write permission
		db = handler.getWritableDatabase();

		// Adding search email query to cursor
		Cursor cursor = db.query(SQLiteDatabase1.TABLE_NAME, null, " " + SQLiteDatabase1.COLUMN_3_EMAIL + "=?", new String[]{EmailHolder}, null, null, null);

		while (cursor.moveToNext()) {
			if (cursor.isFirst()) {
				cursor.moveToFirst();

				// Storing Password and Name associated with entered email
				PhoneNumberHolder = cursor.getString(cursor.getColumnIndex(SQLiteDatabase1.COLUMN_2_PHONE_NUMBER));
				TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteDatabase1.COLUMN_4_PASSWORD));

				// Closing cursor.
				cursor.close();
			}
		}
		handler.close();

		Button get = layout.findViewById(R.id.forgotGetButton);
		Button cancel = layout.findViewById(R.id.forgotCancelButton);

		get.setOnClickListener(view -> {
			String verifyPhone = phone.getText().toString();

			if(verifyPhone.equals(PhoneNumberHolder)) {
				password.setText(TempPassword);

				new android.os.Handler().postDelayed(() -> popwindow.dismiss(), 2000);
			} else {
				Toast.makeText(activity, "Phone Not Match", Toast.LENGTH_LONG).show();
			}
		});

		cancel.setOnClickListener(view -> {
			Toast.makeText(activity, "Action Canceled", Toast.LENGTH_SHORT).show();
			popwindow.dismiss();
		});
	}
}
