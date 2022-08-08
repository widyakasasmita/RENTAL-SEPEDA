package com.widya.PenyewaanSepeda.controller;

import com.widya.PenyewaanSepeda.dto.peminjaman.UpsertPeminjamanDto;
import com.widya.PenyewaanSepeda.service.abstraction.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peminjaman")
public class PeminjamanController {
    @Autowired
    private PeminjamanService peminjamanService;

    @GetMapping
    public ResponseEntity<Object> getGrid(@RequestParam (defaultValue = "")Long id,
                                          @RequestParam(defaultValue = "1")Integer page){
        try{
            var peminjaman = peminjamanService.getAllGrid(page, id);
            return ResponseEntity.status(HttpStatus.OK).body(peminjaman);
        }catch(Exception e){
          return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public  ResponseEntity<Object> post(@RequestBody UpsertPeminjamanDto dto, BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Validation Failed, Http Request Body is not validated.");
            }else{
                dto.setIDpeminjaman(0l);
                Long responId = peminjamanService.save(dto);
                dto.setIDpeminjaman(responId);
                return ResponseEntity.status(HttpStatus.CREATED).body(dto);
            }
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");
        }
    }

    @PutMapping
    public ResponseEntity<Object> put (@RequestBody UpsertPeminjamanDto dto,BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Validation Failed, Http Request Body is not validated.");
            }else{
                peminjamanService.save(dto);
                return ResponseEntity.status(HttpStatus.OK).body(dto);
            }
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");
        }
    }
}
