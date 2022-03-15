package com.zallpy.userapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamsCSV  {

    private long id;
    private double examCost;
    private String examName;
    private String user;


}
