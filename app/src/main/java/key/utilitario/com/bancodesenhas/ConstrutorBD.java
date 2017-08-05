package key.utilitario.com.bancodesenhas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freitas on 26/07/2017.
 */

public class ConstrutorBD extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "chave";
        private static final int versao = 3;
        private static final String tabelaBD =
                "CREATE TABLE chaves(" +
                        "id INTEGER PRIMARY KEY AUTOINCCREMENT," +
                        "key TEXT" +
                        "nome TEXT" +
                        "Data date" +
                        ");";
        private static final String apagarBD = "DROPTABLE TABLE IF EXISTS chaves;";

    public ConstrutorBD(Context context) {
        super(context, DATABASE_NAME, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(tabelaBD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(apagarBD);

        onCreate(db);
    }


    public long inserir(ContentValues cv){
        SQLiteDatabase db = this.getWritableDatabase();

        long id = db.insert("chaves", null, cv);

        return id;
    }

    public List<ContentValues> achar(String chave){
        String key = "SELECT * FROM senha ORDER BY id;";
        String where[] = null;

        return pesquisar(key, where);
    }

    private List<ContentValues> pesquisar(String sql, String where[]){
        List<ContentValues> lista = new ArrayList<>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(sql, where);

        if(c.moveToFirst()){
            do{
                ContentValues cv = new ContentValues();

                cv.put("id", c.getInt(c.getColumnIndex("id")));

                cv.put("key", c.getString(c.getColumnIndex("key")));

                cv.put("nome", c.getString(c.getColumnIndex("nome")));

                cv.put("Data", c.getString(c.getColumnIndex("Data")));

                lista.add(cv);
            }while(c.moveToNext());

        }
        return lista;
    }
    private List<ContentValues> validar(String sql, String where[]) {
        ContentValues cv = new ContentValues();
        List<ContentValues> lista = new ArrayList<>();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(sql, where);

        if(c.moveToFirst()) {
            cv.put("key", c.getInt(c.getColumnIndex("key")));
        }
        return lista;
    }

}

