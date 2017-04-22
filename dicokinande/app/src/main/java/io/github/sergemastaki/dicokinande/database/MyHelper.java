package io.github.sergemastaki.dicokinande.database;
import android.database.sqlite.*;
import android.content.*;
import android.content.res.*;

public class MyHelper extends SQLiteOpenHelper {
    public static final  String DATABASE_NAME = "dicokinande.db";
    public static final  String TABLE_FR_KIN = "FRANCAIS_KINANDE";
	public static final  String TABLE_KIN_FR = "KINANDE_FRANCAIS";

    public static final  String COL_1 = "ID";
    public static final  String COL_2 = "MOT";
    public static final  String COL_3 = "RADICAL";
    public static final  String COL_4 = "VARIANTE";
	public static final  String COL_5 = "TRADUCTION";
	public static final  String COL_6 = "MOT_CLE";

    public MyHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_KIN_FR + "("
		+ COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ COL_2 + " TEXT NOT NULL,"
		+ COL_3 + " TEXT,"
		+ COL_4 +" TEXT,"
		+ COL_5 + " TEXT NOT NULL,"
		+ COL_6 + " TEXT NOT NULL)");
		
		db.execSQL("CREATE TABLE " + TABLE_FR_KIN + "("
				   + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				   + COL_2 + " TEXT NOT NULL,"
				   + COL_3 + " TEXT,"
				   + COL_4 +" TEXT,"
				   + COL_5 + " TEXT NOT NULL,"
				   + COL_6 + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_KIN_FR);
		db.execSQL("DROP TABLE IF EXISTS "+ TABLE_FR_KIN);
	}
	
	/*private boolean insererDonnees(){
		SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       /* contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result = db.insert(TABLE_KIN_FR,null,contentValues);
        db.close();

        //To Check Whether Data is Inserted in DataBase
        if(result==-1){
            return false;
        }else{
            return true;
        }
	}*/
}
