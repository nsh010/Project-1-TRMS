package dao;

import beans.TRF;

public interface TRFDao {
    public TRF getByID(int id);

    public void newForm(TRF trf);

    public void update(TRF trf);

    public void delete(TRF trf);
}
