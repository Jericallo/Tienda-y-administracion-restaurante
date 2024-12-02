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
import com.example.im_delice.core.entities.Comida;
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
public final class ComidaDao_Impl implements ComidaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Comida> __insertionAdapterOfComida;

  private final EntityDeletionOrUpdateAdapter<Comida> __deletionAdapterOfComida;

  private final EntityDeletionOrUpdateAdapter<Comida> __updateAdapterOfComida;

  public ComidaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfComida = new EntityInsertionAdapter<Comida>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Comidas` (`id`,`nombre`,`descripcion`,`precio`,`fotoUrl`,`categoria`,`estado`,`Max_Ingredientes`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Comida entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        if (entity.getDescripcion() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescripcion());
        }
        statement.bindDouble(4, entity.getPrecio());
        statement.bindString(5, entity.getFotoUrl());
        statement.bindLong(6, entity.getCategoria());
        statement.bindString(7, entity.getEstado());
        statement.bindLong(8, entity.getMax_Ingredientes());
      }
    };
    this.__deletionAdapterOfComida = new EntityDeletionOrUpdateAdapter<Comida>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Comidas` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Comida entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfComida = new EntityDeletionOrUpdateAdapter<Comida>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Comidas` SET `id` = ?,`nombre` = ?,`descripcion` = ?,`precio` = ?,`fotoUrl` = ?,`categoria` = ?,`estado` = ?,`Max_Ingredientes` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Comida entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        if (entity.getDescripcion() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescripcion());
        }
        statement.bindDouble(4, entity.getPrecio());
        statement.bindString(5, entity.getFotoUrl());
        statement.bindLong(6, entity.getCategoria());
        statement.bindString(7, entity.getEstado());
        statement.bindLong(8, entity.getMax_Ingredientes());
        statement.bindLong(9, entity.getId());
      }
    };
  }

  @Override
  public long InsertarComida(final Comida obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfComida.insertAndReturnId(obj);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int EliminarComida(final Comida obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __deletionAdapterOfComida.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int ActualizarComida(final Comida obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __updateAdapterOfComida.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Comida> ObtenerTodosComidas() {
    final String _sql = "SELECT * FROM Comidas";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
      final int _cursorIndexOfFotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoUrl");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "categoria");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final int _cursorIndexOfMaxIngredientes = CursorUtil.getColumnIndexOrThrow(_cursor, "Max_Ingredientes");
      final List<Comida> _result = new ArrayList<Comida>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Comida _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final double _tmpPrecio;
        _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
        final String _tmpFotoUrl;
        _tmpFotoUrl = _cursor.getString(_cursorIndexOfFotoUrl);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final String _tmpEstado;
        _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        final int _tmpMax_Ingredientes;
        _tmpMax_Ingredientes = _cursor.getInt(_cursorIndexOfMaxIngredientes);
        _item = new Comida(_tmpId,_tmpNombre,_tmpDescripcion,_tmpPrecio,_tmpFotoUrl,_tmpCategoria,_tmpEstado,_tmpMax_Ingredientes);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Comida ObtenerComidaPorId(final int id) {
    final String _sql = "SELECT * FROM Comidas WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
      final int _cursorIndexOfFotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoUrl");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "categoria");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final int _cursorIndexOfMaxIngredientes = CursorUtil.getColumnIndexOrThrow(_cursor, "Max_Ingredientes");
      final Comida _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final double _tmpPrecio;
        _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
        final String _tmpFotoUrl;
        _tmpFotoUrl = _cursor.getString(_cursorIndexOfFotoUrl);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final String _tmpEstado;
        _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        final int _tmpMax_Ingredientes;
        _tmpMax_Ingredientes = _cursor.getInt(_cursorIndexOfMaxIngredientes);
        _result = new Comida(_tmpId,_tmpNombre,_tmpDescripcion,_tmpPrecio,_tmpFotoUrl,_tmpCategoria,_tmpEstado,_tmpMax_Ingredientes);
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
  public int verificarComida(final String nombre) {
    final String _sql = "SELECT COUNT(*) FROM Comidas WHERE nombre = ?";
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
  public List<Comida> ObtenerComidasOrdenadasPorPrecioDesc() {
    final String _sql = "SELECT * FROM Comidas ORDER BY precio DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
      final int _cursorIndexOfFotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoUrl");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "categoria");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final int _cursorIndexOfMaxIngredientes = CursorUtil.getColumnIndexOrThrow(_cursor, "Max_Ingredientes");
      final List<Comida> _result = new ArrayList<Comida>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Comida _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final double _tmpPrecio;
        _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
        final String _tmpFotoUrl;
        _tmpFotoUrl = _cursor.getString(_cursorIndexOfFotoUrl);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final String _tmpEstado;
        _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        final int _tmpMax_Ingredientes;
        _tmpMax_Ingredientes = _cursor.getInt(_cursorIndexOfMaxIngredientes);
        _item = new Comida(_tmpId,_tmpNombre,_tmpDescripcion,_tmpPrecio,_tmpFotoUrl,_tmpCategoria,_tmpEstado,_tmpMax_Ingredientes);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Comida> ObtenerComidasOrdenadasPorPrecioAsc() {
    final String _sql = "SELECT * FROM Comidas ORDER BY precio ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
      final int _cursorIndexOfFotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoUrl");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "categoria");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final int _cursorIndexOfMaxIngredientes = CursorUtil.getColumnIndexOrThrow(_cursor, "Max_Ingredientes");
      final List<Comida> _result = new ArrayList<Comida>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Comida _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final double _tmpPrecio;
        _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
        final String _tmpFotoUrl;
        _tmpFotoUrl = _cursor.getString(_cursorIndexOfFotoUrl);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final String _tmpEstado;
        _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        final int _tmpMax_Ingredientes;
        _tmpMax_Ingredientes = _cursor.getInt(_cursorIndexOfMaxIngredientes);
        _item = new Comida(_tmpId,_tmpNombre,_tmpDescripcion,_tmpPrecio,_tmpFotoUrl,_tmpCategoria,_tmpEstado,_tmpMax_Ingredientes);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Comida> ObtenerComidasOrdenadasPorCategoriaAsc() {
    final String _sql = "SELECT * FROM Comidas ORDER BY categoria ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
      final int _cursorIndexOfFotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoUrl");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "categoria");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final int _cursorIndexOfMaxIngredientes = CursorUtil.getColumnIndexOrThrow(_cursor, "Max_Ingredientes");
      final List<Comida> _result = new ArrayList<Comida>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Comida _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final double _tmpPrecio;
        _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
        final String _tmpFotoUrl;
        _tmpFotoUrl = _cursor.getString(_cursorIndexOfFotoUrl);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final String _tmpEstado;
        _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        final int _tmpMax_Ingredientes;
        _tmpMax_Ingredientes = _cursor.getInt(_cursorIndexOfMaxIngredientes);
        _item = new Comida(_tmpId,_tmpNombre,_tmpDescripcion,_tmpPrecio,_tmpFotoUrl,_tmpCategoria,_tmpEstado,_tmpMax_Ingredientes);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Comida> ObtenerComidasOrdenadasPorEstadoAsc() {
    final String _sql = "SELECT * FROM Comidas ORDER BY estado ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
      final int _cursorIndexOfFotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoUrl");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "categoria");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final int _cursorIndexOfMaxIngredientes = CursorUtil.getColumnIndexOrThrow(_cursor, "Max_Ingredientes");
      final List<Comida> _result = new ArrayList<Comida>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Comida _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final double _tmpPrecio;
        _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
        final String _tmpFotoUrl;
        _tmpFotoUrl = _cursor.getString(_cursorIndexOfFotoUrl);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final String _tmpEstado;
        _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        final int _tmpMax_Ingredientes;
        _tmpMax_Ingredientes = _cursor.getInt(_cursorIndexOfMaxIngredientes);
        _item = new Comida(_tmpId,_tmpNombre,_tmpDescripcion,_tmpPrecio,_tmpFotoUrl,_tmpCategoria,_tmpEstado,_tmpMax_Ingredientes);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Comida> ObtenerComidasOrdenadasPorNombreAsc() {
    final String _sql = "SELECT * FROM Comidas ORDER BY nombre ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
      final int _cursorIndexOfFotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "fotoUrl");
      final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "categoria");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final int _cursorIndexOfMaxIngredientes = CursorUtil.getColumnIndexOrThrow(_cursor, "Max_Ingredientes");
      final List<Comida> _result = new ArrayList<Comida>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Comida _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        final double _tmpPrecio;
        _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
        final String _tmpFotoUrl;
        _tmpFotoUrl = _cursor.getString(_cursorIndexOfFotoUrl);
        final int _tmpCategoria;
        _tmpCategoria = _cursor.getInt(_cursorIndexOfCategoria);
        final String _tmpEstado;
        _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        final int _tmpMax_Ingredientes;
        _tmpMax_Ingredientes = _cursor.getInt(_cursorIndexOfMaxIngredientes);
        _item = new Comida(_tmpId,_tmpNombre,_tmpDescripcion,_tmpPrecio,_tmpFotoUrl,_tmpCategoria,_tmpEstado,_tmpMax_Ingredientes);
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
