package com.database.person;

import com.database.dao.RowDao;
import com.database.entity.Row;

import java.util.List;

public class PersonRequest implements Runnable{
    @Override
    public void run() {
        RowDao rowDao = RowDao.getInstance();
        List<Row> rows = rowDao.findAll();
//        System.out.println(rows);
    }
}
