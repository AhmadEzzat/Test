package com.test.simplecursoradapter;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Main extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
TextView tv = (TextView) findViewById(R.id.textViewS);
		SQLiteDatabase db = openOrCreateDatabase("myDatabase", MODE_PRIVATE,
				null);
		db.execSQL("create table if not exists accounts (_id int(3) primary key autoincrement, name varchar , password varchar , emaill varchar);");
		db.execSQL("insert into accounts values (1, 'a', 'b', 'c');");
		db.execSQL("insert into accounts values (3, 'd', 'e', 'f');");
		db.close();
		Cursor c = db.rawQuery("select * from accounts;", null);
		c.moveToFirst();
		tv.setText(c.getString(1));
//		String[] columns = { "_id", "name", "password", "emaill" };
//		int[] views = { R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4 };
//
//		SimpleCursorAdapter adapter = new SimpleCursorAdapter(Main.this,
//				R.layout.list_view, c, columns, views);
//		ListView lv = (ListView) findViewById(R.id.listView1);
//		lv.setAdapter(adapter);
//		c.close();
	}
}