package com.example.AllRestEndpointWithArrayList;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    public static List<Students> lst=new ArrayList<Students>(Arrays.asList(
            new Students(11L,"java","12"),new Students(22L,"php","13"),
            new Students(34L,"dot","14")
    ));
    public static int studentCount = 3;

    /*@PostConstruct
    public void init(){
        lst.add(new Students(11L,"java","12"));
        lst.add(new Students(22L,"php","13"));
        lst.add(new Students(34L,"dot","14"));
    }*/

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Students> getAll(){
        return lst;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Students getId(@PathVariable long id){
        //return lst.get((int)id);
        Students newStudent = null;
        for (Students s : lst) {
            if (s.id == id) {
                newStudent = s;
            }
        }
        return newStudent;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public void add(@RequestBody Students student){
        if (null != student && 0 == student.id) {
            student.setId(++studentCount);
        }
        lst.add(student);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable long id,@RequestBody Students students){
        Students newStudent=null;
        for (int i=0;i<lst.size();i++){
            newStudent =lst.get(i);
            if(newStudent.id==id){
                lst.set(i,students);
                return;
            }
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        //lst.remove(id);
        Iterator<Students> iterator = lst.iterator();
        while (iterator.hasNext()) {
            lst.removeIf(s ->s.id == iterator.next().id);
           //if (iterator.next().id == id) {iterator.remove();}
        }
    }
}
