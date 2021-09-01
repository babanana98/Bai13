package DAO;

import entity.Employees;
import entity.ExperienceEmployee;
import entity.FresherEmployee;
import entity.InternEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDAO implements DAOHandler{
    private final List<Employees> list=new ArrayList<>();

    @Override
    public void insert(Employees e) {
        int id=Employees.count+1;
        e.setId(id);
        list.add(e);
    }

    @Override
    public Employees findById(int id) {
        return list.stream().filter((t)->t.getId()==id).findAny().orElse(null);
    }

    @Override
    public List<InternEmployee> findAllIntern() {
        return list.stream()
                .filter((t)->t instanceof InternEmployee)
                .map((t)->(InternEmployee)t)
                .collect(Collectors.toList());
    }

    @Override
    public List<FresherEmployee> findAllFresher() {
        return list.stream()
                .filter((t)->t instanceof FresherEmployee)
                .map((t)->(FresherEmployee)t)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExperienceEmployee> findAllExperience() {
        return list.stream()
                .filter((t)->t instanceof ExperienceEmployee)
                .map((t)->(ExperienceEmployee)t)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Employees e) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==e.getId()){
                list.set(i, e);
            }
        }
    }

    @Override
    public void delete(int id) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                list.remove(i);
            }
        }
    }

    @Override
    public boolean isExistById(int id) {
        return list.stream().filter((t)->t.getId()==id).findAny().isPresent();
    }
}
