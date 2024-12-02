package com.example.im_delice.core.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.im_delice.core.daos.CategoriaDao;
import com.example.im_delice.core.daos.CategoriaDao_Impl;
import com.example.im_delice.core.daos.ComidaDao;
import com.example.im_delice.core.daos.ComidaDao_Impl;
import com.example.im_delice.core.daos.IngredienteDao;
import com.example.im_delice.core.daos.IngredienteDao_Impl;
import com.example.im_delice.core.daos.UsuarioDao;
import com.example.im_delice.core.daos.UsuarioDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ImDeliceDataBase_Impl extends ImDeliceDataBase {
  private volatile UsuarioDao _usuarioDao;

  private volatile ComidaDao _comidaDao;

  private volatile CategoriaDao _categoriaDao;

  private volatile IngredienteDao _ingredienteDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `Usuarios` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `email` TEXT NOT NULL, `contraseña` TEXT NOT NULL, `rol` TEXT NOT NULL, `foto` TEXT NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Usuarios_email` ON `Usuarios` (`email`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Comidas` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `descripcion` TEXT, `precio` REAL NOT NULL, `fotoUrl` TEXT NOT NULL, `categoria` INTEGER NOT NULL, `estado` TEXT NOT NULL, `Max_Ingredientes` INTEGER NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Comidas_nombre` ON `Comidas` (`nombre`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Categorias` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `foto` TEXT NOT NULL, `descripcion` TEXT NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Categorias_nombre` ON `Categorias` (`nombre`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Ingredientes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `Categoria` INTEGER NOT NULL, `disponibilidad` INTEGER NOT NULL, `precioExtra` REAL NOT NULL, `foto` TEXT NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_Ingredientes_nombre` ON `Ingredientes` (`nombre`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f8a81e14e4134c78a078a946375d1220')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `Usuarios`");
        db.execSQL("DROP TABLE IF EXISTS `Comidas`");
        db.execSQL("DROP TABLE IF EXISTS `Categorias`");
        db.execSQL("DROP TABLE IF EXISTS `Ingredientes`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsuarios = new HashMap<String, TableInfo.Column>(6);
        _columnsUsuarios.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuarios.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuarios.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuarios.put("contraseña", new TableInfo.Column("contraseña", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuarios.put("rol", new TableInfo.Column("rol", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuarios.put("foto", new TableInfo.Column("foto", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsuarios = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsuarios = new HashSet<TableInfo.Index>(1);
        _indicesUsuarios.add(new TableInfo.Index("index_Usuarios_email", true, Arrays.asList("email"), Arrays.asList("ASC")));
        final TableInfo _infoUsuarios = new TableInfo("Usuarios", _columnsUsuarios, _foreignKeysUsuarios, _indicesUsuarios);
        final TableInfo _existingUsuarios = TableInfo.read(db, "Usuarios");
        if (!_infoUsuarios.equals(_existingUsuarios)) {
          return new RoomOpenHelper.ValidationResult(false, "Usuarios(com.example.im_delice.core.entities.Usuario).\n"
                  + " Expected:\n" + _infoUsuarios + "\n"
                  + " Found:\n" + _existingUsuarios);
        }
        final HashMap<String, TableInfo.Column> _columnsComidas = new HashMap<String, TableInfo.Column>(8);
        _columnsComidas.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComidas.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComidas.put("descripcion", new TableInfo.Column("descripcion", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComidas.put("precio", new TableInfo.Column("precio", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComidas.put("fotoUrl", new TableInfo.Column("fotoUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComidas.put("categoria", new TableInfo.Column("categoria", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComidas.put("estado", new TableInfo.Column("estado", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComidas.put("Max_Ingredientes", new TableInfo.Column("Max_Ingredientes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysComidas = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesComidas = new HashSet<TableInfo.Index>(1);
        _indicesComidas.add(new TableInfo.Index("index_Comidas_nombre", true, Arrays.asList("nombre"), Arrays.asList("ASC")));
        final TableInfo _infoComidas = new TableInfo("Comidas", _columnsComidas, _foreignKeysComidas, _indicesComidas);
        final TableInfo _existingComidas = TableInfo.read(db, "Comidas");
        if (!_infoComidas.equals(_existingComidas)) {
          return new RoomOpenHelper.ValidationResult(false, "Comidas(com.example.im_delice.core.entities.Comida).\n"
                  + " Expected:\n" + _infoComidas + "\n"
                  + " Found:\n" + _existingComidas);
        }
        final HashMap<String, TableInfo.Column> _columnsCategorias = new HashMap<String, TableInfo.Column>(4);
        _columnsCategorias.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategorias.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategorias.put("foto", new TableInfo.Column("foto", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategorias.put("descripcion", new TableInfo.Column("descripcion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategorias = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategorias = new HashSet<TableInfo.Index>(1);
        _indicesCategorias.add(new TableInfo.Index("index_Categorias_nombre", true, Arrays.asList("nombre"), Arrays.asList("ASC")));
        final TableInfo _infoCategorias = new TableInfo("Categorias", _columnsCategorias, _foreignKeysCategorias, _indicesCategorias);
        final TableInfo _existingCategorias = TableInfo.read(db, "Categorias");
        if (!_infoCategorias.equals(_existingCategorias)) {
          return new RoomOpenHelper.ValidationResult(false, "Categorias(com.example.im_delice.core.entities.Categoria).\n"
                  + " Expected:\n" + _infoCategorias + "\n"
                  + " Found:\n" + _existingCategorias);
        }
        final HashMap<String, TableInfo.Column> _columnsIngredientes = new HashMap<String, TableInfo.Column>(6);
        _columnsIngredientes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredientes.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredientes.put("Categoria", new TableInfo.Column("Categoria", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredientes.put("disponibilidad", new TableInfo.Column("disponibilidad", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredientes.put("precioExtra", new TableInfo.Column("precioExtra", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredientes.put("foto", new TableInfo.Column("foto", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIngredientes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIngredientes = new HashSet<TableInfo.Index>(1);
        _indicesIngredientes.add(new TableInfo.Index("index_Ingredientes_nombre", true, Arrays.asList("nombre"), Arrays.asList("ASC")));
        final TableInfo _infoIngredientes = new TableInfo("Ingredientes", _columnsIngredientes, _foreignKeysIngredientes, _indicesIngredientes);
        final TableInfo _existingIngredientes = TableInfo.read(db, "Ingredientes");
        if (!_infoIngredientes.equals(_existingIngredientes)) {
          return new RoomOpenHelper.ValidationResult(false, "Ingredientes(com.example.im_delice.core.entities.Ingrediente).\n"
                  + " Expected:\n" + _infoIngredientes + "\n"
                  + " Found:\n" + _existingIngredientes);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f8a81e14e4134c78a078a946375d1220", "6aa4e77b44bd4a8519bb3c6d865bd5bc");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Usuarios","Comidas","Categorias","Ingredientes");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Usuarios`");
      _db.execSQL("DELETE FROM `Comidas`");
      _db.execSQL("DELETE FROM `Categorias`");
      _db.execSQL("DELETE FROM `Ingredientes`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UsuarioDao.class, UsuarioDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ComidaDao.class, ComidaDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CategoriaDao.class, CategoriaDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IngredienteDao.class, IngredienteDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UsuarioDao usuarioDao() {
    if (_usuarioDao != null) {
      return _usuarioDao;
    } else {
      synchronized(this) {
        if(_usuarioDao == null) {
          _usuarioDao = new UsuarioDao_Impl(this);
        }
        return _usuarioDao;
      }
    }
  }

  @Override
  public ComidaDao ComidaDao() {
    if (_comidaDao != null) {
      return _comidaDao;
    } else {
      synchronized(this) {
        if(_comidaDao == null) {
          _comidaDao = new ComidaDao_Impl(this);
        }
        return _comidaDao;
      }
    }
  }

  @Override
  public CategoriaDao CategoriaDao() {
    if (_categoriaDao != null) {
      return _categoriaDao;
    } else {
      synchronized(this) {
        if(_categoriaDao == null) {
          _categoriaDao = new CategoriaDao_Impl(this);
        }
        return _categoriaDao;
      }
    }
  }

  @Override
  public IngredienteDao IngredienteDao() {
    if (_ingredienteDao != null) {
      return _ingredienteDao;
    } else {
      synchronized(this) {
        if(_ingredienteDao == null) {
          _ingredienteDao = new IngredienteDao_Impl(this);
        }
        return _ingredienteDao;
      }
    }
  }
}
