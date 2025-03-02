package com.example.ems.configuration;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor

public class ObjectNotValidException extends RuntimeException{

    private  Set<String> errorMessages;



}
