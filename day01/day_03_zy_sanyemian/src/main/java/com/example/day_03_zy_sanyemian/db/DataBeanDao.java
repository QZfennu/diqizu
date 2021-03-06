package com.example.day_03_zy_sanyemian.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.day_03_zy_sanyemian.model.bean.DataBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DATA_BEAN".
*/
public class DataBeanDao extends AbstractDao<DataBean, Long> {

    public static final String TABLENAME = "DATA_BEAN";

    /**
     * Properties of entity DataBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Icon = new Property(1, String.class, "icon", false, "ICON");
        public final static Property Background = new Property(2, String.class, "background", false, "BACKGROUND");
        public final static Property ActivityIcon = new Property(3, String.class, "activityIcon", false, "ACTIVITY_ICON");
        public final static Property Title = new Property(4, String.class, "title", false, "TITLE");
        public final static Property Intro = new Property(5, String.class, "intro", false, "INTRO");
        public final static Property FeedNum = new Property(6, int.class, "feedNum", false, "FEED_NUM");
        public final static Property TagId = new Property(7, int.class, "tagId", false, "TAG_ID");
        public final static Property EnterNum = new Property(8, int.class, "enterNum", false, "ENTER_NUM");
        public final static Property FollowNum = new Property(9, int.class, "followNum", false, "FOLLOW_NUM");
        public final static Property HasFollow = new Property(10, boolean.class, "hasFollow", false, "HAS_FOLLOW");
    }


    public DataBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DataBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DATA_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ICON\" TEXT," + // 1: icon
                "\"BACKGROUND\" TEXT," + // 2: background
                "\"ACTIVITY_ICON\" TEXT," + // 3: activityIcon
                "\"TITLE\" TEXT," + // 4: title
                "\"INTRO\" TEXT," + // 5: intro
                "\"FEED_NUM\" INTEGER NOT NULL ," + // 6: feedNum
                "\"TAG_ID\" INTEGER NOT NULL ," + // 7: tagId
                "\"ENTER_NUM\" INTEGER NOT NULL ," + // 8: enterNum
                "\"FOLLOW_NUM\" INTEGER NOT NULL ," + // 9: followNum
                "\"HAS_FOLLOW\" INTEGER NOT NULL );"); // 10: hasFollow
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DATA_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DataBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(2, icon);
        }
 
        String background = entity.getBackground();
        if (background != null) {
            stmt.bindString(3, background);
        }
 
        String activityIcon = entity.getActivityIcon();
        if (activityIcon != null) {
            stmt.bindString(4, activityIcon);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(5, title);
        }
 
        String intro = entity.getIntro();
        if (intro != null) {
            stmt.bindString(6, intro);
        }
        stmt.bindLong(7, entity.getFeedNum());
        stmt.bindLong(8, entity.getTagId());
        stmt.bindLong(9, entity.getEnterNum());
        stmt.bindLong(10, entity.getFollowNum());
        stmt.bindLong(11, entity.getHasFollow() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DataBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(2, icon);
        }
 
        String background = entity.getBackground();
        if (background != null) {
            stmt.bindString(3, background);
        }
 
        String activityIcon = entity.getActivityIcon();
        if (activityIcon != null) {
            stmt.bindString(4, activityIcon);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(5, title);
        }
 
        String intro = entity.getIntro();
        if (intro != null) {
            stmt.bindString(6, intro);
        }
        stmt.bindLong(7, entity.getFeedNum());
        stmt.bindLong(8, entity.getTagId());
        stmt.bindLong(9, entity.getEnterNum());
        stmt.bindLong(10, entity.getFollowNum());
        stmt.bindLong(11, entity.getHasFollow() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DataBean readEntity(Cursor cursor, int offset) {
        DataBean entity = new DataBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // icon
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // background
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // activityIcon
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // title
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // intro
            cursor.getInt(offset + 6), // feedNum
            cursor.getInt(offset + 7), // tagId
            cursor.getInt(offset + 8), // enterNum
            cursor.getInt(offset + 9), // followNum
            cursor.getShort(offset + 10) != 0 // hasFollow
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DataBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIcon(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBackground(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setActivityIcon(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTitle(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIntro(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFeedNum(cursor.getInt(offset + 6));
        entity.setTagId(cursor.getInt(offset + 7));
        entity.setEnterNum(cursor.getInt(offset + 8));
        entity.setFollowNum(cursor.getInt(offset + 9));
        entity.setHasFollow(cursor.getShort(offset + 10) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DataBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DataBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DataBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
