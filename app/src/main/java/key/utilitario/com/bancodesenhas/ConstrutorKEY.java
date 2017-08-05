package key.utilitario.com.bancodesenhas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freitas on 26/07/2017.
 */

public class ConstrutorKEY extends SQLiteOpenHelper{


    private static final String DATABASE_NAME = "senha";
    private static final int versao = 3;
    private static final String tabelaKEY =
            "CREATE TABLE senha(" +
                    "id INTEGER PRIMARY KEY," +
                    "key TEXT" +
                    ");";
    private static final String apagarKEY = "DROPTABLE TABLE IF EXISTS senha;";

    public ConstrutorKEY(Context context) {
        super(context, DATABASE_NAME, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabelaKEY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(apagarKEY);

        onCreate(db);
    }

    public long inserir(ContentValues cv){
        SQLiteDatabase db = this.getWritableDatabase();

        long id = db.insert("senha", null, cv);

        return id;
    }

    public List<ContentValues>achar(Integer id){
        String key = "SELECT * from senha where id == 1;";
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

                lista.add(cv);
           }while(c.moveToNext());

        }
        return lista;
    }

}
