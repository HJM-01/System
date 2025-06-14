package service;

import DAO.PetDAO;
import entity.Pet;

public class PetService {
    public int insertPet(Pet pet) {
        PetDAO dao = new PetDAO();
        return dao.insertPet(pet);
    }
}
