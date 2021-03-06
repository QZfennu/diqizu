package com.example.day3_zuoye.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.day3_zuoye.bean.DataDTO;

import com.example.day3_zuoye.db.DataDTODao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dataDTODaoConfig;

    private final DataDTODao dataDTODao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dataDTODaoConfig = daoConfigMap.get(DataDTODao.class).clone();
        dataDTODaoConfig.initIdentityScope(type);

        dataDTODao = new DataDTODao(dataDTODaoConfig, this);

        registerDao(DataDTO.class, dataDTODao);
    }
    
    public void clear() {
        dataDTODaoConfig.clearIdentityScope();
    }

    public DataDTODao getDataDTODao() {
        return dataDTODao;
    }

}
