package yarosia.coltivazionepeperoncini.content;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.util.Log;

import java.text.MessageFormat;

/**
 * Created by valen on 29/01/2016.
 */
public class PepperDB extends SQLiteOpenHelper {

    private static final String TAG = "PepperDB";

    private static final String DATABASE_NAME = "PEPPER.db";

    private static final int SCHEMA_VERSION = 1;

    public PepperDB(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"onCreate");


        /** Creazione Tabella Anni **/
        String anniTable = "CREATE TABLE {0} " +
                "({1} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "{2} TEXT NOT NULL, " +
                "{3} TEXT NOT NULL);";
        db.execSQL(MessageFormat.format(anniTable, AnniTable.TABLE_NAME, AnniTable._ID, AnniTable.ANNO, AnniTable.NOTE));
        Log.d(TAG, anniTable);

        /** Creazione Tabella Cultivar **/
        String cultivarTable = "CREATE TABLE {0}" +
                "({1} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "{2} TEXT NOT NULL," +
                "{3} INTEGER NOT NULL" +
                "{4} TEXT NOT NULL);";
        db.execSQL(MessageFormat.format(cultivarTable, CultivarTable.TABLE_NAME, CultivarTable._ID, CultivarTable.NOME, CultivarTable.SPECIE, CultivarTable.NOTE));
        Log.d(TAG,cultivarTable);

        /** Creazione Tabella Provenienza **/
        String provenienzaTable = "CREATE TABLE {0}" +
                "({1} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "{2} TEXT NOT NULL," +
                "{3} TEXT NOT NULL);";
        db.execSQL(MessageFormat.format(provenienzaTable, ProvenienzaTable.TABLE_NAME, ProvenienzaTable._ID, ProvenienzaTable.NOME, ProvenienzaTable.NOTE));
        Log.d(TAG,provenienzaTable);

        /** Creazione Tabella Specie **/
        String specieTable = "CREATE TABLE {0}" +
                "({1} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "{2} TEXT NOT NULL," +
                "{3} TEXT NOT NULL);";
        db.execSQL(MessageFormat.format(specieTable, SpecieTable._ID, SpecieTable._ID, SpecieTable.NOME, SpecieTable.NOTE));
        Log.d(TAG,specieTable);

        /** Creazione Tabella Semi **/
        String semiTable = "CREATE TABLE {0}" +
                "({1} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "{2} INTEGER NOT NULL," +
                "{3} TEXT NOT NULL," +
                "{4} INTEGER NOT NULL," +
                "{5} INTEGER NOT NULL," +
                "{6} TEXT NOT NULL," +
                "{7} TEXT NOT NULL," +
                "{8} TEXT NOT NULL," +
                "{9} TEXT NOT NULL," +
                "{10} TEXT NOT NULL," +
                "{11} INTEGER NOT NULL," + /** 0 false  1 true **/
                "{12} TEXT NOT NULL);";
        db.execSQL(MessageFormat.format(semiTable, SemiTable._ID, SemiTable.CULTIVAR, SemiTable.NOME, SemiTable.ANNO, SemiTable.PROVENIENZA, SemiTable.DATA_SEMINA, SemiTable.DATA_GERMINAZIONE, SemiTable.DATA_COTILEDONI, SemiTable.DATA_FOGLIE, SemiTable.DATA_TRAPIANTO, SemiTable.ISOLATO, SemiTable.NOTE));
        Log.d(TAG,semiTable);

        /** Inizializzazione Specie **/
        initSpecie(db);

    }

    private void initSpecie(SQLiteDatabase db){
        /** Chinense, Annuum, Frutescens, Wild, Pubescens, Baccatum **/
        aggiungiSpecie(db, "Chinense", "");
        aggiungiSpecie(db, "Annuum","");
        aggiungiSpecie(db, "Frutescens", "");
        aggiungiSpecie(db, "Wild","");
        aggiungiSpecie(db, "Pubescens", "");
        aggiungiSpecie(db, "Baccatum", "");
        Log.d(TAG,"initSpecie()");
    }
    /** -----------------Metodi CRUD----------------- **/

    /** Specie **/
    public void aggiungiSpecie(SQLiteDatabase db,String nome, String note){
        Log.d(TAG,"aggiungiSpecie("+nome+note+")");
        ContentValues v = new ContentValues();
        v.put(SpecieTable.NOME, nome);
        v.put(SpecieTable.NOTE, note);
        db.insert(SpecieTable.TABLE_NAME, null, v);

    }

    public Cursor getAllSpecie(){
        Log.d(TAG, "getAllSpecie()");

        return (getReadableDatabase().query(SpecieTable.TABLE_NAME,SpecieTable.COLUMNS,null,null,null,null,SpecieTable.NOME));
    }

    public int removeSpecie (long specieID) {
        Log.d(TAG, "removeSpecie(" + specieID + ")");
        SQLiteDatabase db = this.getReadableDatabase();

        return db.delete(SpecieTable.TABLE_NAME, SpecieTable._ID + " = ?", new String[]{String.valueOf(specieID)});
    }

    public int updateSpecie(){
        Log.d(TAG,"updateSpecie()");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SpecieTable.NOME, "nome");
        values.put(SpecieTable.NOTE, "note");

        return db.update(SpecieTable.TABLE_NAME, values, SpecieTable._ID + " = ?", new String[]{String.valueOf("specieid")});
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
