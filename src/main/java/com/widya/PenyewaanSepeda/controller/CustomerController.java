package com.widya.PenyewaanSepeda.controller;
import com.widya.PenyewaanSepeda.dto.pelanggan.UpsertCustomer;
import com.widya.PenyewaanSepeda.service.abstraction.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/index")
    public ResponseEntity<Object> getgrid(@RequestParam(defaultValue = "")Long id,
                                          @RequestParam(defaultValue = "1")Integer page){
        try {
            var customer =customerService.getAllGrid(page,id );
            return  ResponseEntity.status(HttpStatus.OK).body(customer);
        }catch (Exception exception){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PostMapping("/newCustomer")
    public ResponseEntity<Object> post(@RequestBody UpsertCustomer dto, BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Validation Failed, Http Request Body is not validated.");
            }else{
                dto.setCustomerID(0l);
                Long respondId = customerService.save(dto);
                dto.setCustomerID(respondId);
                return ResponseEntity.status(HttpStatus.CREATED).body(dto);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");
        }
    }

    @PutMapping("/editCustomer")
     public ResponseEntity<Object> update (@RequestBody UpsertCustomer dto ,BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Validation Failed, Http Request Body is not validated.");
            }else{
                customerService.save(dto);
                return ResponseEntity.status(HttpStatus.OK).body(dto);
            }
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");

        }
    }

    @DeleteMapping("/{customerId}")
    public  ResponseEntity<Object> delete (@PathVariable Long  customerId){
        var deleteSepeda = customerService.delete(customerId);
        var totalDependent = customerService.dependentdenganPeminjaman(customerId);
        if(deleteSepeda){
            return ResponseEntity.status(HttpStatus.OK).body(customerService.delete(customerId));
        }
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Customer tidak Bisa dihapus karna sudah memiliki %d history peminjaman",totalDependent));
    }


}
