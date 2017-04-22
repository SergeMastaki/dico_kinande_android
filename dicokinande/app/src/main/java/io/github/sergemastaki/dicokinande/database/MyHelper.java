package io.github.sergemastaki.dicokinande.database;
import android.database.sqlite.*;
import android.content.*;
import android.content.res.*;
import org.xmlpull.v1.*;
import java.io.*;
import io.github.sergemastaki.dicokinande.*;

public class MyHelper extends SQLiteOpenHelper {
    public static final  String DATABASE_NAME = "dicokinande.db";
    public static final  String TABLE_FR_KIN = "francais_kinande";
	public static final  String TABLE_KIN_FR = "kinande_francais";

    public static final  String COL_1 = "_id";
    public static final  String COL_2 = "mot";
    public static final  String COL_3 = "radical";
    public static final  String COL_4 = "variante";
	public static final  String COL_5 = "traduction";
	public static final  String COL_6 = "mot_cle";
	
	private Context context;

    public MyHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
		this.context = context;
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
	
	private synchronized boolean insererDonnees(SQLiteDatabase db) throws XmlPullParserException, IOException{
        ContentValues contentValues = new ContentValues();
		Resources res = context.getResources();
		XmlPullParser xpp = res.getXml(R.xml.dictionnaire_kinande);
		int eventType = xpp.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if(eventType == XmlPullParser.START_TAG){
				
			};
			/*switch(eventType){
				case XmlPullParser.START_DOCUMENT:
					System.out.println("DEBUT");
					break;
				case XmlPullParser.START_TAG:
					if(xpp.getName().equals("entree")){
						System.out.println("mot "+ n + " : "+xpp.getAttributeValue(0));
					}
					else
						System.out.print(xpp.getName()+ " : ");
					break;
				case XmlPullParser.TEXT:
					System.out.println(xpp.getText().replaceAll("\\s+"," "));
					break;
				case XmlPullParser.END_TAG:
					if(xpp.getName().equals("entree")){
						System.out.println("------");
						n++;
					}
					break;
			}*/
			eventType = xpp.next();
		}/*
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);*/
        long result;
		result = db.insert(TABLE_KIN_FR, null, contentValues);
        if (result == -1){
            return false;
        }
		return true;
	}
}
