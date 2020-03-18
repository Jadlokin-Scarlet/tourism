package com.tourism.entity.DaoDto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class TicketMore {
    private Integer id;

    private Integer ticketId;

    private Date useTime;

    private Integer price;

    private Integer balance;

}