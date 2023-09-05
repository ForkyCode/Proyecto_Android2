package com.example.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Ejemplo_BD";
    private static final String TABLE_NAME = "Usuarios";
    private static final String COL_CED = "CedBD";
    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_CELULAR = "Celular";
    private static final String COL_CONTRASENA = "Contrasena";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    //Método constructror que crea la base de datos
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_CED + " TEXT PRIMARY KEY," +
                COL_NOMBRE + " TEXT," +
                COL_CELULAR + " TEXT," +
                COL_CONTRASENA + " TEXT)";
        db.execSQL(createTableQuery);
    }
    //Este método elimina la tabla existente y luego crea una nueva versión de la misma con los datos actualizados
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    //Este método registra los datos de nuevos usuarios en la base de datos y devuelve un booleano
    public boolean Registrar(String cedula, String nombre, String celular, String contrasena) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CED, cedula);
        contentValues.put(COL_NOMBRE, nombre);
        contentValues.put(COL_CELULAR, celular);
        contentValues.put(COL_CONTRASENA, contrasena);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
    //Este método se usa para validar los datos de lo usuarios en la base de datos y devuelve un booleano
    public boolean Validar(String cedula, String contrasena) {
        SQLiteDatabase db = this.getReadableDatabase();             //Esto crea una una versión para sobreescribible de la base de datos para escribir información en ella
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COL_CED + " = '" + cedula + "' AND " +
                COL_CONTRASENA + " = '" + contrasena + "'";
        //Esta consulta busca en toda la base de datos la fila
        // donde los datos coincidan con la información con los que son enviados al método desde la clase que hace el llamado
        Cursor cursor = db.rawQuery(query, null); //Este es un método que ejecuta la consulta (el query) y almacena el resultado en la variable Cursor
        //este valor será un número entero que indicará la posición o número de la fila para que luego este pueda ser usado en el método "ObtenerNombre"
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }
    //Este método busca y devuelve el valor de la columna "Nombre" en la base de datos
    public String obtenerNombre(String cedula) {
        SQLiteDatabase db = this.getReadableDatabase();                 //Esto crea una una versión de sólo lectura de la base de datos para buscar información en ella
        String query = "SELECT " + COL_NOMBRE + " FROM " + TABLE_NAME + " WHERE " +
                COL_CED + " = '" + cedula + "'";            //Esta consulta busca el nombre en una fila donde el valor de la cédula coincida
        // con el valor ingresado en el EditText de la clase que hace el llamado de este método
        Cursor cursor = db.rawQuery(query, null);
        String nombre = "";
        if (cursor.moveToFirst()) {
            nombre = cursor.getString(0);
        }
        cursor.close();
        return nombre;
    }

    public Cursor VerDatos() {
        SQLiteDatabase db = this.getReadableDatabase(); //Esto crea una una versión de sólo lectura de la base de datos para ver la información en ella
        String query = "SELECT * FROM " + TABLE_NAME; //Consulta para ver toda la información ingresada en la tabla
        return db.rawQuery(query, null); //Ejecuta la consulta
    }
}
