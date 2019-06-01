package com.example.RestWithMapAndSet;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DeptController {

    public static Set<Department> set=new HashSet<Department>();
    public static Map<Long, Department>  map=new HashMap<Long, Department>();

    static{
        set.add(new Department(1L,"java","10"));
        set.add(new Department(1L,"php","10"));
        map.put(101L,new Department(101L,"html","10"));
        map.put(102L,new Department(102L,"css","10"));
    }

    @RequestMapping(value = "/set",method = RequestMethod.GET)
    public Set<Department> getAllSet(){
        return set;
    }

    @RequestMapping(value = "/map",method = RequestMethod.GET)
    public Map<Long,Department> getAllMap(){
        return map;
    }

    @RequestMapping(value = "/map2",method = RequestMethod.GET)
    public Collection<Department> getAll(){
        return map.values();
    }

    @RequestMapping(value = "map/{id}", method = RequestMethod.GET)
    public Department getId(@PathVariable long id){
        return map.get(id);
    }

    @RequestMapping(value = "/map",method = RequestMethod.POST)
    public void add(@RequestBody Department department){
        map.put(department.id, department);
    }

    @RequestMapping(value = "map/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable long id, @RequestBody Department department){
        if(department != null && map.containsKey(id)){
            map.put(id,department);
        }
    }

    @RequestMapping(value = "map/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        if(id != 0 && map.containsKey(id)){
            map.remove(id);
        }
    }

}
