package ssu.sdj.digital_receipt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssu.sdj.digital_receipt.service.DataService;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final DataService dataService;

    public RestController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam(required = false) String data) {
        System.out.println("received data : ");
        System.out.println(data);
        return new ResponseEntity<>(dataService.saveData(data), HttpStatus.OK);
    }

    @GetMapping("/mobile")
    public ResponseEntity<String> mobile(@RequestParam String id, @RequestParam String hash) throws Exception {
        return new ResponseEntity<>(dataService.getData(id, hash), HttpStatus.OK) ;
    }
}
