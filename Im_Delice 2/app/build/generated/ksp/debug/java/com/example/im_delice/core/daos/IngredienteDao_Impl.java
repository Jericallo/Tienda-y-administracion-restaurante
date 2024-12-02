package com.example.im_delice.core.daos;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.im_delice.core.entities.Ingrediente;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class IngredienteDao_Impl implements IngredienteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Ingrediente> __insertionAdapterOfIngrediente;

  private final EntityDeletionOrUpdateAdapter<Ingrediente> __deletionAdapterOfIngrediente;

  private final EntityDeletionOrUpdateAdapter<Ingrediente> __updateAdapterOfIngrediente;

  public IngredienteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIngrediente = new EntityInsertionAdapter<Ingrediente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Ingredientes` (`id`,`nombre`,`Categoria`,`disponibilidad`,`precioExtra`,`foto`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Ingrediente entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        statement.bindLong(3, entity.getCategoria());
        final int _tmp = entity.getDisponibilidad() ? 1 : 0;
        statement.bindLong(4, _tmp);
        statement.bindDouble(5, entity.getPrecioExtra());
        statement.bindString(6, entity.getFoto());
      }
    };
    this.__deletionAdapterOfIngrediente = new EntityDeletionOrUpdateAdapter<Ingrediente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Ingredientes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Ingrediente entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfIngrediente = new EntityDeletionOrUpdateAdapter<Ingrediente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Ingredientes` SET `id` = ?,`nombre` = ?,`Categoria` = ?,`disponibilidad` = ?,`precioExtra` = ?,`foto` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Ingrediente entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        statement.bindLong(3, entity.getCategoria());
        final int _tmp = entity.getDisponibilidad() ? 1 : 0;
        statement.bindLong(4, _tmp);
        statement.bindDouble(5, entity.getPrecioExtra());
        statement.bindString(6, entity.getFoto());
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public long InsertarIngrediente(final Ingrediente obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfIngrediente.insertAndReturnId(obj);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int EliminarIngrediente(final Ingrediente obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __deletionAdapterOfIngrediente.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int ActualizarIngrediente(final Ingrediente obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __updateAdapterOfIngrediente.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Ingrediente> obtenerIngrendientes() {
    final String _sql = "SELECT * FROM Ingredientes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "Categoria");
      final int _cursorIndexOfDisponibilidad = CursorUtil.getColumnIndexOrThrow(_cursor, "disponibilidad");
      final int _cursorIndexOfPrecioExtra = CursorUtil.getColumnIndexOrThrow(_cursor, "precioExtra");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final List<Ingrediente> _result = new ArrayList<Ingrediente>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Ingrediente _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final boolean _tmpDisponibilidad;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDisponibilidad);
        _tmpDisponibilidad = _tmp != 0;
        final double _tmpPrecioExtra;
        _tmpPrecioExtra = _cursor.getDouble(_cursorIndexOfPrecioExtra);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _item = new Ingrediente(_tmpId,_tmpNombre,_tmpCategoria,_tmpDisponibilidad,_tmpPrecioExtra,_tmpFoto);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int verificarIngrediente(final String nombre) {
    final String _sql = "SELECT COUNT(*) FROM Ingredientes WHERE nombre = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, nombre);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Ingrediente ObtenerIngredientePorId(final int id) {
    final String _sql = "SELECT * FROM Ingredientes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "Categoria");
      final int _cursorIndexOfDisponibilidad = CursorUtil.getColumnIndexOrThrow(_cursor, "disponibilidad");
      final int _cursorIndexOfPrecioExtra = CursorUtil.getColumnIndexOrThrow(_cursor, "precioExtra");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final Ingrediente _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final boolean _tmpDisponibilidad;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDisponibilidad);
        _tmpDisponibilidad = _tmp != 0;
        final double _tmpPrecioExtra;
        _tmpPrecioExtra = _cursor.getDouble(_cursorIndexOfPrecioExtra);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _result = new Ingrediente(_tmpId,_tmpNombre,_tmpCategoria,_tmpDisponibilidad,_tmpPrecioExtra,_tmpFoto);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Ingrediente> ObtenerIngredientesOrdenadosPorNombreAsc() {
    final String _sql = "SELECT * FROM Ingredientes ORDER BY nombre ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "Categoria");
      final int _cursorIndexOfDisponibilidad = CursorUtil.getColumnIndexOrThrow(_cursor, "disponibilidad");
      final int _cursorIndexOfPrecioExtra = CursorUtil.getColumnIndexOrThrow(_cursor, "precioExtra");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final List<Ingrediente> _result = new ArrayList<Ingrediente>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Ingrediente _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final boolean _tmpDisponibilidad;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDisponibilidad);
        _tmpDisponibilidad = _tmp != 0;
        final double _tmpPrecioExtra;
        _tmpPrecioExtra = _cursor.getDouble(_cursorIndexOfPrecioExtra);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _item = new Ingrediente(_tmpId,_tmpNombre,_tmpCategoria,_tmpDisponibilidad,_tmpPrecioExtra,_tmpFoto);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Ingrediente> ObtenerIngredientesOrdenadosPorCategoriaAsc() {
    final String _sql = "SELECT * FROM Ingredientes ORDER BY Categoria ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "Categoria");
      final int _cursorIndexOfDisponibilidad = CursorUtil.getColumnIndexOrThrow(_cursor, "disponibilidad");
      final int _cursorIndexOfPrecioExtra = CursorUtil.getColumnIndexOrThrow(_cursor, "precioExtra");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final List<Ingrediente> _result = new ArrayList<Ingrediente>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Ingrediente _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final boolean _tmpDisponibilidad;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDisponibilidad);
        _tmpDisponibilidad = _tmp != 0;
        final double _tmpPrecioExtra;
        _tmpPrecioExtra = _cursor.getDouble(_cursorIndexOfPrecioExtra);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _item = new Ingrediente(_tmpId,_tmpNombre,_tmpCategoria,_tmpDisponibilidad,_tmpPrecioExtra,_tmpFoto);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Ingrediente> ObtenerIngredientesOrdenadosPorDisponibilidad() {
    final String _sql = "SELECT * FROM Ingredientes ORDER BY disponibilidad DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "Categoria");
      final int _cursorIndexOfDisponibilidad = CursorUtil.getColumnIndexOrThrow(_cursor, "disponibilidad");
      final int _cursorIndexOfPrecioExtra = CursorUtil.getColumnIndexOrThrow(_cursor, "precioExtra");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final List<Ingrediente> _result = new ArrayList<Ingrediente>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Ingrediente _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final boolean _tmpDisponibilidad;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDisponibilidad);
        _tmpDisponibilidad = _tmp != 0;
        final double _tmpPrecioExtra;
        _tmpPrecioExtra = _cursor.getDouble(_cursorIndexOfPrecioExtra);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _item = new Ingrediente(_tmpId,_tmpNombre,_tmpCategoria,_tmpDisponibilidad,_tmpPrecioExtra,_tmpFoto);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
