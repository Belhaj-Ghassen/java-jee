package tn.enig.dao;

import tn.enig.model.hotel;

import java.util.List;

import tn.enig.model.Chambre;

public interface IGestionDao {
public hotel gethotelById(int idh);
public List<hotel> GetAllhotel();
public List<Chambre> GetChByhotel(hotel h);
public void add(Chambre ch);


}
