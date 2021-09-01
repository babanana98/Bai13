package DAO;

import entity.Employees;
import entity.ExperienceEmployee;
import entity.FresherEmployee;
import entity.InternEmployee;

import java.util.List;

public interface DAOHandler {
    public void insert(Employees e);
    public Employees findById(int id);
    public boolean isExistById(int id);
    public List<InternEmployee> findAllIntern();
    public List<FresherEmployee> findAllFresher();
    public List<ExperienceEmployee> findAllExperience();
    public void update(Employees e);
    public void delete(int id);
}
