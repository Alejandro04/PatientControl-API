package com.example.demo.controllers;

import com.example.demo.persistence.entities.Patient;
import com.example.demo.services.PatientService;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
public class PeopleController {

    String url = "https://jsonplaceholder.typicode.com/users";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    PatientService patientService;

    @GetMapping("/get-and-save-people-like-patient")
    public void getPeople(){
        ResponseEntity<String> response = restTemplate.getForEntity(this.url, String.class);
        JSONArray jsonArray = new JSONArray(response.getBody());
        patientMapper(jsonArray);
    }

    public void patientMapper (JSONArray jsonArray){
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            String phone = jsonObject.getString("phone");

            String firstName = "";
            String lastName = "";

            String[] nameParts = name.split(" ");
            if (nameParts.length > 0) {
                firstName = nameParts[0];
            }
            if (nameParts.length > 1) {
                lastName = nameParts[1];
            }

            Patient patient = new Patient("John Doe");
            patient.setFirst_name(firstName);
            patient.setLast_name(lastName);
            patient.setPhone(phone);
            patient.setAge(randomDataGenerator.nextInt(0, 100));

            patientService.createPatient(patient);
        }
    }
}
