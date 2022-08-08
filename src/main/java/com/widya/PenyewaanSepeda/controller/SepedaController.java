package com.widya.PenyewaanSepeda.controller;
import com.widya.PenyewaanSepeda.dto.sepeda.UpsertSepedaDto;
import com.widya.PenyewaanSepeda.service.abstraction.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("/api/sepeda")
public class SepedaController {

    @Autowired
    private BicycleService bicycleService;

    @GetMapping("/index")

    public ResponseEntity<Object> getGrid (@RequestParam(defaultValue = "")String sepedaId,
                                           @RequestParam(defaultValue = "1")Integer page){
        try{
            var sepeda = bicycleService.getAllGrid(page,sepedaId);
       return  ResponseEntity.status(HttpStatus.OK).body(sepeda);
        }catch (Exception exception){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody UpsertSepedaDto dto, BindingResult bindingResult){
       return ResponseEntity.status(HttpStatus.CREATED).body(bicycleService.save(dto));
    }

    @PutMapping("{sepedaId}")
    public ResponseEntity<Object> update (@PathVariable String sepedaId, @RequestBody UpsertSepedaDto dto ){
        return ResponseEntity.status(HttpStatus.CREATED).body(bicycleService.getUpdate(sepedaId,dto));
    }

    @DeleteMapping("{sepedaId}")
    public  ResponseEntity<Object> delete (@PathVariable String sepedaId ){
        var deleteSepeda = bicycleService.delete(sepedaId);
        var totalDependent = bicycleService.dependentdenganPeminjaman(sepedaId);
        if(deleteSepeda){
            return ResponseEntity.status(HttpStatus.OK).body(bicycleService.delete(sepedaId));
        }
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Sepeda tidak Bisa dihapus karna sudah memiliki %d history peminjaman",totalDependent));
    }

}
