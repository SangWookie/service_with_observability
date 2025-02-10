package ssu.sdj.digital_receipt.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import ssu.sdj.digital_receipt.service.DataService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestControllerTest {

    @Autowired
    private RestController restController;

    @Autowired
    private DataService dataService;

    private String testInput = "u/PIozogu/O1tbW/wda5zrXpCrvnvvfA2rn4yKM6IDEyMy00NS02Nzg5MCAgVEVMOiAwMi04MjAtMDExNAq068elwNo6IMDMwfa5zgrB1rzSOiC8rb/vxq 6sL3DILW/wNuxuCC787W1t84gMzY5Ci0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLQq788ewuO0gICAgICAgICAgILTcsKEgICAgICC89reuICAgICAgsd2 1yAKLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tCrX seIgICAgICAgICAgICAgNCwwMDC/ CAgICAxsLMgICAgNCwwMDC/ AotLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0KsPq8vLmwx7A6ICAgICAgICAgICAgICAgICAgICAgICAgICAzLDYzNr/4CrrOILChILy8OiAgICAgICAgICAgICAgICAgICAgICAgICAgICAzNjS/ ArD0SDH1SCw6DogICAgICAgICAgICAgICAgICAgICAgICAgIDQsMDAwv/gKLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tCsD8wNq8rbjtwPzHpQotLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0Kw6O xsHWvMW8rSCwqLvnx9W0z7TZLiAosO2wtL/rKQoKCgoKCgodVgE=";

    @Test
    @DisplayName("upload test")
    void upload() throws Exception {

        String returnVal = restController.upload(testInput).getBody();
        System.out.println(returnVal);

        String[] out = returnVal.split(",");
        String id = out[0];
        String hash = out[1];
        String data = dataService.getData(id, hash);

        System.out.println(data);
    }

}