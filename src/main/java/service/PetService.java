package service;

import DAO.PetDAO;
import entity.Pet;

import java.util.List;

public interface PetService  {
    public List<Pet> list();
}
