package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.request.CityRequest;
import ra.model.dto.response.CityResponse;
import ra.service.ICityService;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<List<CityResponse>> findAll() {
        List<CityResponse> cityResponseList = cityService.findAll();
        return new ResponseEntity<>(cityResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> findById(@PathVariable Long id) {
        CityResponse cityResponse = cityService.findById(id);
        return new ResponseEntity<>(cityResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CityResponse> create(@RequestBody CityRequest cityRequest) {
        CityResponse cityResponse = cityService.save(cityRequest);
        return new ResponseEntity<>(cityResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityResponse> update(@RequestBody CityRequest cityRequest, @PathVariable Long id) {
        CityResponse cityResponse = cityService.update(cityRequest, id);
        return new ResponseEntity<>(cityResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CityResponse> delete(@PathVariable Long id){
        CityResponse cityResponse = cityService.delete(id);
        return new ResponseEntity<>(cityResponse,HttpStatus.OK);
    }
}