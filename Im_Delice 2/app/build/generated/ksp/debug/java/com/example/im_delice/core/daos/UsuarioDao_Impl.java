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
import com.example.im_delice.core.entities.Usuario;
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
public final class UsuarioDao_Impl implements UsuarioDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Usuario> __insertionAdapterOfUsuario;

  private final EntityDeletionOrUpdateAdapter<Usuario> __deletionAdapterOfUsuario;

  private final EntityDeletionOrUpdateAdapter<Usuario> __updateAdapterOfUsuario;

  public UsuarioDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUsuario = new EntityInsertionAdapter<Usuario>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Usuarios` (`id`,`nombre`,`email`,`contraseña`,`rol`,`foto`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Usuario entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        statement.bindString(3, entity.getEmail());
        statement.bindString(4, entity.getContraseña());
        statement.bindString(5, entity.getRol());
        statement.bindString(6, entity.getFoto());
      }
    };
    this.__deletionAdapterOfUsuario = new EntityDeletionOrUpdateAdapter<Usuario>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Usuarios` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Usuario entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfUsuario = new EntityDeletionOrUpdateAdapter<Usuario>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Usuarios` SET `id` = ?,`nombre` = ?,`email` = ?,`contraseña` = ?,`rol` = ?,`foto` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Usuario entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getNombre());
        statement.bindString(3, entity.getEmail());
        statement.bindString(4, entity.getContraseña());
        statement.bindString(5, entity.getRol());
        statement.bindString(6, entity.getFoto());
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public long InsertarUsuario(final Usuario obj) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfUsuario.insertAndReturnId(obj);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int EliminarUsuario(final Usuario obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __deletionAdapterOfUsuario.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int ActualizarUsuario(final Usuario obj) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total += __updateAdapterOfUsuario.handle(obj);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int verificarEmail(final String email) {
    final String _sql = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, email);
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
  public List<Usuario> ObtenerTodosUsuarios() {
    final String _sql = "SELECT * FROM Usuarios";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfContraseA = CursorUtil.getColumnIndexOrThrow(_cursor, "contraseña");
      final int _cursorIndexOfRol = CursorUtil.getColumnIndexOrThrow(_cursor, "rol");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final List<Usuario> _result = new ArrayList<Usuario>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Usuario _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpContraseña;
        _tmpContraseña = _cursor.getString(_cursorIndexOfContraseA);
        final String _tmpRol;
        _tmpRol = _cursor.getString(_cursorIndexOfRol);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _item = new Usuario(_tmpId,_tmpNombre,_tmpEmail,_tmpContraseña,_tmpRol,_tmpFoto);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Usuario ObtenerUsuarioPorEmail(final String email) {
    final String _sql = "SELECT * FROM Usuarios WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, email);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfContraseA = CursorUtil.getColumnIndexOrThrow(_cursor, "contraseña");
      final int _cursorIndexOfRol = CursorUtil.getColumnIndexOrThrow(_cursor, "rol");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final Usuario _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpContraseña;
        _tmpContraseña = _cursor.getString(_cursorIndexOfContraseA);
        final String _tmpRol;
        _tmpRol = _cursor.getString(_cursorIndexOfRol);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _result = new Usuario(_tmpId,_tmpNombre,_tmpEmail,_tmpContraseña,_tmpRol,_tmpFoto);
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
  public Usuario ObtenerUsuarioPorId(final int id) {
    final String _sql = "SELECT * FROM Usuarios WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfContraseA = CursorUtil.getColumnIndexOrThrow(_cursor, "contraseña");
      final int _cursorIndexOfRol = CursorUtil.getColumnIndexOrThrow(_cursor, "rol");
      final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
      final Usuario _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpNombre;
        _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpContraseña;
        _tmpContraseña = _cursor.getString(_cursorIndexOfContraseA);
        final String _tmpRol;
        _tmpRol = _cursor.getString(_cursorIndexOfRol);
        final String _tmpFoto;
        _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
        _result = new Usuario(_tmpId,_tmpNombre,_tmpEmail,_tmpContraseña,_tmpRol,_tmpFoto);
      } else {
        _result = null;
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
