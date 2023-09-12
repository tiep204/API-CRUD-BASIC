package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.request.ZipCodeRequest;
import ra.model.dto.response.ZipCodeResponse;
import ra.service.IZipCodeService;

import java.util.List;

@RestController
@RequestMapping("/zipCode")
public class ZipCodeController {
    @Autowired
    private IZipCodeService zipCodeService;

    @GetMapping
    public ResponseEntity<List<ZipCodeResponse>> findAll() {
        List<ZipCodeResponse> zipCodeResponseList = zipCodeService.findAll();
        return new ResponseEntity<>(zipCodeResponseList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ZipCodeResponse> add(@RequestBody ZipCodeRequest zipCodeRequest) {
        ZipCodeResponse zipCodeResponse = zipCodeService.save(zipCodeRequest);
        return new ResponseEntity<>(zipCodeResponse, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ZipCodeResponse> findById(@PathVariable Long id){
        ZipCodeResponse zipCodeResponse = zipCodeService.findById(id);
        return new ResponseEntity<>(zipCodeResponse,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZipCodeResponse> update(@RequestBody ZipCodeRequest zipCodeRequest, @PathVariable Long id) {
        ZipCodeResponse zipCodeResponse = zipCodeService.update(zipCodeRequest, id);
        return new ResponseEntity<>(zipCodeResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ZipCodeResponse> delete(@PathVariable Long id){
        ZipCodeResponse zipCodeResponse = zipCodeService.delete(id);
        return new ResponseEntity<>(zipCodeResponse,HttpStatus.OK);
    }
}