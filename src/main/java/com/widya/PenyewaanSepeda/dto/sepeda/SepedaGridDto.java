package com.widya.PenyewaanSepeda.dto.sepeda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SepedaGridDto {

    private String sepedaID;
    private String jenisSepeda;
    private String merekSepeda;
    private String warnaSepeda;
    private Long biayaperJam;
    private String status;

}
