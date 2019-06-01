package com.example.AllRestEndpointWithArrayList;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Students {

    public long id;
    public String name;
    public String age;


    public void setId(long id) {
        this.id=id;
    }
}
