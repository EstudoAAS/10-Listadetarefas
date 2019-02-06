package com.hudeing.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";

    public DBHelper(Context context) {
        super(context, this.NOME_DB, null, this.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " +
                this.TABELA_TAREFAS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL ); ";
        try {
            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela" );
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao criar a tabela " + e.getMessage() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF  EXISTS " + this.TABELA_TAREFAS + " ;";
        //String sql = "ALTER TABLE " + this.TABELA_TAREFAS + " ADD COLUMN status VARCHAR(2);";
        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualiza App" );
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao atualizar App " + e.getMessage() );
        }
    }
}
