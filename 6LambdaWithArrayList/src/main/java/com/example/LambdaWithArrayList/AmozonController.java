package com.example.LambdaWithArrayList;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/amozon")
public class AmozonController {

    public List<Amozon> lst = Collections.singletonList(
      new Amozon(101L,"laptop",2312.00)
    );

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Amozon> getAllProduct(){
        return lst.stream().map(a->{
            return new Amozon(a.id,a.productName,a.productAmount);
        }).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Amozon getId(@PathVariable long id){
        //return lst.stream().filter(a->a.id==id).findFirst().get();
        return lst.stream().filter(a->a.id==id).findFirst()
                .map(a->{return a;}).orElseGet(()->{
                   return new Amozon(102,"",1000.00);
                });
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public void add(@RequestBody Amozon amozon){
        lst.stream().filter(a->a.id==amozon.id).findFirst()
                .ifPresent(a->{
                    System.out.println(a.toString());
                });
        lst.add(amozon);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Boolean update(@PathVariable long id, @RequestBody Amozon amozon){
        return lst.stream().filter(a->a.id==id).findFirst()
                .map(a -> {
                    a.setProductName(amozon.productName);
                    a.setProductAmount(amozon.productAmount);
                    return lst.add(a);
                })
                .orElseGet(() -> {
                    amozon.id=id;
                    return lst.add(amozon);
                });
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        lst.removeIf(a->a.id==id);
    }
}
