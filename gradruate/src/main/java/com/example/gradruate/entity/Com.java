package com.example.gradruate.entity;

import lombok.Data;

@Data
public class Com {
    int szm;
    String szmo;

    public Com(int szm, String szmo) {
        this.szm = szm;
        this.szmo = szmo;
    }

    public Com() {
    }
}
