package com.ibw.skylab.loyaltybackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    private Date createdDate;

    private Date updatedDate;

    private Date deletedDate;

    private boolean deleted;


}
