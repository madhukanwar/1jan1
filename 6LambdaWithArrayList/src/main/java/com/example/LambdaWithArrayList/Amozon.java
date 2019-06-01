package com.example.LambdaWithArrayList;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Amozon {

    public long id;
    public String productName;
    public double productAmount;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductAmount(double productAmount) {
        this.productAmount = productAmount;
    }
}
