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
import com.example.im_delice.core.entities.Categoria;
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
public final class CategoriaDao_Impl implements CategoriaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Categoria> __insertionAdapterOfCategoria;

  private final EntityDeletionOrUpdateAdapter<Categoria> __deletionAdapterOfCategoria;

  private final EntityDeletionOrUpdateAdapter<Categoria> __updateAdapterOfCategoria;

  public CategoriaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCategoria = new EntityInsertionAdapter<Categoria>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Categorias` (`id`,`nombre`,`foto`,`descripcion`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Categoria entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        statement.bindString(3, entity.getFoto());
        statement.bindString(4, entity.getDescripcion());
      }
    };
    this.__deletionAdapterOfCategoria = new EntityDeletionOrUpdateAdapter<Categoria>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Categorias` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Categoria entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCategoria = new EntityDeletionOrUpdateAdapter<Categoria>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Categorias` SET `id` = ?,`nombre` = ?,`foto` = ?,`descripcion` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Categoria entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        statement.bindString(3, entity.getFoto());
        statement.bindString(4, entity.getDescripcion());
        statement.bindLong(5, entity.getId());
      }
    };
  }

  @Override
  public long insertarCategoria(final Categoria obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfCategoria.insertAndReturnId(obj);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int eliminarCategoria(final Categoria obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __deletionAdapterOfCategoria.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int ActualizarCategoria(final Categoria obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __updateAdapterOfCategoria.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Categoria> obtenerCategoria() {
    final String _sql = "SELECT * FROM Categorias";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final List<Categoria> _result = new ArrayList<Categoria>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Categoria _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        final String _tmpDescripcion;
        _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        _item = new Categoria(_tmpId,_tmpNombre,_tmpFoto,_tmpDescripcion);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Categoria> BuscarPorNombre(final String nombre) {
    final String _sql = "SELECT * FROM Categorias WHERE nombre = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, nombre);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final List<Categoria> _result = new ArrayList<Categoria>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Categoria _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        final String _tmpDescripcion;
        _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        _item = new Categoria(_tmpId,_tmpNombre,_tmpFoto,_tmpDescripcion);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Categoria ObtenerCategoriaPorId(final int id) {
    final String _sql = "SELECT * FROM Categorias WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final Categoria _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        final String _tmpDescripcion;
        _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        _result = new Categoria(_tmpId,_tmpNombre,_tmpFoto,_tmpDescripcion);
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
  public int verificarCategoria(final String nombre) {
    final String _sql = "SELECT COUNT(*) FROM Categorias WHERE nombre = ?";
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
