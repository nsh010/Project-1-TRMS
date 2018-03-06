package services;

import beans.TRF;
import dao.TRFDao;
import dao.TRFDaoJdbcPg;

public class TRFService {

    private static TRFDao trfDao = new TRFDaoJdbcPg();

    public TRF getByID(int id){
        return trfDao.getByID(id);
    }

    public void newForm(TRF trf){
        trfDao.newForm(trf);
    }

    public void update(TRF trf){
        trfDao.update(trf);
    }

    public void delete(TRF trf){
        trfDao.delete(trf);
    }
}
